package random;

public class Things {
	//test object
	
	private int data;
	// some kind of data
	
	public Things() {
		this(0);
	}
	
	public Things (int n){
		this.data = n;
	}
	
	public String toString() {
		return "" + this.data;
	}
}
