package de.scholle.rules;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class RulesManager {

    private final JavaPlugin plugin;
    private File rulesFile;
    private FileConfiguration rulesConfig;

    public RulesManager(JavaPlugin plugin) {
        this.plugin = plugin;
        loadRules();
    }

    private void loadRules() {
        rulesFile = new File(plugin.getDataFolder(), "rules.yml");
        if (!rulesFile.exists()) {
            plugin.saveResource("rules.yml", false);
        }
        rulesConfig = YamlConfiguration.loadConfiguration(rulesFile);
    }

    public String getRulesText() {
        return rulesConfig.getString("rules", "There are no rules set yet.");
    }

    public void setRulesText(String text) {
        rulesConfig.set("rules", text);
        saveRules();
    }

    private void saveRules() {
        try {
            rulesConfig.save(rulesFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}