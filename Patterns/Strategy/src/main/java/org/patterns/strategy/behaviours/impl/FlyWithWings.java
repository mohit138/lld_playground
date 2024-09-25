package org.patterns.strategy.behaviours.impl;

import org.patterns.strategy.behaviours.FlyBehaviours;

public class FlyWithWings implements FlyBehaviours {

    public void fly() {
        System.out.println("Flying with Wings.");
    }
}
