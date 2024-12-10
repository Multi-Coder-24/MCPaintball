package org.multicoder.mcpaintball.items.weapons;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.init.MCPaintballSounds;
import org.multicoder.mcpaintball.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.entity.paintball.HeavyPaintballEntity;
import org.multicoder.mcpaintball.utility.enums.PaintballTeam;


public class BazookaItem extends Item
{
    public BazookaItem()
    {
        super(new Properties().setNoRepair().stacksTo(1));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, @NotNull Player player, @NotNull InteractionHand hand)
    {
        if(!level.isClientSide())
        {
            if(MCPaintballTeamsDataHelper.HasTeam(player))
            {
                if(MCPaintballWorldData.INSTANCE.MatchStarted)
                {
                    PaintballTeam PTeam = PaintballTeam.values()[MCPaintballTeamsDataHelper.FetchTeam(player)];
                    AbstractArrow Paintball = new HeavyPaintballEntity(PTeam.getHeavyPaintball(),level);
                    Paintball.shootFromRotation(player,player.getXRot(),player.getYRot(),0f,3f,0f);
                    level.addFreshEntity(Paintball);
                    level.playSound(null,player.blockPosition(), MCPaintballSounds.BAZOOKA.get(), SoundSource.PLAYERS,1f,1f);
                    player.getCooldowns().addCooldown(this,80);
                    return InteractionResultHolder.consume(player.getItemInHand(hand));
                }
            }
        }
        return InteractionResultHolder.fail(player.getItemInHand(hand));
    }
}
