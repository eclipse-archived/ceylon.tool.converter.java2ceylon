import ceylon.test {
	test,
	assertEquals
}
import ceylon.tool.converter.java2ceylon {
	convert
}
import java.io {
	File
}
import java.lang {
	System
}
import org.apache.commons.io {
	FileUtils
}

shared void testFiles(String javaFileName, String ceylonFileName) {
	convert(javaFileName + ".java", "testFiles/testConvertedFile.ceylon", true);
	File file1 = File(ceylonFileName + ".ceylon");
	File file2 = File("testFiles/testConvertedFile.ceylon");
	assertEquals(FileUtils.readFileToString(file2), FileUtils.readFileToString(file1));
}

test
shared void testAbstract() {
	String workingDir = System.getProperty("user.dir");
	String javaFileName = workingDir + "/testFiles/TestAbstract";
	String ceylonFileName = workingDir + "/testFiles/testAbstract";
	testFiles(javaFileName, ceylonFileName);
}

test
shared void testAnonymousClass() {
	String workingDir = System.getProperty("user.dir");
	String javaFileName = workingDir + "/testFiles/TestAnonymousClass";
	String ceylonFileName = workingDir + "/testFiles/testAnonymousClass";
	testFiles(javaFileName, ceylonFileName);
}

test
shared void testArrays() {
	String workingDir = System.getProperty("user.dir");
	String javaFileName = workingDir + "/testFiles/TestArrays";
	String ceylonFileName = workingDir + "/testFiles/testArrays";
	testFiles(javaFileName, ceylonFileName);
}

test
shared void testArrays2() {
	String workingDir = System.getProperty("user.dir");
	String javaFileName = workingDir + "/testFiles/TestArrays2";
	String ceylonFileName = workingDir + "/testFiles/testArrays2";
	testFiles(javaFileName, ceylonFileName);
}

test
shared void testClass() {
	String workingDir = System.getProperty("user.dir");
	String javaFileName = workingDir + "/testFiles/TestClass";
	String ceylonFileName = workingDir + "/testFiles/testClass";
	testFiles(javaFileName, ceylonFileName);
}

test
shared void testConstructors() {
	String workingDir = System.getProperty("user.dir");
	String javaFileName = workingDir + "/testFiles/TestConstructors";
	String ceylonFileName = workingDir + "/testFiles/testConstructors";
	testFiles(javaFileName, ceylonFileName);
}

test
shared void testDoWhile() {
	String workingDir = System.getProperty("user.dir");
	String javaFileName = workingDir + "/testFiles/TestDoWhile";
	String ceylonFileName = workingDir + "/testFiles/testDoWhile";
	testFiles(javaFileName, ceylonFileName);
}

test
shared void testExpressions() {
	String workingDir = System.getProperty("user.dir");
	String javaFileName = workingDir + "/testFiles/TestExpressions";
	String ceylonFileName = workingDir + "/testFiles/testExpressions";
	testFiles(javaFileName, ceylonFileName);
}

test
shared void testExpressions2() {
	String workingDir = System.getProperty("user.dir");
	String javaFileName = workingDir + "/testFiles/TestExpressions2";
	String ceylonFileName = workingDir + "/testFiles/testExpressions2";
	testFiles(javaFileName, ceylonFileName);
}

test
shared void testFor() {
	String workingDir = System.getProperty("user.dir");
	String javaFileName = workingDir + "/testFiles/TestFor";
	String ceylonFileName = workingDir + "/testFiles/testFor";
	testFiles(javaFileName, ceylonFileName);
}

test
shared void testFor2() {
	String workingDir = System.getProperty("user.dir");
	String javaFileName = workingDir + "/testFiles/TestFor2";
	String ceylonFileName = workingDir + "/testFiles/testFor2";
	testFiles(javaFileName, ceylonFileName);
}

test
shared void testGenerics() {
	String workingDir = System.getProperty("user.dir");
	String javaFileName = workingDir + "/testFiles/TestGenerics";
	String ceylonFileName = workingDir + "/testFiles/testGenerics";
	testFiles(javaFileName, ceylonFileName);
}

test
shared void testGenerics2() {
	String workingDir = System.getProperty("user.dir");
	String javaFileName = workingDir + "/testFiles/TestGenerics2";
	String ceylonFileName = workingDir + "/testFiles/testGenerics2";
	testFiles(javaFileName, ceylonFileName);
}

test
shared void testIf() {
	String workingDir = System.getProperty("user.dir");
	String javaFileName = workingDir + "/testFiles/TestIf";
	String ceylonFileName = workingDir + "/testFiles/testIf";
	testFiles(javaFileName, ceylonFileName);
}

test
shared void testImports() {
	String workingDir = System.getProperty("user.dir");
	String javaFileName = workingDir + "/testFiles/TestImports";
	String ceylonFileName = workingDir + "/testFiles/testImports";
	testFiles(javaFileName, ceylonFileName);
}

test
shared void testMethod1() {
	String workingDir = System.getProperty("user.dir");
	String javaFileName = workingDir + "/testFiles/TestMethod";
	String ceylonFileName = workingDir + "/testFiles/testMethod";
	testFiles(javaFileName, ceylonFileName);
}

test
shared void testMethod2() {
	String workingDir = System.getProperty("user.dir");
	String javaFileName = workingDir + "/testFiles/TestMethod2";
	String ceylonFileName = workingDir + "/testFiles/testMethod2";
	testFiles(javaFileName, ceylonFileName);
}

test
shared void testInterface1() {
	String workingDir = System.getProperty("user.dir");
	String javaFileName = workingDir + "/testFiles/TestInterface";
	String ceylonFileName = workingDir + "/testFiles/testInterface";
	testFiles(javaFileName, ceylonFileName);
}

test
shared void testInterface2() {
	String workingDir = System.getProperty("user.dir");
	String javaFileName = workingDir + "/testFiles/TestInterface2";
	String ceylonFileName = workingDir + "/testFiles/testInterface2";
	testFiles(javaFileName, ceylonFileName);
}

test
shared void testSwitch() {
	String workingDir = System.getProperty("user.dir");
	String javaFileName = workingDir + "/testFiles/TestSwitch";
	String ceylonFileName = workingDir + "/testFiles/testSwitch";
	testFiles(javaFileName, ceylonFileName);
}

test
shared void testTypeCast() {
	String workingDir = System.getProperty("user.dir");
	String javaFileName = workingDir + "/testFiles/TestTypeCast";
	String ceylonFileName = workingDir + "/testFiles/testTypeCast";
	testFiles(javaFileName, ceylonFileName);
}

test
shared void testVariableDeclaration() {
	String workingDir = System.getProperty("user.dir");
	String javaFileName = workingDir + "/testFiles/TestVariableDeclaration";
	String ceylonFileName = workingDir + "/testFiles/testVariableDeclaration";
	testFiles(javaFileName, ceylonFileName);
}

test
shared void testGetterSetter() {
	String workingDir = System.getProperty("user.dir");
	String javaFileName = workingDir + "/testFiles/TestGetterSetter";
	String ceylonFileName = workingDir + "/testFiles/testGetterSetter";
	testFiles(javaFileName, ceylonFileName);
}

test
shared void testEnums() {
	String workingDir = System.getProperty("user.dir");
	String javaFileName = workingDir + "/testFiles/TestEnums";
	String ceylonFileName = workingDir + "/testFiles/testEnums";
	testFiles(javaFileName, ceylonFileName);
}
