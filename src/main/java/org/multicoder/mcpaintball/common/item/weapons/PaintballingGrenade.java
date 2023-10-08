package org.multicoder.mcpaintball.common.item.weapons;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.multicoder.mcpaintball.common.capability.PaintballPlayer;
import org.multicoder.mcpaintball.common.capability.PaintballPlayerProvider;
import org.multicoder.mcpaintball.common.entity.PaintballGrenade;
import org.multicoder.mcpaintball.common.init.soundinit;
import org.multicoder.mcpaintball.common.util.enums.Teams;

@SuppressWarnings("all")
public class PaintballingGrenade extends Item {
    public Teams team;

    public PaintballingGrenade() {
        super(new Properties());
    }


    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int p_41407_, boolean p_41408_) {

    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            PaintballPlayer PPlayer = player.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get();
            ThrowableItemProjectile Proj;
            EntityType<?> In = PPlayer.Team.GetGrenade();
            Proj = new PaintballGrenade((EntityType<? extends ThrowableItemProjectile>) In, player, level);
            Proj.shootFromRotation(player, player.getXRot(), player.getYRot(), 0f, 2.5f, 1f);
            level.addFreshEntity(Proj);
            level.playSound(null, player.blockPosition(), soundinit.GRENADE.get(), SoundSource.PLAYERS, 1f, 1f);
            player.getCooldowns().addCooldown(this, 30);
            return InteractionResultHolder.consume(player.getItemInHand(hand));
        }
        return InteractionResultHolder.fail(player.getItemInHand(hand));
    }
}
