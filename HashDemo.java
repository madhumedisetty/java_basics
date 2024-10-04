// Generic HashTable implementation using double hashing
class HashTable<K,V> {
    // Array to store the entries (key-value pairs)
    private Entry<K,V>[] table;
    // Keeps track of the number of elements in the HashTable
    private int size;
    // Load factor threshold for resizing the table when it becomes too full
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;

    // Constructor to initialize the HashTable with a specific capacity
    public HashTable(int capacity) {
        table = new Entry[capacity]; // Initialize the array with the given capacity
        size = 0; // Initialize size to 0
    }

    // Method to insert key-value pairs into the HashTable
    public void put(K key, V value) {
        // Check if the key is null (null keys are not allowed)
        if (key == null) {
            throw new IllegalArgumentException("Null keys are not allowed"); // Throw an exception for null keys
        }

        // Check if the load factor exceeds the threshold (for resizing)
        if ((double)size / table.length >= LOAD_FACTOR_THRESHOLD) {
            resize(); // Resize the table if necessary
        }

        // Calculate the index using the first hash function
        int index = hash1(key);
        // Calculate the step size for double hashing using the second hash function
        int step = hash2(key);
        int i = 0; // Initialize the counter for double hashing

        // Linear probing with double hashing to find the correct position for the key
        while (table[index] != null && !table[index].getKey().equals(key)) {
            // If the slot is occupied and the key is different, find the next index
            index = (index + step * i) % table.length;
            i++; // Increment the counter for the next probe
        }

        // Insert the new key-value pair in the found position
        table[index] = new Entry<>(key, value);
        size++; // Increment the size of the HashTable
    }

    // Method to retrieve the value associated with a given key
    public V get(K key) {
        // Check if the key is null (null keys are not allowed)
        if (key == null) {
            throw new IllegalArgumentException("Null keys are not allowed"); // Throw an exception for null keys
        }

        // Calculate the index using the first hash function
        int index = hash1(key);
        // Calculate the step size for double hashing
        int step = hash2(key);
        int i = 0; // Initialize the counter for double hashing

        // Search for the key using double hashing
        while (table[index] != null) { // Continue searching while there is an entry at the index
            if (table[index].getKey().equals(key)) { // If the key matches, return the associated value
                return table[index].getValue();
            }
            // Otherwise, probe to the next index using the step size
            index = (index + step * i) % table.length;
            i++; // Increment the counter for the next probe
        }

        // Return null if the key is not found
        return null;
    }

    // Method to resize the HashTable when the load factor threshold is exceeded
    private void resize() {
        // Store the old table for rehashing
        Entry<K,V>[] oldTable = table;
        // Create a new table with double the capacity
        table = new Entry[oldTable.length * 2];
        size = 0; // Reset size to 0 because we will reinsert the entries

        // Reinsert each entry from the old table into the new, larger table
        for (Entry<K,V> entry : oldTable) {
            if (entry != null) { // Only reinsert non-null entries
                put(entry.getKey(), entry.getValue()); // Reinsert using the put method
            }
        }
    }

    // First hash function to calculate the initial index
    private int hash1(K key) {
        // Calculate the hash code and ensure it's positive, then mod by table length
        return Math.abs(key.hashCode()) % table.length;
    }

    // Second hash function to calculate the step size for double hashing
    private int hash2(K key) {
        // A second hash function that ensures the step size is non-zero and different from hash1
        return 1 + (Math.abs(key.hashCode()) % (table.length - 1));
    }

    // Static inner class to represent an entry (key-value pair) in the HashTable
    private static class Entry<K,V> {
        private K key; // The key
        private V value; // The value

        // Constructor to initialize an entry with a key and value
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        // Getter for the key
        public K getKey() {
            return key;
        }

        // Getter for the value
        public V getValue() {
            return value;
        }
    }
}

// Main class to demonstrate the HashTable implementation
public class HashDemo {
    public static void main(String[] args) {
        // Create a HashTable with an initial capacity of 5
        HashTable<String, Integer> hashTable = new HashTable<>(5);

        // Insert some key-value pairs (names and their ages)
        hashTable.put("Alice", 30);
        hashTable.put("Bob", 25);
        hashTable.put("Charlie", 35);
        hashTable.put("David", 28);
        hashTable.put("Eve", 22);

        // Retrieve and display values
        System.out.println("Alice's age: " + hashTable.get("Alice"));  // Output: 30
        System.out.println("Bob's age: " + hashTable.get("Bob"));      // Output: 25
        System.out.println("Charlie's age: " + hashTable.get("Charlie")); // Output: 35
        System.out.println("David's age: " + hashTable.get("David"));  // Output: 28
        System.out.println("Eve's age: " + hashTable.get("Eve"));      // Output: 22

        // Attempt to retrieve a non-existing key
        System.out.println("Frank's age: " + hashTable.get("Frank"));  // Output: null (Frank is not in the table)
    }
}
