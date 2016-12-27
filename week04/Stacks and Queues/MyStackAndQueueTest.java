package week31;

public class MyStackAndQueueTest {

  public static void main(String[] args) {
    MyStack stack = new MyStack(11);
    for (int i = 0; i < 10; i++) {
      stack.push(i);
      System.out.println(stack.getSize());
    }
    MyQueue queue = new MyQueue();
    for (int i = 0; i < 10; i++) {
      queue.enqueue(i);
      System.out.println(queue.getSize());
    }
  } 
}
