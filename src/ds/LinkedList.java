package ds;

/**
 * A doubly-linked list class that allows functionalities of both Queues and Stacks. Indices are 0-based.
 *
 * @param <E> the type of elements in the list
 * @author Gabriel Cruz - Universidad ICESI - A00056020
 * @version 1.1 - 09/2019
 */

public class LinkedList<E> implements IList<E> {

    /**
     * The current size of this list.
     */
    private int size = 0;

    /**
     * Pointer to first node.
     * Invariant: (first == null && last == null) ||
     * (first.prev == null && first.item != null)
     */
    private Node<E> first;

    /**
     * Pointer to last node.
     * Invariant: (first == null && last == null) ||
     * (last.next == null && last.item != null)
     */
    private Node<E> last;

    /**
     * Constructs an empty list.
     */
    public LinkedList() {
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Links e as the first element in the list.
     */
    public void linkAsFirst(E e) {
        add(0, e);
    }

    /**
     * Links e as the last element in the list.
     */
    public void linkAsLast(E e) {
        add(size - 1, e);
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns true if the list contains the specified element.
     *
     * @param element element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    @Override
    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    /**
     * Adds the specified element to the end of the list.
     *
     * @param e element to be appended to the list
     * @return true if the specified element was successfully added. False otherwise
     */
    @Override
    public boolean add(E e) {
        last.next = new Node<>(last, e, null);
        last = last.next;
        size++;
        return true;
    }

    /**
     * Removes the specified element from the list.
     *
     * @return true if the element was removed. False if the list didn't contain the element
     */
    @Override
    public boolean remove(E o) {
        for (Node<E> x = first; x != null; x = x.next) {
            if (o.equals(x.item)) {
                if (x.prev != null) {
                    x.prev.next = x.next;
                }
                x.next.prev = x.prev;
                size--;
                return true;
            }
        }
        return false;
    }

    /**
     * Removes all of the elements from the list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Returns the element at the specified position in the list.
     *
     * @param i index of the element to return
     * @return the element at the position specified by the index in the list
     */
    @Override
    public E get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        for (Node<E> x = first; x != null; x = x.next) {
            if (counter == i) {
                return x.item;
            }
            counter++;
        }
        return null;
    }

    /**
     * Replaces the element at the given index with the specified element.
     *
     * @param i index of the element to be replaced
     * @param o element to be substituted with
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @SuppressWarnings("unchecked")
    @Override
    public void set(int i, Object o) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        Node<E> element = new Node(null, o, null);
        for (Node<E> x = first; x != null; x = x.next) {
            if (counter == i) {
                if (counter == 0) {
                    first = element;
                }
                if (counter == size - 1) {
                    last = element;
                }
                if (x.prev != null) {
                    x.prev.next = element;
                }
                element.prev = x.prev;
                element.next = x.next;
            }
            counter++;
        }
    }

    /**
     * Adds the specified element at the given index. The element at the given index (if any) and any subsequent ones
     * are shifted one position to the right (adds one to their indices).
     *
     * @param i index at which the specified element is to be inserted
     * @param o element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @SuppressWarnings("unchecked")
    @Override
    public void add(int i, Object o) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        Node<E> element = new Node(null, o, null);
        for (Node<E> x = first; x != null; x = x.next) {
            if (counter == i) {
                if (counter == 0) {
                    first = element;
                }
                if (counter == size - 1) {
                    last = element;
                }
                element.prev = x.prev;
                element.next = x;
                if (x.prev != null)
                    x.prev.next = element;
                x.prev = element;
                size++;
            }
            counter++;
        }
    }

    /**
     * Removes the element at the given index from the list. All subsequent elements are shifted one position to the
     * left (removes one from their indices).
     *
     * @param i the index of the element to be remove
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void remove(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        for (Node<E> x = first; x != null; x = x.next) {
            if (counter == i) {
                if (counter == 0) {
                    first = x.next;
                }
                if (counter == size - 1) {
                    last = x.prev;
                }
                if (x.prev != null) {
                    x.prev.next = x.next;
                }
                if (x.next != null) {
                    x.next.prev = x.prev;
                }
                size--;
            }
            counter++;
        }
    }

    /**
     * Returns the position at which the given object is located in the list. If there are multiple occurrences, only
     * the first one is considered.
     *
     * @param o element to be searched
     * @return the index of the element, if found. Returns -1 otherwise
     */
    @Override
    public int indexOf(Object o) {
        int index = 0;
        for (Node<E> x = first; x != null; x = x.next) {
            if (o.equals(x.item))
                return index;
            index++;
        }
        return -1;
    }

    /**
     * Removes the first element in this list, and places the second element in its place.
     *
     * @return The first element in this list.
     */
    public E removeFirst() {
        E currentFirst = null;
        if (size != 0) {
            currentFirst = first.item;
            if (size > 1) {
                first.next.prev = null;
                first = first.next;
                size--;
            } else if (size == 1) {
                clear();
            }
        }
        return currentFirst;
    }

    /**
     * Retrieves, but does not remove, the first element in this list.
     *
     * @return The first element in this list.
     */
    public E getFirst() {
        E currentFirst = null;
        if (first != null) {
            currentFirst = first.item;
        }
        return currentFirst;
    }

    /**
     * Retrieves, but does not remove, the last element in this list.
     *
     * @return The last element in this list.
     */
    public E getLast() {
        E currentLast = null;
        if (last != null) {
            currentLast = last.item;
        }
        return currentLast;
    }

    /**
     * Auxiliary class meant to represent each node in the linked list.
     *
     * @param <E> The class that each of these nodes will represent.
     * @author Gabriel Cruz - Universidad ICESI - A00056020
     */
    private static class Node<E> {

        /**
         * The element each of these nodes is representing.
         */
        E item;

        /**
         * Next node in the linked list.
         */
        Node<E> next;

        /**
         * Previous node in the linked list.
         */
        Node<E> prev;

        /**
         * Constructor method, initialises an instance of this class.
         *
         * @param prev    The previous node in the linked list.
         * @param element The object this node is representing.
         * @param next    The next node in the linked list.
         */
        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
