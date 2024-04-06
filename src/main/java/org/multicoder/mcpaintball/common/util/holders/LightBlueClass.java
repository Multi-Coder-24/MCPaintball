package org.multicoder.mcpaintball.common.util.holders;

import net.minecraft.world.item.ItemStack;
import org.multicoder.mcpaintball.common.init.blockinit;
import org.multicoder.mcpaintball.common.init.iteminit;
import org.multicoder.mcpaintball.common.util.enums.KitType;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class LightBlueClass {
    public static List<ItemStack> STANDARD;
    public static List<ItemStack> MEDICAL;
    public static List<ItemStack> HEAVY;
    public static List<ItemStack> SNIPER;
    public static List<ItemStack> ENGINEER;

    public static void PopulateRegistry() {
        STANDARD = new ArrayList<>();
        MEDICAL = new ArrayList<>();
        HEAVY = new ArrayList<>();
        SNIPER = new ArrayList<>();
        ENGINEER = new ArrayList<>();

        //  Common Items
        STANDARD.add(new ItemStack(iteminit.LIGHT_BLUE_BOOTS.get()));
        STANDARD.add(new ItemStack(iteminit.LIGHT_BLUE_LEGGINGS.get()));
        STANDARD.add(new ItemStack(iteminit.LIGHT_BLUE_CHESTPLATE.get()));
        STANDARD.add(new ItemStack(iteminit.LIGHT_BLUE_HELMET.get()));
        MEDICAL.add(new ItemStack(iteminit.LIGHT_BLUE_BOOTS.get()));
        MEDICAL.add(new ItemStack(iteminit.LIGHT_BLUE_LEGGINGS.get()));
        MEDICAL.add(new ItemStack(iteminit.LIGHT_BLUE_CHESTPLATE.get()));
        MEDICAL.add(new ItemStack(iteminit.LIGHT_BLUE_HELMET.get()));
        HEAVY.add(new ItemStack(iteminit.LIGHT_BLUE_BOOTS.get()));
        HEAVY.add(new ItemStack(iteminit.LIGHT_BLUE_LEGGINGS.get()));
        HEAVY.add(new ItemStack(iteminit.LIGHT_BLUE_CHESTPLATE.get()));
        HEAVY.add(new ItemStack(iteminit.LIGHT_BLUE_HELMET.get()));
        SNIPER.add(new ItemStack(iteminit.LIGHT_BLUE_BOOTS.get()));
        SNIPER.add(new ItemStack(iteminit.LIGHT_BLUE_LEGGINGS.get()));
        SNIPER.add(new ItemStack(iteminit.LIGHT_BLUE_CHESTPLATE.get()));
        SNIPER.add(new ItemStack(iteminit.LIGHT_BLUE_HELMET.get()));
        ENGINEER.add(new ItemStack(iteminit.LIGHT_BLUE_BOOTS.get()));
        ENGINEER.add(new ItemStack(iteminit.LIGHT_BLUE_LEGGINGS.get()));
        ENGINEER.add(new ItemStack(iteminit.LIGHT_BLUE_CHESTPLATE.get()));
        ENGINEER.add(new ItemStack(iteminit.LIGHT_BLUE_HELMET.get()));

        //  Class Specific Items
        STANDARD.add(new ItemStack(iteminit.PAINTBALL_RIFLE.get()));
        STANDARD.add(new ItemStack(iteminit.PAINTBALL_PISTOL.get()));
        STANDARD.add(new ItemStack(iteminit.PAINTBALL_GRENADE.get(), 48));
        STANDARD.add(new ItemStack(iteminit.LIGHT_BLUE_REMOTE.get()));
        STANDARD.add(new ItemStack(blockinit.LIGHT_BLUE_EXPLOSIVE_STATION.get(), 4));
        STANDARD.add(new ItemStack(blockinit.AMMO_POD.get(), 4));

        MEDICAL.add(new ItemStack(iteminit.PAINTBALL_SHOTGUN.get()));
        MEDICAL.add(new ItemStack(iteminit.PAINTBALL_PISTOL.get()));
        MEDICAL.add(new ItemStack(iteminit.PAINTBALL_GRENADE.get(), 32));
        MEDICAL.add(new ItemStack(iteminit.LIGHT_BLUE_REMOTE.get()));
        MEDICAL.add(new ItemStack(iteminit.LIGHT_BLUE_MED_KIT.get(), 32));
        MEDICAL.add(new ItemStack(blockinit.LIGHT_BLUE_MEDICAL_STATION.get(), 4));
        MEDICAL.add(new ItemStack(blockinit.AMMO_POD.get(), 2));

        HEAVY.add(new ItemStack(iteminit.PAINTBALL_BAZOOKA.get()));
        HEAVY.add(new ItemStack(iteminit.PAINTBALL_PISTOL.get()));
        HEAVY.add(new ItemStack(iteminit.PAINTBALL_GRENADE.get(), 24));
        HEAVY.add(new ItemStack(iteminit.LIGHT_BLUE_REMOTE.get()));
        HEAVY.add(new ItemStack(blockinit.LIGHT_BLUE_EXPLOSIVE_STATION.get(), 12));
        HEAVY.add(new ItemStack(blockinit.LIGHT_BLUE_EXPLOSIVE.get(), 16));
        HEAVY.add(new ItemStack(blockinit.AMMO_POD.get(), 2));

        SNIPER.add(new ItemStack(iteminit.PAINTBALL_PISTOL.get()));
        SNIPER.add(new ItemStack(iteminit.PAINTBALL_SNIPER.get()));
        SNIPER.add(new ItemStack(iteminit.PAINTBALL_GRENADE.get(), 32));
        SNIPER.add(new ItemStack(iteminit.LIGHT_BLUE_REMOTE.get()));
        SNIPER.add(new ItemStack(blockinit.AMMO_POD.get(), 6));

        ENGINEER.add(new ItemStack(iteminit.PAINTBALL_SHOTGUN.get()));
        ENGINEER.add(new ItemStack(iteminit.PAINTBALL_PISTOL.get()));
        ENGINEER.add(new ItemStack(iteminit.PAINTBALL_GRENADE.get(), 32));
        ENGINEER.add(new ItemStack(iteminit.LIGHT_BLUE_REMOTE.get()));
        ENGINEER.add(new ItemStack(blockinit.LIGHT_BLUE_MEDICAL_STATION.get(), 4));
        ENGINEER.add(new ItemStack(blockinit.AMMO_POD.get(), 2));
        ENGINEER.add(new ItemStack(blockinit.LIGHT_BLUE_RESPAWN_STATION.get(), 2));
    }

    public static List<ItemStack> GetExplosives(KitType Class) {
        List<ItemStack> Stacks = new ArrayList<>();
        switch (Class) {
            case STANDARD, SNIPER -> {
                Stacks.add(new ItemStack(iteminit.PAINTBALL_GRENADE.get(), 16));
            }
            case MEDICAL, ENGINEER -> {
                Stacks.add(new ItemStack(iteminit.PAINTBALL_GRENADE.get(), 24));
            }
            case HEAVY -> {
                Stacks.add(new ItemStack(iteminit.PAINTBALL_GRENADE.get(), 8));
                Stacks.add(new ItemStack(blockinit.LIGHT_BLUE_EXPLOSIVE.get(), 4));
            }
        }
        return Stacks;
    }
}
