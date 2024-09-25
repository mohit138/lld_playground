package org.patterns.strategy;

import org.patterns.strategy.behaviours.impl.FlyWithWings;
import org.patterns.strategy.behaviours.impl.Quack;

public class MallardDuck extends Duck{

    public MallardDuck(){
        flyBehaviour = new FlyWithWings();
        quackBehaviour = new Quack();
    }

    @Override
    public void display() {
        System.out.println("This is a Mallard Duck");
    }
}
