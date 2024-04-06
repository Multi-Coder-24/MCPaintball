package org.multicoder.mcpaintball.client.player;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.init.iteminit;
import org.multicoder.mcpaintball.common.item.weapons.*;
import org.multicoder.mcpaintball.util.ErrorLogGenerator;

@SuppressWarnings("all")
public class ReloadWeaponManager {
    public static void ReloadWeapon(Player player, ItemStack weapon)
    {
        try{
            if (weapon.getItem() instanceof PaintballPistol)
            {
                int Damage = weapon.getDamageValue();
                int HasAmmo = player.getInventory().findSlotMatchingItem(new ItemStack(iteminit.BASIC_AMMO.get()));
                SetReload(HasAmmo, Damage, player, weapon);

            } else if (weapon.getItem() instanceof PaintballRifle)
            {
                int Damage = weapon.getDamageValue();
                int HasAmmo = player.getInventory().findSlotMatchingItem(new ItemStack(iteminit.BASIC_AMMO.get()));
                SetReload(HasAmmo, Damage, player, weapon);

            } else if (weapon.getItem() instanceof PaintballBazooka)
            {
                int Damage = weapon.getDamageValue();
                int HasAmmo = player.getInventory().findSlotMatchingItem(new ItemStack(iteminit.HEAVY_AMMO.get()));
                SetReload(HasAmmo, Damage, player, weapon);

            } else if (weapon.getItem() instanceof PaintballShotgun)
            {
                int Damage = weapon.getDamageValue();
                int HasAmmo = player.getInventory().findSlotMatchingItem(new ItemStack(iteminit.SHELL_AMMO.get()));
                SetReload(HasAmmo, Damage, player, weapon);
            }
            else if (weapon.getItem() instanceof PaintballSniper)
            {
                int Damage = weapon.getDamageValue();
                int HasAmmo = player.getInventory().findSlotMatchingItem(new ItemStack(iteminit.SHELL_AMMO.get()));
                SetReload(HasAmmo, Damage, player, weapon);
            }
        }
        catch(Exception e)
        {
            MCPaintball.LOG_ERROR.throwing(e);
            try
            {
                ErrorLogGenerator.Generate(e);
            }
            catch (Exception ex){}
            MCPaintball.LOG_ERROR.info("Error Handled");
        }
    }

    private static void SetReload(int HasAmmo, int Damage, Player player, ItemStack weapon)
    {
        try{
            if (HasAmmo != -1)
            {
                MCPaintball.LOG.info("Slot Is Valid");
                ItemStack Ammo = player.getInventory().getItem(HasAmmo);
                int AD = (Ammo.getCount() - Damage);
                int DA = (Damage - Ammo.getCount());
                if (AD >= 0)
                {
                    MCPaintball.LOG.info("More Ammo Than Damage");
                    Ammo.setCount(AD);
                    weapon.setDamageValue(0);
                }
                if (DA >= 0)
                {
                    MCPaintball.LOG.info("More Damage Than Ammo");
                    Ammo.shrink(Ammo.getCount());
                    weapon.setDamageValue(DA);
                }
            }
        }
        catch(Exception e)
        {
            MCPaintball.LOG_ERROR.throwing(e);
            try
            {
                ErrorLogGenerator.Generate(e);
            }
            catch (Exception ex){}
            MCPaintball.LOG_ERROR.info("Error Handled");
        }
    }
}
