package concurrency.sharingresources;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by tflomin on 04.12.2014.
 *
 */
public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            System.out.println("next = " + val);
            if (val % 2 != 0/* || val > 1000000*/) {
                System.out.println(val + " not even!");
//                System.out.println(val + " not even or is greater than 1000000!");
                generator.cancel();
            }

            /*try {
                TimeUnit.NANOSECONDS.sleep(1);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }*/
        }
    }

    public static void test(IntGenerator gp, int count) {
        System.out.println("Press ctrl+c to exit.");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(gp, i));
        }
        exec.shutdown();
    }

    public static void test(IntGenerator gp) {
        test(gp, 10);
    }
}
