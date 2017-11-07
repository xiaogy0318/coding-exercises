public class Singleton {
	private static Singleton _instance_;
	
	private Singleton() {
		System.out.println("Singleton()");
	}
	
	public static Singleton getInstance() {
		if (null == _instance_) {
			_instance_ = new Singleton();
			
		}
		return _instance_;
	}
	
	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		singleton = Singleton.getInstance();
		singleton = Singleton.getInstance();
	}
}