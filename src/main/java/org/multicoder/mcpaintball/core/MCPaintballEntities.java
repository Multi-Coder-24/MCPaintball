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
    public static final EntityType<PaintballEntity> RED_PAINTBALL = register("red_paintball", EntityType.Builder.<PaintballEntity>of(PaintballEntity::new, MobCategory.MISC).sized(0.5f,0.5f));
    public static final EntityType<PaintballEntity> GREEN_PAINTBALL = register("green_paintball", EntityType.Builder.<PaintballEntity>of(PaintballEntity::new, MobCategory.MISC).sized(0.5f,0.5f));
    public static final EntityType<PaintballEntity> BLUE_PAINTBALL = register("blue_paintball", EntityType.Builder.<PaintballEntity>of(PaintballEntity::new, MobCategory.MISC).sized(0.5f,0.5f));
    public static final EntityType<PaintballEntity> YELLOW_PAINTBALL = register("yellow_paintball", EntityType.Builder.<PaintballEntity>of(PaintballEntity::new, MobCategory.MISC).sized(0.5f,0.5f));
    public static final EntityType<PaintballEntity> PINK_PAINTBALL = register("pink_paintball", EntityType.Builder.<PaintballEntity>of(PaintballEntity::new, MobCategory.MISC).sized(0.5f,0.5f));
    public static final EntityType<PaintballEntity> ORANGE_PAINTBALL = register("orange_paintball", EntityType.Builder.<PaintballEntity>of(PaintballEntity::new, MobCategory.MISC).sized(0.5f,0.5f));

    public static final EntityType<PaintGrenadeEntity> RED_PAINT_GRENADE = register("red_paint_grenade",EntityType.Builder.of(PaintGrenadeEntity::new,MobCategory.MISC));
    public static final EntityType<PaintGrenadeEntity> GREEN_PAINT_GRENADE = register("green_paint_grenade",EntityType.Builder.of(PaintGrenadeEntity::new,MobCategory.MISC));
    public static final EntityType<PaintGrenadeEntity> BLUE_PAINT_GRENADE = register("blue_paint_grenade",EntityType.Builder.of(PaintGrenadeEntity::new,MobCategory.MISC));
    public static final EntityType<PaintGrenadeEntity> YELLOW_PAINT_GRENADE = register("yellow_paint_grenade",EntityType.Builder.of(PaintGrenadeEntity::new,MobCategory.MISC));
    public static final EntityType<PaintGrenadeEntity> PINK_PAINT_GRENADE = register("pink_paint_grenade",EntityType.Builder.of(PaintGrenadeEntity::new,MobCategory.MISC));
    public static final EntityType<PaintGrenadeEntity> ORANGE_PAINT_GRENADE = register("orange_paint_grenade",EntityType.Builder.of(PaintGrenadeEntity::new,MobCategory.MISC));

    public static final EntityType<SmokeGrenadeEntity> SMOKE_GRENADE = register("smoke_grenade",EntityType.Builder.of(SmokeGrenadeEntity::new,MobCategory.MISC));
    public static final EntityType<EMPGrenadeEntity> EMP_GRENADE = register("emp_grenade",EntityType.Builder.of(EMPGrenadeEntity::new,MobCategory.MISC));
    public static final EntityType<SightGrenadeEntity> SIGHT_GRENADE = register("sight_grenade",EntityType.Builder.of(SightGrenadeEntity::new,MobCategory.MISC));

    public static void initialize() {
        MCPaintball.LOGGER.debug("Initializing Entities");
    }
    private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID, name));
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, builder.build(key));
    }
}
