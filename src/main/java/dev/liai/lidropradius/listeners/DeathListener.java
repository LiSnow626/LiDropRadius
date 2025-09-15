package dev.liai.lidropradius.listeners;

import dev.liai.lidropradius.LiDropRadius;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class DeathListener implements Listener {

    private final Random random = new Random();

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Location loc = event.getEntity().getLocation();
        double radius = LiDropRadius.getInstance().getDropRadius();

        for (ItemStack item : event.getDrops()) {
            double angle = random.nextDouble() * 2 * Math.PI;
            double dist = random.nextDouble() * radius;

            double x = Math.cos(angle) * dist;
            double z = Math.sin(angle) * dist;

            Location dropLoc = loc.clone().add(x, 0.5, z);
            loc.getWorld().dropItemNaturally(dropLoc, item);
        }

        // Убираем стандартный дроп
        event.getDrops().clear();
    }
}
