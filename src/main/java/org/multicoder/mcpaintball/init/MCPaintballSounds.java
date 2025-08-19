package org.multicoder.mcpaintball.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;

@SuppressWarnings("unused")
public class MCPaintballSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, MCPaintball.MOD_ID);

    public static final DeferredHolder<SoundEvent,SoundEvent> SINGLE_SHOT = SOUNDS.register("single_shot",() -> SoundEvent.createFixedRangeEvent(ResourceLocation.fromNamespaceAndPath("mcpaintball","single_shot"),16F));
    public static final DeferredHolder<SoundEvent,SoundEvent> BURST_SHOT = SOUNDS.register("burst_shot",() -> SoundEvent.createFixedRangeEvent(ResourceLocation.fromNamespaceAndPath("mcpaintball","burst_shot"),16F));
    public static final DeferredHolder<SoundEvent,SoundEvent> SPLAT = SOUNDS.register("splat",() -> SoundEvent.createFixedRangeEvent(ResourceLocation.fromNamespaceAndPath("mcpaintball","splat"),16F));
    public static final DeferredHolder<SoundEvent,SoundEvent> HIT = SOUNDS.register("hit",() -> SoundEvent.createFixedRangeEvent(ResourceLocation.fromNamespaceAndPath("mcpaintball","hit"),16F));
    public static final DeferredHolder<SoundEvent,SoundEvent> BAZOOKA = SOUNDS.register("bazooka",() -> SoundEvent.createFixedRangeEvent(ResourceLocation.fromNamespaceAndPath("mcpaintball","bazooka"),16F));
    public static final DeferredHolder<SoundEvent,SoundEvent> C4_ADDED = SOUNDS.register("c4_added",() -> SoundEvent.createFixedRangeEvent(ResourceLocation.fromNamespaceAndPath("mcpaintball","c4_added"),16F));
    public static final DeferredHolder<SoundEvent,SoundEvent> C4_REMOVED = SOUNDS.register("c4_removed",() -> SoundEvent.createFixedRangeEvent(ResourceLocation.fromNamespaceAndPath("mcpaintball","c4_removed"),16F));
    public static final DeferredHolder<SoundEvent,SoundEvent> C4_DETONATED = SOUNDS.register("c4_detonated",() -> SoundEvent.createFixedRangeEvent(ResourceLocation.fromNamespaceAndPath("mcpaintball","c4_detonated"),16F));
    public static final DeferredHolder<SoundEvent,SoundEvent> GRENADE = SOUNDS.register("grenade",() -> SoundEvent.createFixedRangeEvent(ResourceLocation.fromNamespaceAndPath("mcpaintball","grenade"),16F));
}
