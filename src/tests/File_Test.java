package tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import main_program.File;

import org.junit.Test;

public class File_Test {

	@Test (expected = FileNotFoundException.class)
	public void fileNotFound() throws FileNotFoundException {
		File file = new File("testNotFound.xtx");
	}

}
