public class MyHashTable <K, V>{
    private class HashNode<K,V>{
        private K key;
        private V value;
        private HashNode<K,V> next;
        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return "{" + key + ":" + value + "}";
        }
    }
    private HashNode<K, V>[] chain;
    private int M = 11; // default number of chains
    private int size;

    public MyHashTable() {//constructor
        this.chain = new HashNode[M];
    }

    public MyHashTable(int M) {//constructor
        this.M = M;
        this.chain = new HashNode[M];
    }

    private int hash(K key) {
        return key.hashCode() % M; // hashing
    }

    public void put(K key, V value) {
        int index = hash(key); // getting index with hashing
        HashNode<K, V> newNode = new HashNode<>(key, value);

        for (HashNode<K, V> currentNode = chain[index]; currentNode != null; currentNode = currentNode.next) {
            if (currentNode.key.equals(key)) {
                currentNode.value = value;
                return;
            }
        }

        newNode.next = chain[index];
        chain[index] = newNode;
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> currentNode = chain[index];

        for (currentNode = chain[index]; currentNode != null; currentNode = currentNode.next) {
            if (currentNode.key.equals(key)) {
                return currentNode.value;
            }
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> prevNode = null;

        for (HashNode<K, V> currentNode = chain[index]; currentNode != null; prevNode = currentNode, currentNode = currentNode.next) {
            if (currentNode.key.equals(key)) {
                if (prevNode == null) {
                    chain[index] = currentNode.next;
                } else {
                    prevNode.next = currentNode.next;
                }
                size--;
                return currentNode.value;
            }
        }

        return null;
    }

    public boolean contains(V value) {
        for (HashNode<K, V> node : chain) {
            for (HashNode<K, V> currentNode = node; currentNode != null; currentNode = currentNode.next) {
                if (currentNode.value.equals(value)) {
                    return true; // returning true if value is in hash table
                }
            }
        }
        return false; // returning false otherwise
    }

    public K getKey(V value) {
        for (HashNode<K, V> node : chain) {
            for (HashNode<K, V> currentNode = node; currentNode != null; currentNode = currentNode.next) {
                if (currentNode.value.equals(value)) {
                    return currentNode.key; // returning key of value if exist
                }
            }
        }
        return null;  // returning null otherwise
    }

    public int getSize() {
        return size;
    }

    public V remove_old(K key,V newval) {
        int index = hash(key);
        HashNode<K, V> node = chain[index];
        while(node != null){
            if(node.key.equals(key)){
                node.value = newval;
                return newval;
            }
            node = node.next;
        }
        return null;
    }
}
