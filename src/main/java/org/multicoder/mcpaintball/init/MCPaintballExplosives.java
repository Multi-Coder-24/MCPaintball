package org.multicoder.mcpaintball.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.entity.*;

public class MCPaintballExplosives {
    public static final DeferredRegister<EntityType<?>> EXPLOSIVES_REGISTER = DeferredRegister.create(Registries.ENTITY_TYPE, MCPaintball.MOD_ID);

    public static final DeferredHolder<EntityType<?>,EntityType<?>> RED_PAINT_GRENADE = EXPLOSIVES_REGISTER.register("explosives/red_paint_grenade",() -> EntityType.Builder.of(RedPaintGrenadeEntity::new, MobCategory.MISC).build("explosives/red_paint_grenade"));
    public static final DeferredHolder<EntityType<?>,EntityType<?>> GREEN_PAINT_GRENADE = EXPLOSIVES_REGISTER.register("explosives/green_paint_grenade",() -> EntityType.Builder.of(GreenPaintGrenadeEntity::new, MobCategory.MISC).build("explosives/green_paint_grenade"));
    public static final DeferredHolder<EntityType<?>,EntityType<?>> BLUE_PAINT_GRENADE = EXPLOSIVES_REGISTER.register("explosives/blue_paint_grenade",() -> EntityType.Builder.of(BluePaintGrenadeEntity::new, MobCategory.MISC).build("explosives/blue_paint_grenade"));
    public static final DeferredHolder<EntityType<?>,EntityType<?>> CYAN_PAINT_GRENADE = EXPLOSIVES_REGISTER.register("explosives/cyan_paint_grenade",() -> EntityType.Builder.of(CyanPaintGrenadeEntity::new, MobCategory.MISC).build("explosives/cyan_paint_grenade"));
    public static final DeferredHolder<EntityType<?>,EntityType<?>> MAGENTA_PAINT_GRENADE = EXPLOSIVES_REGISTER.register("explosives/magenta_paint_grenade",() -> EntityType.Builder.of(MagentaPaintGrenadeEntity::new, MobCategory.MISC).build("explosives/magenta_paint_grenade"));
    public static final DeferredHolder<EntityType<?>,EntityType<?>> YELLOW_PAINT_GRENADE = EXPLOSIVES_REGISTER.register("explosives/yellow_paint_grenade",() -> EntityType.Builder.of(YellowPaintGrenadeEntity::new, MobCategory.MISC).build("explosives/yellow_paint_grenade"));
    public static final DeferredHolder<EntityType<?>,EntityType<?>> LIME_PAINT_GRENADE = EXPLOSIVES_REGISTER.register("explosives/lime_paint_grenade",() -> EntityType.Builder.of(LimePaintGrenadeEntity::new, MobCategory.MISC).build("explosives/lime_paint_grenade"));
    public static final DeferredHolder<EntityType<?>,EntityType<?>> LIGHT_BLUE_PAINT_GRENADE = EXPLOSIVES_REGISTER.register("explosives/light_blue_paint_grenade",() -> EntityType.Builder.of(LightBluePaintGrenadeEntity::new, MobCategory.MISC).build("explosives/light_blue_paint_grenade"));
    public static final DeferredHolder<EntityType<?>,EntityType<?>> PINK_PAINT_GRENADE = EXPLOSIVES_REGISTER.register("explosives/pink_paint_grenade",() -> EntityType.Builder.of(PinkPaintGrenadeEntity::new, MobCategory.MISC).build("explosives/pink_paint_grenade"));
    public static final DeferredHolder<EntityType<?>,EntityType<?>> WHITE_PAINT_GRENADE = EXPLOSIVES_REGISTER.register("explosives/white_paint_grenade",() -> EntityType.Builder.of(WhitePaintGrenadeEntity::new, MobCategory.MISC).build("explosives/white_paint_grenade"));

    public static final DeferredHolder<EntityType<?>,EntityType<?>> EMP_GRENADE = EXPLOSIVES_REGISTER.register("explosives/emp_grenade",() -> EntityType.Builder.of(EMPGrenadeEntity::new, MobCategory.MISC).build("explosives/emp_grenade"));
}
