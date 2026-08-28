package org.multicoder.mcpaintball.core;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;

public class MCPaintballStats {
    public static final DeferredRegister<Identifier> STATS = DeferredRegister.create(BuiltInRegistries.CUSTOM_STAT, MCPaintball.MODID);

    public static final DeferredHolder<Identifier,Identifier> HITS = STATS.register("hits",() -> Identifier.fromNamespaceAndPath(MCPaintball.MODID,"hits"));
    public static final DeferredHolder<Identifier,Identifier> PLAYERS_HITS = STATS.register("players_hit",() -> Identifier.fromNamespaceAndPath(MCPaintball.MODID,"player_hit"));
}
