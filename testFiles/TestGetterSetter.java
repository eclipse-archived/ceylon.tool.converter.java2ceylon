package com.redhat.ceylon.testFiles;

public class TestMethod {
	public void foo() {
		String a = foo.method();
		a = foo.isMethod();
		foo.getMethod();
		a = foo.getMethod(true);
		foo.setMethod();
		foo.setMethod(true);

		a = foo.getBar().getBaz().method().getFoo().toString();
		a = foo.getPackage().getModule().getShared().getObject();
		a = foo.toString();
		a = foo.toString(a);

		int b = foo.hashCode();
		b = foo.hashCode(a);
		
		Runtime.getRuntime().exec("");
		
		System.out.println(toString());
	}
}
