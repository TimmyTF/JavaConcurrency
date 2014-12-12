package concurrency.sharingresources;

/**
 * Created by tflomin on 04.12.2014.
 *
 */
public class EvenGenerator extends IntGenerator {
    // tasks are able to access the information in EvenGenerator(currentEvenValue field in particular) while it’s in an "incorrect" state
    private int currentEvenValue = 0;

    @Override
    public int next() {
        ++currentEvenValue;
//        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }
}
