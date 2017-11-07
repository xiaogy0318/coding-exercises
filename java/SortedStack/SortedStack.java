import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}

/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*Complete the function below*/
class GfG{
	public Stack<Integer> sort(Stack<Integer> mainStack)
	{
		//add code here.
		// Create the temp stack
		Stack <Integer> tempStack = new Stack <Integer>();

		//Below will work, but there is additional arrangment/moving of the items from temp to main, can be optimized
		/*
		// Iterate the main stack
		while(!mainStack.isEmpty()) {
			//Move items from main to temp		
			int item = mainStack.pop();
			if (tempStack.isEmpty()) {
				tempStack.push(item);
			}
			else {
				// Test if the top of temp stack relative to the item
				int tempItem = tempStack.peek();
				if (tempItem >= item) { // it's in good format, then push to temp. == case is in good format already
					tempStack.push(item);
				}
				else { // Not in good format, push all temp items back to main, and then push the item in too, finish the current iteration
					while (!tempStack.isEmpty()) {
						mainStack.push(tempStack.pop());
					}
					mainStack.push(item);
					
				}
			}
		}
		
		//System.out.println("Main stack: " + mainStack);
		//System.out.println("Temp stack: " + tempStack);
		
		//Now reverse by moving items back to main, and main is what we need
		while(!tempStack.isEmpty()) {
			mainStack.push(tempStack.pop());
		}
		
		//System.out.println("Main stack: " + mainStack);
		
		return mainStack;
		*/
	
		while(!mainStack.isEmpty()) {
			//Move items from main to temp		
			int item = mainStack.pop();
			if (tempStack.isEmpty()) {
				tempStack.push(item);
			}
			else {
				int counter = 0;
				while (!tempStack.isEmpty()) { // Find the position to insert the current item
					// Test if the top of temp stack relative to the item
					int tempItem = tempStack.peek();
					if (tempItem <= item) { // it's in good format (meaning sorted correctly in temp if pushing the current item, then push to temp. == case is in good format already
						//tempStack.push(item);
						break;
					}
					else { // Not in good format, meaning need to find the correct place in temp to push the current item
						mainStack.push(tempStack.pop());
						counter++;
					}
				}
				
				tempStack.push(item);
				
				for(int i = 0; i < counter; i++) {
					tempStack.push(mainStack.pop());
				}
				
				
			}
		}
	
		//System.out.println("Main stack: " + mainStack);
		//System.out.println("Temp stack: " + tempStack);
		
		return tempStack;
		
		
	}
}