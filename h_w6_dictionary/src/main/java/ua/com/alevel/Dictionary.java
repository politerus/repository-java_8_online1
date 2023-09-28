package ua.com.alevel;
import java.util.*;

public class Dictionary<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private final Hashtable<K, V> hashtable;

    public Dictionary() {
        hashtable = new Hashtable<>(INITIAL_CAPACITY, LOAD_FACTOR);
    }

    public int size() {
        return hashtable.size();
    }

    public boolean isEmpty() {
        return hashtable.isEmpty();
    }

    public boolean containsKey(K key) {
        return hashtable.containsKey(key);
    }

    public boolean containsValue(V value) {
        return hashtable.containsValue(value);
    }

    public V get(K key) {
        return hashtable.get(key);
    }

    public boolean put(K key, V value) {
        V oldValue = hashtable.put(key, value);
        return !Objects.equals(oldValue, value);
    }

    public boolean remove(K key) {
        return hashtable.remove(key) != null;
    }

    public boolean putAll(Dictionary<K, V> dictionary) {
        boolean modified = false;
        for (Map.Entry<K, V> entry : dictionary.entrySet()) {
            if (put(entry.getKey(), entry.getValue())) {
                modified = true;
            }
        }
        return modified;
    }

    public boolean clear() {
        hashtable.clear();
        return true;
    }

    public Set<K> keySet() {
        return hashtable.keySet();
    }

    public Collection<V> values() {
        return hashtable.values();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return hashtable.entrySet();
    }

    @Override
    public String toString() {
        return hashtable.toString();
    }
}
