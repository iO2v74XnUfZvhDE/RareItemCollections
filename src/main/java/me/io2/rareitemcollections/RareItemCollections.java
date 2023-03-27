package me.io2.rareitemcollections;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class RareItemCollections extends JavaPlugin {
    public static Map<String, ItemData> itemsList = new HashMap<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Starting up with " + Bukkit.getVersion());
        itemsList.clear();
        Bukkit.getServer().getPluginManager().registerEvents(new BreakListener(), this);

        saveDefaultConfig();
        FileConfiguration config = getConfig();
        for (String key : config.getKeys(false)) {
            String name = key.substring(0, 1).toUpperCase() + key.substring(1);
            name = name.replace("_", " ");
            getLogger().info(name);
            try {
                int rate = config.getInt(key + ".rate");
                List<String> stringList = config.getStringList(key + ".block");
                getLogger().info(Arrays.toString(stringList.toArray(new String[]{})));
                itemsList.put(name, new ItemData(stringList, rate));
            } catch (Throwable ignored) {
                getLogger().info("Erro at " + name);
            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Shutting down");
    }
}
