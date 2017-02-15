class TestAssert {
    void func() {
        assert false;
        assert true: "ok";
        assert 1 + 2 == 3: "not" + "a" + "string" + "literal";
        assert eventPath.startsWith(srcRootPath) : eventPath + " not in " + srcRootPath;
    }
}