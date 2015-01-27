package repeat.threadlocal;

/**
 * Created by tflomin on 22.01.2015.
 *
 */
public class ThreadLocalVariableHolderRepeat {
    /**
     * This is our thread local field which will be cloned for each thread that uses {@code ThreadLocalVariableHolderRepeat} class.
     * <p> I don't understand at the moment, why should it be static.
     */
    private ThreadLocal<String> threadLocalValue = new ThreadLocal<String>() {
        @Override
        protected synchronized String initialValue() {
            return "initial value";
        }
    };

    public String getThreadLocalValue() {
        return threadLocalValue.get();
    }

    public void setThreadLocalValue(String threadLocalValue) {
        this.threadLocalValue.set(threadLocalValue);
    }
}
