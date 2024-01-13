package p730_creating_threads_with_concurrency_api;

import java.util.concurrent.*;

public class Ex6_SchedulingTasks {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable task1 = () -> System.out.println("Hello Zoo");
        Callable<String> task2 = () -> "Monkey";
        ScheduledFuture<?> r1 = service.schedule(task1, 10, TimeUnit.SECONDS);
        // service.shutdown(); If we shutdown de service, so r1 will be executed but not r2, also an exception is executed when try to execute r2.
        ScheduledFuture<String> r2 = service.schedule(task2, 15, TimeUnit.SECONDS);
        System.out.println(r2.get());

    }

    /**
     * Se more
     * Executors.newCachedThreadPool();
     * Executors.newFixedThreadPool();
     */
}
