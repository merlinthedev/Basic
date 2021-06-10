package gg.zenex.chat;

import gg.zenex.basic;
import gg.zenex.utils.utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class staffChat implements CommandExecutor {
    private basic plugin;

    public staffChat(basic plugin) {
        this.plugin = plugin;

        plugin.getCommand("staffchat").setExecutor(this);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("staffchat")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(utils.chat("This can only be executed by a player."));
                return false;
            }

            Player p = (Player) sender;

            if (p.hasPermission("basic.staffchat")) {
                if (args.length < 1) {
                    p.sendMessage(utils.chat("&8[&4SC&8]&r Message can't be empty."));
                    return false;
                }

                String message = "&8[&4SC&8] &r" + p.getDisplayName() + ": ";

                for (String s : args) {
                    message = message + s + " ";

                }

                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (p.hasPermission("basic.staffchat")) {
                        player.sendMessage(utils.chat(message));
                    }
                }
                return true;
            } else {
                p.sendMessage(utils.chat(plugin.getConfig().getString("nopermission")));
                return false;
            }
        }
        return false;
    }
}
