package ds;

/**
 * Interface meant to serve as a bridge to provide the services which different Queues may provide. Implement this when coding a Queue.
 * @author Jhon Edward Mora - Universidad ICESI - A00355710
 * @version 1.0 - 09/2019
 * @param <E> As a queue is meant to work as a set of every kind of class, E is the class type to be used in this queue.
 */
public interface IQueue<E> {

	/**
	 * Adds a given element to this queue and places it in the last spot.
	 * @param e The given element to be added.
	 */
	void enqueue(E e);
	
	/**
	 * Removes the first element of this queue.
	 * @return The element that has just been dequeued.
	 * @throws EmptyException When this queue is empty or has no items in it.
	 */
	E dequeue() throws EmptyException;
	
	/**
	 * Retrieves, but does not remove, the first element of this queue.
	 * @return first element of this queue.
	 * @throws EmptyException When this queue is empty or has no items in it.
	 */
	E front() throws EmptyException;
	
	/**
	 * Retrieves, but does no remove, the last element of this queue.
	 * @return last element of this queue.
	 * @throws EmptyException When this queue is empty or has no items in it.
	 */
	E rear() throws EmptyException;
	
	/**
	 * Determines whether or not this list is empty.
	 * @return true when this queue has no items, false if not.
	 */
	boolean isEmpty();
}
