package io.pingy;

import com.sk89q.bukkit.util.CommandsManagerRegistration;
import com.sk89q.minecraft.util.commands.*;
import io.pingy.commands.Map;
import io.pingy.commands.Test;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by thlappy on 7/22/2016.
 */
public class PingyPGM extends JavaPlugin {
    public void onEnable(){
        setupCommands();
    }
    private CommandsManager<CommandSender> commands;

    private void setupCommands() {
        this.commands = new CommandsManager<CommandSender>() {
            @Override
            public boolean hasPermission(CommandSender sender, String perm) {
                return sender instanceof ConsoleCommandSender || sender.hasPermission(perm);
            }
        };
        CommandsManagerRegistration cmdRegister = new CommandsManagerRegistration(this, this.commands);
            cmdRegister.register(Map.class);
            cmdRegister.register(Test.class);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        try {
            this.commands.execute(cmd.getName(), args, sender, sender);
        } catch (CommandPermissionsException e) {
            sender.sendMessage(ChatColor.RED + "You don't have permission.");
        } catch (MissingNestedCommandException e) {
            sender.sendMessage(ChatColor.RED + e.getUsage());
        } catch (CommandUsageException e) {
            sender.sendMessage(ChatColor.RED + e.getMessage());
            sender.sendMessage(ChatColor.RED + e.getUsage());
        } catch (WrappedCommandException e) {
            if (e.getCause() instanceof NumberFormatException) {
                sender.sendMessage(ChatColor.RED + "Number expected, string received instead.");
            } else {
                sender.sendMessage(ChatColor.RED + "An error has occurred. See console.");
                e.printStackTrace();
            }
        } catch (CommandException e) {
            sender.sendMessage(ChatColor.RED + e.getMessage());
        }
        return true;
    }
}