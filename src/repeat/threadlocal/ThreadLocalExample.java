package repeat.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * Created by tflomin on 26.01.2015.
 *
 */
public class ThreadLocalExample {
    public static class MyRunnable implements Runnable {
        private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                threadLocal.set((int) (Math.random() * 100D));

                /*try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }*/

                System.out.println(Thread.currentThread().getId() + "::" + threadLocal.get());
            }
        }
    }

    public static void main(String[] args) {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.interrupt();
        thread2.interrupt();
    }
}
