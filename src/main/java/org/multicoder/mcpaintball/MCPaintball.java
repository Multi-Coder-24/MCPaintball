package org.multicoder.mcpaintball;



import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.multicoder.mcpaintball.entityrenderer.basic.*;
import org.multicoder.mcpaintball.entityrenderer.heavy.*;
import org.multicoder.mcpaintball.init.*;
import org.multicoder.mcpaintball.network.Networking;
import org.multicoder.mcpaintball.util.BlockHolder;
import org.multicoder.mcpaintball.util.config.MCPaintballConfig;

@Mod(MCPaintball.MODID)
public class MCPaintball
{
    public static final String MODID = "mcpaintball";
    public static final Logger LOG = LogManager.getLogger(MODID);
    public static final boolean DEV_MODE = false;

    public MCPaintball()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MCPaintballConfig.SPEC,"mcpaintball-common.toml");
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        LOG.info("mcpaintball: Mod Loading");
        bus.register(this);
        bus.addListener(this::EntityRenderersSetup);
        bus.addListener(this::OnCommon);
        iteminit.ITEMS.register(bus);
        blockinit.BLOCKS.register(bus);
        blockentityinit.BLOCK_ENTITIES.register(bus);
        entityinit.ENTITY_TYPES.register(bus);
        soundinit.SOUNDS.register(bus);
    }

    private void EntityRenderersSetup(EntityRenderersEvent.RegisterRenderers event)
    {

        event.registerEntityRenderer((EntityType)entityinit.RED_PAINTBALL.get(), RedPaintballArrowRenderer::new);
        event.registerEntityRenderer((EntityType)entityinit.BLUE_PAINTBALL.get(), BluePaintballArrowRenderer::new);
        event.registerEntityRenderer((EntityType)entityinit.GREEN_PAINTBALL.get(), GreenPaintballArrowRenderer::new);
        event.registerEntityRenderer((EntityType)entityinit.MAGENTA_PAINTBALL.get(), MagentaPaintballArrowRenderer::new);
        event.registerEntityRenderer((EntityType)entityinit.PINK_PAINTBALL.get(), PinkPaintballArrowRenderer::new);
        event.registerEntityRenderer((EntityType)entityinit.PURPLE_PAINTBALL.get(), PurplePaintballArrowRenderer::new);
        event.registerEntityRenderer((EntityType)entityinit.LIME_PAINTBALL.get(), LimePaintballArrowRenderer::new);
        event.registerEntityRenderer((EntityType)entityinit.LIGHT_BLUE_PAINTBALL.get(), LightBluePaintballArrowRenderer::new);

        event.registerEntityRenderer((EntityType)entityinit.RED_PAINTBALL_HEAVY.get(), RedPaintballHeavyArrowRenderer::new);
        event.registerEntityRenderer((EntityType)entityinit.BLUE_PAINTBALL_HEAVY.get(), BluePaintballHeavyArrowRenderer::new);
        event.registerEntityRenderer((EntityType)entityinit.GREEN_PAINTBALL_HEAVY.get(), GreenPaintballHeavyArrowRenderer::new);
        event.registerEntityRenderer((EntityType)entityinit.MAGENTA_PAINTBALL_HEAVY.get(), MagentaPaintballHeavyArrowRenderer::new);
        event.registerEntityRenderer((EntityType)entityinit.PINK_PAINTBALL_HEAVY.get(), PinkPaintballHeavyArrowRenderer::new);
        event.registerEntityRenderer((EntityType)entityinit.PURPLE_PAINTBALL_HEAVY.get(), PurplePaintballHeavyArrowRenderer::new);
        event.registerEntityRenderer((EntityType)entityinit.LIME_PAINTBALL_HEAVY.get(), LimePaintballHeavyArrowRenderer::new);
        event.registerEntityRenderer((EntityType)entityinit.LIGHT_BLUE_PAINTBALL_HEAVY.get(), LightBluePaintballHeavyArrowRenderer::new);

        event.registerEntityRenderer(entityinit.RED_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(entityinit.BLUE_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(entityinit.GREEN_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(entityinit.MAGENTA_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(entityinit.PINK_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(entityinit.PURPLE_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(entityinit.LIME_GRENADE.get(),ThrownItemRenderer::new);
        event.registerEntityRenderer(entityinit.LIGHT_BLUE_GRENADE.get(), ThrownItemRenderer::new);
    }

    private void OnCommon(FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            BlockHolder.AppendList();
            Networking.Register();
        });
    }
}
