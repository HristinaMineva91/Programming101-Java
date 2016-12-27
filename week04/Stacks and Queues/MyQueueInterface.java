package week31;

public interface MyQueueInterface<T> {
  /**
   * to push new element
   * 
   * @param element
   */

  public void enqueue(T item);

  /**
   * remove the element
   * 
   * @return
   */
  public T dequeue();

  /**
   * to see element
   * 
   * @return
   */
  public T peek();

  /**
   * to get the size of element
   * 
   * @return
   */
  public int getSize();

}
