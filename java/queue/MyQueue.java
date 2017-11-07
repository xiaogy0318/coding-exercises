import java.util.*;
public class MyQueue {
	public static boolean testTwoQueuesEqual(Queue q1, Queue q2) {
		while (!q1.isEmpty() && !q2.isEmpty()) {
			if (q1.poll() != q2.poll()) {
				return false;
			}
		}

		if (!q1.isEmpty() || !q2.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public static void remove13thElementFromQueue(Queue q) {
			System.out.println(q);
			Queue tempQ = new LinkedList();
			int counter = 0;
			while (!q.isEmpty()) {
				tempQ.add(q.poll());
				counter++;
			}
			
			if (counter < 13) {
				System.out.println("The queue has less than 13 elements!!!");
			}
			
			//else
			//{
				counter = 0;
				while (!tempQ.isEmpty()) {
					int temp = (int)tempQ.poll();
					if (counter != 12) {
						q.add(temp);
					}
					counter++;
				}
			//}
			System.out.println(q);
	}
	
	public static void main(String[] args) {
		Queue q1 = new LinkedList();
		q1.add(1);
		q1.add(2);
		q1.add(3);
		q1.add(4);
		q1.add(5);
		q1.add(6);

		Queue q2 = new LinkedList();
		q2.add(1);
		q2.add(2);
		q2.add(3);
		q2.add(4);
		q2.add(5);
		q2.add(6);
		q2.add(7);
		q2.add(8);
		q2.add(9);
		q2.add(10);
		q2.add(11);
		q2.add(12);
		//q2.add(13);
		//q2.add(14);
		
		//System.out.println(testTwoQueuesEqual(q1, q2));
		//System.out.println(testTwoQueuesEqual(q1, q2));
		remove13thElementFromQueue(q2);
	}
	
}