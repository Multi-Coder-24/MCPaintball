package org.multicoder.mcpaintball.util;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.multicoder.mcpaintball.core.MCPaintballBlocks;
import org.multicoder.mcpaintball.core.MCPaintballItems;

public class KitHandler {
    public static void GrantKit(Player player,int Team,int Type){
        switch (Team) {
            case 1 -> { // Red Team
                player.addItem(new ItemStack(MCPaintballItems.RED_BOOTS));
                player.addItem(new ItemStack(MCPaintballItems.RED_LEGGINGS));
                player.addItem(new ItemStack(MCPaintballItems.RED_CHESTPLATE));
                player.addItem(new ItemStack(MCPaintballItems.RED_HELMET));
                player.addItem(new ItemStack(MCPaintballBlocks.RED_GRENADE_STATION,2));
                player.addItem(new ItemStack(MCPaintballBlocks.RED_RESPAWN_STATION));
                switch (Type){
                    case 1 -> { // Standard
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballItems.ASSAULT_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.RED_PAINT_GRENADE,8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE,4));
                    }
                    case 2 -> { // Sniper
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN));
                        player.addItem(new ItemStack(MCPaintballItems.SNIPER_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.RED_PAINT_GRENADE,8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,16));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE,6));
                    }
                    case 3 -> { // Assault
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN));
                        player.addItem(new ItemStack(MCPaintballItems.BURST_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.RED_PAINT_GRENADE,8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE,2));
                    }
                    case 4 -> { // Heavy
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballItems.GRENADE_LAUNCHER));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,16));
                    }
                }
            }
            case 2 -> { // Green
                player.addItem(new ItemStack(MCPaintballItems.GREEN_BOOTS));
                player.addItem(new ItemStack(MCPaintballItems.GREEN_LEGGINGS));
                player.addItem(new ItemStack(MCPaintballItems.GREEN_CHESTPLATE));
                player.addItem(new ItemStack(MCPaintballItems.GREEN_HELMET));
                player.addItem(new ItemStack(MCPaintballBlocks.GREEN_GRENADE_STATION,2));
                player.addItem(new ItemStack(MCPaintballBlocks.GREEN_RESPAWN_STATION));
                switch (Type){
                    case 1 -> { // Standard
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballItems.ASSAULT_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.GREEN_PAINT_GRENADE,8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,4));
                    }
                    case 2 -> { // Sniper
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN));
                        player.addItem(new ItemStack(MCPaintballItems.SNIPER_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.GREEN_PAINT_GRENADE,8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,16));
                    }
                    case 3 -> { // Assault
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN));
                        player.addItem(new ItemStack(MCPaintballItems.BURST_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.GREEN_PAINT_GRENADE,8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,4));
                    }
                    case 4 -> { // Heavy
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballItems.GRENADE_LAUNCHER));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,16));
                    }
                }
            }
            case 3 -> { // Blue
                player.addItem(new ItemStack(MCPaintballItems.BLUE_BOOTS));
                player.addItem(new ItemStack(MCPaintballItems.BLUE_LEGGINGS));
                player.addItem(new ItemStack(MCPaintballItems.BLUE_CHESTPLATE));
                player.addItem(new ItemStack(MCPaintballItems.BLUE_HELMET));
                player.addItem(new ItemStack(MCPaintballBlocks.BLUE_GRENADE_STATION,2));
                player.addItem(new ItemStack(MCPaintballBlocks.BLUE_RESPAWN_STATION));
                switch (Type){
                    case 1 -> { // Standard
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballItems.ASSAULT_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.BLUE_PAINT_GRENADE,8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,4));
                    }
                    case 2 -> { // Sniper
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN));
                        player.addItem(new ItemStack(MCPaintballItems.SNIPER_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.BLUE_PAINT_GRENADE,8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,16));
                    }
                    case 3 -> { // Assault
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN));
                        player.addItem(new ItemStack(MCPaintballItems.BURST_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.BLUE_PAINT_GRENADE,8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,4));
                    }
                    case 4 -> { // Heavy
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballItems.GRENADE_LAUNCHER));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,16));
                    }
                }
            }
            case 4 -> { // Red Team
                player.addItem(new ItemStack(MCPaintballItems.YELLOW_BOOTS));
                player.addItem(new ItemStack(MCPaintballItems.YELLOW_LEGGINGS));
                player.addItem(new ItemStack(MCPaintballItems.YELLOW_CHESTPLATE));
                player.addItem(new ItemStack(MCPaintballItems.YELLOW_HELMET));
                player.addItem(new ItemStack(MCPaintballBlocks.YELLOW_GRENADE_STATION,2));
                player.addItem(new ItemStack(MCPaintballBlocks.YELLOW_RESPAWN_STATION));
                switch (Type){
                    case 1 -> { // Standard
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballItems.ASSAULT_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.YELLOW_PAINT_GRENADE,8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE,4));
                    }
                    case 2 -> { // Sniper
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN));
                        player.addItem(new ItemStack(MCPaintballItems.SNIPER_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.YELLOW_PAINT_GRENADE,8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,16));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE,6));
                    }
                    case 3 -> { // Assault
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN));
                        player.addItem(new ItemStack(MCPaintballItems.BURST_RIFLE));
                        player.addItem(new ItemStack(MCPaintballItems.YELLOW_PAINT_GRENADE,8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE,2));
                    }
                    case 4 -> { // Heavy
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL));
                        player.addItem(new ItemStack(MCPaintballItems.GRENADE_LAUNCHER));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE,16));
                    }
                }
            }
        }
    }
}
