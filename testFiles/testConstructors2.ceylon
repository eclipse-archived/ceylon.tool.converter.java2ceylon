shared class Test2 {

Integer a;
Float b;
shared new (Integer a, Float b) {
this.a = a;
this.b = b;
}

}
shared class TestConstructors2 extends Test2 {

shared new (Integer a, Float b) extends Test2(a, b) {
}

}
