import java.io.*;
import java.util.*;

/*
    Spiral print of a matrix
    
    Define a method, which takes a rectangular matrix, and
    does a spiral print of its contents.
    
    See below for example matrices and the expected output.
    
    Note: Please make sure to handle rectangular matrices
    with non-equal number of columns and rows.
    
    Given:
    0  1  2  3
    4  5  6  7
    8  9  10 11
    12 13 14 15
    
    Output:
    0 1 2 3 7 11 15 14 13 12 8 4 5 6 10 9
    
    
    0  1  2  3  4
    5  6  7  8  9
    10 11 12 13 14
    15 16 17 18 19
    20 21 22 23 24
    
    Output:
    0 1 2 3 4 9 14 19 24 23 22 21 20 15 10 5 6 7 8 13 18 17 16 11 12
    
    
    0  1  2  3  4  5
    17 18 19 20 21 6
    16 27 28 29 22 7
    15 26 25 24 23 8
    14 13 12 11 10 9
    
    Output:
    0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29
     

Coderpad Docs:
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  
  public static void main(String[] args) {
    
    /* Analysis
    * Start from (0, 0), width is M, height is N
    * print towards right until hitting the wall
    * print downwards util hitting the wall
    * print towards left until hitting the wall
    * print upwards until hitting the wall, here, stop right before reaching the start point
    * Set start point by x + 1 and y + 1, M and N -2
    * hitting the wall meaning the index in question is at the max position
    * Be careful about the boundaries
    */
    
    
    int[][] array1 = new int[][] {{0, 1, 2, 3}, 
                                 {4, 5, 6, 7},
                                 {8,  9,  10, 11},
                                 {12, 13, 14, 15}};
    
    int[][] array2 = new int[][] { {0, 1, 2, 3, 4 }, 
                                 {5, 6, 7, 8, 9 }, 
                                 {10, 11, 12, 13, 14}, 
                                 {15, 16, 17, 18, 19}, 
                                 {20, 21, 22, 23, 24}, };   
    
    int[][] array3 = new int[][] { {0, 1,   2,  3,  4, 5}, 
                                 {17, 18, 19, 20, 21, 6}, 
                                 {16, 27, 28, 29, 22, 7}, 
                                 {15, 26, 25, 24, 23, 8}, 
                                 {14, 13, 12, 11, 10, 9} };
    
    printArraySpiral(array1);
    printArraySpiral(array2);
    printArraySpiral(array3);
    /* //move below to a function
    int startX = 0;
    int startY = 0;
    int endX = array[0].length;
    int endY = array.length;
    
    //System.out.println("Before - startX is: " + startX + ", startY is: " + startY + ", endX is: " + endX + ", " + "endY is: " + endY);
    
    while(endX > 0 && endY > 0) {
      printOneCircle(startX, startY, endX, endY, array);
      startX += 1;
      startY += 1;
      endX -= 1;
      endY -= 1;
      //System.out.println("After - startX is: " + startX + ", startY is: " + startY + ", endX is: " + endX + ", " + "endY is: " + endY);
    }
    */
  }
  
  private static void printArraySpiral(int[][] array) {
    int startX = 0;
    int startY = 0;
    int endX = array[0].length;
    int endY = array.length;
    
    //System.out.println("Before - startX is: " + startX + ", startY is: " + startY + ", endX is: " + endX + ", " + "endY is: " + endY);
    
    while(endX > 0 && endY > 0) {
      printOneCircle(startX, startY, endX, endY, array);
      startX += 1;
      startY += 1;
      endX -= 1;
      endY -= 1;
      //System.out.println("After - startX is: " + startX + ", startY is: " + startY + ", endX is: " + endX + ", " + "endY is: " + endY);
    }  
    System.out.println("");
  }
  
  private static void printOneCircle(int startX, int startY, 
                                     int endX, int endY, int[][] array) {
  
    
    // All validity checks should be done outside, so skip the checks here...
    // print towards right
    //System.out.print("right: ");
    boolean hasAnythingDone = false;
    for (int i = startX; i < endX; i++) {
      System.out.print(array[startY][i]);
      System.out.print(" "); // TODO: not need it at the last item, handle later
      hasAnythingDone = true;
    }
    
        // if it's the last row or column already, then no need to go further
    if(!hasAnythingDone) {
      return;
    }
    
    hasAnythingDone = false;
    
    // print towards down
    //System.out.print("down: ");
    for (int i = startY + 1; i < endY; i++) { // TODO: handle boundary here
      System.out.print(array[i][endX - 1]);
      System.out.print(" "); // TODO: not need it at the last item, handle later
      hasAnythingDone = true;
    }
    
    //Check the situation where no left any more needed
    if(!hasAnythingDone) {
      return;
    }
       
    hasAnythingDone = false;
    // print towards left
    //System.out.print("left: ");
    for (int i = endX - 2; i >= startX; i--) { // TODO: handle boundary here
      System.out.print(array[endY - 1][i]);
      System.out.print(" "); // TODO: not need it at the last item, handle later
      hasAnythingDone = true;
    }
    
    //Check the situation where no up any more needed
    if(!hasAnythingDone) {
      return;
    }    
    
    hasAnythingDone = false;
    // print towards up, but print one less
    //System.out.print("up: ");
    for (int i = endY - 2; i > startY; i--) {
      System.out.print(array[i][startX]);
      System.out.print(" "); // TODO: not need it at the last item, handle later
      hasAnythingDone = true;
    }
    
    //System.out.println("");
    
    if(!hasAnythingDone) {
      return;
    }
  }
  
  private static boolean checkValidity(int startX, int startY, 
                                int endX, int endY) {
      // if it's the last row, then no need to go further
    if(startY < endY - 1 || startX < endX - 1) {
      return false;
    }
    
    return true;
  }
}
