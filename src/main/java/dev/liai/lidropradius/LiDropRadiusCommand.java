package dev.liai.lidropradius;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class LiDropRadiusCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("lidropradius.reload")) {
                sender.sendMessage("У тебя нет прав на эту команду!");
                return true;
            }
            LiDropRadius.getInstance().loadConfig();
            sender.sendMessage("Конфиг LiDropRadius перезагружен!");
            return true;
        }

        sender.sendMessage("Использование: /" + label + " reload");
        return true;
    }
}