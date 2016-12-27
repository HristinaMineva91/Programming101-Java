package week31;

public class MyStack<T> implements MyStackInterface<T> {

  public static int max;
  private int number;
  private T[] stack;

  public MyStack(int size) {
    number = 0;
    stack = (T[]) (new Object[size]);
    max = size;
  }

  public boolean isFull() {
    if (number == max - 1) {
      return true;
    }
    return false;
  }

  public boolean isEmpty() {
    if (number <= 0) {
      return true;
    }
    return false;
  }

  @Override
  public void push(T element) {
    if (!isFull()) {
      stack[number++] = (T) element;
    }
  }

  public T pop() {
    T aux = (T) (new Object());
    if (!isEmpty()) {
      aux = stack[number];
      stack[number] = null;
      number--;
    }
    return aux;
  }
  
  public T peek() {
    if(isEmpty()) {
      return null;
    }
    return stack[number];
  }

  public int getSize() {
    return max;
  }
}
