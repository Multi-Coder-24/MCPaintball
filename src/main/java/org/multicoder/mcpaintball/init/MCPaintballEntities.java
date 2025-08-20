package org.multicoder.mcpaintball.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.entity.*;

public class MCPaintballEntities {
    public static final DeferredRegister<EntityType<?>> PAINTBALLS = DeferredRegister.create(Registries.ENTITY_TYPE, MCPaintball.MOD_ID);

    public static final DeferredHolder<EntityType<?>,EntityType<?>> RED_PAINTBALL = PAINTBALLS.register("red_paintball",() -> EntityType.Builder.of(PaintballEntity::new,MobCategory.MISC).sized(0.5F,0.5F).build("red_paintball"));
    public static final DeferredHolder<EntityType<?>,EntityType<?>> GREEN_PAINTBALL = PAINTBALLS.register("green_paintball",() -> EntityType.Builder.of(PaintballEntity::new,MobCategory.MISC).sized(0.5F,0.5F).build("green_paintball"));
    public static final DeferredHolder<EntityType<?>,EntityType<?>> BLUE_PAINTBALL = PAINTBALLS.register("blue_paintball",() -> EntityType.Builder.of(PaintballEntity::new,MobCategory.MISC).sized(0.5F,0.5F).build("blue_paintball"));
    public static final DeferredHolder<EntityType<?>,EntityType<?>> CYAN_PAINTBALL = PAINTBALLS.register("cyan_paintball",() -> EntityType.Builder.of(PaintballEntity::new,MobCategory.MISC).sized(0.5F,0.5F).build("cyan_paintball"));
    public static final DeferredHolder<EntityType<?>,EntityType<?>> MAGENTA_PAINTBALL = PAINTBALLS.register("magenta_paintball",() -> EntityType.Builder.of(PaintballEntity::new,MobCategory.MISC).sized(0.5F,0.5F).build("magenta_paintball"));
    public static final DeferredHolder<EntityType<?>,EntityType<?>> YELLOW_PAINTBALL = PAINTBALLS.register("yellow_paintball",() -> EntityType.Builder.of(PaintballEntity::new,MobCategory.MISC).sized(0.5F,0.5F).build("yellow_paintball"));
    public static final DeferredHolder<EntityType<?>,EntityType<?>> LIME_PAINTBALL = PAINTBALLS.register("lime_paintball",() -> EntityType.Builder.of(PaintballEntity::new,MobCategory.MISC).sized(0.5F,0.5F).build("lime_paintball"));
    public static final DeferredHolder<EntityType<?>,EntityType<?>> LIGHT_BLUE_PAINTBALL = PAINTBALLS.register("light_blue_paintball",() -> EntityType.Builder.of(PaintballEntity::new,MobCategory.MISC).sized(0.5F,0.5F).build("light_blue_paintball"));
    public static final DeferredHolder<EntityType<?>,EntityType<?>> PINK_PAINTBALL = PAINTBALLS.register("pink_paintball",() -> EntityType.Builder.of(PaintballEntity::new,MobCategory.MISC).sized(0.5F,0.5F).build("pink_paintball"));
    public static final DeferredHolder<EntityType<?>,EntityType<?>> WHITE_PAINTBALL = PAINTBALLS.register("white_paintball",() -> EntityType.Builder.of(PaintballEntity::new,MobCategory.MISC).sized(0.5F,0.5F).build("white_paintball"));
}
