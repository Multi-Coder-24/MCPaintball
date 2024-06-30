package org.multicoder.mcpaintball.common.items;

import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.*;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.items.armor.PaintballBoots;
import org.multicoder.mcpaintball.common.items.armor.PaintballChestplate;
import org.multicoder.mcpaintball.common.items.armor.PaintballHelmet;
import org.multicoder.mcpaintball.common.items.armor.PaintballLeggings;
import org.multicoder.mcpaintball.common.items.weapons.*;
import org.multicoder.mcpaintball.common.utility.PaintballArmorMaterial;

public class MCPaintballItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(MCPaintball.MOD_ID);

    public static final DeferredItem<?> PISTOL = (DeferredItem<?>) ITEMS.register("pistol", PistolItem::new);
    public static final DeferredItem<?> RIFLE = (DeferredItem<?>) ITEMS.register("rifle", RifleItem::new);
    public static final DeferredItem<?> SHOTGUN = (DeferredItem<?>) ITEMS.register("shotgun", ShotgunItem::new);
    public static final DeferredItem<?> BAZOOKA = (DeferredItem<?>) ITEMS.register("bazooka", BazookaItem::new);

    public static final DeferredItem<?> GRENADE = (DeferredItem<?>) ITEMS.register("grenade", GrenadeItem::new);

    public static final DeferredItem<?> RED_BOOTS = (DeferredItem<?>) ITEMS.register("red_boots", () -> new PaintballBoots((ArmorMaterial) PaintballArmorMaterial.RED_ARMOR.get()));
    public static final DeferredItem<?> RED_LEGGINGS = (DeferredItem<?>) ITEMS.register("red_leggings", () -> new PaintballLeggings((ArmorMaterial) PaintballArmorMaterial.RED_ARMOR.get()));
    public static final DeferredItem<?> RED_CHESTPLATE = (DeferredItem<?>) ITEMS.register("red_chestplate", () -> new PaintballChestplate((ArmorMaterial) PaintballArmorMaterial.RED_ARMOR.get()));
    public static final DeferredItem<?> RED_HELMET = (DeferredItem<?>) ITEMS.register("red_helmet", () -> new PaintballHelmet((ArmorMaterial) PaintballArmorMaterial.RED_ARMOR.get()));

    public static final DeferredItem<?> GREEN_BOOTS = (DeferredItem<?>) ITEMS.register("green_boots", () -> new PaintballBoots((ArmorMaterial) PaintballArmorMaterial.GREEN_ARMOR.get()));
    public static final DeferredItem<?> GREEN_LEGGINGS = (DeferredItem<?>) ITEMS.register("green_leggings", () -> new PaintballLeggings((ArmorMaterial) PaintballArmorMaterial.GREEN_ARMOR.get()));
    public static final DeferredItem<?> GREEN_CHESTPLATE = (DeferredItem<?>) ITEMS.register("green_chestplate", () -> new PaintballChestplate((ArmorMaterial) PaintballArmorMaterial.GREEN_ARMOR.get()));
    public static final DeferredItem<?> GREEN_HELMET = (DeferredItem<?>) ITEMS.register("green_helmet", () -> new PaintballHelmet((ArmorMaterial) PaintballArmorMaterial.GREEN_ARMOR.get()));

    public static final DeferredItem<?> BLUE_BOOTS = (DeferredItem<?>) ITEMS.register("blue_boots", () -> new PaintballBoots((ArmorMaterial) PaintballArmorMaterial.BLUE_ARMOR.get()));
    public static final DeferredItem<?> BLUE_LEGGINGS = (DeferredItem<?>) ITEMS.register("blue_leggings", () -> new PaintballLeggings((ArmorMaterial) PaintballArmorMaterial.BLUE_ARMOR.get()));
    public static final DeferredItem<?> BLUE_CHESTPLATE = (DeferredItem<?>) ITEMS.register("blue_chestplate", () -> new PaintballChestplate((ArmorMaterial) PaintballArmorMaterial.BLUE_ARMOR.get()));
    public static final DeferredItem<?> BLUE_HELMET = (DeferredItem<?>) ITEMS.register("blue_helmet", () -> new PaintballHelmet((ArmorMaterial) PaintballArmorMaterial.BLUE_ARMOR.get()));
}
