package com.redhat.ceylon.testFiles;

public class TestArrays2 {
	public String[] foo() {
		int a = 5;
		TestArrays2[] ta = new TestArrays2[a];

		TestArrays2[] ts = new TestArrays2[] {new TestArrays2(), new TestArrays2()};

		return new String[] { "1", "2", "3", "4" };
	}
	public int[] bar() {
		return new int[]{1, 2, 3, 4};
	}
}
