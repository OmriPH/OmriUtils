package me.omrih.omriutils.commands;

import com.mojang.brigadier.Command;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.command.brigadier.argument.ArgumentTypes;
import io.papermc.paper.command.brigadier.argument.resolvers.selector.PlayerSelectorArgumentResolver;
import org.bukkit.entity.Player;

@SuppressWarnings("UnstableApiUsage")
public class FlyCommand {
    public static void register(Commands commands) {
        commands.register(
                Commands.literal("fly")
                        .requires(commandSourceStack -> commandSourceStack.getSender() instanceof Player)
                        .requires(commandSourceStack -> commandSourceStack.getSender().hasPermission("omriutils.fly"))
                        .then(
                                Commands.argument("player", ArgumentTypes.player())
                                        .executes(context -> {
                                            Player player = context.getArgument("player", PlayerSelectorArgumentResolver.class).resolve(context.getSource()).getFirst();
                                            if (player.getAllowFlight()) {
                                                player.setAllowFlight(false);
                                                player.sendRichMessage("<red>" + player.getName() + " can no longer fly");
                                            } else {
                                                player.setAllowFlight(true);
                                                player.sendRichMessage("<green>" + player.getName() + " can now fly");
                                            }
                                            return Command.SINGLE_SUCCESS;
                                        })
                        )
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
                "Toggle a player's ability to fly"
        );
    }
}
