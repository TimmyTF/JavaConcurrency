package concurrency.daemons;

import java.util.concurrent.ThreadFactory;

/**
 * Created by Timmy on 16.09.2014.
 *
 */
public class DaemonThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
