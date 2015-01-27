package concurrency.sharingresources.threadlocal;

/**
 * Created by tflomin on 26.01.2015.
 *
 */
public class Accessor implements Runnable {
    /**
     * This thread id
     */
    private final int id;

    /**
     * Ctor. Init this thread id
     * @param id this thread id
     */
    public Accessor(int id) {
        this.id = id;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    public String toString() {
        return "#" + id + ": " + ThreadLocalVariableHolder.get();
    }
}
