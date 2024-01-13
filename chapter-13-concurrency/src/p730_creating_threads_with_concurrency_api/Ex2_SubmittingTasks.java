package p730_creating_threads_with_concurrency_api;

import java.util.concurrent.*;

/**
 * The execute() method takes a Runnable instance and completes the task asynchronously.
 * Like the execute()  submit() method takes a Runnable instance and completes
 * the task asynchronously, but return a Future instance.
 * invokeAl() is synchronously, so wait for at least one complete and return a Future object.
 */
public class Ex2_SubmittingTasks {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService service = Executors.newSingleThreadExecutor();

        Runnable printInventory = () -> makeSomething("I don't know");

        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Printing record: " + i);
            }
        };

        try {
            Future<?> future = service.submit(printInventory);
            future.get(1, TimeUnit.SECONDS);
            if (future.isDone()) {
                System.out.println(future.isDone());
                service.submit(printRecords);
            }
        } finally {
            System.out.println("Finishing...");
            service.shutdown();
            System.out.println("Shutdown: " + service.isShutdown());
        }
        System.out.println("Terminated: " + service.isTerminated());
    }

    private static void makeSomething(String some) {
        if (some.length() > 6) {
            System.out.println("good");
        } else {
            System.out.println("bad");
        }
    }
}
