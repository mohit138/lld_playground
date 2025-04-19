package org.grokking.amazonlocker;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

enum LockerBookingState{
    AVAILABLE,
    BOOKED
}

enum LockerDoorState{
    OPEN,
    CLOSED
}

enum PackageState{
    TO_DELIVER,
    TO_PICKUP,
    PICKED_UP,
    TO_RETURN,
    RETURNED,
    RETURN_PICKED_UP
}

enum Size{
    XS(1),
    S(2),
    M(3),
    L(4),
    XL(4),
    XXL(5);

    final int sizeVal;

    Size(int i) {
        sizeVal =i;
    }
}

class Customer{
    String id;
    ArrayList<Order> orders;
}
class Order{
    String id;
    ArrayList<Item>items;
    String deliveryLocation;
}
class Item{
    String id;
    String productCode;
}
class Package{
    String id;
    Order order;
    Size size;
    PackageState state;
    String code;
    LocalDateTime deliveryDate;

    Package(String id, String code, Size size){
        this.id = id;
        this.code = code;
        this.size = size;
    }

    void toPickup(){
        state = PackageState.TO_PICKUP;
        deliveryDate = LocalDateTime.now();
    }

    void dispatched(){
        state = PackageState.TO_DELIVER;
    }

    void pickedUp(){
        state = PackageState.PICKED_UP;
    }

    void toReturn(){
        state = PackageState.TO_RETURN;
    }

    void returned(){
        state = PackageState.RETURNED;
    }

    void returnPickedUp(){
        state = PackageState.RETURN_PICKED_UP;
    }

    @Override
    public String toString() {
        return "Package{" +
                "id='" + id + '\'' +
                ", order=" + order +
                ", sizeVal=" + size +
                ", state=" + state +
                ", code='" + code + '\'' +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}

class SizeNotAvailable extends Exception{
    SizeNotAvailable(String msg){
        super(msg);
    }
}

class LockerHub{

    String id;
    String location;
    HashMap<String, Locker> lockerForPackage;
    HashMap<String, Package> packages;
    HashMap<Size, ArrayList<Locker>> availableLockers;
    InteractiveScreen screen;
    Date openTime;
    Date closeTime;

    LockerHub(String location){
        this.location = location;
        availableLockers = new HashMap<>();
        for(Size sz: Size.values()){
            availableLockers.put(sz, new ArrayList<>());
        }
        lockerForPackage = new HashMap<>();
        packages = new HashMap<>();
    }

    Size nextAvailableSize(Package curPackage) throws SizeNotAvailable{
        Size nextAvlSize = null;
        boolean hasLocker=false;
        for(Size sz:Size.values()){
            if(sz.sizeVal >= curPackage.size.sizeVal){
                if(!availableLockers.get(sz).isEmpty()){
                    hasLocker = true;
                    nextAvlSize = sz;
                    break;
                }
            }
        }
        if(!hasLocker){
            throw new SizeNotAvailable("Size Not Available");
        }
        return nextAvlSize;
    }

    boolean hasLockerAvailable(Package curPackage){
        try{
            nextAvailableSize(curPackage);
        } catch (SizeNotAvailable e){
            return false;
        }
        return true;
    }



    void assignLocker(Package curPackage){
        Size nextAvlSize = null;
        try {
            nextAvlSize = nextAvailableSize(curPackage);
        } catch (SizeNotAvailable e) {
            System.out.println("Locker not available");
            return;
        }
        Locker lockerToUse = availableLockers.get(nextAvlSize).removeLast();
        lockerToUse.bookingState = LockerBookingState.BOOKED;
        lockerToUse.storedPackage = curPackage;
        lockerForPackage.put(curPackage.id, lockerToUse);
        packages.put(curPackage.id, curPackage);
    }

    void freeUpLocker(Package curPackage){
        Locker lockerToFreeUp = lockerForPackage.get(curPackage.id);
        lockerToFreeUp.bookingState = LockerBookingState.AVAILABLE;
        availableLockers.get(lockerToFreeUp.size).add(lockerToFreeUp);
        lockerForPackage.remove(curPackage.id);
    }
}

class InteractiveScreen{
    ArrayList<Integer> buttons;
    String screen;

    void enterCode(String code, Locker locker){}
}

class Locker{
    String id;
    LockerBookingState bookingState;
    LockerDoorState doorState;
    Size size;
    Package storedPackage;

    Locker(Size sz){
        size = sz;
    }

    void openLocker(){}
    void closeLocker(){}
}

class LockerSystem{
    HashMap<String, LockerHub> locationToHubMapping = new HashMap<>();

    void addLockerHub(String location, LockerHub hub){
        locationToHubMapping.put(location, hub);
    }

    boolean assignLocker(String location, Package curPackage, boolean isDelivery){
        LockerHub hub = locationToHubMapping.get(location);
        if(!hub.hasLockerAvailable(curPackage)){
            return false;
        }
        if(isDelivery){
            curPackage.dispatched();
        }else{
            curPackage.toReturn();
        }
        hub.assignLocker(curPackage);
        return true;
    }

    /**
     * This function can be used for complete Delivery as well as complete return
     * @param location
     * Location of Locker Hub
     * @param packageId
     * Package id to place in locker
     * @param lockerCode
     * Code to use to open locker
     * @param isDelivery
     * Weather it is delivery or return
     *
    * */
    boolean completePlacingInLocker(String location, String packageId, String lockerCode, boolean isDelivery){
        LockerHub hub = locationToHubMapping.get(location);

        Package curPackage = hub.packages.get(packageId);
        if(!hub.lockerForPackage.containsKey(curPackage.id)){
            // package not present !!
            return false;
        }
        Locker lockerToUse = hub.lockerForPackage.get(curPackage.id);
        if(lockerToUse.storedPackage.code.equals(lockerCode)){
            try{
                lockerToUse.openLocker();

                // once locker is closed,
                lockerToUse.closeLocker();

                if(isDelivery){
                    // Trigger notification w=using notification service, and send code to customer
                    hub.packages.get(packageId).toPickup();
                }else{
                    // Trigger notification to mark ready for return pickup
                    hub.packages.get(packageId).returned();
                }


            } catch (Exception e){
                // handle error
                return false;
            }
        }else{
            return false;
        }
        return true;
    }

    /**
     * This function can be used for complete Delivery as well as complete return
     * @param location
     * Location of Locker Hub
     * @param packageId
     * Package id to place in locker
     * @param lockerCode
     * Code to use to open locker
     * @param isDelivery
     * Weather it is delivery or return
     *
     * */
    boolean pickupOrderFromLocker(String location, String packageId, String lockerCode, boolean isDelivery){
        LockerHub hub = locationToHubMapping.get(location);

        Package curPackage = hub.packages.get(packageId);
        if(!hub.lockerForPackage.containsKey(curPackage.id)){
            // package not present !!
            return false;
        }
        Locker lockerToUse = hub.lockerForPackage.get(curPackage.id);
        LocalDateTime today = LocalDateTime.now();
        if(!(lockerToUse.storedPackage.state.equals(PackageState.TO_PICKUP) ||
                lockerToUse.storedPackage.state.equals(PackageState.RETURNED))){
            // user not allowed to pick up the package
            return false;
        }

        if(lockerToUse.storedPackage.code.equals(lockerCode)){
            try{
                lockerToUse.openLocker();

                // User picks up item.

                lockerToUse.closeLocker();

                //mark package as picked up, or return picked up
                if(isDelivery){
                    curPackage.pickedUp();
                }else{
                    curPackage.returnPickedUp();
                }

                // free up locker,
                hub.freeUpLocker(curPackage);

                // TRIGGER notification to user or delivery partner


            } catch (Exception e){
                // handle error
                return false;
            }
        }else{
            // incorrect code
            return false;
        }
        return true;
    }


}


public class Main {

    public static void main(String[] args) {

        LockerSystem system = new LockerSystem();
        LockerHub hub1 = new LockerHub("1");
        Locker loc1 = new Locker(Size.S);
        Locker loc2 = new Locker(Size.M);
        Locker loc3 = new Locker(Size.L);
        hub1.availableLockers.get(loc1.size).add(loc1);
        hub1.availableLockers.get(loc2.size).add(loc2);
        hub1.availableLockers.get(loc3.size).add(loc3);
        system.addLockerHub(hub1.location, hub1);

        Package pac1 = new Package("1","1234",Size.S);
        Package pac2 = new Package("2","12345",Size.M);
        Package pac3 = new Package("3","12346",Size.M);

        system.assignLocker(hub1.location, pac1, true);
        system.assignLocker(hub1.location, pac2, true);

        // assigning available bigger locker
        System.out.println(system.assignLocker(hub1.location, pac3, true)); // true

        System.out.println(system.locationToHubMapping.get(hub1.location).packages.get(pac1.id).toString()); // true
        system.completePlacingInLocker(hub1.location, pac1.id, pac1.code, true);
//        System.out.println(system.completePlacingInLocker(hub1.location, pac2.id, pac1.code, true)); // false
        System.out.println(system.locationToHubMapping.get(hub1.location).packages.get(pac1.id).toString()); // true
        system.pickupOrderFromLocker(hub1.location, pac1.id, pac1.code, true);
//        System.out.println(system.pickupOrderFromLocker(hub1.location, pac2.id, pac1.code, true)); // false
        System.out.println(system.locationToHubMapping.get(hub1.location).packages.get(pac1.id).toString()); // true

        System.out.println(" - - ");
        System.out.println(system.locationToHubMapping.get(hub1.location).hasLockerAvailable(pac1)); // true
        System.out.println(" - - ");

        system.assignLocker(hub1.location, pac1, false);
        System.out.println(system.locationToHubMapping.get(hub1.location).packages.get(pac1.id).toString()); // true
        system.completePlacingInLocker(hub1.location, pac1.id, pac1.code, false);
        System.out.println(system.locationToHubMapping.get(hub1.location).packages.get(pac1.id).toString()); // true
        system.pickupOrderFromLocker(hub1.location, pac1.id, pac1.code, false);
        System.out.println(system.locationToHubMapping.get(hub1.location).packages.get(pac1.id).toString()); // true


    }
}