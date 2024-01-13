package p722_introducing_threads;

/**
 * DISTINGUISHING THREAD TYPES - PAG. 725
 * user-defined thread and daemon thread
 */
public class Ex3_Zoo {

    public static void pause() {
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {

        }
        System.out.println("Thread finished");
    }

    public static void main(String[] args) {
        var job = new Thread(() -> pause());

        // job.setDaemon(true);
        job.start();
        System.out.println("Main method finished");
    }

    /*
    Without set daemon like true the result is:
    Main method finished
    (10 seconds wait)
    Thread finished

    With set daemon like true the result is:
    Main method finished
    */
}
