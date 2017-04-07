package main_program;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import parser.Numerius;
import parser.Parser;
import parser.Part_Constant;
import parser.Test_Parser_A;

public class File {
	
	private String filename;
	private FileReader fr;
	private BufferedReader br;
	
	private Numerius numerius;
	private Test_Parser_A testParser;
	private Part_Constant partConstant;

	public File(String pFilename) throws FileNotFoundException {
		this.filename = pFilename;
		this.fr = new FileReader(filename);
		this.br = new BufferedReader(fr);
		
		numerius = new Numerius();
		testParser = new Test_Parser_A();
		partConstant = new Part_Constant();
	}
	
	public boolean processFile() throws IOException {
		System.out.println("Now processing: " + filename);
		String line;
		
		while((line = br.readLine()) != null) {
			parseLine(line);
		}
		
		
		
		
		return true;
	}
	
	public void parseLine(String pLine) {
		int len = pLine.length();
		Parser.setLine(pLine);
		int offSet = 0;
		int newOffSet = 0;
		String constant = "";
		
		
		while(offSet < len) {
			if((newOffSet = numerius.parse(offSet)) != 0) {
				offSet = newOffSet;
				constant = numerius.getConst();
				if(!constant.equals("")) {
					System.out.print(constant);
					numerius.emptyConst();
				}
				System.out.print("<Integer>");
			} else if((newOffSet = testParser.parse(offSet)) != 0) {
				offSet = newOffSet;
				constant = testParser.getConst();
				if(!constant.equals("")) {
					System.out.print(constant);
					testParser.emptyConst();
				}
				System.out.print("<A>");
			} else {
				offSet = partConstant.parse(offSet);
			}
		}
		constant = numerius.getConst();
		if(!constant.equals("")) {
			System.out.println(constant);
			numerius.emptyConst();
		}
		
	}
	
	
}
