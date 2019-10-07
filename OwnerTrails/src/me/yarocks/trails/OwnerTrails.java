package me.yarocks.trails;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

/**
 * Created by USER on 7/28/2014.
 */
public class OwnerTrails extends JavaPlugin implements Listener, CommandExecutor {

    static ArrayList<String> trails = new ArrayList<String>();

    public void onEnable() {
        getCommand("eo").setExecutor(this);
        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(this, this);
        manager.registerEvents(new PlayerMove(), this);

    }

    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (command.getName().equalsIgnoreCase("eo")) {
            if (p.hasPermission("eo.on"))
            if (args.length == 0) {
                sender.sendMessage("on or off?");
            }
                if (args[0].equalsIgnoreCase("on")) {
                    trails.add(p.getName());
                }
                else if (args[0].equalsIgnoreCase("off")) {
                    if (p.hasPermission("eo.off"))

                    trails.remove(p.getName());
                }
            } else return true;

            return true;
        }
    }


