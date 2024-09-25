package org.patterns.strategy.behaviours.impl;

import org.patterns.strategy.behaviours.FlyBehaviours;

public class FlyNoWay implements FlyBehaviours {

    @Override
    public void fly() {
    System.out.println("Can Not Fly.");
    }
}
