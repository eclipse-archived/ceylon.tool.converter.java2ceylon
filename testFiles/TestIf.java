package com.redhat.ceylon.testFiles;

public class TestIf {
	public void foo(int a, int b) {
		if(a > b) {
			a = b;
		} else if(a < b) {
			a = b;
		} else {
			a = b + 1;
		}
		
		if(a % b == 0) {
			a = b;
		}

		String c = a > b ? "gt" : "lt";
	}
}
