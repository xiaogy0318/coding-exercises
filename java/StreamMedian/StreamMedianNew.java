import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.PriorityQueue;
import java.util.Comparator;

public class StreamMedianNew {
	public static void main(String[] args) throws IOException {
		//Construct two heaps, one max for holding larger half, and the other holding the smaller half.
		PriorityQueue <Integer> maxHeap = new PriorityQueue <Integer> (new ReverseComparator());
		PriorityQueue <Integer> minHeap = new PriorityQueue <Integer> ();
		
		/*
		//Test out the heaps
		maxHeap.add(3);
		maxHeap.add(5);
		maxHeap.add(1);
		maxHeap.add(4);
		System.out.println("MaxHeap's top is: " + maxHeap.poll());
		
		minHeap.add(3);
		minHeap.add(5);
		minHeap.add(1);
		minHeap.add(4);
		System.out.println("minHeap's top is: " + minHeap.poll());
		*/
		
		
		//Read number of input
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int inputNo = Integer.parseInt(reader.readLine());
		
		for(int i = 0; i < inputNo; i++) {
			//do the work and print output for each input
			int maxHeapSize = maxHeap.size();
			int minHeapSize = minHeap.size();
			
			int streamNumber = Integer.parseInt(reader.readLine());
			
			if (0 == maxHeapSize) { // if maxheap is 0, meaning both heaps are empty
				maxHeap.add(streamNumber);
				System.out.println(maxHeap.peek()); 
				continue;
			}
			
			if (maxHeapSize > minHeapSize) { // Need to add the new number to minHeap to balance out the count
				if(streamNumber > maxHeap.peek()) {
					minHeap.add(streamNumber);
				}
				else {
					minHeap.add(maxHeap.poll());
					maxHeap.add(streamNumber);
				}
			}
			else if(maxHeapSize == minHeapSize) {
				if(streamNumber > maxHeap.peek()) {
					if (streamNumber < minHeap.peek()) {
						maxHeap.add(streamNumber);
					}
					else {
						maxHeap.add(minHeap.poll());
						minHeap.add(streamNumber);
					}
				}
				else {
					maxHeap.add(streamNumber);
				}
				
			}
			//System.out.println("max heap is: " + maxHeap);
			//System.out.println("min heap is: " + minHeap);
			
			if (maxHeap.size() == minHeap.size()) {
				System.out.println((minHeap.peek() + maxHeap.peek()) / 2); //Todo: use double to increase accuracy, like .5 case
			}
			else {
				System.out.println(maxHeap.peek()); 
			}
		}
	}
}

class ReverseComparator implements Comparator <Integer>{
	public int compare(Integer a, Integer b) {
		return b - a;
	}
}