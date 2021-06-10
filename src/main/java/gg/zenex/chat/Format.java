package gg.zenex.chat;

import gg.zenex.basic;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Format implements Listener {

    private basic plugin;

    public Format (basic plugin) {
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }


    @EventHandler
    public void chatFormat (AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        e.setFormat(p.getDisplayName() + ": " + ChatColor.WHITE + e.getMessage());

    }
}
