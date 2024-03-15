package org.multicoder.mcpaintball.common.items;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.multicoder.mcpaintball.common.MCPaintballSounds;
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.common.entity.MCPaintballEntities;
import org.multicoder.mcpaintball.common.entity.throwable.SlownessGrenadeEntity;
import org.multicoder.mcpaintball.common.entity.throwable.WeaknessGrenadeEntity;

public class WeaknessGrenadeItem extends Item
{

    public WeaknessGrenadeItem()
    {
        super(new Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
    {
        if(!level.isClientSide())
        {
            CompoundTag Persist = player.getPersistentData();
            if(Persist.contains("mcpaintball.teamsTag")) {
                CompoundTag TeamData = Persist.getCompound("mcpaintball.teamsTag");
                if (MCPaintballWorldData.INSTANCE.StartedByName(TeamData.getString("name"))) {
                    WeaknessGrenadeEntity Grenade = new WeaknessGrenadeEntity(MCPaintballEntities.WEAKNESS_GRENADE.get(), player, level);
                    Grenade.shootFromRotation(player, player.getXRot(), player.getYRot(), 0f, 3f, 0f);
                    level.addFreshEntity(Grenade);
                    level.playSound(null, player.blockPosition(), MCPaintballSounds.GRENADE.get(), SoundSource.PLAYERS, 1f, 1f);
                }
            }
        }
        return super.use(level, player, hand);
    }
}
