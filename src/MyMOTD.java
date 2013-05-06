package com.kierdavis.mymotd;

import org.bukkit.plugin.java.JavaPlugin;

public class MyMOTD extends JavaPlugin {
    private String motd;
    private File motdFile;
    
    public void onEnable() {
        motd = "\247cSet a MOTD using /motd ...";
        motdFile = new File(getDataFolder(), "motd.txt");
        
        if (motdFile.exists()) {
            BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(motdFile), "UTF-8"));
            motd = r.readLine();
            r.close();
        }
        
        getServer().getPluginManager().registerEvents(new ServerListPingListener(this), this);
        getCommand("motd").setExecutor(new MOTDCommandExecutor(this));
    }
    
    public void onDisable() {
        if (!motdFile.getParentFile().exists()) {
            motdFile.getParentFile().mkdirs();
        }
        
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(motdFile), "UTF-8"));
        w.write(motd);
        w.newLine();
        w.flush();
        w.close();
    }
    
    public String getMOTD() {
        return motd;
    }
    
    public void setMOTD(String s) {
        motd = s;
    }
}
