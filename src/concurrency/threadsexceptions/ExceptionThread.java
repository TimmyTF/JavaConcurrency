package concurrency.threadsexceptions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tflomin on 24.09.2014.
 *
 */
public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        ExceptionThread exceptionThread = new ExceptionThread();
//        exceptionThread.withoutTryCatch();
        exceptionThread.withTryCatch();
    }

    private void withoutTryCatch() {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }

    private void withTryCatch() {
        try {
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        } catch (RuntimeException re) {
            // This statement will NOT execute!
            System.out.println("Exception has been handled!");
        }
    }
}
