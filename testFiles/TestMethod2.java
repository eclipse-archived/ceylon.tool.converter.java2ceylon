package com.redhat.ceylon.testFiles;

public class TestMethod2 {
	public int foo(int a, int b) {
		return b;
	}

	public int bar(double c, int d) {
		return d;
	}

	public void main() {
		foo(1, bar(3.14, foo(1, 1)));
	}
}
