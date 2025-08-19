package org.multicoder.mcpaintball.item.utility;

import net.minecraft.world.ContainerHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.data.attachments.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.attachments.PlayerTeamDataAttachment;
import org.multicoder.mcpaintball.data.component.ItemClassComponent;
import org.multicoder.mcpaintball.init.MCPaintballDataComponents;
import org.multicoder.mcpaintball.init.MCPaintballWeapons;

@SuppressWarnings("all")
public class ClassTokenItem extends Item {
    public ClassTokenItem(int Class) {
        super(new Properties().stacksTo(1).component(MCPaintballDataComponents.ITEM_CLASS.get(),new ItemClassComponent(Class)));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand usedHand) {
        if(!level.isClientSide) {
            ItemStack Stack = player.getItemInHand(usedHand);
            switch (Stack.get(MCPaintballDataComponents.ITEM_CLASS.get()).Class()){
                case 0: //No Class
                    return super.use(level,player,usedHand);
                case 1: //Standard Class
                    player.addItem(new ItemStack(MCPaintballWeapons.ASSAULT_RIFLE));
                    player.addItem(new ItemStack(MCPaintballWeapons.PISTOL));
                    break;
                case 2: //Heavy Class
                    player.addItem(new ItemStack(MCPaintballWeapons.BAZOOKA));
                    player.addItem(new ItemStack(MCPaintballWeapons.SHOTGUN));
                    break;
                case 3: //Sniper Class
                    player.addItem(new ItemStack(MCPaintballWeapons.SNIPER_RIFLE));
                    player.addItem(new ItemStack(MCPaintballWeapons.SHOTGUN));
                    break;
                case 4: //Medical Class
                    player.addItem(new ItemStack(MCPaintballWeapons.SHOTGUN));
                    player.addItem(new ItemStack(MCPaintballWeapons.PISTOL));
                    break;
                case 5: //Assault Class
                    player.addItem(new ItemStack(MCPaintballWeapons.BURST_RIFLE));
                    player.addItem(new ItemStack(MCPaintballWeapons.ASSAULT_RIFLE));
                    break;
            }
            int Class = Stack.get(MCPaintballDataComponents.ITEM_CLASS.get()).Class();
            PlayerTeamDataAttachment Team = player.getData(MCPaintballDataAttachments.PLAYER_TEAM.get());
            Team.Class = Class;
            player.setData(MCPaintballDataAttachments.PLAYER_TEAM.get(), Team);
            ContainerHelper.clearOrCountMatchingItems(player.getInventory(), x -> x.getItem() instanceof ClassTokenItem,7,false);
        }
        return super.use(level, player, usedHand);
    }
}
