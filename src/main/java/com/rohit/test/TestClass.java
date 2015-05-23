package com.rohit.test;

public class TestClass {
	public int foo(int x, int y, int z, float a) {
		int c = x + y;
		return c;
	}
	
	public void bar(float b, boolean c) {
		if(b > 5 && c || b < 2) {
			b = 5;
		}
		int a = 4;
		for(int i = 0; i < b; i++) {
			b = 6;
		}
	}
}
