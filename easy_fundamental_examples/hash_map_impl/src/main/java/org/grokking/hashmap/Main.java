package org.grokking.hashmap;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put(1,1);
        System.out.println(myHashMap);
        myHashMap.put(2,2);
        System.out.println(myHashMap);
        myHashMap.put(5,3);
        System.out.println(myHashMap);
        myHashMap.put(9,4);
        System.out.println(myHashMap);
        myHashMap.put(10,5);
        System.out.println(myHashMap);
    }
}