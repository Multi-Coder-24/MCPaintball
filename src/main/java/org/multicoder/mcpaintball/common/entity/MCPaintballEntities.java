package org.multicoder.mcpaintball.common.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.entity.paintball.HeavyPaintballEntity;
import org.multicoder.mcpaintball.common.entity.paintball.PaintballEntity;
import org.multicoder.mcpaintball.common.entity.throwable.BlindnessGrenadeEntity;
import org.multicoder.mcpaintball.common.entity.throwable.GrenadeEntity;
import org.multicoder.mcpaintball.common.entity.throwable.SlownessGrenadeEntity;
import org.multicoder.mcpaintball.common.entity.throwable.WeaknessGrenadeEntity;

public class MCPaintballEntities {
    //  Deferred Register
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, MCPaintball.MOD_ID);

    //  Paintball Entity
    public static final DeferredHolder<EntityType<?>, EntityType<?>> RED_PAINTBALL = ENTITIES.register("red_paintball", () -> EntityType.Builder.of(PaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("red_paintball"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> GREEN_PAINTBALL = ENTITIES.register("green_paintball", () -> EntityType.Builder.of(PaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("green_paintball"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> BLUE_PAINTBALL = ENTITIES.register("blue_paintball", () -> EntityType.Builder.of(PaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("blue_paintball"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> CYAN_PAINTBALL = ENTITIES.register("cyan_paintball", () -> EntityType.Builder.of(PaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("cyan_paintball"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> MAGENTA_PAINTBALL = ENTITIES.register("magenta_paintball", () -> EntityType.Builder.of(PaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("magenta_paintball"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> YELLOW_PAINTBALL = ENTITIES.register("yellow_paintball", () -> EntityType.Builder.of(PaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("yellow_paintball"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> LIME_PAINTBALL = ENTITIES.register("lime_paintball", () -> EntityType.Builder.of(PaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("lime_paintball"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> LIGHT_BLUE_PAINTBALL = ENTITIES.register("light_blue_paintball", () -> EntityType.Builder.of(PaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("light_blue_paintball"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> PINK_PAINTBALL = ENTITIES.register("pink_paintball", () -> EntityType.Builder.of(PaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("pink_paintball"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> PURPLE_PAINTBALL = ENTITIES.register("purple_paintball", () -> EntityType.Builder.of(PaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("purple_paintball"));

    //  Heavy Paintball Entity
    public static final DeferredHolder<EntityType<?>, EntityType<?>> RED_HEAVY_PAINTBALL = ENTITIES.register("red_heavy_paintball", () -> EntityType.Builder.of(HeavyPaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("red_heavy_paintball"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> GREEN_HEAVY_PAINTBALL = ENTITIES.register("green_heavy_paintball", () -> EntityType.Builder.of(HeavyPaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("green_heavy_paintball"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> BLUE_HEAVY_PAINTBALL = ENTITIES.register("blue_heavy_paintball", () -> EntityType.Builder.of(HeavyPaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("blue_heavy_paintball"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> CYAN_HEAVY_PAINTBALL = ENTITIES.register("cyan_heavy_paintball", () -> EntityType.Builder.of(HeavyPaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("cyan_heavy_paintball"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> MAGENTA_HEAVY_PAINTBALL = ENTITIES.register("magenta_heavy_paintball", () -> EntityType.Builder.of(HeavyPaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("magenta_heavy_paintball"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> YELLOW_HEAVY_PAINTBALL = ENTITIES.register("yellow_heavy_paintball", () -> EntityType.Builder.of(HeavyPaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("yellow_heavy_paintball"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> LIME_HEAVY_PAINTBALL = ENTITIES.register("lime_heavy_paintball", () -> EntityType.Builder.of(HeavyPaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("lime_heavy_paintball"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> LIGHT_BLUE_HEAVY_PAINTBALL = ENTITIES.register("light_blue_heavy_paintball", () -> EntityType.Builder.of(HeavyPaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("light_blue_heavy_paintball"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> PINK_HEAVY_PAINTBALL = ENTITIES.register("pink_heavy_paintball", () -> EntityType.Builder.of(HeavyPaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("pink_heavy_paintball"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> PURPLE_HEAVY_PAINTBALL = ENTITIES.register("purple_heavy_paintball", () -> EntityType.Builder.of(HeavyPaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("purple_heavy_paintball"));

    public static final DeferredHolder<EntityType<?>, EntityType<?>> RED_GRENADE = ENTITIES.register("red_grenade", () -> EntityType.Builder.of(GrenadeEntity::new, MobCategory.MISC).build("red_grenade"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> GREEN_GRENADE = ENTITIES.register("green_grenade", () -> EntityType.Builder.of(GrenadeEntity::new, MobCategory.MISC).build("green_grenade"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> BLUE_GRENADE = ENTITIES.register("blue_grenade", () -> EntityType.Builder.of(GrenadeEntity::new, MobCategory.MISC).build("blue_grenade"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> CYAN_GRENADE = ENTITIES.register("cyan_grenade", () -> EntityType.Builder.of(GrenadeEntity::new, MobCategory.MISC).build("cyan_grenade"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> MAGENTA_GRENADE = ENTITIES.register("magenta_grenade", () -> EntityType.Builder.of(GrenadeEntity::new, MobCategory.MISC).build("magenta_grenade"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> YELLOW_GRENADE = ENTITIES.register("yellow_grenade", () -> EntityType.Builder.of(GrenadeEntity::new, MobCategory.MISC).build("yellow_grenade"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> LIME_GRENADE = ENTITIES.register("lime_grenade", () -> EntityType.Builder.of(GrenadeEntity::new, MobCategory.MISC).build("lime_grenade"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> LIGHT_BLUE_GRENADE = ENTITIES.register("light_blue_grenade", () -> EntityType.Builder.of(GrenadeEntity::new, MobCategory.MISC).build("light_blue_grenade"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> PINK_GRENADE = ENTITIES.register("pink_grenade", () -> EntityType.Builder.of(GrenadeEntity::new, MobCategory.MISC).build("pink_grenade"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> PURPLE_GRENADE = ENTITIES.register("purple_grenade", () -> EntityType.Builder.of(GrenadeEntity::new, MobCategory.MISC).build("purple_grenade"));

    public static final DeferredHolder<EntityType<?>, EntityType<?>> SLOWNESS_GRENADE = ENTITIES.register("slow_grenade", () -> EntityType.Builder.of(SlownessGrenadeEntity::new, MobCategory.MISC).build("slow_grenade"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> WEAKNESS_GRENADE = ENTITIES.register("weak_grenade", () -> EntityType.Builder.of(WeaknessGrenadeEntity::new, MobCategory.MISC).build("weak_grenade"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> BLINDNESS_GRENADE = ENTITIES.register("blind_grenade", () -> EntityType.Builder.of(BlindnessGrenadeEntity::new, MobCategory.MISC).build("blind_grenade"));
}