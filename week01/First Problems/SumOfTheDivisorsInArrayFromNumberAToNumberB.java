import java.util.Scanner;

public class SumOfTheDivisorsInArrayFromNumberAToNumberB {
  
  public static int sumOfDivisors(int numberA, int numberB) {
    int sum = 0;
    for (int i = numberA; i <= numberB ; i++) {
      sum += i + 1;
      for (int j = 2; j <= i/2; j++) {
        if(i % j == 0) {
          sum += j;
        }
      }
    }
    return sum;
  }
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numberA = input.nextInt();
    int numberB = input.nextInt();
    System.out.println(sumOfDivisors(numberA, numberB));
  }

}
