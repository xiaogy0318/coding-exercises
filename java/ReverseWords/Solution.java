/*
Write a java method which accepts an input String that contains multiple words and prints the words of that stirng in reverse order. Please ignore the duplicates.
Example: Input: "Apple is  a good   company  good working  is a cat"
  Output should be: "a is working good company Apple"
  */

import java.io.*;
import java.util.*;

class Solution {
  static String [] inputs = {
		"Apple is  a good   company  good working  is a cat",
    "good good good",
  };
  public static void main(String [] args) {
		for (String input: inputs){
			reverseWords(input);
		}
	}

  public static void reverseWords(String input) {
   /* Write your code here and print the reversed string */
	 
	 // Split into array then trim
	 // From end to begin of the array, add to a LinkedHashSet which reserves order of insert (so duplicates will be ignored)
	 // Print out the LinkedHashSet with space in between
	 
	 
    System.out.println("OK");
  }
}
