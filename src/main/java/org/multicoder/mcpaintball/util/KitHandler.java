package org.multicoder.mcpaintball.util;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.multicoder.mcpaintball.core.MCPaintballItems;

public class KitHandler {
    public static void GrantKit(Player player,int Team,int Type){
        switch (Team) {
            case 1 -> { // Red Team
                player.addItem(new ItemStack(MCPaintballItems.RED_BOOTS.get()));
                player.addItem(new ItemStack(MCPaintballItems.RED_LEGGINGS.get()));
                player.addItem(new ItemStack(MCPaintballItems.RED_CHESTPLATE.get()));
                player.addItem(new ItemStack(MCPaintballItems.RED_HELMET.get()));
                switch (Type){
                    case 1 -> { // Standard
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.ASSAULT_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.RED_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                    }
                    case 2 -> { // Sniper
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SNIPER_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.RED_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),16));
                    }
                    case 3 -> { // Assault
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        player.addItem(new ItemStack(MCPaintballItems.BURST_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.RED_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
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
                switch (Type){
                    case 1 -> { // Standard
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.ASSAULT_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.GREEN_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                    }
                    case 2 -> { // Sniper
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SNIPER_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.GREEN_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),16));
                    }
                    case 3 -> { // Assault
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        player.addItem(new ItemStack(MCPaintballItems.BURST_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.GREEN_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
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
                switch (Type){
                    case 1 -> { // Standard
                        player.addItem(new ItemStack(MCPaintballItems.PISTOL.get()));
                        player.addItem(new ItemStack(MCPaintballItems.ASSAULT_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.BLUE_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                    }
                    case 2 -> { // Sniper
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        player.addItem(new ItemStack(MCPaintballItems.SNIPER_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.BLUE_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),16));
                    }
                    case 3 -> { // Assault
                        player.addItem(new ItemStack(MCPaintballItems.SHOTGUN.get()));
                        player.addItem(new ItemStack(MCPaintballItems.BURST_RIFLE.get()));
                        player.addItem(new ItemStack(MCPaintballItems.BLUE_PAINT_GRENADE.get(),8));
                        player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
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
