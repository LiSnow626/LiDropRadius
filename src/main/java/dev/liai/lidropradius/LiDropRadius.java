package dev.liai.lidropradius;

import dev.liai.lidropradius.listeners.DeathListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class LiDropRadius extends JavaPlugin {

    private static LiDropRadius instance;
    private double dropRadius;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        loadConfig();

        getServer().getPluginManager().registerEvents(new DeathListener(), this);

        // Регистрируем команду
        Objects.requireNonNull(getCommand("lidropradius")).setExecutor(new LiDropRadiusCommand());

        getLogger().info("LiDropRadius включен! Автор: LiSnow");
    }

    @Override
    public void onDisable() {
        getLogger().info("LiDropRadius выключен!");
    }

    public void loadConfig() {
        reloadConfig();
        dropRadius = getConfig().getDouble("drop-radius", 5.0);
    }

    public static LiDropRadius getInstance() {
        return instance;
    }

    public double getDropRadius() {
        return dropRadius;
    }
}
