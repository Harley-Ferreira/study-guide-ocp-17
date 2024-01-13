package p722_introducing_threads;

/** POLLING WITH SLEEP - PAG. 727*/
public class Ex4_PollingWithSleep {

    private static int counter = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) counter++;
        }).start();

        while (counter < 1_000_000) {
            System.out.println("Not reached yet");
            try {
                Thread.sleep(1);  // Polling with sleep.
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }

        System.out.println("Reached: " + counter);

        // Using join(), makes the second thread execute just after first is executed
        var thread1 = new Thread(() -> {for (int i = 0; i < 50; i++) System.out.println("Printing record #1: " + i);});
        var thread2 = new Thread(() -> {for (int i = 0; i < 50; i++) System.out.println("Printing record #2: " + i);});
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread2.start();
    }

    // SEE MORE: join() and yield()
}