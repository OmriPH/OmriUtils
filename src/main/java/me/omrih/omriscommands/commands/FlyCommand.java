package me.omrih.omriscommands.commands;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.entity.Player;

public class FlyCommand implements BasicCommand {
    @Override
    public void execute(CommandSourceStack stack, String[] args) {
        if (!(stack.getSender() instanceof Player player)) {
            stack.getSender().sendRichMessage("<red>Only players can execute this command!");
            return;
        }
        if (player.getAllowFlight()) {
            player.setAllowFlight(false);
            player.sendRichMessage("<red>You can no longer fly");
        } else {
            player.setAllowFlight(true);
            player.sendRichMessage("<green>You can now fly");
        }
    }
}
