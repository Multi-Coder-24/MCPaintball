package org.multicoder.mcpaintball.core;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.data.FlagItemSettings;
import org.multicoder.mcpaintball.item.objectives.FlagItem;
import org.multicoder.mcpaintball.item.weapon.*;
import org.multicoder.mcpaintball.item.weapon.grenades.*;

import java.util.function.Function;

public class MCPaintballItems {
    public static final Item PISTOL = register("weapon/pistol", PistolItem::new,new Item.Properties());
    public static final Item SHOTGUN = register("weapon/shotgun", ShotgunItem::new,new Item.Properties());
    public static final Item SNIPER_RIFLE = register("weapon/sniper_rifle", SniperRifleItem::new,new Item.Properties());
    public static final Item ASSAULT_RIFLE = register("weapon/assault_rifle", RifleItem::new,new Item.Properties());
    public static final Item GRENADE_LAUNCHER = register("weapon/grenade_launcher", GrenadeLauncherItem::new,new Item.Properties());
    public static final Item BURST_RIFLE = register("weapon/burst_rifle", BurstRifleItem::new,new Item.Properties());

    public static final Item RED_PAINT_GRENADE = register("explosives/red_grenade", PaintGrenadeItem::new,new Item.Properties().stacksTo(8));
    public static final Item GREEN_PAINT_GRENADE = register("explosives/green_grenade", PaintGrenadeItem::new,new Item.Properties().stacksTo(8));
    public static final Item BLUE_PAINT_GRENADE = register("explosives/blue_grenade", PaintGrenadeItem::new,new Item.Properties().stacksTo(8));
    public static final Item YELLOW_PAINT_GRENADE = register("explosives/yellow_grenade", PaintGrenadeItem::new,new Item.Properties().stacksTo(8));
    public static final Item PINK_PAINT_GRENADE = register("explosives/pink_grenade", PaintGrenadeItem::new,new Item.Properties().stacksTo(8));
    public static final Item ORANGE_PAINT_GRENADE = register("explosives/orange_grenade", PaintGrenadeItem::new,new Item.Properties().stacksTo(8));

    public static final Item SMOKE_GRENADE = register("explosives/smoke_grenade", SmokeGrenadeItem::new,new Item.Properties().stacksTo(16));
    public static final Item EMP_GRENADE = register("explosives/emp_grenade", EMPGrenadeItem::new,new Item.Properties().stacksTo(16));
    public static final Item SIGHT_GRENADE = register("explosives/sight_grenade", SightGrenadeItem::new,new Item.Properties().stacksTo(16));

    public static final Item RED_BOOTS = register("armor/red_boots",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.RED_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final Item RED_LEGGINGS = register("armor/red_leggings",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.RED_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final Item RED_CHESTPLATE = register("armor/red_chestplate",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.RED_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final Item RED_HELMET = register("armor/red_helmet",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.RED_ARMOR_MATERIAL, ArmorType.HELMET));

    public static final Item GREEN_BOOTS = register("armor/green_boots",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.GREEN_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final Item GREEN_LEGGINGS = register("armor/green_leggings",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.GREEN_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final Item GREEN_CHESTPLATE = register("armor/green_chestplate",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.GREEN_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final Item GREEN_HELMET = register("armor/green_helmet",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.GREEN_ARMOR_MATERIAL, ArmorType.HELMET));

    public static final Item BLUE_BOOTS = register("armor/blue_boots",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.BLUE_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final Item BLUE_LEGGINGS = register("armor/blue_leggings",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.BLUE_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final Item BLUE_CHESTPLATE = register("armor/blue_chestplate",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.BLUE_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final Item BLUE_HELMET = register("armor/blue_helmet",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.BLUE_ARMOR_MATERIAL, ArmorType.HELMET));

    public static final Item YELLOW_BOOTS = register("armor/yellow_boots",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.YELLOW_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final Item YELLOW_LEGGINGS = register("armor/yellow_leggings",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.YELLOW_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final Item YELLOW_CHESTPLATE = register("armor/yellow_chestplate",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.YELLOW_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final Item YELLOW_HELMET = register("armor/yellow_helmet",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.YELLOW_ARMOR_MATERIAL, ArmorType.HELMET));

    public static final Item PINK_BOOTS = register("armor/pink_boots",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.PINK_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final Item PINK_LEGGINGS = register("armor/pink_leggings",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.PINK_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final Item PINK_CHESTPLATE = register("armor/pink_chestplate",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.PINK_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final Item PINK_HELMET = register("armor/pink_helmet",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.PINK_ARMOR_MATERIAL, ArmorType.HELMET));

    public static final Item ORANGE_BOOTS = register("armor/orange_boots",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.ORANGE_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final Item ORANGE_LEGGINGS = register("armor/orange_leggings",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.ORANGE_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final Item ORANGE_CHESTPLATE = register("armor/orange_chestplate",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.ORANGE_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final Item ORANGE_HELMET = register("armor/orange_helmet",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.ORANGE_ARMOR_MATERIAL, ArmorType.HELMET));

    public static final Item RED_FLAG_ITEM = register("objectives/red_flag_item", FlagItem::new,new Item.Properties().component(MCPaintballDataComponents.FLAGITEMSETTINGS,new FlagItemSettings(BlockPos.ZERO, 0)).stacksTo(8));
    public static final Item GREEN_FLAG_ITEM = register("objectives/green_flag_item", FlagItem::new,new Item.Properties().component(MCPaintballDataComponents.FLAGITEMSETTINGS,new FlagItemSettings(BlockPos.ZERO, 0)).stacksTo(8));
    public static final Item BLUE_FLAG_ITEM = register("objectives/blue_flag_item", FlagItem::new,new Item.Properties().component(MCPaintballDataComponents.FLAGITEMSETTINGS,new FlagItemSettings(BlockPos.ZERO, 0)).stacksTo(8));
    public static final Item YELLOW_FLAG_ITEM = register("objectives/yellow_flag_item", FlagItem::new,new Item.Properties().component(MCPaintballDataComponents.FLAGITEMSETTINGS,new FlagItemSettings(BlockPos.ZERO, 0)).stacksTo(8));
    public static final Item PINK_FLAG_ITEM = register("objectives/pink_flag_item", FlagItem::new,new Item.Properties().component(MCPaintballDataComponents.FLAGITEMSETTINGS,new FlagItemSettings(BlockPos.ZERO, 0)).stacksTo(8));
    public static final Item ORANGE_FLAG_ITEM = register("objectives/orange_flag_item", FlagItem::new,new Item.Properties().component(MCPaintballDataComponents.FLAGITEMSETTINGS,new FlagItemSettings(BlockPos.ZERO, 0)).stacksTo(8));

    public static void initialize(){
        MCPaintball.LOGGER.info("Initializing Items");
    }


    public static <T extends Item> T register(String name, Function<Item.Properties,T> factory,Item.Properties properties){
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID, name));
        T item = factory.apply(properties.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }
}
