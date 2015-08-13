shared class TestTypeCast() {

shared class A() {

}
shared class X() extends A() {

}
shared void foo() {
variable A a = A();
if (is X a) {
variable X x1 = a;
}
assert(is X x2 = a);
}

}
