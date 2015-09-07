public class TestEscaping {
    private int[] module;

    public void in(int[] module) {
        int a = module[1];
        in(module);
        this.module = module;

        for (final Package candidate : module.getAllVisiblePackages()) {
        }
    }

    public void LOUD() {
        String UPPERCASE = "WHY ARE YOU SHOUTING?";
        LOUD();
    }
}