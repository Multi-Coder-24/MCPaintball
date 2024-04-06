package org.multicoder.mcpaintball.event;


import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.capability.PlayerTeamCapability;
import org.multicoder.mcpaintball.capability.PlayerTeamCapabilityProvider;
import org.multicoder.mcpaintball.command.TeamCheckCommand;
import org.multicoder.mcpaintball.command.TeamSetCommand;
import org.multicoder.mcpaintball.network.Networking;
import org.multicoder.mcpaintball.network.packets.ReloadC2SPacket;
import org.multicoder.mcpaintball.util.MCPaintballUtilities;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = MCPaintball.MODID)
public class MCPaintballEvents
{
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof Player) {
            if(!event.getObject().getCapability(PlayerTeamCapabilityProvider.CAPABILITY).isPresent()) {
                event.addCapability(new ResourceLocation(MCPaintball.MODID, "team"), new PlayerTeamCapabilityProvider());
            }
        }
    }
    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event)
    {
        event.register(PlayerTeamCapability.class);
    }
    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if(event.isWasDeath())
        {
            event.getOriginal().reviveCaps();
            event.getOriginal().getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(oldStore -> {
                event.getEntity().getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(newStore -> {
                    newStore.CopyFrom(oldStore);
                    event.getOriginal().invalidateCaps();
                });
            });
        }
    }

    @SubscribeEvent
    public static void onPlayerJoined(PlayerEvent.PlayerLoggedInEvent event)
    {
        Player p = event.getPlayer();
        p.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
            if(cap.GetClass() == null || Objects.equals(cap.GetClass(), ""))
            {
                cap.SetClass("None");
            }
        });
    }

    @SubscribeEvent
    public static void onCommandRegister(RegisterCommandsEvent event)
    {
        TeamCheckCommand.register(event.getDispatcher());
        TeamSetCommand.register(event.getDispatcher());
    }
    @Mod.EventBusSubscriber(modid = MCPaintball.MODID,value = Dist.CLIENT)
    public static class ForgeClientEvents
    {
        @SubscribeEvent
        public static void OnKeyPressed(InputEvent.KeyInputEvent key)
        {
            if(MCPaintballUtilities.Keybindings.RELOAD.consumeClick())
            {
                Networking.SendToServer(new ReloadC2SPacket());
            }
        }

    }
    @Mod.EventBusSubscriber(modid = MCPaintball.MODID,bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
    public static class ModClientEvents
    {
        @SubscribeEvent
        public static void onKeyRegister(FMLClientSetupEvent event)
        {
            ClientRegistry.registerKeyBinding(MCPaintballUtilities.Keybindings.RELOAD);
        }
    }
}
