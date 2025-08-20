package org.multicoder.mcpaintball.item.weapons;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.data.PaintballTeam;
import org.multicoder.mcpaintball.data.attachments.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.component.ItemTeamDataComponent;
import org.multicoder.mcpaintball.entity.PaintballEntity;
import org.multicoder.mcpaintball.init.MCPaintballDataComponents;
import org.multicoder.mcpaintball.item.utility.AmmoHopper;
import org.multicoder.mcpaintball.init.MCPaintballSounds;

@SuppressWarnings("unchecked")
public class AssaultRifleItem extends Item {

    public AssaultRifleItem() {
        super(new Properties().stacksTo(1).component(MCPaintballDataComponents.ITEM_TEAM.value(),new ItemTeamDataComponent(0)));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand usedHand)
    {
        if(!level.isClientSide)
        {
            if(player.getOffhandItem().getItem() instanceof AmmoHopper)
            {
                ItemStack Ammo = player.getOffhandItem();
                if(Ammo.getDamageValue() < Ammo.getMaxDamage())
                {
                    Ammo.setDamageValue(Ammo.getDamageValue()+1);
                    PaintballTeam team = PaintballTeam.values()[player.getData(MCPaintballDataAttachments.PLAYER_TEAM).Team];
                    MCPaintball.LOG.debug("Player Team: {}, Player Team As Enum: {}",player.getData(MCPaintballDataAttachments.PLAYER_TEAM.get()).Team,team);
                    PaintballEntity paintball = new PaintballEntity((EntityType<? extends AbstractArrow>) PaintballTeam.getEntityType(team),level);
                    paintball.shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.0F);
                    level.addFreshEntity(paintball);
                    player.getCooldowns().addCooldown(this, 20);
                    level.playSound(null,player.blockPosition(), MCPaintballSounds.SINGLE_SHOT.get(), SoundSource.PLAYERS,1.0F,1.0F);
                }
                else {
                    player.displayClientMessage(Component.translatable("text.mcpaintball.ammo_hopper_empty").withStyle(ChatFormatting.DARK_RED),true);
                }
            }
        }
        return super.use(level, player, usedHand);
    }
}
