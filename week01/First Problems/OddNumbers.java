import java.util.Scanner;

public class OddNumbers {

  public static boolean isNumberOdd(int odd) {
    return odd % 2 == 0;
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    if (!isNumberOdd(n)) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }
  }

}
