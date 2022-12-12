package me.alvsch.mcupgrades.lists;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.alvsch.mcupgrades.items.weapon.energyblade.EnergyBladeMK1;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

public final class Items {

    public static final SlimefunItemStack ENERGY_BLADE_MK1 = new SlimefunItemStack(
            "ENERGY_BLADE_MK1",
            Material.DIAMOND_SWORD,
            "&3Energy Blade MK1",
            "",
            LoreBuilder.powerCharged(0, 1000),
            "",
            "&7When In Main Hand:",
            "&2 14 Attack Damage",
            "&2 1.6 Attack Speed"
    );
    public static final SlimefunItemStack ENERGY_BLADE_MK2 = new SlimefunItemStack(
            "ENERGY_BLADE_MK2",
            Material.DIAMOND_SWORD,
            "&3Energy Blade MK2",
            "",
            LoreBuilder.powerCharged(0, 5000),
            "",
            "&7When In Main Hand:",
            "&2 20 Attack Damage",
            "&2 1.6 Attack Speed"
    );
    public static final SlimefunItemStack ENERGY_BLADE_MK3 = new SlimefunItemStack(
            "ENERGY_BLADE_MK3",
            Material.DIAMOND_SWORD,
            "&3Energy Blade MK3",
            "",
            LoreBuilder.powerCharged(0, 10000),
            "",
            "&7When In Main Hand:",
            "&2 ∞ Attack Damage",
            "&2 1.6 Attack Speed"
    );

    public static final SlimefunItemStack BLINDFOLD = new SlimefunItemStack(
            "BLINDFOLD",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTY3YTJmMjE4YTZlNmUzOGYyYjU0NWY2YzE3NzMzZjRlZjliYmIyODhlNzU0MDI5NDljMDUyMTg5ZWUifX19",
            "Blindfold",
            "",
            "Its dark in here"
    );

    static {

        ENERGY_BLADE_MK1.addUnsafeEnchantment(Enchantment.LUCK, 1);
        ENERGY_BLADE_MK2.addUnsafeEnchantment(Enchantment.LUCK, 1);
        ENERGY_BLADE_MK3.addUnsafeEnchantment(Enchantment.LUCK, 1);

        ItemMeta meta;

        //region Energy Blade
        // MK1
        meta = ENERGY_BLADE_MK1.getItemMeta();
        meta.setUnbreakable(true);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(
                UUID.randomUUID(),
                "generic.attackDamage",
                20 - 1,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlot.HAND
        ));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS);
        ENERGY_BLADE_MK1.setItemMeta(meta);


        // MK2
        meta = ENERGY_BLADE_MK2.getItemMeta();
        meta.setUnbreakable(true);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(
                UUID.randomUUID(),
                "generic.attackDamage",
                30 - 1,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlot.HAND
        ));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS);
        ENERGY_BLADE_MK2.setItemMeta(meta);


        // MK3
        meta = ENERGY_BLADE_MK3.getItemMeta();
        meta.setUnbreakable(true);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(
                UUID.randomUUID(),
                "generic.attackDamage",
                0,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlot.HAND
        ));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS);
        ENERGY_BLADE_MK3.setItemMeta(meta);
        //endregion


    }

}
