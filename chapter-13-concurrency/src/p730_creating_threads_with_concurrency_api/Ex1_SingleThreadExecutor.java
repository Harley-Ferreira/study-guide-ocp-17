package p730_creating_threads_with_concurrency_api;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Ex1_SingleThreadExecutor {

    // CREATE A MANAGE THREADS, UNLIKE THE LAST EXAMPLE, IN THIS WE HAVE JUST ONE THREAD
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();

        Runnable printInventory = () -> System.out.println("Printing zoo inventory");
        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Printing record: " + i);
            }
        };

        /**
         * A thread executor creates a non-daemon thread on the first task that is executed,
         * so failing to call shutdown() will result in your application never terminating.
         */
        try {
            System.out.println("shutdown 1 = " + service.isShutdown());
            System.out.println("terminated 1 = " + service.isTerminated());
            System.out.println("begin");

            /* When we are using execute() we submit a task.
            *  We can submit tasks to an ExecuteService instance multiple ways. */
            service.execute(printInventory);
            service.execute(printRecords);
            service.execute(printInventory);
            System.out.println("end");
            System.out.println("shutdown 2 = " + service.isShutdown());
            System.out.println("terminated 2 = " + service.isTerminated());

        } finally {
            System.out.println("shutdown 3 = " + service.isShutdown());
            System.out.println("terminated 3 = " + service.isTerminated());
            var a = service.submit(printInventory);
            /* The shutdown() does not stop any tasks that
               have already been submitted to the thread executor,
               so when call service.execute(printInventory) above
               and so service.shutdown() the thread just stop when
               service.execute(printInventory) to finish. */
            service.shutdown();
            System.out.println("shutdown 4 = " + service.isShutdown());
            System.out.println("terminated 4 = " + service.isTerminated());

        }
        System.out.println("shutdown 5 = " + service.isShutdown());
        System.out.println("terminated 5 = " + service.isTerminated());
        System.out.println("terminated 5 = " + service.isTerminated());
    }
}
