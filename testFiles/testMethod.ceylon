shared class TestMethod() {

shared void foo() {
throw Exception();
}

shared Integer bar(Integer a, Float b) {
return a;
}

shared String name {
return "Trompon";
}

shared actual String string {
return super.string;
}

}
