public class Generics  <E>{
	private static <T> T max(T a, T b) {
		//return c>d?c:d;
		return a;
	}
	
	public E min(E a, E b) {
		return a;
	}
	
	public static void main(String[] args) {
		System.out.println(max(1, 2));
		//Generics generics = new Generics();
		System.out.println((new Generics<Integer>()).min(1, 2));
		
	}
}