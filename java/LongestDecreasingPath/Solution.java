import java.io.*;
import java.util.*;
import java.awt.Point;

/*
Given a 2D int array, find the length of the longest decreasing path. You can move left, right, up and down.

[9,8,7],
[1,1,6],
[1,1,5],

Longest decreasing path is 9->8->7->6->5->1, with length 6

[1,1,1],
[1,9,1],
[1,5,9],

Longest decreasing path is 9->5->1, with length 3
*/
class Solution {
	private static int[][] dp = new int[][]{
    {0,0,0},
    {0,0,0},
    {0,0,0}};
  public static void main(String[] args) {
    int[][] matrix = new int[][]{
    {9,8,7},
    {2,1,6},
    {1,1,5}};
    
    int len = longestDecreasingPath(matrix);
    System.out.println("maxLength is: " + len);
  }
  
  public static int longestDecreasingPath(int[][] matrix) {
    /* Analysis
    * for each node, find its longest decreasing path using DFS
    * update the global longest decreasing path
    * Kind of brute force
    * 
    * Think about potential optimization...none I can think of. Go ahead
    */
    if(matrix == null || matrix.length == 0) {
      return 0;
    }
    
    int width = matrix[0].length;
    int height = matrix.length;
    int maxLength = 0;
    
    for (int j = 0; j < height; j++) {
      for (int i = 0; i < width; i++) {
        boolean[][] visited = new boolean[height][width];
        //Solution.length = 0; // Reset length for each time
        ArrayList <Integer> queue = new ArrayList <Integer> ();
        //queue.add(matrix[j][i]);

        //int length = DFS(i, j, matrix, visited, queue);
				int length = DFS_DP(i, j, matrix, visited, queue);
				System.out.println("DP length is: " + length);
        //int length = DFS_iterative(i, j, matrix, visited, queue);
        //System.out.println("Finish scanning one...");
        
        
        if(length > maxLength) { // Update max length if needed
          maxLength = length;
          System.out.println("inside maxLength is: " + maxLength);
        }
        
      }
    }
    
    
    return maxLength;
  }
  
  private static int length = 0;
/* Below wont work
  private static int DFS_iterative(int x1, int y1, int[][] matrix, boolean[][] visited, ArrayList <Integer> queue) {
    int width = matrix[0].length;
    int height = matrix.length;
   
    Stack <Point> stack = new Stack <Point> (); // For DFS cache
    stack.push(new Point(x1, y1));
        
    queue = new ArrayList <Integer>();
    
    while(!stack.isEmpty()) {
      Point temp = stack.pop();
      int x = temp.x;
      int y = temp.y;
      

      
      // Visit the node
      visited[y][x] = true;
      //System.out.print("(" + x + ", " + y + ")");
      //System.out.print(matrix[y][x] + " ");
      queue.add(matrix[y][x]);
      
      // Try moving right, left and down decreasingly...
      boolean canMoveRight = false;
      boolean canMoveLeft = false;
      boolean canMoveDown = false;

      int length = 0;
      if (testNext(x, y, x + 1, y, matrix, visited)) {
        canMoveRight = true;
        stack.push(new Point(x + 1, y));
      }

      //newX--; // move left
      if (testNext(x, y, x - 1, y, matrix, visited)) {
        canMoveLeft = true;
        stack.push(new Point(x - 1, y));
      }

      //newY++; // move down
      if (testNext(x, y, x, y + 1, matrix, visited)) {
        canMoveDown = true;
        stack.push(new Point(x, y + 1));    
      }

      if (!canMoveRight && !canMoveLeft && !canMoveDown) { // One iteration has ended, hitting the wall
        System.out.println(queue);
        queue = new ArrayList <Integer> (queue);
        //queue.remove(queue.size() - 1);
        length = queue.size();
        Solution.length = length > Solution.length ? length : Solution.length;
				break;
      }
    }
    System.out.println();
    return Solution.length;
  }
 */
 
  private static int DFS_DP(int x, int y, int[][] matrix, boolean[][] visited, ArrayList <Integer> queue) {
		if(dp[y][x] != 0) {
			System.out.println("Found dp value for " + x + ", " + y + ": " + dp[y][x]);
			return dp[y][x];
		}
    int width = matrix[0].length;
    int height = matrix.length;
   
    //Stack <Point <Integer>> stack = new <Point <Integer>>Stack(); // For DFS cache
    //boolean[][] visited = new boolean[height][width];
    
    //int newX;
    //int newY;

    // Visit this node
    visited[y][x] = true;
    queue.add(matrix[y][x]);
              
    //System.out.print(matrix[y][x] + " ");
    //Solution.length++;
    //Copy the queue
    //ArrayList <Integer> queue = new ArrayList <Integer> (oldQueue);
    
    
    // Try moving right, left and down decreasingly...
    boolean canMoveRight = false;
    boolean canMoveLeft = false;
    boolean canMoveDown = false;
    
    int length = 0;
    //newX++; // move right
    if (testNext(x, y, x + 1, y, matrix, visited)) {
      canMoveRight = true;
      length = Math.max(length, 1+ DFS_DP(x + 1, y, matrix, visited, new ArrayList <Integer>(queue)));
    }
    
    //newX--; // move left
    if (testNext(x, y, x - 1, y, matrix, visited)) {
      canMoveLeft = true;
      length = Math.max(length, 1+ DFS_DP(x - 1, y, matrix, visited, new ArrayList <Integer>(queue)));
    }
    
    //newY++; // move down
    if (testNext(x, y, x, y + 1, matrix, visited)) {
      canMoveDown = true;
      length = Math.max(length, 1+ DFS_DP(x, y + 1, matrix, visited, new ArrayList <Integer>(queue)));    
    }
    
    if (!canMoveRight && !canMoveLeft && !canMoveDown) { // One iteration has ended, hitting the wall
      System.out.println(queue);
			//System.out.println("DP length is: " + length); Should print from outside, not here
      length = 1; // This is the last one, step is 1
      Solution.length = length > Solution.length ? length : Solution.length;
    }
        
    //return Solution.length;
		dp[y][x] = length;
		return length;
  }

  private static int DFS(int x, int y, int[][] matrix, boolean[][] visited, ArrayList <Integer> queue) {
    int width = matrix[0].length;
    int height = matrix.length;
   
    //Stack <Point <Integer>> stack = new <Point <Integer>>Stack(); // For DFS cache
    //boolean[][] visited = new boolean[height][width];
    
    //int newX;
    //int newY;

    // Visit this node
    visited[y][x] = true;
    queue.add(matrix[y][x]);
              
    //System.out.print(matrix[y][x] + " ");
    //Solution.length++;
    //Copy the queue
    //ArrayList <Integer> queue = new ArrayList <Integer> (oldQueue);
    
    
    // Try moving right, left and down decreasingly...
    boolean canMoveRight = false;
    boolean canMoveLeft = false;
    boolean canMoveDown = false;
    
    int length = 0;
    //newX++; // move right
    if (testNext(x, y, x + 1, y, matrix, visited)) {
      canMoveRight = true;
      length = DFS(x + 1, y, matrix, visited, new ArrayList <Integer>(queue));
    }
    
    //newX--; // move left
    if (testNext(x, y, x - 1, y, matrix, visited)) {
      canMoveLeft = true;
      length = DFS(x - 1, y, matrix, visited, new ArrayList <Integer>(queue));
    }
    
    //newY++; // move down
    if (testNext(x, y, x, y + 1, matrix, visited)) {
      canMoveDown = true;
      length = DFS(x, y + 1, matrix, visited, new ArrayList <Integer>(queue));    
    }
    
    if (!canMoveRight && !canMoveLeft && !canMoveDown) { // One iteration has ended, hitting the wall
      System.out.println(queue);
      length = queue.size();
      Solution.length = length > Solution.length ? length : Solution.length;
      /*
      for(int i = 0; i < queue.size(); i++) {
        System.out.print(queue.get(i) + " ");
      }
      */
      //System.out.println("Size is: " + length);
    }
        
    return Solution.length;
  }

  private static boolean testNext(int x, int y, int newX, int newY, int[][] matrix,
                                 boolean[][] visited) { 
    
    int width = matrix[0].length;
    int height = matrix.length;
    
    
    if(newX >= width || newX < 0 || newY >= height || newY < 0
      || matrix[newY][newX] >= matrix[y][x]
      || visited[newY][newX]) { // Out of boundary, or not decreasing, or visited already...
      //System.out.println("testNext fail, x: " + x + ", y: " + y + ", newX: " + newX + ", newY: " + newY);
      return false;
    }
    else { 
      //System.out.println("testNext OK, x: " + x + ", y: " + y + ", newX: " + newX + ", newY: " + newY);
      return true;
    }
    
  }
  /*
  private static int DFS(int x, int y, int[][] matrix) {
    int width = matrix[].length;
    int height = matrix.length;
   
    Stack <Point <Integer>> stack = new <Point <Integer>>Stack(); // For DFS cache
    boolean[][] visited = new boolean[height][width];
    
    int newX;
    int newY;

    
    // Try moving right, left and down decreasingly...
    newX++; // move right
    doWork(newX, newY, matrix);
    
    newX--; // move left
    doWork(newX, newY, matrix);
    
    newY++; // move down
    doWork(newX, newY, matrix);    

    //Add self to stack last since it's DFS...
    stack.push(new Point<Integer>(x, y));
    visited[x][y] = true;

    while(!stack.isEmpty()) {
      // Visit top of the stack
      Point <Integer> top = stack.pop();
      int x = top.x;
      int y = top.y;
      visited[x][y] = true;
      
      System.out.print(top + " "); // print the node in the current path
      
      // Update length here
      length++;
      
    }
  }
  
  
  private static void doWork(int newX, int newY, int[][] matrix) { //TODO: add stack here...
    
    if(newX >= width || newX < 0 || newY >= height || newY < 0
      ||matrix[newX, newY] >= matrix[x][y]) { // Out of boundary, or not decreasing...
     // May need to do something here... 
    }
    else { // Push into stack for later process
      stack.push(new Point <Integer> (newX, newY));
    }
    
  }
  */
}
