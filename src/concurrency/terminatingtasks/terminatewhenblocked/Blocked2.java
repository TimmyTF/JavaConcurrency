package concurrency.terminatingtasks.terminatewhenblocked;

/**
 * Created by tflomin on 27.01.2015.
 *
 */
public class Blocked2 implements Runnable {
    BlockedMutex blocked = new BlockedMutex();

    public void run() {
        System.out.println("Waiting for f() in BlockedMutex");
        blocked.f();
        System.out.println("Broken out of blocked call");
    }
}
