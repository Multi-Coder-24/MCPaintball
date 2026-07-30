package org.multicoder.mcpaintball.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
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

public class PaintballEntity extends AbstractArrow {
    public PaintballEntity(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
    }

    public PaintballEntity(EntityType<? extends AbstractArrow> type,Player mob, Level level, @Nullable ItemStack firedFromWeapon) {
        super(type, mob, level, new ItemStack(Items.ARROW), firedFromWeapon);
    }

    @Override
    public @NonNull ItemStack getDefaultPickupItem() {
        return new ItemStack(Items.ARROW);
    }

    @Override
    protected boolean tryPickup(@NonNull Player player) {return false;}

    @Override
    public void tick() {
        super.tick();
        if(this.isInGround() && this.inGroundTime >= 80){
            this.discard();
        }
    }

    @Override
    protected @NonNull SoundEvent getDefaultHitGroundSoundEvent() {
        return MCPaintballSounds.SPLAT;
    }

    @Override
    protected void onHitEntity(@NonNull EntityHitResult result) {
        if(!level().isClientSide()){
            if(result.getEntity() instanceof ServerPlayer Target){
                if(MCPaintballGameEvents.INSTANCE.MatchStarted && MCPaintballGameEvents.INSTANCE.RoundStarted){
                    MCPaintballPlayerData TargetData = Target.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER);
                    if(Objects.requireNonNull(TargetData).Team != 0){
                        EntityType<?> type = getType();
                        if(type == MCPaintballEntities.RED_PAINTBALL && TargetData.Team != 1){
                            level().playSound(null, Objects.requireNonNull(this.getOwner()).blockPosition(),MCPaintballSounds.HIT, SoundSource.PLAYERS,1f,1f);
                            MCPaintballGameEvents.INSTANCE.RedPoints++;
                            MCPaintballGameEvents.INSTANCE.setDirty(true);
                            BlockPos pos = Objects.requireNonNull(Target.getRespawnConfig()).respawnData().pos();
                            Target.teleportTo(pos.getX(),pos.getY(),pos.getZ());
                        }else if(type == MCPaintballEntities.GREEN_PAINTBALL && TargetData.Team != 2){
                            level().playSound(null, Objects.requireNonNull(this.getOwner()).blockPosition(),MCPaintballSounds.HIT, SoundSource.PLAYERS,1f,1f);
                            MCPaintballGameEvents.INSTANCE.GreenPoints++;
                            MCPaintballGameEvents.INSTANCE.setDirty(true);
                            BlockPos pos = Objects.requireNonNull(Target.getRespawnConfig()).respawnData().pos();
                            Target.teleportTo(pos.getX(),pos.getY(),pos.getZ());
                        }else if(type == MCPaintballEntities.BLUE_PAINTBALL && TargetData.Team != 3){
                            level().playSound(null, Objects.requireNonNull(this.getOwner()).blockPosition(),MCPaintballSounds.HIT, SoundSource.PLAYERS,1f,1f);
                            MCPaintballGameEvents.INSTANCE.BluePoints++;
                            MCPaintballGameEvents.INSTANCE.setDirty(true);
                            BlockPos pos = Objects.requireNonNull(Target.getRespawnConfig()).respawnData().pos();
                            Target.teleportTo(pos.getX(),pos.getY(),pos.getZ());

                        }else if(type == MCPaintballEntities.YELLOW_PAINTBALL && TargetData.Team != 4){
                            level().playSound(null, Objects.requireNonNull(this.getOwner()).blockPosition(),MCPaintballSounds.HIT, SoundSource.PLAYERS,1f,1f);
                            MCPaintballGameEvents.INSTANCE.YellowPoints++;
                            MCPaintballGameEvents.INSTANCE.setDirty(true);
                            BlockPos pos = Objects.requireNonNull(Target.getRespawnConfig()).respawnData().pos();
                            Target.teleportTo(pos.getX(),pos.getY(),pos.getZ());
                        }else if(type == MCPaintballEntities.PINK_PAINTBALL && TargetData.Team != 5){
                            level().playSound(null, Objects.requireNonNull(this.getOwner()).blockPosition(),MCPaintballSounds.HIT, SoundSource.PLAYERS,1f,1f);
                            MCPaintballGameEvents.INSTANCE.PinkPoints++;
                            MCPaintballGameEvents.INSTANCE.setDirty(true);
                            BlockPos pos = Objects.requireNonNull(Target.getRespawnConfig()).respawnData().pos();
                            Target.teleportTo(pos.getX(),pos.getY(),pos.getZ());
                        }else if(type == MCPaintballEntities.ORANGE_PAINTBALL && TargetData.Team != 6){
                            level().playSound(null, Objects.requireNonNull(this.getOwner()).blockPosition(),MCPaintballSounds.HIT, SoundSource.PLAYERS,1f,1f);
                            MCPaintballGameEvents.INSTANCE.OrangePoints++;
                            MCPaintballGameEvents.INSTANCE.setDirty(true);
                            BlockPos pos = Objects.requireNonNull(Target.getRespawnConfig()).respawnData().pos();
                            Target.teleportTo(pos.getX(),pos.getY(),pos.getZ());
                        }
                    }
                }
            }else if(MCPaintball.DEBUG){
                DebugHelper.HandleDebug(result,level(),3,(Player) this.getOwner());
            }

        }
        super.discard();
    }
}
