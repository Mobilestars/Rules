package de.scholle.rules;

import de.scholle.rules.RulesManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Rules extends JavaPlugin {

    private RulesManager rulesManager;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.rulesManager = new RulesManager(this);
        getLogger().info("Rules plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Rules plugin has been disabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("rules")) {
            sender.sendMessage("§aServer Rules:§r " + rulesManager.getRulesText());
            return true;
        }
        return false;
    }
}
