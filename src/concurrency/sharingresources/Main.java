package concurrency.sharingresources;

/**
 * Created by tflomin on 04.12.2014.
 *
 */
public class Main {
    public static void main(String[] args) {
//        EvenChecker.test(new EvenGenerator(), 20);
//        EvenChecker.test(new EvenGenerator());
//        EvenChecker.test(new SynchronizedEvenGenerator());
//        EvenChecker.test(new MutexEvenGenerator());
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
