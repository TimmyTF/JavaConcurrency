package concurrency.terminatingtasks.terminatewhenblocked;

/**
 * Created by tflomin on 27.01.2015.
 * This class designed to show interruption of a thread, blocked by trying to acquire lock on synchronized method f()
 */
class SynchronizedBlocked implements Runnable {
    public SynchronizedBlocked() {
        new Thread() {
            public void run() {
                f(); // Lock acquired by this thread
            }
        }.start();
    }

    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }

    public synchronized void f() {
        while (true) // Never releases lock
            Thread.yield();
    }
}
