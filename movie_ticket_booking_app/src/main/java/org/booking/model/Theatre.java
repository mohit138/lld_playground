package org.booking.model;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Theatre {
    private final String id;
    private final String name;
    private final List<Screen> screens;

    public Theatre(String id, String name) {
        this.id = id;
        this.name = name;
        this.screens = new ArrayList<>();
    }

    public void addScreen(@NonNull final Screen screen){
        screens.add(screen);
    }
}
