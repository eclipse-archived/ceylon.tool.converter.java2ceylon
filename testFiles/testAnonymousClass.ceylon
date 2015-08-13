shared class TestAnonymousClass() {

shared interface Foo {
shared formal void a();
shared formal void b(variable Integer x, variable Integer y);
}
shared abstract class Bar() {

shared new (variable Integer x, variable Integer y) {
}

shared formal void a();

shared formal void b(variable Integer x, variable Integer y);

}
shared void foo() {
variable Foo f = object satisfies Foo {

shared void a() {
}

shared void b(variable Integer x, variable Integer y) {
}

}
;
variable Bar b = object extends Bar(1, 1) {

shared actual void b(variable Integer x, variable Integer y) {
}

shared actual void a() {
}

}
;
}

}
