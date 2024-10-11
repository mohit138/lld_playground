package org.patterns.decorator.condiments;

import org.patterns.decorator.Beverage;

public abstract class CondimentDecorator extends Beverage {
    Beverage beverage;
    @Override
    public abstract String getDescription();
}
