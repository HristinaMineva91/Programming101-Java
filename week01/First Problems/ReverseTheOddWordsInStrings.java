import java.util.Scanner;


public class ReverseTheOddWordsInStrings {
  public static String reverseWords(String word) {
    StringBuilder strBuilder = new StringBuilder();
    char[] strChars = word.toCharArray();
    for (int i = strChars.length - 1; i >= 0; i--) {
      strBuilder.append(strChars[i]);
    }
    return strBuilder.toString();
  }
  public static String reverseOddWords(String sentence) {
    String[] words = sentence.split(" ");
    String result = "";
    for (int i = 0; i < words.length; i++) {
      if((i+1) % 2 == 0) {
        result += reverseWords(words[i]) + " ";
      } else {
        result += words[i] + " ";
      }
    }
    return result;
  }
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String n = input.nextLine();
    System.out.println(reverseOddWords(n));

  }

}
