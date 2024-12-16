package org.multicoder.mcpaintball.utility;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.multicoder.mcpaintball.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.utility.enums.PaintballTeam;

import java.util.ArrayList;
import java.util.List;

import static org.multicoder.mcpaintball.init.MCPaintballItems.*;
import static org.multicoder.mcpaintball.init.MCPaintballBlocks.*;

public class TeamLoadoutManager
{
    public static List<ItemStack> FetchEquipment(Player player)
    {
        List<ItemStack> Equipment = new ArrayList<>();
        PaintballTeam PTeam = PaintballTeam.values()[MCPaintballTeamsDataHelper.FetchTeam(player)];
        switch (PTeam) {
            case RED -> {
                Equipment.add(new ItemStack(RED_GRENADE.get(), 16));
                Equipment.add(new ItemStack(RED_C4.get(), 6));
                Equipment.add(new ItemStack(RED_TEAM_STATION.get(), 4));
                Equipment.add(new ItemStack(RED_REMOTE.get()));
                Equipment.add(new ItemStack(RED_BOOTS.get()));
                Equipment.add(new ItemStack(RED_LEGGINGS.get()));
                Equipment.add(new ItemStack(RED_CHESTPLATE.get()));
                Equipment.add(new ItemStack(RED_HELMET.get()));
                Equipment.add(new ItemStack(RED_PAINTBALL_TUB.get(),16));
            }
            case GREEN -> {
                Equipment.add(new ItemStack(GREEN_GRENADE.get(), 16));
                Equipment.add(new ItemStack(GREEN_C4.get(), 6));
                Equipment.add(new ItemStack(GREEN_TEAM_STATION.get(), 4));
                Equipment.add(new ItemStack(GREEN_REMOTE.get()));
                Equipment.add(new ItemStack(GREEN_BOOTS.get()));
                Equipment.add(new ItemStack(GREEN_LEGGINGS.get()));
                Equipment.add(new ItemStack(GREEN_CHESTPLATE.get()));
                Equipment.add(new ItemStack(GREEN_HELMET.get()));
                Equipment.add(new ItemStack(GREEN_PAINTBALL_TUB.get(),16));

            }
            case BLUE -> {
                Equipment.add(new ItemStack(BLUE_GRENADE.get(), 16));
                Equipment.add(new ItemStack(BLUE_C4.get(), 6));
                Equipment.add(new ItemStack(BLUE_TEAM_STATION.get(), 4));
                Equipment.add(new ItemStack(BLUE_REMOTE.get()));
                Equipment.add(new ItemStack(BLUE_BOOTS.get()));
                Equipment.add(new ItemStack(BLUE_LEGGINGS.get()));
                Equipment.add(new ItemStack(BLUE_CHESTPLATE.get()));
                Equipment.add(new ItemStack(BLUE_HELMET.get()));
                Equipment.add(new ItemStack(BLUE_PAINTBALL_TUB.get(),16));
            }
        }
        Equipment.add(new ItemStack(TEAM_FLAG.get(),2));
        Equipment.add(new ItemStack(RIFLE.get()));
        Equipment.add(new ItemStack(SHOTGUN.get()));
        Equipment.add(new ItemStack(PISTOL.get()));
        return Equipment;
    }
}
