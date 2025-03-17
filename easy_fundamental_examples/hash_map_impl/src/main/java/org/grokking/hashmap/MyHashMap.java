package org.grokking.hashmap;

import java.util.Arrays;

/*
* We need following functions
* public:
* .get(K)
* .put(K,V)
*
* private:
* .rehash()
* .hash()
*
* */
public class MyHashMap <K,V>{
    private static class Entry<K,V>{
        K key;
        V value;
        Entry<K,V> next;
        Entry(K key, V value){
            this.key = key;
            this.value=value;
        }
    }

    private int size=0;
    private int capacity = 4;
    private float loadFactor = 0.75f;
    private Entry<K,V>[] table;

    MyHashMap(){
        table = new Entry[capacity];
    }

    private int hash(K key){
        return (key.hashCode() % capacity);
    }

    public void put(K key, V value){
        int index = hash(key);
        Entry<K,V> curEntry = table[index];

        while(curEntry!=null){
            if(curEntry.key.equals(key)){
                curEntry.value = value;
                return;
            }
            curEntry = curEntry.next;
        }

        size++;
        curEntry = new Entry<K,V>(key, value);
        curEntry.next = table[index];
        table[index] = curEntry;

        if((float)size/capacity >= loadFactor){
            rehash();
        }

    }

    public V get(K key){
        int index = hash(key);
        Entry<K,V> curEntry = table[index];

        while(curEntry!=null){
            if(curEntry.key.equals(key)){
                return curEntry.value;
            }
            curEntry = curEntry.next;
        }

        return null;
    }


    private void rehash(){
        Entry<K,V>[] oldTable = table;
        capacity =2*capacity;
        table = new Entry[capacity];
        size=0;

        for(Entry<K,V> head:oldTable){
            while(head!=null){
                put(head.key, head.value);
                head = head.next;
            }
        }
    }

    public String tableToString(){
        StringBuilder output= new StringBuilder("\n");
        for(Entry<K,V> head:table){
            output.append(" => ");
            while(head!=null){
                output.append("( ").append(head.key).append(", ").append(head.value).append(") ");
                head = head.next;
            }
            output.append("\n");
        }
        return output.toString();
    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "size=" + size +
                ", capacity=" + capacity +
                ", loadFactor=" + loadFactor +
                ", table=" + tableToString() +
                '}';
    }
}
