public class TestEscaping {
    private int[] module;
    public static final String CONSTANT = "bwaaaaaaaa!";

    public void in(int[] module) {
        int a = module[1];
        in(module);
        this.module = module;

        for (final Package function : module.getAllVisiblePackages()) {
        }
    }

    public void LOUD() {
        System.out.println(CONSTANT);
        System.out.println(TestEscaping.CONSTANT);
        System.out.println(TestEscaping.InnerClass.OTHER_CONSTANT);
        String UPPERCASE = "WHY ARE YOU SHOUTING?";
        LOUD();
    }

    private static class InnerClass {
        static final String OTHER_CONSTANT = ":(";
    }
}