package org.grokking.simplefactory;

import java.util.ArrayList;

/*
* This is a simple factory, it is not widely used in real world scenarios,
* Because =>
*   It violate Open close principle. We will have to modify factory to add a new pizza
*   Tight coupling between product and factory
*   No polymorphism, all creation is manual
*
* Hence, we move to Factory Method pattern.
* */

class Pizza{
    String name;
    String dough;
    String sauce;
    ArrayList<String> toppings = new ArrayList<>();

    void prepare(){
        System.out.println("Preparing "+name);
    }

    void bake(){
        System.out.println("Baking "+name);
    }
    void cut(){
        System.out.println("Cutting "+name);
    }

    void box(){
        System.out.println("Boxing "+name);
    }

    @Override
    public String toString() {
        StringBuffer display = new StringBuffer();
        display.append("name : "+name+"\n");
        display.append("dough : "+dough+"\n");
        display.append("sauce : "+sauce+"\n");
        display.append("toppings : \n");
        for(String topping:toppings){
            display.append(topping+"\n");
        }
        return display.toString();
    }
}

class CheesePizza extends Pizza{
    CheesePizza(){
        name = "Cheese Pizza";
        dough = "Regular Crust";
        sauce = "Marinara Pizza Sauce";
        toppings.add("Fresh Mozzarella");
        toppings.add("Parmesan");
    }
}

class PepperoniPizza extends Pizza{
    public PepperoniPizza() {
        name = "Pepperoni Pizza";
        dough = "Crust";
        sauce = "Marinara sauce";
        toppings.add("Sliced Pepperoni");
        toppings.add("Sliced Onion");
        toppings.add("Grated parmesan cheese");
    }
}

class SimplePizzaFactory{
    Pizza createPizza(String type){
        Pizza pizza = null;

        switch (type){
            case "cheese" :
                pizza = new CheesePizza();
                break;

            case "pepperoni" :
                pizza = new PepperoniPizza();
                break;
        }
        return pizza;
    }
}

class PizzaStore {
    SimplePizzaFactory factory = null;

    PizzaStore(SimplePizzaFactory factory){
        this.factory = factory;
    }

    Pizza orderPizza(String type){
        Pizza pizza = factory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}


public class Main {
    public static void main(String[] args) {
        SimplePizzaFactory simplePizzaFactory = new SimplePizzaFactory();
        PizzaStore store = new PizzaStore(simplePizzaFactory);

        Pizza pizza1 = store.orderPizza("cheese");

        System.out.println(pizza1.toString());
    }
}