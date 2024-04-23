package org.multicoder.mcpaintball.common.utility;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum PaintballArmorType implements ArmorMaterial {
    RED("red"),
    GREEN("green"),
    BLUE("blue"),
    CYAN("cyan"),
    MAGENTA("magenta"),
    YELLOW("yellow"),
    LIME("lime"),
    LIGHT_BLUE("light_blue"),
    PINK("pink"),
    PURPLE("purple");

    private static final int[] HEALTH_PER_SLOT = new int[]{1, 1, 1, 1};

    private final String name;

    private final int durabilityMultiplier = 1000;

    private final int[] slotProtections = new int[]{0, 0, 0, 0};

    private final int enchantmentValue = 0;

    private final SoundEvent sound = SoundEvents.ARMOR_EQUIP_LEATHER;

    private final float toughness = 0f;
    private final float knockbackResistance = 0f;

    private final Supplier<Ingredient> repairIngredient = () -> Ingredient.EMPTY;


    PaintballArmorType(String name) {
        this.name = name;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type p_266807_) {
        return HEALTH_PER_SLOT[p_266807_.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type p_267168_) {
        return this.slotProtections[p_267168_.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.sound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return "mcpaintball:" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }


}
