import java.util.Scanner;

public class IsAGivenNumberPalindrome {

  public static boolean isPalindrome(int number) {
    int palindrome = number;
    int reverse = 0;
    while(palindrome != 0) {
      int remainder = palindrome % 10;
      reverse = 10 * reverse + remainder;
      palindrome /= 10;
    }
    if(number == reverse) {
      return true;
    }
    return false;
  }
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int palindrome = input.nextInt();
    if(isPalindrome(palindrome)) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }
  }

}
