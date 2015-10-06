package com.redhat.ceylon.testFiles;

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

		int j;
		for (j = 0; j < 10; j++) {
		}
	}
}