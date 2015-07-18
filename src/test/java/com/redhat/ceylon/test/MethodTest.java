package com.redhat.ceylon.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.redhat.ceylon.converter.Main;

public class MethodTest {
	String workingDir = System.getProperty("user.dir");
	String testFile = workingDir + "/src/test/java/com/redhat/ceylon/testFiles/";
	String convertedFile = "src/test/java/com/redhat/ceylon/testFiles/testConvertedFile.ceylon";
	File file1 = new File(convertedFile);
	String ceylonFile = "src/test/java/com/redhat/ceylon/testFiles/";

	@Test
	public void testMethod() throws IOException {
		Main.main(new String[] { testFile + "TestMethod.java", convertedFile });
		File file2 = new File(ceylonFile + "testMethod.ceylon");
		assertTrue("Method test failed", FileUtils.contentEquals(file1, file2));
	}

	@Test
	public void testMethod2() throws IOException {
		Main.main(new String[] { testFile + "TestMethod2.java", convertedFile });
		File file2 = new File(ceylonFile + "testMethod2.ceylon");
		assertTrue("Method 2 test failed", FileUtils.contentEquals(file1, file2));
	}
}
