package me.omrih.omriutils.commands;

import com.mojang.brigadier.Command;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.command.brigadier.argument.ArgumentTypes;
import io.papermc.paper.command.brigadier.argument.resolvers.selector.PlayerSelectorArgumentResolver;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@SuppressWarnings("UnstableApiUsage")
public class HugCommand {
    public static void register(Commands commands) {
        commands.register(
                Commands.literal("hug")
                        .requires(commandSourceStack -> commandSourceStack.getExecutor() instanceof Player)
                        .then(
                                Commands.argument("player", ArgumentTypes.players())
                                        .executes(context -> {
                                            Player player = (Player) context.getSource().getExecutor();
                                            Player playerArg = context.getArgument("player", PlayerSelectorArgumentResolver.class).resolve(context.getSource()).getFirst();
                                            if (!playerArg.getName().equals(player.getName())) {
                                                Bukkit.getServer().broadcast(Component.text(player.getName() + " sends a warm hug to " + playerArg.getName(), NamedTextColor.GREEN));
                                            } else {
                                                player.sendRichMessage("<red>You can't hug yourself!");
                                            }
                                            return Command.SINGLE_SUCCESS;
                                        })
                        )
                        .build(),
                "Send a hug to a player"
        );
    }
}
