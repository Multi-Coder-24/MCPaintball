package org.multicoder.mcpaintball.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.entity.*;

public class MCPaintballEntities {
    public static final DeferredRegister.Entities ENTITIES = DeferredRegister.createEntities(MCPaintball.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<RedPaintballEntity>> RED_PAINTBALL = ENTITIES.register("red_paintball",() -> EntityType.Builder.<RedPaintballEntity>of(RedPaintballEntity::new,MobCategory.MISC).sized(0.5f,0.5f).build(ResourceKey.create(Registries.ENTITY_TYPE,Identifier.fromNamespaceAndPath(MCPaintball.MODID,"red_paintball"))));
    public static final DeferredHolder<EntityType<?>, EntityType<GreenPaintballEntity>> GREEN_PAINTBALL = ENTITIES.register("green_paintball",() -> EntityType.Builder.<GreenPaintballEntity>of(GreenPaintballEntity::new,MobCategory.MISC).sized(0.5f,0.5f).build(ResourceKey.create(Registries.ENTITY_TYPE,Identifier.fromNamespaceAndPath(MCPaintball.MODID,"green_paintball"))));
    public static final DeferredHolder<EntityType<?>, EntityType<BluePaintballEntity>> BLUE_PAINTBALL = ENTITIES.register("blue_paintball",() -> EntityType.Builder.<BluePaintballEntity>of(BluePaintballEntity::new,MobCategory.MISC).sized(0.5f,0.5f).build(ResourceKey.create(Registries.ENTITY_TYPE,Identifier.fromNamespaceAndPath(MCPaintball.MODID,"blue_paintball"))));

    public static final DeferredHolder<EntityType<?>, EntityType<RedPaintGrenadeEntity>> RED_PAINT_GRENADE = ENTITIES.register("red_grenade",() -> EntityType.Builder.<RedPaintGrenadeEntity>of(RedPaintGrenadeEntity::new,MobCategory.MISC).build(ResourceKey.create(Registries.ENTITY_TYPE,Identifier.fromNamespaceAndPath(MCPaintball.MODID,"red_grenade"))));
    public static final DeferredHolder<EntityType<?>, EntityType<GreenPaintGrenadeEntity>> GREEN_PAINT_GRENADE = ENTITIES.register("green_grenade",() -> EntityType.Builder.<GreenPaintGrenadeEntity>of(GreenPaintGrenadeEntity::new,MobCategory.MISC).build(ResourceKey.create(Registries.ENTITY_TYPE,Identifier.fromNamespaceAndPath(MCPaintball.MODID,"green_grenade"))));
    public static final DeferredHolder<EntityType<?>, EntityType<BluePaintGrenadeEntity>> BLUE_PAINT_GRENADE = ENTITIES.register("blue_grenade",() -> EntityType.Builder.<BluePaintGrenadeEntity>of(BluePaintGrenadeEntity::new,MobCategory.MISC).build(ResourceKey.create(Registries.ENTITY_TYPE,Identifier.fromNamespaceAndPath(MCPaintball.MODID,"blue_grenade"))));

    public static final DeferredHolder<EntityType<?>, EntityType<SmokeGrenadeEntity>> SMOKE_GRENADE = ENTITIES.register("smoke_grenade",() -> EntityType.Builder.<SmokeGrenadeEntity>of(SmokeGrenadeEntity::new,MobCategory.MISC).build(ResourceKey.create(Registries.ENTITY_TYPE,Identifier.fromNamespaceAndPath(MCPaintball.MODID,"smoke_grenade"))));
    public static final DeferredHolder<EntityType<?>, EntityType<EMPGrenadeEntity>> EMP_GRENADE = ENTITIES.register("emp_grenade",() -> EntityType.Builder.<EMPGrenadeEntity>of(EMPGrenadeEntity::new,MobCategory.MISC).build(ResourceKey.create(Registries.ENTITY_TYPE,Identifier.fromNamespaceAndPath(MCPaintball.MODID,"emp_grenade"))));
}
