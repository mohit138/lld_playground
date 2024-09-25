package org.patterns.isahasa;

import org.patterns.isahasa.behaviours.FlyBehaviours;
import org.patterns.isahasa.behaviours.QuackBehaviour;

public abstract class Duck {

    FlyBehaviours flyBehaviour;
    QuackBehaviour quackBehaviour;

    Duck(){

    }

    public abstract void display();

    public void perforFly(){
        flyBehaviour.fly();
    }

    public void performQuack(){
        quackBehaviour.quack();
    }

    public void swim(){
        System.out.println("All ducks float.");
    }

    public void setQuackBehaviour(QuackBehaviour qb){
        quackBehaviour=qb;
    }
    public void setFlyBehaviour(FlyBehaviours fb){
        flyBehaviour=fb;
    }
}
