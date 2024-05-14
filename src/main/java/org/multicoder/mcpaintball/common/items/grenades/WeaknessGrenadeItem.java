package org.multicoder.mcpaintball.common.items.grenades;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.apache.logging.log4j.MarkerManager;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.MCPaintballSounds;
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.common.data.capability.PaintballPlayerProvider;
import org.multicoder.mcpaintball.common.entity.MCPaintballEntities;
import org.multicoder.mcpaintball.common.entity.throwable.WeaknessGrenadeEntity;

import java.rmi.AccessException;

public class WeaknessGrenadeItem extends Item {

    public WeaknessGrenadeItem() {
        super(new Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            ServerPlayer SP = (ServerPlayer) player;
            SP.getCapability(PaintballPlayerProvider.CAPABILITY).ifPresent(cap ->
            {
                try {
                    if (MCPaintballWorldData.INSTANCE.StartedByName(cap.getName(WeaknessGrenadeItem.class), WeaknessGrenadeItem.class)) {
                        WeaknessGrenadeEntity Grenade = new WeaknessGrenadeEntity(MCPaintballEntities.WEAKNESS_GRENADE.get(), player, level);
                        Grenade.shootFromRotation(player, player.getXRot(), player.getYRot(), 0f, 3f, 0f);
                        level.addFreshEntity(Grenade);
                        level.playSound(null, player.blockPosition(), MCPaintballSounds.GRENADE.get(), SoundSource.PLAYERS, 1f, 1f);
                    }
                } catch (AccessException e) {
                    MCPaintball.SECURITY_LOG.fatal(MarkerManager.getMarker("MCPaintball"),"An attempt Was made to access an anti-cheat protected class");}
            });
        }
        return super.use(level, player, hand);
    }
}