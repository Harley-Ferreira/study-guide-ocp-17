package p740_writing_thread_safe_code;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * REENTRANTLOCK - PAG. 747
 *
 */
public class Ex6_ReentrantLock {
    public static void main(String[] args) {
        Object object = new Object();
        synchronized(object) {

        }

        Lock lock = new ReentrantLock();

        try {
            lock.lock();
        } finally {
            lock.unlock();
        }
    }

}
