shared class TestAnonymousClass() {
shared interface Foo {
formal shared void a();
formal shared void b(variable Integer x, variable Integer y);
}
abstract class Bar {
shared new (variable Integer x, variable Integer y){
}
shared formal void a();
shared formal void b(variable Integer x, variable Integer y);
}
shared void foo(){
variable Foo f = object satisfies Foo{
shared void a(){
}
shared void b(variable Integer x, variable Integer y){
}
}
;
variable Bar b = object extends Bar(1, 1){
actual shared void b(variable Integer x, variable Integer y){
}
actual shared void a(){
}
}
;
}
}
