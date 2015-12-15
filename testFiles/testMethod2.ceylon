shared class TestMethod2() {

shared Integer foo(Integer a, Integer b) {
return b;
}

shared Integer bar(Float c, Integer d) {
return d;
}

shared void main() {
foo(1, bar(3.14, foo(1, 1)));
}

}
