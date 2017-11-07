import java.util.Stack;
public class MyStack {
	public static void main(String[] args) {
		//testReverseStack();
		testRemoveEvenFromStack();
	}
	
	public static void testRemoveEvenFromStack() {
		Stack myStack = new Stack();
		
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		myStack.push(5);
		
		System.out.println(myStack);
		Stack myStackNew = new Stack();
		while (!myStack.empty()) {
			int temp = (int)myStack.pop();
			if (temp%2 == 0) {
				myStackNew.push(temp);
			}
		}
		
		while (!myStackNew.empty()) {
			myStack.push(myStackNew.pop());
		}

		System.out.println(myStack);
	}
	
	
	public static void testReverseStack() {
		Stack myStack = new Stack();
		
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		myStack.push(5);
		
		System.out.println(myStack);
		Stack myStackNew = new Stack();
		while (!myStack.empty()) {
			myStackNew.push(myStack.pop());
		}
		System.out.println(myStackNew);
	}
}