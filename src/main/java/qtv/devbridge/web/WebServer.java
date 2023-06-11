package qtv.devbridge.web;

import io.javalin.Javalin;
import io.javalin.http.servlet.JavalinServletContext;
import qtv.devbridge.DevBridge;
import qtv.devbridge.utils.Config;

public class WebServer {

    public static Javalin app;

    public static void load() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(DevBridge.class.getClassLoader());
        app = Javalin.create().start(7000);
        app.before(ctx -> {
            if(!Config.getBoolean("isEnabled")) {
                ctx.status(403);
                ctx.result("DevBridge is disabled");
                JavalinServletContext jsc = (JavalinServletContext)ctx;
                jsc.getTasks().clear();
            }
        });
        Thread.currentThread().setContextClassLoader(classLoader);

        new Handlers();
    }

}
