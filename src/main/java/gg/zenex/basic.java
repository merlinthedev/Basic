package gg.zenex;

import gg.zenex.chat.Format;
import gg.zenex.chat.staffChat;
import gg.zenex.colorGUI.colorGUIListener;
import gg.zenex.colorGUI.colorGUIcommand;
import gg.zenex.commands.*;
import gg.zenex.listeners.listeners;
import gg.zenex.listeners.messageManager;
import gg.zenex.listeners.tagsListener;
import org.bukkit.plugin.java.JavaPlugin;



public class basic extends JavaPlugin {
    public messageManager mM;


    public void onEnable() {


        // default config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // permissions.yml file
        permissionConfig.setup();
        permissionConfig.get().addDefault("enabled", false);
        permissionConfig.get().options().copyDefaults(true);
        permissionConfig.save();


        // messages.yml file
        messageConfig.setup();
        messageConfig.get().addDefault("enabled", true);
        messageConfig.get().options().copyDefaults(true);
        messageConfig.save();

        new messageConfig(this);

        // commands register
        new Commands(this);
        new configCommands(this);
        new colorGUIcommand(this);
        new staffChat(this);
        new chatCommands(this);
        new messageCommands(this);
        new tagsCommand(this);

        //listeners
        new colorGUIListener(this);
        new listeners(this);
        mM = new messageManager(this);
        new tagsListener(this);
        new Format(this);



    }

    public void onDisable() {

    }



}






