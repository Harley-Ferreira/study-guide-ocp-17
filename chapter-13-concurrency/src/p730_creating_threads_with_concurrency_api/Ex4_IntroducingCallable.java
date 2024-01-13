package p730_creating_threads_with_concurrency_api;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * The Callable interface is often preferable over Runnable, since it allows more details
 * to be retrieved easily from the task after it is completed.
 */
public class Ex4_IntroducingCallable {
    public static void main(String[] args) throws Exception {

        ExecutorService service = Executors.newSingleThreadExecutor();

        try {
            Future<Integer> result = service.submit(() -> 30 + 11);
            System.out.println(result.get());
            System.out.println("HELLO");
        } finally {
            service.shutdown();
        }
    }
}
