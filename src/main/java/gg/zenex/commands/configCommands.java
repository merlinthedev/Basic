package gg.zenex.commands;

import gg.zenex.permissionConfig;
import gg.zenex.basic;
import gg.zenex.utils.utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class configCommands implements CommandExecutor {

    private basic plugin;

    public configCommands(basic plugin) {

        this.plugin = plugin;
        plugin.getCommand("creload").setExecutor(this);

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("creload")) {

            if (!(sender instanceof Player)) {
                sender.sendMessage("Can only be done by a player.");
                return true;
            }

            Player p = (Player) sender;

            if (p.hasPermission("basic.creload")) {

                permissionConfig.reload();
                sender.sendMessage("Config reloaded.");
                return false;

            } else {
                p.sendMessage(utils.chat(plugin.getConfig().getString("nopermission")));
                return false;
            }
        }
        return false;
    }
}
