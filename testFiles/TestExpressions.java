package ceylon.tool.converter.java2ceylon.testFiles;

public class TestExpressions {
	public void foo() {
		int a = 4, b = 3;
		int c = --a + b++ + a;

		c = b--;

		a = (c * b) + (b / c) + (c % a);
		
		a = a / (b + c);
	}
}