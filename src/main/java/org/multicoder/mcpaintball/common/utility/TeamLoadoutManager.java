package org.multicoder.mcpaintball.common.utility;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.multicoder.mcpaintball.common.blocks.MCPaintballBlocks;
import org.multicoder.mcpaintball.common.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.common.items.MCPaintballItems;
import org.multicoder.mcpaintball.common.utility.PaintballDataUtility.Class;
import org.multicoder.mcpaintball.common.utility.PaintballDataUtility.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamLoadoutManager {
    public static List<ItemStack> FetchEquipment(Player player) {
        List<ItemStack> Equipment = new ArrayList<>();
        Team PTeam = Team.values()[MCPaintballTeamsDataHelper.FetchTeam(player)];
        Class PClass = Class.values()[MCPaintballTeamsDataHelper.FetchClass(player)];
        switch (PTeam) {
            case RED -> {
                switch (PClass) {
                    case STANDARD -> {
                        Equipment.add(new ItemStack(MCPaintballItems.RIFLE.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.RED_GRENADE.get(), 8));

                    }
                    case SHOTGUNNER -> {
                        Equipment.add(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.RED_GRENADE.get(), 12));
                    }
                    case HEAVY -> {
                        Equipment.add(new ItemStack(MCPaintballItems.BAZOOKA.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.RED_GRENADE.get(), 16));
                    }
                }
                Equipment.add(new ItemStack(MCPaintballItems.PISTOL.get()));
                Equipment.add(new ItemStack(MCPaintballItems.RED_BOOTS.get()));
                Equipment.add(new ItemStack(MCPaintballItems.RED_LEGGINGS.get()));
                Equipment.add(new ItemStack(MCPaintballItems.RED_CHESTPLATE.get()));
                Equipment.add(new ItemStack(MCPaintballItems.RED_HELMET.get()));
            }
            case GREEN -> {
                switch (PClass) {
                    case STANDARD -> {
                        Equipment.add(new ItemStack(MCPaintballItems.RIFLE.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.GREEN_GRENADE.get(), 8));
                    }
                    case SHOTGUNNER -> {
                        Equipment.add(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.GREEN_GRENADE.get(), 12));
                    }
                    case HEAVY -> {
                        Equipment.add(new ItemStack(MCPaintballItems.BAZOOKA.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.GREEN_GRENADE.get(), 16));
                    }
                }
                Equipment.add(new ItemStack(MCPaintballItems.PISTOL.get()));
                Equipment.add(new ItemStack(MCPaintballItems.GREEN_BOOTS.get()));
                Equipment.add(new ItemStack(MCPaintballItems.GREEN_LEGGINGS.get()));
                Equipment.add(new ItemStack(MCPaintballItems.GREEN_CHESTPLATE.get()));
                Equipment.add(new ItemStack(MCPaintballItems.GREEN_HELMET.get()));
            }
            case BLUE -> {
                switch (PClass) {
                    case STANDARD -> {
                        Equipment.add(new ItemStack(MCPaintballItems.RIFLE.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.BLUE_GRENADE.get(), 8));
                    }
                    case SHOTGUNNER -> {
                        Equipment.add(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.BLUE_GRENADE.get(), 12));
                    }
                    case HEAVY -> {
                        Equipment.add(new ItemStack(MCPaintballItems.BAZOOKA.get()));
                        Equipment.add(new ItemStack(MCPaintballItems.BLUE_GRENADE.get(), 16));
                    }
                }
                Equipment.add(new ItemStack(MCPaintballItems.PISTOL.get()));
                Equipment.add(new ItemStack(MCPaintballItems.BLUE_BOOTS.get()));
                Equipment.add(new ItemStack(MCPaintballItems.BLUE_LEGGINGS.get()));
                Equipment.add(new ItemStack(MCPaintballItems.BLUE_CHESTPLATE.get()));
                Equipment.add(new ItemStack(MCPaintballItems.BLUE_HELMET.get()));
            }
            case SOLO ->
            {
                Equipment.add(new ItemStack(MCPaintballItems.PISTOL.get()));
                Equipment.add(new ItemStack(MCPaintballItems.BAZOOKA.get()));
                Equipment.add(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                Equipment.add(new ItemStack(MCPaintballItems.RIFLE.get()));
                Equipment.add(new ItemStack(MCPaintballItems.SOLO_REMOTE.get()));
                Equipment.add(new ItemStack(MCPaintballItems.SOLO_BOOTS.get()));
                Equipment.add(new ItemStack(MCPaintballItems.SOLO_LEGGINGS.get()));
                Equipment.add(new ItemStack(MCPaintballItems.SOLO_CHESTPLATE.get()));
                Equipment.add(new ItemStack(MCPaintballItems.SOLO_HELMET.get()));
                Equipment.add(new ItemStack(MCPaintballBlocks.SOLO_C4.get(), 6));
                Equipment.add(new ItemStack(MCPaintballItems.SOLO_GRENADE.get(), 16));
                Equipment.add(new ItemStack(MCPaintballBlocks.SOLO_TEAM_STATION.get(), 4));
            }
        }
        return Equipment;
    }
}
