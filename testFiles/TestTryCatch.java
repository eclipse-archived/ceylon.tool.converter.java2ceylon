public class TestCatch {
    public void testCatch() {
        try {
            foo();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            foo();
        } catch (Exception1 e1) {
            System.out.println(e1);
        } catch (Exception1 e2) {
            System.out.println(e1);
        }

        try {
            foo();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("done");
        }

        try {
            foo();
        } catch (Exception1 e1) {
            System.out.println(e1);
        } catch (Exception1 e2) {
            System.out.println(e1);
        } finally {
            System.out.println("done");
        }

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("done");
        }
    }
}