package main_program;

import gnu.getopt.Getopt;

import java.io.IOException;

public class Main {
	
	/*
	 * Command line parameter:
	 * 
	 * -f		name of the input file that will be processed
	 * -o		form of output:		JTree
	 * 								dot
	 * 
	 */

	public static void main(String[] args) throws IOException {
		
		String pFile = null;
		String pOutput = null;
		
		Getopt g = new Getopt("optarg", args, "f:o:");
		int c;
		while((c = g.getopt()) != -1) {
			switch(c) {
			case 'f':
				pFile = g.getOptarg();
				break;
			case 'o':
				pOutput = g.getOptarg();
				break;
			default:
				System.out.println("Usage:");
				System.out.println("    -f: file to process");
				System.out.println("    -o: output");
				break;
			}
		}
		
		File file = new File(pFile, pOutput);
		boolean fileSuccess = file.processFile();
		
	}
	
	
}
