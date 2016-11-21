class Lamba {
    public void func() {
        Runnable hello = () -> { System.out.println("hello"); };

        swingComponent.addActionListener(event -> System.out.println("event handler"));
    }
}