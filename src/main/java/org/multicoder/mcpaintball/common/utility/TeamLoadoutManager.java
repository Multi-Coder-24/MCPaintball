package org.multicoder.mcpaintball.common.utility;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.multicoder.mcpaintball.common.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.common.items.MCPaintballItems;

import java.util.ArrayList;
import java.util.List;

public class TeamLoadoutManager
{
    public static List<ItemStack> FetchEquipment(Player player)
    {
        List<ItemStack> Equipment = new ArrayList<>();
        PaintballTeam Team = PaintballTeam.values()[MCPaintballTeamsDataHelper.FetchTeam(player)];
        PaintballClass Class = PaintballClass.values()[MCPaintballTeamsDataHelper.FetchClass(player)];
        switch (Team)
        {
            case RED ->
            {
                switch(Class)
                {
                    case STANDARD ->
                    {
                        Equipment.add(new ItemStack(MCPaintballItems.RIFLE.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.PISTOL.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.GRENADE.get(),8));

                    }
                    case SHOTGUNNER ->
                    {
                        Equipment.add(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.PISTOL.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.GRENADE.get(),12));
                    }
                    case HEAVY ->
                    {
                        Equipment.add(new ItemStack(MCPaintballItems.BAZOOKA.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.PISTOL.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.GRENADE.get(),16));
                    }
                }
                Equipment.add(new ItemStack(MCPaintballItems.RED_BOOTS.get()));
                Equipment.add(new ItemStack(MCPaintballItems.RED_LEGGINGS.get()));
                Equipment.add(new ItemStack(MCPaintballItems.RED_CHESTPLATE.get()));
                Equipment.add(new ItemStack(MCPaintballItems.RED_HELMET.get()));
            }
            case GREEN ->
            {
                switch(Class)
                {
                    case STANDARD ->
                    {
                        Equipment.add(new ItemStack(MCPaintballItems.RIFLE.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.PISTOL.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.GRENADE.get(),8));
                    }
                    case SHOTGUNNER ->
                    {
                        Equipment.add(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.PISTOL.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.GRENADE.get(),12));
                    }
                    case HEAVY ->
                    {
                        Equipment.add(new ItemStack(MCPaintballItems.BAZOOKA.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.PISTOL.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.GRENADE.get(),16));
                    }
                }
                Equipment.add(new ItemStack(MCPaintballItems.BLUE_BOOTS.get()));
                Equipment.add(new ItemStack(MCPaintballItems.BLUE_LEGGINGS.get()));
                Equipment.add(new ItemStack(MCPaintballItems.BLUE_CHESTPLATE.get()));
                Equipment.add(new ItemStack(MCPaintballItems.BLUE_HELMET.get()));
            }
            case BLUE ->
            {
                switch(Class)
                {
                    case STANDARD ->
                    {
                        Equipment.add(new ItemStack(MCPaintballItems.RIFLE.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.PISTOL.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.GRENADE.get(),8));
                    }
                    case SHOTGUNNER ->
                    {
                        Equipment.add(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.PISTOL.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.GRENADE.get(),12));
                    }
                    case HEAVY ->
                    {
                        Equipment.add(new ItemStack(MCPaintballItems.BAZOOKA.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.PISTOL.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.GRENADE.get(),16));
                    }
                }
                Equipment.add(new ItemStack(MCPaintballItems.GREEN_BOOTS.get()));
                Equipment.add(new ItemStack(MCPaintballItems.GREEN_LEGGINGS.get()));
                Equipment.add(new ItemStack(MCPaintballItems.GREEN_CHESTPLATE.get()));
                Equipment.add(new ItemStack(MCPaintballItems.GREEN_HELMET.get()));
            }
        }
        return Equipment;
    }
}