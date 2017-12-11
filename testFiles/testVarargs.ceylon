shared class TestVarargs() {

shared void foo(String* args) {
}

shared void bar(Object* args) {
}

shared void baz(variable String* args) {
args = ObjectArray<String>.with({"1", "2", "3"});
}

}
