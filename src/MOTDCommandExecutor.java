package com.kierdavis.mymotd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MOTDCommandExecutor implements CommandExecutor {
    private MyMOTD plugin;
    
    public MOTDCommandExecutor(MyMOTD plugin_) {
        plugin = plugin_;
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length > 0) {
            StringBuilder b = new StringBuilder();
            b.append(args[0]);
            
            for (int i = 1; i < args.length; i++) {
                b.append(" ").append(args[i]);
            }
            
            plugin.setMOTD(b.toString().replaceAll("&", "\247"));
        }
        
        sender.sendMessage("\247eMOTD is: \247r" + plugin.getMOTD());
        
        return true;
    }
}
