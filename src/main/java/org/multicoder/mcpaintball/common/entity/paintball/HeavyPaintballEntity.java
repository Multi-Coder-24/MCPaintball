package org.multicoder.mcpaintball.common.entity.paintball;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.apache.logging.log4j.MarkerManager;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.MCPaintballSounds;
import org.multicoder.mcpaintball.common.commands.TeamCommands;
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.common.data.capability.PaintballPlayer;
import org.multicoder.mcpaintball.common.data.capability.PaintballPlayerProvider;
import org.multicoder.mcpaintball.common.utility.FormattingManagers;

import java.rmi.AccessException;

@SuppressWarnings("all")
public class HeavyPaintballEntity extends AbstractArrow {
    public HeavyPaintballEntity(EntityType<?> p_36721_, Level p_36722_) {
        super((EntityType<? extends AbstractArrow>) p_36721_, p_36722_);
    }

    public HeavyPaintballEntity(EntityType<?> p_36717_, LivingEntity p_36718_, Level p_36719_) {
        super((EntityType<? extends AbstractArrow>) p_36717_, p_36718_, p_36719_);
    }

    @Override
    protected void onHitBlock(BlockHitResult hitResult) {
        ServerPlayer Owner = (ServerPlayer) getOwner();
        PaintballPlayer OwnerData = Owner.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get();
        BlockPos Position = hitResult.getBlockPos();
        String TK = getTypeName().getString();
        try {
            int EntityTeam = FormattingManagers.FormatTypeToTeam(TK, HeavyPaintballEntity.class).ordinal();
        } catch (Exception e) {MCPaintball.SECURITY_LOG.fatal(MarkerManager.getMarker("MCPaintball"),"An attempt Was made to access an anti-cheat protected class");}
        Explosion E = level().explode(this, Position.getX(), Position.getY(), Position.getZ(), 5f, Level.ExplosionInteraction.MOB);
        E.getHitPlayers().keySet().forEach(player ->
        {
            ServerPlayer target = (ServerPlayer) player;
            PaintballPlayer TargetData = target.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get();
            try {
                if (OwnerData.getName(HeavyPaintballEntity.class).equals(TargetData.getName(HeavyPaintballEntity.class))) {
                    if (OwnerData.GetTeam(HeavyPaintballEntity.class).ordinal() != TargetData.GetTeam(HeavyPaintballEntity.class).ordinal()) {
                        try {
                            MCPaintballWorldData.INSTANCE.IncrementByName(OwnerData.getName(HeavyPaintballEntity.class), OwnerData.GetTeam(HeavyPaintballEntity.class).ordinal(), HeavyPaintballEntity.class);
                        } catch (AccessException e) {MCPaintball.SECURITY_LOG.fatal(MarkerManager.getMarker("MCPaintball"),"An attempt Was made to access an anti-cheat protected class");}
                    }
                }
            } catch (AccessException e) {
                MCPaintball.SECURITY_LOG.fatal(MarkerManager.getMarker("MCPaintball"),"An attempt Was made to access an anti-cheat protected class");}
        });
        this.kill();
        this.discard();
        super.onHitBlock(hitResult);
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
