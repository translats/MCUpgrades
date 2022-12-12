package me.alvsch.mcupgrades.items.weapon.energyblade;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Rechargeable;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.alvsch.mcupgrades.MCUpgrades;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public abstract class EnergyBlade extends SlimefunItem implements Rechargeable {

    public EnergyBlade(SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(MCUpgrades.itemGroup, item, recipeType, recipe);

    }

    @Override
    public float getMaxItemCharge(ItemStack itemStack) {
        return 1;
    }
}
