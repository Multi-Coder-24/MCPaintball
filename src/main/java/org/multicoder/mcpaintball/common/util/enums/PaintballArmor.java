package org.multicoder.mcpaintball.common.util.enums;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

@SuppressWarnings("all")
public enum PaintballArmor implements ArmorMaterial {
    Red("red"),
    Blue("blue"),
    Green("green"),
    Magenta("magenta"),
    Pink("pink"),
    Purple("purple"),
    Lime("lime"),
    Light_Blue("light_blue"),
    Cyan("cyan");
    private static final int[] HEALTH_PER_SLOT;

    private final String name;

    private final int durabilityMultiplier;

    private final int[] slotProtections;

    private final int enchantmentValue;

    private final SoundEvent sound;

    private final float toughness;
    private final float knockbackResistance;

    private final Supplier<Ingredient> repairIngredient;

    static {
        HEALTH_PER_SLOT = new int[]{1, 1, 1, 1};
    }

    PaintballArmor(String name) {
        this.name = name;
        this.durabilityMultiplier = 1000;
        this.slotProtections = new int[]{0, 0, 0, 0};
        this.enchantmentValue = 0;
        this.toughness = 0.0f;
        this.knockbackResistance = 0.0f;
        this.sound = SoundEvents.ARMOR_EQUIP_LEATHER;
        this.repairIngredient = () -> Ingredient.of(Blocks.WHITE_WOOL);
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

    public Teams GetFrom() {
        switch (this) {
            case Red -> {
                return Teams.RED;
            }
            case Green -> {
                return Teams.GREEN;
            }
            case Blue -> {
                return Teams.BLUE;
            }
            case Cyan -> {
                return Teams.CYAN;
            }
            case Magenta -> {
                return Teams.MAGENTA;
            }
            case Pink -> {
                return Teams.PINK;
            }
            case Purple -> {
                return Teams.PURPLE;
            }
            case Lime -> {
                return Teams.LIME;
            }
            case Light_Blue -> {
                return Teams.LIGHT_BLUE;
            }
        }
        return Teams.NONE;
    }
}
