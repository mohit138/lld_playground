package org.cache.utils;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String,String> storage;
    private final Integer capacity;

    public Storage(Integer capacity){
        storage = new HashMap<>();
        this.capacity=capacity;
    }

    public void add(String key, String value){
        storage.put(key,value);
    }

    public void remove(String key){
        if(!storage.containsKey(key)){
            return;
        }
        storage.remove(key);
    }

    public String get(String key){
        return storage.get(key);
    }

    public boolean isStorageFull(){
        return (storage.size()>capacity);
    }
}
