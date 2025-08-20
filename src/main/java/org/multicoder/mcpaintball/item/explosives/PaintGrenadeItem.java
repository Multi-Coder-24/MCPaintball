package org.multicoder.mcpaintball.item.explosives;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.data.component.ItemTeamDataComponent;
import org.multicoder.mcpaintball.entity.*;
import org.multicoder.mcpaintball.init.MCPaintballDataComponents;
import org.multicoder.mcpaintball.init.MCPaintballSounds;

import java.util.Objects;

public class PaintGrenadeItem extends Item {
    public PaintGrenadeItem(int Team) {
        super(new Properties().component(MCPaintballDataComponents.ITEM_TEAM.get(),new ItemTeamDataComponent(Team)));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, @NotNull Player player, @NotNull InteractionHand usedHand)
    {
        if(!level.isClientSide)
        {
            ItemStack Stack =  player.getItemInHand(usedHand);
            switch(Objects.requireNonNull(Stack.get(MCPaintballDataComponents.ITEM_TEAM.get())).team()){
                case 1:
                    RedPaintGrenadeEntity Grenade1 = new RedPaintGrenadeEntity(player, level);
                    Grenade1.shootFromRotation(player, player.getXRot(), player.getYRot(), 0F, 2F, 0F);
                    level.addFreshEntity(Grenade1);
                    break;
                case 2:
                    GreenPaintGrenadeEntity Grenade2 = new GreenPaintGrenadeEntity(player, level);
                    Grenade2.shootFromRotation(player, player.getXRot(), player.getYRot(), 0F, 2F, 0F);
                    level.addFreshEntity(Grenade2);
                    break;
                case 3:
                    BluePaintGrenadeEntity Grenade3 = new BluePaintGrenadeEntity(player, level);
                    Grenade3.shootFromRotation(player, player.getXRot(), player.getYRot(), 0F, 2F, 0F);
                    level.addFreshEntity(Grenade3);
                    break;
                case 4:
                    CyanPaintGrenadeEntity Grenade4 = new CyanPaintGrenadeEntity(player, level);
                    Grenade4.shootFromRotation(player, player.getXRot(), player.getYRot(), 0F, 2F, 0F);
                    level.addFreshEntity(Grenade4);
                    break;
                case 5:
                    MagentaPaintGrenadeEntity Grenade5 = new MagentaPaintGrenadeEntity(player, level);
                    Grenade5.shootFromRotation(player, player.getXRot(), player.getYRot(), 0F, 2F, 0F);
                    level.addFreshEntity(Grenade5);
                    break;
                case 6:
                    YellowPaintGrenadeEntity Grenade6 = new YellowPaintGrenadeEntity(player, level);
                    Grenade6.shootFromRotation(player, player.getXRot(), player.getYRot(), 0F, 2F, 0F);
                    level.addFreshEntity(Grenade6);
                    break;
                case 7:
                    LimePaintGrenadeEntity Grenade7 = new LimePaintGrenadeEntity(player, level);
                    Grenade7.shootFromRotation(player, player.getXRot(), player.getYRot(), 0F, 2F, 0F);
                    level.addFreshEntity(Grenade7);
                    break;
                case 8:
                    LightBluePaintGrenadeEntity Grenade8 = new LightBluePaintGrenadeEntity(player, level);
                    Grenade8.shootFromRotation(player, player.getXRot(), player.getYRot(), 0F, 2F, 0F);
                    level.addFreshEntity(Grenade8);
                    break;
                case 9:
                    PinkPaintGrenadeEntity Grenade9 = new PinkPaintGrenadeEntity(player, level);
                    Grenade9.shootFromRotation(player, player.getXRot(), player.getYRot(), 0F, 2F, 0F);
                    level.addFreshEntity(Grenade9);
                    break;
                case 10:
                    WhitePaintGrenadeEntity Grenade10 = new WhitePaintGrenadeEntity(player, level);
                    Grenade10.shootFromRotation(player, player.getXRot(), player.getYRot(), 0F, 2F, 0F);
                    level.addFreshEntity(Grenade10);
                    break;
            }
            Stack.shrink(1);
            level.playSound(null,player.blockPosition(), MCPaintballSounds.GRENADE.get(), SoundSource.PLAYERS,1F,1F);
        }
        return super.use(level, player, usedHand);
    }
}
