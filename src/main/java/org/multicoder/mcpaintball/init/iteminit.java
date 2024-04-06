package org.multicoder.mcpaintball.init;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.item.armor.boots.BlueBoots;
import org.multicoder.mcpaintball.item.armor.boots.GreenBoots;
import org.multicoder.mcpaintball.item.armor.boots.RedBoots;
import org.multicoder.mcpaintball.item.armor.chestplate.BlueChestplate;
import org.multicoder.mcpaintball.item.armor.chestplate.GreenChestplate;
import org.multicoder.mcpaintball.item.armor.chestplate.RedChestplate;
import org.multicoder.mcpaintball.item.armor.helmet.BlueHelmet;
import org.multicoder.mcpaintball.item.armor.helmet.GreenHelmet;
import org.multicoder.mcpaintball.item.armor.helmet.RedHelmet;
import org.multicoder.mcpaintball.item.armor.leggings.BlueLeggings;
import org.multicoder.mcpaintball.item.armor.leggings.GreenLeggings;
import org.multicoder.mcpaintball.item.armor.leggings.RedLeggings;
import org.multicoder.mcpaintball.item.utility.BlueRemote;
import org.multicoder.mcpaintball.item.utility.GreenRemote;
import org.multicoder.mcpaintball.item.utility.RedRemote;
import org.multicoder.mcpaintball.item.weapons.pistol.BluePistol;
import org.multicoder.mcpaintball.item.weapons.pistol.GreenPistol;
import org.multicoder.mcpaintball.item.weapons.pistol.RedPistol;
import org.multicoder.mcpaintball.item.weapons.rifle.BlueRifle;
import org.multicoder.mcpaintball.item.weapons.rifle.GreenRifle;
import org.multicoder.mcpaintball.item.weapons.rifle.RedRifle;
import org.multicoder.mcpaintball.item.weapons.shotgun.BlueShotgun;
import org.multicoder.mcpaintball.item.weapons.shotgun.GreenShotgun;
import org.multicoder.mcpaintball.item.weapons.shotgun.RedShotgun;

public class iteminit
{

    public static Item RED_PISTOL = RegsiterItem("weapon/pistol/red_pistol", new RedPistol());
    public static Item BLUE_PISTOL = RegsiterItem("weapon/pistol/blue_pistol", new BluePistol());
    public static Item GREEN_PISTOL = RegsiterItem("weapon/pistol/green_pistol", new GreenPistol());

    public static Item RED_SHOTGUN = RegsiterItem("weapon/shotgun/red_shotgun", new RedShotgun());
    public static Item BLUE_SHOTGUN = RegsiterItem("weapon/shotgun/blue_shotgun", new BlueShotgun());
    public static Item GREEN_SHOTGUN = RegsiterItem("weapon/shotgun/green_shotgun", new GreenShotgun());

    public static Item RED_RIFLE = RegsiterItem("weapon/rifle/red_rifle", new RedRifle());
    public static Item BLUE_RIFLE = RegsiterItem("weapon/rifle/blue_rifle", new BlueRifle());
    public static Item GREEN_RIFLE = RegsiterItem("weapon/rifle/green_rifle", new GreenRifle());

    public static Item RED_REMOTE = RegsiterItem("utility/red_remote", new RedRemote());
    public static Item BLUE_REMOTE = RegsiterItem("utility/blue_remote", new BlueRemote());
    public static Item GREEN_REMOTE = RegsiterItem("utility/green_remote", new GreenRemote());

    public static Item RED_BOOTS = RegsiterItem("armor/red_boots", new RedBoots());
    public static Item BLUE_BOOTS = RegsiterItem("armor/blue_boots", new BlueBoots());
    public static Item GREEN_BOOTS = RegsiterItem("armor/green_boots", new GreenBoots());

    public static Item RED_LEGGINGS = RegsiterItem("armor/red_leggings", new RedLeggings());
    public static Item BLUE_LEGGINGS = RegsiterItem("armor/blue_leggings", new BlueLeggings());
    public static Item GREEN_LEGGINGS = RegsiterItem("armor/green_leggings", new GreenLeggings());

    public static Item RED_CHESTPLATE = RegsiterItem("armor/red_chestplate", new RedChestplate());
    public static Item BLUE_CHESTPLATE = RegsiterItem("armor/blue_chestplate", new BlueChestplate());
    public static Item GREEN_CHESTPLATE = RegsiterItem("armor/green_chestplate", new GreenChestplate());

    public static Item RED_HELMET = RegsiterItem("armor/red_helmet", new RedHelmet());
    public static Item BLUE_HELMET = RegsiterItem("armor/blue_helmet", new BlueHelmet());
    public static Item GREEN_HELMET = RegsiterItem("armor/green_helmet", new GreenHelmet());



    private static Item RegsiterItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM,new Identifier(MCPaintball.ModID,name),item);
    }

    public static void addItemsToItemGroups()
    {
        addItemToGroup(RED_PISTOL);
        addItemToGroup(BLUE_PISTOL);
        addItemToGroup(GREEN_PISTOL);

        addItemToGroup(RED_RIFLE);
        addItemToGroup(BLUE_RIFLE);
        addItemToGroup(GREEN_RIFLE);

        addItemToGroup(RED_SHOTGUN);
        addItemToGroup(BLUE_SHOTGUN);
        addItemToGroup(GREEN_SHOTGUN);

        addItemToGroup(RED_REMOTE);
        addItemToGroup(BLUE_REMOTE);
        addItemToGroup(GREEN_REMOTE);

        addItemToGroup(RED_HELMET);
        addItemToGroup(BLUE_HELMET);
        addItemToGroup(GREEN_HELMET);

        addItemToGroup(RED_CHESTPLATE);
        addItemToGroup(BLUE_CHESTPLATE);
        addItemToGroup(GREEN_CHESTPLATE);

        addItemToGroup(RED_LEGGINGS);
        addItemToGroup(BLUE_LEGGINGS);
        addItemToGroup(GREEN_LEGGINGS);

        addItemToGroup(RED_BOOTS);
        addItemToGroup(BLUE_BOOTS);
        addItemToGroup(GREEN_BOOTS);
    }

    public static void addItemToGroup(Item item)
    {
        ItemGroupEvents.modifyEntriesEvent(tabinit.paintball).register(entries -> {entries.add(item);});
    }
    public static void RegisterItems()
    {
        MCPaintball.LOGGER.debug("MCPaintball: Register Items");

        addItemsToItemGroups();
    }
}
