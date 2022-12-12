package me.alvsch.mcupgrades.listeners;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.alvsch.mcupgrades.items.weapon.energyblade.EnergyBlade;
import me.alvsch.mcupgrades.items.weapon.energyblade.EnergyBladeMK3;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class HitListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onEnergyBladeHit(EntityDamageByEntityEvent e) {
        Entity entity = e.getDamager();
        if (!(entity instanceof Player)) return;

        ItemStack item = ((Player) entity).getInventory().getItemInMainHand();
        SlimefunItem slimefunItem = SlimefunItem.getByItem(item);

        if (slimefunItem instanceof EnergyBlade) {
            EnergyBlade blade = (EnergyBlade) slimefunItem;
            float charge = blade.getItemCharge(item);

            // Is MK3?
            if (blade instanceof EnergyBladeMK3) {
                if (charge < blade.getMaxItemCharge(item)) {
                    e.setCancelled(true);
                } else {
                    ((LivingEntity) e.getEntity()).setHealth(0);
                    blade.setItemCharge(item, 0);
                }
            }

            if (charge < blade.getMaxItemCharge(item) / 10) {
                e.setCancelled(true);
            } else {
                blade.removeItemCharge(item, blade.getMaxItemCharge(item) / 10);
            }
        }
    }

}
