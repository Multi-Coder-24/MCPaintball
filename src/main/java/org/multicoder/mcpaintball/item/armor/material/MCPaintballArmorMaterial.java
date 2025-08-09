package org.multicoder.mcpaintball.item.armor.material;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;

import java.util.EnumMap;
import java.util.List;

public class MCPaintballArmorMaterial
{
    public static final DeferredRegister<ArmorMaterial> MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, MCPaintball.MOD_ID);

    public static final Holder<ArmorMaterial> RED = MATERIALS.register("red",() -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class),map -> {map.put(ArmorItem.Type.BODY,0);map.put(ArmorItem.Type.BOOTS,0);map.put(ArmorItem.Type.LEGGINGS,0);map.put(ArmorItem.Type.HELMET,0);}), 0, SoundEvents.ARMOR_EQUIP_GENERIC, () -> Ingredient.EMPTY, List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MCPaintball.MOD_ID, "red"))),0,0));
    public static final Holder<ArmorMaterial> GREEN = MATERIALS.register("green",() -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class),map -> {map.put(ArmorItem.Type.BODY,0);map.put(ArmorItem.Type.BOOTS,0);map.put(ArmorItem.Type.LEGGINGS,0);map.put(ArmorItem.Type.HELMET,0);}), 0, SoundEvents.ARMOR_EQUIP_GENERIC, () -> Ingredient.EMPTY, List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MCPaintball.MOD_ID, "green"))),0,0));
    public static final Holder<ArmorMaterial> BLUE = MATERIALS.register("blue",() -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class),map -> {map.put(ArmorItem.Type.BODY,0);map.put(ArmorItem.Type.BOOTS,0);map.put(ArmorItem.Type.LEGGINGS,0);map.put(ArmorItem.Type.HELMET,0);}), 0, SoundEvents.ARMOR_EQUIP_GENERIC, () -> Ingredient.EMPTY, List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MCPaintball.MOD_ID, "blue"))),0,0));
    public static final Holder<ArmorMaterial> CYAN = MATERIALS.register("cyan",() -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class),map -> {map.put(ArmorItem.Type.BODY,0);map.put(ArmorItem.Type.BOOTS,0);map.put(ArmorItem.Type.LEGGINGS,0);map.put(ArmorItem.Type.HELMET,0);}), 0, SoundEvents.ARMOR_EQUIP_GENERIC, () -> Ingredient.EMPTY, List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MCPaintball.MOD_ID, "cyan"))),0,0));
    public static final Holder<ArmorMaterial> MAGENTA = MATERIALS.register("magenta",() -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class),map -> {map.put(ArmorItem.Type.BODY,0);map.put(ArmorItem.Type.BOOTS,0);map.put(ArmorItem.Type.LEGGINGS,0);map.put(ArmorItem.Type.HELMET,0);}), 0, SoundEvents.ARMOR_EQUIP_GENERIC, () -> Ingredient.EMPTY, List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MCPaintball.MOD_ID, "magenta"))),0,0));
    public static final Holder<ArmorMaterial> YELLOW = MATERIALS.register("yellow",() -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class),map -> {map.put(ArmorItem.Type.BODY,0);map.put(ArmorItem.Type.BOOTS,0);map.put(ArmorItem.Type.LEGGINGS,0);map.put(ArmorItem.Type.HELMET,0);}), 0, SoundEvents.ARMOR_EQUIP_GENERIC, () -> Ingredient.EMPTY, List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MCPaintball.MOD_ID, "yellow"))),0,0));
    public static final Holder<ArmorMaterial> LIME = MATERIALS.register("lime",() -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class),map -> {map.put(ArmorItem.Type.BODY,0);map.put(ArmorItem.Type.BOOTS,0);map.put(ArmorItem.Type.LEGGINGS,0);map.put(ArmorItem.Type.HELMET,0);}), 0, SoundEvents.ARMOR_EQUIP_GENERIC, () -> Ingredient.EMPTY, List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MCPaintball.MOD_ID, "lime"))),0,0));
    public static final Holder<ArmorMaterial> LIGHT_BLUE = MATERIALS.register("light_blue",() -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class),map -> {map.put(ArmorItem.Type.BODY,0);map.put(ArmorItem.Type.BOOTS,0);map.put(ArmorItem.Type.LEGGINGS,0);map.put(ArmorItem.Type.HELMET,0);}), 0, SoundEvents.ARMOR_EQUIP_GENERIC, () -> Ingredient.EMPTY, List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MCPaintball.MOD_ID, "light_blue"))),0,0));
    public static final Holder<ArmorMaterial> PINK = MATERIALS.register("pink",() -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class),map -> {map.put(ArmorItem.Type.BODY,0);map.put(ArmorItem.Type.BOOTS,0);map.put(ArmorItem.Type.LEGGINGS,0);map.put(ArmorItem.Type.HELMET,0);}), 0, SoundEvents.ARMOR_EQUIP_GENERIC, () -> Ingredient.EMPTY, List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MCPaintball.MOD_ID, "pink"))),0,0));
    public static final Holder<ArmorMaterial> WHITE = MATERIALS.register("white",() -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class),map -> {map.put(ArmorItem.Type.BODY,0);map.put(ArmorItem.Type.BOOTS,0);map.put(ArmorItem.Type.LEGGINGS,0);map.put(ArmorItem.Type.HELMET,0);}), 0, SoundEvents.ARMOR_EQUIP_GENERIC, () -> Ingredient.EMPTY, List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MCPaintball.MOD_ID, "white"))),0,0));
}
