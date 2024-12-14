package org.multicoder.mcpaintball.init;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.items.armor.PaintballBoots;
import org.multicoder.mcpaintball.items.armor.PaintballChestplate;
import org.multicoder.mcpaintball.items.armor.PaintballHelmet;
import org.multicoder.mcpaintball.items.armor.PaintballLeggings;
import org.multicoder.mcpaintball.items.tools.PaintballC4RemoteItem;
import org.multicoder.mcpaintball.items.weapons.*;
import org.multicoder.mcpaintball.utility.enums.PaintballArmorMaterial;

public class MCPaintballItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MCPaintball.MOD_ID);

    public static final DeferredItem<?> PISTOL = ITEMS.register("weapon/pistol", PistolItem::new);
    public static final DeferredItem<?> RIFLE = ITEMS.register("weapon/rifle", RifleItem::new);
    public static final DeferredItem<?> SHOTGUN = ITEMS.register("weapon/shotgun", ShotgunItem::new);

    public static final DeferredItem<?> RED_GRENADE = ITEMS.register("explosives/red_grenade", GrenadeItem::new);
    public static final DeferredItem<?> GREEN_GRENADE = ITEMS.register("explosives/green_grenade", GrenadeItem::new);
    public static final DeferredItem<?> BLUE_GRENADE = ITEMS.register("explosives/blue_grenade", GrenadeItem::new);

    public static final DeferredItem<?> RED_BOOTS = ITEMS.register("armor/red_boots", () -> new PaintballBoots(PaintballArmorMaterial.RED));
    public static final DeferredItem<?> RED_LEGGINGS = ITEMS.register("armor/red_leggings", () -> new PaintballLeggings(PaintballArmorMaterial.RED));
    public static final DeferredItem<?> RED_CHESTPLATE = ITEMS.register("armor/red_chestplate", () -> new PaintballChestplate(PaintballArmorMaterial.RED));
    public static final DeferredItem<?> RED_HELMET = ITEMS.register("armor/red_helmet", () -> new PaintballHelmet(PaintballArmorMaterial.RED));

    public static final DeferredItem<?> GREEN_BOOTS = ITEMS.register("armor/green_boots", () -> new PaintballBoots(PaintballArmorMaterial.GREEN));
    public static final DeferredItem<?> GREEN_LEGGINGS = ITEMS.register("armor/green_leggings", () -> new PaintballLeggings(PaintballArmorMaterial.GREEN));
    public static final DeferredItem<?> GREEN_CHESTPLATE = ITEMS.register("armor/green_chestplate", () -> new PaintballChestplate(PaintballArmorMaterial.GREEN));
    public static final DeferredItem<?> GREEN_HELMET = ITEMS.register("armor/green_helmet", () -> new PaintballHelmet(PaintballArmorMaterial.GREEN));

    public static final DeferredItem<?> BLUE_BOOTS = ITEMS.register("armor/blue_boots", () -> new PaintballBoots(PaintballArmorMaterial.BLUE));
    public static final DeferredItem<?> BLUE_LEGGINGS = ITEMS.register("armor/blue_leggings", () -> new PaintballLeggings(PaintballArmorMaterial.BLUE));
    public static final DeferredItem<?> BLUE_CHESTPLATE = ITEMS.register("armor/blue_chestplate", () -> new PaintballChestplate(PaintballArmorMaterial.BLUE));
    public static final DeferredItem<?> BLUE_HELMET = ITEMS.register("armor/blue_helmet", () -> new PaintballHelmet(PaintballArmorMaterial.BLUE));

    public static final DeferredItem<Item> RED_REMOTE = ITEMS.register("red_remote", PaintballC4RemoteItem::new);
    public static final DeferredItem<Item> GREEN_REMOTE = ITEMS.register("green_remote", PaintballC4RemoteItem::new);
    public static final DeferredItem<Item> BLUE_REMOTE = ITEMS.register("blue_remote", PaintballC4RemoteItem::new);
}
