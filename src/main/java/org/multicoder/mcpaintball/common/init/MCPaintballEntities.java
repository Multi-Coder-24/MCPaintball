package org.multicoder.mcpaintball.common.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.entity.grenade.BluePaintballGrenadeEntity;
import org.multicoder.mcpaintball.common.entity.grenade.GrayPaintballGrenadeEntity;
import org.multicoder.mcpaintball.common.entity.grenade.GreenPaintballGrenadeEntity;
import org.multicoder.mcpaintball.common.entity.grenade.RedPaintballGrenadeEntity;
import org.multicoder.mcpaintball.common.entity.paintball.GrayHeavyPaintballEntity;
import org.multicoder.mcpaintball.common.entity.paintball.GrayPaintballEntity;
import org.multicoder.mcpaintball.common.entity.paintball.HeavyPaintballEntity;
import org.multicoder.mcpaintball.common.entity.paintball.PaintballEntity;

public class MCPaintballEntities {
    //  Deferred Register
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, MCPaintball.MOD_ID);

    //  Paintball Entity
    public static final DeferredHolder<EntityType<?>, EntityType<?>> RED_PAINTBALL = ENTITIES.register("red_paintball", () -> EntityType.Builder.of(PaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("red_paintball"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> GREEN_PAINTBALL = ENTITIES.register("green_paintball", () -> EntityType.Builder.of(PaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("green_paintball"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> BLUE_PAINTBALL = ENTITIES.register("blue_paintball", () -> EntityType.Builder.of(PaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("blue_paintball"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> SOLO_PAINTBALL = ENTITIES.register("gray_paintball", () -> EntityType.Builder.of(GrayPaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("gray_paintball"));

    //  Heavy Paintball Entity
    public static final DeferredHolder<EntityType<?>, EntityType<?>> RED_HEAVY_PAINTBALL = ENTITIES.register("red_heavy_paintball", () -> EntityType.Builder.of(HeavyPaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("red_heavy_paintball"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> GREEN_HEAVY_PAINTBALL = ENTITIES.register("green_heavy_paintball", () -> EntityType.Builder.of(HeavyPaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("green_heavy_paintball"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> BLUE_HEAVY_PAINTBALL = ENTITIES.register("blue_heavy_paintball", () -> EntityType.Builder.of(HeavyPaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("blue_heavy_paintball"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> SOLO_HEAVY_PAINTBALL = ENTITIES.register("gray_heavy_paintball", () -> EntityType.Builder.of(GrayHeavyPaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("gray_heavy_paintball"));

    public static final DeferredHolder<EntityType<?>, EntityType<?>> RED_GRENADE = ENTITIES.register("red_grenade", () -> EntityType.Builder.of(RedPaintballGrenadeEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("red_grenade"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> GREEN_GRENADE = ENTITIES.register("green_grenade", () -> EntityType.Builder.of(GreenPaintballGrenadeEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("green_grenade"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> BLUE_GRENADE = ENTITIES.register("blue_grenade", () -> EntityType.Builder.of(BluePaintballGrenadeEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("blue_grenade"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> SOLO_GRENADE = ENTITIES.register("gray_grenade", () -> EntityType.Builder.of(GrayPaintballGrenadeEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("gray_grenade"));

}
