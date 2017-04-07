package parser;

public abstract class Parser {
	
	private static String toParse;
	private static String constant = "";
	
	public static void setLine(String line) {
		toParse = line;
	}
	
	public String getLine() {
		return toParse;
	}
	
	public void addToConst(char c) {
		constant += c;
	}
	
	public String getConst() {
		return constant;
	}
	
	public void emptyConst() {
		constant = "";
	}
	
	public abstract int parse(int pOffSet);
}
