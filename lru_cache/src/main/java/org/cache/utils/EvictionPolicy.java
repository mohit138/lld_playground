package org.cache.utils;

import java.util.HashMap;
import java.util.Map;

public class EvictionPolicy {
    private DLL dll;
    private Map<String, DLLN> mapper;

    public EvictionPolicy(){
        this.dll = new DLL();
        mapper = new HashMap<>();
    }

    public void keyAccessed(String key){
        DLLN node;
        if(mapper.containsKey(key)){
            node = dll.detatchNode(mapper.get(key));
        }else{
            node = new DLLN(key);
        }
        mapper.put(key,dll.insertNodeAtEnd(node));
    }

    public String evictKey(){
        String keyToEvict = dll.getHead().data;
        mapper.remove(keyToEvict);
        dll.removeHead();
        return keyToEvict;
    }

    public void printExistingLinkedList(){
        dll.printDLL();
    }
}
