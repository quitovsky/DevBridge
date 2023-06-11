package qtv.devbridge;

import org.bukkit.plugin.java.JavaPlugin;
import qtv.devbridge.commands.MainCommand;
import qtv.devbridge.utils.Config;
import qtv.devbridge.web.WebServer;

public final class DevBridge extends JavaPlugin {

    static DevBridge instance;

    @Override
    public void onEnable() {
        instance = this;
        WebServer.load();

        new Config(this);
        new MainCommand();
    }

    @Override
    public void onDisable() {
        WebServer.app.stop();
    }

    public static DevBridge getInstance() {
        return instance;
    }
}
