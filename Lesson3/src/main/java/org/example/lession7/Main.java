package org.example.lession7;

import jakarta.persistence.OptimisticLockException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.LockAcquisitionException;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Main {

    private static final int THREADS = 8;
    private static final int OPERATIONS_PER_THREAD = 20;
    private static final int SLEEP_MS = 5;

    private static final SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Item.class)
            .buildSessionFactory();

    public static void main(String[] args) throws InterruptedException {
        resetItems(); // Сброс значений до 0

        CountDownLatch latch = new CountDownLatch(THREADS);

        for (int i = 0; i < THREADS; i++) {
            new Thread(() -> {
                Random random = new Random();
                int operations = 0;

                while (operations < OPERATIONS_PER_THREAD) {
                    Session session = factory.openSession();
                    try {
                        session.beginTransaction();

                        long randomId = random.nextInt(40) + 1;
                        Item item = session.get(Item.class, randomId);

                        if (item != null) {
                            item.incrementVal();
                            Thread.sleep(SLEEP_MS);
                            session.getTransaction().commit();
                            operations++; // Увеличиваем только при успешной транзакции
                        } else {
                            session.getTransaction().rollback();
                        }

                    } catch (OptimisticLockException | LockAcquisitionException e) {
                        rollbackQuietly(session);
                        System.out.println(Thread.currentThread().getName() + " DEADLOCK! Повтор...");
                    } catch (Exception e) {
                        rollbackQuietly(session);
                        e.printStackTrace();
                    } finally {
                        session.close();
                    }
                }

                System.out.println(Thread.currentThread().getName() + " завершил " + OPERATIONS_PER_THREAD + " операций");
                latch.countDown();
            }).start();
        }

        latch.await();

        Session session = factory.openSession();
        session.beginTransaction();
        Long total = (Long) session.createQuery("SELECT SUM(i.val) FROM Item i").uniqueResult();
        session.getTransaction().commit();
        session.close();

        System.out.println("Общая сумма всех val: " + total); // Должно быть ровно 160
        factory.close();
    }

    private static void resetItems() {
        Session session = factory.openSession();
        session.beginTransaction();
        session.createQuery("UPDATE Item i SET i.val = 0").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    private static void rollbackQuietly(Session session) {
        try {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } catch (Exception ignored) {}
    }
}
