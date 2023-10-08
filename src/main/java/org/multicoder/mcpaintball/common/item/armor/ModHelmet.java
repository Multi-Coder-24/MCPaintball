package org.multicoder.mcpaintball.common.item.armor;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("all")
public class ModHelmet extends ArmorItem {

    public ModHelmet(ArmorMaterial pMaterial) {
        super(pMaterial, Type.HELMET, new Properties());
    }


    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (HasFullArmor(player)) {
            player.getFoodData().setSaturation(0.0f);
            player.getFoodData().setFoodLevel(15);
            stack.setDamageValue(0);
        }
        super.onArmorTick(stack, level, player);
    }

    private static boolean HasFullArmor(Player p) {
        AtomicInteger V = new AtomicInteger(0);
        p.getArmorSlots().forEach(slot ->
        {
            if (!slot.isEmpty()) {
                V.getAndIncrement();
            }
        });
        return V.get() == 4;
    }

}
