shared class TestFor() {

shared void foo() {
variable Integer i = 0;
while(i < 5) {
print(i);
i++;
}
variable Integer i = 0;
while(i < 5) {
print(i);
i += 2;
}
variable Integer i = 5;
while(i >= 0) {
print(i);
i -= 2;
}
}

}
