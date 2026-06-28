package org.multicoder.mcpaintball.core;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import org.multicoder.mcpaintball.MCPaintball;

public class MCPaintballSounds {

    public static final SoundEvent SHOT = register("shot");
    public static final SoundEvent HIT = register("hit");
    public static final SoundEvent SPLAT = register("splat");
    public static final SoundEvent GRENADE = register("grenade");

    public static void Initialize() {}
    public static SoundEvent register(String name){
        return Registry.register(BuiltInRegistries.SOUND_EVENT, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,name),SoundEvent.createFixedRangeEvent(Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,name),16));
    }
}
