package gg.zenex;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;


import java.io.File;
import java.io.IOException;

public class messageConfig implements CommandExecutor {

    private static File file;
    private static FileConfiguration messageFile;

    public messageConfig (basic plugin) {

        plugin.getCommand("mreload").setExecutor(this);
    }

    public static void setup (){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("basic").getDataFolder(), "messages.yml");

        if (!(file.exists())) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("error");
            }
        }

        messageFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get() {
        return messageFile;

    }

    public static void save() {
        try {
            messageFile.save(file);
        } catch (IOException e) {
            System.out.println("Could not save file.");
        }
    }

    public static void reload () {

        messageFile = YamlConfiguration.loadConfiguration(file);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("mreload")) {
            if (sender instanceof ConsoleCommandSender) {
                reload();
                sender.sendMessage("Messages.yml has been reloaded.");
                return true;
            }

            Player p = (Player) sender;

            if (p.hasPermission("basic.mreload")) {
                reload();
                p.sendMessage("reloaded");
                return true;
            }
        }
        return false;
    }
}

