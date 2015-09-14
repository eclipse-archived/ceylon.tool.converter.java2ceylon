shared class TestClass() extends TestFor() satisfies TestInterface & TestInterface2 {

String foo = "foo";
shared String foo() {
return this.foo;
}

}
