package minimalist;

public class Minimalist {

	public static void main(String[] args) {
		int val1 = 3;
		int val2 = 5;
		
		if(args.length == 2) {
			try {
				val1 = Integer.parseInt(args[0]);
				val2 = Integer.parseInt(args[1]);
			} catch(Exception e) {
				System.err.println("Expected 2 integers as input");
			}
		}

		for(int n = 1; n <= 1000; n++) 
			System.out.println(n%val1 == 0 ? n%val2 == 0 ? "Hans Dekkers" : "Hans" : n%val2 == 0 ? "Dekkers" : n);             		
	}

}
