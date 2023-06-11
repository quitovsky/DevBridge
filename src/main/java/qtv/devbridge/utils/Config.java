package qtv.devbridge.utils;

import org.bukkit.configuration.file.FileConfiguration;
import qtv.devbridge.DevBridge;

public class Config {

    static FileConfiguration config;
    static DevBridge main;

    public Config(DevBridge main) {
        main.saveDefaultConfig();
        config = main.getConfig();
        Config.main = main;
    }

    public static boolean getBoolean(String path) {
        return config.getBoolean(path);
    }

    public static void set(String path, Object value) {
        config.set(path, value);
        main.saveConfig();
    }

}
