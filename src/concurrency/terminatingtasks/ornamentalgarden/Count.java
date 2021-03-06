package concurrency.terminatingtasks.ornamentalgarden;

import java.util.Random;

/**
 * Created by tflomin on 26.01.2015.
 *
 */
public class Count {
    private int count = 0;
    private Random rand = new Random(47);

    // Remove the synchronized keyword to see counting fail:
    public synchronized int increment() {
        int temp = count;
        if (rand.nextBoolean()) // Yield half the time
            Thread.yield();
        return (count = ++temp);
    }

    public synchronized int value() {
        return count;
    }
}
