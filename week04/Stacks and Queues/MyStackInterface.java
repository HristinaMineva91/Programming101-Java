package week31;

public interface MyStackInterface<T> {
  /**
   * to push new element
   * 
   * @param element
   */

  public void push(T element);

  /**
   * remove the element
   * 
   * @return
   */
  public T pop();

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
