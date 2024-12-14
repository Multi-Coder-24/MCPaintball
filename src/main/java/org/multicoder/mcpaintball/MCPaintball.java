package org.multicoder.mcpaintball;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.saveddata.SavedData;
import net.neoforged.bus.api.*;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterGuiOverlaysEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlerEvent;
import org.multicoder.mcpaintball.commands. *;
import org.multicoder.mcpaintball.data.*;
import org.multicoder.mcpaintball.entityrenderers.EntityRenderers;
import org.multicoder.mcpaintball.networking.*;

import static org.multicoder.mcpaintball.MCPaintball.MOD_ID;
import static org.multicoder.mcpaintball.data.MCPaintballWorldData.*;
import static org.multicoder.mcpaintball.init.MCPaintballBlocks.BLOCKS;
import static org.multicoder.mcpaintball.init.MCPaintballItems.ITEMS;
import static org.multicoder.mcpaintball.init.MCPaintballCreativeTabs.TABS;
import static org.multicoder.mcpaintball.init.MCPaintballSounds.SOUNDS;
import static org.multicoder.mcpaintball.init.MCPaintballEntities.ENTITIES;
import static net.neoforged.neoforge.network.PacketDistributor.PLAYER;
import static net.neoforged.fml.common.Mod.EventBusSubscriber.Bus.FORGE;
import static org.multicoder.mcpaintball.networking.TeamsDataSyncPacket.ID;


@Mod(MOD_ID)
public class MCPaintball {
    public static final String MOD_ID = "mcpaintball";

    public MCPaintball(IEventBus eventBus)
    {
        eventBus.addListener(EntityRenderers::RegisterRenderers);
        eventBus.addListener(this::OverlayRegister);
        eventBus.addListener(this::RegisterPayloads);
        ITEMS.register(eventBus);
        BLOCKS.register(eventBus);
        TABS.register(eventBus);
        ENTITIES.register(eventBus);
        SOUNDS.register(eventBus);

    }

    public void OverlayRegister(RegisterGuiOverlaysEvent event)
    {
        event.registerAboveAll(new ResourceLocation(MOD_ID,"paintball_info"),new PaintballOverlay());
    }
    public void RegisterPayloads(final RegisterPayloadHandlerEvent event)
    {
        event.registrar(MOD_ID).play(ID,TeamsDataSyncPacket::new,handler -> handler.client(TeamDataSyncPayloadHandler::Handle));
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = FORGE)
    public static class NeoEvents
    {
        @SubscribeEvent
        private static void onServerStarted(ServerStartedEvent event)
        {
            INSTANCE = event.getServer().overworld().getDataStorage().computeIfAbsent(new SavedData.Factory<>(MCPaintballWorldData::create, MCPaintballWorldData::load), SAVE_NAME);
            INSTANCE.setDirty();
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID)
    public static class ModEvents
    {
        @SubscribeEvent
        public static void registerCommands(RegisterCommandsEvent event)
        {
            TeamCommands.registerCommands(event.getDispatcher());
            MatchCommands.registerCommands(event.getDispatcher());
        }

        @SubscribeEvent
        public static void PlayerTick(PlayerEvent.LivingTickEvent event)
        {
            if(!event.getEntity().level().isClientSide())
            {
                CompoundTag Data = event.getEntity().getPersistentData().getCompound("mcpaintball.team");
                int Team = Data.getInt("team");
                int Points = MCPaintballWorldData.getPointsFromIndex(Team);
                PLAYER.with((ServerPlayer) event.getEntity()).send(new TeamsDataSyncPacket(Points,Team));
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
            CompoundTag Tag = event.getOriginal().getPersistentData().getCompound("mcpaintball.team");
            event.getEntity().getPersistentData().put("mcpaintball.team",Tag);
        }
    }
}
