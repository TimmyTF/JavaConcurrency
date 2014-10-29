package concurrency.responsiveui;

/**
 * Created by tflomin on 24.09.2014.
 *
 */
public class ResponsiveUI extends Thread {
    private static volatile double d = 1;

    public ResponsiveUI() {
        setDaemon(true); // ���� ����� ������ daemon'��, ����� �� ���� ������ � ������� main;
                         // ���� ����� �� �������, �� ������� ��������� �����-�� �������(��������, while d < 100000),
                         // ����� ��� ����������.
        start();
    }

    @Override
    public void run() {
        while (true) {
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) throws Exception {
        //new UnresponsiveUI(5); // Must kill this process!
//        new ResponsiveUI();
        System.in.read();
        System.out.println(d);
    }
}

class UnresponsiveUI {
    private volatile double d = 1;

    UnresponsiveUI(double d) throws Exception {
        while (d > 0)
            d = d + (Math.PI + Math.E) / d;
        System.in.read(); // Never gets here
    }
}
