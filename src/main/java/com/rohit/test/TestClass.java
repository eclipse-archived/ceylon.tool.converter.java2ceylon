package com.rohit.test;

public class TestClass {

	public final int f = 2;

	public float foo(int x, int y, int z, float a) {
		float c = 1 + y + a;
		return c;
	}

	public void bar(int b, boolean c) {
		final int d = 4;

		if (b == 5 && c || b < 2) {
			b = 5;
		} else if (b < 4) {
			b = 2;
		} else {
			b = 0;
		}

		int a = 4;

		foo(a, b, a, 1.5f);

		switch (b) {
		case 1:
			a = 1;
			break;
		case 2:
			a = 2;
		default:
			a = 4;
			break;
		}

		for (int i = a; i <= b; i++) {
			b = 6;
		}

	}
}