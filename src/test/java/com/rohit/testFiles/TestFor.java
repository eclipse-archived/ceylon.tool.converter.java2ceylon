package com.rohit.testFiles;

public class TestFor {
	public void foo() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}

		for (int i = 0; i < 5; i += 2) {
			System.out.println(i);
		}

		for (int i = 5; i >= 0; i -= 2)
			System.out.println(i);
	}
}