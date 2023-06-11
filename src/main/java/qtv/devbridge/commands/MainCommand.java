package qtv.devbridge.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import qtv.devbridge.utils.Config;

public class MainCommand extends AbstractCommand{
    public MainCommand() {
        super("devbridge");
    }

    @Override
    public void execute(CommandSender sender, @NotNull Command command, @NotNull String s, String[] args) {
        if (args.length == 1) {
            String subCommand = args[0];
            if(subCommand.equalsIgnoreCase("toggle")) {
                boolean isEnabled = Config.getBoolean("isEnabled");
                Config.set("isEnabled", !isEnabled);
                sender.sendMessage("DevBridge has been " + (isEnabled ? "disabled" : "enabled"));
            }
        }
    }
}
