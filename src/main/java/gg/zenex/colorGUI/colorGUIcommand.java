package gg.zenex.colorGUI;

import gg.zenex.basic;
import gg.zenex.utils.utils;
import jdk.nashorn.internal.ir.Block;
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
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;

public class colorGUIcommand implements CommandExecutor {

    private basic plugin;
    public colorGUIcommand (basic plugin) {
        this.plugin = plugin;
        plugin.getCommand("color").setExecutor(this);

    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("color")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(utils.chat(plugin.getConfig().getString("nopermission")));
                return false;
            }

            Player p = (Player) sender;

            if (p.hasPermission("basic.color")) {

                if (args.length > 0) {
                    p.sendMessage(utils.chat("Incorrect usage: /color"));
                    return false;
                } else if (args.length == 0) {
                    Inventory colorGUI = Bukkit.createInventory(p, 36, ChatColor.DARK_RED + "Change name color");

                    ItemStack red = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
                    ItemStack pink = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 6);
                    ItemStack purple = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 10);
                    ItemStack blue = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 11);
                    ItemStack cyan = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 9);
                    ItemStack aqua = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3);
                    ItemStack lime = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
                    ItemStack green = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 13);
                    ItemStack yellow = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 4);
                    ItemStack gold = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
                    ItemStack pane = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
                    ItemStack reset = new ItemStack(Material.IRON_FENCE, 1);

                    ItemMeta reset_meta = reset.getItemMeta();
                    reset_meta.setDisplayName(utils.chat("&4Reset"));
                    ArrayList<String> reset_lore = new ArrayList<>();
                    reset_lore.add(utils.chat("&cReset chat color."));
                    reset_meta.setLore(reset_lore);
                    reset.setItemMeta(reset_meta);

                    ItemMeta red_meta = red.getItemMeta();
                    red_meta.setDisplayName(utils.chat("&cRed"));
                    ArrayList<String> red_lore = new ArrayList<>();
                    red_lore.add(utils.chat("&cRed name color."));
                    red_meta.setLore(red_lore);
                    red.setItemMeta(red_meta);


                    ItemMeta pink_meta = pink.getItemMeta();
                    pink_meta.setDisplayName(utils.chat("&dPink"));
                    ArrayList<String> pink_lore = new ArrayList<>();
                    pink_lore.add(utils.chat("&dPink name color."));
                    pink_meta.setLore(pink_lore);
                    pink.setItemMeta(pink_meta);

                    ItemMeta purple_meta = purple.getItemMeta();
                    purple_meta.setDisplayName(utils.chat("&5Purple"));
                    ArrayList<String> purple_lore = new ArrayList<>();
                    purple_lore.add(utils.chat("&5Purple name color."));
                    purple_meta.setLore(purple_lore);
                    purple.setItemMeta(purple_meta);

                    ItemMeta blue_meta = blue.getItemMeta();
                    blue_meta.setDisplayName(utils.chat("&1Blue"));
                    ArrayList<String> blue_lore = new ArrayList<>();
                    blue_lore.add(utils.chat("&1Blue name color."));
                    blue_meta.setLore(blue_lore);
                    blue.setItemMeta(blue_meta);

                    ItemMeta cyan_meta = cyan.getItemMeta();
                    cyan_meta.setDisplayName(utils.chat("&3Cyan"));
                    ArrayList<String> cyan_lore = new ArrayList<>();
                    cyan_lore.add(utils.chat("&3Cyan name color."));
                    cyan_meta.setLore(cyan_lore);
                    cyan.setItemMeta(cyan_meta);

                    ItemMeta aqua_meta = aqua.getItemMeta();
                    aqua_meta.setDisplayName(utils.chat("&bAqua"));
                    ArrayList<String> aqua_lore = new ArrayList<>();
                    aqua_lore.add(utils.chat("&bAqua name color."));
                    aqua_meta.setLore(aqua_lore);
                    aqua.setItemMeta(aqua_meta);

                    ItemMeta lime_meta = lime.getItemMeta();
                    lime_meta.setDisplayName(utils.chat("&aLime"));
                    ArrayList<String> lime_lore = new ArrayList<>();
                    lime_lore.add(utils.chat("&aLime name color."));
                    lime_meta.setLore(lime_lore);
                    lime.setItemMeta(lime_meta);

                    ItemMeta green_meta = green.getItemMeta();
                    green_meta.setDisplayName(utils.chat("&2Green"));
                    ArrayList<String> green_lore = new ArrayList<>();
                    green_lore.add(utils.chat("&2Green name color."));
                    green_meta.setLore(green_lore);
                    green.setItemMeta(green_meta);

                    ItemMeta yellow_meta = yellow.getItemMeta();
                    yellow_meta.setDisplayName(utils.chat("&eYellow"));
                    ArrayList<String> yellow_lore = new ArrayList<>();
                    yellow_lore.add(utils.chat("&eYellow name color."));
                    yellow_meta.setLore(yellow_lore);
                    yellow.setItemMeta(yellow_meta);

                    ItemMeta gold_meta = gold.getItemMeta();
                    gold_meta.setDisplayName(utils.chat("&6Gold"));
                    ArrayList<String> gold_lore = new ArrayList<>();
                    gold_lore.add(utils.chat("&6Gold name color."));
                    gold_meta.setLore(gold_lore);
                    gold.setItemMeta(gold_meta);

                    ItemStack[] menu_items = {pane, pane, pane, pane, pane, pane, pane, pane, pane, pane, pane,red, pink, purple, blue, cyan, pane, pane, pane, pane, aqua, lime, green, yellow, gold, pane, pane, pane, pane, pane, pane, reset, pane, pane, pane, pane};

                    colorGUI.setContents(menu_items);
                    p.openInventory(colorGUI);

                }

            } else {
                p.sendMessage(utils.chat(plugin.getConfig().getString("nopermission")));
                return true;
            }
        }
        return false;
    }
}
