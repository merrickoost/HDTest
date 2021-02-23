package generatorfactory;

public class HDfactory {
	private Integer n = 0;

	private abstract class NextElement {
		private NextElement nextElement = null;
		protected abstract String getValue();
		public String next() {
			n++;
			return getValue();
		}
	}
	
	private class NextHans extends NextElement {
		protected String getValue() {return "Hans";}	
	}
	
	private class NextDekkers extends NextElement {
		protected String getValue() {return "Dekkers";}	
	}
	
	private class NextHansDekkers extends NextElement {
		protected String getValue() {return "Hans Dekkers";}	
	}
	
	private class NextNumber extends NextElement {
		protected String getValue() {return n.toString();}	
	}
	
	private HDgenerator getGenerator(int val1, int val2, int val3) {
		NextElement element = null;
		NextElement firstElement = null;
		for(int n = 1; n <= val3; n++) {
			NextElement nextElement = n%val1 == 0 ? n%val2 == 0 ? new NextHansDekkers() : new NextHans() : n%val2 == 0 ? new NextDekkers() : new NextNumber(); 
			if(element == null) {
				firstElement = element = nextElement;
			}
			else {
				element.nextElement = nextElement;
				element = nextElement;
			}
		}
		element.nextElement = firstElement;
		final NextElement nE = firstElement;
		
		return new HDgenerator() {
			private NextElement nextElement = nE;
			
			@Override
			public String next() {
				String value = nextElement.next();
				nextElement = nextElement.nextElement;
				return value;
			}
		};		
	}
	
	public static HDgenerator getGeneratorFor(int val1, int val2) {
		if(val1 < val2) {
			return new HDfactory().getGenerator(val1, val2, val1 * val2);
			
		} else {
			return new HDfactory().getGenerator(val2, val1, val1 * val2);
		}
	}

}
