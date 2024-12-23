package me.omrih.omriutils.commands;

import com.mojang.brigadier.Command;
import io.papermc.paper.command.brigadier.Commands;
import org.bukkit.entity.Player;

@SuppressWarnings("UnstableApiUsage")
public class FlyCommand {
    public static void register(Commands commands) {
        commands.register(
                Commands.literal("fly")
                        .requires(commandSourceStack -> commandSourceStack.getSender() instanceof Player)
                        .requires(commandSourceStack -> commandSourceStack.getSender().hasPermission("omriutils.fly"))
                        .executes(context -> {
                            Player player = (Player) context.getSource().getSender();
                            if (player.getAllowFlight()) {
                                player.setAllowFlight(false);
                                player.sendRichMessage("<red>You can no longer fly");
                            } else {
                                player.setAllowFlight(true);
                                player.sendRichMessage("<green>You can now fly");
                            }
                            return Command.SINGLE_SUCCESS;
                        })
                        .build(),
                "Toggle your ability to fly"
        );
    }
}
