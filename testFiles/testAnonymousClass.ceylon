shared class TestAnonymousClass() {

shared interface Foo {
shared formal void a();
shared formal void b(Integer x, Integer y);
}
shared abstract class Bar {

shared new (Integer x, Integer y) {
}

shared formal void a();

shared formal void b(Integer x, Integer y);

}
shared void foo() {
Foo f = object satisfies Foo {

shared void a() {
}

shared void b(Integer x, Integer y) {
}

}
;
Bar b = object extends Bar(1, 1) {

shared actual void b(Integer x, Integer y) {
}

shared actual void a() {
}

}
;
}

}
