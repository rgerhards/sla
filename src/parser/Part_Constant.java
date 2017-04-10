package parser;

public class Part_Constant extends Parser {
	
	public Part_Constant(String pType) {
		super(pType);
	}
	
	public @Override int parse(int pOffSet) {
		
		char c = getLine().charAt(pOffSet);
		addToConst(c);
		pOffSet++;
		
		return pOffSet;
	}
	
}
