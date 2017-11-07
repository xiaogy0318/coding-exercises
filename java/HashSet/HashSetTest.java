import java.util.HashSet;
import java.awt.Point;

public class HashSetTest {
	public static void main (String[] args) {
		HashSet <Point> mySet = new HashSet <Point> ();
		Point pt1 = new Point(0, 0);
		Point pt2 = new Point(0, 0);
		
		try {
			mySet.add(pt1);
			mySet.add(pt2);
		}
		catch (Exception e) {
			System.out.println(e);	
		}
		
		
		System.out.println(mySet);
		Point pt3 = new Point(3, 3);
		mySet.add(pt3);
		System.out.println(mySet);

		Integer i = 8; 
		System.out.println(i.intValue());
	}
}