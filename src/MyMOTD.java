package com.kierdavis.mymotd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import org.bukkit.plugin.java.JavaPlugin;

public class MyMOTD extends JavaPlugin {
    private String motd;
    private File motdFile;
    
    public void onEnable() {
        motd = "\247cSet a MOTD using /motd ...";
        motdFile = new File(getDataFolder(), "motd.txt");
        
        if (motdFile.exists()) {
            try {
                BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(motdFile), "UTF-8"));
                motd = r.readLine();
                r.close();
            }
            catch (IOException e) {
                getLogger().warn("Could not read motd.txt: " + e.toString());
            }
        }
        
        getServer().getPluginManager().registerEvents(new ServerListPingListener(this), this);
        getCommand("motd").setExecutor(new MOTDCommandExecutor(this));
    }
    
    public void onDisable() {
        if (!motdFile.getParentFile().exists()) {
            motdFile.getParentFile().mkdirs();
        }
        
        try {
            BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(motdFile), "UTF-8"));
            w.write(motd);
            w.newLine();
            w.flush();
            w.close();
        }
        catch (IOException e) {
            getLogger().warn("Could not write motd.txt: " + e.toString());
        }
    }
    
    public String getMOTD() {
        return motd;
    }
    
    public void setMOTD(String s) {
        motd = s;
    }
}
