package me.omrih.omriutils.commands;

import com.mojang.brigadier.Command;
import io.papermc.paper.command.brigadier.Commands;
import org.bukkit.configuration.file.FileConfiguration;

import static me.omrih.omriutils.OmriUtilsPlugin.plugin;

@SuppressWarnings("UnstableApiUsage")
public class PvpCommand {
    static FileConfiguration config = plugin.getConfig();

    public static void register(Commands commands) {
        commands.register(
                Commands.literal("pvp")
                        .requires(commandSourceStack -> commandSourceStack.getSender().hasPermission("omriutils.pvp"))
                        .executes(context -> {
                            if (config.getBoolean("pvp")) {
                                config.set("pvp", false);
                                plugin.saveConfig();
                                context.getSource().getSender().sendRichMessage("<red>PvP has been disabled");
                            } else {
                                config.set("pvp", true);
                                plugin.saveConfig();
                                context.getSource().getSender().sendRichMessage("<green>PvP has been enabled");
                            }
                            return Command.SINGLE_SUCCESS;
                        })
                        .build(),
                "Toggle PvP for the server"
        );
    }
}
