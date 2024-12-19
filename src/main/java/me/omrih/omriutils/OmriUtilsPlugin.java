package me.omrih.omriutils;

import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public final class OmriUtilsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        int pluginId = 24190;
        Metrics metrics = new Metrics(this, pluginId);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
