package org.multicoder.mcpaintball.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.init.MCPaintballExplosives;
import org.multicoder.mcpaintball.init.MCPaintballUtilities;
import org.multicoder.mcpaintball.item.weapons.*;

import java.util.List;

@SuppressWarnings("all")
public class EMPGrenadeEntity extends ThrowableItemProjectile implements ItemSupplier {
    public EMPGrenadeEntity(EntityType<?> entityEntityType, Level level) {
        super((EntityType<? extends ThrowableItemProjectile>) entityEntityType, level);
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        Level level = level();
        BlockPos pos = result.getBlockPos();
        List<Entity> entities = level.getEntities(this, AABB.encapsulatingFullBlocks(pos.offset(-5,-2,-5),pos.offset(5,2,5)), entity -> entity instanceof Player);
        entities.forEach(entity -> {
            Player player = (Player) entity;
            player.getInventory().items.stream().filter(stack -> stack.getItem() instanceof PistolItem).forEach(stack -> {
                player.getCooldowns().addCooldown(stack.getItem(), 200);
            });
            player.getInventory().items.stream().filter(stack -> stack.getItem() instanceof AssaultRifleItem).forEach(stack -> {
                player.getCooldowns().addCooldown(stack.getItem(), 200);
            });
            player.getInventory().items.stream().filter(stack -> stack.getItem() instanceof SniperRifleItem).forEach(stack -> {
                player.getCooldowns().addCooldown(stack.getItem(), 200);
            });
            player.getInventory().items.stream().filter(stack -> stack.getItem() instanceof ShotgunItem).forEach(stack -> {
                player.getCooldowns().addCooldown(stack.getItem(), 200);
            });
            player.getInventory().items.stream().filter(stack -> stack.getItem() instanceof BazookaItem).forEach(stack -> {
                player.getCooldowns().addCooldown(stack.getItem(), 200);
            });
            player.getInventory().items.stream().filter(stack -> stack.getItem() instanceof BurstRifleItem).forEach(stack -> {
                player.getCooldowns().addCooldown(stack.getItem(), 200);
            });
        });
        this.discard();
    }

    public EMPGrenadeEntity(LivingEntity shooter, Level level) {
        super((EntityType<? extends ThrowableItemProjectile>) MCPaintballExplosives.EMP_GRENADE.get(), shooter, level);
    }

    @Override
    protected @NotNull Item getDefaultItem() {
        return MCPaintballUtilities.EMP_GRENADE.get();
    }
}
