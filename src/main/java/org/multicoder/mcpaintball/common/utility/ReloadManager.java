package org.multicoder.mcpaintball.common.utility;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import org.multicoder.mcpaintball.common.items.MCPaintballItems;

import java.rmi.AccessException;

public class ReloadManager {
    public static void ReloadWeapon(ItemStack Weapon, ServerPlayer player ,Class<?> Invoker) throws AccessException {
        if(Invoker.getPackageName().startsWith("org.multicoder")){
            if (Weapon.getItem() == MCPaintballItems.PISTOL.get() || Weapon.getItem() == MCPaintballItems.RIFLE.get() || Weapon.getItem() == MCPaintballItems.SNIPER.get()) {
                if (player.getInventory().contains(new ItemStack(MCPaintballItems.BASIC_AMMO.get()))) {
                    ItemStack Ammo = player.getInventory().getItem(player.getInventory().findSlotMatchingItem(new ItemStack(MCPaintballItems.BASIC_AMMO.get())));
                    int Damage = Weapon.getDamageValue();
                    int Count = Ammo.getCount();
                    if (Damage < Count) {
                        Count -= Damage;
                        Ammo.setCount(Count);
                        Weapon.setDamageValue(0);
                    } else {
                        Damage -= Count;
                        Weapon.setDamageValue(Damage);
                        Ammo.setCount(0);
                    }
                }
            } else if (Weapon.getItem() == MCPaintballItems.SHOTGUN.get()) {
                if (player.getInventory().contains(new ItemStack(MCPaintballItems.SHELL_AMMO.get()))) {
                    ItemStack Ammo = player.getInventory().getItem(player.getInventory().findSlotMatchingItem(new ItemStack(MCPaintballItems.SHELL_AMMO.get())));
                    int Damage = Weapon.getDamageValue();
                    int Count = Ammo.getCount();
                    if (Damage < Count) {
                        Count -= Damage;
                        Ammo.setCount(Count);
                        Weapon.setDamageValue(0);
                    } else {
                        Damage -= Count;
                        Weapon.setDamageValue(Damage);
                        Ammo.setCount(0);
                    }
                }
            } else if (Weapon.getItem() == MCPaintballItems.BAZOOKA.get()) {
                if (player.getInventory().contains(new ItemStack(MCPaintballItems.HEAVY_AMMO.get()))) {
                    ItemStack Ammo = player.getInventory().getItem(player.getInventory().findSlotMatchingItem(new ItemStack(MCPaintballItems.HEAVY_AMMO.get())));
                    int Damage = Weapon.getDamageValue();
                    int Count = Ammo.getCount();
                    if (Damage < Count) {
                        Count -= Damage;
                        Ammo.setCount(Count);
                        Weapon.setDamageValue(0);
                    } else {
                        Damage -= Count;
                        Weapon.setDamageValue(Damage);
                        Ammo.setCount(0);
                    }
                }
            }
        }
        else{
            throw new AccessException("Cannot Access This Class");
        }
    }
}
