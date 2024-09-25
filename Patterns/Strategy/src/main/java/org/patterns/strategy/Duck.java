package org.patterns.strategy;

import org.patterns.strategy.behaviours.FlyBehaviours;
import org.patterns.strategy.behaviours.QuackBehaviour;

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
