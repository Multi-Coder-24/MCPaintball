
package org.multicoder.mcpaintball.item.utility;

import net.minecraft.world.ContainerHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.block.RefillStationBlockItem;
import org.multicoder.mcpaintball.data.attachments.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.attachments.PlayerTeamDataAttachment;
import org.multicoder.mcpaintball.item.armor.PaintballBoots;
import org.multicoder.mcpaintball.item.armor.PaintballChestplate;
import org.multicoder.mcpaintball.item.armor.PaintballHelmet;
import org.multicoder.mcpaintball.item.armor.PaintballLeggings;
import org.multicoder.mcpaintball.item.weapons.*;

public class TeamRemoverTokenItem extends Item {

    public TeamRemoverTokenItem()
    {
        super(new Properties().stacksTo(1));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand usedHand)
    {
        ContainerHelper.clearOrCountMatchingItems(player.getInventory(),x -> x.getItem() instanceof PaintballBoots,5,false);
        ContainerHelper.clearOrCountMatchingItems(player.getInventory(),x -> x.getItem() instanceof PaintballChestplate,5,false);
        ContainerHelper.clearOrCountMatchingItems(player.getInventory(),x -> x.getItem() instanceof PaintballLeggings,5,false);
        ContainerHelper.clearOrCountMatchingItems(player.getInventory(),x -> x.getItem() instanceof PaintballHelmet,5,false);
        ContainerHelper.clearOrCountMatchingItems(player.getInventory(),x -> x.getItem() instanceof AmmoHopper,5,false);
        ContainerHelper.clearOrCountMatchingItems(player.getInventory(),x -> x.getItem() instanceof PistolItem,5,false);
        ContainerHelper.clearOrCountMatchingItems(player.getInventory(),x -> x.getItem() instanceof ShotgunItem,5,false);
        ContainerHelper.clearOrCountMatchingItems(player.getInventory(),x -> x.getItem() instanceof AssaultRifleItem,5,false);
        ContainerHelper.clearOrCountMatchingItems(player.getInventory(),x -> x.getItem() instanceof BurstRifleItem,5,false);
        ContainerHelper.clearOrCountMatchingItems(player.getInventory(),x -> x.getItem() instanceof SniperRifleItem,5,false);
        ContainerHelper.clearOrCountMatchingItems(player.getInventory(),x -> x.getItem() instanceof BazookaItem,5,false);
        ContainerHelper.clearOrCountMatchingItems(player.getInventory(),x -> x.getItem() instanceof RefillStationBlockItem,5,false);
        player.getItemInHand(usedHand).shrink(1);
        PlayerTeamDataAttachment Team = player.getData(MCPaintballDataAttachments.PLAYER_TEAM.get());
        Team.Team = 0;
        Team.Class = 0;
        player.setData(MCPaintballDataAttachments.PLAYER_TEAM.get(), Team);
        return super.use(level, player, usedHand);
    }
}
