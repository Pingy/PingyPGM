package io.pingy.commands;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 * Created by thlappy on 7/26/2016.
 */
public class Test {
    @Command(aliases = {"author"}, desc = "A simple test command")
    public static void test(final CommandContext args, CommandSender sender) throws CommandException {
        sender.sendMessage("At least this command works :)");
        String world = Bukkit.getServer().getWorldContainer().getAbsolutePath();
        sender.sendMessage(ChatColor.AQUA + world);
    }
}