package concurrency.sharingresources;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tflomin on 10.12.2014.
 *
 */
public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger currentEvenValue = new AtomicInteger(0);

    public int next() {
        return currentEvenValue.addAndGet(2);
    }
}
