package org.multicoder.mcpaintball.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;

import java.util.function.Supplier;

public class MCPaintballSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, MCPaintball.MODID);

    public static final Supplier<SoundEvent> SHOT = SOUNDS.register("shot",() -> SoundEvent.createFixedRangeEvent(Identifier.fromNamespaceAndPath(MCPaintball.MODID,"shot"),16f));
    public static final Supplier<SoundEvent> HIT = SOUNDS.register("hit",() -> SoundEvent.createFixedRangeEvent(Identifier.fromNamespaceAndPath(MCPaintball.MODID,"hit"),16f));
    public static final Supplier<SoundEvent> SPLAT = SOUNDS.register("splat",() -> SoundEvent.createFixedRangeEvent(Identifier.fromNamespaceAndPath(MCPaintball.MODID,"splat"),16f));
    public static final Supplier<SoundEvent> GRENADE = SOUNDS.register("grenade",() -> SoundEvent.createFixedRangeEvent(Identifier.fromNamespaceAndPath(MCPaintball.MODID,"grenade"),16f));

}
