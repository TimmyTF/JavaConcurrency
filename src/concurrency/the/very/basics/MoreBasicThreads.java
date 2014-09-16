package concurrency.the.very.basics;

/**
 * Created by tflomin on 26.08.2014.
 *
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++)
            new Thread(new LiftOff()).start();
        System.out.println("Waiting for LiftOff");
    }
}
