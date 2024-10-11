package org.patterns.observer.displays.impl;

import org.patterns.observer.WeatherData;
import org.patterns.observer.displays.DisplayElement;
import org.patterns.observer.displays.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    WeatherData weatherData;

    public CurrentConditionsDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current Conditions: "+temperature+"F degree and "+humidity+"% humidity");
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.humidity=humidity;
        this.temperature=temperature;
        display();
    }
}
