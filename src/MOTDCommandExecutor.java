package com.kierdavis.mymotd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MOTDCommandExecutor implements CommandExecutor {
    private MyMOTD plugin;
    
    public MOTDCommandExecutor(MyMOTD plugin_) {
        plugin = plugin_;
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("mymotd.get")) {
            sender.sendMessage(ChatColor.GREEN + "You don't have permission (mymotd.get)");
            return false;
        }
        
        if (args.length > 0) {
            if (!sender.hasPermission("mymotd.set")) {
                sender.sendMessage(ChatColor.GREEN + "You don't have permission (mymotd.set)");
                return false;
            }
            
            StringBuilder b = new StringBuilder();
            b.append(args[0]);
            
            for (int i = 1; i < args.length; i++) {
                b.append(" ").append(args[i]);
            }
            
            plugin.setMOTD(b.toString().replaceAll("&", "\247"));
        }
        
        sender.sendMessage(ChatColor.GREEN + "MOTD is: " + ChatColor.RESET + plugin.getMOTD());
        
        return true;
    }
}
