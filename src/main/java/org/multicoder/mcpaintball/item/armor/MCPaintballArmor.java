package org.multicoder.mcpaintball.item.armor;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.item.armor.material.MCPaintballArmorMaterial;

@SuppressWarnings("unused")
public class MCPaintballArmor
{
    public static final DeferredRegister<Item> ARMORS = DeferredRegister.create(Registries.ITEM, MCPaintball.MOD_ID);
    //  Boots
    public static final DeferredHolder<Item,Item> RED_BOOTS = ARMORS.register("armor/red_boots",() -> new PaintballBoots(MCPaintballArmorMaterial.RED));
    public static final DeferredHolder<Item,Item> GREEN_BOOTS = ARMORS.register("armor/green_boots",() -> new PaintballBoots(MCPaintballArmorMaterial.GREEN));
    public static final DeferredHolder<Item,Item> BLUE_BOOTS = ARMORS.register("armor/blue_boots",() -> new PaintballBoots(MCPaintballArmorMaterial.BLUE));
    public static final DeferredHolder<Item,Item> CYAN_BOOTS = ARMORS.register("armor/cyan_boots",() -> new PaintballBoots(MCPaintballArmorMaterial.CYAN));
    public static final DeferredHolder<Item,Item> MAGENTA_BOOTS = ARMORS.register("armor/magenta_boots",() -> new PaintballBoots(MCPaintballArmorMaterial.MAGENTA));
    public static final DeferredHolder<Item,Item> YELLOW_BOOTS = ARMORS.register("armor/yellow_boots",() -> new PaintballBoots(MCPaintballArmorMaterial.YELLOW));
    public static final DeferredHolder<Item,Item> LIGHT_BLUE_BOOTS = ARMORS.register("armor/light_blue_boots",() -> new PaintballBoots(MCPaintballArmorMaterial.LIGHT_BLUE));
    public static final DeferredHolder<Item,Item> LIME_BOOTS = ARMORS.register("armor/lime_boots",() -> new PaintballBoots(MCPaintballArmorMaterial.LIME));
    public static final DeferredHolder<Item,Item> PINK_BOOTS = ARMORS.register("armor/pink_boots",() -> new PaintballBoots(MCPaintballArmorMaterial.PINK));
    public static final DeferredHolder<Item,Item> WHITE_BOOTS = ARMORS.register("armor/white_boots",() -> new PaintballBoots(MCPaintballArmorMaterial.WHITE));
    //  Leggings
    public static final DeferredHolder<Item,Item> RED_LEGGINGS = ARMORS.register("armor/red_leggings",() -> new PaintballLeggings(MCPaintballArmorMaterial.RED));
    public static final DeferredHolder<Item,Item> GREEN_LEGGINGS = ARMORS.register("armor/green_leggings",() -> new PaintballLeggings(MCPaintballArmorMaterial.GREEN));
    public static final DeferredHolder<Item,Item> BLUE_LEGGINGS = ARMORS.register("armor/blue_leggings",() -> new PaintballLeggings(MCPaintballArmorMaterial.BLUE));
    public static final DeferredHolder<Item,Item> CYAN_LEGGINGS = ARMORS.register("armor/cyan_leggings",() -> new PaintballLeggings(MCPaintballArmorMaterial.CYAN));
    public static final DeferredHolder<Item,Item> MAGENTA_LEGGINGS = ARMORS.register("armor/magenta_leggings",() -> new PaintballLeggings(MCPaintballArmorMaterial.MAGENTA));
    public static final DeferredHolder<Item,Item> YELLOW_LEGGINGS = ARMORS.register("armor/yellow_leggings",() -> new PaintballLeggings(MCPaintballArmorMaterial.YELLOW));
    public static final DeferredHolder<Item,Item> LIGHT_BLUE_LEGGINGS = ARMORS.register("armor/light_blue_leggings",() -> new PaintballLeggings(MCPaintballArmorMaterial.LIGHT_BLUE));
    public static final DeferredHolder<Item,Item> LIME_LEGGINGS = ARMORS.register("armor/lime_leggings",() -> new PaintballLeggings(MCPaintballArmorMaterial.LIME));
    public static final DeferredHolder<Item,Item> PINK_LEGGINGS = ARMORS.register("armor/pink_leggings",() -> new PaintballLeggings(MCPaintballArmorMaterial.PINK));
    public static final DeferredHolder<Item,Item> WHITE_LEGGINGS = ARMORS.register("armor/white_leggings",() -> new PaintballLeggings(MCPaintballArmorMaterial.WHITE));
    //  Chestplate
    public static final DeferredHolder<Item,Item> RED_CHESTPLATE = ARMORS.register("armor/red_chestplate",() -> new PaintballChestplate(MCPaintballArmorMaterial.RED));
    public static final DeferredHolder<Item,Item> GREEN_CHESTPLATE = ARMORS.register("armor/green_chestplate",() -> new PaintballChestplate(MCPaintballArmorMaterial.GREEN));
    public static final DeferredHolder<Item,Item> BLUE_CHESTPLATE = ARMORS.register("armor/blue_chestplate",() -> new PaintballChestplate(MCPaintballArmorMaterial.BLUE));
    public static final DeferredHolder<Item,Item> CYAN_CHESTPLATE = ARMORS.register("armor/cyan_chestplate",() -> new PaintballChestplate(MCPaintballArmorMaterial.CYAN));
    public static final DeferredHolder<Item,Item> MAGENTA_CHESTPLATE = ARMORS.register("armor/magenta_chestplate",() -> new PaintballChestplate(MCPaintballArmorMaterial.MAGENTA));
    public static final DeferredHolder<Item,Item> YELLOW_CHESTPLATE = ARMORS.register("armor/yellow_chestplate",() -> new PaintballChestplate(MCPaintballArmorMaterial.YELLOW));
    public static final DeferredHolder<Item,Item> LIGHT_BLUE_CHESTPLATE = ARMORS.register("armor/light_blue_chestplate",() -> new PaintballChestplate(MCPaintballArmorMaterial.LIGHT_BLUE));
    public static final DeferredHolder<Item,Item> LIME_CHESTPLATE = ARMORS.register("armor/lime_chestplate",() -> new PaintballChestplate(MCPaintballArmorMaterial.LIME));
    public static final DeferredHolder<Item,Item> PINK_CHESTPLATE = ARMORS.register("armor/pink_chestplate",() -> new PaintballChestplate(MCPaintballArmorMaterial.PINK));
    public static final DeferredHolder<Item,Item> WHITE_CHESTPLATE = ARMORS.register("armor/white_chestplate",() -> new PaintballChestplate(MCPaintballArmorMaterial.WHITE));
    //  Helmet
    public static final DeferredHolder<Item,Item> RED_HELMET = ARMORS.register("armor/red_helmet",() -> new PaintballHelmet(MCPaintballArmorMaterial.RED));
    public static final DeferredHolder<Item,Item> GREEN_HELMET = ARMORS.register("armor/green_helmet",() -> new PaintballHelmet(MCPaintballArmorMaterial.GREEN));
    public static final DeferredHolder<Item,Item> BLUE_HELMET = ARMORS.register("armor/blue_helmet",() -> new PaintballHelmet(MCPaintballArmorMaterial.BLUE));
    public static final DeferredHolder<Item,Item> CYAN_HELMET = ARMORS.register("armor/cyan_helmet",() -> new PaintballHelmet(MCPaintballArmorMaterial.CYAN));
    public static final DeferredHolder<Item,Item> MAGENTA_HELMET = ARMORS.register("armor/magenta_helmet",() -> new PaintballHelmet(MCPaintballArmorMaterial.MAGENTA));
    public static final DeferredHolder<Item,Item> YELLOW_HELMET = ARMORS.register("armor/yellow_helmet",() -> new PaintballHelmet(MCPaintballArmorMaterial.YELLOW));
    public static final DeferredHolder<Item,Item> LIGHT_BLUE_HELMET = ARMORS.register("armor/light_blue_helmet",() -> new PaintballHelmet(MCPaintballArmorMaterial.LIGHT_BLUE));
    public static final DeferredHolder<Item,Item> LIME_HELMET = ARMORS.register("armor/lime_helmet",() -> new PaintballHelmet(MCPaintballArmorMaterial.LIME));
    public static final DeferredHolder<Item,Item> PINK_HELMET = ARMORS.register("armor/pink_helmet",() -> new PaintballHelmet(MCPaintballArmorMaterial.PINK));
    public static final DeferredHolder<Item,Item> WHITE_HELMET = ARMORS.register("armor/white_helmet",() -> new PaintballHelmet(MCPaintballArmorMaterial.WHITE));
}
