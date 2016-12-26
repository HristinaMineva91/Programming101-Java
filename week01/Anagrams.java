import java.util.ArrayList;
import java.util.Scanner;

public class Anagrams {

  public static boolean areAnagrams(String a, String b) {
    String phrase1 = a;
    phrase1 = phrase1.toLowerCase().trim();
    char[] phrase1Arr = phrase1.toCharArray();
    
    String phrase2 = b;
    phrase2 = phrase2.toLowerCase().trim();
    ArrayList<Character> phrase2ArrList = coverStringToArrayList(phrase2);
    if(phrase1.length() != phrase2.length()) {
      System.out.println("NOT ANAGRAMS");
    } else {
      boolean isFound = true;
      for (int i = 0; i < phrase1Arr.length; i++) {
        for (int j = 0; j < phrase2ArrList.size(); j++) {
          if(phrase1Arr[i] == phrase2ArrList.get(j)) {
            System.out.print("ANAGRAMS\n");
            isFound = true;
            phrase2ArrList.remove(j);
            return true;
          }
          if(isFound == false) {
            System.out.println("NOT ANAGRAMS");
          }
        }
      }
    }
    return false;
  }
  public static ArrayList<Character> coverStringToArrayList(String str) {
    ArrayList<Character> charList = new ArrayList<Character>();
    for (int i = 0; i < str.length(); i++) {
      charList.add(str.charAt(i));
    }
    return charList;
  }
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String a = input.nextLine();
    String b = input.nextLine();
    System.out.println(areAnagrams(a, b));
  }

}
