package me.omrih.omriscommands.commands;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public class VelocityCommand implements BasicCommand {
    @Override
    public void execute(@NotNull CommandSourceStack stack, @NotNull String[] args) {
        if (!(stack.getSender() instanceof Player player)) {
            stack.getSender().sendRichMessage("<red>Only players can execute this command!");
            return;
        }

        if (!(args.length == 3)) {
            player.sendMessage("Usage: /velocity <x> <y> <z>");
            return;
        }

        for (int i = 0; i < 2; i++) {
            if (!StringUtils.isNumeric(args[i])) {
                player.sendMessage("Usage: /velocity <x> <y> <z>");
                return;
            }
        }

        // /velocity x y z
        String xArgument = args[0];
        String yArgument = args[1];
        String zArgument = args[2];

        int x = Integer.parseInt(xArgument);
        int y = Integer.parseInt(yArgument);
        int z = Integer.parseInt(zArgument);

        player.setVelocity(new Vector(x, y, z));
        player.sendRichMessage("<green>Your velocity has been set to " + x + ' ' + y + ' ' + z + '!');
    }
}
