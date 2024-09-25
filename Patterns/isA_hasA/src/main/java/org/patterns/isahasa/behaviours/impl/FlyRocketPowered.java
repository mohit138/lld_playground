package org.patterns.isahasa.behaviours.impl;

import org.patterns.isahasa.behaviours.FlyBehaviours;

public class FlyRocketPowered implements FlyBehaviours {

    @Override
    public void fly() {
        System.out.println("Flying with a Rocket");
    }
}
