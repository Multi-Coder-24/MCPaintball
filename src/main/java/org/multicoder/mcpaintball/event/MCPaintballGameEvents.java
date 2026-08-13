package org.multicoder.mcpaintball.event;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.particle.GlowParticle;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.permissions.Permissions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import net.neoforged.neoforge.client.network.event.RegisterClientPayloadHandlersEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.client.gui.SelectRoleScreen;
import org.multicoder.mcpaintball.client.gui.SelectTeamScreen;
import org.multicoder.mcpaintball.client.renderer.PaintballDataOverlay;
import org.multicoder.mcpaintball.command.MCPaintballCommands;
import org.multicoder.mcpaintball.core.*;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.data.MCPaintballSaveData;
import org.multicoder.mcpaintball.entity.renderer.*;
import org.multicoder.mcpaintball.integration.MinecraftTeamSystem;
import org.multicoder.mcpaintball.network.*;

import java.util.Objects;
import static net.minecraft.commands.Commands.literal;
import static net.neoforged.neoforge.common.NeoForgeMod.MOD_ID;

@EventBusSubscriber(modid = MCPaintball.MODID)
public class MCPaintballGameEvents {
    public static int Ticker = 0;
    public static MCPaintballSaveData INSTANCE;
    @SubscribeEvent
    public static void CreativeTabRegister(BuildCreativeModeTabContentsEvent event){
        if(event.getTabKey() == MCPaintballCreativeTabs.WEAPONS_TAB.getKey()){
            event.accept(MCPaintballItems.PISTOL.value());
            event.accept(MCPaintballItems.SHOTGUN.value());
            event.accept(MCPaintballItems.ASSAULT_RIFLE.value());
            event.accept(MCPaintballItems.SNIPER_RIFLE.value());
            event.accept(MCPaintballItems.BURST_RIFLE.value());
            event.accept(MCPaintballItems.GRENADE_LAUNCHER.value());
            event.accept(MCPaintballItems.RED_PAINT_GRENADE.value());
            event.accept(MCPaintballItems.GREEN_PAINT_GRENADE.value());
            event.accept(MCPaintballItems.BLUE_PAINT_GRENADE.value());
            event.accept(MCPaintballItems.YELLOW_PAINT_GRENADE.value());
            event.accept(MCPaintballItems.PINK_PAINT_GRENADE.value());
            event.accept(MCPaintballItems.ORANGE_PAINT_GRENADE.value());
            event.accept(MCPaintballBlocks.RED_PAINT_MINE.value());
            event.accept(MCPaintballBlocks.GREEN_PAINT_MINE.value());
            event.accept(MCPaintballBlocks.BLUE_PAINT_MINE.value());
            event.accept(MCPaintballBlocks.YELLOW_PAINT_MINE.value());
            event.accept(MCPaintballBlocks.PINK_PAINT_MINE.value());
            event.accept(MCPaintballBlocks.ORANGE_PAINT_MINE.value());
            event.accept(MCPaintballItems.SMOKE_GRENADE.value());
            event.accept(MCPaintballItems.EMP_GRENADE.value());
            event.accept(MCPaintballItems.SIGHT_GRENADE.value());
            event.accept(MCPaintballBlocks.RED_CLAYMORE_BLOCK.value());
            event.accept(MCPaintballBlocks.GREEN_CLAYMORE_BLOCK.value());
            event.accept(MCPaintballBlocks.BLUE_CLAYMORE_BLOCK.value());
            event.accept(MCPaintballBlocks.YELLOW_CLAYMORE_BLOCK.value());
            event.accept(MCPaintballBlocks.PINK_CLAYMORE_BLOCK.value());
            event.accept(MCPaintballBlocks.ORANGE_CLAYMORE_BLOCK.value());
        }else if(event.getTabKey() == MCPaintballCreativeTabs.UTILITY_TAB.getKey()){
            event.accept(MCPaintballItems.RED_BOOTS.value());
            event.accept(MCPaintballItems.RED_LEGGINGS.value());
            event.accept(MCPaintballItems.RED_CHESTPLATE.value());
            event.accept(MCPaintballItems.RED_HELMET.value());
            event.accept(MCPaintballItems.GREEN_BOOTS.value());
            event.accept(MCPaintballItems.GREEN_LEGGINGS.value());
            event.accept(MCPaintballItems.GREEN_CHESTPLATE.value());
            event.accept(MCPaintballItems.GREEN_HELMET.value());
            event.accept(MCPaintballItems.BLUE_BOOTS.value());
            event.accept(MCPaintballItems.BLUE_LEGGINGS.value());
            event.accept(MCPaintballItems.BLUE_CHESTPLATE.value());
            event.accept(MCPaintballItems.BLUE_HELMET.value());
            event.accept(MCPaintballItems.YELLOW_BOOTS.value());
            event.accept(MCPaintballItems.YELLOW_LEGGINGS.value());
            event.accept(MCPaintballItems.YELLOW_CHESTPLATE.value());
            event.accept(MCPaintballItems.YELLOW_HELMET.value());
            event.accept(MCPaintballItems.PINK_BOOTS.value());
            event.accept(MCPaintballItems.PINK_LEGGINGS.value());
            event.accept(MCPaintballItems.PINK_CHESTPLATE.value());
            event.accept(MCPaintballItems.PINK_HELMET.value());
            event.accept(MCPaintballItems.ORANGE_BOOTS.value());
            event.accept(MCPaintballItems.ORANGE_LEGGINGS.value());
            event.accept(MCPaintballItems.ORANGE_CHESTPLATE.value());
            event.accept(MCPaintballItems.ORANGE_HELMET.value());
            event.accept(MCPaintballBlocks.RED_GRENADE_STATION.value());
            event.accept(MCPaintballBlocks.GREEN_GRENADE_STATION.value());
            event.accept(MCPaintballBlocks.BLUE_GRENADE_STATION.value());
            event.accept(MCPaintballBlocks.YELLOW_GRENADE_STATION.value());
            event.accept(MCPaintballBlocks.PINK_GRENADE_STATION.value());
            event.accept(MCPaintballBlocks.ORANGE_GRENADE_STATION.value());
            event.accept(MCPaintballBlocks.RED_RESPAWN_STATION.value());
            event.accept(MCPaintballBlocks.GREEN_RESPAWN_STATION.value());
            event.accept(MCPaintballBlocks.BLUE_RESPAWN_STATION.value());
            event.accept(MCPaintballBlocks.YELLOW_RESPAWN_STATION.value());
            event.accept(MCPaintballBlocks.PINK_RESPAWN_STATION.value());
            event.accept(MCPaintballBlocks.ORANGE_RESPAWN_STATION.value());
            event.accept(MCPaintballBlocks.RED_FLAG.value());
            event.accept(MCPaintballBlocks.GREEN_FLAG.value());
            event.accept(MCPaintballBlocks.BLUE_FLAG.value());
            event.accept(MCPaintballBlocks.YELLOW_FLAG.value());
            event.accept(MCPaintballBlocks.PINK_FLAG.value());
            event.accept(MCPaintballBlocks.ORANGE_FLAG.value());
            event.accept(MCPaintballBlocks.RED_DOOR.value());
            event.accept(MCPaintballBlocks.GREEN_DOOR.value());
            event.accept(MCPaintballBlocks.BLUE_DOOR.value());
            event.accept(MCPaintballBlocks.YELLOW_DOOR.value());
            event.accept(MCPaintballBlocks.PINK_DOOR.value());
            event.accept(MCPaintballBlocks.ORANGE_DOOR.value());
            event.accept(MCPaintballBlocks.CAPTURE_POINT.value());
            event.accept(MCPaintballBlocks.RED_TOWER.value());
            event.accept(MCPaintballBlocks.GREEN_TOWER.value());
            event.accept(MCPaintballBlocks.BLUE_TOWER.value());
            event.accept(MCPaintballBlocks.YELLOW_TOWER.value());
            event.accept(MCPaintballBlocks.PINK_TOWER.value());
            event.accept(MCPaintballBlocks.ORANGE_TOWER.value());
        }
    }

    @SubscribeEvent
    public static void RegisterPayloads(RegisterPayloadHandlersEvent event){
        MCPaintball.LOGGER.info("[MCPaintball] Payload Registers");
        PayloadRegistrar registrar = event.registrar("1");
        registrar.playToClient(PointSyncS2CPacket.TYPE,PointSyncS2CPacket.STREAM_CODEC);
        registrar.playToClient(DataSyncS2CPacket.TYPE,DataSyncS2CPacket.STREAM_CODEC);
        registrar.playToServer(CycleGLTypeC2SPacket.TYPE,CycleGLTypeC2SPacket.STREAM_CODEC,CycleGLTypeC2SPacket::HandlePacket);
        registrar.playToServer(TeamSelectC2SPacket.TYPE,TeamSelectC2SPacket.STREAM_CODEC,TeamSelectC2SPacket::handlePacket);
        registrar.playToServer(RoleSelectC2SPacket.TYPE,RoleSelectC2SPacket.STREAM_CODEC,RoleSelectC2SPacket::handlePacket);
    }

    @SubscribeEvent
    public static void ServerStarted(ServerStartedEvent event){
        MinecraftTeamSystem.init(event.getServer());
        MCPaintball.LOGGER.info("[MCPaintball] Attaching Server Data");
        INSTANCE = event.getServer().overworld().getDataStorage().computeIfAbsent(MCPaintballSaveData.TYPE);
        INSTANCE.setDirty(true);
        event.getServer().addTickable(() -> {
            if(Ticker == 20){
                event.getServer().getPlayerList().getPlayers().forEach(player -> PacketDistributor.sendToPlayer(player,new PointSyncS2CPacket(MCPaintballGameEvents.INSTANCE.RedPoints,MCPaintballGameEvents.INSTANCE.GreenPoints,MCPaintballGameEvents.INSTANCE.BluePoints,MCPaintballGameEvents.INSTANCE.YellowPoints,MCPaintballGameEvents.INSTANCE.PinkPoints,MCPaintballGameEvents.INSTANCE.OrangePoints,MCPaintballGameEvents.INSTANCE.MatchStarted, MCPaintballGameEvents.INSTANCE.RoundStarted)));
                Ticker = 0;
            }else{
                Ticker++;
            }
        });
    }
    @SubscribeEvent
    public static void PlayerJoined(PlayerEvent.PlayerLoggedInEvent event){
        MCPaintball.LOGGER.info("[MCPaintball] Attaching Player Data");
        if(!event.getEntity().hasData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get())){
            event.getEntity().setData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get(), new MCPaintballPlayerData());
        }
    }
    @SubscribeEvent
    public static void PlayerClone(PlayerEvent.Clone event){
        MCPaintball.LOGGER.info("[MCPaintball] Player Clone");
        if(event.isWasDeath() && event.getOriginal().hasData(MCPaintballDataAttachments.PAINTBALL_PLAYER.value())){
            event.getEntity().setData(MCPaintballDataAttachments.PAINTBALL_PLAYER.value(), event.getOriginal().getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.value()));
        }
    }

    @SubscribeEvent
    public static void RegisterCommands(RegisterCommandsEvent event){
        MCPaintball.LOGGER.info("[MCPaintball] Commands Register");
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();
        dispatcher.register(literal(Component.translatable("command.mcpaintball.prefix").getString()).then(literal(Component.translatable("command.mcpaintball.game_prefix").getString()).then(literal(Component.translatable("command.mcpaintball.start").getString()).requires(commandSourceStack -> commandSourceStack.permissions().hasPermission(Permissions.COMMANDS_MODERATOR)).executes(MCPaintballCommands::StartGame)).then(literal(Component.translatable("command.mcpaintball.stop").getString()).requires(commandSourceStack -> commandSourceStack.permissions().hasPermission(Permissions.COMMANDS_MODERATOR)).executes(MCPaintballCommands::StopGame)))).createBuilder().build();
        dispatcher.register(literal(Component.translatable("command.mcpaintball.prefix").getString()).then(literal(Component.translatable("command.mcpaintball.round_prefix").getString()).then(literal(Component.translatable("command.mcpaintball.start").getString()).requires(commandSourceStack -> commandSourceStack.permissions().hasPermission(Permissions.COMMANDS_MODERATOR)).executes(MCPaintballCommands::StartRound)).then(literal(Component.translatable("command.mcpaintball.end").getString()).requires(commandSourceStack -> commandSourceStack.permissions().hasPermission(Permissions.COMMANDS_MODERATOR)).executes(MCPaintballCommands::StopRound)).then(literal(Component.translatable("command.mcpaintball.winner").getString()).requires(commandSourceStack -> commandSourceStack.permissions().hasPermission(Permissions.COMMANDS_MODERATOR)).executes(MCPaintballCommands::RoundWinner)))).createBuilder().build();
        dispatcher.register(literal(Component.translatable("command.mcpaintball.prefix").getString()).then(literal(Component.translatable("command.mcpaintball.kit").getString()).executes(MCPaintballCommands::GiveKit))).createBuilder().build();
    }

    @EventBusSubscriber(modid = MCPaintball.MODID,value = Dist.CLIENT)
    public static class ClientEvents {
        public static final Logger CLIENT_LOGGER = LogManager.getLogger(MOD_ID + "_client");
        @SubscribeEvent
        private static void EntityRenderers(EntityRenderersEvent.RegisterRenderers event){
            CLIENT_LOGGER.info("Initializing EntityRenderers");
            EntityRenderers.register(MCPaintballEntities.RED_PAINTBALL.get(), PaintballEntityRenderer::new);
            EntityRenderers.register(MCPaintballEntities.GREEN_PAINTBALL.get(), PaintballEntityRenderer::new);
            EntityRenderers.register(MCPaintballEntities.BLUE_PAINTBALL.get(), PaintballEntityRenderer::new);
            EntityRenderers.register(MCPaintballEntities.YELLOW_PAINTBALL.get(), PaintballEntityRenderer::new);
            EntityRenderers.register(MCPaintballEntities.PINK_PAINTBALL.get(), PaintballEntityRenderer::new);
            EntityRenderers.register(MCPaintballEntities.ORANGE_PAINTBALL.get(), PaintballEntityRenderer::new);
            EntityRenderers.register(MCPaintballEntities.RED_PAINT_GRENADE.get(), PaintGrenadeEntityRenderer::new);
            EntityRenderers.register(MCPaintballEntities.GREEN_PAINT_GRENADE.get(), PaintGrenadeEntityRenderer::new);
            EntityRenderers.register(MCPaintballEntities.BLUE_PAINT_GRENADE.get(), PaintGrenadeEntityRenderer::new);
            EntityRenderers.register(MCPaintballEntities.YELLOW_PAINT_GRENADE.get(), PaintGrenadeEntityRenderer::new);
            EntityRenderers.register(MCPaintballEntities.PINK_PAINT_GRENADE.get(), PaintGrenadeEntityRenderer::new);
            EntityRenderers.register(MCPaintballEntities.ORANGE_PAINT_GRENADE.get(), PaintGrenadeEntityRenderer::new);
            EntityRenderers.register(MCPaintballEntities.SMOKE_GRENADE.get(), SmokeGrenadeEntityRenderer::new);
            EntityRenderers.register(MCPaintballEntities.EMP_GRENADE.get(), EMPGrenadeEntityRenderer::new);
            EntityRenderers.register(MCPaintballEntities.SIGHT_GRENADE.get(), SightGrenadeEntityRenderer::new);
        }

        @SubscribeEvent
        public static void ParticleRegistry(RegisterParticleProvidersEvent event){
            CLIENT_LOGGER.info("Initializing Particles");
            event.registerSpriteSet(MCPaintballParticles.RED_PAINT.get(), GlowParticle.ElectricSparkProvider::new);
            event.registerSpriteSet(MCPaintballParticles.GREEN_PAINT.get(), GlowParticle.ElectricSparkProvider::new);
            event.registerSpriteSet(MCPaintballParticles.BLUE_PAINT.get(), GlowParticle.ElectricSparkProvider::new);
            event.registerSpriteSet(MCPaintballParticles.YELLOW_PAINT.get(), GlowParticle.ElectricSparkProvider::new);
            event.registerSpriteSet(MCPaintballParticles.PINK_PAINT.get(), GlowParticle.ElectricSparkProvider::new);
            event.registerSpriteSet(MCPaintballParticles.ORANGE_PAINT.get(), GlowParticle.ElectricSparkProvider::new);
        }

        @SubscribeEvent
        public static void RegisterClientReceiver(RegisterClientPayloadHandlersEvent event){
            CLIENT_LOGGER.info("Initializing ClientReceiver Packets");
            event.register(PointSyncS2CPacket.TYPE,PointSyncS2CPacket::HandlePacket);
            event.register(DataSyncS2CPacket.TYPE,DataSyncS2CPacket::HandlePacket);
        }
        @SubscribeEvent
        public static void PostClientTick(ClientTickEvent.Post event){
            while(MCPaintballKeybindings.CYCLE_GRENADE_LAUNCHER_TYPE.consumeClick()){
                Player player = Minecraft.getInstance().player;
                ItemStack held = Objects.requireNonNull(player).getMainHandItem();
                if(held.getItem() == MCPaintballItems.GRENADE_LAUNCHER.value()){
                    int Setting = Objects.requireNonNull(held.get(MCPaintballDataComponents.SETTING.get())).Setting();
                    ClientPacketDistributor.sendToServer(new CycleGLTypeC2SPacket(Setting));
                }
            }
            while (MCPaintballKeybindings.SELECT_ROLE.consumeClick()){
                Minecraft mc = Minecraft.getInstance();
                Screen screen = mc.screen;
                mc.setScreen(new SelectRoleScreen(screen));
            }
            while (MCPaintballKeybindings.SELECT_TEAM.consumeClick()){
                Minecraft mc = Minecraft.getInstance();
                Screen screen = mc.screen;
                mc.setScreen(new SelectTeamScreen(screen));
            }
        }

        @SubscribeEvent
        public static void RegisterKeyMappings(RegisterKeyMappingsEvent event){
            CLIENT_LOGGER.info("Initializing Keybindings");
            event.registerCategory(MCPaintballKeybindings.CATEGORY);
            event.registerCategory(MCPaintballKeybindings.CATEGORY_CONFIG);
            event.register(MCPaintballKeybindings.CYCLE_GRENADE_LAUNCHER_TYPE);
            event.register(MCPaintballKeybindings.SELECT_ROLE);
            event.register(MCPaintballKeybindings.SELECT_TEAM);
        }

        @SubscribeEvent
        public static void RegGuiLayers(RegisterGuiLayersEvent event){
            CLIENT_LOGGER.info("Initializing Overlay");
            event.registerAbove(VanillaGuiLayers.CHAT, Identifier.fromNamespaceAndPath(MCPaintball.MODID,"paintball_overlay"),new PaintballDataOverlay());
        }

    }
}
