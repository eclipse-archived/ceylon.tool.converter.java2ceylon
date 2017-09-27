package ceylon.tool.converter.java2ceylon.testFiles;

public class TestMethod {
    public void foo() {
        throw new Exception();
    }

    public int bar(int a, final float b) {
        return a;
    }

    public String getName() {
        return "Trompon";
    }

    @Override
    String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
