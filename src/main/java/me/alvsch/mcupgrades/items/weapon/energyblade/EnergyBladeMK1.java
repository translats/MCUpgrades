package me.alvsch.mcupgrades.items.weapon.energyblade;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Rechargeable;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.alvsch.mcupgrades.MCUpgrades;
import me.alvsch.mcupgrades.lists.Items;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class EnergyBladeMK1 extends EnergyBlade {

    public EnergyBladeMK1() {
        super(Items.ENERGY_BLADE_MK1, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                null, SlimefunItems.SYNTHETIC_DIAMOND, null,
                null, SlimefunItems.SYNTHETIC_DIAMOND, null,
                null, SlimefunItems.GRANDPAS_WALKING_STICK, null
        });

    }


    @Override
    public float getMaxItemCharge(ItemStack itemStack) {
        return 1000;
    }
}
