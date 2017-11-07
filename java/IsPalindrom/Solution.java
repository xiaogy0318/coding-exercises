import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static String[] candidates = {
    // Valid
    "racecar", 
    "Kayak",
    "never odd or even",
    "rats live on no evil star",
    "A Toyota! Race fast... safe car: a Toyota",
    "Some men interpret nine memos",
    // Invalid
    "wombat",
    "No lemons, one melon", // lemons, one->lemon, no
    "Too bad – I hid a book", // book->boot
    "No trace; not one cartoon", // cartoon->carton
    "Ma'am, I'm Adam", // Ma'am->Madam
    "Del was a sled", // was->saw
    "Flee to Em, remote elf", // Em->me
    "Ma? Ha! A sham!" // Ha! A sham->Has a ham
  };
  
  public static Boolean isPalindrome(String candidate) {
    // Make this work
    
    /* Analysis
    * First need to pre-process the input string so that
    * it's case insensitive comparision
    * Also remove all punctuations, meaning removing all non-letter chars not in scope of 'a' to 'z (or 'A' to 'Z') Confirm this with interviewer though
    */
    candidate = preprocess(candidate);
  
    /* Analysis continues
    * here just need to determine if the string is a palindrome, 
    * by using two pointers at the start and end position of the string respectively
    * the start pointer runs right towards the middle, 
    * while end pointer moves left also towards the middle
    * If any mismatch, then it fails. 
    */
    //int start = 0;
    //int end = candidate.length() - 1;
    int size = candidate.length();
    int mid = size / 2; // start pointer needs to run until reaching mid - 1
                        // mid is the same as total in the metrics we're building
    int matchCount = 0;
    boolean result = true;
    for (int i = 0; i < mid; i++) {
      if(candidate.charAt(i) != candidate.charAt(size - 1 - i)) {
        // return false; do not return here. Want to exhaust the loop to get all matches!!!
        result = false;
      }
      else {
        matchCount++; // Found one match
      }
    }
    
    float percentage = 0;
    if(mid == 0) {
      percentage = 100f;
    }
    else {
      percentage = ((float) matchCount / (float) mid) * 100f;
    }
      
    System.out.println("Match percentage is: " + percentage + "%");
    
    // If reaching here, meaning all pass
    return result;
  }
  
  private static String preprocess(String candidate) {
    // Convert all to lower case letters
    // Use StringBuffer which is more efficient than String in modification of the string
    StringBuffer sb = new StringBuffer(candidate.toLowerCase());
    
    // Now remove chars not in ('a' and 'z')
    for (int i = sb.length() - 1; i >= 0 ; i--) { // check from right to left, 
                                                // as non-letter chars will be deleted along the way
      char aChar = sb.charAt(i);
      if (aChar < 'a' || aChar > 'z') { // non-letter char, delete it
        sb.deleteCharAt(i);
      }
    } 
    System.out.println("After preprocess the string is: " + sb.toString());
    return sb.toString();
  }
  
  
  public static void main(String[] args) {
    
    for (String candidate : candidates) {
      System.out.println(candidate + ": " + isPalindrome(candidate));
    }

    /*
    //preprocess("abc ! ABC");
    //String candidate = "abcba";
    String candidate = "ab@#$ccba  ";
    //String candidate = "";
    System.out.println(candidate + ": " + isPalindrome(candidate));
    
    */    
    
    // Now some funny stuff, the metrics score
    // Consider this case: the percentage of matches out of total
    // e.g. abcbx - only a and x do not match, and the total for comparison is 2 (ab vs bx)
    // so we can give the score matches/total = 1/2 = 50%
    
    
  }
}
