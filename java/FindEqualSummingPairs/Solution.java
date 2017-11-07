import java.io.*;
import java.util.*;

/**
     * Given:
     *  Root node
     * Find:
     *  all pairs (2 numbers per pair) of numbers which, when added have the same sum in a Binary Tree
     *            4
     *           / \
     *          6  6
     */
class Pair<A, B> {

      public final A left;
      public final B right;

      Pair(A left, B right) {
        this.left = left;
        this.right = right;
      }
    }

class Node<V> {
     public Node<V> _left;
     public Node<V> _right;
     public  V _value;

     public Node(V val){
         this._value = val;
     }
}

class Solution {
  public static void main(String[] args) {
    Node<Integer> root = new Node<>(4);
    Node<Integer> left = new Node<>(6);
    Node<Integer> right = new Node<>(6);
    
    root._left = left;
    root._right = right;
    List<Pair<Integer, Integer>> pairs = findEqualSummingPairs(root);
    
  }
    
  public static List<Pair<Integer, Integer>> findEqualSummingPairs(Node<Integer> root){
      return null;
  }  
}

