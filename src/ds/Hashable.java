package ds;

/**
 * Interface that every element that will use a HashTable must implement. Simply defines the key functions.
 * @author Jhon Edward Mora - Universidad ICESI - A00355710
 * @version 1.0 - 09/2019
 */
public interface Hashable {

	/**
	 * Returns the key of the object implementing this interface by a certain method.
	 * @return The key of this object.
	 */
	public int getKey();
}
