package org.nohope.app;

/**
 * @author <a href="mailto:ketoth.xupack@gmail.com">ketoth xupack</a>
 * @since 7/15/12 3:13 PM
 */
public abstract class App {
    protected abstract void onStart();

    protected abstract void onVMShutdown();

    public void start() throws InterruptedException {
        Runtime.getRuntime()
                .addShutdownHook(new Thread(new Runnable() {
                    @Override
                    public void run() {
                        onVMShutdownWrapper();
                    }
                }));

        onStart();
    }

    protected void onVMShutdownWrapper() {
        onVMShutdown();
    }
}