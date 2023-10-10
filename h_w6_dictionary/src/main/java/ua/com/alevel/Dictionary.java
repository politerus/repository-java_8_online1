package ua.com.alevel;

import java.util.*;

public class Dictionary<K, V> {


    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Entry<K, V>[] table;
    private int size;

    public Dictionary() {
        this.table = new Entry[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public int size() {

        return size;
    }

    public boolean isEmpty() {

        return size == 0;
    }

    public boolean containsKey(K key) {

        return getEntry(key) != null;
    }

    public boolean containsValue(V value) {
        for (Entry<K, V> entry : table) {
            while (entry != null) {
                if (Objects.equals(entry.getValue(), value)) {
                    return true;
                }
                entry = entry.next;
            }
        }
        return false;
    }

    public V get(K key) {
        Entry<K, V> entry = getEntry(key);
        return (entry != null) ? entry.getValue() : null;
    }

    public boolean put(K key, V value) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }
        int index = hash(key) % table.length;
        Entry<K, V> entry = table[index];
        while (entry != null) {
            if (key.equals(entry.getKey())) {
                entry.setValue(value);
                return true;
            }
            entry = entry.next;
        }
        addEntry(index, key, value);
        size++;
        if (size >= table.length * LOAD_FACTOR) {
            resizeTable();
        }
        return true;
    }

    public boolean remove(K key) {
        if (key == null) {
            return false;
        }
        int index = hash(key) % table.length;
        Entry<K, V> entry = table[index];
        Entry<K, V> prev = null;
        while (entry != null) {
            if (key.equals(entry.getKey())) {
                if (prev != null) {
                    prev.next = entry.next;
                } else {
                    table[index] = entry.next;
                }
                size--;
                return true;
            }
            prev = entry;
            entry = entry.next;
        }
        return false;
    }

    public boolean putAll(Dictionary<K, V> dictionary) {
        if (dictionary != null) {
            for (Entry<K, V> entry : dictionary.table) {
                while (entry != null) {
                    put(entry.getKey(), entry.getValue());
                    entry = entry.next;
                }
            }
            return true;
        }
        return false;
    }

    public boolean clear() {
        Arrays.fill(table, null);
        size = 0;
        return true;
    }

    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (Entry<K, V> entry : table) {
            while (entry != null) {
                keys.add(entry.getKey());
                entry = entry.next;
            }
        }
        return keys;
    }

    public Collection<V> values() {
        List<V> values = new ArrayList<>();
        for (Entry<K, V> entry : table) {
            while (entry != null) {
                values.add(entry.getValue());
                entry = entry.next;
            }
        }
        return values;
    }

    private int hash(K key) {
        return (key == null) ? 0 : key.hashCode();
    }

    private Entry<K, V> getEntry(K key) {
        int index = hash(key) % table.length;
        Entry<K, V> entry = table[index];
        while (entry != null) {
            if (key.equals(entry.getKey())) {
                return entry;
            }
            entry = entry.next;
        }
        return null;
    }

    private void addEntry(int index, K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value);
        entry.next = table[index];
        table[index] = entry;
    }

    private void resizeTable() {
        int newCapacity = table.length * 2;
        Entry<K, V>[] newTable = new Entry[newCapacity];
        for (Entry<K, V> entry : table) {
            while (entry != null) {
                int index = hash(entry.getKey()) % newCapacity;
                Entry<K, V> next = entry.next;
                entry.next = newTable[index];
                newTable[index] = entry;
                entry = next;
            }
        }
        table = newTable;
    }

    private static class Entry<K, V> {
        private final K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}