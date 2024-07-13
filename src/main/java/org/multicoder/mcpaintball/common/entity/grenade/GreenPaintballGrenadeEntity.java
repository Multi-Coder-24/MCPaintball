package org.multicoder.mcpaintball.common.entity.grenade;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.multicoder.mcpaintball.common.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.common.items.MCPaintballItems;
import org.multicoder.mcpaintball.common.utility.FormattingManagers;
import org.multicoder.mcpaintball.common.data.PaintballDataUtility.Team;

@SuppressWarnings("all")
public class GreenPaintballGrenadeEntity extends ThrowableItemProjectile implements ItemSupplier {

    public GreenPaintballGrenadeEntity(EntityType<?> p_37442_, Level p_37443_) {
        super((EntityType<? extends ThrowableItemProjectile>) p_37442_, p_37443_);
    }

    public GreenPaintballGrenadeEntity(EntityType<?> p_37438_, LivingEntity p_37439_, Level p_37440_) {
        super((EntityType<? extends ThrowableItemProjectile>) p_37438_, p_37439_, p_37440_);
    }

    @Override
    protected void onHitBlock(BlockHitResult p_37258_)
    {
        if (MCPaintballWorldData.INSTANCE.MatchStarted)
        {
            if(MCPaintballWorldData.INSTANCE.GAME_TYPE == 2)
            {
                BlockPos Position = p_37258_.getBlockPos();
                Explosion E = level().explode(this, Position.getX(), Position.getY(), Position.getZ(), 2f, Level.ExplosionInteraction.TNT);
                E.getHitPlayers().keySet().forEach(player ->
                {
                    String TK = getTypeName().getString().toLowerCase();
                    Team EntityTeam = FormattingManagers.FormatTypeToTeam(TK);
                    if (MCPaintballTeamsDataHelper.HasTeam(player)) {
                        Team T = Team.values()[MCPaintballTeamsDataHelper.FetchTeam(player)];
                        if (EntityTeam != T)
                        {
                            MCPaintballWorldData.IncrementByTranslationKey(TK);
                        }
                    }
                });
            } else if (MCPaintballWorldData.INSTANCE.GAME_TYPE == 0)
            {
                BlockPos Position = p_37258_.getBlockPos();
                Explosion E = level().explode(this, Position.getX(), Position.getY(), Position.getZ(), 2f, Level.ExplosionInteraction.NONE);
                E.getHitPlayers().keySet().forEach(player ->
                {
                    String TK = getTypeName().getString().toLowerCase();
                    Team EntityTeam = FormattingManagers.FormatTypeToTeam(TK);
                    if (MCPaintballTeamsDataHelper.HasTeam(player)) {
                        Team T = Team.values()[MCPaintballTeamsDataHelper.FetchTeam(player)];
                        if (EntityTeam != T)
                        {
                            MCPaintballWorldData.IncrementByTranslationKey(TK);
                        }
                    }
                });
            }
        }
        this.kill();
        this.discard();
    }

    @Override
    protected Item getDefaultItem()
    {
        return MCPaintballItems.GREEN_GRENADE.get();
    }
}
