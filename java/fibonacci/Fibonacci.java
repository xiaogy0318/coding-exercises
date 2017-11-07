class Fibonacci {

	private static int calcFibonacci(int n, int[] cache) {
		if (0 == n) {
			cache[n] = 0;
			return 0;
		}
		
		if (1 == n) {
			cache[n] = 1;
			return 1;
		}
		
		
		if (0 == cache[n]) {
			cache[n] = calcFibonacci(n - 2, cache) + calcFibonacci(n - 1, cache);
		}
		
		return cache[n]; 
	}
	
	private static int calcFibonacciInterative(int n, int[] cache) {
		
		cache[0] = 0;
		cache[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			cache[i] = cache[i - 2] + cache[i - 1];
			//System.out.println(i);
			//System.out.println(cache[i]);
		}
		
		return cache[n];
	}
	
	public static void main(String[] args) {
		int[] cache = new int[9];
		//System.out.println(calcFibonacciInterative(8, cache));
		System.out.println(calcFibonacci(8, cache));
	}
}