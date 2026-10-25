package org.multicoder.mcpaintball.util;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.multicoder.mcpaintball.core.MCPaintballBlocks;
import org.multicoder.mcpaintball.core.MCPaintballItems;

public class KitHandler {
    public static void grantKit(Player player, PaintballTeam team, PaintballRole type){
        switch (team) {
            case Red -> {
                player.addItem(new ItemStack(MCPaintballItems.RED_BOOTS));
                player.addItem(new ItemStack(MCPaintballItems.RED_LEGGINGS));
                player.addItem(new ItemStack(MCPaintballItems.RED_CHESTPLATE));
                player.addItem(new ItemStack(MCPaintballItems.RED_HELMET));
                switch (type){
                    case Captain -> {
                        player.addItem(new ItemStack(MCPaintballItems.ASSAULT_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballBlocks.RED_TOWER));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.RED_PAINT_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE,2));
                    }
                    case Gunner -> {
                        player.addItem(new ItemStack(MCPaintballItems.BURST_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.RED_PAINT_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE,2));
                    }
                    case Sniper -> {
                        player.addItem(new ItemStack(MCPaintballItems.SNIPER_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,8));
                        player.addItem(new ItemStack(MCPaintballItems.RED_PAINT_GRENADE,8));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE,6));
                    }
                    case Specialist -> {
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballBlocks.RED_PAINT_MINE, 8));
                        player.addItem(new ItemStack(MCPaintballBlocks.RED_CLAYMORE_BLOCK,4));
                        player.addItem(new ItemStack(MCPaintballBlocks.RED_GRENADE_STATION,2));
                    }
                    case Grenadier -> {
                        player.addItem(new ItemStack(MCPaintballItems.GRENADE_LAUNCHER));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE, 10));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE, 10));
                        player.addItem(new ItemStack(MCPaintballItems.SIGHT_GRENADE, 10));
                        player.addItem(new ItemStack(MCPaintballItems.RED_PAINT_GRENADE, 16));
                    }
                }
            }
            case Green -> {
                player.addItem(new ItemStack(MCPaintballItems.GREEN_BOOTS));
                player.addItem(new ItemStack(MCPaintballItems.GREEN_LEGGINGS));
                player.addItem(new ItemStack(MCPaintballItems.GREEN_CHESTPLATE));
                player.addItem(new ItemStack(MCPaintballItems.GREEN_HELMET));
                switch (type){
                    case Captain -> {
                        player.addItem(new ItemStack(MCPaintballItems.ASSAULT_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballBlocks.GREEN_TOWER));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.GREEN_PAINT_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE,2));
                    }
                    case Gunner -> {
                        player.addItem(new ItemStack(MCPaintballItems.BURST_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.GREEN_PAINT_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE,2));
                    }
                    case Sniper -> {
                        player.addItem(new ItemStack(MCPaintballItems.SNIPER_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,8));
                        player.addItem(new ItemStack(MCPaintballItems.GREEN_PAINT_GRENADE,8));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE,6));
                    }
                    case Specialist -> {
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballBlocks.GREEN_PAINT_MINE, 8));
                        player.addItem(new ItemStack(MCPaintballBlocks.GREEN_CLAYMORE_BLOCK,4));
                        player.addItem(new ItemStack(MCPaintballBlocks.GREEN_GRENADE_STATION,2));
                    }
                    case Grenadier -> {
                        player.addItem(new ItemStack(MCPaintballItems.GRENADE_LAUNCHER));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE, 10));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE, 10));
                        player.addItem(new ItemStack(MCPaintballItems.SIGHT_GRENADE, 10));
                        player.addItem(new ItemStack(MCPaintballItems.GREEN_PAINT_GRENADE, 16));
                    }
                }
            }
            case Blue -> { // blue
                player.addItem(new ItemStack(MCPaintballItems.BLUE_BOOTS));
                player.addItem(new ItemStack(MCPaintballItems.BLUE_LEGGINGS));
                player.addItem(new ItemStack(MCPaintballItems.BLUE_CHESTPLATE));
                player.addItem(new ItemStack(MCPaintballItems.BLUE_HELMET));
                switch (type){
                    case Captain -> {
                        player.addItem(new ItemStack(MCPaintballItems.ASSAULT_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballBlocks.BLUE_TOWER));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.BLUE_PAINT_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE,2));
                    }
                    case Gunner -> {
                        player.addItem(new ItemStack(MCPaintballItems.BURST_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.BLUE_PAINT_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE,2));
                    }
                    case Sniper -> {
                        player.addItem(new ItemStack(MCPaintballItems.SNIPER_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,8));
                        player.addItem(new ItemStack(MCPaintballItems.BLUE_PAINT_GRENADE,8));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE,6));
                    }
                    case Specialist -> {
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballBlocks.BLUE_PAINT_MINE, 8));
                        player.addItem(new ItemStack(MCPaintballBlocks.BLUE_CLAYMORE_BLOCK,4));
                        player.addItem(new ItemStack(MCPaintballBlocks.BLUE_GRENADE_STATION,2));
                    }
                    case Grenadier -> {
                        player.addItem(new ItemStack(MCPaintballItems.GRENADE_LAUNCHER));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE, 10));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE, 10));
                        player.addItem(new ItemStack(MCPaintballItems.SIGHT_GRENADE, 10));
                        player.addItem(new ItemStack(MCPaintballItems.BLUE_PAINT_GRENADE, 16));
                    }
                }
            }
            case Yellow -> {
                player.addItem(new ItemStack(MCPaintballItems.YELLOW_BOOTS));
                player.addItem(new ItemStack(MCPaintballItems.YELLOW_LEGGINGS));
                player.addItem(new ItemStack(MCPaintballItems.YELLOW_CHESTPLATE));
                player.addItem(new ItemStack(MCPaintballItems.YELLOW_HELMET));
                switch (type){
                    case Captain -> {
                        player.addItem(new ItemStack(MCPaintballItems.ASSAULT_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballBlocks.YELLOW_TOWER));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.YELLOW_PAINT_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE,2));
                    }
                    case Gunner -> {
                        player.addItem(new ItemStack(MCPaintballItems.BURST_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.YELLOW_PAINT_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE,2));
                    }
                    case Sniper -> {
                        player.addItem(new ItemStack(MCPaintballItems.SNIPER_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,8));
                        player.addItem(new ItemStack(MCPaintballItems.YELLOW_PAINT_GRENADE,8));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE,6));
                    }
                    case Specialist -> {
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballBlocks.YELLOW_PAINT_MINE, 8));
                        player.addItem(new ItemStack(MCPaintballBlocks.YELLOW_CLAYMORE_BLOCK,4));
                        player.addItem(new ItemStack(MCPaintballBlocks.YELLOW_GRENADE_STATION,2));
                    }
                    case Grenadier -> {
                        player.addItem(new ItemStack(MCPaintballItems.GRENADE_LAUNCHER));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE, 10));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE, 10));
                        player.addItem(new ItemStack(MCPaintballItems.SIGHT_GRENADE, 10));
                        player.addItem(new ItemStack(MCPaintballItems.YELLOW_PAINT_GRENADE, 16));
                    }
                }
            }case Pink -> {
                player.addItem(new ItemStack(MCPaintballItems.PINK_BOOTS));
                player.addItem(new ItemStack(MCPaintballItems.PINK_LEGGINGS));
                player.addItem(new ItemStack(MCPaintballItems.PINK_CHESTPLATE));
                player.addItem(new ItemStack(MCPaintballItems.PINK_HELMET));
                switch (type){
                    case Captain -> {
                        player.addItem(new ItemStack(MCPaintballItems.ASSAULT_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballBlocks.PINK_TOWER));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.PINK_PAINT_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE,2));
                    }
                    case Gunner -> {
                        player.addItem(new ItemStack(MCPaintballItems.BURST_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.PINK_PAINT_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE,2));
                    }
                    case Sniper -> {
                        player.addItem(new ItemStack(MCPaintballItems.SNIPER_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,8));
                        player.addItem(new ItemStack(MCPaintballItems.PINK_PAINT_GRENADE,8));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE,6));
                    }
                    case Specialist -> {
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballBlocks.PINK_PAINT_MINE, 8));
                        player.addItem(new ItemStack(MCPaintballBlocks.PINK_CLAYMORE_BLOCK,4));
                        player.addItem(new ItemStack(MCPaintballBlocks.PINK_GRENADE_STATION,2));
                    }
                    case Grenadier -> {
                        player.addItem(new ItemStack(MCPaintballItems.GRENADE_LAUNCHER));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE, 10));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE, 10));
                        player.addItem(new ItemStack(MCPaintballItems.SIGHT_GRENADE, 10));
                        player.addItem(new ItemStack(MCPaintballItems.PINK_PAINT_GRENADE, 16));
                    }
                }
            }case Orange -> {
                player.addItem(new ItemStack(MCPaintballItems.ORANGE_BOOTS));
                player.addItem(new ItemStack(MCPaintballItems.ORANGE_LEGGINGS));
                player.addItem(new ItemStack(MCPaintballItems.ORANGE_CHESTPLATE));
                player.addItem(new ItemStack(MCPaintballItems.ORANGE_HELMET));
                switch (type){
                    case Captain -> {
                        player.addItem(new ItemStack(MCPaintballItems.ASSAULT_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballBlocks.ORANGE_TOWER));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.ORANGE_PAINT_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE,2));
                    }
                    case Gunner -> {
                        player.addItem(new ItemStack(MCPaintballItems.BURST_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.ORANGE_PAINT_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE,2));
                    }
                    case Sniper -> {
                        player.addItem(new ItemStack(MCPaintballItems.SNIPER_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,8));
                        player.addItem(new ItemStack(MCPaintballItems.ORANGE_PAINT_GRENADE,8));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE,6));
                    }
                    case Specialist -> {
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballBlocks.ORANGE_PAINT_MINE, 8));
                        player.addItem(new ItemStack(MCPaintballBlocks.ORANGE_CLAYMORE_BLOCK,4));
                        player.addItem(new ItemStack(MCPaintballBlocks.ORANGE_GRENADE_STATION,2));
                    }
                    case Grenadier -> {
                        player.addItem(new ItemStack(MCPaintballItems.GRENADE_LAUNCHER));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE, 10));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE, 10));
                        player.addItem(new ItemStack(MCPaintballItems.SIGHT_GRENADE, 10));
                        player.addItem(new ItemStack(MCPaintballItems.ORANGE_PAINT_GRENADE, 16));
                    }
                }
            }
            case Admin -> {
                player.addItem(new ItemStack(MCPaintballBlocks.RED_FLAG,4));
                player.addItem(new ItemStack(MCPaintballBlocks.GREEN_FLAG,4));
                player.addItem(new ItemStack(MCPaintballBlocks.BLUE_FLAG,4));
                player.addItem(new ItemStack(MCPaintballBlocks.YELLOW_FLAG,4));
                player.addItem(new ItemStack(MCPaintballBlocks.PINK_FLAG,4));
                player.addItem(new ItemStack(MCPaintballBlocks.ORANGE_FLAG,4));
                player.addItem(new ItemStack(MCPaintballBlocks.CAPTURE_POINT,12));
            }
        }
    }
}
