package week6;

import java.util.Arrays;

public class MyCountingSort {

  public static void countingSort(int[] a, int low, int high) {
    int[] counts = new int[high - low + 1];
    for(int x : a) {
      counts[x - low]++;
    }
    int current = 0;
    for (int i = 0; i < counts.length; i++) {
      Arrays.fill(a, current, current + counts[i], i + low);
      current += counts[i];
    }
  }
  public static void main(String[] args) {
    int[] arr1 = new int[] {4, 2, 9, 6, 23, 12, 34, 0, 1};
    int low = 0;
    int high = 34;
    countingSort(arr1, low, high);
    for (int i = 0; i < arr1.length; i++) {
      System.out.print(arr1[i] + " ");
    }
  }
}
