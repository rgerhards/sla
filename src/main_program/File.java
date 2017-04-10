package main_program;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import parser.Numerius;
import parser.Parser;
import parser.Part_Constant;
import parser.Test_Parser_A;
import trees.Tree;

public class File {
	
	private String filename;
	private FileReader fr;
	private BufferedReader br;
	private Parser list[];
	private Tree tree;
	
	private Numerius numerius;
	private Test_Parser_A testParser;
	private Part_Constant partConstant;

	public File(String pFilename) throws FileNotFoundException {
		this.filename = pFilename;
		this.fr = new FileReader(filename);
		this.br = new BufferedReader(fr);
		
	}
	
	public void buildParserArray() {
		numerius = new Numerius("int");
		testParser = new Test_Parser_A("A");
		partConstant = new Part_Constant("const");
		
		list = new Parser[2];
		list[0] = numerius;
		list[1] = testParser;
	}
	
	public boolean processFile() throws IOException {
		System.out.println("Now processing: " + filename);
		String line;
		buildParserArray();
		tree = new Tree();
		
		while((line = br.readLine()) != null) {
			parseLine(line);
		}
		tree.dotTreeOutput();
		
		
		
		return true;
	}
	
	public void parseLine(String pLine) {
		
		Parser.setLine(pLine);
		int len = pLine.length();
		int offSet = 0;
		int newOffSet = 0;
		boolean parserFound = false;
		
		while(offSet < len) {
			for(int i=0; i<2; i++) {
				if((newOffSet = list[i].parse(offSet)) != 0) {
					if(!list[i].getConst().equals("")) {
						tree.addEdge(list[i].getConst());
						System.out.print(list[i].getConst());
						list[i].emptyConst();
					}
					tree.addEdge("<" + list[i].getType() + ">");
					System.out.print("<" + list[i].getType() + ">");
					parserFound = true;
					offSet = newOffSet;
					break;
				}
			}
			if(!parserFound) {
				offSet = partConstant.parse(offSet);
			}
			parserFound = false;
		}
		tree.addEdge(partConstant.getConst());
		System.out.println(partConstant.getConst());
		partConstant.emptyConst();
		tree.nextLine();
	}
	
	
}
