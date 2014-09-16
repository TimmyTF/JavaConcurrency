package concurrency.the.very.basics;

/**
 * Created by tflomin on 26.08.2014.
 *
 */
public class MainThread {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
    }
}
