package concurrency.sharingresources;

/**
 * Created by tflomin on 09.12.2014.
 *
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;

    public static int nextSerialNumber() {
        return serialNumber++; // Not thread-safe
    }
}
