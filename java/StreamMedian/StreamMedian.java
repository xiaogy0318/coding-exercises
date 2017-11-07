import java.util.PriorityQueue;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class StreamMedian {

		public static void main(String[] args) throws IOException {
			
			ReverseComparator rc = new ReverseComparator();
			PriorityQueue <Integer> q1 = new PriorityQueue <Integer> (); // priority from low to high
			PriorityQueue <Integer> q2 = new PriorityQueue <Integer> (rc); // priority from high to low
			
			//Todo: Use an array to hold the input, and iterate
			//Todo: Create function to wrap below to reduce duplicate code
			/*
			q1.add(5); 
			q2.add(5);
			*/
			
			//Enter data using BufferReader
			BufferedReader reader =
                   new BufferedReader(new InputStreamReader(System.in));
        
			// Reading data using readLine
			String input = reader.readLine();
			Integer inputCount = Integer.valueOf(input);
			
			for (int i = 0; i < inputCount; i++) {
				Integer number = Integer.valueOf(reader.readLine());
				q1.add(number); 
				q2.add(number);

			//Make copies of the queues
				PriorityQueue <Integer> newQ1 = new PriorityQueue <Integer>(q1);
				PriorityQueue <Integer> newQ2 = new PriorityQueue <Integer>(q2);
				System.out.println("Median is: " + getMedian(newQ1, newQ2));
				
			}
			/*
			//Make copies of the queues
			PriorityQueue <Integer> newQ1 = new PriorityQueue <Integer>(q1);
			PriorityQueue <Integer> newQ2 = new PriorityQueue <Integer>(q2);
			System.out.println("Median is: " + getMedian(newQ1, newQ2));
			
			q1.add(15); 
			q2.add(15);
			newQ1 = new PriorityQueue <Integer>(q1);
			newQ2 = new PriorityQueue <Integer>(q2);
			System.out.println("Median is: " + getMedian(newQ1, newQ2));
			
			
			q1.add(1); 
			q2.add(1);
			newQ1 = new PriorityQueue <Integer>(q1);
			newQ2 = new PriorityQueue <Integer>(q2);
			System.out.println("Median is: " + getMedian(newQ1, newQ2));

			q1.add(3); 
			q2.add(3);
			newQ1 = new PriorityQueue <Integer>(q1);
			newQ2 = new PriorityQueue <Integer>(q2);
			System.out.println("Median is: " + getMedian(newQ1, newQ2));
			*/
			
			/*
			q1.add(18); 
			q2.add(18);
			newQ1 = new PriorityQueue <Integer>(q1);
			newQ2 = new PriorityQueue <Integer>(q2);
			System.out.println("Median is: " + getMedian(newQ1, newQ2));
			*/
		}
		
		private static Integer getMedian (PriorityQueue <Integer> q1, PriorityQueue <Integer> q2) {
			while (!q1.isEmpty()) {
				Integer i1 = q1.poll(); //System.out.println("i1: " + i1);
				Integer i2 = q2.poll(); //System.out.println("i2: " + i2);
				if (i1 >= i2) {
					return (i1 + i2) / 2;
				}
			}
			
			//Should never come here!
			return 0;
			
		}
}

class ReverseComparator implements Comparator <Integer> {
	public int compare(Integer a, Integer b) {
		return b - a;
	}
}