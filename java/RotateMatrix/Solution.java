import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 
 Rotate Matrix 
 
 matrix 
 1, 2 ,3 
 3, 4 ,6
 7, 8, 9
 
 
 output 
 7, 3, 1
 8, 4, 2
 9, 6, 3
 
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
		/*
			ArrayList<String> strings = new ArrayList<String>();
			strings.add("Hello, World!");
			strings.add("Welcome to CoderPad.");
			strings.add("This pad is running Java 8.");

			for (String string : strings) {
				System.out.println(string);
			}
		}
		*/
		
		/* Analysis
		* Need to replace top right with top left, and so on
		* Use in-place rotation, No need for extra space like temp array, except for just a temp int
		*/
		
		/*
		int[][] matrix = {{1, 2 ,3},
											{4, 5 ,6},
											{7, 8, 9}};
		*/
		int[][] matrix = {{1,  2 , 3,  4},
											{5 , 6,  7,  8},
											{9,  10, 11, 12},
											{13, 14, 15, 16}};
		
		
		// Check null for matrix

		if(matrix == null) {
			System.out.println("Width and height of the matrix not equal!!!");
			return;
		}
			//Rotate the outer circle first
		// Save right top to temp as it will be replaced first
		int width = matrix[0].length;
		int height = matrix.length;
		// For rotation to work, width must be equal, so check here...
		if (width != height) {
			System.out.println("Width and height of the matrix not equal!!!");
			return;
		}
		
		
		// Now rotate the entire outer corner - done
		// Now handle the inner circles
		// Now put below logic into a function, so we can use it for both outer and inner circles
		/*
		for(int i = 0; i < width - 1; i++) {
			int temp = matrix[0][i];
			matrix[0][i] = matrix[height - 1 - i][0];
			matrix[height -i - 1][0] = matrix[height - 1][width - i - 1];
			matrix[height - 1][width - i - 1] = matrix[i][width - 1];
			matrix[i][width - 1] = temp;
		}
		*/
		for(int i = 0; i < width / 2 ; i++) {
			rotateOneCircle(matrix, i, i, width - i, width - i);
		}
		printMatrix(matrix);
			
		
		// Rotate inner circles later until all exhausted
	
										
	
	}	
	private static void rotateOneCircle(int[][] matrix, int startX, int startY, int endX, int endY) {
		//int width = matrix[0].length;
		//int height = width;
		for(int i = startX; i < endX - 1; i++) {
			int temp = matrix[startY][startX + i];
			matrix[startY][startX + i] = matrix[endY - 1 - i][startX];
			matrix[endY -i - 1][startX] = matrix[endY - 1][endX - i - 1];
			matrix[endY - 1][endX - i - 1] = matrix[startY + i][endX - 1];
			matrix[startY + i][endX - 1] = temp;
		}
		
		
	}
	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
}
