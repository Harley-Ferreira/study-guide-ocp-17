package p740_writing_thread_safe_code;

/** EXTRA
 *  Use synchronized when you have two or more threads accessing the same variable.
 */
public class Ex5_Synchronized {
    static class Bank implements Runnable {
        private Account account = new Account();

        public static void main(String[] args) {
            Bank bank = new Bank();
            var suzan = new Thread(bank, "Suzan");
            var john = new Thread(bank, "John");
            suzan.start();
            john.start();
        }

        //IF REMOVE THE SYNCHRONIZED so suzan and john will withdraw to the same time.
        private synchronized void withdrawMoney(double value) {
            if (account.getBalance() >= value) {
                System.out.println(Thread.currentThread().getName() + " is withdrawing");
                account.withdraw(value);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " withdrew, balance: " + account.getBalance());
            } else {
                System.out.println("Without money for " + Thread.currentThread().getName() + " make a withdraw, balance: " + + account.getBalance());
            }
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                withdrawMoney(10);
                if (account.balance < 0) {
                    System.out.println("Oh my god");
                }
            }
        }
    }

    public static class Account {
        Double balance = 50.0;

        public Double getBalance() {
            return balance;
        }

        public void withdraw(double value) {
            balance = balance - value;
        }
    }
}
