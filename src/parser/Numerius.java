package parser;

import java.security.InvalidParameterException;

public class Numerius extends Parser {
	
	
	public @Override int parse(int pOffSet) {
		String line = getLine();
		int len = line.length();
		boolean hasDigit = false;
		
		if(pOffSet < 0 || pOffSet >= len) {
			throw new InvalidParameterException("Number_Parser: Invalid offSet");
		}
		
		if(line.charAt(pOffSet) == '-') {
			pOffSet++;
		}
		while(pOffSet < len && Character.isDigit(line.charAt(pOffSet))) {
			pOffSet++;
			hasDigit = true;
		}
		
		if(hasDigit) {
			return pOffSet;
		} else {
			return 0;
		}
	}
}
