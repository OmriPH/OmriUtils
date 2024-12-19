package me.omrih.omriutils;

import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import me.omrih.omriutils.commands.FlyCommand;
import me.omrih.omriutils.commands.HugCommand;

public class OmriUtilsBootstrap implements PluginBootstrap {
    @Override
    public void bootstrap(BootstrapContext context) {
        LifecycleEventManager<BootstrapContext> manager = context.getLifecycleManager();
        manager.registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            final Commands commands = event.registrar();
            FlyCommand.register(commands);
            HugCommand.register(commands);
        });
    }
}
