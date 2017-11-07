import org.junit.*;
import org.junit.runner.*;
import static org.junit.Assert.*;


import java.util.*;

public class Solution {

  /* TODO: Write this Compound Iterator class below */
  public class CompoundIterator<T>
  implements Iterator<T> {
    private Iterator<T>[] myiterators; // class iterator array
    private int iteratorIndex = 0; // index for current iterator in the array

    CompoundIterator(Iterator<T>[] iterators) {
      // Allow null iterators to be in
      this.myiterators = iterators;
      /*
      // Initialize the iterators
      if(iterators == null) return;
      int size = iterators.length;
      ArrayList <Iterator<T>> list = new ArrayList<Iterator<T>>(); // use a list as I want to remove null iterators below, so size is not certain at this point
      for (int i = 0; i < size; i++) {
        if (iterators[i] == null) continue; // skip null iterators
        //this.myiterators[i] = new Iterator<T>(iterator[i]);
        list.add(iterators[i]); // This isn't what a copy constructor usually do (shallow copy). This is actually using reference. Should be fine here
      }
      
      // Now convert the list of iterators to the array
      this.myiterators = (Iterator<T>[]) list.toArray();
      */
      /*
      this.myiterators = new Iterator <T> [list.size()]; // this doesn't work, generic type creation error!!! java's limitation, it seems
      int j = 0;
      while(list.size() > 0) {
        this.myiterators[j] = list.get(i);
        list.remove(i);
      }
      */
      
            
    }

    public boolean hasNext() {
      
      Iterator<T> iterator = this.myiterators[iteratorIndex];
      
      /*
      if(this.myiterators[iteratorIndex].hasNext()) {
        return true;
      }
      
      
      if (iteratorIndex == this.myiterators.length - 1) { // already the last iterator
        return this.myiterators[iteratorIndex].hasNext();
      }
      */
      
      // There are following iterators, need to check if they are empty
      boolean hasNext = false;
      for(int i = iteratorIndex; i < this.myiterators.length; i++) {
        if (this.myiterators[i] == null) {
          continue;
        }
        
        if (this.myiterators[i].hasNext()) {
          hasNext = true;
          iteratorIndex = i;
          break;
          
        }
      }
      return hasNext;
      
    }

    public T next() {     
      // There are following iterators, need to check if they are empty
      boolean hasNext = false;
      T next = null;
      for(int i = iteratorIndex; i < this.myiterators.length; i++) {
        if (this.myiterators[i] == null) {
          continue;
        }
        
        if (this.myiterators[i].hasNext()) {
          hasNext = true;
          next = this.myiterators[i].next();
          iteratorIndex = i;
//          break;
          return next;
        }
      }
      
      // Up here, if hasNext is still false, then the caller is not right as it should always check hasNext first.
        throw new NoSuchElementException( "No such element" );
    }

    public void remove()
    throws UnsupportedOperationException {
      throw new UnsupportedOperationException(
        getClass().getName() + " does not support the remove() operation.");
    }
  }

  /* JUnit Test Code below - Do not change */

  private static final boolean DEBUG_TEST = false;

  private static Random rnd = new Random(System.currentTimeMillis());

  private static final int[][] SIMPLE_TEST_DATA = {
    {0, 1, 2, 3, 4},
    {5, 6, 7},
    {8},
    {9, 10, 11, 12}
  };

  private static final int[][] SPARSE_TEST_DATA = {
    { 0, 1, 2, 3, 4 },
    {},
    { 5, 6, 7 },
    { 8 },
    {},
    {},
    { 9 },
    {},
    {10, 11},
    {},
    {12}
  };

  private static final int[][] MULTIPLE_EMPTY_TEST_DATA = {
    {}, {}, {}, {}, {}, {}
  };

  private static final int NUM_TEST_LOOPS = DEBUG_TEST ? 50 : 100;
  private static final int MAX_ITERATORS_FOR_RANDOM_TEST = 100;
  private static final int MAX_ELEMENTS_PER_ITERATOR = 5;

  private static final String EOL = System.getProperty("line.separator");

  @Test
  public void testSimpleData()
  throws Throwable
  {
    try
    {
      doSequentialIntegerTest(SIMPLE_TEST_DATA);
    }
    catch (Throwable e)
    {
      System.err.println("Throwable caught within test");
      e.printStackTrace();
      throw e;
    }
  }

  @Test
  public void testSparseData()
  throws Throwable
  {
    try
    {
      doSequentialIntegerTest(SPARSE_TEST_DATA);
    }
    catch (Throwable e)
    {
      System.err.println("Throwable caught within test");
      e.printStackTrace();
      throw e;
    }
  }

  @Test
  public void testEmptyData()
  throws Throwable
  {
    try
    {
      doSequentialIntegerTest(MULTIPLE_EMPTY_TEST_DATA);
    }
    catch (Throwable e)
    {
      System.err.println("Throwable caught within test");
      e.printStackTrace();
      throw e;
    }

  }

  @Test
  public void testRandomNonSparseData()
  throws Throwable
  {

    try
    {
      for (int i = 0; i < NUM_TEST_LOOPS; i++)
      {
        int[][] testData = constructRandomTestMatrix(MAX_ITERATORS_FOR_RANDOM_TEST,
        MAX_ELEMENTS_PER_ITERATOR,
        false, false);
        doSequentialIntegerTest(testData);
      }
    }
    catch (Throwable e)
    {
      System.err.println("Throwable caught within test");
      e.printStackTrace();
      throw e;
    }
  }

  @Test
  public void testRandomSparseData()
  throws Throwable
  {

    try
    {
      for (int i = 0; i < NUM_TEST_LOOPS; i++)
      {
        int[][] testData = constructRandomTestMatrix(MAX_ITERATORS_FOR_RANDOM_TEST,
        MAX_ELEMENTS_PER_ITERATOR,
        true, false);
        doSequentialIntegerTest(testData);
      }
    }
    catch (Throwable e)
    {
      System.err.println("Throwable caught within test");
      e.printStackTrace();
      throw e;
    }
  }

  @Test
  public void testRandomSparseDataWithNulls()
  throws Throwable
  {

    try
    {
      for (int i = 0; i < NUM_TEST_LOOPS; i++)
      {
        int[][] testData = constructRandomTestMatrix(MAX_ITERATORS_FOR_RANDOM_TEST,
        MAX_ELEMENTS_PER_ITERATOR,
        true, true);
        doSequentialIntegerTest(testData);
      }
    }
    catch (Throwable e)
    {
      System.err.println("Throwable caught within test");
      e.printStackTrace();
      throw e;
    }
  }

  private void doSequentialIntegerTest(int[][] testData)
  {
    // Test the mode of use where you call hasNext()
    doSequentialIntegerTest(testData, true);

    // Test the mode of use where you call next() n times without ever calling hasNext()
    doSequentialIntegerTest(testData, false);
  }

  private void doSequentialIntegerTest(int[][] testData, boolean shouldCallHasNext)
  {
    @SuppressWarnings("rawtypes")
    final Iterator[] rawIterators = new Iterator[testData.length];
    @SuppressWarnings("unchecked")
    Iterator<Integer>[] iterators = rawIterators;
    int numInts = 0;
    for (int i = 0; i < testData.length; i++)
    {
      if (testData[i] == null)
      {
        iterators[i] = null;
      }
      else
      {
        List<Integer> intList = intArrayToList(testData[i]);
        iterators[i] = intList.iterator();
        numInts += intList.size();
      }
    }

    CompoundIterator<Integer> iter = new CompoundIterator<>(iterators);
    int count = 0;
    while (shouldCallHasNext ? iter.hasNext() : (count < numInts))
    {
      Integer integerFromIterator = iter.next();
      assertEquals("Unexpected value returned from CompoundIterator; " +
      "test data was: " + intMatrixToString(testData) + ". ",
      new Integer(count++), integerFromIterator);
    }
    assertEquals("Expected number of elements in compound iterator " +
    "to be the sum of the number of elements " +
    "in the individual iterators", count, numInts);

    try
    {
      iter.next();
      fail("Expected next() to throw NoSuchElementException after hasNext() is false.");
    }
    catch (Throwable e)
    {
      assertTrue("Expected next() to throw NoSuchElementException, not: " + e.getClass().getName(),
      e instanceof NoSuchElementException);
    }
  }

  private List<Integer> intArrayToList(int[] arr)
  {
    List<Integer> intList = new ArrayList<>();
    for (int anArr : arr)
    {
      intList.add(anArr);
    }
    return intList;
  }

  private int[][] constructRandomTestMatrix(int maxIterators,
  int maxElementsPerIterator,
  boolean isSparse,
  boolean canContainNullArrays)
  {
    int numIterators = randomIntBetween(1, maxIterators + 1);
    int[][] target = new int[numIterators][];

    int count = 0;
    for (int i = 0; i < target.length; i++)
    {
      int minElementsPerIterator = 1;
      if (isSparse)
      {
        if (canContainNullArrays)
        {
          minElementsPerIterator = -1;
        }
        else
        {
          minElementsPerIterator = 0;
        }
      }
      int numElements =
      randomIntBetween(minElementsPerIterator,
      maxElementsPerIterator + 1);
      int[] subArray = null;
      if (numElements >= 0)
      {
        subArray = new int[numElements];
        for (int j = 0; j < subArray.length; j++)
        {
          subArray[j] = count++;
        }
      }
      if (DEBUG_TEST && (subArray == null)) {
        System.out.println("subArray is null.");
      }
      target[i] = subArray;
    }

    if (DEBUG_TEST)
    {
      System.out.println(intMatrixToString(target));
    }

    return target;
  }

  private int randomIntBetween(int inclusiveLowerBound, int exclusiveUpperBound)
  {
    if (inclusiveLowerBound >= exclusiveUpperBound)
    {
      throw new IllegalArgumentException(
      "Bad range for randomIntBetween();" +
      " expected inclusiveLowerBound of " + inclusiveLowerBound +
      " to be stricly less than exclusiveUpperBound of " + exclusiveUpperBound);
    }
    int range = exclusiveUpperBound - inclusiveLowerBound;
    return inclusiveLowerBound + rnd.nextInt(range);
  }

  private String intMatrixToString(int[][] matrix)
  {
    StringBuilder buf = new StringBuilder();
    buf.append("{").append(EOL);
    for (int i = 0; i < matrix.length; i++)
    {
      buf.append("    ");
      int[] ints = matrix[i];
      if (ints == null)
      {
        buf.append("null");
      }
      else
      {
        buf.append("{ ");
        for (int j = 0; j < ints.length; j++)
        {
          int anInt = ints[j];
          buf.append(anInt);
          if (j < ints.length - 1)
          {
            buf.append(",");
          }
          buf.append(" ");
        }
        buf.append("}");
      }
      if (i < matrix.length - 1)
      {
        buf.append(",");
      }
      buf.append(EOL);
    }
    buf.append("}");
    return buf.toString();
  }

  public static void main(String[] args) {
    JUnitCore.main("Solution");
  }
}
