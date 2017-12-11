shared class TestEnums {
shared actual String string;
shared new \iSUNDAY { string = "SUNDAY"; }
shared new \iMONDAY { string = "MONDAY"; }
shared new \iTUESDAY { string = "TUESDAY"; }
shared new \iWEDNESDAY { string = "WEDNESDAY"; }
shared new \iTHURSDAY { string = "THURSDAY"; }
shared new \iFRIDAY { string = "FRIDAY"; }
shared new \iSATURDAY { string = "SATURDAY"; }
}
shared class Languages {
shared actual String string;
shared Integer score;
abstract new \iLanguages(String string, Integer score) {
this.string = string;
this.score = score;
}

shared new \iJAVA extends \iLanguages("JAVA", 8) { }
shared new \iSCALA extends \iLanguages("SCALA", 0) { }
shared new \iCEYLON extends \iLanguages("CEYLON", 10) { }
}
