package org.multicoder.mcpaintball.utility;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.multicoder.mcpaintball.init.MCPaintballBlocks;
import org.multicoder.mcpaintball.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.init.MCPaintballItems;
import org.multicoder.mcpaintball.utility.enums.PaintballTeam;

import java.util.ArrayList;
import java.util.List;

public class TeamLoadoutManager
{
    public static List<ItemStack> FetchEquipment(Player player)
    {
        List<ItemStack> Equipment = new ArrayList<>();
        PaintballTeam PTeam = PaintballTeam.values()[MCPaintballTeamsDataHelper.FetchTeam(player)];
        switch (PTeam) {
            case RED -> {
                Equipment.add(new ItemStack(MCPaintballItems.RED_GRENADE.get(), 16));
                Equipment.add(new ItemStack(MCPaintballBlocks.RED_C4.get(), 6));
                Equipment.add(new ItemStack(MCPaintballBlocks.RED_TEAM_STATION.get(), 4));
                Equipment.add(new ItemStack(MCPaintballItems.RED_REMOTE.get()));
                Equipment.add(new ItemStack(MCPaintballItems.RED_BOOTS.get()));
                Equipment.add(new ItemStack(MCPaintballItems.RED_LEGGINGS.get()));
                Equipment.add(new ItemStack(MCPaintballItems.RED_CHESTPLATE.get()));
                Equipment.add(new ItemStack(MCPaintballItems.RED_HELMET.get()));
            }
            case GREEN -> {
                Equipment.add(new ItemStack(MCPaintballItems.GREEN_GRENADE.get(), 16));
                Equipment.add(new ItemStack(MCPaintballBlocks.GREEN_C4.get(), 6));
                Equipment.add(new ItemStack(MCPaintballBlocks.GREEN_TEAM_STATION.get(), 4));
                Equipment.add(new ItemStack(MCPaintballItems.GREEN_REMOTE.get()));
                Equipment.add(new ItemStack(MCPaintballItems.GREEN_BOOTS.get()));
                Equipment.add(new ItemStack(MCPaintballItems.GREEN_LEGGINGS.get()));
                Equipment.add(new ItemStack(MCPaintballItems.GREEN_CHESTPLATE.get()));
                Equipment.add(new ItemStack(MCPaintballItems.GREEN_HELMET.get()));

            }
            case BLUE -> {
                Equipment.add(new ItemStack(MCPaintballItems.BLUE_GRENADE.get(), 16));
                Equipment.add(new ItemStack(MCPaintballBlocks.BLUE_C4.get(), 6));
                Equipment.add(new ItemStack(MCPaintballBlocks.BLUE_TEAM_STATION.get(), 4));
                Equipment.add(new ItemStack(MCPaintballItems.BLUE_REMOTE.get()));
                Equipment.add(new ItemStack(MCPaintballItems.BLUE_BOOTS.get()));
                Equipment.add(new ItemStack(MCPaintballItems.BLUE_LEGGINGS.get()));
                Equipment.add(new ItemStack(MCPaintballItems.BLUE_CHESTPLATE.get()));
                Equipment.add(new ItemStack(MCPaintballItems.BLUE_HELMET.get()));
            }
        }
        Equipment.add(new ItemStack(MCPaintballBlocks.TEAM_FLAG.get(),2));
        Equipment.add(new ItemStack(MCPaintballItems.RIFLE.get()));
        Equipment.add(new ItemStack(MCPaintballItems.SHOTGUN.get()));
        Equipment.add(new ItemStack(MCPaintballItems.PISTOL.get()));
        return Equipment;
    }
}
