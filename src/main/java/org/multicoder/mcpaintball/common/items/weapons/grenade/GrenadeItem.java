package org.multicoder.mcpaintball.common.items.weapons.grenade;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.multicoder.mcpaintball.common.MCPaintballSounds;
import org.multicoder.mcpaintball.common.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.common.entity.grenade.RedPaintballGrenadeEntity;
import org.multicoder.mcpaintball.common.data.PaintballDataUtility.Team;

@SuppressWarnings("all")
public class GrenadeItem extends Item {

    public GrenadeItem() {
        super(new Properties().stacksTo(16));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            if (MCPaintballTeamsDataHelper.HasTeam(player)) {
                if (MCPaintballWorldData.INSTANCE.MatchStarted) {
                    Team PTeam = Team.values()[MCPaintballTeamsDataHelper.FetchTeam(player)];
                    RedPaintballGrenadeEntity Grenade = new RedPaintballGrenadeEntity(PTeam.getGrenade(), player, level);
                    Grenade.shootFromRotation(player, player.getXRot(), player.getYRot(), 0f, 3f, 0f);
                    level.addFreshEntity(Grenade);
                    level.playSound(null, player.blockPosition(), MCPaintballSounds.GRENADE.get(), SoundSource.PLAYERS, 1f, 1f);
                    player.getItemInHand(hand).shrink(1);
                    player.getCooldowns().addCooldown(this,40);
                    return InteractionResultHolder.consume(player.getItemInHand(hand));
                }
            }
        }
        return InteractionResultHolder.fail(player.getItemInHand(hand));
    }
}
