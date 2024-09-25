package org.patterns.strategy;

import org.patterns.strategy.behaviours.impl.FlyNoWay;
import org.patterns.strategy.behaviours.impl.Quack;

public class ModelDuck extends Duck{
    public ModelDuck(){
        flyBehaviour = new FlyNoWay();
        quackBehaviour = new Quack();
    }

    @Override
    public void display() {
        System.out.println("This is a Model Duck.");
    }
}
