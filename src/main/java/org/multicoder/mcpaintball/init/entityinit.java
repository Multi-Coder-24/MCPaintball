package org.multicoder.mcpaintball.init;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.entity.base.*;
import org.multicoder.mcpaintball.entity.grenade.*;
import org.multicoder.mcpaintball.entity.heavy.*;

public class entityinit
{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, MCPaintball.MODID);

    public static final RegistryObject<EntityType<?>> RED_PAINTBALL = ENTITY_TYPES.register("red_paintball",() -> EntityType.Builder.of(RedPaintballArrowEntity::new, MobCategory.MISC).sized(0.5f,0.5f).build("red_paintball"));
    public static final RegistryObject<EntityType<?>> BLUE_PAINTBALL = ENTITY_TYPES.register("blue_paintball",() -> EntityType.Builder.of(BluePaintballArrowEntity::new, MobCategory.MISC).sized(0.5f,0.5f).build("blue_paintball"));
    public static final RegistryObject<EntityType<?>> GREEN_PAINTBALL = ENTITY_TYPES.register("green_paintball",() -> EntityType.Builder.of(GreenPaintballArrowEntity::new, MobCategory.MISC).sized(0.5f,0.5f).build("green_paintball"));
    public static final RegistryObject<EntityType<?>> MAGENTA_PAINTBALL = ENTITY_TYPES.register("magenta_paintball",() -> EntityType.Builder.of(MagentaPaintballArrowEntity::new, MobCategory.MISC).sized(0.5f,0.5f).build("magenta_paintball"));
    public static final RegistryObject<EntityType<?>> PINK_PAINTBALL = ENTITY_TYPES.register("pink_paintball",() -> EntityType.Builder.of(PinkPaintballArrowEntity::new, MobCategory.MISC).sized(0.5f,0.5f).build("pink_paintball"));
        public static final RegistryObject<EntityType<?>> PURPLE_PAINTBALL = ENTITY_TYPES.register("purple_paintball",() -> EntityType.Builder.of(PurplePaintballArrowEntity::new, MobCategory.MISC).sized(0.5f,0.5f).build("purple_paintball"));
    public static final RegistryObject<EntityType<?>> LIME_PAINTBALL = ENTITY_TYPES.register("lime_paintball",() -> EntityType.Builder.of(LimePaintballArrowEntity::new, MobCategory.MISC).sized(0.5f,0.5f).build("lime_paintball"));
    public static final RegistryObject<EntityType<?>> LIGHT_BLUE_PAINTBALL = ENTITY_TYPES.register("light_blue_paintball",() -> EntityType.Builder.of(LightBluePaintballArrowEntity::new, MobCategory.MISC).sized(0.5f,0.5f).build("light_blue_paintball"));

    public static final RegistryObject<EntityType<?>> RED_PAINTBALL_HEAVY = ENTITY_TYPES.register("red_paintball_heavy",() -> EntityType.Builder.of(RedPaintballHeavyArrowEntity::new, MobCategory.MISC).sized(0.5f,0.5f).build("red_paintball_heavy"));
    public static final RegistryObject<EntityType<?>> BLUE_PAINTBALL_HEAVY = ENTITY_TYPES.register("blue_paintball_heavy",() -> EntityType.Builder.of(BluePaintballHeavyArrowEntity::new, MobCategory.MISC).sized(0.5f,0.5f).build("blue_paintball_heavy"));
    public static final RegistryObject<EntityType<?>> GREEN_PAINTBALL_HEAVY = ENTITY_TYPES.register("green_paintball_heavy",() -> EntityType.Builder.of(GreenPaintballHeavyArrowEntity::new, MobCategory.MISC).sized(0.5f,0.5f).build("green_paintball_heavy"));
    public static final RegistryObject<EntityType<?>> MAGENTA_PAINTBALL_HEAVY = ENTITY_TYPES.register("magenta_paintball_heavy",() -> EntityType.Builder.of(MagentaPaintballHeavyArrowEntity::new, MobCategory.MISC).sized(0.5f,0.5f).build("magenta_paintball_heavy"));
    public static final RegistryObject<EntityType<?>> PINK_PAINTBALL_HEAVY = ENTITY_TYPES.register("pink_paintball_heavy",() -> EntityType.Builder.of(PinkPaintballHeavyArrowEntity::new, MobCategory.MISC).sized(0.5f,0.5f).build("pink_paintball_heavy"));
    public static final RegistryObject<EntityType<?>> PURPLE_PAINTBALL_HEAVY = ENTITY_TYPES.register("purple_paintball_heavy",() -> EntityType.Builder.of(PurplePaintballHeavyArrowEntity::new, MobCategory.MISC).sized(0.5f,0.5f).build("purple_paintball_heavy"));
    public static final RegistryObject<EntityType<?>> LIME_PAINTBALL_HEAVY = ENTITY_TYPES.register("lime_paintball_heavy",() -> EntityType.Builder.of(LimePaintballHeavyArrowEntity::new, MobCategory.MISC).sized(0.5f,0.5f).build("lime_paintball_heavy"));
    public static final RegistryObject<EntityType<?>> LIGHT_BLUE_PAINTBALL_HEAVY = ENTITY_TYPES.register("light_blue_paintball_heavy",() -> EntityType.Builder.of(LightBluePaintballHeavyArrowEntity::new, MobCategory.MISC).sized(0.5f,0.5f).build("light_blue_paintball_heavy"));

    public static final RegistryObject<EntityType<RedGrenade>> RED_GRENADE = ENTITY_TYPES.register("red_grenade",() -> EntityType.Builder.<RedGrenade>of(RedGrenade::new, MobCategory.MISC).sized(1f,1f).build("red_grenade"));
    public static final RegistryObject<EntityType<GreenGrenade>> GREEN_GRENADE = ENTITY_TYPES.register("green_grenade",() -> EntityType.Builder.<GreenGrenade>of(GreenGrenade::new, MobCategory.MISC).sized(1f,1f).build("green_grenade"));
    public static final RegistryObject<EntityType<BlueGrenade>> BLUE_GRENADE = ENTITY_TYPES.register("blue_grenade",() -> EntityType.Builder.<BlueGrenade>of(BlueGrenade::new, MobCategory.MISC).sized(1f,1f).build("blue_grenade"));
    public static final RegistryObject<EntityType<MagentaGrenade>> MAGENTA_GRENADE = ENTITY_TYPES.register("magenta_grenade",() -> EntityType.Builder.<MagentaGrenade>of(MagentaGrenade::new, MobCategory.MISC).sized(1f,1f).build("magenta_grenade"));
    public static final RegistryObject<EntityType<PinkGrenade>> PINK_GRENADE = ENTITY_TYPES.register("pink_grenade",() -> EntityType.Builder.<PinkGrenade>of(PinkGrenade::new, MobCategory.MISC).sized(1f,1f).build("pink_grenade"));
    public static final RegistryObject<EntityType<PurpleGrenade>> PURPLE_GRENADE = ENTITY_TYPES.register("purple_grenade",() -> EntityType.Builder.<PurpleGrenade>of(PurpleGrenade::new, MobCategory.MISC).sized(1f,1f).build("purple_grenade"));
    public static final RegistryObject<EntityType<LimeGrenade>> LIME_GRENADE = ENTITY_TYPES.register("lime_grenade",() -> EntityType.Builder.<LimeGrenade>of(LimeGrenade::new, MobCategory.MISC).sized(1f,1f).build("lime_grenade"));
    public static final RegistryObject<EntityType<LightBlueGrenade>> LIGHT_BLUE_GRENADE = ENTITY_TYPES.register("light_blue_grenade",() -> EntityType.Builder.<LightBlueGrenade>of(LightBlueGrenade::new, MobCategory.MISC).sized(1f,1f).build("light_blue_grenade"));


}
