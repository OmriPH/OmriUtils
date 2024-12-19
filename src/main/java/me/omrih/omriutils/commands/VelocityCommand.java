package me.omrih.omriutils.commands;

import com.mojang.brigadier.Command;
import io.papermc.paper.command.brigadier.Commands;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import static com.mojang.brigadier.arguments.IntegerArgumentType.integer;

public class VelocityCommand {
    public static void register(Commands commands) {
        commands.register(
                Commands.literal("velocity")
                        .requires(commandSourceStack -> commandSourceStack.getExecutor() instanceof Player)
                        .requires(commandSourceStack -> commandSourceStack.getExecutor().hasPermission("omriutils.velocity"))
                        .then(
                                Commands.argument("x", integer())
                                        .then(Commands.argument("y", integer())
                                                .then(Commands.argument("z", integer())
                                                        .executes(context -> {
                                                            Player player = (Player) context.getSource().getExecutor();
                                                            int x = context.getArgument("x", int.class);
                                                            int y = context.getArgument("y", int.class);
                                                            int z = context.getArgument("z", int.class);
                                                            player.setVelocity(new Vector(x, y, z));
                                                            player.sendRichMessage("<green>Your velocity has been set to " + x + ' ' + y + ' ' + z);
                                                            return Command.SINGLE_SUCCESS;
                                                        })
                                                )
                                        )
                        )
                        .build(),
                "Modify your velocity"
        );
    }
}