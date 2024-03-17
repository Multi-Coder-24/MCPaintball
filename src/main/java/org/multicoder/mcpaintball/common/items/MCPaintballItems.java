package org.multicoder.mcpaintball.common.items;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.*;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.items.weapons.*;
import org.multicoder.mcpaintball.common.utility.PaintballArmorType;

public class MCPaintballItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(MCPaintball.MOD_ID);

    public static final DeferredItem<?> PISTOL = (DeferredItem<?>) ITEMS.register("pistol", PistolItem::new);
    public static final DeferredItem<?> RIFLE = (DeferredItem<?>) ITEMS.register("rifle", RifleItem::new);
    public static final DeferredItem<?> SHOTGUN = (DeferredItem<?>) ITEMS.register("shotgun", ShotgunItem::new);
    public static final DeferredItem<?> SNIPER = (DeferredItem<?>) ITEMS.register("sniper", SniperItem::new);
    public static final DeferredItem<?> BAZOOKA = (DeferredItem<?>) ITEMS.register("bazooka", BazookaItem::new);

    public static final DeferredItem<?> REMOTE = (DeferredItem<?>) ITEMS.register("remote", RemoteItem::new);
    public static final DeferredItem<?> GRENADE = (DeferredItem<?>) ITEMS.register("grenade", GrenadeItem::new);
    public static final DeferredItem<?> SLOW_GRENADE = (DeferredItem<?>) ITEMS.register("slow_grenade", SlownessGrenadeItem::new);
    public static final DeferredItem<?> WEAK_GRENADE = (DeferredItem<?>) ITEMS.register("weak_grenade", WeaknessGrenadeItem::new);
    public static final DeferredItem<?> BLIND_GRENADE = (DeferredItem<?>) ITEMS.register("blind_grenade", BlindnessGrenadeItem::new);
    public static final DeferredItem<?> DEBUG_WAND = (DeferredItem<?>) ITEMS.register("debug_wand", DebugWand::new);

    //  Armor Sets
    public static final DeferredItem<?> RED_BOOTS = (DeferredItem<?>) ITEMS.register("armor/red_boots",() -> new PaintballBootsItem(PaintballArmorType.RED));
    public static final DeferredItem<?> RED_LEGGINGS = (DeferredItem<?>) ITEMS.register("armor/red_leggings",() -> new PaintballLeggingsItem(PaintballArmorType.RED));
    public static final DeferredItem<?> RED_CHESTPLATE = (DeferredItem<?>) ITEMS.register("armor/red_chestplate",() -> new PaintballChestplateItem(PaintballArmorType.RED));
    public static final DeferredItem<?> RED_HELMET = (DeferredItem<?>) ITEMS.register("armor/red_helmet",() -> new PaintballHelmetItem(PaintballArmorType.RED));

    public static final DeferredItem<?> GREEN_BOOTS = (DeferredItem<?>) ITEMS.register("armor/green_boots",() -> new PaintballBootsItem(PaintballArmorType.GREEN));
    public static final DeferredItem<?> GREEN_LEGGINGS = (DeferredItem<?>) ITEMS.register("armor/leggings",() -> new PaintballLeggingsItem(PaintballArmorType.GREEN));
    public static final DeferredItem<?> GREEN_CHESTPLATE = (DeferredItem<?>) ITEMS.register("armor/green_chestplate",() -> new PaintballChestplateItem(PaintballArmorType.GREEN));
    public static final DeferredItem<?> GREEN_HELMET = (DeferredItem<?>) ITEMS.register("armor/green_helmet",() -> new PaintballHelmetItem(PaintballArmorType.GREEN));

    public static final DeferredItem<?> BLUE_BOOTS = (DeferredItem<?>) ITEMS.register("armor/blue_boots",() -> new PaintballBootsItem(PaintballArmorType.BLUE));
    public static final DeferredItem<?> BLUE_LEGGINGS = (DeferredItem<?>) ITEMS.register("armor/blue_leggings",() -> new PaintballLeggingsItem(PaintballArmorType.BLUE));
    public static final DeferredItem<?> BLUE_CHESTPLATE = (DeferredItem<?>) ITEMS.register("armor/blue_chestplate",() -> new PaintballChestplateItem(PaintballArmorType.BLUE));
    public static final DeferredItem<?> BLUE_HELMET = (DeferredItem<?>) ITEMS.register("armor/blue_helmet",() -> new PaintballHelmetItem(PaintballArmorType.BLUE));

    public static final DeferredItem<?> CYAN_BOOTS = (DeferredItem<?>) ITEMS.register("armor/cyan_boots",() -> new PaintballBootsItem(PaintballArmorType.CYAN));
    public static final DeferredItem<?> CYAN_LEGGINGS = (DeferredItem<?>) ITEMS.register("armor/cyan_leggings",() -> new PaintballLeggingsItem(PaintballArmorType.CYAN));
    public static final DeferredItem<?> CYAN_CHESTPLATE = (DeferredItem<?>) ITEMS.register("armor/cyan_chestplate",() -> new PaintballChestplateItem(PaintballArmorType.CYAN));
    public static final DeferredItem<?> CYAN_HELMET = (DeferredItem<?>) ITEMS.register("armor/cyan_helmet",() -> new PaintballHelmetItem(PaintballArmorType.CYAN));

    public static final DeferredItem<?> MAGENTA_BOOTS = (DeferredItem<?>) ITEMS.register("armor/magenta_boots",() -> new PaintballBootsItem(PaintballArmorType.MAGENTA));
    public static final DeferredItem<?> MAGENTA_LEGGINGS = (DeferredItem<?>) ITEMS.register("armor/magenta_leggings",() -> new PaintballLeggingsItem(PaintballArmorType.MAGENTA));
    public static final DeferredItem<?> MAGENTA_CHESTPLATE = (DeferredItem<?>) ITEMS.register("armor/magenta_chestplate",() -> new PaintballChestplateItem(PaintballArmorType.MAGENTA));
    public static final DeferredItem<?> MAGENTA_HELMET = (DeferredItem<?>) ITEMS.register("armor/magenta_helmet",() -> new PaintballHelmetItem(PaintballArmorType.MAGENTA));

    public static final DeferredItem<?> YELLOW_BOOTS = (DeferredItem<?>) ITEMS.register("armor/yellow_boots",() -> new PaintballBootsItem(PaintballArmorType.YELLOW));
    public static final DeferredItem<?> YELLOW_LEGGINGS = (DeferredItem<?>) ITEMS.register("armor/yellow_leggings",() -> new PaintballLeggingsItem(PaintballArmorType.YELLOW));
    public static final DeferredItem<?> YELLOW_CHESTPLATE = (DeferredItem<?>) ITEMS.register("armor/yellow_chestplate",() -> new PaintballChestplateItem(PaintballArmorType.YELLOW));
    public static final DeferredItem<?> YELLOW_HELMET = (DeferredItem<?>) ITEMS.register("armor/yellow_helmet",() -> new PaintballHelmetItem(PaintballArmorType.YELLOW));

    public static final DeferredItem<?> LIME_BOOTS = (DeferredItem<?>) ITEMS.register("armor/lime_boots",() -> new PaintballBootsItem(PaintballArmorType.LIME));
    public static final DeferredItem<?> LIME_LEGGINGS = (DeferredItem<?>) ITEMS.register("armor/lime_leggings",() -> new PaintballLeggingsItem(PaintballArmorType.LIME));
    public static final DeferredItem<?> LIME_CHESTPLATE = (DeferredItem<?>) ITEMS.register("armor/lime_chestplate",() -> new PaintballChestplateItem(PaintballArmorType.LIME));
    public static final DeferredItem<?> LIME_HELMET = (DeferredItem<?>) ITEMS.register("armor/lime_helmet",() -> new PaintballHelmetItem(PaintballArmorType.LIME));

    public static final DeferredItem<?> LIGHT_BLUE_BOOTS = (DeferredItem<?>) ITEMS.register("armor/light_blue_boots",() -> new PaintballBootsItem(PaintballArmorType.LIGHT_BLUE));
    public static final DeferredItem<?> LIGHT_BLUE_LEGGINGS = (DeferredItem<?>) ITEMS.register("armor/light_blue_leggings",() -> new PaintballLeggingsItem(PaintballArmorType.LIGHT_BLUE));
    public static final DeferredItem<?> LIGHT_BLUE_CHESTPLATE = (DeferredItem<?>) ITEMS.register("armor/light_blue_chestplate",() -> new PaintballChestplateItem(PaintballArmorType.LIGHT_BLUE));
    public static final DeferredItem<?> LIGHT_BLUE_HELMET = (DeferredItem<?>) ITEMS.register("armor/light_blue_helmet",() -> new PaintballHelmetItem(PaintballArmorType.LIGHT_BLUE));

    public static final DeferredItem<?> PINK_BOOTS = (DeferredItem<?>) ITEMS.register("armor/pink_boots",() -> new PaintballBootsItem(PaintballArmorType.PINK));
    public static final DeferredItem<?> PINK_LEGGINGS = (DeferredItem<?>) ITEMS.register("armor/pink_leggings",() -> new PaintballLeggingsItem(PaintballArmorType.PINK));
    public static final DeferredItem<?> PINK_CHESTPLATE = (DeferredItem<?>) ITEMS.register("armor/pink_chestplate",() -> new PaintballChestplateItem(PaintballArmorType.PINK));
    public static final DeferredItem<?> PINK_HELMET = (DeferredItem<?>) ITEMS.register("armor/pink_helmet",() -> new PaintballHelmetItem(PaintballArmorType.PINK));

    public static final DeferredItem<?> PURPLE_BOOTS = (DeferredItem<?>) ITEMS.register("armor/purple_boots",() -> new PaintballBootsItem(PaintballArmorType.PURPLE));
    public static final DeferredItem<?> PURPLE_LEGGINGS = (DeferredItem<?>) ITEMS.register("armor/purple_leggings",() -> new PaintballLeggingsItem(PaintballArmorType.PURPLE));
    public static final DeferredItem<?> PURPLE_CHESTPLATE = (DeferredItem<?>) ITEMS.register("armor/purple_chestplate",() -> new PaintballChestplateItem(PaintballArmorType.PURPLE));
    public static final DeferredItem<?> PURPLE_HELMET = (DeferredItem<?>) ITEMS.register("armor/purple_helmet",() -> new PaintballHelmetItem(PaintballArmorType.PURPLE));
}
