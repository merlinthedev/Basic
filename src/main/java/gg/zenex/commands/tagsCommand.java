package gg.zenex.commands;

import gg.zenex.basic;
import gg.zenex.utils.utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class tagsCommand implements CommandExecutor {

    private basic plugin;

    public tagsCommand(basic plugin) {
        this.plugin = plugin;

        plugin.getCommand("tag").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("tag")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be executed by a player.");
                return true;
            }

            Player p = (Player) sender;

            if (p.hasPermission("basic.tag")) {
                if (args.length > 0) {
                    p.sendMessage(utils.chat("&cIncorrect usage: /tags"));
                    return true;
                } else if (args.length == 0) {
                    Inventory tagsGUI = Bukkit.createInventory(p, 9, ChatColor.DARK_RED + "Tags");

                    ItemStack dollar = new ItemStack(Material.INK_SACK, 1, (short) 1);

                    ItemMeta dm = dollar.getItemMeta();
                    dm.setDisplayName(utils.chat("&4$"));
                    ArrayList<String> dml = new ArrayList<>();
                    dml.add(utils.chat("&cYour tag will be displayed as:"));
                    dml.add(utils.chat( "&7- &r" + p.getName() + " &4$&r: &7<message>"));
                    dm.setLore(dml);
                    dollar.setItemMeta(dm);

                    ItemStack[] MI = {dollar};
                    tagsGUI.setContents(MI);
                    p.openInventory(tagsGUI);
                }

            }
        }

        return false;
    }
}
