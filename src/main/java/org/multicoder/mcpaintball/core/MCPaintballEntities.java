package org.multicoder.mcpaintball.core;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.entity.*;

public class MCPaintballEntities {
    public static final EntityType<RedPaintballEntity> RED_PAINTBALL = register("red_paintball", EntityType.Builder.of(RedPaintballEntity::new, MobCategory.MISC).sized(0.5f,0.5f));
    public static final EntityType<GreenPaintballEntity> GREEN_PAINTBALL = register("green_paintball", EntityType.Builder.of(GreenPaintballEntity::new, MobCategory.MISC).sized(0.5f,0.5f));
    public static final EntityType<BluePaintballEntity> BLUE_PAINTBALL = register("blue_paintball", EntityType.Builder.of(BluePaintballEntity::new, MobCategory.MISC).sized(0.5f,0.5f));

    public static final EntityType<RedPaintGrenadeEntity> RED_PAINT_GRENADE = register("red_paint_grenade",EntityType.Builder.of(RedPaintGrenadeEntity::new,MobCategory.MISC));
    public static final EntityType<GreenPaintGrenadeEntity> GREEN_PAINT_GRENADE = register("green_paint_grenade",EntityType.Builder.of(GreenPaintGrenadeEntity::new,MobCategory.MISC));
    public static final EntityType<BluePaintGrenadeEntity> BLUE_PAINT_GRENADE = register("blue_paint_grenade",EntityType.Builder.of(BluePaintGrenadeEntity::new,MobCategory.MISC));

    public static void Initialize() {
        MCPaintball.LOGGER.info("Initializing Entities");
    }
    private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID, name));
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, builder.build(key));
    }
}
