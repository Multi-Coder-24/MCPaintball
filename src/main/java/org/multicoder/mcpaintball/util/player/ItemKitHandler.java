package org.multicoder.mcpaintball.util.player;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.capability.PlayerTeamCapabilityProvider;
import org.multicoder.mcpaintball.init.blockinit;
import org.multicoder.mcpaintball.init.iteminit;
import org.multicoder.mcpaintball.network.Networking;
import org.multicoder.mcpaintball.network.packets.TeamUpdateS2CPacket;
import org.multicoder.mcpaintball.util.KitType;
import org.multicoder.mcpaintball.util.Teams;

public class ItemKitHandler
{
    public static void checkAndApply(Teams Team, ServerPlayer player, KitType type)
    {
        MCPaintball.LOG.info("Check And Apply");
        switch(Team)
        {
            case NONE -> {
                MCPaintball.LOG.info("No Team Found");
                player.displayClientMessage(new TranslatableComponent("text.mcpaintball.invalid_team"),true);
                return;
            }
            case RED ->
            {
                MCPaintball.LOG.info("Red Team");
                Helper.SetRedTeam(type,player);
                return;
            }
            case BLUE -> {
                MCPaintball.LOG.info("Blue Team");
                Helper.SetBlueTeam(type,player);
                return;
            }
            case GREEN -> {
                MCPaintball.LOG.info("Green Team");
                Helper.SetGreenTeam(type,player);
                return;
            }
            case LIME -> {
                MCPaintball.LOG.info("Lime Team");
                Helper.SetLimeTeam(type,player);
                return;
            }
            case PURPLE -> {
                MCPaintball.LOG.info("Purple Team");
                Helper.SetPurpleTeam(type,player);
                return;
            }
            case PINK -> {
                MCPaintball.LOG.info("Pink Team");
                Helper.SetPinkTeam(type,player);
                return;
            }
            case MAGENTA -> {
                MCPaintball.LOG.info("Magenta Team");
                Helper.SetMagentaTeam(type,player);
                return;
            }
            case LIGHT_BLUE -> {
                MCPaintball.LOG.info("Light Blue Team");
                Helper.SetLightBlueTeam(type,player);
                return;
            }
        }
        return;
    }

    private static class Helper
    {
        public static void SetRedTeam(KitType type, ServerPlayer Player)
        {
            MCPaintball.LOG.info("Red Team Apply");
            switch(type)
            {
                case NONE -> {
                    MCPaintball.LOG.info("No Kit");
                    Player.displayClientMessage(new TranslatableComponent("text.mcpaintball.invalid_kit"),true);}
                case STANDARD ->
                {
                    MCPaintball.LOG.info("Standard Kit");
                    Player.drop(new ItemStack(iteminit.RED_BOOTS.get()), true);
                    Player.drop(new ItemStack(iteminit.RED_LEGGINGS.get()), true);
                    Player.drop(new ItemStack(iteminit.RED_CHESTPLATE.get()), true);
                    Player.drop(new ItemStack(iteminit.RED_HELMET.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_RIFLE.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()), true);
                    Player.drop(new ItemStack(blockinit.RED_EXPLOSIVE_STATION.get(),4),true);
                    Player.drop(new ItemStack(iteminit.RED_REMOTE.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),48),true);
                    Player.drop(new ItemStack(iteminit.RED_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.RED_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.drop(new ItemStack(blockinit.RED_AMMO_POD_BASIC.get(),8),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetTeam(1);
                        cap.SetClass("Standard");
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(1,"Standard"),Player);});
                }
                case MEDICAL ->
                {
                    MCPaintball.LOG.info("Medical Kit");
                    Player.drop(new ItemStack(iteminit.RED_BOOTS.get()), true);
                    Player.drop(new ItemStack(iteminit.RED_LEGGINGS.get()), true);
                    Player.drop(new ItemStack(iteminit.RED_CHESTPLATE.get()), true);
                    Player.drop(new ItemStack(iteminit.RED_HELMET.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_SHOTGUN.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()), true);
                    Player.drop(new ItemStack(iteminit.RED_REMOTE.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),32),true);
                    Player.drop(new ItemStack(iteminit.RED_MED_KIT.get(),32),true);
                    Player.drop(new ItemStack(iteminit.RED_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.RED_AMMO_SHELL.get(),64),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetTeam(1);
                        cap.SetClass("Medic");
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(1,"Medic"),Player);
                    });
                }
                case HEAVY ->
                {
                    MCPaintball.LOG.info("Heavy Kit");
                    Player.drop(new ItemStack(iteminit.RED_BOOTS.get()), true);
                    Player.drop(new ItemStack(iteminit.RED_LEGGINGS.get()), true);
                    Player.drop(new ItemStack(iteminit.RED_CHESTPLATE.get()), true);
                    Player.drop(new ItemStack(iteminit.RED_HELMET.get()), true);
                    Player.drop(new ItemStack(blockinit.RED_EXPLOSIVE_STATION.get(),12),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_BAZOOKA.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()), true);
                    Player.drop(new ItemStack(blockinit.RED_EXPLOSIVE.get(), 16), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),24),true);
                    Player.drop(new ItemStack(iteminit.RED_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.RED_AMMO_HEAVY.get(),64),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetTeam(1);
                        cap.SetClass("Heavy");
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(1,"Heavy"),Player);
                    });
                }
                case TRAINEE ->
                {
                    MCPaintball.LOG.info("Trainee Kit");
                    Player.drop(new ItemStack(iteminit.RED_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.RED_AMMO_HEAVY.get(),64),true);
                    Player.drop(new ItemStack(iteminit.RED_AMMO_SHELL.get(),64),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),64),true);
                    Player.drop(new ItemStack(iteminit.RED_BOOTS.get()),true);
                    Player.drop(new ItemStack(blockinit.RED_EXPLOSIVE_STATION.get(),12),true);
                    Player.drop(new ItemStack(iteminit.RED_HELMET.get()),true);
                    Player.drop(new ItemStack(iteminit.RED_CHESTPLATE.get()),true);
                    Player.drop(new ItemStack(iteminit.RED_LEGGINGS.get()),true);
                    Player.drop(new ItemStack(iteminit.RED_REMOTE.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_RIFLE.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_SHOTGUN.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_BAZOOKA.get()),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.drop(new ItemStack(iteminit.RED_MED_KIT.get(),4),true);
                    Player.drop(new ItemStack(blockinit.RED_EXPLOSIVE.get(),4),true);
                    Player.drop(new ItemStack(blockinit.RED_AMMO_POD_BASIC.get(),4),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetClass("Trainee");
                        cap.SetTeam(1);
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(1,"Trainee"), Player);
                    });
                }
            }
            return;
        }

        public static void SetBlueTeam(KitType type, ServerPlayer Player)
        {
            switch(type){
                case NONE -> {Player.displayClientMessage(new TranslatableComponent("text.mcpaintball.invalid_kit"),true);}
                case STANDARD ->
                {
                    Player.drop(new ItemStack(iteminit.BLUE_BOOTS.get()), true);
                    Player.drop(new ItemStack(iteminit.BLUE_LEGGINGS.get()), true);
                    Player.drop(new ItemStack(iteminit.BLUE_CHESTPLATE.get()), true);
                    Player.drop(new ItemStack(iteminit.BLUE_HELMET.get()), true);
                    Player.drop(new ItemStack(blockinit.BLUE_EXPLOSIVE_STATION.get(),4),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_RIFLE.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()), true);
                    Player.drop(new ItemStack(iteminit.BLUE_REMOTE.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),48),true);
                    Player.drop(new ItemStack(iteminit.BLUE_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.BLUE_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.drop(new ItemStack(blockinit.BLUE_AMMO_POD_BASIC.get(),8),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetTeam(3);
                        cap.SetClass("Standard");
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(3,"Standard"),Player);});
                }
                case MEDICAL -> {
                    Player.drop(new ItemStack(iteminit.BLUE_BOOTS.get()), true);
                    Player.drop(new ItemStack(iteminit.BLUE_LEGGINGS.get()), true);
                    Player.drop(new ItemStack(iteminit.BLUE_CHESTPLATE.get()), true);
                    Player.drop(new ItemStack(iteminit.BLUE_HELMET.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_SHOTGUN.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()), true);
                    Player.drop(new ItemStack(iteminit.BLUE_REMOTE.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),32),true);
                    Player.drop(new ItemStack(iteminit.BLUE_MED_KIT.get(),32),true);
                    Player.drop(new ItemStack(iteminit.BLUE_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.BLUE_AMMO_SHELL.get(),64),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetTeam(3);
                        cap.SetClass("Medic");
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(3,"Medic"),Player);
                    });
                }
                case HEAVY -> {
                    Player.drop(new ItemStack(iteminit.BLUE_BOOTS.get()), true);
                    Player.drop(new ItemStack(iteminit.BLUE_LEGGINGS.get()), true);
                    Player.drop(new ItemStack(iteminit.BLUE_CHESTPLATE.get()), true);
                    Player.drop(new ItemStack(iteminit.BLUE_HELMET.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_BAZOOKA.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()), true);
                    Player.drop(new ItemStack(blockinit.BLUE_EXPLOSIVE_STATION.get(),12),true);
                    Player.drop(new ItemStack(blockinit.BLUE_EXPLOSIVE.get(), 16), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),24),true);
                    Player.drop(new ItemStack(iteminit.BLUE_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.BLUE_AMMO_HEAVY.get(),64),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetTeam(3);
                        cap.SetClass("Heavy");
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(3,"Heavy"),Player);
                    });
                }
                case TRAINEE -> {
                    Player.drop(new ItemStack(iteminit.BLUE_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.BLUE_AMMO_HEAVY.get(),64),true);
                    Player.drop(new ItemStack(iteminit.BLUE_AMMO_SHELL.get(),64),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),64),true);
                    Player.drop(new ItemStack(iteminit.BLUE_BOOTS.get()),true);
                    Player.drop(new ItemStack(iteminit.BLUE_HELMET.get()),true);
                    Player.drop(new ItemStack(iteminit.BLUE_CHESTPLATE.get()),true);
                    Player.drop(new ItemStack(iteminit.BLUE_LEGGINGS.get()),true);
                    Player.drop(new ItemStack(blockinit.BLUE_EXPLOSIVE_STATION.get(),12),true);
                    Player.drop(new ItemStack(iteminit.BLUE_REMOTE.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_RIFLE.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_SHOTGUN.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_BAZOOKA.get()),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.drop(new ItemStack(iteminit.BLUE_MED_KIT.get(),4),true);
                    Player.drop(new ItemStack(blockinit.BLUE_EXPLOSIVE.get(),4),true);
                    Player.drop(new ItemStack(blockinit.BLUE_AMMO_POD_BASIC.get(),4),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetClass("Trainee");
                        cap.SetTeam(3);
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(3,"Trainee"), Player);
                    });
                }
            }
            return;
        }

        public static void SetGreenTeam(KitType type, ServerPlayer Player)
        {
            switch(type){
                case NONE -> {Player.displayClientMessage(new TranslatableComponent("text.mcpaintball.invalid_kit"),true);}
                case STANDARD ->
                {
                    Player.drop(new ItemStack(iteminit.GREEN_BOOTS.get()), true);
                    Player.drop(new ItemStack(iteminit.GREEN_LEGGINGS.get()), true);
                    Player.drop(new ItemStack(iteminit.GREEN_CHESTPLATE.get()), true);
                    Player.drop(new ItemStack(iteminit.GREEN_HELMET.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_RIFLE.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()), true);
                    Player.drop(new ItemStack(blockinit.GREEN_EXPLOSIVE_STATION.get(),4),true);
                    Player.drop(new ItemStack(iteminit.GREEN_REMOTE.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),48),true);
                    Player.drop(new ItemStack(iteminit.GREEN_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.GREEN_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.drop(new ItemStack(blockinit.GREEN_AMMO_POD_BASIC.get(),8),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetTeam(2);
                        cap.SetClass("Standard");
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(2,"Standard"),Player);});
                }
                case MEDICAL -> {
                    Player.drop(new ItemStack(iteminit.GREEN_BOOTS.get()), true);
                    Player.drop(new ItemStack(iteminit.GREEN_LEGGINGS.get()), true);
                    Player.drop(new ItemStack(iteminit.GREEN_CHESTPLATE.get()), true);
                    Player.drop(new ItemStack(iteminit.GREEN_HELMET.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_SHOTGUN.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()), true);
                    Player.drop(new ItemStack(iteminit.GREEN_REMOTE.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),32),true);
                    Player.drop(new ItemStack(iteminit.GREEN_MED_KIT.get(),32),true);
                    Player.drop(new ItemStack(iteminit.GREEN_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.GREEN_AMMO_SHELL.get(),64),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetTeam(2);
                        cap.SetClass("Medic");
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(2,"Medic"),Player);
                    });
                }
                case HEAVY -> {
                    Player.drop(new ItemStack(iteminit.GREEN_BOOTS.get()), true);
                    Player.drop(new ItemStack(iteminit.GREEN_LEGGINGS.get()), true);
                    Player.drop(new ItemStack(iteminit.GREEN_CHESTPLATE.get()), true);
                    Player.drop(new ItemStack(iteminit.GREEN_HELMET.get()), true);
                    Player.drop(new ItemStack(blockinit.GREEN_EXPLOSIVE_STATION.get(),12),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_BAZOOKA.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()), true);
                    Player.drop(new ItemStack(blockinit.GREEN_EXPLOSIVE.get(), 16), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),24),true);
                    Player.drop(new ItemStack(iteminit.GREEN_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.GREEN_AMMO_HEAVY.get(),64),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetTeam(2);
                        cap.SetClass("Heavy");
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(2,"Heavy"),Player);
                    });
                }
                case TRAINEE -> {
                    Player.drop(new ItemStack(iteminit.GREEN_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.GREEN_AMMO_HEAVY.get(),64),true);
                    Player.drop(new ItemStack(iteminit.GREEN_AMMO_SHELL.get(),64),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),64),true);
                    Player.drop(new ItemStack(iteminit.GREEN_BOOTS.get()),true);
                    Player.drop(new ItemStack(iteminit.GREEN_HELMET.get()),true);
                    Player.drop(new ItemStack(iteminit.GREEN_CHESTPLATE.get()),true);
                    Player.drop(new ItemStack(blockinit.GREEN_EXPLOSIVE_STATION.get(),12),true);
                    Player.drop(new ItemStack(iteminit.GREEN_LEGGINGS.get()),true);
                    Player.drop(new ItemStack(iteminit.GREEN_REMOTE.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_RIFLE.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_SHOTGUN.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_BAZOOKA.get()),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.drop(new ItemStack(iteminit.GREEN_MED_KIT.get(),4),true);
                    Player.drop(new ItemStack(blockinit.GREEN_EXPLOSIVE.get(),4),true);
                    Player.drop(new ItemStack(blockinit.GREEN_AMMO_POD_BASIC.get(),4),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetClass("Trainee");
                        cap.SetTeam(2);
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(2,"Trainee"), Player);
                    });
                }
            }
            return;
        }

        public static void SetLimeTeam(KitType type, ServerPlayer Player)
        {
            switch(type){
                case NONE -> {Player.displayClientMessage(new TranslatableComponent("text.mcpaintball.invalid_kit"),true);}
                case STANDARD ->
                {
                    Player.drop(new ItemStack(iteminit.LIME_BOOTS.get()), true);
                    Player.drop(new ItemStack(iteminit.LIME_LEGGINGS.get()), true);
                    Player.drop(new ItemStack(iteminit.LIME_CHESTPLATE.get()), true);
                    Player.drop(new ItemStack(iteminit.LIME_HELMET.get()), true);
                    Player.drop(new ItemStack(blockinit.LIME_EXPLOSIVE_STATION.get(),4),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_RIFLE.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()), true);
                    Player.drop(new ItemStack(iteminit.LIME_REMOTE.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),48),true);
                    Player.drop(new ItemStack(iteminit.LIME_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.LIME_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.drop(new ItemStack(blockinit.LIME_AMMO_POD_BASIC.get(),8),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetTeam(7);
                        cap.SetClass("Standard");
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(7,"Standard"),Player);});
                }
                case MEDICAL -> {
                    Player.drop(new ItemStack(iteminit.LIME_BOOTS.get()), true);
                    Player.drop(new ItemStack(iteminit.LIME_LEGGINGS.get()), true);
                    Player.drop(new ItemStack(iteminit.LIME_CHESTPLATE.get()), true);
                    Player.drop(new ItemStack(iteminit.LIME_HELMET.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_SHOTGUN.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()), true);
                    Player.drop(new ItemStack(iteminit.LIME_REMOTE.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),32),true);
                    Player.drop(new ItemStack(iteminit.LIME_MED_KIT.get(),32),true);
                    Player.drop(new ItemStack(iteminit.LIME_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.LIME_AMMO_SHELL.get(),64),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetTeam(7);
                        cap.SetClass("Medic");
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(7,"Medic"),Player);
                    });
                }
                case HEAVY -> {
                    Player.drop(new ItemStack(iteminit.LIME_BOOTS.get()), true);
                    Player.drop(new ItemStack(iteminit.LIME_LEGGINGS.get()), true);
                    Player.drop(new ItemStack(iteminit.LIME_CHESTPLATE.get()), true);
                    Player.drop(new ItemStack(iteminit.LIME_HELMET.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_BAZOOKA.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()), true);
                    Player.drop(new ItemStack(blockinit.LIME_EXPLOSIVE_STATION.get(),12),true);
                    Player.drop(new ItemStack(blockinit.LIME_EXPLOSIVE.get(), 16), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),24),true);
                    Player.drop(new ItemStack(iteminit.LIME_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.LIME_AMMO_HEAVY.get(),64),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetTeam(7);
                        cap.SetClass("Heavy");
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(7,"Heavy"),Player);
                    });
                }
                case TRAINEE -> {
                    Player.drop(new ItemStack(iteminit.LIME_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.LIME_AMMO_HEAVY.get(),64),true);
                    Player.drop(new ItemStack(iteminit.LIME_AMMO_SHELL.get(),64),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),64),true);
                    Player.drop(new ItemStack(iteminit.LIME_BOOTS.get()),true);
                    Player.drop(new ItemStack(iteminit.LIME_HELMET.get()),true);
                    Player.drop(new ItemStack(iteminit.LIME_CHESTPLATE.get()),true);
                    Player.drop(new ItemStack(iteminit.LIME_LEGGINGS.get()),true);
                    Player.drop(new ItemStack(iteminit.LIME_REMOTE.get()),true);
                    Player.drop(new ItemStack(blockinit.LIME_EXPLOSIVE_STATION.get(),12),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_RIFLE.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_SHOTGUN.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_BAZOOKA.get()),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.drop(new ItemStack(iteminit.LIME_MED_KIT.get(),4),true);
                    Player.drop(new ItemStack(blockinit.LIME_EXPLOSIVE.get(),4),true);
                    Player.drop(new ItemStack(blockinit.LIME_AMMO_POD_BASIC.get(),4),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetClass("Trainee");
                        cap.SetTeam(7);
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(7,"Trainee"), Player);
                    });
                }
            }
            return;
        }

        public static void SetPinkTeam(KitType type, ServerPlayer Player)
        {
            switch(type){
                case NONE -> {Player.displayClientMessage(new TranslatableComponent("text.mcpaintball.invalid_kit"),true);}
                case STANDARD ->
                {
                    Player.drop(new ItemStack(iteminit.PINK_BOOTS.get()), true);
                    Player.drop(new ItemStack(iteminit.PINK_LEGGINGS.get()), true);
                    Player.drop(new ItemStack(iteminit.PINK_CHESTPLATE.get()), true);
                    Player.drop(new ItemStack(iteminit.PINK_HELMET.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_RIFLE.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()), true);
                    Player.drop(new ItemStack(blockinit.PINK_EXPLOSIVE_STATION.get(),4),true);
                    Player.drop(new ItemStack(iteminit.PINK_REMOTE.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),48),true);
                    Player.drop(new ItemStack(iteminit.PINK_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.PINK_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.drop(new ItemStack(blockinit.PINK_AMMO_POD_BASIC.get(),8),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetTeam(5);
                        cap.SetClass("Standard");
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(5,"Standard"),Player);});
                }
                case MEDICAL -> {
                    Player.drop(new ItemStack(iteminit.PINK_BOOTS.get()), true);
                    Player.drop(new ItemStack(iteminit.PINK_LEGGINGS.get()), true);
                    Player.drop(new ItemStack(iteminit.PINK_CHESTPLATE.get()), true);
                    Player.drop(new ItemStack(iteminit.PINK_HELMET.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_SHOTGUN.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()), true);
                    Player.drop(new ItemStack(iteminit.PINK_REMOTE.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),32),true);
                    Player.drop(new ItemStack(iteminit.PINK_MED_KIT.get(),32),true);
                    Player.drop(new ItemStack(iteminit.PINK_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.PINK_AMMO_SHELL.get(),64),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetTeam(5);
                        cap.SetClass("Medic");
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(5,"Medic"),Player);
                    });
                }
                case HEAVY -> {
                    Player.drop(new ItemStack(iteminit.PINK_BOOTS.get()), true);
                    Player.drop(new ItemStack(iteminit.PINK_LEGGINGS.get()), true);
                    Player.drop(new ItemStack(iteminit.PINK_CHESTPLATE.get()), true);
                    Player.drop(new ItemStack(iteminit.PINK_HELMET.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_BAZOOKA.get()), true);
                    Player.drop(new ItemStack(blockinit.PINK_EXPLOSIVE_STATION.get(),12),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()), true);
                    Player.drop(new ItemStack(blockinit.PINK_EXPLOSIVE.get(), 16), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),24),true);
                    Player.drop(new ItemStack(iteminit.PINK_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.PINK_AMMO_HEAVY.get(),64),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetTeam(5);
                        cap.SetClass("Heavy");
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(5,"Heavy"),Player);
                    });
                }
                case TRAINEE -> {
                    Player.drop(new ItemStack(iteminit.PINK_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.PINK_AMMO_HEAVY.get(),64),true);
                    Player.drop(new ItemStack(iteminit.PINK_AMMO_SHELL.get(),64),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),64),true);
                    Player.drop(new ItemStack(iteminit.PINK_BOOTS.get()),true);
                    Player.drop(new ItemStack(iteminit.PINK_HELMET.get()),true);
                    Player.drop(new ItemStack(iteminit.PINK_CHESTPLATE.get()),true);
                    Player.drop(new ItemStack(iteminit.PINK_LEGGINGS.get()),true);
                    Player.drop(new ItemStack(blockinit.PINK_EXPLOSIVE_STATION.get(),12),true);
                    Player.drop(new ItemStack(iteminit.PINK_REMOTE.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_RIFLE.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_SHOTGUN.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_BAZOOKA.get()),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.drop(new ItemStack(iteminit.PINK_MED_KIT.get(),4),true);
                    Player.drop(new ItemStack(blockinit.PINK_EXPLOSIVE.get(),4),true);
                    Player.drop(new ItemStack(blockinit.PINK_AMMO_POD_BASIC.get(),4),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetClass("Trainee");
                        cap.SetTeam(5);
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(5,"Trainee"), Player);
                    });
                }
            }
            return;
        }

        public static void SetMagentaTeam(KitType type, ServerPlayer Player)
        {
            switch(type){
                case NONE -> {Player.displayClientMessage(new TranslatableComponent("text.mcpaintball.invalid_kit"),true);}
                case STANDARD ->
                {
                    Player.drop(new ItemStack(iteminit.MAGENTA_BOOTS.get()), true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_LEGGINGS.get()), true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_CHESTPLATE.get()), true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_HELMET.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_RIFLE.get()), true);
                    Player.drop(new ItemStack(blockinit.MAGENTA_EXPLOSIVE_STATION.get(),4),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()), true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_REMOTE.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),48),true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.drop(new ItemStack(blockinit.MAGENTA_AMMO_POD_BASIC.get(),8),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetTeam(4);
                        cap.SetClass("Standard");
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(4,"Standard"),Player);});
                }
                case MEDICAL -> {
                    Player.drop(new ItemStack(iteminit.MAGENTA_BOOTS.get()), true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_LEGGINGS.get()), true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_CHESTPLATE.get()), true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_HELMET.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_SHOTGUN.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()), true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_REMOTE.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),32),true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_MED_KIT.get(),32),true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_AMMO_SHELL.get(),64),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetTeam(4);
                        cap.SetClass("Medic");
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(4,"Medic"),Player);
                    });
                }
                case HEAVY -> {
                    Player.drop(new ItemStack(iteminit.MAGENTA_BOOTS.get()), true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_LEGGINGS.get()), true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_CHESTPLATE.get()), true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_HELMET.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_BAZOOKA.get()), true);
                    Player.drop(new ItemStack(blockinit.MAGENTA_EXPLOSIVE_STATION.get(),12),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()), true);
                    Player.drop(new ItemStack(blockinit.MAGENTA_EXPLOSIVE.get(), 16), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),24),true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_AMMO_HEAVY.get(),64),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetTeam(4);
                        cap.SetClass("Heavy");
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(4,"Heavy"),Player);
                    });
                }
                case TRAINEE -> {
                    Player.drop(new ItemStack(iteminit.MAGENTA_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_AMMO_HEAVY.get(),64),true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_AMMO_SHELL.get(),64),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),64),true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_BOOTS.get()),true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_HELMET.get()),true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_CHESTPLATE.get()),true);
                    Player.drop(new ItemStack(blockinit.MAGENTA_EXPLOSIVE_STATION.get(),12),true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_LEGGINGS.get()),true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_REMOTE.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_RIFLE.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_SHOTGUN.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_BAZOOKA.get()),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_MED_KIT.get(),4),true);
                    Player.drop(new ItemStack(blockinit.MAGENTA_EXPLOSIVE.get(),4),true);
                    Player.drop(new ItemStack(blockinit.MAGENTA_AMMO_POD_BASIC.get(),4),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetClass("Trainee");
                        cap.SetTeam(4);
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(4,"Trainee"), Player);
                    });
                }
            }
            return;
        }

        public static void SetPurpleTeam(KitType type, ServerPlayer Player)
        {
            switch(type){
                case NONE -> {Player.displayClientMessage(new TranslatableComponent("text.mcpaintball.invalid_kit"),true);}
                case STANDARD ->
                {
                    Player.drop(new ItemStack(iteminit.PURPLE_BOOTS.get()), true);
                    Player.drop(new ItemStack(iteminit.PURPLE_LEGGINGS.get()), true);
                    Player.drop(new ItemStack(iteminit.PURPLE_CHESTPLATE.get()), true);
                    Player.drop(new ItemStack(iteminit.PURPLE_HELMET.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_RIFLE.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()), true);
                    Player.drop(new ItemStack(iteminit.PURPLE_REMOTE.get()), true);
                    Player.drop(new ItemStack(blockinit.PURPLE_EXPLOSIVE_STATION.get(),4),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),48),true);
                    Player.drop(new ItemStack(iteminit.PURPLE_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.PURPLE_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.drop(new ItemStack(blockinit.PURPLE_AMMO_POD_BASIC.get(),8),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetTeam(6);
                        cap.SetClass("Standard");
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(6,"Standard"),Player);});
                }
                case MEDICAL -> {
                    Player.drop(new ItemStack(iteminit.PURPLE_BOOTS.get()), true);
                    Player.drop(new ItemStack(iteminit.PURPLE_LEGGINGS.get()), true);
                    Player.drop(new ItemStack(iteminit.PURPLE_CHESTPLATE.get()), true);
                    Player.drop(new ItemStack(iteminit.PURPLE_HELMET.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_SHOTGUN.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()), true);
                    Player.drop(new ItemStack(iteminit.PURPLE_REMOTE.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),32),true);
                    Player.drop(new ItemStack(iteminit.PURPLE_MED_KIT.get(),32),true);
                    Player.drop(new ItemStack(iteminit.PURPLE_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.PURPLE_AMMO_SHELL.get(),64),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetTeam(6);
                        cap.SetClass("Medic");
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(6,"Medic"),Player);
                    });
                }
                case HEAVY -> {
                    Player.drop(new ItemStack(iteminit.PURPLE_BOOTS.get()), true);
                    Player.drop(new ItemStack(iteminit.PURPLE_LEGGINGS.get()), true);
                    Player.drop(new ItemStack(iteminit.PURPLE_CHESTPLATE.get()), true);
                    Player.drop(new ItemStack(iteminit.PURPLE_HELMET.get()), true);
                    Player.drop(new ItemStack(blockinit.PURPLE_EXPLOSIVE_STATION.get(),12),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_BAZOOKA.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()), true);
                    Player.drop(new ItemStack(blockinit.PURPLE_EXPLOSIVE.get(), 16), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),24),true);
                    Player.drop(new ItemStack(iteminit.PURPLE_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.PURPLE_AMMO_HEAVY.get(),64),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetTeam(6);
                        cap.SetClass("Heavy");
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(6,"Heavy"),Player);
                    });
                }
                case TRAINEE -> {
                    Player.drop(new ItemStack(iteminit.PURPLE_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.PURPLE_AMMO_HEAVY.get(),64),true);
                    Player.drop(new ItemStack(iteminit.PURPLE_AMMO_SHELL.get(),64),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),64),true);
                    Player.drop(new ItemStack(iteminit.PURPLE_BOOTS.get()),true);
                    Player.drop(new ItemStack(iteminit.PURPLE_HELMET.get()),true);
                    Player.drop(new ItemStack(iteminit.PURPLE_CHESTPLATE.get()),true);
                    Player.drop(new ItemStack(iteminit.PURPLE_LEGGINGS.get()),true);
                    Player.drop(new ItemStack(iteminit.PURPLE_REMOTE.get()),true);
                    Player.drop(new ItemStack(blockinit.PURPLE_EXPLOSIVE_STATION.get(),12),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_RIFLE.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_SHOTGUN.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_BAZOOKA.get()),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.drop(new ItemStack(iteminit.PURPLE_MED_KIT.get(),4),true);
                    Player.drop(new ItemStack(blockinit.PURPLE_EXPLOSIVE.get(),4),true);
                    Player.drop(new ItemStack(blockinit.PURPLE_AMMO_POD_BASIC.get(),4),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetClass("Trainee");
                        cap.SetTeam(6);
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(6,"Trainee"), Player);
                    });
                }
            }
            return;
        }

        public static void SetLightBlueTeam(KitType type, ServerPlayer Player)
        {
            switch(type){
                case NONE -> {Player.displayClientMessage(new TranslatableComponent("text.mcpaintball.invalid_kit"),true);}
                case STANDARD ->
                {
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_BOOTS.get()), true);
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_LEGGINGS.get()), true);
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_CHESTPLATE.get()), true);
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_HELMET.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_RIFLE.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()), true);
                    Player.drop(new ItemStack(blockinit.LIGHT_BLUE_EXPLOSIVE_STATION.get(),4),true);
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_REMOTE.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),48),true);
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.drop(new ItemStack(blockinit.LIGHT_BLUE_AMMO_POD_BASIC.get(),8),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetTeam(8);
                        cap.SetClass("Standard");
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(8,"Standard"),Player);});
                }
                case MEDICAL -> {
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_BOOTS.get()), true);
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_LEGGINGS.get()), true);
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_CHESTPLATE.get()), true);
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_HELMET.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_SHOTGUN.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()), true);
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_REMOTE.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),32),true);
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_MED_KIT.get(),32),true);
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_AMMO_SHELL.get(),64),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetTeam(8);
                        cap.SetClass("Medic");
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(8,"Medic"),Player);
                    });
                }
                case HEAVY -> {
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_BOOTS.get()), true);
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_LEGGINGS.get()), true);
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_CHESTPLATE.get()), true);
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_HELMET.get()), true);
                    Player.drop(new ItemStack(blockinit.LIGHT_BLUE_EXPLOSIVE_STATION.get(),12),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_BAZOOKA.get()), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()), true);
                    Player.drop(new ItemStack(blockinit.LIGHT_BLUE_EXPLOSIVE.get(), 16), true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),24),true);
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_AMMO_HEAVY.get(),64),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetTeam(8);
                        cap.SetClass("Heavy");
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(8,"Heavy"),Player);
                    });
                }
                case TRAINEE -> {
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_AMMO_HEAVY.get(),64),true);
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_AMMO_SHELL.get(),64),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),64),true);
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_BOOTS.get()),true);
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_HELMET.get()),true);
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_CHESTPLATE.get()),true);
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_LEGGINGS.get()),true);
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_REMOTE.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_PISTOL.get()),true);
                    Player.drop(new ItemStack(blockinit.LIGHT_BLUE_EXPLOSIVE_STATION.get(),12),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_RIFLE.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_SHOTGUN.get()),true);
                    Player.drop(new ItemStack(iteminit.PAINTBALL_BAZOOKA.get()),true);
                    Player.drop(new ItemStack(iteminit.TABLET.get()),true);
                    Player.drop(new ItemStack(iteminit.RESET_ROD.get()),true);
                    Player.drop(new ItemStack(iteminit.LIGHT_BLUE_MED_KIT.get(),4),true);
                    Player.drop(new ItemStack(blockinit.LIGHT_BLUE_EXPLOSIVE.get(),4),true);
                    Player.drop(new ItemStack(blockinit.LIGHT_BLUE_AMMO_POD_BASIC.get(),4),true);
                    Player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                    Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{
                        cap.ResetAll();
                        cap.SetClass("Trainee");
                        cap.SetTeam(8);
                        Networking.sendToPlayer(new TeamUpdateS2CPacket(8,"Trainee"), Player);
                    });
                }
            }
            return;
        }
    }
}
