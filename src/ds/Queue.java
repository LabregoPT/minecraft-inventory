package ds;

/**
 * Class used to represent different Queues used along different instances and programs. Each queue handles input and output of elements as FIFO (First In, Fast Out) as the model to handle information in this structure. 
 * @author Jhon Edward Mora - Universidad ICESI - A00355710
 * @version 1.0 - 09/2019
 * @param <E> Every subclass of object. This generic class is meant to be used with any object created.
 */
public class Queue<E> implements IQueue<E>{
	
	/**
	 * This list will represent the queue as it adds objects
	 */
	private LinkedList<E> ll;
	
	/**
	 * Instantiates the Queue and its representative linked list.
	 */
	public Queue() {
		ll = new LinkedList<>();
	}
	
	/**
	 * Creates a new queue and places the given element to the front of it.
	 * @param e given element.
	 */
	public Queue(E e) {
		ll = new LinkedList<>();
		ll.add(e);
	}
	
	/**
	 * Enqueues a new element to this queue. Basically adds an element to the last index of the linked list.
	 * @param e The element to be enqueued.
	 */
	@Override
	public void enqueue(E e) {
		ll.add(e);
	}
	
	/**
	 * Removes the first element of this queue.
	 * @return The element that has just been dequeued.
	 * @throws EmptyException when this queue is empty and nothing can't be dequeued of it.
	 */
	public E dequeue() throws EmptyException{
		if(!ll.isEmpty()) {
			return ll.removeFirst();
		}else {
			throw new EmptyException("Queue is empty");
		}
	}
	
	/**
	 * Retrieves, but does not remove, the first element of this queue.
	 * @return The first element of the linked list that represents this queue.
	 * @throws EmptyException when the queue has no elements in it.
	 */
	public E front() throws EmptyException{
		if(ll.getFirst() != null)
			return ll.getFirst();
		else
			throw new EmptyException("This queue is empty.");
	}
	
	/**
	 * Retrieves, but does not remove, the last element of this queue.
	 * @return The last element of the linked list that represents this queue.
	 * @throws EmptyException when the queue has no elements in it.
	 */
	public E rear() throws EmptyException{
		if(ll.getLast() != null)
			return ll.getLast();
		else
			throw new EmptyException("This queue is empty.");
	}
	
	/**
	 * Determines whether or not this list is empty.
	 * @return whether or not the list represented by this queue is empty.
	 */
	public boolean isEmpty() {
		return ll.isEmpty();
	}
}


