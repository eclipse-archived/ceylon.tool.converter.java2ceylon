shared class TestMethod2() {

shared Integer foo(variable Integer a, variable Integer b) {
return b;
}

shared Integer bar(variable Float c, variable Integer d) {
return d;
}

shared void main() {
foo(1, bar(3.14, foo(1, 1)));
}

}
