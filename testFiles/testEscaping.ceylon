shared class TestEscaping() {

IntArray \imodule;
shared String \iCONSTANT = "bwaaaaaaaa!";
shared void \iin(IntArray \imodule) {
Integer a = \imodule.get(1);
\iin(\imodule);
this.\imodule = \imodule;
for (Package \ifunction in \imodule.allVisiblePackages) {
}
}

shared void \iLOUD() {
print(\iCONSTANT);
print(TestEscaping.\iCONSTANT);
print(TestEscaping.InnerClass.\iOTHER_CONSTANT);
String \iUPPERCASE = "WHY ARE YOU SHOUTING?";
\iLOUD();
}

class InnerClass() {

String \iOTHER_CONSTANT = ":(";
}
}
