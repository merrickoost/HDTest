package generatorfactory;

public class GeneratorFactory {

	public static void main(String[] args) {
		int val1 = 3;
		int val2 = 5;

		if (args.length == 2) {
			try {
				val1 = Integer.parseInt(args[0]);
				val2 = Integer.parseInt(args[1]);
			} catch (Exception e) {
				System.err.println("Expected 2 integers as input");
			}
		}
		
		HDgenerator hdGenerator= HDfactory.getGeneratorFor(val1, val2);
		
		for(int n = 0; n < 1000; n++) {
			System.out.println(hdGenerator.next());
		}
	}
}
