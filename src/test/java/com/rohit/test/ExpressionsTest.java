package com.rohit.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.rohit.converter.Main;

public class ExpressionsTest {
	String workingDir = System.getProperty("user.dir");
	String testFile = workingDir + "/src/test/java/com/rohit/testFiles/";
	String convertedFile = "src/test/java/com/rohit/testFiles/testConvertedFile.ceylon";
	File file1 = new File(convertedFile);
	String ceylonFile = "src/test/java/com/rohit/testFiles/";

	@Test
	public void testFor() throws IOException {
		Main.main(new String[] { testFile + "TestExpressions.java", convertedFile });
		File file2 = new File(ceylonFile + "testExpressions.ceylon");
		assertTrue("Expressions test failed", FileUtils.contentEquals(file1, file2));
	}
}
