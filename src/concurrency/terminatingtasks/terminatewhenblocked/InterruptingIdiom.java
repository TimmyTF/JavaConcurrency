package concurrency.terminatingtasks.terminatewhenblocked;

import java.util.concurrent.TimeUnit;

/**
 * Created by tflomin on 28.01.2015.
 *
 */
public class InterruptingIdiom {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("usage: java InterruptingIdiom delay-in-mS");
            System.exit(1);
        }
        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(new Integer(args[0]));
        t.interrupt();
    }
}
