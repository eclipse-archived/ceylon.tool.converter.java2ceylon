shared class TestExpressions() {
shared void foo(){
variable Integer a = 4;
variable Integer b = 3;
variable Integer c = --a + b++ + a;
c=b--;
a=(c * b) + (b / c) + (c % a);
a=a / (b + c);
}
}