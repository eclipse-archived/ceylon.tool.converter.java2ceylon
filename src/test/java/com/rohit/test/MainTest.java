package com.rohit.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.rohit.converter.Main;

public class MainTest {

	String workingDir = System.getProperty("user.dir");
	String testFile = workingDir + "/src/test/java/com/rohit/test/";
	String convertedFile = "src/test/java/com/rohit/test/testConvertedFile.ceylon";
	String ceylonFile = "src/test/java/com/rohit/test/";

	@Test
	public void testMethod() throws IOException {
		Main.main(new String[]{testFile + "TestMethod.java", convertedFile});
		File file1 = new File(convertedFile);
		File file2 = new File(ceylonFile + "testMethod.ceylon");
		assertTrue("Method test failed", FileUtils.contentEquals(file1, file2));
	}

	@Test
	public void testIf() throws IOException {
		Main.main(new String[]{testFile + "TestIf.java", convertedFile});
		File file1 = new File(convertedFile);
		File file2 = new File(ceylonFile + "testIf.ceylon");
		assertTrue("If test failed", FileUtils.contentEquals(file1, file2));
	}
	
	@Test
	public void testFor() throws IOException {
		Main.main(new String[]{testFile + "TestFor.java", convertedFile});
		File file1 = new File(convertedFile);
		File file2 = new File(ceylonFile + "testFor.ceylon");
		assertTrue("For test failed", FileUtils.contentEquals(file1, file2));
	}
	
	@Test
	public void testSwitch() throws IOException {
		Main.main(new String[]{testFile + "TestSwitch.java", convertedFile});
		File file1 = new File(convertedFile);
		File file2 = new File(ceylonFile + "testSwitch.ceylon");
		assertTrue("Switch test failed", FileUtils.contentEquals(file1, file2));
	}
}