package org.cache;

import org.cache.utils.DLL;
import org.cache.utils.DLLN;
import org.cache.utils.EvictionPolicy;
import org.cache.utils.Storage;

public class Main {
    public static void main(String[] args) {

        //DLL TESTING
//        DLL dll = new DLL();
//        DLLN nodeFirst = dll.insertNodeAtEnd(new DLLN("1"));
//        dll.insertNodeAtEnd(new DLLN("2"));
//        DLLN node = dll.insertNodeAtEnd(new DLLN("3"));
//        dll.insertNodeAtEnd(new DLLN ("4"));
//        DLLN nodeLast = dll.insertNodeAtEnd(new DLLN ("5"));
//        dll.printDLL();
//        dll.detatchNode(node);
//        dll.printDLL();
//        dll.detatchNode(nodeFirst);
//        dll.printDLL();
//        dll.detatchNode(nodeLast);
//        dll.printDLL();
//        dll.removeHead();
//        dll.printDLL();

        EvictionPolicy evictionPolicy = new EvictionPolicy();
        Storage storage = new Storage(5);
        Cache cache = new Cache(evictionPolicy, storage);

        cache.put("A","1");
        cache.put("B","2");
        cache.put("C","3");
        cache.put("D","4");
        cache.put("E","5");

        evictionPolicy.printExistingLinkedList();

        System.out.println(cache.get("A"));

        evictionPolicy.printExistingLinkedList();

        cache.put("F","6");

        evictionPolicy.printExistingLinkedList();

        System.out.println(cache.get("A"));
        System.out.println(cache.get("B"));
    }
}