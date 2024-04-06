package org.multicoder.mcpaintball.common.init;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.entity.HeavyPaintballEntity;
import org.multicoder.mcpaintball.common.entity.PaintballEntity;
import org.multicoder.mcpaintball.common.entity.PaintballGrenade;

public class entityinit {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MCPaintball.MOD_ID);

    public static final RegistryObject<EntityType<PaintballEntity>> RED_PAINTBALL = ENTITY_TYPES.register("red_paintball", () -> EntityType.Builder.<PaintballEntity>of(PaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("red_paintball"));
    public static final RegistryObject<EntityType<PaintballEntity>> BLUE_PAINTBALL = ENTITY_TYPES.register("blue_paintball", () -> EntityType.Builder.<PaintballEntity>of(PaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("blue_paintball"));
    public static final RegistryObject<EntityType<PaintballEntity>> GREEN_PAINTBALL = ENTITY_TYPES.register("green_paintball", () -> EntityType.Builder.<PaintballEntity>of(PaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("green_paintball"));
    public static final RegistryObject<EntityType<PaintballEntity>> MAGENTA_PAINTBALL = ENTITY_TYPES.register("magenta_paintball", () -> EntityType.Builder.<PaintballEntity>of(PaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("magenta_paintball"));
    public static final RegistryObject<EntityType<PaintballEntity>> PINK_PAINTBALL = ENTITY_TYPES.register("pink_paintball", () -> EntityType.Builder.<PaintballEntity>of(PaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("pink_paintball"));
    public static final RegistryObject<EntityType<PaintballEntity>> PURPLE_PAINTBALL = ENTITY_TYPES.register("purple_paintball", () -> EntityType.Builder.<PaintballEntity>of(PaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("purple_paintball"));
    public static final RegistryObject<EntityType<PaintballEntity>> LIME_PAINTBALL = ENTITY_TYPES.register("lime_paintball", () -> EntityType.Builder.<PaintballEntity>of(PaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("lime_paintball"));
    public static final RegistryObject<EntityType<PaintballEntity>> LIGHT_BLUE_PAINTBALL = ENTITY_TYPES.register("light_blue_paintball", () -> EntityType.Builder.<PaintballEntity>of(PaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("light_blue_paintball"));
    public static final RegistryObject<EntityType<PaintballEntity>> CYAN_PAINTBALL = ENTITY_TYPES.register("cyan_paintball", () -> EntityType.Builder.<PaintballEntity>of(PaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("cyan_paintball"));

    public static final RegistryObject<EntityType<HeavyPaintballEntity>> RED_PAINTBALL_HEAVY = ENTITY_TYPES.register("red_paintball_heavy", () -> EntityType.Builder.<HeavyPaintballEntity>of(HeavyPaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("red_paintball_heavy"));
    public static final RegistryObject<EntityType<HeavyPaintballEntity>> BLUE_PAINTBALL_HEAVY = ENTITY_TYPES.register("blue_paintball_heavy", () -> EntityType.Builder.<HeavyPaintballEntity>of(HeavyPaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("blue_paintball_heavy"));
    public static final RegistryObject<EntityType<HeavyPaintballEntity>> GREEN_PAINTBALL_HEAVY = ENTITY_TYPES.register("green_paintball_heavy", () -> EntityType.Builder.<HeavyPaintballEntity>of(HeavyPaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("green_paintball_heavy"));
    public static final RegistryObject<EntityType<HeavyPaintballEntity>> MAGENTA_PAINTBALL_HEAVY = ENTITY_TYPES.register("magenta_paintball_heavy", () -> EntityType.Builder.<HeavyPaintballEntity>of(HeavyPaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("magenta_paintball_heavy"));
    public static final RegistryObject<EntityType<HeavyPaintballEntity>> PINK_PAINTBALL_HEAVY = ENTITY_TYPES.register("pink_paintball_heavy", () -> EntityType.Builder.<HeavyPaintballEntity>of(HeavyPaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("pink_paintball_heavy"));
    public static final RegistryObject<EntityType<HeavyPaintballEntity>> PURPLE_PAINTBALL_HEAVY = ENTITY_TYPES.register("purple_paintball_heavy", () -> EntityType.Builder.<HeavyPaintballEntity>of(HeavyPaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("purple_paintball_heavy"));
    public static final RegistryObject<EntityType<HeavyPaintballEntity>> LIME_PAINTBALL_HEAVY = ENTITY_TYPES.register("lime_paintball_heavy", () -> EntityType.Builder.<HeavyPaintballEntity>of(HeavyPaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("lime_paintball_heavy"));
    public static final RegistryObject<EntityType<HeavyPaintballEntity>> LIGHT_BLUE_PAINTBALL_HEAVY = ENTITY_TYPES.register("light_blue_paintball_heavy", () -> EntityType.Builder.<HeavyPaintballEntity>of(HeavyPaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("light_blue_paintball_heavy"));
    public static final RegistryObject<EntityType<HeavyPaintballEntity>> CYAN_PAINTBALL_HEAVY = ENTITY_TYPES.register("cyan_paintball_heavy", () -> EntityType.Builder.<HeavyPaintballEntity>of(HeavyPaintballEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build("cyan_paintball_heavy"));

    public static final RegistryObject<EntityType<PaintballGrenade>> RED_GRENADE = ENTITY_TYPES.register("red_grenade", () -> EntityType.Builder.<PaintballGrenade>of(PaintballGrenade::new, MobCategory.MISC).sized(1f, 1f).build("red_grenade"));
    public static final RegistryObject<EntityType<PaintballGrenade>> GREEN_GRENADE = ENTITY_TYPES.register("green_grenade", () -> EntityType.Builder.<PaintballGrenade>of(PaintballGrenade::new, MobCategory.MISC).sized(1f, 1f).build("green_grenade"));
    public static final RegistryObject<EntityType<PaintballGrenade>> BLUE_GRENADE = ENTITY_TYPES.register("blue_grenade", () -> EntityType.Builder.<PaintballGrenade>of(PaintballGrenade::new, MobCategory.MISC).sized(1f, 1f).build("blue_grenade"));
    public static final RegistryObject<EntityType<PaintballGrenade>> MAGENTA_GRENADE = ENTITY_TYPES.register("magenta_grenade", () -> EntityType.Builder.<PaintballGrenade>of(PaintballGrenade::new, MobCategory.MISC).sized(1f, 1f).build("magenta_grenade"));
    public static final RegistryObject<EntityType<PaintballGrenade>> PINK_GRENADE = ENTITY_TYPES.register("pink_grenade", () -> EntityType.Builder.<PaintballGrenade>of(PaintballGrenade::new, MobCategory.MISC).sized(1f, 1f).build("pink_grenade"));
    public static final RegistryObject<EntityType<PaintballGrenade>> PURPLE_GRENADE = ENTITY_TYPES.register("purple_grenade", () -> EntityType.Builder.<PaintballGrenade>of(PaintballGrenade::new, MobCategory.MISC).sized(1f, 1f).build("purple_grenade"));
    public static final RegistryObject<EntityType<PaintballGrenade>> LIME_GRENADE = ENTITY_TYPES.register("lime_grenade", () -> EntityType.Builder.<PaintballGrenade>of(PaintballGrenade::new, MobCategory.MISC).sized(1f, 1f).build("lime_grenade"));
    public static final RegistryObject<EntityType<PaintballGrenade>> LIGHT_BLUE_GRENADE = ENTITY_TYPES.register("light_blue_grenade", () -> EntityType.Builder.<PaintballGrenade>of(PaintballGrenade::new, MobCategory.MISC).sized(1f, 1f).build("light_blue_grenade"));
    public static final RegistryObject<EntityType<PaintballGrenade>> CYAN_GRENADE = ENTITY_TYPES.register("cyan_grenade", () -> EntityType.Builder.<PaintballGrenade>of(PaintballGrenade::new, MobCategory.MISC).sized(1f, 1f).build("cyan_grenade"));


}
