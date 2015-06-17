shared class TestArrays() {
shared void foo() {
variable IntArray a = IntArray(5);
variable Integer b;
a.set(2, 6);
b=a.get(4);
variable ObjectArray<TestClass> c = ObjectArray<TestClass>(b);
}
}