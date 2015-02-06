package jcip;

/**
 * Created by tflomin on 02.02.2015.
 *
 */
public class IntrinsicLocks implements Runnable {
    private int id;
    private Mutex myMutex;

    public IntrinsicLocks(int id, Mutex myMutex) {
        this.id = id;
        this.myMutex = myMutex;
    }

    public static void main(String[] args) {
        Mutex m = new Mutex();
        IntrinsicLocks intrinsicLocks1 = new IntrinsicLocks(1, m);
        IntrinsicLocks intrinsicLocks2 = new IntrinsicLocks(2, m);

        Thread t1 = new Thread(intrinsicLocks1);
        Thread t2 = new Thread(intrinsicLocks2);

        t1.start();
        t2.start();
    }

    @Override
    public void run() {
//        myMutex.doSmth1();
        if (id == 1)
            myMutex.doSmth1();
        else
            myMutex.doSmth3();
//            myMutex.doSmth2();
    }
}
