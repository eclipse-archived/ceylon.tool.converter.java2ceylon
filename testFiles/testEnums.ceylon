shared class TestEnums {
shared actual String string;
shared new _SUNDAY { string = "SUNDAY"; }
shared new _MONDAY { string = "MONDAY"; }
shared new _TUESDAY { string = "TUESDAY"; }
shared new _WEDNESDAY { string = "WEDNESDAY"; }
shared new _THURSDAY { string = "THURSDAY"; }
shared new _FRIDAY { string = "FRIDAY"; }
shared new _SATURDAY { string = "SATURDAY"; }
}
shared class Languages {
shared actual String string;
shared variable Integer score;
abstract new _Languages(String string, variable Integer score) {
this.string = string;
this.score = score;
}

shared new _JAVA extends _Languages("JAVA", 8) { }
shared new _SCALA extends _Languages("SCALA", 0) { }
shared new _CEYLON extends _Languages("CEYLON", 10) { }
}
