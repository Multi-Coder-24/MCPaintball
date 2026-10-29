package org.multicoder.mcpaintball.core;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.item.MedalItem;
import org.multicoder.mcpaintball.item.objectives.FlagItem;
import org.multicoder.mcpaintball.item.weapon.*;
import org.multicoder.mcpaintball.item.weapon.grenades.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MCPaintballItems {

    public static List<Item> UTILITY_ITEMS = new ArrayList<>();
    public static List<Item> WEAPON_ITEMS = new ArrayList<>();

    public static final Item PISTOL = registerWeaponItem("weapon/pistol", PistolItem::new,new Item.Properties());
    public static final Item SHOTGUN = registerWeaponItem("weapon/shotgun", ShotgunItem::new,new Item.Properties());
    public static final Item SNIPER_RIFLE = registerWeaponItem("weapon/sniper_rifle", SniperRifleItem::new,new Item.Properties());
    public static final Item ASSAULT_RIFLE = registerWeaponItem("weapon/assault_rifle", RifleItem::new,new Item.Properties());
    public static final Item GRENADE_LAUNCHER = registerWeaponItem("weapon/grenade_launcher", GrenadeLauncherItem::new,new Item.Properties());
    public static final Item BURST_RIFLE = registerWeaponItem("weapon/burst_rifle", BurstRifleItem::new,new Item.Properties());

    public static final Item RED_PAINT_GRENADE = registerWeaponItem("explosives/red_grenade", PaintGrenadeItem::new,new Item.Properties().stacksTo(8));
    public static final Item GREEN_PAINT_GRENADE = registerWeaponItem("explosives/green_grenade", PaintGrenadeItem::new,new Item.Properties().stacksTo(8));
    public static final Item BLUE_PAINT_GRENADE = registerWeaponItem("explosives/blue_grenade", PaintGrenadeItem::new,new Item.Properties().stacksTo(8));
    public static final Item YELLOW_PAINT_GRENADE = registerWeaponItem("explosives/yellow_grenade", PaintGrenadeItem::new,new Item.Properties().stacksTo(8));
    public static final Item PINK_PAINT_GRENADE = registerWeaponItem("explosives/pink_grenade", PaintGrenadeItem::new,new Item.Properties().stacksTo(8));
    public static final Item ORANGE_PAINT_GRENADE = registerWeaponItem("explosives/orange_grenade", PaintGrenadeItem::new,new Item.Properties().stacksTo(8));
    public static final Item CYAN_PAINT_GRENADE = registerWeaponItem("explosives/cyan_grenade", PaintGrenadeItem::new,new Item.Properties().stacksTo(8));
    public static final Item MAGENTA_PAINT_GRENADE = registerWeaponItem("explosives/magenta_grenade", PaintGrenadeItem::new,new Item.Properties().stacksTo(8));
    public static final Item LIME_PAINT_GRENADE = registerWeaponItem("explosives/lime_grenade", PaintGrenadeItem::new,new Item.Properties().stacksTo(8));
    public static final Item LIGHT_BLUE_PAINT_GRENADE = registerWeaponItem("explosives/light_blue_grenade", PaintGrenadeItem::new,new Item.Properties().stacksTo(8));
    public static final Item LIGHT_GRAY_PAINT_GRENADE = registerWeaponItem("explosives/light_gray_grenade", PaintGrenadeItem::new,new Item.Properties().stacksTo(8));
    public static final Item GRAY_PAINT_GRENADE = registerWeaponItem("explosives/gray_grenade", PaintGrenadeItem::new,new Item.Properties().stacksTo(8));
    public static final Item WHITE_PAINT_GRENADE = registerWeaponItem("explosives/white_grenade", PaintGrenadeItem::new,new Item.Properties().stacksTo(8));
    public static final Item BLACK_PAINT_GRENADE = registerWeaponItem("explosives/black_grenade", PaintGrenadeItem::new,new Item.Properties().stacksTo(8));
    public static final Item BROWN_PAINT_GRENADE = registerWeaponItem("explosives/brown_grenade", PaintGrenadeItem::new,new Item.Properties().stacksTo(8));
    public static final Item PURPLE_PAINT_GRENADE = registerWeaponItem("explosives/purple_grenade", PaintGrenadeItem::new,new Item.Properties().stacksTo(8));

    public static final Item SMOKE_GRENADE = registerWeaponItem("explosives/smoke_grenade", SmokeGrenadeItem::new,new Item.Properties().stacksTo(16));
    public static final Item EMP_GRENADE = registerWeaponItem("explosives/emp_grenade", EMPGrenadeItem::new,new Item.Properties().stacksTo(16));
    public static final Item SIGHT_GRENADE = registerWeaponItem("explosives/sight_grenade", SightGrenadeItem::new,new Item.Properties().stacksTo(16));

    public static final Item RED_BOOTS = registerUtilityItem("armor/red_boots",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.RED_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final Item RED_LEGGINGS = registerUtilityItem("armor/red_leggings",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.RED_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final Item RED_CHESTPLATE = registerUtilityItem("armor/red_chestplate",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.RED_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final Item RED_HELMET = registerUtilityItem("armor/red_helmet",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.RED_ARMOR_MATERIAL, ArmorType.HELMET));

    public static final Item GREEN_BOOTS = registerUtilityItem("armor/green_boots",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.GREEN_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final Item GREEN_LEGGINGS = registerUtilityItem("armor/green_leggings",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.GREEN_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final Item GREEN_CHESTPLATE = registerUtilityItem("armor/green_chestplate",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.GREEN_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final Item GREEN_HELMET = registerUtilityItem("armor/green_helmet",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.GREEN_ARMOR_MATERIAL, ArmorType.HELMET));

    public static final Item BLUE_BOOTS = registerUtilityItem("armor/blue_boots",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.BLUE_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final Item BLUE_LEGGINGS = registerUtilityItem("armor/blue_leggings",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.BLUE_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final Item BLUE_CHESTPLATE = registerUtilityItem("armor/blue_chestplate",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.BLUE_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final Item BLUE_HELMET = registerUtilityItem("armor/blue_helmet",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.BLUE_ARMOR_MATERIAL, ArmorType.HELMET));

    public static final Item YELLOW_BOOTS = registerUtilityItem("armor/yellow_boots",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.YELLOW_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final Item YELLOW_LEGGINGS = registerUtilityItem("armor/yellow_leggings",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.YELLOW_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final Item YELLOW_CHESTPLATE = registerUtilityItem("armor/yellow_chestplate",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.YELLOW_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final Item YELLOW_HELMET = registerUtilityItem("armor/yellow_helmet",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.YELLOW_ARMOR_MATERIAL, ArmorType.HELMET));

    public static final Item PINK_BOOTS = registerUtilityItem("armor/pink_boots",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.PINK_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final Item PINK_LEGGINGS = registerUtilityItem("armor/pink_leggings",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.PINK_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final Item PINK_CHESTPLATE = registerUtilityItem("armor/pink_chestplate",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.PINK_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final Item PINK_HELMET = registerUtilityItem("armor/pink_helmet",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.PINK_ARMOR_MATERIAL, ArmorType.HELMET));

    public static final Item ORANGE_BOOTS = registerUtilityItem("armor/orange_boots",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.ORANGE_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final Item ORANGE_LEGGINGS = registerUtilityItem("armor/orange_leggings",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.ORANGE_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final Item ORANGE_CHESTPLATE = registerUtilityItem("armor/orange_chestplate",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.ORANGE_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final Item ORANGE_HELMET = registerUtilityItem("armor/orange_helmet",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.ORANGE_ARMOR_MATERIAL, ArmorType.HELMET));

    public static final Item CYAN_BOOTS = registerUtilityItem("armor/cyan_boots",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.CYAN_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final Item CYAN_LEGGINGS = registerUtilityItem("armor/cyan_leggings",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.CYAN_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final Item CYAN_CHESTPLATE = registerUtilityItem("armor/cyan_chestplate",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.CYAN_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final Item CYAN_HELMET = registerUtilityItem("armor/cyan_helmet",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.CYAN_ARMOR_MATERIAL, ArmorType.HELMET));

    public static final Item MAGENTA_BOOTS = registerUtilityItem("armor/magenta_boots",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.MAGENTA_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final Item MAGENTA_LEGGINGS = registerUtilityItem("armor/magenta_leggings",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.MAGENTA_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final Item MAGENTA_CHESTPLATE = registerUtilityItem("armor/magenta_chestplate",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.MAGENTA_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final Item MAGENTA_HELMET = registerUtilityItem("armor/magenta_helmet",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.MAGENTA_ARMOR_MATERIAL, ArmorType.HELMET));

    public static final Item LIME_BOOTS = registerUtilityItem("armor/lime_boots",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.LIME_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final Item LIME_LEGGINGS = registerUtilityItem("armor/lime_leggings",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.LIME_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final Item LIME_CHESTPLATE = registerUtilityItem("armor/lime_chestplate",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.LIME_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final Item LIME_HELMET = registerUtilityItem("armor/lime_helmet",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.LIME_ARMOR_MATERIAL, ArmorType.HELMET));

    public static final Item LIGHT_BLUE_BOOTS = registerUtilityItem("armor/light_blue_boots",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.LIGHT_BLUE_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final Item LIGHT_BLUE_LEGGINGS = registerUtilityItem("armor/light_blue_leggings",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.LIGHT_BLUE_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final Item LIGHT_BLUE_CHESTPLATE = registerUtilityItem("armor/light_blue_chestplate",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.LIGHT_BLUE_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final Item LIGHT_BLUE_HELMET = registerUtilityItem("armor/light_blue_helmet",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.LIGHT_BLUE_ARMOR_MATERIAL, ArmorType.HELMET));

    public static final Item LIGHT_GRAY_BOOTS = registerUtilityItem("armor/light_gray_boots",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.LIGHT_GRAY_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final Item LIGHT_GRAY_LEGGINGS = registerUtilityItem("armor/light_gray_leggings",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.LIGHT_GRAY_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final Item LIGHT_GRAY_CHESTPLATE = registerUtilityItem("armor/light_gray_chestplate",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.LIGHT_GRAY_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final Item LIGHT_GRAY_HELMET = registerUtilityItem("armor/light_gray_helmet",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.LIGHT_GRAY_ARMOR_MATERIAL, ArmorType.HELMET));

    public static final Item GRAY_BOOTS = registerUtilityItem("armor/gray_boots",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.GRAY_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final Item GRAY_LEGGINGS = registerUtilityItem("armor/gray_leggings",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.GRAY_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final Item GRAY_CHESTPLATE = registerUtilityItem("armor/gray_chestplate",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.GRAY_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final Item GRAY_HELMET = registerUtilityItem("armor/gray_helmet",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.GRAY_ARMOR_MATERIAL, ArmorType.HELMET));

    public static final Item WHITE_BOOTS = registerUtilityItem("armor/white_boots",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.WHITE_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final Item WHITE_LEGGINGS = registerUtilityItem("armor/white_leggings",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.WHITE_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final Item WHITE_CHESTPLATE = registerUtilityItem("armor/white_chestplate",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.WHITE_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final Item WHITE_HELMET = registerUtilityItem("armor/white_helmet",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.WHITE_ARMOR_MATERIAL, ArmorType.HELMET));

    public static final Item BLACK_BOOTS = registerUtilityItem("armor/black_boots",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.BLACK_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final Item BLACK_LEGGINGS = registerUtilityItem("armor/black_leggings",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.BLACK_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final Item BLACK_CHESTPLATE = registerUtilityItem("armor/black_chestplate",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.BLACK_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final Item BLACK_HELMET = registerUtilityItem("armor/black_helmet",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.BLACK_ARMOR_MATERIAL, ArmorType.HELMET));

    public static final Item BROWN_BOOTS = registerUtilityItem("armor/brown_boots",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.BROWN_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final Item BROWN_LEGGINGS = registerUtilityItem("armor/brown_leggings",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.BROWN_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final Item BROWN_CHESTPLATE = registerUtilityItem("armor/brown_chestplate",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.BROWN_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final Item BROWN_HELMET = registerUtilityItem("armor/brown_helmet",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.BROWN_ARMOR_MATERIAL, ArmorType.HELMET));

    public static final Item PURPLE_BOOTS = registerUtilityItem("armor/purple_boots",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.PURPLE_ARMOR_MATERIAL, ArmorType.BOOTS));
    public static final Item PURPLE_LEGGINGS = registerUtilityItem("armor/purple_leggings",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.PURPLE_ARMOR_MATERIAL, ArmorType.LEGGINGS));
    public static final Item PURPLE_CHESTPLATE = registerUtilityItem("armor/purple_chestplate",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.PURPLE_ARMOR_MATERIAL, ArmorType.CHESTPLATE));
    public static final Item PURPLE_HELMET = registerUtilityItem("armor/purple_helmet",Item::new,new Item.Properties().humanoidArmor(MCPaintballArmorMaterials.PURPLE_ARMOR_MATERIAL, ArmorType.HELMET));

    public static final Item RED_FLAG_ITEM = registerHiddenItem("objectives/red_flag_item", FlagItem::new,new Item.Properties());
    public static final Item GREEN_FLAG_ITEM = registerHiddenItem("objectives/green_flag_item", FlagItem::new,new Item.Properties());
    public static final Item BLUE_FLAG_ITEM = registerHiddenItem("objectives/blue_flag_item", FlagItem::new,new Item.Properties());
    public static final Item YELLOW_FLAG_ITEM = registerHiddenItem("objectives/yellow_flag_item", FlagItem::new,new Item.Properties());
    public static final Item PINK_FLAG_ITEM = registerHiddenItem("objectives/pink_flag_item", FlagItem::new,new Item.Properties());
    public static final Item ORANGE_FLAG_ITEM = registerHiddenItem("objectives/orange_flag_item", FlagItem::new,new Item.Properties());
    public static final Item CYAN_FLAG_ITEM = registerHiddenItem("objectives/orange_flag_item", FlagItem::new,new Item.Properties());
    public static final Item MAGENTA_FLAG_ITEM = registerHiddenItem("objectives/magenta_flag_item", FlagItem::new,new Item.Properties());
    public static final Item LIME_FLAG_ITEM = registerHiddenItem("objectives/lime_flag_item", FlagItem::new,new Item.Properties());
    public static final Item LIGHT_BLUE_FLAG_ITEM = registerHiddenItem("objectives/light_blue_flag_item", FlagItem::new,new Item.Properties());
    public static final Item LIGHT_GRAY_FLAG_ITEM = registerHiddenItem("objectives/light_gray_flag_item", FlagItem::new,new Item.Properties());
    public static final Item GRAY_FLAG_ITEM = registerHiddenItem("objectives/gray_flag_item", FlagItem::new,new Item.Properties());
    public static final Item WHITE_FLAG_ITEM = registerHiddenItem("objectives/white_flag_item", FlagItem::new,new Item.Properties());
    public static final Item BLACK_FLAG_ITEM = registerHiddenItem("objectives/black_flag_item", FlagItem::new,new Item.Properties());
    public static final Item BROWN_FLAG_ITEM = registerHiddenItem("objectives/brown_flag_item", FlagItem::new,new Item.Properties());
    public static final Item PURPLE_FLAG_ITEM = registerHiddenItem("objectives/purple_flag_item", FlagItem::new,new Item.Properties());

    public static void initialize(){
        MCPaintball.LOGGER.info("Initializing Items");
    }


    public static <T extends Item> T registerUtilityItem(String name, Function<Item.Properties,T> factory,Item.Properties properties){
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID, name));
        T item = factory.apply(properties.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        UTILITY_ITEMS.add(item);
        return item;
    }

    public static <T extends Item> T registerWeaponItem(String name, Function<Item.Properties,T> factory,Item.Properties properties){
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID, name));
        T item = factory.apply(properties.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        WEAPON_ITEMS.add(item);
        return item;
    }

    public static <T extends Item> T registerHiddenItem(String name, Function<Item.Properties,T> factory,Item.Properties properties){
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID, name));
        T item = factory.apply(properties.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }
}
