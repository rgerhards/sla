package tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Test_Runner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(File_TestSuite.class);
		for(Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		Result result2 = JUnitCore.runClasses(Parser_TestSuite.class);
		for(Failure failure : result2.getFailures()) {
			System.out.println(failure.toString());
		}
	}
}
