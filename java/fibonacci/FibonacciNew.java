import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

class FibonacciNew {
	private static long[] cache;
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int testCaseNo = Integer.parseInt(reader.readLine());
			
			for (int i = 0; i < testCaseNo; i++) {
				int input = Integer.parseInt(reader.readLine());
				
				// Handle corner case of 0
				if (input <= 0) {
					System.out.println("0");
					return;
				}
				
				cache = new long[input + 1];
				//System.out.println("Input cache before fibonacci: " + Arrays.toString(cache));
				System.out.println(calculateFibonacci(input));
				//System.out.println("Input cache after fibonacci: " + Arrays.toString(cache));
			}
		}
		catch(IOException ex) {
			System.out.println(ex);
		}
	}
	
	private static Long calculateFibonacci(int input) {
		if (input <= 0) {
			cache[0] = 0L;
			return 0L;
		}
		
		//Already calculated before, just return!
		if (cache[input] != 0) {
			return cache[input];
		}
		
		if (1 == input) {
			cache[1] = 1L;
			return 1L;
		}
		
		if (cache[input] == 0L) { // not yet calculated
			cache[input] = (calculateFibonacci(input - 1) + calculateFibonacci(input - 2)) % 1000000007L;
		}
		
		return cache[input];
	}
}