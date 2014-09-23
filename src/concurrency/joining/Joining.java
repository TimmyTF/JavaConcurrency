package concurrency.joining;

/**
 * Created by tflomin on 23.09.2014.
 *
 */
public class Joining {
    public static void main(String[] args) {
        Sleeper
                sleepy = new Sleeper("Sleepy", 1500),
                grumpy = new Sleeper("Grumpy", 1500);
        Joiner
                dopey = new Joiner("Dopey", sleepy),
                doc = new Joiner("Doc", grumpy);
        grumpy.interrupt();
    }
}

class Sleeper extends Thread {
    private int duration;

    Sleeper(String name, int duration) {
        super(name);
        this.duration = duration;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException ie) {
            System.err.println(getName() + " was interrupted. " + "isInterrupted(): " + isInterrupted());
            return;
        }
        System.out.println(getName() + " was awakened.");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException ie) {
            System.err.println("Interrupted");
        }
        System.out.println(getName() + " join completed.");
    }
}
