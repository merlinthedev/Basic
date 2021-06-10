package gg.zenex.commands;

import gg.zenex.basic;
import gg.zenex.utils.utils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    private basic plugin;

    public Commands(basic plugin) {
        this.plugin = plugin;

        plugin.getCommand("gmc").setExecutor(this);
        plugin.getCommand("gms").setExecutor(this);

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("gmc")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be executed by a player.");
                return true;
            }

            Player p = (Player) sender;
            if (p.hasPermission("basic.gmc")) {
                if (args.length == 0) {
                    if (p.getGameMode() == GameMode.CREATIVE) {
                        p.sendMessage(utils.chat("&cAlready in creative mode."));
                        return true;
                    }

                    if (p.getGameMode() != GameMode.CREATIVE) {
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(utils.chat("&cGamemode set to creative."));
                        return true;
                    }
                }

                if (args.length == 1) {
                    try {
                        Player target = (Player) Bukkit.getPlayerExact(args[0]);
                        if (target.getGameMode() == GameMode.CREATIVE) {
                            p.sendMessage(utils.chat("&cPlayer already in creative mode."));
                            return true;
                        }

                        if (target.getGameMode() != GameMode.CREATIVE) {
                            target.setGameMode(GameMode.CREATIVE);
                            p.sendMessage(utils.chat("&cTarget gamemode set to creative."));
                            target.sendMessage(utils.chat("&cYour gamemode has been updated."));
                            return true;

                        }


                    } catch (NullPointerException e) {
                        p.sendMessage(utils.chat(plugin.getConfig().getString("notonline")));
                        return true;
                    }
                }

                if (args.length > 1) {
                    p.sendMessage(utils.chat("&cIncorrect usage: /gmc <username>"));
                    return true;
                }

            } else {
                p.sendMessage(utils.chat(plugin.getConfig().getString("nopermission")));
                return true;
            }
        }

        if (cmd.getName().equalsIgnoreCase("gms")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(utils.chat("This command can only be executed by a player."));
                return true;
            }

            Player p = (Player) sender;

            if (p.hasPermission("basic.gms")) {
                if (args.length == 0) {
                    if (p.getGameMode() == GameMode.SURVIVAL) {
                        p.sendMessage(utils.chat("&cAlready in survival mode."));
                        return true;
                    }

                    if (p.getGameMode() != GameMode.SURVIVAL) {
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(utils.chat("&cGamemode set to survival."));
                        return true;
                    }
                }

                if (args.length == 1) {
                    try {
                        Player target = (Player) Bukkit.getPlayerExact(args[0]);

                        if (target.getGameMode() == GameMode.SURVIVAL) {
                            p.sendMessage(utils.chat("&cPlayer is already in survival mode."));
                            return true;
                        }

                        if (target.getGameMode() != GameMode.SURVIVAL) {
                            target.setGameMode(GameMode.SURVIVAL);
                            p.sendMessage(utils.chat("&cTarget gamemode set to creative."));
                            target.sendMessage(utils.chat("&cYour gamemode has been updated."));
                            return true;
                        }
                    } catch (NullPointerException e) {
                        p.sendMessage(utils.chat(plugin.getConfig().getString("notonline")));
                        return true;
                    }
                }

                if (args.length > 1) {
                    p.sendMessage(utils.chat("&cIncorrect usage: /gms <username>"));
                    return true;
                }
            } else {
                p.sendMessage(utils.chat(plugin.getConfig().getString("nopermission")));
                return true;
            }
        }

        if (cmd.getName().equalsIgnoreCase("")) {

        }

        return false;
    }
}
