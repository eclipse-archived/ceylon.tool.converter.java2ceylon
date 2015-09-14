package com.redhat.ceylon.testFiles;

public class TestClass extends TestFor implements TestInterface, TestInterface2 {
	final String foo = "foo";
	public String foo() {
		return this.foo;
	}
}
