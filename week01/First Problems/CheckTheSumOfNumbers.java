import java.util.Scanner;

public class CheckTheSumOfNumbers {

  public static int reversedNumber(int number) {
    int n = number;
    int reversed = 0;
    while (n != 0) {
      int remainder = n % 10;
      reversed = 10 * reversed + remainder;
      n /= 10;
    }
    return reversed;
  }

  public static boolean isSumPalindrome(int input) {
    int sum = 0;
    sum = input + reversedNumber(input);
    if (sum == reversedNumber(sum)) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    System.out.println(isSumPalindrome(n));
  }

}
