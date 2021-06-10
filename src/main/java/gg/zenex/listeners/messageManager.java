package gg.zenex.listeners;

import gg.zenex.basic;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class messageManager {

    private basic plugin;

    HashMap <Player, Player> conversations = new HashMap<Player, Player>();

    public messageManager (basic plugin) {
        this.plugin = plugin;
    }

    public void setReplyTarget (Player messager, Player reciever) {
        conversations.put(messager, reciever);
        conversations.put(reciever, messager);

    }

    public Player getReplyTarget (Player messager) {
        return conversations.get(messager);
    }
}
