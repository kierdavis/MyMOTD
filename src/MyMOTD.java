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
import org.mcstats.Metrics;

public class MyMOTD extends JavaPlugin {
    private String motd;
    private File motdFile;
    
    public void onEnable() {
        motd = getServer().getMotd();
        motdFile = new File(getDataFolder(), "motd.txt");
        
        if (motdFile.exists()) {
            try {
                BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(motdFile), "UTF-8"));
                motd = r.readLine();
                r.close();
            }
            catch (IOException e) {
                getLogger().warning("Could not read motd.txt: " + e.toString());
            }
        }
        
        getServer().getPluginManager().registerEvents(new ServerListPingListener(this), this);
	MOTDCommandExecutor ex = new MOTDCommandExecutor(this);
        getCommand("motd").setExecutor(ex);
	getCommand("mymotd").setExecutor(ex);
        
        // Start Metrics
        try {
            Metrics metrics = new Metrics(this);
            metrics.start();
        }
        catch (IOException e) {
            getLogger().severe("Failed to submit stats to Metrics: " + e.toString());
        }
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
            getLogger().warning("Could not write motd.txt: " + e.toString());
        }
    }
    
    public String getMOTD() {
        return motd;
    }
    
    public void setMOTD(String s) {
        motd = s;
    }
}
