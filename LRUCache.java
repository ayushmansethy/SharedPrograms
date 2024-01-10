import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, V> cache;
    private final Queue<K> lruOrder;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.lruOrder = new LinkedList<>();
    }

    public V get(K key) {
        if (cache.containsKey(key)) {
            // Move the accessed key to the end to represent it's the most recently used
            lruOrder.remove(key);
            lruOrder.offer(key);
            return cache.get(key);
        }
        return null; // Key not present in the cache
    }

    public void set(K key, V value) {
        if (cache.containsKey(key)) {
            // Update the existing key
            cache.put(key, value);
            lruOrder.remove(key);
        } else {
            // Check if the cache is at capacity and remove the least recently used key
            if (cache.size() >= capacity) {
                K lruKey = lruOrder.poll();
                cache.remove(lruKey);
            }
            // Add the new key-value pair
            cache.put(key, value);
        }
        // Add the current key to the end to represent it's the most recently used
        lruOrder.offer(key);
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache<>(3);

        lruCache.set(1, "One");
        lruCache.set(2, "Two");
        lruCache.set(3, "Three");

        System.out.println("Initial Cache:");
        System.out.println(lruCache.cache.keySet());

        // Access key 1 to make it the most recently used
        lruCache.get(1);

        System.out.println("\nCache after accessing key 1:");
        System.out.println(lruCache.cache.keySet());

        // Add a new key-value pair, evicting the least recently used key (key 2)
        lruCache.set(4, "Four");

        System.out.println("\nCache after adding key 4:");
        System.out.println(lruCache.cache.keySet());
    }
}
