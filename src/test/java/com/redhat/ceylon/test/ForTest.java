package com.redhat.ceylon.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.redhat.ceylon.converter.Main;

public class ForTest {
	String workingDir = System.getProperty("user.dir");
	String testFile = workingDir + "/src/test/java/com/redhat/ceylon/testFiles/";
	String convertedFile = "src/test/java/com/redhat/ceylon/testFiles/testConvertedFile.ceylon";
	File file1 = new File(convertedFile);
	String ceylonFile = "src/test/java/com/redhat/ceylon/testFiles/";

	@Test
	public void testFor() throws IOException {
		Main.main(new String[] { testFile + "TestFor.java", convertedFile });
		File file2 = new File(ceylonFile + "testFor.ceylon");
		assertTrue("For test failed", FileUtils.contentEquals(file1, file2));
	}
	
	@Test
	public void testFor2() throws IOException {
		Main.main(new String[] { testFile + "TestFor2.java", convertedFile });
		File file2 = new File(ceylonFile + "testFor2.ceylon");
		assertTrue("For each test failed", FileUtils.contentEquals(file1, file2));
	}
}
