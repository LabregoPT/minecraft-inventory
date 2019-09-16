package ds;

/**
 * @param <T> The type of the elements from the HashTable
 * @author Andres Orozco A00355202
 * Universidad ICESI
 */
public class HashTable<T> {
    /**
     * The linked list would be used in the chaining method if required
     */

    private int hashValue;

    public T hashMap[];

    private int z;

    /**
     * @param h This is the hash value, it will be given
     */
    @SuppressWarnings("unchecked")
    public HashTable(int z) {
        z = this.z;

        hashMap = (T[]) new Object[z];
    }

    /**
     * This method return the key which will be given
     *
     * @return The key
     */
    public int getHashValue() {
        return hashValue;
    }


    //Method inhereted from hashTable

    /**
     * This method check if the hash table is empty if is empty returns true , else return false
     *
     * @return the status of the hash table
     */
    public boolean isEmpty() {
        boolean result = false;
        for (int i = 0; i < hashMap.length; i++) {
            if (hashMap[i] != null) {
                result = true;
            }
        }
        return result;
    }

    /**
     * This
     *
     * @param B
     * @param k
     * @throws EmptyException
     */
    public void insert(T[] B, int k, T element) {
        int i, j;
        i = 0;
        while (i > z) {
            j = calculateByDivisionMethod(i);
            if (isEmpty()) {
                B[j] = element;

            } else {
                int newPos = doubleHashing(k, i);
                B[newPos] = element;
            }
        }

    }

    /**
     * This method search for an element T, by the given key
     *
     * @param k the given key
     * @param B The hashTable
     * @return if the key is found  it return it otherwise will return null
     */
    public T search(int k, T[] B) {
        T toReturn = null;
        int i = 0;
        int j;
        while (i < z) {
            j = getHashValue();
            if (B[j] != null) {
                B[j] = toReturn;
            } else {
                toReturn = null;

            }
        }

        return toReturn;
    }

    /**

     *@param k This is the key to be deleted in the HashTable
     */
    public void delete(int k,T[]B) {
    	B[k]=null;
    } 
    					//HashFunctions

    /**
     * This method calculates the hash function my the division mehtod
     *
     * @param k Is the given key
     * @return
     */
    public int calculateByDivisionMethod(int k) {
        double A = (Math.sqrt(5) - 1) / 2;
        double answer = Math.floor(z * ((k * A) % 1));
        return (int) answer;
    }

    /**
     * This method uses the calculation hash function in order to calculate the key
     *
     * @param k is the key which is given
     * @return the hashFunction
     */
    public int calculateByMultiplcationMethod(int k) {
        int answer = k % z;
        return answer;
    }

    /**
     * @param key
     * @return
     */
    public int hashFunc2(int key) {
        //It is better to use prime numbers
        return 5 - key % 5;
    }

    //Collision resolution by open addressing

    /**
     * This method will use the doubleHashing for resolve a collision
     *
     * @param k  Is the given key
     * @param h1 Is an auxiliary function
     * @param h2 Another auxiliary function
     * @param i
     */
    public int doubleHashing(int k, int i) {
        //h.k; i/ D .h 1 .k/ C ih 2 .k// mod m
        int newPos = (calculateByMultiplcationMethod(k) + i * hashFunc2(k)) % z;
        return newPos;

    }

    /**
     *
     */
    public void linearProbing() {
    }

    public void quadraticProbing() {
    }


    public static void main(String[] args) {
        int[] x;
        Integer xz = new Integer(10);
        HashTable<Integer> ht;
        ht = new HashTable<Integer>(10);
        ht.insert(ht.hashMap, 0, xz);
        System.out.println(ht.search(0, ht.hashMap));

    }

}


/**
 * IGNORE THIS
 * public class Hashtbl<K,V> {
 * <p>
 * private Hashnode<K,V>[] nodes;
 *
 * @SuppressWarnings("unchecked") public Hashtbl(int size){
 * nodes = new Hashnode[size];
 * }
 * <p>
 * private int getIndex(K key){
 * int hash = key.hashCode() % nodes.length;
 * if(hash < 0){
 * hash += nodes.length;
 * }
 * return hash;
 * }
 * <p>
 * public V insert(K key, V data){
 * int hash = getIndex(key);
 * <p>
 * // Lets check if same key already exists and if so lets update it with the new value
 * for(Hashnode<K,V> node = nodes[hash]; node != null; node = node.next){
 * if((hash == node.hash) && key.equals(node.key)){
 * V oldData = node.data;
 * node.data = data;
 * return oldData;
 * }
 * }
 * <p>
 * // Lets add the new hash node created below to the start of linked list at nodes[hash] position
 * Hashnode<K,V> node = new Hashnode<K,V>(key, data, nodes[hash], hash);
 * nodes[hash] = node;
 * <p>
 * return null;
 * }
 * <p>
 * /**
 * * It Removes the given key from hash table.
 * * 1. Gets the hash using built in hash code method and by doing % to match to local index
 * * 2. Look for the corresponding index in nodes array, if found then, we got the linked list
 * *         a. Search for the given key, also match the hash
 * *         b. If found, make previous.next = node.next; and return true.
 * * @param key
 * * @return
 * <p>
 * public boolean remove(K key){
 * int hash=getIndex(key);
 * Hashnode<K, V> previous=null;
 * for(Hashnode<K, V> node=nodes[hash];node!=null;node=node.next){
 * if((hash==node.hash)&&key.equals(node.key)){
 * if(previous!=null){
 * previous.next=node.next;
 * }else{
 * nodes[hash]=node.next;
 * }
 * return true;
 * }
 * previous=node;
 * }
 * return false;
 * }
 * <p>
 * public V get(K key){
 * int hash=getIndex(key);
 * <p>
 * for(Hashnode<K, V> node=nodes[hash];node!=null;node=node.next){
 * if(key.equals(node.key))
 * return node.data;
 * }
 * return null;
 * }
 * <p>
 * public void resize(int size){
 * Hashtbl<K, V> newtbl=new Hashtbl<K, V>(size);
 * for(Hashnode<K, V> node:nodes){
 * for(;node!=null;node=node.next){
 * newtbl.insert(node.key,node.data);
 * remove(node.key);
 * }
 * }
 * nodes=newtbl.nodes;
 * }
 * <p>
 * /**
 * * Generic Hash node class, acts like a linked list node
 * * @author IVY3508
 * *
 * * @param <K>
 * * @param <V>
 * <p>
 * <p>
 * <p>
 * public static class Hashnode<K, V> {
 * <p>
 * final K key;
 * <p>
 * V data;
 * <p>
 * Hashnode<K, V> next;
 * <p>
 * final int hash;
 * <p>
 * <p>
 * <p>
 * public Hashnode(K k, V v, Hashnode<K, V> n, int h) {
 * key = k;
 * data = v;
 * next = n;
 * hash = h;
 * }
 * <p>
 * }
 * <p>
 * Most of the code where found in
 */
