import java.util.Scanner;


public class FactorialDigits {
  public static int factorialDigits(int number) {
    if(number == 0) {
      return 1;
    }
    int factorial = 1;
    for (int i = 1; i <= number; i++) {
      factorial *= i;
    }
    return factorial;
  }
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int sum = 0;
    int fact;
    while(n != 0) {
      int num = n % 10;
      n /= 10;
      fact = factorialDigits(num);
      sum += fact;
    }
    System.out.println(sum);
  }

}
