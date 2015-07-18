package com.redhat.ceylon.testFiles;

public class TestTypeCast {

	public class A {

	}

	public class X extends A {

	}

	public void foo() {
		A a = new A();

		if (a instanceof X) {
			X x1 = (X) a; // should only remove typecast
		}

		X x2 = (X) a; // should convert to assert
	}
}
