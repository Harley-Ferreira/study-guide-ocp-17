package p740_writing_thread_safe_code;

/** EXTRA
 * TAKE CARE WITH DEADLOCK
 */
public class Ex7_DeadLock {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();


    public void simulation1() {
        synchronized (lock1) {
            System.out.println("Thread 1: holding lock 1");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 1: waiting for lock 2");
            synchronized (lock2) {
                System.out.println("Thread 1: is holding lock 2 and lock 1");
            }
        }
    }

    public void simulation2() {
        synchronized (lock2) {
            System.out.println("Thread 2: holding lock 2");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 2: waiting for lock 1");
            synchronized (lock1) {
                System.out.println("Thread 1: is holding lock 1 and lock 2");
            }
        }
    }

    public static void main(String[] args) {
        new Thread(() -> new Ex7_DeadLock().simulation1()).start();
        new Thread(() -> new Ex7_DeadLock().simulation2()).start();
    }
}
