package org.multicoder.mcpaintball.core;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.item.*;

public class MCPaintballItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MCPaintball.MODID);

    public static final DeferredItem<?> PISTOL = ITEMS.registerItem("weapon/pistol", PistolItem::new);
    public static final DeferredItem<?> SHOTGUN = ITEMS.registerItem("weapon/shotgun", ShotgunItem::new);
    public static final DeferredItem<?> SNIPER_RIFLE = ITEMS.registerItem("weapon/sniper_rifle", SniperRifleItem::new);
    public static final DeferredItem<?> ASSAULT_RIFLE = ITEMS.registerItem("weapon/assault_rifle", RifleItem::new);
    public static final DeferredItem<?> GRENADE_LAUNCHER = ITEMS.registerItem("weapon/grenade_launcher", GrenadeLauncherItem::new);
    public static final DeferredItem<?> BURST_RIFLE = ITEMS.registerItem("weapon/burst_rifle", BurstRifleItem::new);

    public static final DeferredItem<?> RED_PAINT_GRENADE = ITEMS.registerItem("explosives/red_grenade",RedPaintGrenadeItem::new);
    public static final DeferredItem<?> GREEN_PAINT_GRENADE = ITEMS.registerItem("explosives/green_grenade",GreenPaintGrenadeItem::new);
    public static final DeferredItem<?> BLUE_PAINT_GRENADE = ITEMS.registerItem("explosives/blue_grenade",BluePaintGrenadeItem::new);

    public static final DeferredItem<?> SMOKE_GRENADE = ITEMS.registerItem("explosives/smoke_grenade",SmokeGrenadeItem::new);

    public static final DeferredItem<?> RED_BOOTS = ITEMS.registerItem("armor/red_boots", Item::new,() -> new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.RED_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final DeferredItem<?> RED_LEGGINGS = ITEMS.registerItem("armor/red_leggings", Item::new,() -> new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.RED_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final DeferredItem<?> RED_CHESTPLATE = ITEMS.registerItem("armor/red_chestplate", Item::new,() -> new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.RED_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final DeferredItem<?> RED_HELMET = ITEMS.registerItem("armor/red_helmet", Item::new,() -> new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.RED_ARMOR_MATERIAL, ArmorType.HELMET));


    public static final DeferredItem<?> GREEN_BOOTS = ITEMS.registerItem("armor/green_boots", Item::new,() -> new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.GREEN_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final DeferredItem<?> GREEN_LEGGINGS = ITEMS.registerItem("armor/green_leggings", Item::new,() -> new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.GREEN_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final DeferredItem<?> GREEN_CHESTPLATE = ITEMS.registerItem("armor/green_chestplate", Item::new,() -> new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.GREEN_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final DeferredItem<?> GREEN_HELMET = ITEMS.registerItem("armor/green_helmet", Item::new,() -> new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.GREEN_ARMOR_MATERIAL, ArmorType.HELMET));


    public static final DeferredItem<?> BLUE_BOOTS = ITEMS.registerItem("armor/blue_boots", Item::new,() -> new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.BLUE_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final DeferredItem<?> BLUE_LEGGINGS = ITEMS.registerItem("armor/blue_leggings", Item::new,() -> new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.BLUE_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final DeferredItem<?> BLUE_CHESTPLATE = ITEMS.registerItem("armor/blue_chestplate", Item::new,() -> new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.BLUE_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final DeferredItem<?> BLUE_HELMET = ITEMS.registerItem("armor/blue_helmet", Item::new,() -> new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.BLUE_ARMOR_MATERIAL, ArmorType.HELMET));

}
