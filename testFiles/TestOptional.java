public class TestOptional {
	String a = null;
	String b = "Foo";

	public void foo() {

		b = null;

		String c = null;

		c = "hi";

		String d;

		//inside a block
		if (true) {
			d = null;
		}

		String e = "Bar";

	}
}