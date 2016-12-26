package LinkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class MyLinkedListTest {

  public static void main(String[] args) {
    MyLinkedList<Integer> link = new MyLinkedList<Integer>();
    link.add(5, 4);
    link.add(4, 4);
    link.add(3, 3);
    link.add(2, 2);
    link.add(1, 1);
    link.peek();
  }
}
