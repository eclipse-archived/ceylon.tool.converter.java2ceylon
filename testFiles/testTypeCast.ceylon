shared class TestTypeCast() {

shared class A() {

}
shared class X() extends A() {

}
class C() {

shared A a;
}
shared void foo() {
A a = A();
Boolean b = a is X;
if (is X a) {
X x1 = a;
}
assert(is X x2 = a);
C c = C();
if (c.a is X) {
X x3 = c.a;
}
}

}
