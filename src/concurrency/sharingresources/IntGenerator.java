package concurrency.sharingresources;

/**
 * Created by tflomin on 04.12.2014.
 *
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
