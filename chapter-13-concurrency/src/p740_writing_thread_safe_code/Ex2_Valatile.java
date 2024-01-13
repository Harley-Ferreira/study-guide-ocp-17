package p740_writing_thread_safe_code;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex2_Valatile {
    private volatile int sheepCount = 0;

    private void incrementAndReport() {
        System.out.print((++sheepCount) + " ");
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        try {
            Ex2_Valatile manage = new Ex2_Valatile();
            for (int i = 0; i < 10; i++) {
                service.submit(() -> manage.incrementAndReport());
            }
        } finally {
            service.shutdown();
        }
    }
}
