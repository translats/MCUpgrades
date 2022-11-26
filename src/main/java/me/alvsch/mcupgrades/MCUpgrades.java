package me.alvsch.mcupgrades;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerSkin;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.alvsch.mcupgrades.items.EnderOreResource;
import me.alvsch.mcupgrades.items.FireCake;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

public class MCUpgrades extends JavaPlugin implements SlimefunAddon {

    private final String STOVE = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGY5ZGE0NmQ5NzQ2MWExYmUxMDYwMGNjNTQ2YTlkNDYxM2UxNmNmYjU3MTllZWIzOTA0MmU1MDE4MzYwMDhjYSJ9fX0=";
    private final String FIRE_CAKE = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTk1MmQyYjNmMzUxYTZiMDQ4N2NjNTlkYjMxYmY1ZjI2NDExMzNlNWJhMDAwNmIxODU3NmU5OTZhMDI5M2U1MiJ9fX0=";

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }

        NamespacedKey categoryId = new NamespacedKey(this, "upgrades_category");
        CustomItemStack categoryItem = new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromBase64(STOVE)), "&aUpgrades");

        ItemGroup itemGroup = new ItemGroup(categoryId, categoryItem);

        //region FIRE_CAKE
        SlimefunItemStack itemStack = new SlimefunItemStack("FIRE_CAKE", Material.CAKE, "&cFire Cake", "", LoreBuilder.radioactive(Radioactivity.HIGH), LoreBuilder.HAZMAT_SUIT_REQUIRED);

        ItemStack[] recipe = {
                new ItemStack(Material.BLAZE_POWDER), null, new ItemStack(Material.BLAZE_POWDER),
                null, new ItemStack(Material.CAKE), null,
                new ItemStack(Material.BLAZE_POWDER), null, new ItemStack(Material.BLAZE_POWDER)
        };


        FireCake fireCake = new FireCake(itemGroup, itemStack, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        fireCake.register(this);
        //endregion
        //region ENDER_ORE
        SlimefunItemStack enderOreItem = new SlimefunItemStack("ENDER_ORE", FIRE_CAKE, "&5Ender Ore", "", "&rCool Ore");
        SlimefunItem enderOre = new SlimefunItem(itemGroup, enderOreItem, RecipeType.GEO_MINER, new ItemStack[9]);
        enderOre.register(this);

        EnderOreResource enderOreResource = new EnderOreResource(this, enderOreItem);
        enderOreResource.register();
        //endregion

        NamespacedKey researchKey = new NamespacedKey(this, "custom_research");
        Research research = new Research(researchKey, 112221938_1, "You feel smarter now? :)", 10);
        research.addItems(fireCake);

        research.register();

    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

}
