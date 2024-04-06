package org.multicoder.mcpaintball;

//  External And JDK Packages
import org.apache.logging.log4j.*;
import java.io.File;
//  Minecraft Packages
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
//  Mod Packages
import org.multicoder.mcpaintball.client.ClientPlayerTeamData;
import org.multicoder.mcpaintball.client.entityrenderer.*;
import org.multicoder.mcpaintball.common.config.MCPaintballConfig;
import org.multicoder.mcpaintball.common.init.*;
import org.multicoder.mcpaintball.common.network.Networking;
import org.multicoder.mcpaintball.common.util.holders.*;
import org.multicoder.mcpaintball.common.util.item.ItemCategories;
import org.multicoder.mcpaintball.util.ErrorLogGenerator;


@Mod(MCPaintball.MOD_ID)
public class MCPaintball {
    public static final String MOD_ID = "mcpaintball";
    public static final Logger LOG = LogManager.getLogger("MCPaintball Main");
    public static final Logger LOG_ERROR = LogManager.getLogger("MCPaintball Errors");
    public static final boolean DEV_MODE = false;

    public MCPaintball()
    {
        try
        {
            String Folder = FMLPaths.GAMEDIR.get() + "\\MCPaintball";
            File F = new File(Folder);
            F.mkdir();
            ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, MCPaintballConfig.SPEC, "mcpaintball-server.toml");
            IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
            bus.addListener(this::EntityRenderersSetup);
            bus.addListener(this::OnCommon);
            bus.addListener(this::OnClient);
            bus.addListener(this::addCreative);
            iteminit.ITEMS.register(bus);
            blockinit.BLOCKS.register(bus);
            blockentityinit.BLOCK_ENTITIES.register(bus);
            entityinit.ENTITY_TYPES.register(bus);
            soundinit.SOUNDS.register(bus);
        }
        catch(Exception e)
        {
            MCPaintball.LOG_ERROR.throwing(e);
            try
            {
                ErrorLogGenerator.Generate(e);
            }
            catch (Exception ex){}
            MCPaintball.LOG_ERROR.info("Error Handled");
        }
    }

    private void EntityRenderersSetup(EntityRenderersEvent.RegisterRenderers event)
    {
        try{
            event.registerEntityRenderer(entityinit.RED_PAINTBALL.get(), PaintballRenderer::new);
            event.registerEntityRenderer(entityinit.BLUE_PAINTBALL.get(), PaintballRenderer::new);
            event.registerEntityRenderer(entityinit.GREEN_PAINTBALL.get(), PaintballRenderer::new);
            event.registerEntityRenderer(entityinit.MAGENTA_PAINTBALL.get(), PaintballRenderer::new);
            event.registerEntityRenderer(entityinit.PINK_PAINTBALL.get(), PaintballRenderer::new);
            event.registerEntityRenderer(entityinit.PURPLE_PAINTBALL.get(), PaintballRenderer::new);
            event.registerEntityRenderer(entityinit.LIME_PAINTBALL.get(), PaintballRenderer::new);
            event.registerEntityRenderer(entityinit.LIGHT_BLUE_PAINTBALL.get(), PaintballRenderer::new);
            event.registerEntityRenderer(entityinit.CYAN_PAINTBALL.get(), PaintballRenderer::new);

            event.registerEntityRenderer(entityinit.RED_PAINTBALL_HEAVY.get(), PaintballHeavyRenderer::new);
            event.registerEntityRenderer(entityinit.BLUE_PAINTBALL_HEAVY.get(), PaintballHeavyRenderer::new);
            event.registerEntityRenderer(entityinit.GREEN_PAINTBALL_HEAVY.get(), PaintballHeavyRenderer::new);
            event.registerEntityRenderer(entityinit.MAGENTA_PAINTBALL_HEAVY.get(), PaintballHeavyRenderer::new);
            event.registerEntityRenderer(entityinit.PINK_PAINTBALL_HEAVY.get(), PaintballHeavyRenderer::new);
            event.registerEntityRenderer(entityinit.PURPLE_PAINTBALL_HEAVY.get(), PaintballHeavyRenderer::new);
            event.registerEntityRenderer(entityinit.LIME_PAINTBALL_HEAVY.get(), PaintballHeavyRenderer::new);
            event.registerEntityRenderer(entityinit.LIGHT_BLUE_PAINTBALL_HEAVY.get(), PaintballHeavyRenderer::new);
            event.registerEntityRenderer(entityinit.CYAN_PAINTBALL_HEAVY.get(), PaintballHeavyRenderer::new);

            event.registerEntityRenderer(entityinit.RED_GRENADE.get(), GrenadeRenderer::new);
            event.registerEntityRenderer(entityinit.BLUE_GRENADE.get(), GrenadeRenderer::new);
            event.registerEntityRenderer(entityinit.GREEN_GRENADE.get(), GrenadeRenderer::new);
            event.registerEntityRenderer(entityinit.MAGENTA_GRENADE.get(), GrenadeRenderer::new);
            event.registerEntityRenderer(entityinit.PINK_GRENADE.get(), GrenadeRenderer::new);
            event.registerEntityRenderer(entityinit.PURPLE_GRENADE.get(), GrenadeRenderer::new);
            event.registerEntityRenderer(entityinit.LIME_GRENADE.get(), GrenadeRenderer::new);
            event.registerEntityRenderer(entityinit.LIGHT_BLUE_GRENADE.get(), GrenadeRenderer::new);
            event.registerEntityRenderer(entityinit.CYAN_GRENADE.get(), GrenadeRenderer::new);
        }
        catch(Exception e)
        {
            MCPaintball.LOG_ERROR.throwing(e);
            try
            {
                ErrorLogGenerator.Generate(e);
            }
            catch (Exception ex){}
            MCPaintball.LOG_ERROR.info("Error Handled");
        }
    }

    private void OnClient(FMLClientSetupEvent event)
    {
        try{
            event.enqueueWork(() ->
            {
                Networking.Register();
                ItemProperties.register(iteminit.PAINTBALL_GRENADE.get(), new ResourceLocation(MCPaintball.MOD_ID, "team"), ((stack, level, entity, i) ->
                {
                    if (entity instanceof Player) {
                        return ClientPlayerTeamData.GetTeam().GetModelIndex();
                    }
                    return 0f;
                }));
            });
        }
        catch(Exception e)
        {
            MCPaintball.LOG_ERROR.throwing(e);
            try
            {
                ErrorLogGenerator.Generate(e);
            }
            catch (Exception ex){}
            MCPaintball.LOG_ERROR.info("Error Handled");
        }
    }

    private void OnCommon(FMLCommonSetupEvent event)
    {
        try{
            RedClass.PopulateRegistry();
            BlueClass.PopulateRegistry();
            GreenClass.PopulateRegistry();
            MagentaClass.PopulateRegistry();
            PinkClass.PopulateRegistry();
            PurpleClass.PopulateRegistry();
            LimeClass.PopulateRegistry();
            LightBlueClass.PopulateRegistry();
            CyanClass.PopulateRegistry();
            ItemCategories.Populate();
        }
        catch(Exception e)
        {
            MCPaintball.LOG_ERROR.throwing(e);
            try
            {
                ErrorLogGenerator.Generate(e);
            }
            catch (Exception ex){}
            MCPaintball.LOG_ERROR.info("Error Handled");
        }
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        try{
            if (event.getTab() == tabinit.Weapons) {
                ItemCategories.WEAPONS.forEach(event::accept);
            } else if (event.getTab() == tabinit.Armor) {
                ItemCategories.ARMOR.forEach(event::accept);
            } else if (event.getTab() == tabinit.Utility) {
                ItemCategories.UTILITY.forEach(event::accept);
            }
        }
        catch(Exception e)
        {
            MCPaintball.LOG_ERROR.throwing(e);
            try
            {
                ErrorLogGenerator.Generate(e);
            }
            catch (Exception ex){}
            MCPaintball.LOG_ERROR.info("Error Handled");
        }
    }
}
