package com.redhat.ceylon.testFiles;

public class TestAnonymousClass {
	public interface Foo {
		public void a();

		public void b(int x, int y);
	}

	public abstract class Bar {
		public Bar(int x, int y) {

		}

		public abstract void a();

		public abstract void b(int x, int y);
	}

	public void foo() {
		Foo f = new Foo() {

			public void a() {
			}

			public void b(int x, int y) {
			}
		};

		Bar b = new Bar(1, 1) {

			@Override
			public void b(int x, int y) {
			}

			@Override
			public void a() {
			}
		};
	}
}