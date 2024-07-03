package org.multicoder.mcpaintball.common.utility;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

@SuppressWarnings("all")
public enum PaintballArmorMaterial implements ArmorMaterial {
    RED("mcpaintball:red"),
    GREEN("mcpaintball:green"),
    BLUE("mcpaintball:blue");

    String Name;

    PaintballArmorMaterial(String name) {
        Name = name;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return 500;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return 0;
    }

    @Override
    public int getEnchantmentValue() {
        return 0;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_GENERIC;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.EMPTY;
    }

    @Override
    public String getName() {
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
