package org.example.lession10.lession2;

public class AccountMain {
    public static void main(String[] args) {
        Account a1 = new Account(100_000);
        Account a2 = new Account(100_000);

        // дедлок
        // new Thread(new AccountThread(a1, a2, 100)).start();
        // new Thread(new AccountThread(a2, a1, 100)).start();

        // безопасный перевод
        Thread t1 = new Thread(new SafeAccountThread(a1, a2, 100));
        Thread t2 = new Thread(new SafeAccountThread(a2, a1, 100));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Balance A1: " + a1.getCacheBalance());
        System.out.println("Balance A2: " + a2.getCacheBalance());
    }
}
