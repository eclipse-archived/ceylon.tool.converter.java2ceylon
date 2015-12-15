shared class TestIf() {

shared void foo(variable Integer a, Integer b) {
if (a > b) {
a = b;
}
else if (a < b) {
a = b;
}
else {
a = b + 1;
}
if (a % b == 0) {
a = b;
}
String c = if (a > b) then "gt" else "lt";
}

}
