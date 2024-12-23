package me.omrih.omriutils;

import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import me.omrih.omriutils.commands.FlyCommand;
import me.omrih.omriutils.commands.HugCommand;
import me.omrih.omriutils.commands.PvpCommand;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("UnstableApiUsage")
public final class OmriUtilsPlugin extends JavaPlugin {
    public static OmriUtilsPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        LifecycleEventManager<Plugin> manager = this.getLifecycleManager();
        manager.registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            final Commands commands = event.registrar();
            FlyCommand.register(commands);
            HugCommand.register(commands);
            PvpCommand.register(commands);
        });

        getServer().getPluginManager().registerEvents(new EventListeners(), this);
        new Metrics(this, 24190);
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
