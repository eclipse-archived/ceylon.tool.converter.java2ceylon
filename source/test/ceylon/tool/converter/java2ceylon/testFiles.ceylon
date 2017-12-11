/********************************************************************************
 * Copyright (c) 2011-2017 Red Hat Inc. and/or its affiliates and others
 *
 * This program and the accompanying materials are made available under the 
 * terms of the Apache License, Version 2.0 which is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * SPDX-License-Identifier: Apache-2.0 
 ********************************************************************************/
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

shared void testFiles(String suffix, Boolean transformGetters = true, Boolean useValues = false) {
    String workingDir = System.getProperty("ceylon.cwd");
    String javaFileName = workingDir + "/testFiles/Test" + suffix;
    String ceylonFileName = workingDir + "/testFiles/test" + suffix;

	convert(javaFileName + ".java", workingDir + "/testFiles/testConvertedFile.ceylon", transformGetters, useValues);
	File file1 = File(ceylonFileName + ".ceylon");
	File file2 = File(workingDir + "/testFiles/testConvertedFile.ceylon");
	assertEquals(FileUtils.readFileToString(file2), FileUtils.readFileToString(file1));
}

test
shared void testAbstract() {
	testFiles("Abstract");
}

test
shared void testAnonymousClass() {
	testFiles("AnonymousClass");
}

test
shared void testArrays() {
	testFiles("Arrays");
}

test
shared void testArrays2() {
	testFiles("Arrays2");
}

test
shared void testAssert() {
	testFiles("Assert");
}

test
shared void testClass() {
	testFiles("Class");
}

test
shared void testConstructors() {
	testFiles("Constructors");
}

test
shared void testConstructors2() {
	testFiles("Constructors2");
}

test
shared void testDoWhile() {
	testFiles("DoWhile");
}

test
shared void testExpressions() {
	testFiles("Expressions");
}

test
shared void testExpressions2() {
	testFiles("Expressions2");
}

test
shared void testFor() {
	testFiles("For");
}

test
shared void testFor2() {
	testFiles("For2");
}

test
shared void testGenerics() {
	testFiles("Generics");
}

test
shared void testGenerics2() {
	testFiles("Generics2");
}

test
shared void testIf() {
	testFiles("If");
}

test
shared void testImports() {
	testFiles("Imports");
}

test
shared void testMethod1() {
	testFiles("Method");
}

test
shared void testMethod2() {
	testFiles("Method2");
}

test
shared void testInterface1() {
	testFiles("Interface");
}

test
shared void testInterface2() {
	testFiles("Interface2");
}

test
shared void testSwitch() {
	testFiles("Switch");
}

test
shared void testTypeCast() {
	testFiles("TypeCast");
}

test
shared void testVariableDeclaration() {
	testFiles("VariableDeclaration");
}

test
shared void testGetterSetter() {
	testFiles("GetterSetter");
}

test
shared void testEnums() {
	testFiles("Enums");
}

test
shared void testSingleMethod() {
    testFiles("SingleMethod");
}

test
shared void testTryCatch() {
    testFiles("TryCatch");
}

test
shared void testWhile() {
    testFiles("While");
}

test
shared void testExists() {
    testFiles("Exists");
}

test
shared void testEscaping() {
    testFiles("Escaping");
}

test
shared void testValues() {
    testFiles("Values", true, true);
}

test
shared void testOptional() {
	testFiles("Optional");
}

test
shared void testLambda() {
	testFiles("Lambda");
}

test
shared void testDeclaration() {
	testFiles("Declaration");
}

test
shared void testSingleStatement() {
	testFiles("SingleStatement");
}

test
shared void testDouble() {
	testFiles("Double");
}

test
shared void testVarargs() {
	testFiles("Varargs");
}