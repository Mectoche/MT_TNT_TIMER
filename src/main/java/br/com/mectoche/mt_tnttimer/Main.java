package br.com.mectoche.mt_tnttimer;
/*
*  __  __ _     _______    _     _______ _
* |  \/  | |   |__   __|  | |   |__   __(_)
* | \  / | |_     | |_ __ | |_     | |   _ _ __ ___   ___ _ __
* | |\/| | __|    | | '_ \| __|    | |  | | '_ ` _ \ / _ \ '__|
* | |  | | |_     | | | | | |_     | |  | | | | | | |  __/ |
* |_|  |_|\__|    |_|_| |_|\__|    |_|  |_|_| |_| |_|\___|_|
*                                                              |
*  Ⓡ Developed by: @Mectoche Ⓡ
*  [Timer plugin for tnt milti functional in various minigames]
*
*/
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public final class Main extends JavaPlugin implements Listener {

    private BukkitTask task;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
    }

    @EventHandler
    public void onTntPlace(BlockPlaceEvent event) {
        if (event.getBlockPlaced().getType() == Material.TNT) {
            ItemStack tnt = new ItemStack(Material.TNT);
            event.getPlayer().getInventory().removeItem(tnt);
            Location location = event.getBlockPlaced().getLocation();
            startTimer(location);
            event.setCancelled(true);
        }
    }

    private void startTimer(Location location) {
        TNTPrimed tnt = location.getWorld().spawn(location, TNTPrimed.class);
        tnt.setFuseTicks(60);

        ArmorStand timerStand = (ArmorStand) location.getWorld().spawnEntity(location.clone().add(0., -1, 0.0), EntityType.ARMOR_STAND);
        timerStand.setVisible(false);
        timerStand.setGravity(false);
        timerStand.setCustomNameVisible(true);
        timerStand.setCustomName(ChatColor.YELLOW + "3.00");

        task = new BukkitRunnable() {
            double timer = 3.0;
            boolean exploded = false;

            @Override
            public void run() {
                if (timer > 0.0) {
                    updateTimer(timerStand, timer);
                    timer -= 0.05;
                } else {
                    if (!exploded) {
                        tntExplode(tnt);
                        exploded = true;
                        timerStand.remove();
                    }
                    cancel();
                }
            }
        }.runTaskTimer(this, 0, 1);
    }

    private void tntExplode(TNTPrimed tnt) {
        Location location = tnt.getLocation();
        tnt.remove();
        location.getWorld().createExplosion(location.getX(), location.getY(), location.getZ(), 4f, false, true);
    }

    private void updateTimer(ArmorStand timerStand, double timerLeft) {
        timerStand.setCustomName(ChatColor.YELLOW + String.format("%.2f", timerLeft));
    }
}
