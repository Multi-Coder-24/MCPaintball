package org.multicoder.mcpaintball.util.player;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.lwjgl.system.CallbackI;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.capability.PlayerTeamCapabilityProvider;
import org.multicoder.mcpaintball.init.iteminit;
import org.multicoder.mcpaintball.util.AmmoType;
import org.multicoder.mcpaintball.util.Teams;

import java.util.concurrent.atomic.AtomicInteger;

public class PlayerUtils
{
    public static class BasicAmmo
    {
        public static boolean HasRedBasicAmmo(ServerPlayer player)
        {
            return player.getInventory().contains(new ItemStack(iteminit.RED_AMMO.get()));
        }

        public static boolean HasGreenBasicAmmo(ServerPlayer player)
        {
            return player.getInventory().contains(new ItemStack(iteminit.GREEN_AMMO.get()));
        }

        public static boolean HasBlueBasicAmmo(ServerPlayer player)
        {
            return player.getInventory().contains(new ItemStack(iteminit.BLUE_AMMO.get()));
        }
        public static boolean HasMagentaBasicAmmo(ServerPlayer player)
        {
            return player.getInventory().contains(new ItemStack(iteminit.MAGENTA_AMMO.get()));
        }
        public static boolean HasPinkBasicAmmo(ServerPlayer player)
        {
            return player.getInventory().contains(new ItemStack(iteminit.PINK_AMMO.get()));
        }
        public static boolean HasPurpleBasicAmmo(ServerPlayer player)
        {
            return player.getInventory().contains(new ItemStack(iteminit.PURPLE_AMMO.get()));
        }
        public static boolean HasLimeBasicAmmo(ServerPlayer player)
        {
            return player.getInventory().contains(new ItemStack(iteminit.LIME_AMMO.get()));
        }
        public static boolean HasLightBlueBasicAmmo(ServerPlayer player)
        {
            return player.getInventory().contains(new ItemStack(iteminit.LIGHT_BLUE_AMMO.get()));
        }
    }
    public static class ShellAmmo
    {

        public static boolean HasRedShellAmmo(ServerPlayer player)
        {
            return player.getInventory().contains(new ItemStack(iteminit.RED_AMMO_SHELL.get()));
        }

        public static boolean HasGreenShellAmmo(ServerPlayer player)
        {
            return player.getInventory().contains(new ItemStack(iteminit.GREEN_AMMO_SHELL.get()));
        }

        public static boolean HasBlueShellAmmo(ServerPlayer player)
        {
            return player.getInventory().contains(new ItemStack(iteminit.BLUE_AMMO_SHELL.get()));
        }
        public static boolean HasMagentaShellAmmo(ServerPlayer player)
        {
            return player.getInventory().contains(new ItemStack(iteminit.MAGENTA_AMMO_SHELL.get()));
        }
        public static boolean HasPinkShellAmmo(ServerPlayer player)
        {
            return player.getInventory().contains(new ItemStack(iteminit.PINK_AMMO_SHELL.get()));
        }
        public static boolean HasPurpleShellAmmo(ServerPlayer player)
        {
            return player.getInventory().contains(new ItemStack(iteminit.PURPLE_AMMO_SHELL.get()));
        }
        public static boolean HasLimeShellAmmo(ServerPlayer player)
        {
            return player.getInventory().contains(new ItemStack(iteminit.LIME_AMMO_SHELL.get()));
        }
        public static boolean HasLightBlueShellAmmo(ServerPlayer player)
        {
            return player.getInventory().contains(new ItemStack(iteminit.LIGHT_BLUE_AMMO_SHELL.get()));
        }
    }
    public static class HeavyAmmo
    {

        public static boolean HasRedHeavyAmmo(ServerPlayer player)
        {
            return player.getInventory().contains(new ItemStack(iteminit.RED_AMMO_HEAVY.get()));
        }

        public static boolean HasGreenHeavyAmmo(ServerPlayer player)
        {
            return player.getInventory().contains(new ItemStack(iteminit.GREEN_AMMO_HEAVY.get()));
        }

        public static boolean HasBlueHeavyAmmo(ServerPlayer player)
        {
            return player.getInventory().contains(new ItemStack(iteminit.BLUE_AMMO_HEAVY.get()));
        }
        public static boolean HasMagentaHeavyAmmo(ServerPlayer player)
        {
            return player.getInventory().contains(new ItemStack(iteminit.MAGENTA_AMMO_HEAVY.get()));
        }
        public static boolean HasPinkHeavyAmmo(ServerPlayer player)
        {
            return player.getInventory().contains(new ItemStack(iteminit.PINK_AMMO_HEAVY.get()));
        }
        public static boolean HasPurpleHeavyAmmo(ServerPlayer player)
        {
            return player.getInventory().contains(new ItemStack(iteminit.PURPLE_AMMO_HEAVY.get()));
        }
        public static boolean HasLimeHeavyAmmo(ServerPlayer player)
        {
            return player.getInventory().contains(new ItemStack(iteminit.LIME_AMMO_HEAVY.get()));
        }
        public static boolean HasLightBlueHeavyAmmo(ServerPlayer player)
        {
            return player.getInventory().contains(new ItemStack(iteminit.LIGHT_BLUE_AMMO_HEAVY.get()));
        }
    }

    public static class ReloadManager
    {
        public static void Reload(ServerPlayer SP,ItemStack Weapon)
        {
            AtomicInteger TeamHolder = new AtomicInteger(0);
            SP.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->{TeamHolder.set(cap.GetTeam());});
            Teams Team = Teams.getTeam(TeamHolder.get());
            AmmoType Type = AmmoType.UNKNOWN;
            switch(Team)
            {
                case RED ->
                {
                    Item I = Weapon.getItem();
                    if(I.equals(iteminit.PAINTBALL_PISTOL.get()) || I.equals(iteminit.PAINTBALL_RIFLE.get()))
                    {
                        Type = AmmoType.BASIC;
                    } else if (I.equals(iteminit.PAINTBALL_BAZOOKA.get()))
                    {
                        Type = AmmoType.HEAVY;
                    } else if (I.equals(iteminit.PAINTBALL_SHOTGUN.get()))
                    {
                        Type = AmmoType.SHELL;
                    }
                    CheckAndApplyRedAmmo(SP,Weapon,Type);
                }
                case BLUE ->
                {
                    Item I = Weapon.getItem();
                    if(I.equals(iteminit.PAINTBALL_PISTOL.get()) || I.equals(iteminit.PAINTBALL_RIFLE.get()))
                    {
                        Type = AmmoType.BASIC;
                    } else if (I.equals(iteminit.PAINTBALL_BAZOOKA.get()))
                    {
                        Type = AmmoType.HEAVY;
                    } else if (I.equals(iteminit.PAINTBALL_SHOTGUN.get()))
                    {
                        Type = AmmoType.SHELL;
                    }
                    CheckAndApplyBlueAmmo(SP,Weapon,Type);
                }
                case GREEN ->
                {
                    Item I = Weapon.getItem();
                    if(I.equals(iteminit.PAINTBALL_PISTOL.get()) || I.equals(iteminit.PAINTBALL_RIFLE.get()))
                    {
                        Type = AmmoType.BASIC;
                    } else if (I.equals(iteminit.PAINTBALL_BAZOOKA.get()))
                    {
                        Type = AmmoType.HEAVY;
                    } else if (I.equals(iteminit.PAINTBALL_SHOTGUN.get()))
                    {
                        Type = AmmoType.SHELL;
                    }
                    CheckAndApplyGreenAmmo(SP,Weapon,Type);
                }
                case PINK ->
                {
                    Item I = Weapon.getItem();
                    if(I.equals(iteminit.PAINTBALL_PISTOL.get()) || I.equals(iteminit.PAINTBALL_RIFLE.get()))
                    {
                        Type = AmmoType.BASIC;
                    } else if (I.equals(iteminit.PAINTBALL_BAZOOKA.get()))
                    {
                        Type = AmmoType.HEAVY;
                    } else if (I.equals(iteminit.PAINTBALL_SHOTGUN.get()))
                    {
                        Type = AmmoType.SHELL;
                    }
                    CheckAndApplyPinkAmmo(SP,Weapon,Type);
                }
                case MAGENTA ->
                {
                    Item I = Weapon.getItem();
                    if(I.equals(iteminit.PAINTBALL_PISTOL.get()) || I.equals(iteminit.PAINTBALL_RIFLE.get()))
                    {
                        Type = AmmoType.BASIC;
                    } else if (I.equals(iteminit.PAINTBALL_BAZOOKA.get()))
                    {
                        Type = AmmoType.HEAVY;
                    } else if (I.equals(iteminit.PAINTBALL_SHOTGUN.get()))
                    {
                        Type = AmmoType.SHELL;
                    }
                    CheckAndApplyMagentaAmmo(SP,Weapon,Type);
                }
                case PURPLE ->
                {
                    Item I = Weapon.getItem();
                    if(I.equals(iteminit.PAINTBALL_PISTOL.get()) || I.equals(iteminit.PAINTBALL_RIFLE.get()))
                    {
                        Type = AmmoType.BASIC;
                    } else if (I.equals(iteminit.PAINTBALL_BAZOOKA.get()))
                    {
                        Type = AmmoType.HEAVY;
                    } else if (I.equals(iteminit.PAINTBALL_SHOTGUN.get()))
                    {
                        Type = AmmoType.SHELL;
                    }
                    CheckAndApplyPurpleAmmo(SP,Weapon,Type);
                }
                case LIME ->
                {
                    Item I = Weapon.getItem();
                    if(I.equals(iteminit.PAINTBALL_PISTOL.get()) || I.equals(iteminit.PAINTBALL_RIFLE.get()))
                    {
                        Type = AmmoType.BASIC;
                    } else if (I.equals(iteminit.PAINTBALL_BAZOOKA.get()))
                    {
                        Type = AmmoType.HEAVY;
                    } else if (I.equals(iteminit.PAINTBALL_SHOTGUN.get()))
                    {
                        Type = AmmoType.SHELL;
                    }
                    CheckAndApplyLimeAmmo(SP,Weapon,Type);
                }
                case LIGHT_BLUE ->
                {
                    Item I = Weapon.getItem();
                    if(I.equals(iteminit.PAINTBALL_PISTOL.get()) || I.equals(iteminit.PAINTBALL_RIFLE.get()))
                    {
                        Type = AmmoType.BASIC;
                    } else if (I.equals(iteminit.PAINTBALL_BAZOOKA.get()))
                    {
                        Type = AmmoType.HEAVY;
                    } else if (I.equals(iteminit.PAINTBALL_SHOTGUN.get()))
                    {
                        Type = AmmoType.SHELL;
                    }
                    CheckAndApplyLightBlueAmmo(SP,Weapon,Type);
                }
            }
        }

        private static void CheckAndApplyRedAmmo(ServerPlayer SP,ItemStack Held, AmmoType type)
        {
            switch(type)
            {
                case BASIC ->
                {
                    if(PlayerUtils.BasicAmmo.HasRedBasicAmmo(SP))
                    {
                        int Index = SP.getInventory().findSlotMatchingItem(new ItemStack(iteminit.RED_AMMO.get()));
                        ItemStack Ammo = SP.getInventory().getItem(Index);
                        int Amount = Ammo.getCount();
                        int DV = Held.getDamageValue();
                        if(DV > Amount)
                        {
                            DV -= Amount;
                            Held.setDamageValue(DV);
                            Ammo.shrink(Amount);
                        }
                        else
                        {
                            int Remaining = Amount - DV;
                            Held.setDamageValue(0);
                            Ammo.setCount(Remaining);
                        }
                    }
                }
                case SHELL ->
                {
                    if(PlayerUtils.ShellAmmo.HasRedShellAmmo(SP))
                    {
                        int Index = SP.getInventory().findSlotMatchingItem(new ItemStack(iteminit.RED_AMMO_SHELL.get()));
                        ItemStack Ammo = SP.getInventory().getItem(Index);
                        int Amount = Ammo.getCount();
                        int DV = Held.getDamageValue();
                        if(DV > Amount)
                        {
                            DV -= Amount;
                            Held.setDamageValue(DV);
                            Ammo.shrink(Amount);
                        }
                        else
                        {
                            int Remaining = Amount - DV;
                            Held.setDamageValue(0);
                            Ammo.setCount(Remaining);
                        }
                    }
                }
                case HEAVY ->
                {
                    if(PlayerUtils.HeavyAmmo.HasRedHeavyAmmo(SP))
                    {
                        int Index = SP.getInventory().findSlotMatchingItem(new ItemStack(iteminit.RED_AMMO_HEAVY.get()));
                        ItemStack Ammo = SP.getInventory().getItem(Index);
                        int Amount = Ammo.getCount();
                        int DV = Held.getDamageValue();
                        if(DV > Amount)
                        {
                            DV -= Amount;
                            Held.setDamageValue(DV);
                            Ammo.shrink(Amount);
                        }
                        else
                        {
                            int Remaining = Amount - DV;
                            Held.setDamageValue(0);
                            Ammo.setCount(Remaining);
                        }
                    }
                }
            }
        }
        private static void CheckAndApplyBlueAmmo(ServerPlayer SP,ItemStack Held, AmmoType type)
        {
            switch(type)
            {
                case BASIC ->
                {
                    if(PlayerUtils.BasicAmmo.HasBlueBasicAmmo(SP))
                    {
                        int Index = SP.getInventory().findSlotMatchingItem(new ItemStack(iteminit.BLUE_AMMO.get()));
                        ItemStack Ammo = SP.getInventory().getItem(Index);
                        int Amount = Ammo.getCount();
                        int DV = Held.getDamageValue();
                        if(DV > Amount)
                        {
                            DV -= Amount;
                            Held.setDamageValue(DV);
                            Ammo.shrink(Amount);
                        }
                        else
                        {
                            int Remaining = Amount - DV;
                            Held.setDamageValue(0);
                            Ammo.setCount(Remaining);
                        }
                    }
                }
                case SHELL ->
                {
                    if(PlayerUtils.ShellAmmo.HasBlueShellAmmo(SP))
                    {
                        int Index = SP.getInventory().findSlotMatchingItem(new ItemStack(iteminit.BLUE_AMMO_SHELL.get()));
                        ItemStack Ammo = SP.getInventory().getItem(Index);
                        int Amount = Ammo.getCount();
                        int DV = Held.getDamageValue();
                        if(DV > Amount)
                        {
                            DV -= Amount;
                            Held.setDamageValue(DV);
                            Ammo.shrink(Amount);
                        }
                        else
                        {
                            int Remaining = Amount - DV;
                            Held.setDamageValue(0);
                            Ammo.setCount(Remaining);
                        }
                    }
                }
                case HEAVY ->
                {
                    if(PlayerUtils.HeavyAmmo.HasBlueHeavyAmmo(SP))
                    {
                        int Index = SP.getInventory().findSlotMatchingItem(new ItemStack(iteminit.BLUE_AMMO_HEAVY.get()));
                        ItemStack Ammo = SP.getInventory().getItem(Index);
                        int Amount = Ammo.getCount();
                        int DV = Held.getDamageValue();
                        if(DV > Amount)
                        {
                            DV -= Amount;
                            Held.setDamageValue(DV);
                            Ammo.shrink(Amount);
                        }
                        else
                        {
                            int Remaining = Amount - DV;
                            Held.setDamageValue(0);
                            Ammo.setCount(Remaining);
                        }
                    }
                }
            }
        }
        private static void CheckAndApplyGreenAmmo(ServerPlayer SP,ItemStack Held, AmmoType type)
        {
            switch(type)
            {
                case BASIC ->
                {
                    if(PlayerUtils.BasicAmmo.HasGreenBasicAmmo(SP))
                    {
                        int Index = SP.getInventory().findSlotMatchingItem(new ItemStack(iteminit.GREEN_AMMO.get()));
                        ItemStack Ammo = SP.getInventory().getItem(Index);
                        int Amount = Ammo.getCount();
                        int DV = Held.getDamageValue();
                        if(DV > Amount)
                        {
                            DV -= Amount;
                            Held.setDamageValue(DV);
                            Ammo.shrink(Amount);
                        }
                        else
                        {
                            int Remaining = Amount - DV;
                            Held.setDamageValue(0);
                            Ammo.setCount(Remaining);
                        }
                    }
                }
                case SHELL ->
                {
                    if(PlayerUtils.ShellAmmo.HasGreenShellAmmo(SP))
                    {
                        int Index = SP.getInventory().findSlotMatchingItem(new ItemStack(iteminit.GREEN_AMMO_SHELL.get()));
                        ItemStack Ammo = SP.getInventory().getItem(Index);
                        int Amount = Ammo.getCount();
                        int DV = Held.getDamageValue();
                        if(DV > Amount)
                        {
                            DV -= Amount;
                            Held.setDamageValue(DV);
                            Ammo.shrink(Amount);
                        }
                        else
                        {
                            int Remaining = Amount - DV;
                            Held.setDamageValue(0);
                            Ammo.setCount(Remaining);
                        }
                    }
                }
                case HEAVY ->
                {
                    if(PlayerUtils.HeavyAmmo.HasGreenHeavyAmmo(SP))
                    {
                        int Index = SP.getInventory().findSlotMatchingItem(new ItemStack(iteminit.GREEN_AMMO_HEAVY.get()));
                        ItemStack Ammo = SP.getInventory().getItem(Index);
                        int Amount = Ammo.getCount();
                        int DV = Held.getDamageValue();
                        if(DV > Amount)
                        {
                            DV -= Amount;
                            Held.setDamageValue(DV);
                            Ammo.shrink(Amount);
                        }
                        else
                        {
                            int Remaining = Amount - DV;
                            Held.setDamageValue(0);
                            Ammo.setCount(Remaining);
                        }
                    }
                }
            }
        }
        private static void CheckAndApplyPinkAmmo(ServerPlayer SP,ItemStack Held, AmmoType type)
        {
            switch(type)
            {
                case BASIC ->
                {
                    if(PlayerUtils.BasicAmmo.HasPinkBasicAmmo(SP))
                    {
                        int Index = SP.getInventory().findSlotMatchingItem(new ItemStack(iteminit.PINK_AMMO.get()));
                        ItemStack Ammo = SP.getInventory().getItem(Index);
                        int Amount = Ammo.getCount();
                        int DV = Held.getDamageValue();
                        if(DV > Amount)
                        {
                            DV -= Amount;
                            Held.setDamageValue(DV);
                            Ammo.shrink(Amount);
                        }
                        else
                        {
                            int Remaining = Amount - DV;
                            Held.setDamageValue(0);
                            Ammo.setCount(Remaining);
                        }
                    }
                }
                case SHELL ->
                {
                    if(PlayerUtils.ShellAmmo.HasPinkShellAmmo(SP))
                    {
                        int Index = SP.getInventory().findSlotMatchingItem(new ItemStack(iteminit.PINK_AMMO_SHELL.get()));
                        ItemStack Ammo = SP.getInventory().getItem(Index);
                        int Amount = Ammo.getCount();
                        int DV = Held.getDamageValue();
                        if(DV > Amount)
                        {
                            DV -= Amount;
                            Held.setDamageValue(DV);
                            Ammo.shrink(Amount);
                        }
                        else
                        {
                            int Remaining = Amount - DV;
                            Held.setDamageValue(0);
                            Ammo.setCount(Remaining);
                        }
                    }
                }
                case HEAVY ->
                {
                    if(PlayerUtils.HeavyAmmo.HasPinkHeavyAmmo(SP))
                    {
                        int Index = SP.getInventory().findSlotMatchingItem(new ItemStack(iteminit.PINK_AMMO_HEAVY.get()));
                        ItemStack Ammo = SP.getInventory().getItem(Index);
                        int Amount = Ammo.getCount();
                        int DV = Held.getDamageValue();
                        if(DV > Amount)
                        {
                            DV -= Amount;
                            Held.setDamageValue(DV);
                            Ammo.shrink(Amount);
                        }
                        else
                        {
                            int Remaining = Amount - DV;
                            Held.setDamageValue(0);
                            Ammo.setCount(Remaining);
                        }
                    }
                }
            }
        }
        private static void CheckAndApplyMagentaAmmo(ServerPlayer SP,ItemStack Held, AmmoType type)
        {
            switch(type)
            {
                case BASIC ->
                {
                    if(PlayerUtils.BasicAmmo.HasMagentaBasicAmmo(SP))
                    {
                        int Index = SP.getInventory().findSlotMatchingItem(new ItemStack(iteminit.MAGENTA_AMMO.get()));
                        ItemStack Ammo = SP.getInventory().getItem(Index);
                        int Amount = Ammo.getCount();
                        int DV = Held.getDamageValue();
                        if(DV > Amount)
                        {
                            DV -= Amount;
                            Held.setDamageValue(DV);
                            Ammo.shrink(Amount);
                        }
                        else
                        {
                            int Remaining = Amount - DV;
                            Held.setDamageValue(0);
                            Ammo.setCount(Remaining);
                        }
                    }
                }
                case SHELL ->
                {
                    if(PlayerUtils.ShellAmmo.HasMagentaShellAmmo(SP))
                    {
                        int Index = SP.getInventory().findSlotMatchingItem(new ItemStack(iteminit.MAGENTA_AMMO_SHELL.get()));
                        ItemStack Ammo = SP.getInventory().getItem(Index);
                        int Amount = Ammo.getCount();
                        int DV = Held.getDamageValue();
                        if(DV > Amount)
                        {
                            DV -= Amount;
                            Held.setDamageValue(DV);
                            Ammo.shrink(Amount);
                        }
                        else
                        {
                            int Remaining = Amount - DV;
                            Held.setDamageValue(0);
                            Ammo.setCount(Remaining);
                        }
                    }
                }
                case HEAVY ->
                {
                    if(PlayerUtils.HeavyAmmo.HasMagentaHeavyAmmo(SP))
                    {
                        int Index = SP.getInventory().findSlotMatchingItem(new ItemStack(iteminit.MAGENTA_AMMO_HEAVY.get()));
                        ItemStack Ammo = SP.getInventory().getItem(Index);
                        int Amount = Ammo.getCount();
                        int DV = Held.getDamageValue();
                        if(DV > Amount)
                        {
                            DV -= Amount;
                            Held.setDamageValue(DV);
                            Ammo.shrink(Amount);
                        }
                        else
                        {
                            int Remaining = Amount - DV;
                            Held.setDamageValue(0);
                            Ammo.setCount(Remaining);
                        }
                    }
                }
            }
        }
        private static void CheckAndApplyPurpleAmmo(ServerPlayer SP,ItemStack Held, AmmoType type)
        {
            switch(type)
            {
                case BASIC ->
                {
                    if(PlayerUtils.BasicAmmo.HasPurpleBasicAmmo(SP))
                    {
                        int Index = SP.getInventory().findSlotMatchingItem(new ItemStack(iteminit.PURPLE_AMMO.get()));
                        ItemStack Ammo = SP.getInventory().getItem(Index);
                        int Amount = Ammo.getCount();
                        int DV = Held.getDamageValue();
                        if(DV > Amount)
                        {
                            DV -= Amount;
                            Held.setDamageValue(DV);
                            Ammo.shrink(Amount);
                        }
                        else
                        {
                            int Remaining = Amount - DV;
                            Held.setDamageValue(0);
                            Ammo.setCount(Remaining);
                        }
                    }
                }
                case SHELL ->
                {
                    if(PlayerUtils.ShellAmmo.HasPurpleShellAmmo(SP))
                    {
                        int Index = SP.getInventory().findSlotMatchingItem(new ItemStack(iteminit.PURPLE_AMMO_SHELL.get()));
                        ItemStack Ammo = SP.getInventory().getItem(Index);
                        int Amount = Ammo.getCount();
                        int DV = Held.getDamageValue();
                        if(DV > Amount)
                        {
                            DV -= Amount;
                            Held.setDamageValue(DV);
                            Ammo.shrink(Amount);
                        }
                        else
                        {
                            int Remaining = Amount - DV;
                            Held.setDamageValue(0);
                            Ammo.setCount(Remaining);
                        }
                    }
                }
                case HEAVY ->
                {
                    if(PlayerUtils.HeavyAmmo.HasPurpleHeavyAmmo(SP))
                    {
                        int Index = SP.getInventory().findSlotMatchingItem(new ItemStack(iteminit.PURPLE_AMMO_HEAVY.get()));
                        ItemStack Ammo = SP.getInventory().getItem(Index);
                        int Amount = Ammo.getCount();
                        int DV = Held.getDamageValue();
                        if(DV > Amount)
                        {
                            DV -= Amount;
                            Held.setDamageValue(DV);
                            Ammo.shrink(Amount);
                        }
                        else
                        {
                            int Remaining = Amount - DV;
                            Held.setDamageValue(0);
                            Ammo.setCount(Remaining);
                        }
                    }
                }
            }
        }
        private static void CheckAndApplyLimeAmmo(ServerPlayer SP,ItemStack Held, AmmoType type)
        {
            switch(type)
            {
                case BASIC ->
                {
                    if(PlayerUtils.BasicAmmo.HasLimeBasicAmmo(SP))
                    {
                        int Index = SP.getInventory().findSlotMatchingItem(new ItemStack(iteminit.LIME_AMMO.get()));
                        ItemStack Ammo = SP.getInventory().getItem(Index);
                        int Amount = Ammo.getCount();
                        int DV = Held.getDamageValue();
                        if(DV > Amount)
                        {
                            DV -= Amount;
                            Held.setDamageValue(DV);
                            Ammo.shrink(Amount);
                        }
                        else
                        {
                            int Remaining = Amount - DV;
                            Held.setDamageValue(0);
                            Ammo.setCount(Remaining);
                        }
                    }
                }
                case SHELL ->
                {
                    if(PlayerUtils.ShellAmmo.HasLimeShellAmmo(SP))
                    {
                        int Index = SP.getInventory().findSlotMatchingItem(new ItemStack(iteminit.LIME_AMMO_SHELL.get()));
                        ItemStack Ammo = SP.getInventory().getItem(Index);
                        int Amount = Ammo.getCount();
                        int DV = Held.getDamageValue();
                        if(DV > Amount)
                        {
                            DV -= Amount;
                            Held.setDamageValue(DV);
                            Ammo.shrink(Amount);
                        }
                        else
                        {
                            int Remaining = Amount - DV;
                            Held.setDamageValue(0);
                            Ammo.setCount(Remaining);
                        }
                    }
                }
                case HEAVY ->
                {
                    if(PlayerUtils.HeavyAmmo.HasLimeHeavyAmmo(SP))
                    {
                        int Index = SP.getInventory().findSlotMatchingItem(new ItemStack(iteminit.LIME_AMMO_HEAVY.get()));
                        ItemStack Ammo = SP.getInventory().getItem(Index);
                        int Amount = Ammo.getCount();
                        int DV = Held.getDamageValue();
                        if(DV > Amount)
                        {
                            DV -= Amount;
                            Held.setDamageValue(DV);
                            Ammo.shrink(Amount);
                        }
                        else
                        {
                            int Remaining = Amount - DV;
                            Held.setDamageValue(0);
                            Ammo.setCount(Remaining);
                        }
                    }
                }
            }
        }
        private static void CheckAndApplyLightBlueAmmo(ServerPlayer SP,ItemStack Held, AmmoType type)
        {
            switch(type)
            {
                case BASIC ->
                {
                    if(PlayerUtils.BasicAmmo.HasLightBlueBasicAmmo(SP))
                    {
                        int Index = SP.getInventory().findSlotMatchingItem(new ItemStack(iteminit.LIGHT_BLUE_AMMO.get()));
                        ItemStack Ammo = SP.getInventory().getItem(Index);
                        int Amount = Ammo.getCount();
                        int DV = Held.getDamageValue();
                        if(DV > Amount)
                        {
                            DV -= Amount;
                            Held.setDamageValue(DV);
                            Ammo.shrink(Amount);
                        }
                        else
                        {
                            int Remaining = Amount - DV;
                            Held.setDamageValue(0);
                            Ammo.setCount(Remaining);
                        }
                    }
                }
                case SHELL ->
                {
                    if(PlayerUtils.ShellAmmo.HasLightBlueShellAmmo(SP))
                    {
                        int Index = SP.getInventory().findSlotMatchingItem(new ItemStack(iteminit.LIGHT_BLUE_AMMO_SHELL.get()));
                        ItemStack Ammo = SP.getInventory().getItem(Index);
                        int Amount = Ammo.getCount();
                        int DV = Held.getDamageValue();
                        if(DV > Amount)
                        {
                            DV -= Amount;
                            Held.setDamageValue(DV);
                            Ammo.shrink(Amount);
                        }
                        else
                        {
                            int Remaining = Amount - DV;
                            Held.setDamageValue(0);
                            Ammo.setCount(Remaining);
                        }
                    }
                }
                case HEAVY ->
                {
                    if(PlayerUtils.HeavyAmmo.HasLightBlueHeavyAmmo(SP))
                    {
                        int Index = SP.getInventory().findSlotMatchingItem(new ItemStack(iteminit.LIGHT_BLUE_AMMO_HEAVY.get()));
                        ItemStack Ammo = SP.getInventory().getItem(Index);
                        int Amount = Ammo.getCount();
                        int DV = Held.getDamageValue();
                        if(DV > Amount)
                        {
                            DV -= Amount;
                            Held.setDamageValue(DV);
                            Ammo.shrink(Amount);
                        }
                        else
                        {
                            int Remaining = Amount - DV;
                            Held.setDamageValue(0);
                            Ammo.setCount(Remaining);
                        }
                    }
                }
            }
        }
    }
}
