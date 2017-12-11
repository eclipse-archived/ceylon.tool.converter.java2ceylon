public void testExists() {
    if (foo == null) {}
    if (foo.bar == null) {}
    if (foo != null) {}
    if (foo.bar != null) {}
    final boolean baz = foo != null;
}