package gg.zenex.listeners;

import gg.zenex.basic;
import gg.zenex.utils.utils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class tagsListener implements Listener {

    private basic plugin;
    private boolean active = false;

    public tagsListener(basic plugin) {
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void tagsInventory(InventoryClickEvent e) {
        if (e.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.DARK_RED + "Tags")) {
            Player p = (Player) e.getWhoClicked();
            p.sendMessage(String.valueOf(active));

            switch (e.getSlot()) {
                case 0:
                    if (active == true) {
                        p.setDisplayName(p.getName());
                        p.sendMessage("You already had this tag active. Display name has been reset.");
                        active = false;
                    } else if (active == false) {
                        p.setDisplayName(utils.chat(p.getDisplayName() + " &4$&r"));
                        active = true;

                    }
                    break;
                case 1:

                    break;
            }
            e.setCancelled(true);
        }
    }
}
