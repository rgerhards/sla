package parser;

public class Test_Parser_A extends Parser {
	
	public @Override int parse(int pOffSet) {
		
		if(getLine().charAt(pOffSet) == 'A') {
			return ++pOffSet;
		}
		
		
		return 0;
	}
	
}
