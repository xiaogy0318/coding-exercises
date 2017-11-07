import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Array2BST {
	public static void main(String[] args) {
		//Plumbing
		//Read test case number
		int testCaseNo = 0;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			testCaseNo = Integer.parseInt(reader.readLine());
			for (int i = 0; i < testCaseNo; i++) {
				int arrayCount = Integer.parseInt(reader.readLine()); // parse array size. Todo: use it to check input later.
				String N = reader.readLine(); // the array is here, raw input
				String[] sortedN = N.split(" "); // convert into an array
				//System.out.println("Array input is: " + Arrays.toString(sortedN));
				
							
				//Test Node
				
				Node root = constructNode(sortedN);
				root.printNode();
				System.out.println();
			}
		}catch(IOException ex) {
			System.out.println(ex);
			return;
		}
	}

	private static Node constructNode(String[] input) {
		//Construct the BST

		//special case when length is 0
		if (input.length == 0) {
			return null;
		}

		//special case when length is 1
		if (input.length == 1) {
			Node node = new Node();
			node.value = Integer.parseInt(input[0]);
			return node;
		}
		
		//Find the item in the middle
		int middle = (input.length + 1)/ 2 - 1;
		

		
		Node root = new Node();
		root.value = Integer.parseInt(input[middle]);
		//System.out.println("Root is: " + root.value);
		//Continue to recursively construct the rest of the nodes
		//Construct the left side the tree
		String[] left = new String[middle];
		for (int j = 0; j < left.length; j++) {
			left[j] = input[j];
		}
		//System.out.println("Left array is: " + Arrays.toString(left));
		
		Node leftNode = constructNode(left);
		root.left = leftNode;
		
		//Construct the right side of the tree
		String[] right = new String[input.length - middle - 1];
		for (int k = middle + 1; k < input.length; k++) {
			right[k - middle - 1] = input[k];
		}
		//System.out.println("Right array is: " + Arrays.toString(right));
		Node rightNode = constructNode(right);
		root.right = rightNode;
		
		return root; //temp
	}
}

class Node {
	public int value;
	public Node left;
	public Node right;
	
	public void printNode() {
		//Print value;
		System.out.print(value);
		System.out.print(" ");
		
		if (null != left) {
			left.printNode();
		}
		
		if (null != right) {
			right.printNode();
		}
	}
	
}
