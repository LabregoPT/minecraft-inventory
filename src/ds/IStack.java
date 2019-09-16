package ds;

/**
 * Interface meant to display the abstract linear data structure Stack, in which uses the "FILO" retrieving order.
 *
 * @param <T> As Stack is meant to be used with any kind of object, T is the type parameter that will be used in this Stack
 * @author Andres Orozco Nu�ez - A00355202 - Universidad ICESI
 */
public interface IStack<T> {

    /**
     * Retrieves and removes the top element of this stack.
     *
     * @return The element on top of this stack.
     * @throws EmptyException when the stack is empty or has no elements in it.
     */
    T pop() throws EmptyException;

    /**
     * Adds a new element to this stack, and places it at the top.
     *
     * @param e The element to be added to the stack.
     */
    void push(T e);

    /**
     * Retrieves, but does not remove, the top element of this stack.
     *
     * @return The element on top of stack list.
     * @throws EmptyException when the stack is empty.
     */
    T peek() throws EmptyException;

    /**
     * Determines whether or not this stack is empty.
     *
     * @return true if the stack has no elements in it, false if not.
     */
    boolean empty();

}
