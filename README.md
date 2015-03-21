# Java to Ceylon Converter

This is a project to convert java to ceylon. 
The Main class generates an AST and converts the given java file to ceylon.
Right now it does basic conversions like `public class Foo {}` to `shared class Foo() {}`. 
The Main class requires 2 arguments - the location of the source java file and the destination ceylon file.
