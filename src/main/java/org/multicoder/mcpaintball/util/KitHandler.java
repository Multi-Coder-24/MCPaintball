package org.multicoder.mcpaintball.util;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import org.multicoder.mcpaintball.core.MCPaintballBlocks;
import org.multicoder.mcpaintball.core.MCPaintballItems;

public class KitHandler {
    public static void GrantKit(Player player,int Team,int Type){
        switch (Team) {
            case 1 -> { // Red Team
                player.addItem(new ItemStack(MCPaintballItems.RED_BOOTS.get()));
                player.addItem(new ItemStack(MCPaintballItems.RED_LEGGINGS.get()));
                player.addItem(new ItemStack(MCPaintballItems.RED_CHESTPLATE.get()));
                player.addItem(new ItemStack(MCPaintballItems.RED_HELMET.get()));
                player.addItem(new ItemStack(MCPaintballBlocks.RED_GRENADE_STATION.get(),2));
                player.addItem(new ItemStack(MCPaintballBlocks.RED_RESPAWN_STATION.get()));
                player.addItem(new ItemStack(MCPaintballItems.SIGHT_GRENADE.get(),4));
                player.addItem(new ItemStack(MCPaintballBlocks.RED_PAINT_MINE,8));
                player.addItem(new ItemStack(MCPaintballBlocks.RED_FLAG,2));
                player.addItem(new ItemStack(MCPaintballBlocks.CAPTURE_POINT,2));
                player.addItem(new ItemStack(MCPaintballBlocks.RED_TOWER));
                player.addItem(new ItemStack(Blocks.RED_WOOL,64));
                player.addItem(new ItemStack(MCPaintballBlocks.RED_DOOR,4));
                switch (Type){
                    case 1 -> { // Standard
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.ASSAULT_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.RED_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),4));
                    }
                    case 2 -> { // Sniper
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SNIPER_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.RED_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),16));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),6));
                    }
                    case 3 -> { // Assault
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        player.addItem(new ItemStack(MCPaintballItems.BURST_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.RED_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),2));
                    }
                    case 4 -> { // Heavy
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.GRENADE_LAUNCHER.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),16));
                    }
                }
            }
            case 2 -> { // Green
                player.addItem(new ItemStack(MCPaintballItems.GREEN_BOOTS.get()));
                player.addItem(new ItemStack(MCPaintballItems.GREEN_LEGGINGS.get()));
                player.addItem(new ItemStack(MCPaintballItems.GREEN_CHESTPLATE.get()));
                player.addItem(new ItemStack(MCPaintballItems.GREEN_HELMET.get()));
                player.addItem(new ItemStack(MCPaintballBlocks.GREEN_GRENADE_STATION.get(),2));
                player.addItem(new ItemStack(MCPaintballBlocks.GREEN_RESPAWN_STATION.get()));
                player.addItem(new ItemStack(MCPaintballItems.SIGHT_GRENADE.get(),4));
                player.addItem(new ItemStack(MCPaintballBlocks.GREEN_PAINT_MINE,8));
                player.addItem(new ItemStack(MCPaintballBlocks.GREEN_FLAG,2));
                player.addItem(new ItemStack(MCPaintballBlocks.CAPTURE_POINT,2));
                player.addItem(new ItemStack(MCPaintballBlocks.GREEN_TOWER));
                player.addItem(new ItemStack(Blocks.GREEN_WOOL,64));
                player.addItem(new ItemStack(MCPaintballBlocks.GREEN_DOOR,4));

                switch (Type){
                    case 1 -> { // Standard
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.ASSAULT_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.GREEN_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),4));
                    }
                    case 2 -> { // Sniper
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SNIPER_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.GREEN_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),16));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),6));
                    }
                    case 3 -> { // Assault
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        player.addItem(new ItemStack(MCPaintballItems.BURST_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.GREEN_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),2));
                    }
                    case 4 -> { // Heavy
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.GRENADE_LAUNCHER.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),16));
                    }
                }
            }
            case 3 -> { // Blue
                player.addItem(new ItemStack(MCPaintballItems.BLUE_BOOTS.get()));
                player.addItem(new ItemStack(MCPaintballItems.BLUE_LEGGINGS.get()));
                player.addItem(new ItemStack(MCPaintballItems.BLUE_CHESTPLATE.get()));
                player.addItem(new ItemStack(MCPaintballItems.BLUE_HELMET.get()));
                player.addItem(new ItemStack(MCPaintballBlocks.BLUE_GRENADE_STATION.get(),2));
                player.addItem(new ItemStack(MCPaintballBlocks.BLUE_RESPAWN_STATION.get()));
                player.addItem(new ItemStack(MCPaintballItems.SIGHT_GRENADE.get(),4));
                player.addItem(new ItemStack(MCPaintballBlocks.BLUE_PAINT_MINE,8));
                player.addItem(new ItemStack(MCPaintballBlocks.BLUE_FLAG,2));
                player.addItem(new ItemStack(MCPaintballBlocks.CAPTURE_POINT,2));
                player.addItem(new ItemStack(MCPaintballBlocks.BLUE_TOWER));
                player.addItem(new ItemStack(Blocks.BLUE_WOOL,64));
                player.addItem(new ItemStack(MCPaintballBlocks.BLUE_DOOR,4));

                switch (Type){
                    case 1 -> { // Standard
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.ASSAULT_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.BLUE_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),4));
                    }
                    case 2 -> { // Sniper
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SNIPER_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.BLUE_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),16));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),6));
                    }
                    case 3 -> { // Assault
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        player.addItem(new ItemStack(MCPaintballItems.BURST_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.BLUE_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),2));
                    }
                    case 4 -> { // Heavy
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.GRENADE_LAUNCHER.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),16));
                    }
                }
            }
            case 4 -> { // Yellow
                player.addItem(new ItemStack(MCPaintballItems.YELLOW_BOOTS.get()));
                player.addItem(new ItemStack(MCPaintballItems.YELLOW_LEGGINGS.get()));
                player.addItem(new ItemStack(MCPaintballItems.YELLOW_CHESTPLATE.get()));
                player.addItem(new ItemStack(MCPaintballItems.YELLOW_HELMET.get()));
                player.addItem(new ItemStack(MCPaintballBlocks.YELLOW_GRENADE_STATION.get(),2));
                player.addItem(new ItemStack(MCPaintballBlocks.YELLOW_RESPAWN_STATION.get()));
                player.addItem(new ItemStack(MCPaintballItems.SIGHT_GRENADE.get(),4));
                player.addItem(new ItemStack(MCPaintballBlocks.YELLOW_PAINT_MINE,8));
                player.addItem(new ItemStack(MCPaintballBlocks.YELLOW_FLAG,2));
                player.addItem(new ItemStack(MCPaintballBlocks.CAPTURE_POINT,2));
                player.addItem(new ItemStack(MCPaintballBlocks.YELLOW_TOWER));
                player.addItem(new ItemStack(Blocks.YELLOW_WOOL,64));
                player.addItem(new ItemStack(MCPaintballBlocks.YELLOW_DOOR,4));
                switch (Type){
                    case 1 -> { // Standard
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.ASSAULT_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.YELLOW_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),4));
                    }
                    case 2 -> { // Sniper
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SNIPER_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.YELLOW_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),16));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),6));
                    }
                    case 3 -> { // Assault
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        player.addItem(new ItemStack(MCPaintballItems.BURST_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.YELLOW_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),2));
                    }
                    case 4 -> { // Heavy
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.GRENADE_LAUNCHER.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),16));
                    }
                }
            }case 5 -> { // Pink
                player.addItem(new ItemStack(MCPaintballItems.PINK_BOOTS.get()));
                player.addItem(new ItemStack(MCPaintballItems.PINK_LEGGINGS.get()));
                player.addItem(new ItemStack(MCPaintballItems.PINK_CHESTPLATE.get()));
                player.addItem(new ItemStack(MCPaintballItems.PINK_HELMET.get()));
                player.addItem(new ItemStack(MCPaintballBlocks.PINK_GRENADE_STATION.get(),2));
                player.addItem(new ItemStack(MCPaintballBlocks.PINK_RESPAWN_STATION.get()));
                player.addItem(new ItemStack(MCPaintballItems.SIGHT_GRENADE.get(),4));
                player.addItem(new ItemStack(MCPaintballBlocks.PINK_PAINT_MINE,8));
                player.addItem(new ItemStack(MCPaintballBlocks.PINK_FLAG,2));
                player.addItem(new ItemStack(MCPaintballBlocks.CAPTURE_POINT,2));
                player.addItem(new ItemStack(MCPaintballBlocks.PINK_TOWER));
                player.addItem(new ItemStack(Blocks.PINK_WOOL,64));
                player.addItem(new ItemStack(MCPaintballBlocks.PINK_DOOR,4));
                switch (Type){
                    case 1 -> { // Standard
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.ASSAULT_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PINK_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),4));
                    }
                    case 2 -> { // Sniper
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SNIPER_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PINK_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),16));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),6));
                    }
                    case 3 -> { // Assault
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        player.addItem(new ItemStack(MCPaintballItems.BURST_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PINK_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),2));
                    }
                    case 4 -> { // Heavy
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.GRENADE_LAUNCHER.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),16));
                    }
                }
            }case 6 -> { // Orange
                player.addItem(new ItemStack(MCPaintballItems.ORANGE_BOOTS.get()));
                player.addItem(new ItemStack(MCPaintballItems.ORANGE_LEGGINGS.get()));
                player.addItem(new ItemStack(MCPaintballItems.ORANGE_CHESTPLATE.get()));
                player.addItem(new ItemStack(MCPaintballItems.ORANGE_HELMET.get()));
                player.addItem(new ItemStack(MCPaintballBlocks.ORANGE_GRENADE_STATION.get(),2));
                player.addItem(new ItemStack(MCPaintballBlocks.ORANGE_RESPAWN_STATION.get()));
                player.addItem(new ItemStack(MCPaintballItems.SIGHT_GRENADE.get(),4));
                player.addItem(new ItemStack(MCPaintballBlocks.ORANGE_PAINT_MINE,8));
                player.addItem(new ItemStack(MCPaintballBlocks.ORANGE_FLAG,2));
                player.addItem(new ItemStack(MCPaintballBlocks.CAPTURE_POINT,2));
                player.addItem(new ItemStack(MCPaintballBlocks.ORANGE_TOWER));
                player.addItem(new ItemStack(Blocks.ORANGE_WOOL,64));
                player.addItem(new ItemStack(MCPaintballBlocks.ORANGE_DOOR,4));
                switch (Type){
                    case 1 -> { // Standard
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.ASSAULT_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.ORANGE_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),4));
                    }
                    case 2 -> { // Sniper
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SNIPER_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.ORANGE_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),16));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),6));
                    }
                    case 3 -> { // Assault
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        player.addItem(new ItemStack(MCPaintballItems.BURST_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.ORANGE_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),2));
                    }
                    case 4 -> { // Heavy
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.GRENADE_LAUNCHER.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),16));
                    }
                }
            }

        }
    }
}
