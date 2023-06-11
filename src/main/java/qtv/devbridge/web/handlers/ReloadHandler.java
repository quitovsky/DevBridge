package qtv.devbridge.web.handlers;

import org.bukkit.Bukkit;
import qtv.devbridge.DevBridge;
import qtv.devbridge.web.WebServer;

public class ReloadHandler {

    public ReloadHandler() {
        WebServer.app.get("/reload/{target}", ctx -> {
            String target = ctx.pathParam("target");
            if (target.equalsIgnoreCase("server")) {
                Bukkit.getScheduler().scheduleSyncDelayedTask(
                        DevBridge.getInstance(),
                        new ReloadRunnable()
                );
                ctx.result("Server reloaded");
            }
        });
    }

}

class ReloadRunnable implements Runnable {
    @Override
    public void run() {
        Bukkit.getServer().dispatchCommand(
                Bukkit.getServer().getConsoleSender(),
                "reload"
        );
    }
}
