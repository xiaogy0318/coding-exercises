import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main (String[] args) {
		ReverseComparater rc = new ReverseComparater();
		PriorityQueue <Integer> q = new PriorityQueue <Integer>(rc);
		q.add(10);
		q.add(9);
		q.add(1);
		q.add(5);
		
		while (!q.isEmpty()) {
			Integer i = (Integer) q.poll();
			System.out.println(i);
		}
	}
}

class ReverseComparater implements java.util.Comparator <Integer>{
	public int compare(Integer i1, Integer i2) {
		return i2 - i1;
	}
}