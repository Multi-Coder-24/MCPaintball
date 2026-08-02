package org.multicoder.mcpaintball.core;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.item.objectives.FlagItem;
import org.multicoder.mcpaintball.item.weapon.*;
import org.multicoder.mcpaintball.item.weapon.grenades.*;

public class MCPaintballItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MCPaintball.MODID);

    public static final DeferredItem<?> PISTOL = ITEMS.registerItem("weapon/pistol", PistolItem::new);
    public static final DeferredItem<?> SHOTGUN = ITEMS.registerItem("weapon/shotgun", ShotgunItem::new);
    public static final DeferredItem<?> SNIPER_RIFLE = ITEMS.registerItem("weapon/sniper_rifle", SniperRifleItem::new);
    public static final DeferredItem<?> ASSAULT_RIFLE = ITEMS.registerItem("weapon/assault_rifle", RifleItem::new);
    public static final DeferredItem<?> GRENADE_LAUNCHER = ITEMS.registerItem("weapon/grenade_launcher", GrenadeLauncherItem::new);
    public static final DeferredItem<?> BURST_RIFLE = ITEMS.registerItem("weapon/burst_rifle", BurstRifleItem::new);

    public static final DeferredItem<?> RED_PAINT_GRENADE = ITEMS.registerItem("explosives/red_grenade", GrenadeItem::new);
    public static final DeferredItem<?> GREEN_PAINT_GRENADE = ITEMS.registerItem("explosives/green_grenade", GrenadeItem::new);
    public static final DeferredItem<?> BLUE_PAINT_GRENADE = ITEMS.registerItem("explosives/blue_grenade", GrenadeItem::new);
    public static final DeferredItem<?> YELLOW_PAINT_GRENADE = ITEMS.registerItem("explosives/yellow_grenade", GrenadeItem::new);
    public static final DeferredItem<?> PINK_PAINT_GRENADE = ITEMS.registerItem("explosives/pink_grenade", GrenadeItem::new);
    public static final DeferredItem<?> ORANGE_PAINT_GRENADE = ITEMS.registerItem("explosives/orange_grenade", GrenadeItem::new);

    public static final DeferredItem<?> RED_FLAG_ITEM = ITEMS.registerItem("objectives/red_flag_item", FlagItem::new);
    public static final DeferredItem<?> GREEN_FLAG_ITEM = ITEMS.registerItem("objectives/green_flag_item", FlagItem::new);
    public static final DeferredItem<?> BLUE_FLAG_ITEM = ITEMS.registerItem("objectives/blue_flag_item", FlagItem::new);
    public static final DeferredItem<?> YELLOW_FLAG_ITEM = ITEMS.registerItem("objectives/yellow_flag_item", FlagItem::new);
    public static final DeferredItem<?> PINK_FLAG_ITEM = ITEMS.registerItem("objectives/pink_flag_item", FlagItem::new);
    public static final DeferredItem<?> ORANGE_FLAG_ITEM = ITEMS.registerItem("objectives/orange_flag_item", FlagItem::new);


    public static final DeferredItem<?> SMOKE_GRENADE = ITEMS.registerItem("explosives/smoke_grenade", GrenadeItem::new);
    public static final DeferredItem<?> EMP_GRENADE = ITEMS.registerItem("explosives/emp_grenade", GrenadeItem::new);
    public static final DeferredItem<?> SIGHT_GRENADE = ITEMS.registerItem("explosives/sight_grenade", GrenadeItem::new);

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

    public static final DeferredItem<?> YELLOW_BOOTS = ITEMS.registerItem("armor/yellow_boots", Item::new,() -> new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.YELLOW_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final DeferredItem<?> YELLOW_LEGGINGS = ITEMS.registerItem("armor/yellow_leggings", Item::new,() -> new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.YELLOW_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final DeferredItem<?> YELLOW_CHESTPLATE = ITEMS.registerItem("armor/yellow_chestplate", Item::new,() -> new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.YELLOW_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final DeferredItem<?> YELLOW_HELMET = ITEMS.registerItem("armor/yellow_helmet", Item::new,() -> new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.YELLOW_ARMOR_MATERIAL, ArmorType.HELMET));

    public static final DeferredItem<?> PINK_BOOTS = ITEMS.registerItem("armor/pink_boots", Item::new,() -> new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.PINK_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final DeferredItem<?> PINK_LEGGINGS = ITEMS.registerItem("armor/pink_leggings", Item::new,() -> new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.PINK_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final DeferredItem<?> PINK_CHESTPLATE = ITEMS.registerItem("armor/pink_chestplate", Item::new,() -> new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.PINK_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final DeferredItem<?> PINK_HELMET = ITEMS.registerItem("armor/pink_helmet", Item::new,() -> new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.PINK_ARMOR_MATERIAL, ArmorType.HELMET));

    public static final DeferredItem<?> ORANGE_BOOTS = ITEMS.registerItem("armor/orange_boots", Item::new,() -> new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.ORANGE_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final DeferredItem<?> ORANGE_LEGGINGS = ITEMS.registerItem("armor/orange_leggings", Item::new,() -> new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.ORANGE_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final DeferredItem<?> ORANGE_CHESTPLATE = ITEMS.registerItem("armor/orange_chestplate", Item::new,() -> new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.ORANGE_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final DeferredItem<?> ORANGE_HELMET = ITEMS.registerItem("armor/orange_helmet", Item::new,() -> new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.ORANGE_ARMOR_MATERIAL, ArmorType.HELMET));

}
