package ds;

/**
 * An interface that gives its user precise control over the location of each element in the list. The user can access
 * any element directly through its index, and search for any element currently contained in the list.
 *
 * @param <E> the type of elements in the list
 * @author Gabriel Cruz - Universidad ICESI - A00056020
 * @version 1.0 - 09/2019
 */

public interface IList<E> {
    //Query Operations

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    int size();

    /**
     * Indicates if the list contains no elements.
     *
     * @return true if the list is empty. False otherwise
     */
    boolean isEmpty();

    /**
     * Returns true if the list contains the specified element.
     *
     * @return true if element E is contained. False otherwise
     */
    boolean contains(E element);//TODO: Determinar si usar 'Object' o 'E' para el tipo.


    //Modification Operations

    /**
     * Adds the specified element to the end of the list.
     *
     * @param e element to be appended to the list
     * @return true if the specified element was successfully added. False otherwise
     */
    boolean add(E e);

    /**
     * Removes the specified element from the list.
     *
     * @return true if the element was removed. False if the list didn't contain the element
     */
    boolean remove(E e);


    // Bulk Modification Operations

    /**
     * Removes all of the elements from the list.
     * The list will be empty after this call returns.
     */
    void clear();


    // Positional Access Operations

    /**
     * Returns the element at the specified position in the list.
     *
     * @param i index of the element to return
     * @return the element at the position specified by the index in the list
     */
    E get(int i);

    /**
     * Replaces the element at the given index with the specified element.
     *
     * @param i index of the element to be replaced
     * @param e element to be substituted with
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    void set(int i, E e) throws Exception;

    /**
     * Adds the specified element at the given index. The element at the given index (if any) and any subsequent ones
     * are shifted one position to the right (adds one to their indices).
     *
     * @param i index at which the specified element is to be inserted
     * @param e element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    void add(int i, E e);

    /**
     * Removes the element at the given index from the list. All subsequent elements are shifted one position to the
     * left (removes one from their indices).
     *
     * @param i the index of the element to be remove
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    void remove(int i);


    // Search Operations

    /**
     * Returns the position at which the given object is located in the list. If there are multiple occurrences, only
     * the first one is considered.
     *
     * @param o element to be searched
     * @return the index of the element, if found. Returns -1 otherwise
     */
    int indexOf(Object o);//TODO: Determinar si usar 'Object' o 'E' para el tipo.
}