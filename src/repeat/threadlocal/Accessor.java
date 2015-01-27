package repeat.threadlocal;

import java.util.Random;

/**
 * Created by tflomin on 26.01.2015.
 *
 */
public class Accessor implements Runnable {
    private int id;
    private ThreadLocalVariableHolderRepeat threadLocalVariableHolderRepeat;
    private Random rand = new Random(42);

    public Accessor(int id) {
        this.id = id;
        this.threadLocalVariableHolderRepeat = new ThreadLocalVariableHolderRepeat();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            threadLocalVariableHolderRepeat.setThreadLocalValue("value#" + rand.nextInt(10000));
            System.out.println(this);
            Thread.yield();
        }
    }

    @Override
    public String toString() {
        return "Accessor{id=" + id + ", threadLocalVariableHolderRepeat="  + threadLocalVariableHolderRepeat.getThreadLocalValue() + '}';
    }
}

