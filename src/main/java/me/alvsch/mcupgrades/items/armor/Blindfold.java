package me.alvsch.mcupgrades.items.armor;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.items.armor.SlimefunArmorPiece;
import me.alvsch.mcupgrades.MCUpgrades;
import me.alvsch.mcupgrades.lists.Items;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Blindfold extends SlimefunArmorPiece {

    public Blindfold() {
        super(MCUpgrades.itemGroup, Items.BLINDFOLD, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                new ItemStack(Material.BLACK_WOOL), new ItemStack(Material.BLACK_WOOL), new ItemStack(Material.BLACK_WOOL),
                new ItemStack(Material.BLACK_WOOL), new ItemStack(Material.LEATHER_HELMET), new ItemStack(Material.BLACK_WOOL),
                new ItemStack(Material.BLACK_WOOL), new ItemStack(Material.BLACK_WOOL), new ItemStack(Material.BLACK_WOOL)
        }, new PotionEffect[]{
                new PotionEffect(PotionEffectType.BLINDNESS, 14 * 20, 0, false, false, true)
        });
    }

}
