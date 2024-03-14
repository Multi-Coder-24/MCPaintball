package org.multicoder.mcpaintball.common.entity.throwable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.common.items.MCPaintballItems;
import org.multicoder.mcpaintball.common.utility.FormattingManagers;
import org.multicoder.mcpaintball.common.utility.PaintballTeam;

public class GrenadeEntity extends ThrowableItemProjectile
{

    public GrenadeEntity(EntityType<?> p_37442_, Level p_37443_)
    {
        super((EntityType<? extends ThrowableItemProjectile>) p_37442_, p_37443_);
    }

    public GrenadeEntity(EntityType<?> p_37438_, LivingEntity p_37439_, Level p_37440_)
    {
        super((EntityType<? extends ThrowableItemProjectile>) p_37438_, p_37439_, p_37440_);
    }

    @Override
    protected void onHitBlock(BlockHitResult result)
    {
        BlockPos Position = result.getBlockPos();
        Explosion E = level().explode(this,Position.getX(), Position.getY(),Position.getZ(),5f, Level.ExplosionInteraction.MOB);
        E.getHitPlayers().keySet().forEach(player ->
        {
            String TK = getTypeName().getString();
            PaintballTeam EntityTeam = FormattingManagers.FormatTypeToTeam(TK);
            CompoundTag Persist = player.getPersistentData();
            if(Persist.contains("mcpaintball.teamsTag"))
            {
                CompoundTag TeamsData = Persist.getCompound("mcpaintball.teamsTag");
                PaintballTeam T = PaintballTeam.values()[TeamsData.getInt("team")];
                if(EntityTeam != T)
                {
                    MCPaintballWorldData.IncrementByTranslationKey(TK);
                }
            }
        });
        this.kill();
        this.discard();
        super.onHitBlock(result);
    }

    @Override
    protected Item getDefaultItem() {
        return MCPaintballItems.GRENADE.get();
    }
}
