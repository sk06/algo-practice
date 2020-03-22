
public class PassByRefOrValueExample {
	
	
	public static int testpbv(int i){
		return i+2;
	}
	
	public static void main(String[] args) {
		
		int i = 5;
		System.out.println(i);
		System.out.println(testpbv(i));
		System.out.println(i);
		i = testpbv(i);
		System.out.println(i);
		

	}

}
