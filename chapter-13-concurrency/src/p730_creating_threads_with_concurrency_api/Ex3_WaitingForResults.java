package p730_creating_threads_with_concurrency_api;

import java.util.concurrent.*;

/**
 *
 */
public class Ex3_WaitingForResults {
    private static int counter = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();

        try {
            Future<?> result = service.submit(() -> {
                for (int i = 0; i < 1_000_000; i++) {
                    counter++;
                }
            });
            result.get(1, TimeUnit.MILLISECONDS);
            System.out.println("Reached! " + counter);
        } catch (TimeoutException e) {
            System.out.println("Not reached in time!");
        } finally {
            System.out.println("Finishing...");
            service.shutdown();
            System.out.println("Shutdown: " + service.isShutdown());
        }
        System.out.println("Terminated: " + service.isTerminated());
    }
}
