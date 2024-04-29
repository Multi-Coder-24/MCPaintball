package org.multicoder.mcpaintball;


import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.saveddata.SavedData;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.event.AttachCapabilitiesEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.multicoder.mcpaintball.common.MCPaintballSounds;
import org.multicoder.mcpaintball.common.blocks.MCPaintballBlocks;
import org.multicoder.mcpaintball.common.commands.MatchCommands;
import org.multicoder.mcpaintball.common.commands.TeamCommands;
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.common.data.capability.PaintballPlayer;
import org.multicoder.mcpaintball.common.data.capability.PaintballPlayerProvider;
import org.multicoder.mcpaintball.common.entity.MCPaintballEntities;
import org.multicoder.mcpaintball.common.entity.paintball.HeavyPaintballEntity;
import org.multicoder.mcpaintball.common.entity.paintball.PaintballEntity;
import org.multicoder.mcpaintball.common.entity.throwable.BlindnessGrenadeEntity;
import org.multicoder.mcpaintball.common.entity.throwable.GrenadeEntity;
import org.multicoder.mcpaintball.common.entity.throwable.SlownessGrenadeEntity;
import org.multicoder.mcpaintball.common.entity.throwable.WeaknessGrenadeEntity;
import org.multicoder.mcpaintball.common.entityrenderers.GrenadeRenderer;
import org.multicoder.mcpaintball.common.entityrenderers.paintball.HeavyPaintballRenderer;
import org.multicoder.mcpaintball.common.entityrenderers.paintball.PaintballEntityRenderer;
import org.multicoder.mcpaintball.common.items.MCPaintballItems;

@Mod(MCPaintball.MOD_ID)
public class MCPaintball {
    public static final String MOD_ID = "mcpaintball";
    public static final boolean DEBUG_MODE = true;
    public static Logger LOG = LogManager.getLogger(MOD_ID);

    public MCPaintball() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::buildCreativeTabContents);
        eventBus.addListener(this::registerEntityRenderers);
        MCPaintballItems.ITEMS.register(eventBus);
        MCPaintballBlocks.BLOCKS.register(eventBus);
        MCPaintballEntities.ENTITIES.register(eventBus);
        MCPaintballSounds.SOUNDS.register(eventBus);
    }

    @SuppressWarnings("unchecked")
    public void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer((EntityType<PaintballEntity>) MCPaintballEntities.RED_PAINTBALL.get(), PaintballEntityRenderer::new);
        event.registerEntityRenderer((EntityType<PaintballEntity>) MCPaintballEntities.GREEN_PAINTBALL.get(), PaintballEntityRenderer::new);
        event.registerEntityRenderer((EntityType<PaintballEntity>) MCPaintballEntities.BLUE_PAINTBALL.get(), PaintballEntityRenderer::new);
        event.registerEntityRenderer((EntityType<PaintballEntity>) MCPaintballEntities.CYAN_PAINTBALL.get(), PaintballEntityRenderer::new);
        event.registerEntityRenderer((EntityType<PaintballEntity>) MCPaintballEntities.MAGENTA_PAINTBALL.get(), PaintballEntityRenderer::new);
        event.registerEntityRenderer((EntityType<PaintballEntity>) MCPaintballEntities.YELLOW_PAINTBALL.get(), PaintballEntityRenderer::new);
        event.registerEntityRenderer((EntityType<PaintballEntity>) MCPaintballEntities.LIME_PAINTBALL.get(), PaintballEntityRenderer::new);
        event.registerEntityRenderer((EntityType<PaintballEntity>) MCPaintballEntities.LIGHT_BLUE_PAINTBALL.get(), PaintballEntityRenderer::new);
        event.registerEntityRenderer((EntityType<PaintballEntity>) MCPaintballEntities.PINK_PAINTBALL.get(), PaintballEntityRenderer::new);
        event.registerEntityRenderer((EntityType<PaintballEntity>) MCPaintballEntities.PURPLE_PAINTBALL.get(), PaintballEntityRenderer::new);

        event.registerEntityRenderer((EntityType<HeavyPaintballEntity>) MCPaintballEntities.RED_HEAVY_PAINTBALL.get(), HeavyPaintballRenderer::new);
        event.registerEntityRenderer((EntityType<HeavyPaintballEntity>) MCPaintballEntities.GREEN_HEAVY_PAINTBALL.get(), HeavyPaintballRenderer::new);
        event.registerEntityRenderer((EntityType<HeavyPaintballEntity>) MCPaintballEntities.BLUE_HEAVY_PAINTBALL.get(), HeavyPaintballRenderer::new);
        event.registerEntityRenderer((EntityType<HeavyPaintballEntity>) MCPaintballEntities.CYAN_HEAVY_PAINTBALL.get(), HeavyPaintballRenderer::new);
        event.registerEntityRenderer((EntityType<HeavyPaintballEntity>) MCPaintballEntities.MAGENTA_HEAVY_PAINTBALL.get(), HeavyPaintballRenderer::new);
        event.registerEntityRenderer((EntityType<HeavyPaintballEntity>) MCPaintballEntities.YELLOW_HEAVY_PAINTBALL.get(), HeavyPaintballRenderer::new);
        event.registerEntityRenderer((EntityType<HeavyPaintballEntity>) MCPaintballEntities.LIME_HEAVY_PAINTBALL.get(), HeavyPaintballRenderer::new);
        event.registerEntityRenderer((EntityType<HeavyPaintballEntity>) MCPaintballEntities.LIGHT_BLUE_HEAVY_PAINTBALL.get(), HeavyPaintballRenderer::new);
        event.registerEntityRenderer((EntityType<HeavyPaintballEntity>) MCPaintballEntities.PINK_HEAVY_PAINTBALL.get(), HeavyPaintballRenderer::new);
        event.registerEntityRenderer((EntityType<HeavyPaintballEntity>) MCPaintballEntities.PURPLE_HEAVY_PAINTBALL.get(), HeavyPaintballRenderer::new);

        event.registerEntityRenderer((EntityType<GrenadeEntity>) MCPaintballEntities.RED_GRENADE.value(), GrenadeRenderer::new);
        event.registerEntityRenderer((EntityType<GrenadeEntity>) MCPaintballEntities.GREEN_GRENADE.value(), GrenadeRenderer::new);
        event.registerEntityRenderer((EntityType<GrenadeEntity>) MCPaintballEntities.BLUE_GRENADE.value(), GrenadeRenderer::new);
        event.registerEntityRenderer((EntityType<GrenadeEntity>) MCPaintballEntities.CYAN_GRENADE.value(), GrenadeRenderer::new);
        event.registerEntityRenderer((EntityType<GrenadeEntity>) MCPaintballEntities.MAGENTA_GRENADE.value(), GrenadeRenderer::new);
        event.registerEntityRenderer((EntityType<GrenadeEntity>) MCPaintballEntities.YELLOW_GRENADE.value(), GrenadeRenderer::new);
        event.registerEntityRenderer((EntityType<GrenadeEntity>) MCPaintballEntities.LIME_GRENADE.value(), GrenadeRenderer::new);
        event.registerEntityRenderer((EntityType<GrenadeEntity>) MCPaintballEntities.LIGHT_BLUE_GRENADE.value(), GrenadeRenderer::new);
        event.registerEntityRenderer((EntityType<GrenadeEntity>) MCPaintballEntities.PINK_GRENADE.value(), GrenadeRenderer::new);
        event.registerEntityRenderer((EntityType<GrenadeEntity>) MCPaintballEntities.PURPLE_GRENADE.value(), GrenadeRenderer::new);

        event.registerEntityRenderer((EntityType<SlownessGrenadeEntity>) MCPaintballEntities.SLOWNESS_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer((EntityType<WeaknessGrenadeEntity>) MCPaintballEntities.WEAKNESS_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer((EntityType<BlindnessGrenadeEntity>) MCPaintballEntities.BLINDNESS_GRENADE.get(), ThrownItemRenderer::new);
    }

    public void buildCreativeTabContents(BuildCreativeModeTabContentsEvent event) {
        try {
            if (event.getTabKey().equals(CreativeModeTabs.COMBAT)) {
                event.accept(MCPaintballItems.PISTOL.get());
                event.accept(MCPaintballItems.RIFLE.get());
                event.accept(MCPaintballItems.SHOTGUN.get());
                event.accept(MCPaintballItems.SNIPER.get());
                event.accept(MCPaintballItems.BAZOOKA.get());

                event.accept(MCPaintballItems.RED_BOOTS.get());
                event.accept(MCPaintballItems.RED_LEGGINGS.get());
                event.accept(MCPaintballItems.RED_CHESTPLATE.get());
                event.accept(MCPaintballItems.RED_HELMET.get());

                event.accept(MCPaintballItems.GREEN_BOOTS.get());
                event.accept(MCPaintballItems.GREEN_LEGGINGS.get());
                event.accept(MCPaintballItems.GREEN_CHESTPLATE.get());
                event.accept(MCPaintballItems.GREEN_HELMET.get());

                event.accept(MCPaintballItems.BLUE_BOOTS.get());
                event.accept(MCPaintballItems.BLUE_LEGGINGS.get());
                event.accept(MCPaintballItems.BLUE_CHESTPLATE.get());
                event.accept(MCPaintballItems.BLUE_HELMET.get());

                event.accept(MCPaintballItems.CYAN_BOOTS.get());
                event.accept(MCPaintballItems.CYAN_LEGGINGS.get());
                event.accept(MCPaintballItems.CYAN_CHESTPLATE.get());
                event.accept(MCPaintballItems.CYAN_HELMET.get());

                event.accept(MCPaintballItems.MAGENTA_BOOTS.get());
                event.accept(MCPaintballItems.MAGENTA_LEGGINGS.get());
                event.accept(MCPaintballItems.MAGENTA_CHESTPLATE.get());
                event.accept(MCPaintballItems.MAGENTA_HELMET.get());

                event.accept(MCPaintballItems.YELLOW_BOOTS.get());
                event.accept(MCPaintballItems.YELLOW_LEGGINGS.get());
                event.accept(MCPaintballItems.YELLOW_CHESTPLATE.get());
                event.accept(MCPaintballItems.YELLOW_HELMET.get());

                event.accept(MCPaintballItems.LIME_BOOTS.get());
                event.accept(MCPaintballItems.LIME_LEGGINGS.get());
                event.accept(MCPaintballItems.LIME_CHESTPLATE.get());
                event.accept(MCPaintballItems.LIME_HELMET.get());

                event.accept(MCPaintballItems.LIGHT_BLUE_BOOTS.get());
                event.accept(MCPaintballItems.LIGHT_BLUE_LEGGINGS.get());
                event.accept(MCPaintballItems.LIGHT_BLUE_CHESTPLATE.get());
                event.accept(MCPaintballItems.LIGHT_BLUE_HELMET.get());

                event.accept(MCPaintballItems.PINK_BOOTS.get());
                event.accept(MCPaintballItems.PINK_LEGGINGS.get());
                event.accept(MCPaintballItems.PINK_CHESTPLATE.get());
                event.accept(MCPaintballItems.PINK_HELMET.get());

                event.accept(MCPaintballItems.PURPLE_BOOTS.get());
                event.accept(MCPaintballItems.PURPLE_LEGGINGS.get());
                event.accept(MCPaintballItems.PURPLE_CHESTPLATE.get());
                event.accept(MCPaintballItems.PURPLE_HELMET.get());

            } else if (event.getTabKey().equals(CreativeModeTabs.TOOLS_AND_UTILITIES)) {
                event.accept(MCPaintballItems.REMOTE.get());
                event.accept(MCPaintballItems.GRENADE.get());
                event.accept(MCPaintballItems.SLOW_GRENADE.get());
                event.accept(MCPaintballItems.WEAK_GRENADE.get());
                event.accept(MCPaintballItems.BLIND_GRENADE.get());
                event.accept(MCPaintballItems.BASIC_AMMO.get());
                event.accept(MCPaintballItems.SHELL_AMMO.get());
                event.accept(MCPaintballItems.HEAVY_AMMO.get());
                event.accept(MCPaintballBlocks.RED_EXPLOSIVE.get());
                event.accept(MCPaintballBlocks.GREEN_EXPLOSIVE.get());
                event.accept(MCPaintballBlocks.BLUE_EXPLOSIVE.get());
                event.accept(MCPaintballBlocks.CYAN_EXPLOSIVE.get());
                event.accept(MCPaintballBlocks.MAGENTA_EXPLOSIVE.get());
                event.accept(MCPaintballBlocks.YELLOW_EXPLOSIVE.get());
                event.accept(MCPaintballBlocks.LIME_EXPLOSIVE.get());
                event.accept(MCPaintballBlocks.LIGHT_BLUE_EXPLOSIVE.get());
                event.accept(MCPaintballBlocks.PINK_EXPLOSIVE.get());
                event.accept(MCPaintballBlocks.PURPLE_EXPLOSIVE.get());

                event.accept(MCPaintballBlocks.RED_RESPAWN.get());
                event.accept(MCPaintballBlocks.GREEN_RESPAWN.get());
                event.accept(MCPaintballBlocks.BLUE_RESPAWN.get());
                event.accept(MCPaintballBlocks.CYAN_RESPAWN.get());
                event.accept(MCPaintballBlocks.MAGENTA_RESPAWN.get());
                event.accept(MCPaintballBlocks.YELLOW_RESPAWN.get());
                event.accept(MCPaintballBlocks.LIME_RESPAWN.get());
                event.accept(MCPaintballBlocks.LIGHT_BLUE_RESPAWN.get());
                event.accept(MCPaintballBlocks.PINK_RESPAWN.get());
                event.accept(MCPaintballBlocks.PURPLE_RESPAWN.get());
            }
        } catch (Exception exception) {
            LOG.error(exception);
        }
    }

    @SuppressWarnings("unused")
    @Mod.EventBusSubscriber(modid = MCPaintball.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class NeoEvents {
        @SubscribeEvent
        private static void onServerStarted(ServerStartedEvent event) {
            ServerLevel overworld = event.getServer().overworld();
            SavedData.Factory<MCPaintballWorldData> F = new SavedData.Factory<>(MCPaintballWorldData::create, MCPaintballWorldData::load);
            MCPaintballWorldData.INSTANCE = overworld.getDataStorage().computeIfAbsent(F, MCPaintballWorldData.SAVE_NAME);
        }

        @SubscribeEvent
        private static void PlayerCloned(PlayerEvent.Clone event) {
            if (event.isWasDeath()) {
                event.getEntity().reviveCaps();
                event.getOriginal().getCapability(PaintballPlayerProvider.CAPABILITY).ifPresent(oldStore -> event.getOriginal().getCapability(PaintballPlayerProvider.CAPABILITY).ifPresent(newStore -> newStore.CopyFrom(oldStore)));
                event.getEntity().invalidateCaps();
            }
        }
    }

    @SuppressWarnings("unused")
    @Mod.EventBusSubscriber(modid = MCPaintball.MOD_ID)
    public static class ModEvents {
        @SubscribeEvent
        public static void registerCommands(RegisterCommandsEvent event) {
            CommandDispatcher<CommandSourceStack> Dispatcher = event.getDispatcher();
            TeamCommands.registerCommands(Dispatcher);
            MatchCommands.register(Dispatcher);
        }

        @SubscribeEvent
        public static void RegisterCapabilities(RegisterCapabilitiesEvent event) {
            event.register(PaintballPlayer.class);
        }

        @SubscribeEvent
        public static void AttachCapabilityPlayer(AttachCapabilitiesEvent<Entity> event) {
            if (event.getObject() instanceof Player player) {
                if (!player.getCapability(PaintballPlayerProvider.CAPABILITY).isPresent()) {
                    event.addCapability(new ResourceLocation(MCPaintball.MOD_ID, "paintball_player"), new PaintballPlayerProvider());
                }
            }
        }
    }
}
