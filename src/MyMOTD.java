package com.kierdavis.mymotd;

import org.bukkit.plugin.java.JavaPlugin;

public class MyMOTD extends JavaPlugin {
    private String motd;
    
    public void onEnable() {
        motd = "\247cSet an MOTD using /motd ...";
        
        getServer().getPluginManager().registerEvents(new ServerListPingListener(this), this);
        getCommand("motd").setExecutor(new MOTDCommandExecutor(this));
    }
    
    public void onDisable() {
        
    }
    
    public String getMOTD() {
        return motd;
    }
    
    public void setMOTD(String s) {
        motd = s;
    }
}
