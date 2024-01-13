package p740_writing_thread_safe_code;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/** PROTECTING DATA WITH ATOMIC CLASSES - PAG. 742
 *  Atomic is the property of an operation to be carried out as a single
 *  unit of execution without any interference from another tread.
 */
public class Ex3_AtomicClasses {
    private AtomicInteger sheepCount = new AtomicInteger(0);

    private void incrementAndReport() {
        System.out.print(sheepCount.incrementAndGet() + " ");
    }

    /**
     * what does this program output in? It may in different order. Worse yet, it may print some numbers twice.
     *
     *            <- Reads sheepCount as 1                  Reads sheepCount as 2 ->
     * Thread One <----------------------->  Shared Memory <-----------------------> Thread Two
     *            Writes sheepCount as 2 ->                <- Writes sheepCount as 3
     *
     */

    // Unlike our previous sample output,
    // the numbers 1 through 10 will always be printed,
    // although the order is still not guaranteed.
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        try {
            Ex3_AtomicClasses manage = new Ex3_AtomicClasses();
            for (int i = 0; i < 10; i++) {
                service.submit(() -> manage.incrementAndReport());
            }
        } finally {
            service.shutdown();
        }
    }
}
