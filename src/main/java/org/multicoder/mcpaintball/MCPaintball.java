package org.multicoder.mcpaintball;


import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.saveddata.SavedData;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterGuiOverlaysEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlerEvent;
import net.neoforged.neoforge.network.registration.IPayloadRegistrar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.multicoder.mcpaintball.common.MCPaintballSounds;
import org.multicoder.mcpaintball.common.commands.MatchCommands;
import org.multicoder.mcpaintball.common.commands.TeamCommands;
import org.multicoder.mcpaintball.common.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.common.data.PaintballOverlay;
import org.multicoder.mcpaintball.common.entity.MCPaintballEntities;
import org.multicoder.mcpaintball.common.entity.grenade.PaintballGrenadeEntity;
import org.multicoder.mcpaintball.common.entity.paintball.HeavyPaintballEntity;
import org.multicoder.mcpaintball.common.entity.paintball.PaintballEntity;
import org.multicoder.mcpaintball.common.entityrenderers.paintball.GrenadeEntityRenderer;
import org.multicoder.mcpaintball.common.entityrenderers.paintball.HeavyPaintballRenderer;
import org.multicoder.mcpaintball.common.entityrenderers.paintball.PaintballEntityRenderer;
import org.multicoder.mcpaintball.common.items.MCPaintballItems;
import org.multicoder.mcpaintball.common.networking.TeamDataSyncPayloadHandler;
import org.multicoder.mcpaintball.common.networking.TeamsDataSyncPacket;
import org.multicoder.mcpaintball.common.utility.PaintballDataUtility.Class;
import org.multicoder.mcpaintball.common.utility.PaintballDataUtility.Team;

@SuppressWarnings("all")
@Mod(MCPaintball.MOD_ID)
public class MCPaintball {
    public static final String MOD_ID = "mcpaintball";
    public static Logger LOG = LogManager.getLogger(MOD_ID);

    public MCPaintball(IEventBus eventBus)
    {
        eventBus.addListener(this::buildCreativeTabContents);
        eventBus.addListener(this::registerEntityRenderers);
        eventBus.addListener(this::OverlayRegister);
        eventBus.addListener(this::RegisterPayloads);
        MCPaintballItems.ITEMS.register(eventBus);
        MCPaintballEntities.ENTITIES.register(eventBus);
        MCPaintballSounds.SOUNDS.register(eventBus);
    }
    @SuppressWarnings("unchecked")
    public void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer((EntityType<PaintballEntity>) MCPaintballEntities.RED_PAINTBALL.get(), PaintballEntityRenderer::new);
        event.registerEntityRenderer((EntityType<PaintballEntity>) MCPaintballEntities.GREEN_PAINTBALL.get(), PaintballEntityRenderer::new);
        event.registerEntityRenderer((EntityType<PaintballEntity>) MCPaintballEntities.BLUE_PAINTBALL.get(), PaintballEntityRenderer::new);

        event.registerEntityRenderer((EntityType<HeavyPaintballEntity>) MCPaintballEntities.RED_HEAVY_PAINTBALL.get(), HeavyPaintballRenderer::new);
        event.registerEntityRenderer((EntityType<HeavyPaintballEntity>) MCPaintballEntities.GREEN_HEAVY_PAINTBALL.get(), HeavyPaintballRenderer::new);
        event.registerEntityRenderer((EntityType<HeavyPaintballEntity>) MCPaintballEntities.BLUE_HEAVY_PAINTBALL.get(), HeavyPaintballRenderer::new);

        event.registerEntityRenderer((EntityType<PaintballGrenadeEntity>) MCPaintballEntities.RED_GRENADE.get(), GrenadeEntityRenderer::new);
        event.registerEntityRenderer((EntityType<PaintballGrenadeEntity>) MCPaintballEntities.GREEN_GRENADE.get(), GrenadeEntityRenderer::new);
        event.registerEntityRenderer((EntityType<PaintballGrenadeEntity>) MCPaintballEntities.BLUE_GRENADE.get(), GrenadeEntityRenderer::new);
    }

    public void buildCreativeTabContents(BuildCreativeModeTabContentsEvent event) {
        try {
            if (event.getTabKey().equals(CreativeModeTabs.COMBAT)) {
                event.accept(MCPaintballItems.PISTOL.get());
                event.accept(MCPaintballItems.RIFLE.get());
                event.accept(MCPaintballItems.SHOTGUN.get());
                event.accept(MCPaintballItems.BAZOOKA.get());
                event.accept(MCPaintballItems.GRENADE);

                event.accept(MCPaintballItems.RED_BOOTS);
                event.accept(MCPaintballItems.RED_LEGGINGS);
                event.accept(MCPaintballItems.RED_CHESTPLATE);
                event.accept(MCPaintballItems.RED_HELMET);

                event.accept(MCPaintballItems.GREEN_BOOTS);
                event.accept(MCPaintballItems.GREEN_LEGGINGS);
                event.accept(MCPaintballItems.GREEN_CHESTPLATE);
                event.accept(MCPaintballItems.GREEN_HELMET);

                event.accept(MCPaintballItems.BLUE_BOOTS);
                event.accept(MCPaintballItems.BLUE_LEGGINGS);
                event.accept(MCPaintballItems.BLUE_CHESTPLATE);
                event.accept(MCPaintballItems.BLUE_HELMET);
            }
        } catch (Exception exception) {
            LOG.error(exception);
        }
    }

    public void OverlayRegister(RegisterGuiOverlaysEvent event)
    {
        event.registerAboveAll(new ResourceLocation(MCPaintball.MOD_ID,"paintball_info"),new PaintballOverlay());
    }
    public void RegisterPayloads(final RegisterPayloadHandlerEvent event)
    {
        final IPayloadRegistrar registrar = event.registrar(MCPaintball.MOD_ID);
        registrar.play(TeamsDataSyncPacket.ID,TeamsDataSyncPacket::new,handler -> handler.client(TeamDataSyncPayloadHandler::Handle));
    }

    @SuppressWarnings("unused")
    @Mod.EventBusSubscriber(modid = MCPaintball.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class NeoEvents {
        @SubscribeEvent
        private static void onServerStarted(ServerStartedEvent event)
        {
            ServerLevel overworld = event.getServer().overworld();
            SavedData.Factory<MCPaintballWorldData> F = new SavedData.Factory<>(MCPaintballWorldData::create, MCPaintballWorldData::load);
            MCPaintballWorldData.INSTANCE = overworld.getDataStorage().computeIfAbsent(F, MCPaintballWorldData.SAVE_NAME);
            MCPaintballWorldData.INSTANCE.setDirty();
        }
    }

    @SuppressWarnings("unused")
    @Mod.EventBusSubscriber(modid = MCPaintball.MOD_ID)
    public static class ModEvents {
        @SubscribeEvent
        public static void registerCommands(RegisterCommandsEvent event) {
            CommandDispatcher<CommandSourceStack> Dispatcher = event.getDispatcher();
            TeamCommands.registerCommands(Dispatcher);
            MatchCommands.registerCommands(Dispatcher);
        }

        @SubscribeEvent
        public static void PlayerTick(LivingEvent.LivingTickEvent event)
        {
            if(event.getEntity() instanceof Player player)
            {
                if(!player.level().isClientSide())
                {
                    CompoundTag Data = player.getPersistentData().getCompound("mcpaintball.team");
                    Team PTeam = Team.values()[Data.getInt("team")];
                    Class PClass = Class.values()[Data.getInt("class")];
                    int Points = 0;
                    if(PTeam == Team.NONE)
                    {
                        Points = -1;
                    }
                    else{
                        switch (PTeam)
                        {
                            case RED -> Points = MCPaintballWorldData.INSTANCE.RED_POINTS;
                            case BLUE -> Points = MCPaintballWorldData.INSTANCE.BLUE_POINTS;
                            case GREEN -> Points = MCPaintballWorldData.INSTANCE.GREEN_POINTS;
                        }
                    }
                    PacketDistributor.PLAYER.with((ServerPlayer) player).send(new TeamsDataSyncPacket(Points,PTeam,PClass));

                }
            }
        }
        @SubscribeEvent
        public static void PlayerJoined(PlayerEvent.PlayerLoggedInEvent event) {
            MCPaintballTeamsDataHelper.SetIfAbsent(event.getEntity());
        }
    }
}
