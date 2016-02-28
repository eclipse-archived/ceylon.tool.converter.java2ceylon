shared class TestArrays2() {

shared ObjectArray<String> foo() {
Integer a = 5;
ObjectArray<TestArrays> ta = ObjectArray<TestArrays>(a);
return createJavaObjectArray<String>({"1", "2", "3", "4"});
}

shared IntArray bar() {
return createJavaIntArray({1, 2, 3, 4});
}

}
