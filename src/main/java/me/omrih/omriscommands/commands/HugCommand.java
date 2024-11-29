package me.omrih.omriscommands.commands;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HugCommand implements BasicCommand {
    @Override
    public void execute(CommandSourceStack stack, String[] args) {
        if (!(stack.getSender() instanceof Player player)) {
            stack.getSender().sendRichMessage("<red>Only players can execute this command!");
            return;
        }

        if (!(args.length == 1)) {
            player.sendMessage("Usage: /hug <playername>");
            return;
        }

        Player playerArg = Bukkit.getPlayer(args[0]);

        if (!playerArg.getName().equals(player.getName())) {
            Bukkit.getServer().broadcast(Component.text(player.getName() + " sends a warm hug to " + playerArg.getName(), NamedTextColor.GREEN));
        } else {
            player.sendRichMessage("<red>You can't hug yourself!");
        }

    }

    @Override
    public Collection<String> suggest(CommandSourceStack commandSourceStack, String[] args) {
        List<String> playerNames = new ArrayList<>();
        for (Player player : Bukkit.getOnlinePlayers()) {
            playerNames.add(player.getName());  // Get the player's username
        }
        return playerNames;
    }
}
