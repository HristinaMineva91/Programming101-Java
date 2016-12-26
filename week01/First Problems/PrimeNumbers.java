import java.util.Scanner;


public class PrimeNumbers {

  public static boolean isPrimeNumbers(int number) {
    int n = 0;
    if(number == 2) {
      return true;
    }
    for (int i = 3; i*i < number; i+=2) {
      if(number % i == 0) {
        return false;
      } 
    }
    return true;
  }
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int num = input.nextInt();
    if(isPrimeNumbers(num)) {
      System.out.println("True");
    } else {
      System.out.println("False");
    }
  }

}
