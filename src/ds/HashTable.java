package ds;

/**
 * This data structure is meant to act as a Hash Table, in which elements are stored in an array using particular functions to figure out their indexes.
 * This implementation will use double hashing as its collision handling method.
 * @author Jhon Edward Mora - Universidad ICESI - A00355710
 * @version 1.1 - 09/2019
 * @param <T> The Object that will be stored in this HashTable.
 */
public class HashTable<T extends Hashable> {

	//Attributes
	/**The representative array of this HashTable.*/
	private T[] arr;
	
	/**The max size that the representative array will have. Must be higher or equal to the maximum possible number of keys to be used.*/
	private int size;
	
	/**The number of elements that have been added in this hashtable.*/
	private int hashSize;
	
	/**
	 * Creates a Hashtable and initialises its representative array with a given size.
	 * @param s Maximum size of the Hashtable, must be higher or equals to the max possible number of keys to be used.
	 */
	@SuppressWarnings("unchecked")
	public HashTable(int s){
		arr = (T[])new Hashable[s];
		size = s;
		hashSize = 0;
	}
	
	/**
	 * Adds a new element to this hash table using a chosen hash function.
	 * @param obj The element to be added in this hash table.
	 */
	public void add(T obj) {
		int i = 0;
		while(i<size) {
			int index = getIndex(obj.getKey(), i);
			if(arr[index] == null) {
				arr[index] = obj;
				hashSize++;
				break;
			}else {
				i++;
			}
		}
	}
	
	/**
	 * Searches for an element in this hash table, by its key.
	 * @param key The key to search.
	 * @return The found element that matches the given key. Null if this key is yet to be stored in this table.
	 */
	public T search(int key) {
		int i = 0;
		int j =getIndex(key, i);
		while(arr[j]!=null && i <= size) {
			if(arr[j].getKey() == key) {
				return arr[j];
			}
			i++;
		}
		return null;
	}
	
	/**
	 * Determines whether or not this table is full.
	 * @return True if the size of this table is equals to the number of already added elements, false if not.
	 */
	public boolean isFull() {
		return size == hashSize;
	}
	
	/**
	 * Determines an index to store an object given its key. This uses the double hashing collision handling and a multiplication and single modulo hashing functions
	 * @param key The given key.
	 * @param i Number of times the double hashing function has been done.
	 * @return An integer determining the index where to store a value.
	 */
	private int getIndex(int key, int i) {
		int hashA = calculateByDivision(key);
		int hashB = calculateByMultiplication(key);
		return (hashA + (i*hashB))%size;
	}
	
	private int calculateByDivision(int key) {
		double a = (Math.sqrt(5))/2;
		return (int)Math.floor(hashSize*((key*a)%1));
	}
	
	private int calculateByMultiplication(int key) {
		return key*hashSize;
	}
	
	public String toString() {
		String m = "";
		for(T t:arr) {
			if(t!=null)
				m+=t.toString() + " ";
			else
				m+= "- ";
		}
		return m;
	}
	
}
