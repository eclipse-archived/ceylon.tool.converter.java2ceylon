class TestAssert() {

void func() {
assert(false);
"ok"
assert(true);
// "not" + "a" + "string" + "literal"
assert(1 + 2 == 3);
// eventPath + " not in " + srcRootPath
assert(eventPath.startsWith(srcRootPath));
}

}
