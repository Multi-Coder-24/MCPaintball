package org.multicoder.mcpaintball.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.data.PaintballTeam;
import org.multicoder.mcpaintball.data.attachments.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.level.PaintballWorldData;
import org.multicoder.mcpaintball.init.MCPaintballSounds;

import java.util.Objects;

public class PaintballEntity extends AbstractArrow
{

    public PaintballEntity(EntityType<? extends AbstractArrow> entityType, Level level)
    {
        super(entityType, level);
    }

    @Override
    protected @NotNull ItemStack getDefaultPickupItem() {
        return new ItemStack(Items.AIR);
    }

    @Override
    protected void onHitEntity(@NotNull EntityHitResult result)
    {
        Level level = level();
        if(!level.isClientSide)
        {
            if(PaintballWorldData.INSTANCE.GAME_STARTED){
                if(result.getEntity() instanceof Player player){
                    PaintballTeam team = PaintballTeam.fromEntitytType(this);
                    if(player.getData(MCPaintballDataAttachments.PLAYER_TEAM).Team != 0 && player.getData(MCPaintballDataAttachments.PLAYER_TEAM.get()).Team != team.ordinal()){
                        Objects.requireNonNull(this.getOwner()).playSound(MCPaintballSounds.HIT.get());
                        PaintballWorldData.incrementByIndex(team.ordinal());
                    }
                }
            }
            this.discard();
        }
    }

    @Override
    public void tick() {
        super.tick();
        if(this.inGroundTime == 100){
            this.discard();
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result)
    {
        level().playSound(null,result.getBlockPos(),MCPaintballSounds.SPLAT.get(), SoundSource.NEUTRAL,1F,1F);
        super.onHitBlock(result);
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return MCPaintballSounds.SPLAT.get();
    }
}
