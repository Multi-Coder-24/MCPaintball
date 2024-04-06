package org.multicoder.mcpaintball.common.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.item.ammo.BasicAmmo;
import org.multicoder.mcpaintball.common.item.ammo.HeavyAmmo;
import org.multicoder.mcpaintball.common.item.ammo.ShellAmmo;
import org.multicoder.mcpaintball.common.item.armor.ModBoots;
import org.multicoder.mcpaintball.common.item.armor.ModChestplate;
import org.multicoder.mcpaintball.common.item.armor.ModHelmet;
import org.multicoder.mcpaintball.common.item.armor.ModLeggings;
import org.multicoder.mcpaintball.common.item.utility.MedkitItem;
import org.multicoder.mcpaintball.common.item.utility.PaintballRemote;
import org.multicoder.mcpaintball.common.item.weapons.*;
import org.multicoder.mcpaintball.common.util.enums.PaintballArmor;
import org.multicoder.mcpaintball.common.util.enums.Teams;

@SuppressWarnings("all")
public class iteminit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MCPaintball.MOD_ID);

    //  Weapons //
    public static final RegistryObject<Item> PAINTBALL_PISTOL = ITEMS.register("weapon/paintball_pistol", PaintballPistol::new);
    public static final RegistryObject<Item> PAINTBALL_SHOTGUN = ITEMS.register("weapon/paintball_shotgun", PaintballShotgun::new);
    public static final RegistryObject<Item> PAINTBALL_RIFLE = ITEMS.register("weapon/paintball_rifle", PaintballRifle::new);
    public static final RegistryObject<Item> PAINTBALL_BAZOOKA = ITEMS.register("weapon/paintball_bazooka", PaintballBazooka::new);
    public static final RegistryObject<Item> PAINTBALL_SNIPER = ITEMS.register("weapon/paintball_sniper", PaintballSniper::new);
    //  Armor //
    public static final RegistryObject<Item> RED_BOOTS = ITEMS.register("armor/red_boots", () -> new ModBoots(PaintballArmor.Red));
    public static final RegistryObject<Item> BLUE_BOOTS = ITEMS.register("armor/blue_boots", () -> new ModBoots(PaintballArmor.Blue));
    public static final RegistryObject<Item> GREEN_BOOTS = ITEMS.register("armor/green_boots", () -> new ModBoots(PaintballArmor.Green));
    public static final RegistryObject<Item> MAGENTA_BOOTS = ITEMS.register("armor/magenta_boots", () -> new ModBoots(PaintballArmor.Magenta));
    public static final RegistryObject<Item> PINK_BOOTS = ITEMS.register("armor/pink_boots", () -> new ModBoots(PaintballArmor.Pink));
    public static final RegistryObject<Item> PURPLE_BOOTS = ITEMS.register("armor/purple_boots", () -> new ModBoots(PaintballArmor.Purple));
    public static final RegistryObject<Item> LIME_BOOTS = ITEMS.register("armor/lime_boots", () -> new ModBoots(PaintballArmor.Lime));
    public static final RegistryObject<Item> LIGHT_BLUE_BOOTS = ITEMS.register("armor/light_blue_boots", () -> new ModBoots(PaintballArmor.Light_Blue));
    public static final RegistryObject<Item> CYAN_BOOTS = ITEMS.register("armor/cyan_boots", () -> new ModBoots(PaintballArmor.Cyan));
    //
    public static final RegistryObject<Item> RED_LEGGINGS = ITEMS.register("armor/red_leggings", () -> new ModLeggings(PaintballArmor.Red));
    public static final RegistryObject<Item> BLUE_LEGGINGS = ITEMS.register("armor/blue_leggings", () -> new ModLeggings(PaintballArmor.Blue));
    public static final RegistryObject<Item> GREEN_LEGGINGS = ITEMS.register("armor/green_leggings", () -> new ModLeggings(PaintballArmor.Green));
    public static final RegistryObject<Item> MAGENTA_LEGGINGS = ITEMS.register("armor/magenta_leggings", () -> new ModLeggings(PaintballArmor.Magenta));
    public static final RegistryObject<Item> PINK_LEGGINGS = ITEMS.register("armor/pink_leggings", () -> new ModLeggings(PaintballArmor.Pink));
    public static final RegistryObject<Item> PURPLE_LEGGINGS = ITEMS.register("armor/purple_leggings", () -> new ModLeggings(PaintballArmor.Purple));
    public static final RegistryObject<Item> LIME_LEGGINGS = ITEMS.register("armor/lime_leggings", () -> new ModLeggings(PaintballArmor.Lime));
    public static final RegistryObject<Item> LIGHT_BLUE_LEGGINGS = ITEMS.register("armor/light_blue_leggings", () -> new ModLeggings(PaintballArmor.Light_Blue));
    public static final RegistryObject<Item> CYAN_LEGGINGS = ITEMS.register("armor/cyan_leggings", () -> new ModLeggings(PaintballArmor.Cyan));
    //
    public static final RegistryObject<Item> RED_CHESTPLATE = ITEMS.register("armor/red_chestplate", () -> new ModChestplate(PaintballArmor.Red));
    public static final RegistryObject<Item> BLUE_CHESTPLATE = ITEMS.register("armor/blue_chestplate", () -> new ModChestplate(PaintballArmor.Blue));
    public static final RegistryObject<Item> GREEN_CHESTPLATE = ITEMS.register("armor/green_chestplate", () -> new ModChestplate(PaintballArmor.Green));
    public static final RegistryObject<Item> MAGENTA_CHESTPLATE = ITEMS.register("armor/magenta_chestplate", () -> new ModChestplate(PaintballArmor.Magenta));
    public static final RegistryObject<Item> PINK_CHESTPLATE = ITEMS.register("armor/pink_chestplate", () -> new ModChestplate(PaintballArmor.Pink));
    public static final RegistryObject<Item> PURPLE_CHESTPLATE = ITEMS.register("armor/purple_chestplate", () -> new ModChestplate(PaintballArmor.Purple));
    public static final RegistryObject<Item> LIME_CHESTPLATE = ITEMS.register("armor/lime_chestplate", () -> new ModChestplate(PaintballArmor.Lime));
    public static final RegistryObject<Item> LIGHT_BLUE_CHESTPLATE = ITEMS.register("armor/light_blue_chestplate", () -> new ModChestplate(PaintballArmor.Light_Blue));
    public static final RegistryObject<Item> CYAN_CHESTPLATE = ITEMS.register("armor/cyan_chestplate", () -> new ModChestplate(PaintballArmor.Cyan));
    //
    public static final RegistryObject<Item> RED_HELMET = ITEMS.register("armor/red_helmet", () -> new ModHelmet(PaintballArmor.Red));
    public static final RegistryObject<Item> BLUE_HELMET = ITEMS.register("armor/blue_helmet", () -> new ModHelmet(PaintballArmor.Blue));
    public static final RegistryObject<Item> GREEN_HELMET = ITEMS.register("armor/green_helmet", () -> new ModHelmet(PaintballArmor.Green));
    public static final RegistryObject<Item> MAGENTA_HELMET = ITEMS.register("armor/magenta_helmet", () -> new ModHelmet(PaintballArmor.Magenta));
    public static final RegistryObject<Item> PINK_HELMET = ITEMS.register("armor/pink_helmet", () -> new ModHelmet(PaintballArmor.Pink));
    public static final RegistryObject<Item> PURPLE_HELMET = ITEMS.register("armor/purple_helmet", () -> new ModHelmet(PaintballArmor.Purple));
    public static final RegistryObject<Item> LIME_HELMET = ITEMS.register("armor/lime_helmet", () -> new ModHelmet(PaintballArmor.Lime));
    public static final RegistryObject<Item> LIGHT_BLUE_HELMET = ITEMS.register("armor/light_blue_helmet", () -> new ModHelmet(PaintballArmor.Light_Blue));
    public static final RegistryObject<Item> CYAN_HELMET = ITEMS.register("armor/cyan_helmet", () -> new ModHelmet(PaintballArmor.Cyan));

    //  Remote //
    public static final RegistryObject<Item> RED_REMOTE = ITEMS.register("utility/red_remote", () -> new PaintballRemote(Teams.RED));
    public static final RegistryObject<Item> BLUE_REMOTE = ITEMS.register("utility/blue_remote", () -> new PaintballRemote(Teams.BLUE));
    public static final RegistryObject<Item> GREEN_REMOTE = ITEMS.register("utility/green_remote", () -> new PaintballRemote(Teams.GREEN));
    public static final RegistryObject<Item> MAGENTA_REMOTE = ITEMS.register("utility/magenta_remote", () -> new PaintballRemote(Teams.MAGENTA));
    public static final RegistryObject<Item> PINK_REMOTE = ITEMS.register("utility/pink_remote", () -> new PaintballRemote(Teams.PINK));
    public static final RegistryObject<Item> PURPLE_REMOTE = ITEMS.register("utility/purple_remote", () -> new PaintballRemote(Teams.PURPLE));
    public static final RegistryObject<Item> LIME_REMOTE = ITEMS.register("utility/lime_remote", () -> new PaintballRemote(Teams.LIME));
    public static final RegistryObject<Item> LIGHT_BLUE_REMOTE = ITEMS.register("utility/light_blue_remote", () -> new PaintballRemote(Teams.LIGHT_BLUE));
    public static final RegistryObject<Item> CYAN_REMOTE = ITEMS.register("utility/cyan_remote", () -> new PaintballRemote(Teams.CYAN));

    // Grenades //
    public static final RegistryObject<Item> PAINTBALL_GRENADE = ITEMS.register("utility/grenades/paintball_grenade", PaintballingGrenade::new);

    // Med Kits //
    public static final RegistryObject<Item> RED_MED_KIT = ITEMS.register("utility/med/red_kit", () -> new MedkitItem(Teams.RED));
    public static final RegistryObject<Item> GREEN_MED_KIT = ITEMS.register("utility/med/green_kit", () -> new MedkitItem(Teams.GREEN));
    public static final RegistryObject<Item> BLUE_MED_KIT = ITEMS.register("utility/med/blue_kit", () -> new MedkitItem(Teams.BLUE));
    public static final RegistryObject<Item> MAGENTA_MED_KIT = ITEMS.register("utility/med/magenta_kit", () -> new MedkitItem(Teams.MAGENTA));
    public static final RegistryObject<Item> PINK_MED_KIT = ITEMS.register("utility/med/pink_kit", () -> new MedkitItem(Teams.PINK));
    public static final RegistryObject<Item> PURPLE_MED_KIT = ITEMS.register("utility/med/purple_kit", () -> new MedkitItem(Teams.PURPLE));
    public static final RegistryObject<Item> LIME_MED_KIT = ITEMS.register("utility/med/lime_kit", () -> new MedkitItem(Teams.LIME));
    public static final RegistryObject<Item> LIGHT_BLUE_MED_KIT = ITEMS.register("utility/med/light_blue_kit", () -> new MedkitItem(Teams.LIGHT_BLUE));
    public static final RegistryObject<Item> CYAN_MED_KIT = ITEMS.register("utility/med/cyan_kit", () -> new MedkitItem(Teams.CYAN));

    // Basic Ammo //
    public static final RegistryObject<Item> BASIC_AMMO = ITEMS.register("utility/ammo/basic_ammo", BasicAmmo::new);
    public static final RegistryObject<Item> SHELL_AMMO = ITEMS.register("utility/ammo/shell_ammo", ShellAmmo::new);
    public static final RegistryObject<Item> HEAVY_AMMO = ITEMS.register("utility/ammo/heavy_ammo", HeavyAmmo::new);
}
