package org.multicoder.mcpaintball.core;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.item.utility.*;
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

    public static final Item RED_PAINT_GRENADE = register("explosives/red_grenade", RedPaintGrenadeItem::new,new Item.Properties().stacksTo(8));
    public static final Item GREEN_PAINT_GRENADE = register("explosives/green_grenade", GreenPaintGrenadeItem::new,new Item.Properties().stacksTo(8));
    public static final Item BLUE_PAINT_GRENADE = register("explosives/blue_grenade", BluePaintGrenadeItem::new,new Item.Properties().stacksTo(8));

    public static final Item SMOKE_GRENADE = register("explosives/smoke_grenade", SmokeGrenadeItem::new,new Item.Properties().stacksTo(16));

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

    public static final Item RED_C4_REMOTE = Registry.register(BuiltInRegistries.ITEM,Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"util/red_c4_remote"), new RedC4RemoteItem());
    public static final Item GREEN_C4_REMOTE = Registry.register(BuiltInRegistries.ITEM,Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"util/green_c4_remote"), new GreenC4RemoteItem());
    public static final Item BLUE_C4_REMOTE = Registry.register(BuiltInRegistries.ITEM,Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"util/blue_c4_remote"), new BlueC4RemoteItem());

    public static void Initialize(){
        MCPaintball.LOGGER.debug("Initializing Items");
    }


    public static <T extends Item> T register(String name, Function<Item.Properties,T> factory,Item.Properties properties){
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID, name));

        // Create the item instance.
        T item = factory.apply(properties.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }
}
