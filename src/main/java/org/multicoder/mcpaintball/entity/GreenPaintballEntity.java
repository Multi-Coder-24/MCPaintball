package org.multicoder.mcpaintball.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballEntities;
import org.multicoder.mcpaintball.core.MCPaintballSounds;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;
import org.multicoder.mcpaintball.util.DebugHelper;

import java.util.Objects;

public class GreenPaintballEntity extends AbstractArrow {
    public GreenPaintballEntity(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
    }

    public GreenPaintballEntity(Player mob, Level level, @Nullable ItemStack firedFromWeapon) {
        super(MCPaintballEntities.GREEN_PAINTBALL.get(), mob, level, new ItemStack(Items.ARROW), firedFromWeapon);
    }

    @Override
    protected @NonNull ItemStack getDefaultPickupItem() {
        return new ItemStack(Items.ARROW);
    }

    @Override
    protected boolean tryPickup(@NonNull Player player) {return false;}

    @Override
    protected @NonNull SoundEvent getDefaultHitGroundSoundEvent() {
        return MCPaintballSounds.SPLAT.get();
    }

    @Override
    public void tick() {
        super.tick();
        if(this.isInGround() && this.inGroundTime >= 80){
            this.discard();
        }
    }
    @Override
    protected void onHitEntity(@NonNull EntityHitResult result) {
        if(result.getEntity() instanceof Player Target){
            if(MCPaintballGameEvents.INSTANCE.MatchStarted && MCPaintballGameEvents.INSTANCE.RoundStarted){
                MCPaintballPlayerData TargetData = Target.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get());
                if((Objects.requireNonNull(TargetData).Team != 0 && Objects.requireNonNull(TargetData).Team != 2)){
                    Objects.requireNonNull(level()).playSound(null, Objects.requireNonNull(this.getOwner()).blockPosition(),MCPaintballSounds.HIT.get(), SoundSource.PLAYERS,1f,1f);
                    MCPaintballGameEvents.INSTANCE.GreenPoints++;
                    MCPaintballGameEvents.INSTANCE.setDirty(true);
                }
            }
        }else if(MCPaintball.DEBUG){
            DebugHelper.HandleDebug(result,level(),2,(Player) this.getOwner());
        }
        super.discard();
    }
}
