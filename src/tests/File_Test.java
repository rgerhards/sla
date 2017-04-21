package tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import main_program.File;

import org.junit.Test;

public class File_Test {

	@Test (expected = FileNotFoundException.class)
	public void fileNotFound() throws FileNotFoundException {
		String[] args = new String[1];
		args[0] = "testNotFound.xtx";
		File file = new File(args);
	}

}
