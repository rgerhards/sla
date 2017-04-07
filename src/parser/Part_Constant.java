package parser;

public class Part_Constant extends Parser {
	
	public @Override int parse(int pOffSet) {
		
		char c = getLine().charAt(pOffSet);
		addToConst(c);
		pOffSet++;
		
		return pOffSet;
	}
	
}
