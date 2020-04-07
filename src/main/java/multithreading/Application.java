package multithreading;

import java.util.concurrent.TimeUnit;

public class Application {

    public static void main(String[] args) throws Exception {
        Scheduler scheduler = new Scheduler(TimeUnit.SECONDS, 1, () -> System.out.println("Tick"));
        scheduler.start();

        Thread.sleep(60_000);
        scheduler.stop();
    }

}
