package org.multicoder.mcpaintball.common.entity.paintball;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.multicoder.mcpaintball.common.init.MCPaintballSounds;
import org.multicoder.mcpaintball.common.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;

@SuppressWarnings("all")
public class GrayHeavyPaintballEntity extends AbstractArrow {
    public GrayHeavyPaintballEntity(EntityType<?> p_36721_, Level p_36722_) {
        super((EntityType<? extends AbstractArrow>) p_36721_, p_36722_, ItemStack.EMPTY);
    }

    public GrayHeavyPaintballEntity(EntityType<?> p_36717_, LivingEntity p_36718_, Level p_36719_) {
        super((EntityType<? extends AbstractArrow>) p_36717_, p_36718_, p_36719_, ItemStack.EMPTY);
    }

    @Override
    protected void onHitBlock(BlockHitResult hitResult)
    {
        if (MCPaintballWorldData.INSTANCE.MatchStarted)
        {
            BlockPos Position = hitResult.getBlockPos();
            Level.ExplosionInteraction Interaction = (MCPaintballWorldData.INSTANCE.GAME_TYPE == 3) ? Level.ExplosionInteraction.TNT : Level.ExplosionInteraction.NONE;
            Explosion E = level().explode(this, Position.getX(), Position.getY(), Position.getZ(), 2f,Interaction);
            E.getHitPlayers().keySet().forEach(player ->
            {
                if (MCPaintballTeamsDataHelper.HasTeam(player))
                {
                    int Team = MCPaintballTeamsDataHelper.FetchTeam(player);
                    Player shooter = (Player) getOwner();
                    MCPaintballTeamsDataHelper.AddPoint(shooter);
                }
            });
        }
        this.kill();
        this.discard();
    }

    @Override
    public void tick() {
        super.tick();
        if (this.inGroundTime == 100) {
            this.kill();
            this.discard();
        }
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return MCPaintballSounds.SPLAT.get();
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }
}
