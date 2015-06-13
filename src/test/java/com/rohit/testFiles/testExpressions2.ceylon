shared class TestExpressions2() {
shared void foo() {
variable Boolean a = true;
variable Integer b = 5;
variable Integer c = 7;
b=(2 * b + (b + (c + c)));
if((a && (b + c) > 11) || (!a && (c < 6))){
}
}
}