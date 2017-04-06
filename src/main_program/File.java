package main_program;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import parser.Parser;

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
		
		
	}
	
}
