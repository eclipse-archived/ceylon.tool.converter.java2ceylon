package com.redhat.ceylon.testFiles;

public class TestTypeCast {

	public class A {

	}

	public class X extends A {

	}
	
	class C {
	    public A a;
	}

	public void foo() {
		A a = new A();
		
		final boolean b = a instanceof X;

		if (a instanceof X) {
			X x1 = (X) a; // should only remove typecast
		}

		X x2 = (X) a; // should convert to assert
		
		C c = new C();
		
		if (c.a instanceof X) {
		    X x3 = (X) c.a; // what to do here??!
		}
	}
}
