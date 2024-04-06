package org.multicoder.mcpaintball.common.util.item;

import net.minecraft.world.item.Item;
import org.multicoder.mcpaintball.common.init.blockinit;
import org.multicoder.mcpaintball.common.init.iteminit;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class ItemCategories {
    public static List<Item> WEAPONS = new ArrayList<>();
    public static List<Item> UTILITY = new ArrayList<>();
    public static List<Item> ARMOR = new ArrayList<>();

    public static void Populate() {
        WEAPONS.add(iteminit.PAINTBALL_RIFLE.get());
        WEAPONS.add(iteminit.PAINTBALL_PISTOL.get());
        WEAPONS.add(iteminit.PAINTBALL_SNIPER.get());
        WEAPONS.add(iteminit.PAINTBALL_SHOTGUN.get());
        WEAPONS.add(iteminit.PAINTBALL_BAZOOKA.get());
        WEAPONS.add(iteminit.PAINTBALL_GRENADE.get());
        WEAPONS.add(iteminit.BASIC_AMMO.get());
        WEAPONS.add(iteminit.SHELL_AMMO.get());
        WEAPONS.add(iteminit.HEAVY_AMMO.get());

        ARMOR.add(iteminit.BLUE_HELMET.get());
        ARMOR.add(iteminit.BLUE_CHESTPLATE.get());
        ARMOR.add(iteminit.BLUE_LEGGINGS.get());
        ARMOR.add(iteminit.BLUE_BOOTS.get());
        ARMOR.add(iteminit.RED_HELMET.get());
        ARMOR.add(iteminit.RED_CHESTPLATE.get());
        ARMOR.add(iteminit.RED_LEGGINGS.get());
        ARMOR.add(iteminit.RED_BOOTS.get());
        ARMOR.add(iteminit.GREEN_HELMET.get());
        ARMOR.add(iteminit.GREEN_CHESTPLATE.get());
        ARMOR.add(iteminit.GREEN_LEGGINGS.get());
        ARMOR.add(iteminit.GREEN_BOOTS.get());
        ARMOR.add(iteminit.CYAN_HELMET.get());
        ARMOR.add(iteminit.CYAN_CHESTPLATE.get());
        ARMOR.add(iteminit.CYAN_LEGGINGS.get());
        ARMOR.add(iteminit.CYAN_BOOTS.get());
        ARMOR.add(iteminit.MAGENTA_HELMET.get());
        ARMOR.add(iteminit.MAGENTA_CHESTPLATE.get());
        ARMOR.add(iteminit.MAGENTA_LEGGINGS.get());
        ARMOR.add(iteminit.MAGENTA_BOOTS.get());
        ARMOR.add(iteminit.PINK_HELMET.get());
        ARMOR.add(iteminit.PINK_CHESTPLATE.get());
        ARMOR.add(iteminit.PINK_LEGGINGS.get());
        ARMOR.add(iteminit.PINK_BOOTS.get());
        ARMOR.add(iteminit.LIME_HELMET.get());
        ARMOR.add(iteminit.LIME_CHESTPLATE.get());
        ARMOR.add(iteminit.LIME_LEGGINGS.get());
        ARMOR.add(iteminit.LIME_BOOTS.get());
        ARMOR.add(iteminit.PURPLE_HELMET.get());
        ARMOR.add(iteminit.PURPLE_CHESTPLATE.get());
        ARMOR.add(iteminit.PURPLE_LEGGINGS.get());
        ARMOR.add(iteminit.PURPLE_BOOTS.get());
        ARMOR.add(iteminit.LIGHT_BLUE_HELMET.get());
        ARMOR.add(iteminit.LIGHT_BLUE_CHESTPLATE.get());
        ARMOR.add(iteminit.LIGHT_BLUE_LEGGINGS.get());
        ARMOR.add(iteminit.LIGHT_BLUE_BOOTS.get());

        UTILITY.add(iteminit.BLUE_REMOTE.get());
        UTILITY.add(iteminit.RED_REMOTE.get());
        UTILITY.add(iteminit.GREEN_REMOTE.get());
        UTILITY.add(iteminit.CYAN_REMOTE.get());
        UTILITY.add(iteminit.MAGENTA_REMOTE.get());
        UTILITY.add(iteminit.PINK_REMOTE.get());
        UTILITY.add(iteminit.PURPLE_REMOTE.get());
        UTILITY.add(iteminit.LIME_REMOTE.get());
        UTILITY.add(iteminit.LIGHT_BLUE_REMOTE.get());

        UTILITY.add(iteminit.BLUE_MED_KIT.get());
        UTILITY.add(iteminit.RED_MED_KIT.get());
        UTILITY.add(iteminit.GREEN_MED_KIT.get());
        UTILITY.add(iteminit.CYAN_MED_KIT.get());
        UTILITY.add(iteminit.MAGENTA_MED_KIT.get());
        UTILITY.add(iteminit.PINK_MED_KIT.get());
        UTILITY.add(iteminit.PURPLE_MED_KIT.get());
        UTILITY.add(iteminit.LIME_MED_KIT.get());
        UTILITY.add(iteminit.LIGHT_BLUE_MED_KIT.get());

        blockinit.BLOCKS.getEntries().forEach(blockRegistryObject -> {
            UTILITY.add(blockRegistryObject.get().asItem());
        });
    }
}
