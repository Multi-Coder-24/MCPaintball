package org.multicoder.mcpaintball.common.entity.paintball;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.Nullable;
import org.multicoder.mcpaintball.common.MCPaintballSounds;
import org.multicoder.mcpaintball.common.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.common.utility.FormattingManagers;
import org.multicoder.mcpaintball.common.data.PaintballDataUtility;

@SuppressWarnings("all")
public class PaintballEntity extends AbstractArrow
{

    public PaintballEntity(EntityType<?> p_36721_, LivingEntity p_345310_, Level p_36722_, ItemStack p_309145_, @Nullable ItemStack p_345000_) {
        super((EntityType<? extends AbstractArrow>)p_36721_, p_345310_, p_36722_, p_309145_, p_345000_);
    }

    public PaintballEntity(EntityType<?> entityType, Level level) {
        super((EntityType<? extends AbstractArrow>) entityType, level);
    }

    public PaintballEntity(EntityType<?> paintball, Player player, Level level) {
        super((EntityType<? extends AbstractArrow>)paintball, (LivingEntity) player, level,new ItemStack(Items.ARROW), new ItemStack(Items.BOW));
    }


    @Override
    protected void onHitEntity(EntityHitResult hitResult)
    {
        if(!level().isClientSide())
        {
            if(MCPaintballWorldData.INSTANCE.MatchStarted)
            {
                if(MCPaintballWorldData.INSTANCE.GAME_TYPE == 2)
                {
                    String TN = getTypeName().getString().toLowerCase();
                    PaintballDataUtility.Team EntityTeam = FormattingManagers.FormatTypeToTeam(TN);
                    if(hitResult.getEntity() instanceof Player player)
                    {
                        if(MCPaintballTeamsDataHelper.HasTeam(player))
                        {
                            PaintballDataUtility.Team T = PaintballDataUtility.Team.values()[MCPaintballTeamsDataHelper.FetchTeam(player)];
                            if(EntityTeam != T)
                            {
                                MCPaintballWorldData.IncrementByTranslationKey(TN);
                                Entity SoundSourceEntity = this.getOwner();
                                player.hurt(level().damageSources().arrow(this,SoundSourceEntity),2f);
                                level().playSound(null,SoundSourceEntity.blockPosition(),MCPaintballSounds.HIT.get(), SoundSource.PLAYERS,1f,1f);
                            }
                        }
                    }
                } else if (MCPaintballWorldData.INSTANCE.GAME_TYPE == 0)
                {
                    String TN = getTypeName().getString().toLowerCase();
                    PaintballDataUtility.Team EntityTeam = FormattingManagers.FormatTypeToTeam(TN);
                    if(hitResult.getEntity() instanceof Player player)
                    {
                        if(MCPaintballTeamsDataHelper.HasTeam(player))
                        {
                            PaintballDataUtility.Team T = PaintballDataUtility.Team.values()[MCPaintballTeamsDataHelper.FetchTeam(player)];
                            if(EntityTeam != T)
                            {
                                MCPaintballWorldData.IncrementByTranslationKey(TN);
                                Entity SoundSourceEntity = this.getOwner();
                                level().playSound(null,SoundSourceEntity.blockPosition(),MCPaintballSounds.HIT.get(), SoundSource.PLAYERS,1f,1f);
                            }
                        }
                    }
                }
            }
        }
        this.kill();
        this.discard();
    }

    @Override
    public void tick()
    {
        super.tick();
        if(this.inGroundTime == 100) {
            this.kill();
            this.discard();
        }
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent()
    {
        return MCPaintballSounds.SPLAT.get();
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return ItemStack.EMPTY;
    }
}
