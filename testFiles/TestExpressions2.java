package ceylon.tool.converter.java2ceylon.testFiles;

public class TestExpressions2 {
	public void foo() {
		boolean a = true;
		int b = 5, c = 7;

		b = (2 * b + (b + (c + c)));

		if ((a && (b + c) > 11) || (!a && (c < 6))) {

		}
	}
}
