package concurrency.the.very.basics.custom;

/**
 * Created by Timmy on 31.08.2014.
 *
 */
public class RunningSeveralOfMyThreads {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++)
            new Thread(new MyThread()).start();
        System.out.println("Waiting for MyThreads to start.");
    }
}
