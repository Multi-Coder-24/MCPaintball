package org.multicoder.mcpaintball.util;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.multicoder.mcpaintball.core.MCPaintballBlocks;
import org.multicoder.mcpaintball.core.MCPaintballItems;

public class KitHandler {
    public static void grantKit(Player player, PaintballTeam team, PaintballRole type){
        switch (team) {
            case Red -> {
                switch (type){
                    case Captain -> {}
                    case Gunner -> {}
                    case Sniper -> {}
                    case Specialist -> {}
                    case Grenadier -> {}
                }
            }
            case Green -> {
                switch (type){
                    case Captain -> {}
                    case Gunner -> {}
                    case Sniper -> {}
                    case Specialist -> {}
                    case Grenadier -> {}
                }
            }
            case Blue -> { // blue
                switch (type){
                    case Captain -> {}
                    case Gunner -> {}
                    case Sniper -> {}
                    case Specialist -> {}
                    case Grenadier -> {}
                }
            }
            case Yellow -> {
                switch (type){
                    case Captain -> {}
                    case Gunner -> {}
                    case Sniper -> {}
                    case Specialist -> {}
                    case Grenadier -> {}
                }
            }case Pink -> {
                switch (type){
                    case Captain -> {}
                    case Gunner -> {}
                    case Sniper -> {}
                    case Specialist -> {}
                    case Grenadier -> {}
                }
            }case Orange -> {
                switch (type){
                    case Captain -> {}
                    case Gunner -> {}
                    case Sniper -> {}
                    case Specialist -> {}
                    case Grenadier -> {}
                }
            }
            case Admin -> {}
        }
    }
}
