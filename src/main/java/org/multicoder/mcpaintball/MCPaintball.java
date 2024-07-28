package org.multicoder.mcpaintball;


import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
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
import org.multicoder.mcpaintball.common.blockentities.MCPaintballBlockEntities;
import org.multicoder.mcpaintball.common.blocks.MCPaintballBlocks;
import org.multicoder.mcpaintball.common.commands.MatchCommands;
import org.multicoder.mcpaintball.common.commands.TeamCommands;
import org.multicoder.mcpaintball.common.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.common.data.PaintballDataUtility;
import org.multicoder.mcpaintball.common.data.PaintballDataUtility.Class;
import org.multicoder.mcpaintball.common.data.PaintballDataUtility.Team;
import org.multicoder.mcpaintball.common.data.PaintballOverlay;
import org.multicoder.mcpaintball.common.entity.MCPaintballEntities;
import org.multicoder.mcpaintball.common.entity.grenade.RedPaintballGrenadeEntity;
import org.multicoder.mcpaintball.common.entity.paintball.GrayHeavyPaintballEntity;
import org.multicoder.mcpaintball.common.entity.paintball.GrayPaintballEntity;
import org.multicoder.mcpaintball.common.entity.paintball.HeavyPaintballEntity;
import org.multicoder.mcpaintball.common.entity.paintball.PaintballEntity;
import org.multicoder.mcpaintball.common.entityrenderers.paintball.GrayHeavyPaintballRenderer;
import org.multicoder.mcpaintball.common.entityrenderers.paintball.GrayPaintballEntityRenderer;
import org.multicoder.mcpaintball.common.entityrenderers.paintball.HeavyPaintballRenderer;
import org.multicoder.mcpaintball.common.entityrenderers.paintball.PaintballEntityRenderer;
import org.multicoder.mcpaintball.common.items.MCPaintballItems;
import org.multicoder.mcpaintball.common.networking.TeamDataSyncPayloadHandler;
import org.multicoder.mcpaintball.common.networking.TeamsDataSyncPacket;

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
        MCPaintballBlocks.BLOCKS.register(eventBus);
        MCPaintballEntities.ENTITIES.register(eventBus);
        MCPaintballSounds.SOUNDS.register(eventBus);
        MCPaintballBlockEntities.BLOCK_ENTITIES.register(eventBus);
    }
    @SuppressWarnings("unchecked")
    public void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer((EntityType<PaintballEntity>) MCPaintballEntities.RED_PAINTBALL.get(), PaintballEntityRenderer::new);
        event.registerEntityRenderer((EntityType<PaintballEntity>) MCPaintballEntities.GREEN_PAINTBALL.get(), PaintballEntityRenderer::new);
        event.registerEntityRenderer((EntityType<PaintballEntity>) MCPaintballEntities.BLUE_PAINTBALL.get(), PaintballEntityRenderer::new);
        event.registerEntityRenderer((EntityType<GrayPaintballEntity>) MCPaintballEntities.SOLO_PAINTBALL.get(), GrayPaintballEntityRenderer::new);

        event.registerEntityRenderer((EntityType<HeavyPaintballEntity>) MCPaintballEntities.RED_HEAVY_PAINTBALL.get(), HeavyPaintballRenderer::new);
        event.registerEntityRenderer((EntityType<HeavyPaintballEntity>) MCPaintballEntities.GREEN_HEAVY_PAINTBALL.get(), HeavyPaintballRenderer::new);
        event.registerEntityRenderer((EntityType<HeavyPaintballEntity>) MCPaintballEntities.BLUE_HEAVY_PAINTBALL.get(), HeavyPaintballRenderer::new);
        event.registerEntityRenderer((EntityType<GrayHeavyPaintballEntity>) MCPaintballEntities.SOLO_HEAVY_PAINTBALL.get(), GrayHeavyPaintballRenderer::new);

        event.registerEntityRenderer((EntityType<RedPaintballGrenadeEntity>) MCPaintballEntities.RED_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer((EntityType<RedPaintballGrenadeEntity>) MCPaintballEntities.GREEN_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer((EntityType<RedPaintballGrenadeEntity>) MCPaintballEntities.BLUE_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer((EntityType<RedPaintballGrenadeEntity>) MCPaintballEntities.SOLO_GRENADE.get(), ThrownItemRenderer::new);
    }

    public void buildCreativeTabContents(BuildCreativeModeTabContentsEvent event)
    {
        try
        {
            if (event.getTabKey().equals(CreativeModeTabs.COMBAT))
            {
                event.accept(MCPaintballItems.PISTOL);
                event.accept(MCPaintballItems.RIFLE);
                event.accept(MCPaintballItems.SHOTGUN);
                event.accept(MCPaintballItems.BAZOOKA);
                event.accept(MCPaintballItems.RED_GRENADE);
                event.accept(MCPaintballItems.GREEN_GRENADE);
                event.accept(MCPaintballItems.BLUE_GRENADE);
                event.accept(MCPaintballItems.SOLO_GRENADE);

                event.accept(MCPaintballItems.RED_REMOTE);
                event.accept(MCPaintballItems.GREEN_REMOTE);
                event.accept(MCPaintballItems.BLUE_REMOTE);
                event.accept(MCPaintballItems.SOLO_REMOTE);

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

                event.accept(MCPaintballItems.SOLO_BOOTS);
                event.accept(MCPaintballItems.SOLO_LEGGINGS);
                event.accept(MCPaintballItems.SOLO_CHESTPLATE);
                event.accept(MCPaintballItems.SOLO_HELMET);

            } else if (event.getTabKey().equals(CreativeModeTabs.FUNCTIONAL_BLOCKS))
            {
                event.accept(new ItemStack(MCPaintballBlocks.RED_C4));
                event.accept(new ItemStack(MCPaintballBlocks.GREEN_C4));
                event.accept(new ItemStack(MCPaintballBlocks.BLUE_C4));
                event.accept(new ItemStack(MCPaintballBlocks.SOLO_C4));

                event.accept(new ItemStack(MCPaintballBlocks.RED_TEAM_STATION));
                event.accept(new ItemStack(MCPaintballBlocks.GREEN_TEAM_STATION));
                event.accept(new ItemStack(MCPaintballBlocks.BLUE_TEAM_STATION));
                event.accept(new ItemStack(MCPaintballBlocks.SOLO_TEAM_STATION));

                event.accept(new ItemStack(MCPaintballBlocks.TEAM_FLAG));
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
                    if(MCPaintballWorldData.INSTANCE.GAME_TYPE == 0 || MCPaintballWorldData.INSTANCE.GAME_TYPE == 2)
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
                        PacketDistributor.PLAYER.with((ServerPlayer) player).send(new TeamsDataSyncPacket(Points,PTeam,PClass, PaintballDataUtility.GameType.values()[MCPaintballWorldData.INSTANCE.GAME_TYPE]));
                    } else if (MCPaintballWorldData.INSTANCE.GAME_TYPE == 1 || MCPaintballWorldData.INSTANCE.GAME_TYPE == 3)
                    {
                        CompoundTag Data = player.getPersistentData().getCompound("mcpaintball.team");
                        Team PTeam = Team.values()[Data.getInt("team")];
                        Class PClass = Class.values()[Data.getInt("class")];
                        int Points = Data.getInt("points");
                        PacketDistributor.PLAYER.with((ServerPlayer) player).send(new TeamsDataSyncPacket(Points,PTeam,PClass, PaintballDataUtility.GameType.values()[MCPaintballWorldData.INSTANCE.GAME_TYPE]));
                    }
                }
            }
        }
        @SubscribeEvent
        public static void PlayerJoined(PlayerEvent.PlayerLoggedInEvent event) {
            MCPaintballTeamsDataHelper.SetIfAbsent(event.getEntity());
        }
    }
}
