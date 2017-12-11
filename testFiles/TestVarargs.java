public class TestVarargs {
    public void foo(String... args) {

    }
    public void bar(final Object... args) {

    }
    public void baz(String... args) {
        args = new String[]{"1", "2", "3"};
    }
}