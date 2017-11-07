/*
Sieve of Eratosthenes

To find all the prime numbers less than or equal to a given integer n by Eratosthenes' method:
1. Create a list of consecutive integers from 2 through n: (2, 3, 4, ..., n).
2. Initially, let p equal 2, the first prime number.
3. Starting from p, enumerate its multiples by counting to n in increments of p, and mark them in the list (these will be 2p, 3p, 4p, etc.; the p itself should not be marked).
4. Find the first number greater than p in the list that is not marked. If there was no such number, stop. Otherwise, let p now equal this new number (which is the next prime), and repeat from step 3.
5. When the algorithm terminates, all the numbers in the list that are not marked are prime.
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
//import java.lang.Math;

class Solution {
  
  /**
   * Returns a list of primes up to including the upper bound
   * example usage: List<Integer> primes = findPrimes(10);
   *   —> [2,3,5,7]
   */
  public List<Integer> findPrimes(Integer n) throws IllegalArgumentException {
  
    if(n < 2) {
      return new ArrayList <Integer> ();
    }
    
    // Create a boolean array to track the true/false of all nubers up to n
    boolean[] primability = new boolean[n + 1];
    // Initial value is true, as we're going to check the false and flip their status
    for(int i = 2; i < n + 1; i++) { // leave 0 and 1 as false
      primability[i] = true;
    }
    
    ArrayList <Integer> list = new ArrayList <Integer>();
    // Now scan the array to flip the non-primes
    
    int p = 2;
    list.add(2);
    int sqrtN = (int)Math.sqrt(n); // check later

    while(p <= n) {
      // We only need to check up to sqrt of n, because for the bigger ones
      // Their complement has already been checked for primability
      
      System.out.println("Check p = " + p);
      
      for(int i = p; i * p <= n; i++) { 
        primability[i * p] = false;
        System.out.println("Checking off " + (i * p));
        //System.out.println("Primability array is: " + Arrays.toString(primability));
      }
      
      p++;
      
      // Find next prime
      while(p <= n) { 
        if (primability[p]) { // need check
          list.add(p);
          System.out.println("Next prime is: " + p);
          break;
        }
        else {
          p++;
        }
      }
      
      
    }
    
    return list;
  }


  
  public static void main(String[] args) {

    Solution soe = new Solution();

    List<Integer> primes = soe.findPrimes(100);
    if (null != primes) {
      System.out.println(primes);
    }
  }
}