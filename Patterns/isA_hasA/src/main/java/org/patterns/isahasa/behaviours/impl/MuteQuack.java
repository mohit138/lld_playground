package org.patterns.isahasa.behaviours.impl;

import org.patterns.isahasa.behaviours.QuackBehaviour;

public class MuteQuack implements QuackBehaviour {

    public void quack(){
        System.out.println("<<SILENCE>>");
    }
}
