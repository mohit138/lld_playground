package org.patterns.strategy.behaviours.impl;

import org.patterns.strategy.behaviours.FlyBehaviours;

public class FlyRocketPowered implements FlyBehaviours {

    @Override
    public void fly() {
        System.out.println("Flying with a Rocket");
    }
}
