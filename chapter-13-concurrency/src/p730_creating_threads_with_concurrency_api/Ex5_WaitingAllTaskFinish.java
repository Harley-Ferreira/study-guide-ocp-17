package p730_creating_threads_with_concurrency_api;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ex5_WaitingAllTaskFinish {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            makeSomething();
        } finally {
            service.shutdown();
        }

        service.awaitTermination(1, TimeUnit.MINUTES);

        if (service.isTerminated()) {
            System.out.println("Finished!");
        } else {
            System.out.println("At least one task is still running");
        }
    }

    private static void makeSomething() {
        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Printing record: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        new Thread(printRecords).run();
    }
}
