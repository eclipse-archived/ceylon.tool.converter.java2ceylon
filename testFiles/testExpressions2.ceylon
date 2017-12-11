shared class TestExpressions2() {

shared void foo() {
Boolean a = true;
variable Integer b = 5;
Integer c = 7;
b = (2 * b + (b + (c + c)));
if ((a && (b + c) > 11) || (!a && (c < 6))) {
}
}

}
