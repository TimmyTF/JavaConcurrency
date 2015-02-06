package jcip;

import java.util.concurrent.TimeUnit;

/**
 * Created by tflomin on 02.02.2015.
 *
 */
public class Mutex {
    public void doSmth1() {
        synchronized(this) {
            Thread thread = Thread.currentThread();
            System.out.println("Method doSmth1: Thread " + thread.getName() + ":" + thread.getId());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void doSmth2() {
        synchronized(this) {
            Thread thread = Thread.currentThread();
            System.out.println("Method doSmth2: Thread " + thread.getName() + ":" + thread.getId());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void doSmth3() {
        Mutex m = new Mutex();
        synchronized(m) {
            Thread thread = Thread.currentThread();
            System.out.println("Method doSmth3: Thread " + thread.getName() + ":" + thread.getId());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
