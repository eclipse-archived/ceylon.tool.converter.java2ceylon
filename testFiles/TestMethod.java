package com.redhat.ceylon.testFiles;

public class TestMethod {
	public void foo() {
	    throw new Exception();
	}
	
	public int bar(int a, final float b) {
		return a;
	}
	
	public String getName() {
	    return "Trompon";
	}
	
	@Override
	public String toString() {
	    return super.toString();
	}
}
