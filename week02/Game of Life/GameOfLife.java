package gameOfLife;

import java.util.Scanner;

public class GameOfLife {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    input.nextLine();
    String[] lines = new String[n];
    String[][] matrix = new String[20][20];
    for (int i = 0; i < n; i++) {
      lines[i] = input.nextLine();
    }
    matrix = firstDraw(matrix, lines);
    while(true) {
      draw(matrix);
    }
  

  }
  public static String[][] firstDraw(String[][] matrix, String[] lines) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[i][j] = "□ ";
      }
    }
    for (int i = 0; i < lines.length; i++) {
      String[] result = lines[i].split(" ");
      int x = Integer.valueOf(result[0]);
      int y = Integer.valueOf(result[1]);
      matrix[x][y] = "■ ";
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j]);
      }
      System.out.println();
    }
    return matrix;
  }
  
  
  public static void draw(String[][] matrix) {
    boolean[][] live = new boolean[20][20];
    for (int i = 0; i < matrix.length; i++) {
      int count = 0;
      int n = 0;
      for (int j = 0; j < matrix[0].length; j++) {
        String current = matrix[i][j];
        
        
        if(current.equals("■ ")) count++;
        if (j > 0) {
          String left = matrix[i][j-1];
          if(left.equals("■ ")) count++;
        }
        if (i > 0 && (j < matrix[0].length - 1)) {
          String right = matrix[i][j+1];
          if(right.equals("■ ")) count++; 
        }
        if (i > 0) {
          String up = matrix[i-1][j];
          if(up.equals("■ ")) count++; 
        }
        if (i < matrix.length - 1) {
          String down = matrix[i+1][j];
          if(down.equals("■ ")) count++; 
        }
        if (i > 0 && (j < matrix[0].length -1)) {
          String upRightD = matrix[i-1][j+1];
          if(upRightD.equals("■ ")) count++;
        }
        if (i > 0 && j > 0) {
          String upLeftD = matrix[i-1][j-1];
          if(upLeftD.equals("■ ")) count++;
        }
        if ((i < matrix.length - 1) && j > 0) {
          String downRightD = matrix[i+1][j-1];
          if(downRightD.equals("■ ")) count++; 
        }
        if ((i < matrix.length-1) && (j < matrix.length - 1)) {
          String downLeftD = matrix[i+1][j+1];
          if(downLeftD.equals("■ ")) count++; 
        }
        n = j;
      }
      if(count < 2) {
        live[i][n] = false;
      } else {
        if(count == 2 || count == 3) {
          live[i][n] = true;
        } else if(count > 3){
          live[i][n] = false;
        }
      }
    }
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if(live[i][j] == true) {
          matrix[i][j] = "■ ";
        }
      }
    }
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j]);
      }
      System.out.println();
    }
  }
}
