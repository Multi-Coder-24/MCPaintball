package org.multicoder.mcpaintball.common.event;


import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.capability.PaintballPlayer;
import org.multicoder.mcpaintball.common.capability.PaintballPlayerProvider;
import org.multicoder.mcpaintball.common.command.*;
import org.multicoder.mcpaintball.common.network.Networking;
import org.multicoder.mcpaintball.common.network.packets.TeamDataSyncS2CPacket;
import org.multicoder.mcpaintball.common.util.enums.KitType;
import org.multicoder.mcpaintball.common.util.enums.Teams;
import org.multicoder.mcpaintball.util.ErrorLogGenerator;

@SuppressWarnings("all")
@Mod.EventBusSubscriber(modid = MCPaintball.MOD_ID)
public class MCPaintballEvents {
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event)
    {
        try{
            if (event.getObject() instanceof Player) {
                if (!event.getObject().getCapability(PaintballPlayerProvider.CAPABILITY).isPresent()) {
                    event.addCapability(new ResourceLocation(MCPaintball.MOD_ID, "team"), new PaintballPlayerProvider());
                    Player player = (Player) event.getObject();
                    event.getObject().getCapability(PaintballPlayerProvider.CAPABILITY).ifPresent(cap ->
                    {
                        cap.Team = Teams.NONE;
                        cap.ClassType = KitType.NONE;
                        cap.Points = 0;
                        cap.LoadoutCode = "00";
                    });
                }
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

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event)
    {
        try{
            event.register(PaintballPlayer.class);
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

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event)
    {
        try{
            if (event.isWasDeath()) {
                event.getOriginal().reviveCaps();
                event.getOriginal().getCapability(PaintballPlayerProvider.CAPABILITY).ifPresent(oldStore ->
                {
                    event.getEntity().getCapability(PaintballPlayerProvider.CAPABILITY).ifPresent(newStore ->
                    {
                        newStore.copyFrom(oldStore);
                        event.getOriginal().invalidateCaps();
                    });
                });
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

    @SubscribeEvent
    public static void onCommandRegister(RegisterCommandsEvent event)
    {
        try{
            PointTestCommand.Regsiter(event.getDispatcher());
            WinningTeamCommand.Register(event.getDispatcher());
            SetTeamCommand.RegisterCommand(event.getDispatcher());
            SetClassCommand.RegisterCommand(event.getDispatcher());
            GiveKitCommand.RegisterCommand(event.getDispatcher());
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


    @SubscribeEvent
    public static void PlayerTick(TickEvent.PlayerTickEvent event)
    {
        try{
            if (event.side == LogicalSide.SERVER && event.player.isAlive()) {
                PaintballPlayer PPlayer = event.player.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get();
                Networking.sendToPlayer(new TeamDataSyncS2CPacket(PPlayer.GetTeam(), PPlayer.GetClass(), PPlayer.GetPoints(), PPlayer.GetCode()), (ServerPlayer) event.player);
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

    @SubscribeEvent
    public static void PlayerJoin(EntityJoinLevelEvent event)
    {
        try{
            if (!event.getLevel().isClientSide()) {
                if (event.getEntity() instanceof ServerPlayer player) {
                    PaintballPlayer PPlayer = player.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get();
                    Networking.sendToPlayer(new TeamDataSyncS2CPacket(PPlayer.Team, PPlayer.ClassType, PPlayer.Points, PPlayer.GetCode()), player);
                }
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
