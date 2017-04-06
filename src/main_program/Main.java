package main_program;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		boolean fileSuccess = file.processFile();
	}
	
	
}
