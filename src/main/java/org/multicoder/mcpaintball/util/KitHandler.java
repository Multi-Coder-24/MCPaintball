package org.multicoder.mcpaintball.util;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.multicoder.mcpaintball.core.MCPaintballBlocks;
import org.multicoder.mcpaintball.core.MCPaintballItems;

public class KitHandler {
    public static void grantKit(Player player, PaintballTeam team, PaintballRole type){
        switch (team) {
            case Red -> {
                player.addItem(new ItemStack(MCPaintballItems.RED_BOOTS.get()));
                player.addItem(new ItemStack(MCPaintballItems.RED_LEGGINGS.get()));
                player.addItem(new ItemStack(MCPaintballItems.RED_CHESTPLATE.get()));
                player.addItem(new ItemStack(MCPaintballItems.RED_HELMET.get()));
                switch (type){
                    case Captain -> {
                        player.addItem(new ItemStack(MCPaintballItems.ASSAULT_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballBlocks.RED_TOWER.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.RED_PAINT_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),2));
                    }
                    case Gunner -> {
                        player.addItem(new ItemStack(MCPaintballItems.BURST_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.RED_PAINT_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),2));
                    }
                    case Sniper -> {
                        player.addItem(new ItemStack(MCPaintballItems.SNIPER_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.RED_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),6));
                    }
                    case Specialist -> {
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballBlocks.RED_PAINT_MINE.get(), 8));
                        player.addItem(new ItemStack(MCPaintballBlocks.RED_CLAYMORE_BLOCK.get(),4));
                        player.addItem(new ItemStack(MCPaintballBlocks.RED_GRENADE_STATION.get(),2));
                    }
                    case Grenadier -> {
                        player.addItem(new ItemStack(MCPaintballItems.GRENADE_LAUNCHER.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(), 10));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(), 10));
                        player.addItem(new ItemStack(MCPaintballItems.SIGHT_GRENADE.get(), 10));
                        player.addItem(new ItemStack(MCPaintballItems.RED_PAINT_GRENADE.get(), 16));
                    }
                }
            }
            case Green -> {
                player.addItem(new ItemStack(MCPaintballItems.GREEN_BOOTS.get()));
                player.addItem(new ItemStack(MCPaintballItems.GREEN_LEGGINGS.get()));
                player.addItem(new ItemStack(MCPaintballItems.GREEN_CHESTPLATE.get()));
                player.addItem(new ItemStack(MCPaintballItems.GREEN_HELMET.get()));
                switch (type){
                    case Captain -> {
                        player.addItem(new ItemStack(MCPaintballItems.ASSAULT_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballBlocks.GREEN_TOWER.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.GREEN_PAINT_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),2));
                    }
                    case Gunner -> {
                        player.addItem(new ItemStack(MCPaintballItems.BURST_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.GREEN_PAINT_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),2));
                    }
                    case Sniper -> {
                        player.addItem(new ItemStack(MCPaintballItems.SNIPER_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.GREEN_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),6));
                    }
                    case Specialist -> {
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballBlocks.GREEN_PAINT_MINE.get(), 8));
                        player.addItem(new ItemStack(MCPaintballBlocks.GREEN_CLAYMORE_BLOCK.get(),4));
                        player.addItem(new ItemStack(MCPaintballBlocks.GREEN_GRENADE_STATION.get(),2));
                    }
                    case Grenadier -> {
                        player.addItem(new ItemStack(MCPaintballItems.GRENADE_LAUNCHER.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(), 10));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(), 10));
                        player.addItem(new ItemStack(MCPaintballItems.SIGHT_GRENADE.get(), 10));
                        player.addItem(new ItemStack(MCPaintballItems.GREEN_PAINT_GRENADE.get(), 16));
                    }
                }
            }
            case Blue -> { // blue
                player.addItem(new ItemStack(MCPaintballItems.BLUE_BOOTS.get()));
                player.addItem(new ItemStack(MCPaintballItems.BLUE_LEGGINGS.get()));
                player.addItem(new ItemStack(MCPaintballItems.BLUE_CHESTPLATE.get()));
                player.addItem(new ItemStack(MCPaintballItems.BLUE_HELMET.get()));
                switch (type){
                    case Captain -> {
                        player.addItem(new ItemStack(MCPaintballItems.ASSAULT_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballBlocks.BLUE_TOWER.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.BLUE_PAINT_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),2));
                    }
                    case Gunner -> {
                        player.addItem(new ItemStack(MCPaintballItems.BURST_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.BLUE_PAINT_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),2));
                    }
                    case Sniper -> {
                        player.addItem(new ItemStack(MCPaintballItems.SNIPER_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.BLUE_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),6));
                    }
                    case Specialist -> {
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballBlocks.BLUE_PAINT_MINE.get(), 8));
                        player.addItem(new ItemStack(MCPaintballBlocks.BLUE_CLAYMORE_BLOCK.get(),4));
                        player.addItem(new ItemStack(MCPaintballBlocks.BLUE_GRENADE_STATION.get(),2));
                    }
                    case Grenadier -> {
                        player.addItem(new ItemStack(MCPaintballItems.GRENADE_LAUNCHER.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(), 10));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(), 10));
                        player.addItem(new ItemStack(MCPaintballItems.SIGHT_GRENADE.get(), 10));
                        player.addItem(new ItemStack(MCPaintballItems.BLUE_PAINT_GRENADE.get(), 16));
                    }
                }
            }
            case Yellow -> {
                player.addItem(new ItemStack(MCPaintballItems.YELLOW_BOOTS.get()));
                player.addItem(new ItemStack(MCPaintballItems.YELLOW_LEGGINGS.get()));
                player.addItem(new ItemStack(MCPaintballItems.YELLOW_CHESTPLATE.get()));
                player.addItem(new ItemStack(MCPaintballItems.YELLOW_HELMET.get()));
                switch (type){
                    case Captain -> {
                        player.addItem(new ItemStack(MCPaintballItems.ASSAULT_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballBlocks.YELLOW_TOWER.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.YELLOW_PAINT_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),2));
                    }
                    case Gunner -> {
                        player.addItem(new ItemStack(MCPaintballItems.BURST_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.YELLOW_PAINT_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),2));
                    }
                    case Sniper -> {
                        player.addItem(new ItemStack(MCPaintballItems.SNIPER_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.YELLOW_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),6));
                    }
                    case Specialist -> {
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballBlocks.YELLOW_PAINT_MINE.get(), 8));
                        player.addItem(new ItemStack(MCPaintballBlocks.YELLOW_CLAYMORE_BLOCK.get(),4));
                        player.addItem(new ItemStack(MCPaintballBlocks.YELLOW_GRENADE_STATION.get(),2));
                    }
                    case Grenadier -> {
                        player.addItem(new ItemStack(MCPaintballItems.GRENADE_LAUNCHER.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(), 10));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(), 10));
                        player.addItem(new ItemStack(MCPaintballItems.SIGHT_GRENADE.get(), 10));
                        player.addItem(new ItemStack(MCPaintballItems.YELLOW_PAINT_GRENADE.get(), 16));
                    }
                }
            }case Pink -> {
                player.addItem(new ItemStack(MCPaintballItems.PINK_BOOTS.get()));
                player.addItem(new ItemStack(MCPaintballItems.PINK_LEGGINGS.get()));
                player.addItem(new ItemStack(MCPaintballItems.PINK_CHESTPLATE.get()));
                player.addItem(new ItemStack(MCPaintballItems.PINK_HELMET.get()));
                switch (type){
                    case Captain -> {
                        player.addItem(new ItemStack(MCPaintballItems.ASSAULT_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballBlocks.PINK_TOWER.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.PINK_PAINT_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),2));
                    }
                    case Gunner -> {
                        player.addItem(new ItemStack(MCPaintballItems.BURST_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.PINK_PAINT_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),2));
                    }
                    case Sniper -> {
                        player.addItem(new ItemStack(MCPaintballItems.SNIPER_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.PINK_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),6));
                    }
                    case Specialist -> {
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballBlocks.PINK_PAINT_MINE.get(), 8));
                        player.addItem(new ItemStack(MCPaintballBlocks.PINK_CLAYMORE_BLOCK.get(),4));
                        player.addItem(new ItemStack(MCPaintballBlocks.PINK_GRENADE_STATION.get(),2));
                    }
                    case Grenadier -> {
                        player.addItem(new ItemStack(MCPaintballItems.GRENADE_LAUNCHER.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(), 10));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(), 10));
                        player.addItem(new ItemStack(MCPaintballItems.SIGHT_GRENADE.get(), 10));
                        player.addItem(new ItemStack(MCPaintballItems.PINK_PAINT_GRENADE.get(), 16));
                    }
                }
            }case Orange -> {
                player.addItem(new ItemStack(MCPaintballItems.ORANGE_BOOTS.get()));
                player.addItem(new ItemStack(MCPaintballItems.ORANGE_LEGGINGS.get()));
                player.addItem(new ItemStack(MCPaintballItems.ORANGE_CHESTPLATE.get()));
                player.addItem(new ItemStack(MCPaintballItems.ORANGE_HELMET.get()));
                switch (type){
                    case Captain -> {
                        player.addItem(new ItemStack(MCPaintballItems.ASSAULT_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballBlocks.ORANGE_TOWER.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.ORANGE_PAINT_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),2));
                    }
                    case Gunner -> {
                        player.addItem(new ItemStack(MCPaintballItems.BURST_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.ORANGE_PAINT_GRENADE.get(),4));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),2));
                    }
                    case Sniper -> {
                        player.addItem(new ItemStack(MCPaintballItems.SNIPER_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.ORANGE_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),6));
                    }
                    case Specialist -> {
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballBlocks.ORANGE_PAINT_MINE.get(), 8));
                        player.addItem(new ItemStack(MCPaintballBlocks.ORANGE_CLAYMORE_BLOCK.get(),4));
                        player.addItem(new ItemStack(MCPaintballBlocks.ORANGE_GRENADE_STATION.get(),2));
                    }
                    case Grenadier -> {
                        player.addItem(new ItemStack(MCPaintballItems.GRENADE_LAUNCHER.get()));
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(), 10));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(), 10));
                        player.addItem(new ItemStack(MCPaintballItems.SIGHT_GRENADE.get(), 10));
                        player.addItem(new ItemStack(MCPaintballItems.ORANGE_PAINT_GRENADE.get(), 16));
                    }
                }
            }
            case Admin -> {
                player.addItem(new ItemStack(MCPaintballBlocks.RED_FLAG.get(),4));
                player.addItem(new ItemStack(MCPaintballBlocks.GREEN_FLAG.get(),4));
                player.addItem(new ItemStack(MCPaintballBlocks.BLUE_FLAG.get(),4));
                player.addItem(new ItemStack(MCPaintballBlocks.YELLOW_FLAG.get(),4));
                player.addItem(new ItemStack(MCPaintballBlocks.PINK_FLAG.get(),4));
                player.addItem(new ItemStack(MCPaintballBlocks.ORANGE_FLAG.get(),4));
                player.addItem(new ItemStack(MCPaintballBlocks.CAPTURE_POINT.get(),12));
            }
        }
    }
}
