package concurrency.terminatingtasks.ornamentalgarden;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by tflomin on 26.01.2015.
 *
 */
public class Entrance implements Runnable {
    /**
     * Number of entries through all entrances
     */
    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<Entrance>();
    /**
     * Number of entries through this Entrance
     */
    private int number = 0;
    // Doesn't need synchronization to read:
    private final int id;
    private static volatile boolean canceled = false;

    // Atomic operation on a volatile field:
    public static void cancel() {
        canceled = true;
    }

    public synchronized int getValue() {
        return number;
    }

    public String toString() {
        return "Entrance " + id + ": " + getValue();
    }

    public static int getTotalCount() {
        return count.value();
    }

    public static int sumEntrances() {
        int sum = 0;
        for (Entrance entrance : entrances)
            sum += entrance.getValue();
        return sum;
    }

    public Entrance(int id) {
        this.id = id;
        // Keep this task in a list. Also prevents
        // garbage collection of dead tasks:
        entrances.add(this);
    }

    public void run() {
        while (!canceled) {
            // Increment number of entries through this Entrance and then increment overall
            // (Notice that this block of code is synchronized!)
            synchronized (this) {
                ++number;
            }
            // And then increment overall number of entries
            System.out.println(this + " Total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
            }
        }
        System.out.println("Stopping " + this);
    }
}
