public class TestBitSwapRequired {
	public static int bitSwapRequired(int a, int b) {
		// Use XOR to filter out the digits of 1 first.
		//int xorResult = a ^ b;
		
		// Right shift the result by 1 each time to count how many 1s there are
		int counter = 0;
		
		for (int x = a ^ b; x != 0; x = x >> 1 ) {
			if ((x & 1) > 0) {
				counter++;
			}
		}
		
		return counter;
	}
	
	public static void main (String[] args) {
		System.out.println(bitSwapRequired(9, 10));
	}
}

