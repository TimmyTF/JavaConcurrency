package concurrency.terminatingtasks.terminatewhenblocked;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by tflomin on 27.01.2015.
 * This class designed to show interruption of a thread, blocked by some I/O operation
 */
class IOBlocked implements Runnable {
    private InputStream in;

    public IOBlocked(InputStream is) {
        in = is;
    }

    public void run() {
        try {
            System.out.println("Waiting for read():");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from blocked I/O");
            } else {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exiting IOBlocked.run()");
    }
}
