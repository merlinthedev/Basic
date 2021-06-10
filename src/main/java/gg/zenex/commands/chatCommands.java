package gg.zenex.commands;

import gg.zenex.basic;
import gg.zenex.listeners.listeners;
import gg.zenex.utils.utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class chatCommands implements CommandExecutor {

    private basic plugin;

    public chatCommands(basic plugin) {
        this.plugin = plugin;

        plugin.getCommand("mutechat").setExecutor(this);
        plugin.getCommand("clearchat").setExecutor(this);

    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("mutechat")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be executed by a player.");

            }

            Player p = (Player) sender;

            if (p.hasPermission("basic.mutechat")) {

                if (listeners.muted) {
                    listeners.muted = false;
                    Bukkit.broadcastMessage(utils.chat("&cThe chat was unmuted by &r&l" + p.getName() + "."));
                } else {
                    listeners.muted = true;
                    Bukkit.broadcastMessage(utils.chat("&CThe chat was muted by &r&l" + p.getName() + "."));
                }

            } else {
                p.sendMessage(utils.chat(plugin.getConfig().getString("nopermission")));
                return false;
            }
        }

        if (cmd.getName().equalsIgnoreCase("clearchat")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be executed by a player.");
                return false;
            }

            Player p = (Player) sender;

            if (p.hasPermission("basic.clearchat")) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (player.hasPermission("basic.clearchat.bypass")) {
                        player.sendMessage(utils.chat("&cThe chat was cleared by &r" + p.getName() + "&c, however you are bypassing this"));
                    } else {
                        for (int x = 0; x < 1500; x++) {
                            player.sendMessage( " ");
                        }
                        player.sendMessage(utils.chat("&cThe chat was cleared by &r&l" + p.getName() + "."));
                    }
                }

            } else {
                p.sendMessage(utils.chat(plugin.getConfig().getString("nopermission")));
                return false;
            }
        }
        return false;
    }
}
