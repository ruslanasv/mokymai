package multithreading;

import java.util.concurrent.TimeUnit;

public class Scheduler {

    private final Thread thread;

    private volatile boolean destroyed = false;

    public Scheduler(TimeUnit timeUnit, long time, Runnable runnable) {
        this.thread = new Thread(() -> {
            while (!destroyed) {
                runnable.run();

                try {
                    timeUnit.sleep(time);
                } catch (InterruptedException e) {}
            }
        });
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        destroyed = true;
        thread.interrupt();
    }
}
