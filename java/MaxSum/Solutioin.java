import java.io.*;
import java.util.*;

/**
 * Given a list of integers (positives and negatives)
 * Find the sequence of numbers (sub array) with the largest sum.
 *
 * Just return the sum
 *
 * E.g
 * [5]                      -> 5
 * [1, 2, 3]                -> 6
 * [-5, 6, -2, 20, 30]      -> 54 (sequence is the last 4 numbers)
 * [4, -9, 3, -2, 4, -12]   -> 5  (sequence is 3, -2, 4)
 * [-9, -3, -2, -12]        -> -2
 *
 * @param array list of integers (positives and/or negatives)
 * @return the max sum (or 0 if null or empty array)
 */
class Solution {
  static int maxSum = 0;
  
  public static int find(int[] array) {

    /* Analysis
    If a positive number is part of the sum, then its adjacent positive number must also be in
    If a negative number is part of the sum, like 9, -1, -2, 9
      that means there must be a positive number to make the sum bigger, and its adjacent negative must be also in
    So we should merge the adjacent positives and negatives
    */
    // merge adjacent positives and negatives
    
    ArrayList <Integer> list = mergeAdjacent(array);
    System.out.println("After meging the array is: " + list);
    
    
    /* Analysis
    0 can be removed from the array
    Leading negative and trailing negative can also be removed
    */
    if (list.size() > 0 && list.get(0) < 0) {
      list.remove(0);
    }
    
    if (list.size() > 0 && list.get(list.size() - 1) < 0) {
      list.remove(list.size() - 1);
    }
      
    System.out.println("After removing leading and trialing negatives the array is: " + list);
    

    // convert ArrayList to array
    if (list == null || list.size() == 0) { // handle empty case, should not really happen
      return Integer.MIN_VALUE;
    }
    
    int[] newArray = new int[list.size()];
    for (int j = 0; j < list.size(); j++) {
      newArray[j] = list.get(j);
      //System.out.println(result[j]);
    }
    
    
    // Here we should get an array alternating positive/negative
    // Special case: empty array
    // Special case: just one element in array
    
    //Now starting from beginning, iterate the array
    Solution.maxSum = newArray[0]; // the initial max value is the first one
    
    // Run the iteration until end, or the runningSum <=0, update the max if needed
    
    // Reset the start point to where the previous iteration ends, repeat. Update the maxSum
    int nextIndex = 0;
    while (nextIndex < newArray.length) {
      nextIndex = findMaxIteration(newArray, nextIndex); 
      System.out.println("Next index is: " + nextIndex);
    }
    
    
    
    return Solution.maxSum;
  }      
  
  /*
  * This funciton will return the index where it stops checking further
  * Also will update max value
  */
  private static int findMaxIteration(int[] array, int startIndex) {
    System.out.println("Being findMaxIteration: array is" + Arrays.toString(array) + "startIndex = " + startIndex);
    if(Solution.maxSum < array[startIndex]) { // Update the max if needed
      Solution.maxSum = array[startIndex];
    }
    
    //int newIndex = 0;
    int runningSum = 0; // this is the sum from start to the current pointer
    int i;
    for (i = startIndex; i < array.length; i++) {
      runningSum += array[i];
      System.out.println("runningSum is: " + runningSum + " at index: " + i);
      if (runningSum > Solution.maxSum) { // Update the max if running sum is bigger
        Solution.maxSum = runningSum;
      }
      
      if (runningSum < 0) { // Here, we need to stop as running sum is negative
        //newIndex = i + 1; // next iteration will begin from next item
        return i + 1;
      }
      else { // if running sum is positive or 0, let it continue

      }
    }
    return i;
  }
  
  private static ArrayList <Integer> mergeAdjacent(int[] array) {
    // Use ArrayList as we're not sure how many items will be in after merge
    ArrayList <Integer> list = new ArrayList <Integer> (array.length); // loadfactor to be same as original to avoid
                                                  // resizing later
    
    // handle null and empty situations here
    if (array == null || array.length == 0) {
      return list;
    }
    
    int sum = array[0];
    for (int i = 1; i < array.length; i++) { // start from index 1 (2nd place), as first is 
                                              // already counted
      if (sum >= 0) {
        if (array[i] >= 0) {
          sum += array[i];
        }
        else {
         // Now stop, as the sum is ready now
          list.add(sum);
          
          // Reset sum to current item for next iteration
          sum = array[i];
          
        }
      }
      else {//if (sum < 0) {//negative, similar logic here
        if (array[i] < 0) {
          sum += array[i];
        }
        else {
          // TODO: below seems duplcate, consider putting in a common function later.
          // Now stop, as the sum is ready now
          list.add(sum);
          
          // Reset sum to current item for next iteration
          sum = array[i];
          
        }
      }
    /*
      else { // If 0, nothing needs to be done here. meaning skip it.
      }
     */
    }  
    
    // The last sum does not get a chance to be added. Add now
    list.add(sum);


    
    return list;
  }
  

  
  /**
   * Main program
   */
  public static void main(String[] args) {
    //Test merge function
    //int result = find(new int[] {-5, 6, 9, -2,0, -3, 20,0, 30});
    //System.out.println("Merged array is: " + merged);
    
    
    verify(6, find(new int[] {1, 2, 3}));
    verify(54, find(new int[] {-5, 6, -2, 20, 30}));
    verify(5, find(new int[] {4, -9, 3, -2, 4, -12}));
    
  }

  
  /**
   * Utility class to do verification
   */
  private static void verify(int expected, int answer) {
    final String verdict;
    if (expected == answer) {
      verdict = "CORRECT";
    } else {
      verdict = "WRONG  ";
    }
    System.out.println(verdict + " - Expecting " + expected + "; Your answer is " + answer);
  }
  

}


