public class HashNode<K, V> {
    K key;
    V value;
    HashNode<K, V> next;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K key() {
        return key;
    }

    public V next() {
        return next.next();
    }

    public void value(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" + key + " " + value + "}";
    }
}