shared class TestFor() {
shared void foo() {
for(Integer i in (0..4).by(1)){
print(i);
}
for(Integer i in (0..4).by(2)){
print(i);
}
for(Integer i in (5..0).by(2)){
print(i);
}
}
}