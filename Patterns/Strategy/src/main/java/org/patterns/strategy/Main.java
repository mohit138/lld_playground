package org.patterns.strategy;

import org.patterns.strategy.behaviours.impl.FlyRocketPowered;

public class Main {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.display();
        duck.perforFly();
        duck.performQuack();

        Duck d2 = new ModelDuck();
        d2.display();
        d2.perforFly();
        d2.setFlyBehaviour(new FlyRocketPowered());
        d2.perforFly();
    }
}