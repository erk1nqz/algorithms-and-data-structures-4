public class HashNode<K, V> {
    private K key;
    private V value;
    private HashNode<K, V> next;
    /**
     * HashNode - constructor to set values in fields
     * @param key - given key to set
     * @param value - given value to set
     */
    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
    /**
     * getKey - method that returns key of node
     * @return K - key type
     */
    public K getKey() {
        return key;
    }
    /**
     * getValue - method that returns value of node
     * @return V - value type
     */
    public V getValue() {
        return value;
    }
    /**
     * setValue - method that set value in node
     * @param value - given value to set
     */
    public void setValue(V value) {
        this.value = value;
    }
    /**
     * toString - method that returns node with specific type
     * @return String
     */
    @Override
    public String toString() {
        return "{" + key + " " + value + "}";
    }
}