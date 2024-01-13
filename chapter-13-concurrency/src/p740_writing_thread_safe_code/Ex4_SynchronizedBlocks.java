package p740_writing_thread_safe_code;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * IMPROVING ACCESS WITH SYNCHRONIZED BLOCKS - PAG. 744
 * While atomic classes are great at protecting a single variable, they aren't
 * particularly useful if you need to execute a series of commands or call a method.
 * For example, we can't use them to update two atomic variables at the same time.
 * The most common technique is to use a monitor to synchronize access.
 */
public class Ex4_SynchronizedBlocks {
    private int sheepCount = 0;

    private void incrementAndReport() {
        synchronized (this) {
            System.out.print(++sheepCount + " ");
        }
    }

    // Although all threads are still created and executed at the same time, they each wait at the
    // synchronized block for the worker to increment and report the result before entering.
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        try {
            Ex4_SynchronizedBlocks manage = new Ex4_SynchronizedBlocks();
            for (int i = 0; i < 10; i++) {
                service.submit(() -> manage.incrementAndReport());
            }
        } finally {
            service.shutdown();
        }
    }
}
