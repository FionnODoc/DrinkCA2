package org.project.drinksca2.utils;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class HashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] table;
    private int size;

    public HashMap() {
        table = new LinkedList[INITIAL_CAPACITY];
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = getIndex(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.key.equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    public V remove(K key) {
        int index = getIndex(key);
        if (table[index] != null) {
            for (int i = 0; i < table[index].size(); i++) {
                Entry<K, V> entry = table[index].get(i);
                if (entry.key.equals(key)) {
                    V value = entry.value;
                    table[index].remove(i);
                    size--;
                    return value;
                }
            }
        }
        return null;
    }

    public void clear() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                table[i].clear();
            }
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public Collection<V> values() {
        List<V> values = new LinkedList<>();
        for (LinkedList<Entry<K, V>> bucket : table) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    values.add(entry.value);
                }
            }
        }
        return values;
    }

    private int getIndex(K key) {
        return (key.hashCode() & 0x7fffffff) % table.length;
    }


    public LinkedList<Entry<K, V>> getHead() {
        return table[0];
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}