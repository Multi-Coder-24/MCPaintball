package org.multicoder.mcpaintball.items.weapons;

import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.entity.paintball.PaintballEntity;
import org.multicoder.mcpaintball.utility.enums.PaintballTeam;

import static net.minecraft.sounds.SoundSource.PLAYERS;
import static org.multicoder.mcpaintball.data.MCPaintballWorldData.INSTANCE;
import static org.multicoder.mcpaintball.init.MCPaintballSounds.SHOT;

public class RifleItem extends Item {
    public RifleItem() {
        super(new Properties().setNoRepair().stacksTo(1));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if (!level.isClientSide()) {
            if (MCPaintballTeamsDataHelper.HasTeam(player)) {
                if (INSTANCE.MatchStarted) {
                    PaintballTeam PTeam = PaintballTeam.values()[MCPaintballTeamsDataHelper.FetchTeam(player)];
                    AbstractArrow Paintball = new PaintballEntity(PTeam.getPaintball(), level);
                    Paintball.shootFromRotation(player, player.getXRot(), player.getYRot(), 0f, 4f, 0f);
                    level.addFreshEntity(Paintball);
                    level.playSound(null, player.blockPosition(), SHOT.get(), PLAYERS, 1f, 1f);
                    player.getCooldowns().addCooldown(this, 20);
                    return InteractionResultHolder.consume(player.getItemInHand(hand));
                }
            }
        }
        return InteractionResultHolder.fail(player.getItemInHand(hand));
    }
}
