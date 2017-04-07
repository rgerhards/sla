package parser;

public class Part_Constant extends Parser {
	
	public static int parseConst(int pOffSet) {
		
		char c = getLine().charAt(pOffSet);
		addToConst(c);
		pOffSet++;
		
		return pOffSet;
	}
	
}
