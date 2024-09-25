package org.patterns.isahasa;

import org.patterns.isahasa.behaviours.impl.FlyNoWay;
import org.patterns.isahasa.behaviours.impl.Quack;

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
