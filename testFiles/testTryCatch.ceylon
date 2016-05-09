shared class TestCatch() {

shared void testCatch() {
try {
foo();
}
catch (Exception e) {
print(e);
}
try {
foo();
}
catch (Exception1 e1) {
print(e1);
}
catch (Exception1 e2) {
print(e1);
}
try {
foo();
}
catch (Exception e) {
print(e);
}
finally {
print("done");
}
try {
foo();
}
catch (Exception1 e1) {
print(e1);
}
catch (Exception1 e2) {
print(e1);
}
finally {
print("done");
}
try (BufferedReader br = BufferedReader(FileReader(path))) {
return br.readLine();
}
try (BufferedReader br = BufferedReader(FileReader(path))) {
return br.readLine();
}
catch (Exception e) {
print(e);
}
finally {
print("done");
}
try {
foo();
}
catch (Exception | RuntimeException e) {
print(e);
}
}

}
