package org.multicoder.mcpaintball.common.utility;

import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;

import java.util.EnumMap;
import java.util.List;

public class PaintballArmorMaterial
{
    public static final DeferredRegister<ArmorMaterial> MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, MCPaintball.MOD_ID);

    public static final DeferredHolder<?,?> RED_ARMOR = MATERIALS.register("red",() -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), p_323384_ -> {p_323384_.put(ArmorItem.Type.BOOTS, 0);p_323384_.put(ArmorItem.Type.LEGGINGS, 0);p_323384_.put(ArmorItem.Type.CHESTPLATE, 0);p_323384_.put(ArmorItem.Type.HELMET, 0);p_323384_.put(ArmorItem.Type.BODY, 0);}),
             0,
             SoundEvents.ARMOR_EQUIP_GENERIC,
             () -> Ingredient.EMPTY,
             List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath("mcpaintball","red"), "", false)), 0.0f, 0.0f));

    public static final DeferredHolder<?,?> GREEN_ARMOR = MATERIALS.register("green",() -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), p_323384_ -> {p_323384_.put(ArmorItem.Type.BOOTS, 0);p_323384_.put(ArmorItem.Type.LEGGINGS, 0);p_323384_.put(ArmorItem.Type.CHESTPLATE, 0);p_323384_.put(ArmorItem.Type.HELMET, 0);p_323384_.put(ArmorItem.Type.BODY, 0);}),
            0,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            () -> Ingredient.EMPTY,
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath("mcpaintball","green"), "", false)), 0.0f, 0.0f));

    public static final DeferredHolder<?,?> BLUE_ARMOR = MATERIALS.register("blue",() -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), p_323384_ -> {p_323384_.put(ArmorItem.Type.BOOTS, 0);p_323384_.put(ArmorItem.Type.LEGGINGS, 0);p_323384_.put(ArmorItem.Type.CHESTPLATE, 0);p_323384_.put(ArmorItem.Type.HELMET, 0);p_323384_.put(ArmorItem.Type.BODY, 0);}),
            0,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            () -> Ingredient.EMPTY,
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath("mcpaintball","blue"), "", false)), 0.0f, 0.0f));

}
