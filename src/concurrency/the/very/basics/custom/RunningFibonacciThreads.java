package concurrency.the.very.basics.custom;

/**
 * Created by Timmy on 31.08.2014.
 *
 */
public class RunningFibonacciThreads {
    public static void main(String[] args) {
        for(int i = 5; i < 15; i++)
            new Thread(new MyFibonacciThread(i)).start();
    }
}
