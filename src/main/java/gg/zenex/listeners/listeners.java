package gg.zenex.listeners;

import gg.zenex.basic;
import gg.zenex.messageConfig;
import gg.zenex.utils.utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class listeners implements Listener {

    private basic plugin;

    public listeners (basic plugin) {
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public static boolean muted = false;

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (muted) {
            Player p = e.getPlayer();
            if (p.hasPermission("basic.mutechat.bypass")) {
                p.sendMessage(utils.chat("&cThe chat is currently &lmuted&r&c, but you are bypassing this."));
            } else {
                p.sendMessage(utils.chat("&cChat is currently muted."));
                e.setCancelled(true);
            }
        }
    }


    @EventHandler
    public void playerJoinMessage (PlayerJoinEvent e) {
        Player p = (Player) e.getPlayer();
        // send player a message from the message.yml config file (still has to be created.)
        p.sendMessage(messageConfig.get().getString("newLine"));
        p.sendMessage(utils.chat(messageConfig.get().getString("joinMessage")));
        p.sendMessage(messageConfig.get().getString("newLine"));
        p.sendMessage(utils.chat(messageConfig.get().getString("joinMessage2")));
        p.sendMessage(messageConfig.get().getString("newLine"));
    }
}
