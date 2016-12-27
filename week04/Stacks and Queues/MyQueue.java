package week31;

import java.util.NoSuchElementException;

public class MyQueue<T> implements MyQueueInterface<T>{
  private int n;
  private Node first;
  private Node last;
  
  // helper linked list class
  public class Node {
    private T item;
    private Node next;
  }

  /**
     * Initializes an empty queue.
     */
  public MyQueue() {
    first = null;
    last = null;
    n = 0;
  }
  
   /**
     * Returns true if this queue is empty.
     *
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
  public boolean isEmpty() {
    return first == null;
  }
  
   /**
     * Add the item to the queue.
     */
  
  @Override
  public void enqueue(T item) {
    Node oldlast = last;
    last = new Node();
    last.item = item;
    last.next = null;
    if(isEmpty()) {
      first = last;
    } else {
      oldlast.next = last;
    }
    n++;
  }

  /**
     * Removes and returns the item on this queue that was least recently added.
     *
     * @return the item on this queue that was least recently added
     * @throws NoSuchElementException if this queue is empty
     */
  @Override
  public T dequeue() {
    if(isEmpty()) {
      throw new NoSuchElementException("Queue underflow");
    }
    T item = first.item;
    first = first.next;
    n--;
    if(isEmpty()) {
      last = null;
    }
    return item;
    }

  /**
     * Returns the item least recently added to this queue.
     *
     * @return the item least recently added to this queue
     * @throws NoSuchElementException if this queue is empty
     */
  @Override
  public T peek() {
    if(isEmpty()) {
      throw new NoSuchElementException("Queue underflow");
    }
    return first.item;
  }

  /**
     * Returns the number of items in this queue.
     *
     * @return the number of items in this queue
     */
  @Override
  public int getSize() {
    return n;
  }
}
