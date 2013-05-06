package com.kierdavis.mymotd;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListPingListener implements Listener {
    private MyMOTD plugin;
    
    public ServerListPingListener(MyMOTD plugin_) {
        plugin = plugin_;
    }
    
    @EventHandler
    public void onServerListPing(ServerListPingEvent event) {
        event.setMotd(plugin.getMOTD());
    }
}
