package concurrency.the.very.basics.custom;

/**
 * Created by Timmy on 31.08.2014.
 *
 */
public class MyThread implements Runnable {
    private static int taskCount = 0;
    private final int id = taskCount++;

    MyThread() {
        System.out.println("MyThread #" + id + " created.");
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("MyThread's #" + id +  " message!");
            Thread.yield();
        }
        System.out.println("MyThread #" + id + " finished it's work.");
    }
}
