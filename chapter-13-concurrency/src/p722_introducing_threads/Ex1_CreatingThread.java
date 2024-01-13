package p722_introducing_threads;

/**
 * CREATING A THREAD - PAG. 724
 */
public class Ex1_CreatingThread {

    // REMEMBER THAT ORDER OF THREAD EXECUTION IS NOT OFTEN GUARANTEED
    public static void main(String[] args) {
        new Thread(() -> System.out.println("Hello")).start();
        System.out.println("World");

        Runnable printInventory = () -> System.out.println("Printing zoo inventory");
        Runnable printRecords = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Printing record #1: " + i);
            }
        };
        Runnable printRecords2 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Printing record #2: " + i);
            }
        };

        // It is not possible to start a thread twice.
        System.out.println("begin");
        new Thread(printInventory).start();
        new Thread(printRecords).start();
        new Thread(printRecords2).start();
        new Thread(printInventory).start();
        System.out.println("end");

    }
}
