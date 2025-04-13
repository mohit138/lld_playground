package org.grokking.amazonlocker;



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
    RETURNED
}

enum Size{
    XS,
    S,
    M,
    L,
    XL,
    XXL
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
}

class LockerHub{
    String id;
    HashMap<Package, Locker> occupiedLockers;
    HashMap<Size, ArrayList<Locker>> availableLockers;
    InteractiveScreen screen;
    Date openTime;
    Date closeTime;

    boolean hasLockerAvailable(Package curPackage){
        return !availableLockers.get(curPackage.size).isEmpty();
    }

    void assignLocker(Package curPackage){
        Locker lockerToUse = availableLockers.get(curPackage.size).removeLast();
        lockerToUse.bookingState = LockerBookingState.BOOKED;
        curPackage.state = PackageState.TO_DELIVER;
        occupiedLockers.put(curPackage, lockerToUse);
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

    void openLocker(){}
    void closeLocker(){}
}

class LockerSystem{
    HashMap<String, LockerHub> locationToHubMapping;

    void addLockerHub(String location, LockerHub hub){
        locationToHubMapping.put(location, hub);
    }

    boolean assignLocker(String location, Package curPackage){
        LockerHub hub = locationToHubMapping.get(location);
        if(!hub.hasLockerAvailable(curPackage)){
            return false;
        }

        hub.assignLocker(curPackage);
        return true;
    }


}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}