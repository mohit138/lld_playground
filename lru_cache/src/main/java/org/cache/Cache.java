package org.cache;

import org.cache.utils.EvictionPolicy;
import org.cache.utils.Storage;

public class Cache {
    private final EvictionPolicy evictionPolicy;
    private final Storage storage;

    Cache (EvictionPolicy evictionPolicy, Storage storage) {

        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(String key, String value){
        this.storage.add(key,value);
        this.evictionPolicy.keyAccessed(key);
        if(storage.isStorageFull()){
            String keyToRemove = evictionPolicy.evictKey();
            storage.remove(keyToRemove);
        }
    }

    public String get(String key){
        String value = storage.get(key);
        if(value!=null)
            evictionPolicy.keyAccessed(key);
        return value;
    }

}
