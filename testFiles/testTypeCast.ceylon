shared class TestTypeCast() {

shared class A() {

}
shared class X() extends A() {

}
class C() {

shared variable A a;
}
shared void foo() {
variable A a = A();
Boolean b = a is X;
if (is X a) {
variable X x1 = a;
}
assert(is X x2 = a);
variable C c = C();
if (c.a is X) {
variable X x3 = c.a;
}
}

}
