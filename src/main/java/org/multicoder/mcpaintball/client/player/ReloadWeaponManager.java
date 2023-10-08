package org.multicoder.mcpaintball.client.player;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import org.multicoder.mcpaintball.common.init.iteminit;
import org.multicoder.mcpaintball.common.item.weapons.*;

@SuppressWarnings("all")
public class ReloadWeaponManager {
    public static void ReloadWeapon(ServerPlayer player, ItemStack weapon) {
        if (weapon.getItem() instanceof PaintballPistol) {
            int Damage = weapon.getDamageValue();
            int HasAmmo = player.getInventory().findSlotMatchingItem(new ItemStack(iteminit.BASIC_AMMO.get()));
            SetReload(HasAmmo, Damage, player, weapon);

        } else if (weapon.getItem() instanceof PaintballRifle) {
            int Damage = weapon.getDamageValue();
            int HasAmmo = player.getInventory().findSlotMatchingItem(new ItemStack(iteminit.BASIC_AMMO.get()));
            SetReload(HasAmmo, Damage, player, weapon);

        } else if (weapon.getItem() instanceof PaintballBazooka) {
            int Damage = weapon.getDamageValue();
            int HasAmmo = player.getInventory().findSlotMatchingItem(new ItemStack(iteminit.HEAVY_AMMO.get()));
            SetReload(HasAmmo, Damage, player, weapon);

        } else if (weapon.getItem() instanceof PaintballShotgun) {
            int Damage = weapon.getDamageValue();
            int HasAmmo = player.getInventory().findSlotMatchingItem(new ItemStack(iteminit.SHELL_AMMO.get()));
            SetReload(HasAmmo, Damage, player, weapon);
        } else if (weapon.getItem() instanceof PaintballSniper) {
            int Damage = weapon.getDamageValue();
            int HasAmmo = player.getInventory().findSlotMatchingItem(new ItemStack(iteminit.BASIC_AMMO.get()));
            SetReload(HasAmmo, Damage, player, weapon);
        }
    }

    private static void SetReload(int HasAmmo, int Damage, ServerPlayer player, ItemStack weapon) {
        if (HasAmmo != -1) {
            ItemStack Ammo = player.getInventory().getItem(HasAmmo);
            int AD = (Ammo.getCount() - Damage);
            int DA = (Damage - Ammo.getCount());
            if (AD >= 0) {
                Ammo.setCount(AD);
                weapon.setDamageValue(0);
            }
            if (DA >= 0) {
                Ammo.shrink(Ammo.getCount());
                weapon.setDamageValue(DA);
            }
        }
    }
}
