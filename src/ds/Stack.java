package ds;

/**
 * Stack class, a data structure that uses the LIFO order in its elements. Represented by a LinkedList with access restrictions, as its inserting and deleting operations can only be applied on the last element added in it.
 *
 * @param <E> As this data structure is meant to be used generically, E defines the type it'll use.
 * @author Jhon Edward Mora - Universidad ICESI - A00355710
 * @version 1.0 - 09/2019
 */
public class Stack<E> implements IStack<E> {

    /**
     * The LinkedList that represents this Stack
     */
    private LinkedList<E> ll;

    /**
     * Creates a new Stack and initialises its representative LinkedList.
     */
    public Stack() {
        ll = new LinkedList<>();
    }

    /**
     * Creates a new Stack and initialises its representative LinkedList, adding the given element as its first element.
     *
     * @param el The given element to be added as first element.
     */
    public Stack(E el) {
        ll = new LinkedList<>();
        ll.add(el);
    }

    /**
     * Retrieves and removes the top element of this stack.
     *
     * @return The element on top of this stack.
     * @throws EmptyException when the stack is empty or has no elements in it.
     */
    @Override
    public E pop() throws EmptyException {
        if (ll.getFirst() != null)
            return ll.removeFirst();
        else
            throw new EmptyException("This stack is empty.");
    }

    /**
     * Adds a new element to this stack, and places it at the top.
     *
     * @param e The element to be added to the stack.
     */
    @Override
    public void push(E e) {
        ll.linkAsFirst(e);
    }

    /**
     * Retrieves, but does not remove, the top element of this stack.
     *
     * @return The element on top of stack list.
     * @throws EmptyException when the stack is empty.
     */
    @Override
    public E peek() throws EmptyException {
        if (ll.getFirst() != null)
            return ll.getFirst();
        else
            throw new EmptyException("This stack is empty.");
    }

    /**
     * Determines whether or not this stack is empty.
     *
     * @return true if the stack has no elements in it, false if not.
     */
    @Override
    public boolean empty() {
        return ll.isEmpty();
    }
}
