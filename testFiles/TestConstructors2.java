package com.redhat.ceylon.testFiles;

public class Test2 {
    private int a;
    private float b;
    
    public Test2(int a, float b) {
        this.a = a;
        this.b = b;
    }
}

public class TestConstructors2 extends Test2 {
    
    public TestConstructors2(int a, float b) {
        super(a, b);
    }
}