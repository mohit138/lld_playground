package org.patterns.observer.displays;

public interface Observer {
    public void update(float temperature, float humidity, float pressure);
}
