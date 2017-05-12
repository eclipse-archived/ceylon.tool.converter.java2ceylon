shared class TestArrays2() {

shared ObjectArray<String> foo() {
Integer a = 5;
ObjectArray<TestArrays2> ta = ObjectArray<TestArrays2>(a);
ObjectArray<TestArrays2> ts = ObjectArray<TestArrays2>.with({TestArrays2(), TestArrays2()});
return ObjectArray<String>.with({"1", "2", "3", "4"});
}

shared IntArray bar() {
return IntArray.with({1, 2, 3, 4});
}

}
