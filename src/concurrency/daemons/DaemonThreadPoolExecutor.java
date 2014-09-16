package concurrency.daemons;

import java.util.concurrent.*;

/**
 * Created by Timmy on 16.09.2014.
 *
 */
public class DaemonThreadPoolExecutor extends ThreadPoolExecutor {
    public DaemonThreadPoolExecutor() {
        super(0,
            Integer.MAX_VALUE,
            60L, TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>(),
            new DaemonThreadFactory()
        );
    }
}
