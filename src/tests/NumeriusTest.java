package tests;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.Test;

import parser.Numerius;
import parser.Parser;

public class NumeriusTest {

	@Test
	public void test() {
		Numerius tester = new Numerius();
		
		Parser.setLine("1");
		assertEquals("line: 1", 1, tester.parseInt(0));
		
		Parser.setLine("210");
		assertEquals("line: 210", 3, tester.parseInt(0));
		
		Parser.setLine("-2");
		assertEquals("line: -2", 2, tester.parseInt(0));
		
		Parser.setLine("a");
		assertEquals("line: a", 0, tester.parseInt(0));
		
		Parser.setLine("abd");
		assertEquals("line: abd", 0, tester.parseInt(0));
		
		Parser.setLine("a5");
		assertEquals("line: a5", 0, tester.parseInt(0));
		
		Parser.setLine("56ab");
		assertEquals("line: 56ab", 2, tester.parseInt(0));
		
		Parser.setLine("1-");
		assertEquals("line: 1-", 1, tester.parseInt(0));
		
		Parser.setLine("-5a");
		assertEquals("line: -5a", 2, tester.parseInt(0));
		
		Parser.setLine("5-a");
		assertEquals("line: 5-a", 1, tester.parseInt(0));
		
		Parser.setLine("!?");
		assertEquals("line: !?", 0, tester.parseInt(0));
		
		Parser.setLine("67!?");
		assertEquals("line: 67!?", 2, tester.parseInt(0));
		
	}
	
	@Test (expected = InvalidParameterException.class)
	public void test2() {
		Numerius tester = new Numerius();
		
		Parser.setLine("390");
		tester.parseInt(-1);
	}
	
	@Test (expected = InvalidParameterException.class)
	public void test3() {
		Numerius tester = new Numerius();
		
		Parser.setLine("390");
		tester.parseInt(3);
	}
	
	@Test
	public void test4() {
		Numerius tester = new Numerius();
		
		Parser.setLine("ABC 146 DEF");
		assertEquals("line: ABC 146 DEF, offset: 4", 7, tester.parseInt(4));
		
		Parser.setLine("ABC 146 DEF");
		assertEquals("line: ABC 146 DEF, offset: 2", 0, tester.parseInt(2));
		
		Parser.setLine("ABC 146 DEF");
		assertEquals("line: ABC 146 DEF, offset: 5", 7, tester.parseInt(5));
	}

}
