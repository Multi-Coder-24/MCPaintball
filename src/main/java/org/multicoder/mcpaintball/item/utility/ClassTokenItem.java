package org.multicoder.mcpaintball.item.utility;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.item.MCPaintballUtilities;
import org.multicoder.mcpaintball.item.MCPaintballWeapons;

public class ClassTokenItem extends Item {
    public ClassTokenItem() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand usedHand) {
        ItemStack Stack = player.getItemInHand(usedHand);
        if(Stack.getItemHolder().is(MCPaintballUtilities.STANDARD_CLASS_TOKEN.getKey())){
            player.addItem(new ItemStack(MCPaintballWeapons.ASSAULT_RIFLE));
            player.addItem(new ItemStack(MCPaintballWeapons.PISTOL));
        }
        if(Stack.getItemHolder().is(MCPaintballUtilities.HEAVY_CLASS_TOKEN.getKey())){
            player.addItem(new ItemStack(MCPaintballWeapons.ASSAULT_RIFLE));
            player.addItem(new ItemStack(MCPaintballWeapons.PISTOL));
        }
        if(Stack.getItemHolder().is(MCPaintballUtilities.SNIPER_CLASS_TOKEN.getKey())){
            player.addItem(new ItemStack(MCPaintballWeapons.ASSAULT_RIFLE));
            player.addItem(new ItemStack(MCPaintballWeapons.PISTOL));
        }
        if(Stack.getItemHolder().is(MCPaintballUtilities.ASSAULT_CLASS_TOKEN.getKey())){
            player.addItem(new ItemStack(MCPaintballWeapons.ASSAULT_RIFLE));
            player.addItem(new ItemStack(MCPaintballWeapons.PISTOL));
        }
        if(Stack.getItemHolder().is(MCPaintballUtilities.MEDIC_CLASS_TOKEN.getKey())){
            player.addItem(new ItemStack(MCPaintballWeapons.ASSAULT_RIFLE));
            player.addItem(new ItemStack(MCPaintballWeapons.PISTOL));
        }
        return super.use(level, player, usedHand);
    }
}
