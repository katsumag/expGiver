package io.github.katsumag.expGiver;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class expGiver extends JavaPlugin {

    @Override
    public void onDisable() {

    }

    @Override
    public void onEnable() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length != 2){
            sender.sendMessage(ChatColor.RED + "Incorrect Usage! /expgive <player_to_take_xp_from> <player_to_give_xp_to>");
        }

        if (sender.hasPermission("expgiver.command") || sender instanceof ConsoleCommandSender){
            if (command.getName().equalsIgnoreCase("expgive")){
                if (Bukkit.getPlayer(args[0]) != null){
                    if (Bukkit.getPlayer(args[1]) != null){
                        Player give = Bukkit.getPlayer(args[0]);
                        Player take = Bukkit.getPlayer(args[1]);
                        give.giveExp((int) Math.floor(take.getExp()));
                        take.setExp(0);
                    } else {
                        sender.sendMessage(ChatColor.RED + args[1] + "is not a player!");
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + args[0] + "is not a player!");
                }
            }
        }
        return true;
    }
}
