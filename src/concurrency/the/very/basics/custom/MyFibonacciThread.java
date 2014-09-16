package concurrency.the.very.basics.custom;

import generics.Fibonacci;

/**
 * Created by Timmy on 31.08.2014.
 *
 */
public class MyFibonacciThread implements Runnable {
    private Fibonacci fib = new Fibonacci();
    private int n;
    private static int taskCount = 0;
    private final int id = taskCount++;

    MyFibonacciThread(int n) {
        this.n = n;
    }

    public void run() {
        for(int i = 0; i < n; i++)
            System.out.println("Thread #" + id + ": " + fib.next() + " ");
    }
}
