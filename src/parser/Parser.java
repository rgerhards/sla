package parser;

public abstract class Parser {
	
	private static String toParse;
	
	public static void setLine(String line) {
		toParse = line;
	}
	
	public static String getLine() {
		return toParse;
	}
}
