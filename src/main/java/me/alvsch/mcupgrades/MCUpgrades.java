package me.alvsch.mcupgrades;

import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerSkin;
import me.alvsch.mcupgrades.items.weapon.energyblade.EnergyBladeMK1;
import me.alvsch.mcupgrades.items.weapon.energyblade.EnergyBladeMK2;
import me.alvsch.mcupgrades.items.weapon.energyblade.EnergyBladeMK3;
import me.alvsch.mcupgrades.listeners.HitListener;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

public class MCUpgrades extends JavaPlugin implements SlimefunAddon {

    private final String STOVE = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGY5ZGE0NmQ5NzQ2MWExYmUxMDYwMGNjNTQ2YTlkNDYxM2UxNmNmYjU3MTllZWIzOTA0MmU1MDE4MzYwMDhjYSJ9fX0=";

    public static ItemGroup itemGroup;

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }

        NamespacedKey categoryId = new NamespacedKey(this, "upgrades_category");
        CustomItemStack categoryItem = new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromBase64(STOVE)), "&aUpgrades");

        itemGroup = new ItemGroup(categoryId, categoryItem);

        NamespacedKey researchKey = new NamespacedKey(this, "custom_research");
        Research research = new Research(researchKey, 112221938_1, "你现在觉得更聪明了? :)", 10);

        research.register();

        createItems();

        registerEvents();

    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new HitListener(), this);
    }


    private void createItems() {

        //endregion
        //region EnergyBlade MK 1-3
        new EnergyBladeMK1().register(this);
        new EnergyBladeMK2().register(this);
        new EnergyBladeMK3().register(this);
        //endregion

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
