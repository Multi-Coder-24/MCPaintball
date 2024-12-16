package org.multicoder.mcpaintball.items.weapons;

import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.entity.grenade.RedPaintballGrenadeEntity;
import org.multicoder.mcpaintball.utility.enums.PaintballTeam;

import static net.minecraft.sounds.SoundSource.PLAYERS;
import static org.multicoder.mcpaintball.data.MCPaintballWorldData.INSTANCE;
import static org.multicoder.mcpaintball.init.MCPaintballSounds.GRENADE;

public class GrenadeItem extends Item {

    public GrenadeItem() {
        super(new Properties().stacksTo(16));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if (!level.isClientSide()) {
            if (MCPaintballTeamsDataHelper.HasTeam(player)) {
                if (INSTANCE.MatchStarted) {
                    PaintballTeam PTeam = PaintballTeam.values()[MCPaintballTeamsDataHelper.FetchTeam(player)];
                    RedPaintballGrenadeEntity Grenade = new RedPaintballGrenadeEntity(PTeam.getGrenade(),player, level);
                    Grenade.shootFromRotation(player, player.getXRot(), player.getYRot(), 0f, 3f, 0f);
                    level.addFreshEntity(Grenade);
                    level.playSound(null, player.blockPosition(), GRENADE.get(), PLAYERS, 1f, 1f);
                    player.getItemInHand(hand).shrink(1);
                    player.getCooldowns().addCooldown(this,40);
                    return InteractionResultHolder.consume(player.getItemInHand(hand));
                }
            }
        }
        return InteractionResultHolder.fail(player.getItemInHand(hand));
    }
}
