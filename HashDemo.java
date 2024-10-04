import java.util.function.BiConsumer;

class HashTable<K, V> {
    private Entry<K, V>[] table; // Array to store entries
    private int size; // Number of elements in the table
    private static final double LOAD_FACTOR_THRESHOLD = 0.75; // Threshold for resizing

    // Constructor to initialize table with given capacity
    public HashTable(int capacity) {
        table = new Entry[capacity];
        size = 0;
    }

    // Method to insert key-value pairs
    public void put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("Null keys are not allowed");

        if ((double) size / table.length >= LOAD_FACTOR_THRESHOLD) {
            resize(); // Resize if load factor exceeds the threshold
        }

        int index = hash1(key); // Get initial index
        int step = hash2(key); // Get step size for double hashing
        int i = 0;

        // Find the correct index using double hashing
        while (table[index] != null && !table[index].getKey().equals(key)) {
            index = (index + step * i) % table.length;
            i++;
        }

        table[index] = new Entry<>(key, value); // Insert key-value pair
        size++;
    }

    // Method to retrieve value by key
    public V get(K key) {
        if (key == null) throw new IllegalArgumentException("Null keys are not allowed");

        int index = hash1(key); // Get initial index
        int step = hash2(key); // Get step size
        int i = 0;

        // Search for the key
        while (table[index] != null) {
            if (table[index].getKey().equals(key)) {
                return table[index].getValue(); // Return value if key is found
            }
            index = (index + step * i) % table.length;
            i++;
        }
        return null; // Return null if key not found
    }

    // Method to remove a key-value pair
    public V remove(K key) {
        if (key == null) throw new IllegalArgumentException("Null keys are not allowed");

        int index = hash1(key);
        int step = hash2(key);
        int i = 0;

        // Search for the key
        while (table[index] != null) {
            if (table[index].getKey().equals(key)) {
                V value = table[index].getValue();
                table[index] = null; // Remove the entry
                size--;

                // Rehash all subsequent elements to maintain structure
                index = (index + step * i) % table.length;
                i++;
                while (table[index] != null) {
                    Entry<K, V> rehashEntry = table[index];
                    table[index] = null; // Remove entry before re-inserting it
                    put(rehashEntry.getKey(), rehashEntry.getValue()); // Reinsert
                    index = (index + step * i) % table.length;
                    i++;
                }

                return value; // Return the removed value
            }
            index = (index + step * i) % table.length;
            i++;
        }
        return null; // Return null if key not found
    }

    // Method to apply action to each key-value pair
    public void forEach(BiConsumer<K, V> action) {
        for (Entry<K, V> entry : table) {
            if (entry != null) {
                action.accept(entry.getKey(), entry.getValue()); // Apply the action to each entry
            }
        }
    }

    // Resize the table when load factor is exceeded
    private void resize() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[oldTable.length * 2]; // Double the size
        size = 0;

        // Reinsert old entries into the new table
        for (Entry<K, V> entry : oldTable) {
            if (entry != null) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    // First hash function
    private int hash1(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    // Second hash function for double hashing
    private int hash2(K key) {
        return 1 + (Math.abs(key.hashCode()) % (table.length - 1));
    }

    // Inner class to represent a key-value pair
    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}

// Test the HashTable
public class HashDemo {
    public static void main(String[] args) {
        // Create a HashTable
        HashTable<String, Integer> hashTable = new HashTable<>(5);

        // Add key-value pairs
        hashTable.put("Alice", 30);
        hashTable.put("Bob", 25);
        hashTable.put("Charlie", 35);
        hashTable.put("David", 28);
        hashTable.put("Eve", 22);

        // Retrieve and print values
        System.out.println("Alice's age: " + hashTable.get("Alice"));  // Output: 30

        // Remove a key
        System.out.println("Removing Bob's age: " + hashTable.remove("Bob"));  // Output: 25

        // Try to get a removed value
        System.out.println("Bob's age after removal: " + hashTable.get("Bob"));  // Output: null

        // Iterate and print all entries using forEach
        hashTable.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
