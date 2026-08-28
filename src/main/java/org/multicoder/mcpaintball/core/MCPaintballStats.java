package org.multicoder.mcpaintball.core;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.stats.Stat;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;
import org.multicoder.mcpaintball.MCPaintball;

public class MCPaintballStats {

    public static final Stat<?> PLAYERS_HIT = register("players_hit");
    public static final Stat<?> HITS = register("hits");


    private static Stat<?> register(String name){
        Identifier id = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,name);
        Registry.register(BuiltInRegistries.CUSTOM_STAT,name,id);
        return Stats.CUSTOM.get(id, StatFormatter.DEFAULT);
    }

    public static void initialize(){
        MCPaintball.LOGGER.info("Initializing Stats");
    }

}
