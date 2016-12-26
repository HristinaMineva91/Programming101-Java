import java.util.Scanner;


public class FibonacciSequence {

  public static int fibonacciSequence(int n) {
    int a0 = 1;
    int a1 = 1;
    if(n == 1) {
      return 1;
    }
    if(n == 2) {
      return 11;
    }
    String fib = "11";  
    for (int i = 3; i <= n; i++) {
      int a = a0 + a1;
      fib += a;
      a0 = a1;
      a1 = a;
    }
    return Integer.parseInt(fib);
  }


  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    System.out.println(fibonacciSequence(n));
  }

}
