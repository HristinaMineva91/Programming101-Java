package week6;

public class MyBubbleSort {

  public static void bubbleSort(int[] array) {
    int n = array.length;
    int k;
    for (int i = n; i >= 0; i--) {
      for (int j = 0; j < n - 1; j++) {
        k = j + 1;
        if(array[j] > array[k]) {
          swapNumbers(j, k, array);
        }
      }
    }
    printNumbers(array);
  }
  
  private static void swapNumbers(int i, int j, int[] array) {
    int temp;
    temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
  
  private static void printNumbers(int[] input) {
    for (int i = 0; i < input.length; i++) {
      System.out.print(input[i] + " ");
    }
    System.out.println("\n");
  }
  
  public static void main(String[] args) {
    int[] input = new int[] {4, 2, 9, 6, 23, 12, 34, 0, 1};
    bubbleSort(input);
  }

}
