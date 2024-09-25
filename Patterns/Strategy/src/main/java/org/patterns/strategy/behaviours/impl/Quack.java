package org.patterns.strategy.behaviours.impl;

import org.patterns.strategy.behaviours.QuackBehaviour;

public class Quack implements QuackBehaviour {

    public void quack() {
        System.out.println("Quack.");
    }
}
