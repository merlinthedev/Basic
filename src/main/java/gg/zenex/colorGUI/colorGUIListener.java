package gg.zenex.colorGUI;

import gg.zenex.basic;
import gg.zenex.utils.utils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class colorGUIListener implements Listener {

    private basic plugin;

    public colorGUIListener(basic plugin) {
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void clickEvent(InventoryClickEvent e) {
        if (e.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.DARK_RED + "Change name color")) {
            Player p = (Player) e.getWhoClicked();

            switch (e.getSlot()) {
                case 11:
                    p.setDisplayName(utils.chat("&c" + p.getName() + "&r"));
                    p.sendMessage(utils.chat("&lYour display name has been set to " + "&c&lRED."));
                    break;
                case 12:
                    p.setDisplayName(utils.chat("&d" + p.getName() + "&r"));
                    p.sendMessage(utils.chat("&lYour display name has been set to " + "&d&lPINK."));
                    break;
                case 13:
                    p.setDisplayName(utils.chat("&5" + p.getName() + "&r"));
                    p.sendMessage(utils.chat("&lYour display name has been set to " + "&5&lPURPLE."));
                    break;
                case 14:
                    p.setDisplayName(utils.chat("&1" + p.getName() + "&r"));
                    p.sendMessage(utils.chat("&lYour display name has been set to " + "&1&lBLUE."));
                    break;
                case 15:
                    p.setDisplayName(utils.chat("&3" + p.getName() + "&r"));
                    p.sendMessage(utils.chat("&lYour display name has been set to " + "&3&lCYAN."));
                    break;
                case 20:
                    p.setDisplayName(utils.chat("&b" + p.getName() + "&r"));
                    p.sendMessage(utils.chat("&lYour display name has been set to " + "&b&lAQUA."));
                    break;
                case 21:
                    p.setDisplayName(utils.chat("&A" + p.getName() + "&r"));
                    p.sendMessage(utils.chat("&lYour display name has been set to " + "&A&lLIME."));
                    break;
                case 22:
                    p.setDisplayName(utils.chat("&2" + p.getName() + "&r"));
                    p.sendMessage(utils.chat("&lYour display name has been set to " + "&2&lGREEN."));
                    break;
                case 23:
                    p.setDisplayName(utils.chat("&E" + p.getName() + "&r"));
                    p.sendMessage(utils.chat("&lYour display name has been set to " + "&E&lYELLOW."));
                    break;
                case 24:
                    p.setDisplayName(utils.chat("&6" + p.getName() + "&r"));
                    p.sendMessage(utils.chat("&lYour display name has been set to " + "&6&lGOLD."));
                    break;
                case 31:
                    p.setDisplayName(utils.chat("&a" + p.getName() + "&r"));
                    p.sendMessage(utils.chat("&lYour display name has been reset."));
                    break;
            }

            e.setCancelled(true);
        }
    }
}
