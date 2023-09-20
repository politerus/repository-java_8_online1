package ua.com.alevel;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

public class Dictionary<K, V> {
    private final Map<K, V> map;

    public Dictionary() {
        map = new HashMap<>();
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public boolean containsValue(V value) {
        return map.containsValue(value);
    }

    public V get(K key) {
        return map.get(key);
    }

    public void put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key and value cannot be null");
        }
        map.put(key, value);
    }

    public void remove(K key) {
        map.remove(key);
    }

    public void putAll(Dictionary<K, V> dictionary) {
        if (dictionary == null) {
            throw new IllegalArgumentException("Dictionary cannot be null");
        }

        for (K key : dictionary.keySet()) {
            V value = dictionary.get(key);
            this.put(key, value);
        }

    }

    public void clear() {
        map.clear();
    }

    public Set<K> keySet() {
        return map.keySet();
    }

    public Collection<V> values() {
        return map.values();
    }
}
