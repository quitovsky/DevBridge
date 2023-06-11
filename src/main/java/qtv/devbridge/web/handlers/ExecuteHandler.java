package qtv.devbridge.web.handlers;

import org.bukkit.Bukkit;
import qtv.devbridge.DevBridge;
import qtv.devbridge.web.WebServer;

public class ExecuteHandler {
    public ExecuteHandler() {
        WebServer.app.post("/execute", ctx -> {
            String code = ctx.body();
            System.out.println(code);
            ExecuteRunnable executeRunnable = new ExecuteRunnable(code);
            Bukkit.getScheduler().scheduleSyncDelayedTask(
                    DevBridge.getInstance(),
                    executeRunnable
            );
            ctx.result("Executed");
        });
    }
}

class ExecuteRunnable implements Runnable {
    String code;

    public ExecuteRunnable(String code) {
        this.code = code;
    }

    @Override
    public void run() {
        Bukkit.getServer().dispatchCommand(
                Bukkit.getServer().getConsoleSender(),
                code.replaceFirst("/", "")
        );
    }
}