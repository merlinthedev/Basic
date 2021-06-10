package gg.zenex.commands;

import gg.zenex.basic;
import gg.zenex.utils.utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class messageCommands implements CommandExecutor {

    private basic plugin;

    public messageCommands(basic plugin) {
        this.plugin = plugin;

        plugin.getCommand("msg").setExecutor(this);
        plugin.getCommand("r").setExecutor(this);
    }

    @SuppressWarnings("deprecation")
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("msg")) {
            if (sender instanceof Player && args.length > 0) {
                if (Bukkit.getOfflinePlayer(args[0]).getPlayer() != null) {
                    Player messager = (Player) sender;
                    Player reciever = Bukkit.getOfflinePlayer(args[0]).getPlayer();
                    plugin.mM.setReplyTarget(messager, reciever);
                    args[0] = "";
                    String message = "";
                    for (int i = 0; i < args.length; i++) {
                        message += " " + args[i];
                    }
                    messager.sendMessage(utils.chat("&7(To &r" + reciever.getDisplayName() + "&7)" + message));
                    reciever.sendMessage(utils.chat("&7(From &r" + messager.getDisplayName() + "&7)" + message));
                    return true;
                } else {
                    sender.sendMessage("Player is not online.");
                    return true;
                }
            }
        }

        if (cmd.getName().equalsIgnoreCase("r")) {
            if (sender instanceof Player) {
                Player messager = (Player) sender;
                if (plugin.mM.getReplyTarget(messager) == null) {
                    messager.sendMessage(utils.chat("&cNo current conversation."));
                    return true;
                }
                Player reciever = plugin.mM.getReplyTarget(messager);
                String message = "";
                for (int i = 0; i < args.length; i++) {
                    message += " " + args[i];
                }
                messager.sendMessage(utils.chat("&7(To &r"+ reciever.getDisplayName() + "&7)" + message));
                reciever.sendMessage(utils.chat("&7(From &r" + messager.getDisplayName() + "&7)" + message));
                return true;
            }
        }
        return false;
    }
}
