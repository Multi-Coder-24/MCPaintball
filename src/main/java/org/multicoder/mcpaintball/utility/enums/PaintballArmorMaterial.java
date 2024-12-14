package org.multicoder.mcpaintball.utility.enums;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public enum PaintballArmorMaterial implements ArmorMaterial {
    RED("mcpaintball:red"),
    GREEN("mcpaintball:green"),
    BLUE("mcpaintball:blue"),
    GRAY("mcpaintball:gray");

    final String Name;

    PaintballArmorMaterial(String name) {
        Name = name;
    }

    @Override
    public int getDurabilityForType(ArmorItem.@NotNull Type type) {
        return 500;
    }

    @Override
    public int getDefenseForType(ArmorItem.@NotNull Type type) {
        return 0;
    }

    @Override
    public int getEnchantmentValue() {
        return 0;
    }

    @Override
    public @NotNull SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_GENERIC;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return Ingredient.EMPTY;
    }

    @Override
    public @NotNull String getName() {
        return Name;
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
