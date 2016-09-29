shared class TestEscaping() {

IntArray \imodule;
shared String constant = "bwaaaaaaaa!";
shared void \iin(IntArray \imodule) {
Integer a = \imodule.get(1);
\iin(\imodule);
this.\imodule = \imodule;
for (Package \ifunction in \imodule.allVisiblePackages) {
}
}

shared void loud() {
print(constant);
print(TestEscaping.constant);
print(TestEscaping.InnerClass.otherConstant);
String uppercase = "WHY ARE YOU SHOUTING?";
loud();
}

class InnerClass() {

String otherConstant = ":(";
}
}
