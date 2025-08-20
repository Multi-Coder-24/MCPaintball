package org.multicoder.mcpaintball.item.weapons;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.data.PaintballTeam;
import org.multicoder.mcpaintball.data.attachments.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.component.ItemTeamDataComponent;
import org.multicoder.mcpaintball.entity.PaintballEntity;
import org.multicoder.mcpaintball.init.MCPaintballDataComponents;
import org.multicoder.mcpaintball.item.utility.AmmoHopper;
import org.multicoder.mcpaintball.init.MCPaintballSounds;

public class ShotgunItem extends Item {

    public ShotgunItem() {
        super(new Properties().stacksTo(1).component(MCPaintballDataComponents.ITEM_TEAM.value(),new ItemTeamDataComponent(0)));    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand usedHand) {
        if(!level.isClientSide) {
            if (player.getOffhandItem().getItem() instanceof AmmoHopper) {
                ItemStack Ammo = player.getOffhandItem();
                if (Ammo.getDamageValue() < Ammo.getMaxDamage()) {
                    Ammo.setDamageValue(Ammo.getDamageValue() + 1);
                    PaintballTeam team = PaintballTeam.values()[player.getData(MCPaintballDataAttachments.PLAYER_TEAM).Team];
                    PaintballEntity paintball1 = new PaintballEntity((EntityType<? extends AbstractArrow>) PaintballTeam.getEntityType(team),player,level);
                    PaintballEntity paintball2 = new PaintballEntity((EntityType<? extends AbstractArrow>) PaintballTeam.getEntityType(team),player,level);
                    PaintballEntity paintball3 = new PaintballEntity((EntityType<? extends AbstractArrow>) PaintballTeam.getEntityType(team),player,level);
                    paintball1.shootFromRotation(player,player.getXRot(),player.getYRot() + 3F,0F,2F,0F);
                    paintball2.shootFromRotation(player,player.getXRot(),player.getYRot(),0F,2F,0.0F);
                    paintball3.shootFromRotation(player,player.getXRot(),player.getYRot() - 3F,0.0F,2F,0F);
                    level.addFreshEntity(paintball1);
                    level.addFreshEntity(paintball2);
                    level.addFreshEntity(paintball3);
                    player.getCooldowns().addCooldown(this, 80);
                    level.playSound(null,player.blockPosition(), MCPaintballSounds.SINGLE_SHOT.get(), SoundSource.PLAYERS,1.0F,1.0F);
                }
            }
        }
        return super.use(level, player, usedHand);
    }
}
