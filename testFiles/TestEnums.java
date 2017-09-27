package ceylon.tool.converter.java2ceylon.testFiles;

public enum TestEnums {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

public enum Languages {
    JAVA(8),
    SCALA(0),
    CEYLON(10);

    public int score;
    private Languages(int score) {
        this.score = score;
    }
}