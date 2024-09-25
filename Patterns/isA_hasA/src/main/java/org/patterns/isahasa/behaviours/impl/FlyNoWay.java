package org.patterns.isahasa.behaviours.impl;

import org.patterns.isahasa.behaviours.FlyBehaviours;

public class FlyNoWay implements FlyBehaviours {

    @Override
    public void fly() {
    System.out.println("Can Not Fly.");
    }
}
