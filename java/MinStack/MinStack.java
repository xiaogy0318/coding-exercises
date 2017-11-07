import java.util.Scanner;
import java.util.Stack;
class MinStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			Stack<Integer> s=new Stack<>();
			GfG g=new GfG();
			while(!g.isFull(s,n)){
				g.push(sc.nextInt(),s);
			}
			System.out.println(g.min(s));
			
			
			// Now test pop
			while(!g.isEmpty(s)) {
				g.pop(s);
				System.out.println(g.min(s));
			}
			
		}
	}
}

/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*Complete the function(s) below*/
class GfG{
	private int minValue; // hold the min value
	public void push(int item,Stack<Integer> stack)
	{
	    //add code here.
		if (stack.isEmpty()) {
			minValue = item;
			stack.push(item);
			return;
		}
		
		if(item >= minValue) { // no need to update min
			stack.push(item);
		}
		else {
			int prevMin = minValue; // Retain old min
			minValue = item; // Update min to new value
			stack.push(minValue + minValue - prevMin); // push (newMin * 2 - oldMin) to retain info
		}
		
		System.out.println("After push, the stack is: " + stack);
	}
	
	//Todo: in real practice, this should be implemented to correspond to push logic. However, since the test cases do not cover this, skip to save time for now.
	public int pop(Stack<Integer> stack)
    {
		//add code here.
		int min = this.minValue;
		int top = stack.peek();
		int returnValue;
		
		if (min <= top) { // min is min, all good, just do normal stuff here!
			// Keep min, no need to update
			
			returnValue = stack.pop(); // return the normal stuff
		}
		else { // Now it's special stuff!
			// Need to restore the hidden value of the previous min value here
			int prevMin = min * 2 - top;
			this.minValue = prevMin;
			returnValue = min;
			stack.pop(); // still pop out the value
		}
		
		System.out.println("After pop, the stack is: " + stack);
		return returnValue;
	}
	public int min(Stack<Integer> s)
        {
           //add code here.
		   return minValue;
	}

	public boolean isFull(Stack<Integer>s, int n)
        {
           //add code here.
		   return s.size() == n;
	}
	public boolean isEmpty(Stack<Integer>s)
        {
           //add code here.
		   return s.isEmpty();
	}
	/*
	public int peek(Stack<Integer>s)
        {
           //add code here.
		   return s.peak();
	}
*/
}