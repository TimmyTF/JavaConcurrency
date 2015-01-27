package concurrency.terminatingtasks.terminatewhenblocked;

import java.util.concurrent.TimeUnit;

/**
 * Created by tflomin on 27.01.2015.
 *
 */
public class Interrupting2 {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new Blocked2());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Issuing t.interrupt()");
        t.interrupt();
    }
}
