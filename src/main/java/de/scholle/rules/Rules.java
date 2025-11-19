package de.scholle.rules;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

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

        if (!command.getName().equalsIgnoreCase("rules")) return false;

        if (getConfig().getBoolean("players-only") && !(sender instanceof Player)) {
            sender.sendMessage("§cOnly players may use this command!");
            return true;
        }

        String perm = getConfig().getString("permission");
        if (perm != null && !perm.isEmpty() && !sender.hasPermission(perm)) {
            sender.sendMessage("§cYou don't have permission to view the rules.");
            return true;
        }

        String prefix = getConfig().getString("prefix");
        String color = getConfig().getString("rules-color");
        boolean asList = getConfig().getBoolean("rules-as-list");

        sender.sendMessage(prefix);

        if (asList) {
            List<String> rules = rulesManager.getRulesList();
            if (rules.isEmpty()) {
                sender.sendMessage(color + "No rules have been set yet.");
            } else {
                for (String r : rules) {
                    sender.sendMessage(color + "- " + r);
                }
            }

        } else {
            sender.sendMessage(color + rulesManager.getRulesString());
        }

        return true;
    }
}
