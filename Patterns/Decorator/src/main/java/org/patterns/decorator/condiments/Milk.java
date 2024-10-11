package org.patterns.decorator.condiments;

import org.patterns.decorator.Beverage;

public class Milk  extends CondimentDecorator{
    public Milk(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription()+", Milk";
    }

    @Override
    public double cost() {
        return .10 + beverage.cost();
    }
}
