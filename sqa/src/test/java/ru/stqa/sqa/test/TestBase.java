package ru.stqa.sqa.test;

import org.junit.Before;
import ru.stqa.sqa.app.Application;

public class TestBase {
    public static ThreadLocal<Application> tlDriver = new ThreadLocal<>();
    public Application app;




    @Before
    public void start() {
        if (tlDriver.get() != null) {
            app = tlDriver.get();
            return;
        }
        app = new Application();
        tlDriver.set(app);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {app.quit(); app = null;}));
    }


}
