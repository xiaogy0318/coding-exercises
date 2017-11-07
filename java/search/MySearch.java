import java.util.*;
import javax.swing.tree.TreeNode;

public class MySearch {
	public static boolean testBinarySearch(ArrayList list, int value) {
		if (0 == list.size()) {
			return false;
		}
		
		int midPoint = list.size()/2;
		ArrayList leftList = new ArrayList();
		ArrayList rightList = new ArrayList();
		
		if (value == (int)list.get(midPoint)) {
			return true;
		}
		else if (value < (int)list.get(midPoint)) {
			for (int i = 0; i < midPoint; i++) {
				leftList.add((int)list.get(i));
			}
			return testBinarySearch(leftList, value);
		}
		else {//if (value > (int)list.get(midPoint)) {
			for (int i = midPoint + 1; i < list.size(); i++) {
				rightList.add((int)list.get(i));
			}
			return testBinarySearch(rightList, value);
		}

	}
	
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(3);
		list.add(5);		
		System.out.println(testBinarySearch(list, 5));

		TreeNode root = new MyTreeNode();
	}
}

class MyTreeNode implements TreeNode {
	public int value;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	
	
}