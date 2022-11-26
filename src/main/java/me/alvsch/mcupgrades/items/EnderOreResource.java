package me.alvsch.mcupgrades.items;

import io.github.thebusybiscuit.slimefun4.api.geo.GEOResource;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class EnderOreResource implements GEOResource {

    private final NamespacedKey key;
    private final ItemStack item;

    public EnderOreResource(Plugin plugin, ItemStack item) {
        this.key = new NamespacedKey(plugin, "ender_ore");
        this.item = item;
    }

    @Override
    public String getName() {
        return "Ender Ore";
    }

    @Override
    public boolean isObtainableFromGEOMiner() {
        return true;
    }

    @Override
    public int getDefaultSupply(World.Environment environment, Biome biome) {
        if (environment == World.Environment.THE_END) {
            return 20;
        }
        else {
            return 0;
        }
    }

    @Override
    public int getMaxDeviation() {
        return 8;
    }

    @Override
    public NamespacedKey getKey() {
        return key;
    }

    @Override
    public ItemStack getItem() {
        return item.clone();
    }
}
