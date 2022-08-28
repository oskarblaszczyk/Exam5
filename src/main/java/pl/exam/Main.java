package pl.exam;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        linePrinter();

    }

    private static void linePrinter() throws InterruptedException {
        for (int i = 100; i >= 0; i--) {
            System.out.print("\r");
            System.out.print("X");
            for (int j = i; j > 0; j--) {
                System.out.print("-");
            }
            System.out.print("Y");
            Thread.sleep(100);
        }
        System.out.print("\rZDALEM TEST!!!");
    }
}
