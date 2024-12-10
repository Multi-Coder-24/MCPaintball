package org.multicoder.mcpaintball;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.saveddata.SavedData;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterGuiOverlaysEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlerEvent;
import net.neoforged.neoforge.network.registration.IPayloadRegistrar;
import org.multicoder.mcpaintball.commands.MatchCommands;
import org.multicoder.mcpaintball.commands.TeamCommands;
import org.multicoder.mcpaintball.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.data.PaintballOverlay;
import org.multicoder.mcpaintball.entity.grenade.BluePaintballGrenadeEntity;
import org.multicoder.mcpaintball.entity.grenade.GreenPaintballGrenadeEntity;
import org.multicoder.mcpaintball.entity.grenade.RedPaintballGrenadeEntity;
import org.multicoder.mcpaintball.entity.paintball.HeavyPaintballEntity;
import org.multicoder.mcpaintball.entity.paintball.PaintballEntity;
import org.multicoder.mcpaintball.entityrenderers.paintball.HeavyPaintballRenderer;
import org.multicoder.mcpaintball.entityrenderers.paintball.PaintballEntityRenderer;
import org.multicoder.mcpaintball.init.*;
import org.multicoder.mcpaintball.networking.TeamDataSyncPayloadHandler;
import org.multicoder.mcpaintball.networking.TeamsDataSyncPacket;

@SuppressWarnings("all")
@Mod(MCPaintball.MOD_ID)
public class MCPaintball {
    public static final String MOD_ID = "mcpaintball";

    public MCPaintball(IEventBus eventBus)
    {
        eventBus.addListener(this::registerEntityRenderers);
        eventBus.addListener(this::OverlayRegister);
        eventBus.addListener(this::RegisterPayloads);
        MCPaintballItems.ITEMS.register(eventBus);
        MCPaintballBlocks.BLOCKS.register(eventBus);
        MCPaintballCreativeTabs.TABS.register(eventBus);
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

        event.registerEntityRenderer((EntityType<RedPaintballGrenadeEntity>) MCPaintballEntities.RED_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer((EntityType<GreenPaintballGrenadeEntity>) MCPaintballEntities.GREEN_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer((EntityType<BluePaintballGrenadeEntity>) MCPaintballEntities.BLUE_GRENADE.get(), ThrownItemRenderer::new);
    }

    public void OverlayRegister(RegisterGuiOverlaysEvent event)
    {
        event.registerAboveAll(new ResourceLocation(MCPaintball.MOD_ID,"paintball_info"),new PaintballOverlay());
    }
    public void RegisterPayloads(final RegisterPayloadHandlerEvent event)
    {
        IPayloadRegistrar registrar = event.registrar(MCPaintball.MOD_ID);
        registrar.play(TeamsDataSyncPacket.ID,TeamsDataSyncPacket::new,handler -> handler.client(TeamDataSyncPayloadHandler::Handle));
    }

    @SuppressWarnings("unused")
    @Mod.EventBusSubscriber(modid = MCPaintball.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class NeoEvents
    {
        @SubscribeEvent
        private static void onServerStarted(ServerStartedEvent event)
        {
            ServerLevel overworld = event.getServer().overworld();
            SavedData.Factory<MCPaintballWorldData> saveDataFactory = new SavedData.Factory<>(MCPaintballWorldData::create, MCPaintballWorldData::load);
            MCPaintballWorldData.INSTANCE = overworld.getDataStorage().computeIfAbsent(saveDataFactory, MCPaintballWorldData.SAVE_NAME);
            MCPaintballWorldData.INSTANCE.setDirty();
        }
    }

    @SuppressWarnings("unused")
    @Mod.EventBusSubscriber(modid = MCPaintball.MOD_ID)
    public static class ModEvents
    {
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
                    int Team = Data.getInt("team");
                    int Class = Data.getInt("class");
                    int Points = MCPaintballWorldData.getPointsFromIndex(Team);
                    PacketDistributor.PLAYER.with((ServerPlayer) player).send(new TeamsDataSyncPacket(Points,Team,Class));
                }
            }
        }
        @SubscribeEvent
        public static void PlayerJoined(PlayerEvent.PlayerLoggedInEvent event)
        {
            MCPaintballTeamsDataHelper.SetIfAbsent(event.getEntity());
        }
        @SubscribeEvent
        public static void PlayerClone(PlayerEvent.Clone event)
        {
            if(event.isWasDeath())
            {
                event.getEntity().getInventory().load(event.getOriginal().getInventory().save(new ListTag()));
            }
            CompoundTag Tag = event.getOriginal().getPersistentData().getCompound("mcpaintball.team");
            event.getEntity().getPersistentData().put("mcpaintball.team",Tag);
        }
    }
}
