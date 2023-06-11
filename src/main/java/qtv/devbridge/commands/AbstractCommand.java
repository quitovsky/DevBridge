package qtv.devbridge.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.jetbrains.annotations.NotNull;
import qtv.devbridge.DevBridge;

public abstract class AbstractCommand implements CommandExecutor {

    public AbstractCommand(String command) {
        PluginCommand pluginCommand = DevBridge.getInstance().getCommand(command);
        assert pluginCommand != null;
        pluginCommand.setExecutor(this);
    }

    public abstract void execute(CommandSender sender, @NotNull Command command, @NotNull String s, String[] args);

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        execute(commandSender, command, s, strings);
        return true;
    }
}
