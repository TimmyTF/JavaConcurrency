package concurrency.callable;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by Timmy on 31.08.2014.
 *
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();

        for (int i = 0; i < 10; i++)
            results.add(exec.submit(new TaskWithResult(i)));

        for (Future<String> fs : results) {
            try {
                System.out.println(fs.get());
            } catch(InterruptedException ie) {
                System.out.println(ie.getMessage());
                return;
            } catch(ExecutionException ee) {
                System.out.println(ee.getMessage());
                return;
            } finally {
                exec.shutdown();
            }
        }
    }
}

class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    public String call() {
        return "result of TaskWithResult " + id;
    }
}
