package org.multicoder.mcpaintball.core;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import org.multicoder.mcpaintball.MCPaintball;

import java.util.Map;

public class MCPaintballArmorMaterials {

    public static void Initialize(){
        MCPaintball.LOGGER.debug("Initializing Armor Materials");
    }
    private static final ResourceKey<EquipmentAsset> RED_ARMOR_MATERIALS = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"red"));
    private static final ResourceKey<EquipmentAsset> GREEN_ARMOR_MATERIALS = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"green"));
    private static final ResourceKey<EquipmentAsset> BLUE_ARMOR_MATERIALS = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"blue"));
    private static final ResourceKey<EquipmentAsset> YELLOW_ARMOR_MATERIALS = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"yellow"));
    private static final ResourceKey<EquipmentAsset> PINK_ARMOR_MATERIALS = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"pink"));
    private static final ResourceKey<EquipmentAsset> ORANGE_ARMOR_MATERIALS = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"orange"));

    public static final ArmorMaterial RED_ARMOR_MATERIAL = new ArmorMaterial(1000, Map.of(ArmorType.HELMET,0,ArmorType.CHESTPLATE,0,ArmorType.LEGGINGS,0,ArmorType.BOOTS,0),1, SoundEvents.ARMOR_EQUIP_GENERIC,0f,0f, TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath("minecraft","air")),RED_ARMOR_MATERIALS);
    public static final ArmorMaterial GREEN_ARMOR_MATERIAL = new ArmorMaterial(1000, Map.of(ArmorType.HELMET,0,ArmorType.CHESTPLATE,0,ArmorType.LEGGINGS,0,ArmorType.BOOTS,0),1, SoundEvents.ARMOR_EQUIP_GENERIC,0f,0f, TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath("minecraft","air")),GREEN_ARMOR_MATERIALS);
    public static final ArmorMaterial BLUE_ARMOR_MATERIAL = new ArmorMaterial(1000, Map.of(ArmorType.HELMET,0,ArmorType.CHESTPLATE,0,ArmorType.LEGGINGS,0,ArmorType.BOOTS,0),1, SoundEvents.ARMOR_EQUIP_GENERIC,0f,0f, TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath("minecraft","air")),BLUE_ARMOR_MATERIALS);
    public static final ArmorMaterial YELLOW_ARMOR_MATERIAL = new ArmorMaterial(1000, Map.of(ArmorType.HELMET,0,ArmorType.CHESTPLATE,0,ArmorType.LEGGINGS,0,ArmorType.BOOTS,0),1, SoundEvents.ARMOR_EQUIP_GENERIC,0f,0f, TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath("minecraft","air")),YELLOW_ARMOR_MATERIALS);
    public static final ArmorMaterial PINK_ARMOR_MATERIAL = new ArmorMaterial(1000, Map.of(ArmorType.HELMET,0,ArmorType.CHESTPLATE,0,ArmorType.LEGGINGS,0,ArmorType.BOOTS,0),1, SoundEvents.ARMOR_EQUIP_GENERIC,0f,0f, TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath("minecraft","air")),PINK_ARMOR_MATERIALS);
    public static final ArmorMaterial ORANGE_ARMOR_MATERIAL = new ArmorMaterial(1000, Map.of(ArmorType.HELMET,0,ArmorType.CHESTPLATE,0,ArmorType.LEGGINGS,0,ArmorType.BOOTS,0),1, SoundEvents.ARMOR_EQUIP_GENERIC,0f,0f, TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath("minecraft","air")),ORANGE_ARMOR_MATERIALS);
}
