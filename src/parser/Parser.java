package parser;

public abstract class Parser {
	
	private static String toParse;
	private static String constant = "";
	
	public static void setLine(String line) {
		toParse = line;
	}
	
	public static String getLine() {
		return toParse;
	}
	
	public static void addToConst(char c) {
		constant += c;
	}
	
	public static String getConst() {
		return constant;
	}
	
	public static void emptyConst() {
		constant = "";
	}
}
