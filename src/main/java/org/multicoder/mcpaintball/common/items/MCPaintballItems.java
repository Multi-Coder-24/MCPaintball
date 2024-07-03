package org.multicoder.mcpaintball.common.items;

import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.items.armor.PaintballBoots;
import org.multicoder.mcpaintball.common.items.armor.PaintballChestplate;
import org.multicoder.mcpaintball.common.items.armor.PaintballHelmet;
import org.multicoder.mcpaintball.common.items.armor.PaintballLeggings;
import org.multicoder.mcpaintball.common.items.tools.PaintballC4RemoteItem;
import org.multicoder.mcpaintball.common.items.weapons.*;
import org.multicoder.mcpaintball.common.items.weapons.grenade.GrenadeItem;
import org.multicoder.mcpaintball.common.utility.PaintballArmorMaterial;

public class MCPaintballItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MCPaintball.MOD_ID);

    public static final DeferredItem<?> PISTOL = ITEMS.register("pistol", PistolItem::new);
    public static final DeferredItem<?> RIFLE = ITEMS.register("rifle", RifleItem::new);
    public static final DeferredItem<?> SHOTGUN = ITEMS.register("shotgun", ShotgunItem::new);
    public static final DeferredItem<?> BAZOOKA = ITEMS.register("bazooka", BazookaItem::new);

    public static final DeferredItem<?> RED_GRENADE = ITEMS.register("red_grenade", GrenadeItem::new);
    public static final DeferredItem<?> GREEN_GRENADE = ITEMS.register("green_grenade", GrenadeItem::new);
    public static final DeferredItem<?> BLUE_GRENADE = ITEMS.register("blue_grenade", GrenadeItem::new);

    public static final DeferredItem<?> RED_BOOTS = ITEMS.register("red_boots", () -> new PaintballBoots((ArmorMaterial) PaintballArmorMaterial.RED_ARMOR.get()));
    public static final DeferredItem<?> RED_LEGGINGS = ITEMS.register("red_leggings", () -> new PaintballLeggings((ArmorMaterial) PaintballArmorMaterial.RED_ARMOR.get()));
    public static final DeferredItem<?> RED_CHESTPLATE = ITEMS.register("red_chestplate", () -> new PaintballChestplate((ArmorMaterial) PaintballArmorMaterial.RED_ARMOR.get()));
    public static final DeferredItem<?> RED_HELMET = ITEMS.register("red_helmet", () -> new PaintballHelmet((ArmorMaterial) PaintballArmorMaterial.RED_ARMOR.get()));

    public static final DeferredItem<?> GREEN_BOOTS = ITEMS.register("green_boots", () -> new PaintballBoots((ArmorMaterial) PaintballArmorMaterial.GREEN_ARMOR.get()));
    public static final DeferredItem<?> GREEN_LEGGINGS = ITEMS.register("green_leggings", () -> new PaintballLeggings((ArmorMaterial) PaintballArmorMaterial.GREEN_ARMOR.get()));
    public static final DeferredItem<?> GREEN_CHESTPLATE = ITEMS.register("green_chestplate", () -> new PaintballChestplate((ArmorMaterial) PaintballArmorMaterial.GREEN_ARMOR.get()));
    public static final DeferredItem<?> GREEN_HELMET = ITEMS.register("green_helmet", () -> new PaintballHelmet((ArmorMaterial) PaintballArmorMaterial.GREEN_ARMOR.get()));

    public static final DeferredItem<?> BLUE_BOOTS = ITEMS.register("blue_boots", () -> new PaintballBoots((ArmorMaterial) PaintballArmorMaterial.BLUE_ARMOR.get()));
    public static final DeferredItem<?> BLUE_LEGGINGS = ITEMS.register("blue_leggings", () -> new PaintballLeggings((ArmorMaterial) PaintballArmorMaterial.BLUE_ARMOR.get()));
    public static final DeferredItem<?> BLUE_CHESTPLATE = ITEMS.register("blue_chestplate", () -> new PaintballChestplate((ArmorMaterial) PaintballArmorMaterial.BLUE_ARMOR.get()));
    public static final DeferredItem<?> BLUE_HELMET = ITEMS.register("blue_helmet", () -> new PaintballHelmet((ArmorMaterial) PaintballArmorMaterial.BLUE_ARMOR.get()));

    public static final DeferredItem<Item> RED_REMOTE = ITEMS.register("red_remote", PaintballC4RemoteItem::new);
    public static final DeferredItem<Item> GREEN_REMOTE = ITEMS.register("green_remote", PaintballC4RemoteItem::new);
    public static final DeferredItem<Item> BLUE_REMOTE = ITEMS.register("blue_remote", PaintballC4RemoteItem::new);
}
