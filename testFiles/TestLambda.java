class Lamba {
    public void func() {
        Runnable hello = () -> { System.out.println("hello"); };

        swingComponent.addActionListener(event -> System.out.println("event handler"));
        swingComponent.addActionListener((event) -> System.out.println("event handler"));
        swingComponent.addActionListener((Event event) -> System.out.println("event handler"));
        Collections.sort(strings, (s1, s2)-> s1.compareTo(s2));
    }
}