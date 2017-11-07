//Read from console using BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.NoSuchElementException;

//String split
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

//Thread
import java.lang.Thread;
import java.lang.Runnable;

//Java collections
import java.util.TreeSet;
import java.util.TreeMap;

public class Plumber {
	public static Object mutex = new Object();

	public static void main(String[] args) {
		//Read from console using BufferedReader	
		//Need to handle IOException
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //System.in, not System.io
			System.out.println("Input a line for BufferedReader to read!");
			String line = reader.readLine();
			System.out.println("BufferedReader reads line: " + line);
		}
		catch (IOException ex) {
			System.out.println(ex);
		}
		
		
		//Split a string
		String str = "a b c d";
		String[] strArray = str.split(" ");
		
		// Array to string
		System.out.println("String is split into an array: " + Arrays.toString(strArray)); //Arrays.toString()

		//String sort and binary search with Arrays
		String str1 = "b c d a";
		String[] str1Array = str1.split(" ");
		Arrays.sort(str1Array);
		System.out.println("After sorting the array is: " + Arrays.toString(str1Array));
		
		//Binary search in sorted Arrays
		System.out.println("Binary search character b result is: " + Arrays.binarySearch(str1Array, "b"));
		System.out.println("Binary search character x result is: " + Arrays.binarySearch(str1Array, "x"));
		
		//String sort and binary search with Collections
		String str2 = "b c d a";
		String[] str2Array = str2.split(" ");
		ArrayList list = new ArrayList <String> (Arrays.asList(str2Array));
		Collections.sort(list);
		System.out.println("After sorting the list is: " + list.toString());
		
		//Binary search the string with Collections
		System.out.println("Binary search character b result is: " + Collections.binarySearch(list, "b"));
		System.out.println("Binary search character x result is: " + Collections.binarySearch(list, "x"));
		
		//---------------------------
		//Create a thread using Thread
		Thread myThread = new MyThread();
		myThread.start();
		
		Thread myThreadForRunnable = new Thread(new myRunnable());
		myThreadForRunnable.start();
		
		//Thread wait/notify
		new Thread() {
			public void run() {
				try {
					synchronized(mutex) {
						mutex.wait(10000);
						System.out.println("thread 1 has finished waiting for 10 seconds or until notified by thread 2");
					}
				}
				catch(InterruptedException ex) {
					System.out.println(ex);
				}
			}
		}.start();

		new Thread() {
			public void run() {
				try {
					synchronized(mutex) {
						System.out.println("thread 2 will wait for 3 seconds");
						Thread.sleep(3000);
						mutex.notify();
						System.out.println("thread 2 notifies on the mutex");
					}
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
			}
		}.start();

		//TreeSet (sorted)
		TreeSet treeSet = new TreeSet();
		treeSet.add("b");
		treeSet.add("c");
		treeSet.add("a");
		System.out.println("treeSet content is: " + treeSet.toString());
		if (treeSet.contains("b")) {
			System.out.println("b exists in treeSet");
		}
		treeSet.remove("a");
		System.out.println("treeSet content is: " + treeSet.toString());

		
		//TreeSet and TreeMap
		TreeMap treeMap = new TreeMap();
		treeMap.put("b", "bob");
		treeMap.put("c", "cinderella");
		treeMap.put("a", "apple");
		System.out.println("treeMap content is: " + treeMap.toString());
		if (treeMap.containsKey("b")) {
			System.out.println("b exists in treeMap");
		}
		treeMap.remove("a");
		System.out.println("treeMap content is: " + treeMap.toString());

		/*Throw exception
		*
		*/
		throw new NoSuchElementException("No such element");
	}
}

class MyThread extends Thread {
	public void run() {
		System.out.println("MyThread is running");
	}
}

class myRunnable implements Runnable {
	public void run() {
		System.out.println("myRunnable is running");
	}
}