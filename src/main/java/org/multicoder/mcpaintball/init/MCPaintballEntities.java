package org.multicoder.mcpaintball.init;

import net.minecraft.world.entity.*;
import net.neoforged.neoforge.registries.*;
import org.multicoder.mcpaintball.entity.grenade.*;
import org.multicoder.mcpaintball.entity.paintball.PaintballEntity;

import static net.minecraft.core.registries.Registries.ENTITY_TYPE;
import static org.multicoder.mcpaintball.MCPaintball.MOD_ID;

public class MCPaintballEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ENTITY_TYPE, MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<?>> RED_PAINTBALL = ENTITIES.register("red_paintball", () -> EntityType.Builder.of(PaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("red_paintball"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> GREEN_PAINTBALL = ENTITIES.register("green_paintball", () -> EntityType.Builder.of(PaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("green_paintball"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> BLUE_PAINTBALL = ENTITIES.register("blue_paintball", () -> EntityType.Builder.of(PaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("blue_paintball"));

    public static final DeferredHolder<EntityType<?>, EntityType<?>> RED_GRENADE = ENTITIES.register("red_grenade", () -> EntityType.Builder.of(RedPaintballGrenadeEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("red_grenade"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> GREEN_GRENADE = ENTITIES.register("green_grenade", () -> EntityType.Builder.of(GreenPaintballGrenadeEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("green_grenade"));
    public static final DeferredHolder<EntityType<?>, EntityType<?>> BLUE_GRENADE = ENTITIES.register("blue_grenade", () -> EntityType.Builder.of(BluePaintballGrenadeEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("blue_grenade"));

}
