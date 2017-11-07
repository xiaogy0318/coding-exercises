import java.awt.Point;

public class PassByValue {
	public static void main (String[] args) {
		//System.out.println("PassByValue");
		Point pt1 = new Point(0, 0);
		Point pt2 = new Point(0, 0);
		System.out.println ("Point 1 x: " + pt1.x + ", y: " + pt1.y);
		System.out.println ("Point 2 x: " + pt2.x + ", y: " + pt2.y);
		swap(pt1, pt2);
		System.out.println ("Point 1 x: " + pt1.x + ", y: " + pt1.y);
		System.out.println ("Point 2 x: " + pt2.x + ", y: " + pt2.y);
		
	}
	
	private static void swap (Point pt1, Point pt2) {
		pt1.x = 100;
		pt1.y = 100;
		System.out.println ("Point " + pt1. + ", y: " + pt1.y);
		Point temp = new Point();
		temp = pt1;
		pt1 = pt2;
		pt2 = temp;
	}
}