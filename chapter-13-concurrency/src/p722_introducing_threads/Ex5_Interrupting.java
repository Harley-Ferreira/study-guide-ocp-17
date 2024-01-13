package p722_introducing_threads;

/**
 * Interrupting a thread
 * */
public class Ex5_Interrupting {
    private static int counter = 0;

    public static void main(String[] args) {
        final var mainThread = Thread.currentThread();
        new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) counter++;
            mainThread.interrupt();
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
    }
}
