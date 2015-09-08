shared class TestEscaping() {

variable IntArray \imodule;
shared String \iCONSTANT = "bwaaaaaaaa!";
shared void \iin(variable IntArray \imodule) {
variable Integer a = \imodule.get(1);
\iin(\imodule);
this.\imodule = \imodule;
for (Package \ifunction in \imodule.allVisiblePackages) {
}
}

shared void \iLOUD() {
print(\iCONSTANT);
print(TestEscaping.\iCONSTANT);
print(TestEscaping.InnerClass.\iOTHER_CONSTANT);
variable String \iUPPERCASE = "WHY ARE YOU SHOUTING?";
\iLOUD();
}

class InnerClass() {

String \iOTHER_CONSTANT = ":(";
}
}
