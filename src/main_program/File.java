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
	

	public File(String pFilename) throws FileNotFoundException {
		this.filename = pFilename;
		this.fr = new FileReader(filename);
		this.br = new BufferedReader(fr);
	}
	
	public boolean processFile() throws IOException {
		System.out.println("Now processing: " + filename);
		String line;
		int offSet;
		int len;
		
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
			if((newOffSet = Numerius.parseInt(offSet)) != 0) {
				offSet = newOffSet;
				constant = Numerius.getConst();
				if(!constant.equals("")) {
					System.out.print(constant);
					Numerius.emptyConst();
				}
				System.out.print("<Integer>");
			} else if((newOffSet = Test_Parser_A.parseA(offSet)) != 0) {
				offSet = newOffSet;
				constant = Test_Parser_A.getConst();
				if(!constant.equals("")) {
					System.out.print(constant);
					Test_Parser_A.emptyConst();
				}
				System.out.print("<A>");
			} else {
				offSet = Part_Constant.parseConst(offSet);
			}
		}
		constant = Numerius.getConst();
		if(!constant.equals("")) {
			System.out.println(constant);
			Numerius.emptyConst();
		}
		
	}
	
}
