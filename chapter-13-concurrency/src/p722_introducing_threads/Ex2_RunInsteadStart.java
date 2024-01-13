package p722_introducing_threads;

/**
 * CALLING run() INSTEAD OF start()
 * Calling run() on a Thread or Runnable does not start a new thread.
 */
public class Ex2_RunInsteadStart {

    // UNLIKE THE PREVIOUS EXAMPLE, EACH LINE OF THIS CODE WILL WAIT
    // UNTIL THE run() METHOD IS COMPLETE BEFORE MOVING ON THE NEXT LINE.
    public static void main(String[] args) {

        Runnable printInventory = () -> System.out.println("Printing zoo inventory");
        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Printing record: " + i);
            }
        };

        System.out.println("begin");
        new Thread(printInventory).run();
        new Thread(printRecords).run();
        new Thread(printInventory).run();
        System.out.println("end");

    }
}
