shared class TestIf() {

shared void foo(variable Integer a, variable Integer b) {
if (a > b) {
a = b;
}
else if (a < b) {
a = b;
}
else {
a = b + 1;
}
if (a % b === 0) {
a = b;
}
variable String c = if (a > b) then "gt" else "lt";
}

}
