package org.multicoder.mcpaintball.item.utility;

import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.init.MCPaintballBlocks;
import org.multicoder.mcpaintball.data.attachments.*;
import org.multicoder.mcpaintball.data.component.*;
import org.multicoder.mcpaintball.init.MCPaintballArmor;
import org.multicoder.mcpaintball.init.MCPaintballDataComponents;
import org.multicoder.mcpaintball.init.MCPaintballUtilities;

@SuppressWarnings("all")
public class TeamTokenItem extends Item {
    public TeamTokenItem(int Team){
        super(new Properties().stacksTo(1).component(MCPaintballDataComponents.ITEM_TEAM.get(),new ItemTeamDataComponent(Team)));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, @NotNull Player player, @NotNull InteractionHand usedHand) {
        if(!level.isClientSide){
            ItemStack itemStack = player.getItemInHand(usedHand);
            switch(itemStack.get(MCPaintballDataComponents.ITEM_TEAM).team()){
                case 0: //NO Team
                    return super.use(level, player, usedHand);
                case 1: //Red Team
                    player.addItem(new ItemStack(MCPaintballArmor.RED_BOOTS));
                    player.addItem(new ItemStack(MCPaintballArmor.RED_LEGGINGS));
                    player.addItem(new ItemStack(MCPaintballArmor.RED_CHESTPLATE));
                    player.addItem(new ItemStack(MCPaintballArmor.RED_HELMET));
                    player.addItem(new ItemStack(MCPaintballUtilities.RED_AMMO_HOPPER));
                    player.addItem(new ItemStack(MCPaintballBlocks.RED_REFILL_STATION.value().asItem()));
                    break;
                case 2: //Green Team
                    player.addItem(new ItemStack(MCPaintballArmor.GREEN_BOOTS));
                    player.addItem(new ItemStack(MCPaintballArmor.GREEN_LEGGINGS));
                    player.addItem(new ItemStack(MCPaintballArmor.GREEN_CHESTPLATE));
                    player.addItem(new ItemStack(MCPaintballArmor.GREEN_HELMET));
                    player.addItem(new ItemStack(MCPaintballUtilities.GREEN_AMMO_HOPPER));
                    player.addItem(new ItemStack(MCPaintballBlocks.GREEN_REFILL_STATION.value().asItem()));

                    break;
                case 3: //Blue Team
                    player.addItem(new ItemStack(MCPaintballArmor.BLUE_BOOTS));
                    player.addItem(new ItemStack(MCPaintballArmor.BLUE_LEGGINGS));
                    player.addItem(new ItemStack(MCPaintballArmor.BLUE_CHESTPLATE));
                    player.addItem(new ItemStack(MCPaintballArmor.BLUE_HELMET));
                    player.addItem(new ItemStack(MCPaintballUtilities.BLUE_AMMO_HOPPER));
                    player.addItem(new ItemStack(MCPaintballBlocks.BLUE_REFILL_STATION.value().asItem()));
                    break;
                case 4: //Cyan Team
                    player.addItem(new ItemStack(MCPaintballArmor.CYAN_BOOTS));
                    player.addItem(new ItemStack(MCPaintballArmor.CYAN_LEGGINGS));
                    player.addItem(new ItemStack(MCPaintballArmor.CYAN_CHESTPLATE));
                    player.addItem(new ItemStack(MCPaintballArmor.CYAN_HELMET));
                    player.addItem(new ItemStack(MCPaintballUtilities.CYAN_AMMO_HOPPER));
                    player.addItem(new ItemStack(MCPaintballBlocks.CYAN_REFILL_STATION.value().asItem()));
                    break;
                case 5: //Magenta Team
                    player.addItem(new ItemStack(MCPaintballArmor.MAGENTA_BOOTS));
                    player.addItem(new ItemStack(MCPaintballArmor.MAGENTA_LEGGINGS));
                    player.addItem(new ItemStack(MCPaintballArmor.MAGENTA_CHESTPLATE));
                    player.addItem(new ItemStack(MCPaintballArmor.MAGENTA_HELMET));
                    player.addItem(new ItemStack(MCPaintballUtilities.MAGENTA_AMMO_HOPPER));
                    player.addItem(new ItemStack(MCPaintballBlocks.MAGENTA_REFILL_STATION.value().asItem()));
                    break;
                case 6: //Yellow Team
                    player.addItem(new ItemStack(MCPaintballArmor.YELLOW_BOOTS));
                    player.addItem(new ItemStack(MCPaintballArmor.YELLOW_LEGGINGS));
                    player.addItem(new ItemStack(MCPaintballArmor.YELLOW_CHESTPLATE));
                    player.addItem(new ItemStack(MCPaintballArmor.YELLOW_HELMET));
                    player.addItem(new ItemStack(MCPaintballUtilities.YELLOW_AMMO_HOPPER));
                    player.addItem(new ItemStack(MCPaintballBlocks.YELLOW_REFILL_STATION.value().asItem()));
                    break;
                case 7: //Lime Team
                    player.addItem(new ItemStack(MCPaintballArmor.LIME_BOOTS));
                    player.addItem(new ItemStack(MCPaintballArmor.LIME_LEGGINGS));
                    player.addItem(new ItemStack(MCPaintballArmor.LIME_CHESTPLATE));
                    player.addItem(new ItemStack(MCPaintballArmor.LIME_HELMET));
                    player.addItem(new ItemStack(MCPaintballUtilities.LIME_AMMO_HOPPER));
                    player.addItem(new ItemStack(MCPaintballBlocks.LIME_REFILL_STATION.value().asItem()));
                    break;
                case 8: //Light Blue Team
                    player.addItem(new ItemStack(MCPaintballArmor.LIGHT_BLUE_BOOTS));
                    player.addItem(new ItemStack(MCPaintballArmor.LIGHT_BLUE_LEGGINGS));
                    player.addItem(new ItemStack(MCPaintballArmor.LIGHT_BLUE_CHESTPLATE));
                    player.addItem(new ItemStack(MCPaintballArmor.LIGHT_BLUE_HELMET));
                    player.addItem(new ItemStack(MCPaintballUtilities.LIGHT_BLUE_AMMO_HOPPER));
                    player.addItem(new ItemStack(MCPaintballBlocks.LIGHT_BLUE_REFILL_STATION.value().asItem()));
                    break;
                case 9: //Pink Team
                    player.addItem(new ItemStack(MCPaintballArmor.PINK_BOOTS));
                    player.addItem(new ItemStack(MCPaintballArmor.PINK_LEGGINGS));
                    player.addItem(new ItemStack(MCPaintballArmor.PINK_CHESTPLATE));
                    player.addItem(new ItemStack(MCPaintballArmor.PINK_HELMET));
                    player.addItem(new ItemStack(MCPaintballUtilities.PINK_AMMO_HOPPER));
                    player.addItem(new ItemStack(MCPaintballBlocks.PINK_REFILL_STATION.value().asItem()));
                    break;
                case 10: //White Team
                    player.addItem(new ItemStack(MCPaintballArmor.WHITE_BOOTS));
                    player.addItem(new ItemStack(MCPaintballArmor.WHITE_LEGGINGS));
                    player.addItem(new ItemStack(MCPaintballArmor.WHITE_CHESTPLATE));
                    player.addItem(new ItemStack(MCPaintballArmor.WHITE_HELMET));
                    player.addItem(new ItemStack(MCPaintballUtilities.WHITE_AMMO_HOPPER));
                    player.addItem(new ItemStack(MCPaintballBlocks.WHITE_REFILL_STATION.value().asItem()));
                    break;
            }
            player.addItem(new ItemStack(MCPaintballUtilities.TEAM_REMOVER_TOKEN));
            player.addItem(new ItemStack(MCPaintballUtilities.STANDARD_CLASS_TOKEN));
            player.addItem(new ItemStack(MCPaintballUtilities.SNIPER_CLASS_TOKEN));
            player.addItem(new ItemStack(MCPaintballUtilities.MEDIC_CLASS_TOKEN));
            player.addItem(new ItemStack(MCPaintballUtilities.HEAVY_CLASS_TOKEN));
            player.addItem(new ItemStack(MCPaintballUtilities.ASSAULT_CLASS_TOKEN));
            player.addItem(new ItemStack(MCPaintballUtilities.SPECIALIST_CLASS_TOKEN));
            int Team = itemStack.get(MCPaintballDataComponents.ITEM_TEAM.get()).team();
            PlayerTeamDataAttachment Data = player.getData(MCPaintballDataAttachments.PLAYER_TEAM.get());
            Data.Team = Team;
            player.setData(MCPaintballDataAttachments.PLAYER_TEAM.get(), Data);
            itemStack.shrink(1);
        }
        return super.use(level, player, usedHand);
    }
}
