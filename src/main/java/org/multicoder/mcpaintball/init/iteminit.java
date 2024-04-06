package org.multicoder.mcpaintball.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.*;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.item.armor.boots.*;
import org.multicoder.mcpaintball.item.armor.chestplate.*;
import org.multicoder.mcpaintball.item.armor.helmet.*;
import org.multicoder.mcpaintball.item.armor.leggings.*;
import org.multicoder.mcpaintball.item.utility.ammunition.basic.*;
import org.multicoder.mcpaintball.item.utility.ammunition.heavy.*;
import org.multicoder.mcpaintball.item.utility.ammunition.shell.*;
import org.multicoder.mcpaintball.item.utility.crafting.*;
import org.multicoder.mcpaintball.item.utility.extra.TabletItem;
import org.multicoder.mcpaintball.item.utility.grenades.*;
import org.multicoder.mcpaintball.item.utility.kits.*;
import org.multicoder.mcpaintball.item.utility.medical.*;
import org.multicoder.mcpaintball.item.utility.remote.*;
import org.multicoder.mcpaintball.item.weapons.current.*;


public class iteminit
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MCPaintball.MODID);

    //  Weapons //
    public static final RegistryObject<Item> PAINTBALL_PISTOL = ITEMS.register("weapon/paintball_pistol", PaintballPistol::new);
    public static final RegistryObject<Item> PAINTBALL_SHOTGUN = ITEMS.register("weapon/paintball_shotgun", PaintballShotgun::new);
    public static final RegistryObject<Item> PAINTBALL_RIFLE = ITEMS.register("weapon/paintball_rifle", PaintballRifle::new);
    public static final RegistryObject<Item> PAINTBALL_BAZOOKA = ITEMS.register("weapon/paintball_bazooka", PaintballBazooka::new);
    //  Armor //
    public static final RegistryObject<Item> RED_BOOTS = ITEMS.register("armor/red_boots", RedBoots::new);
    public static final RegistryObject<Item> BLUE_BOOTS = ITEMS.register("armor/blue_boots", BlueBoots::new);
    public static final RegistryObject<Item> GREEN_BOOTS = ITEMS.register("armor/green_boots", GreenBoots::new);
    public static final RegistryObject<Item> MAGENTA_BOOTS = ITEMS.register("armor/magenta_boots", MagentaBoots::new);
    public static final RegistryObject<Item> PINK_BOOTS = ITEMS.register("armor/pink_boots", PinkBoots::new);
    public static final RegistryObject<Item> PURPLE_BOOTS = ITEMS.register("armor/purple_boots", PurpleBoots::new);
    public static final RegistryObject<Item> LIME_BOOTS = ITEMS.register("armor/lime_boots", LimeBoots::new);
    public static final RegistryObject<Item> LIGHT_BLUE_BOOTS = ITEMS.register("armor/light_blue_boots", LightBlueBoots::new);
    //
    public static final RegistryObject<Item> RED_LEGGINGS = ITEMS.register("armor/red_leggings", RedLeggings::new);
    public static final RegistryObject<Item> BLUE_LEGGINGS = ITEMS.register("armor/blue_leggings", BlueLeggings::new);
    public static final RegistryObject<Item> GREEN_LEGGINGS = ITEMS.register("armor/green_leggings", GreenLeggings::new);
    public static final RegistryObject<Item> MAGENTA_LEGGINGS = ITEMS.register("armor/magenta_leggings", MagentaLeggings::new);
    public static final RegistryObject<Item> PINK_LEGGINGS = ITEMS.register("armor/pink_leggings", PinkLeggings::new);
    public static final RegistryObject<Item> PURPLE_LEGGINGS = ITEMS.register("armor/purple_leggings", PurpleLeggings::new);
    public static final RegistryObject<Item> LIME_LEGGINGS = ITEMS.register("armor/lime_leggings", LimeLeggings::new);
    public static final RegistryObject<Item> LIGHT_BLUE_LEGGINGS = ITEMS.register("armor/light_blue_leggings", LightBlueLeggings::new);
    //
    public static final RegistryObject<Item> RED_CHESTPLATE = ITEMS.register("armor/red_chestplate", RedChestplate::new);
    public static final RegistryObject<Item> BLUE_CHESTPLATE = ITEMS.register("armor/blue_chestplate", BlueChestplate::new);
    public static final RegistryObject<Item> GREEN_CHESTPLATE = ITEMS.register("armor/green_chestplate", GreenChestplate::new);
    public static final RegistryObject<Item> MAGENTA_CHESTPLATE = ITEMS.register("armor/magenta_chestplate", MagentaChestplate::new);
    public static final RegistryObject<Item> PINK_CHESTPLATE = ITEMS.register("armor/pink_chestplate", PinkChestplate::new);
    public static final RegistryObject<Item> PURPLE_CHESTPLATE = ITEMS.register("armor/purple_chestplate", PurpleChestplate::new);
    public static final RegistryObject<Item> LIME_CHESTPLATE = ITEMS.register("armor/lime_chestplate", LimeChestplate::new);
    public static final RegistryObject<Item> LIGHT_BLUE_CHESTPLATE = ITEMS.register("armor/light_blue_chestplate", LightBlueChestplate::new);
    //
    public static final RegistryObject<Item> RED_HELMET = ITEMS.register("armor/red_helmet", RedHelmet::new);
    public static final RegistryObject<Item> BLUE_HELMET = ITEMS.register("armor/blue_helmet", BlueHelmet::new);
    public static final RegistryObject<Item> GREEN_HELMET = ITEMS.register("armor/green_helmet", GreenHelmet::new);
    public static final RegistryObject<Item> MAGENTA_HELMET = ITEMS.register("armor/magenta_helmet", MagentaHelmet::new);
    public static final RegistryObject<Item> PINK_HELMET = ITEMS.register("armor/pink_helmet", PinkHelmet::new);
    public static final RegistryObject<Item> PURPLE_HELMET = ITEMS.register("armor/purple_helmet", PurpleHelmet::new);
    public static final RegistryObject<Item> LIME_HELMET = ITEMS.register("armor/lime_helmet", LimeHelmet::new);
    public static final RegistryObject<Item> LIGHT_BLUE_HELMET = ITEMS.register("armor/light_blue_helmet", LightBlueHelmet::new);

    //  Remote //
    public static final RegistryObject<Item> RED_REMOTE = ITEMS.register("utility/red_remote", RedRemote::new);
    public static final RegistryObject<Item> BLUE_REMOTE = ITEMS.register("utility/blue_remote", BlueRemote::new);
    public static final RegistryObject<Item> GREEN_REMOTE = ITEMS.register("utility/green_remote", GreenRemote::new);
    public static final RegistryObject<Item> MAGENTA_REMOTE = ITEMS.register("utility/magenta_remote", MagentaRemote::new);
    public static final RegistryObject<Item> PINK_REMOTE = ITEMS.register("utility/pink_remote", PinkRemote::new);
    public static final RegistryObject<Item> PURPLE_REMOTE = ITEMS.register("utility/purple_remote", PurpleRemote::new);
    public static final RegistryObject<Item> LIME_REMOTE = ITEMS.register("utility/lime_remote", LimeRemote::new);
    public static final RegistryObject<Item> LIGHT_BLUE_REMOTE = ITEMS.register("utility/light_blue_remote", LightBlueRemote::new);

    //  Weapons Base //
    public static final RegistryObject<Item> PAINTBALL_WEAPONS_BASE = ITEMS.register("utility/extra/kit_base", PaintballWeaponBase::new);

    // Team Kits //
    public static final RegistryObject<Item> PAINTBALL_STANDARD_KIT = ITEMS.register("utility/kits/paintball_standard", StandardKit::new);
    public static final RegistryObject<Item> PAINTBALL_MEDICAL_KIT = ITEMS.register("utility/kits/paintball_medical", MedicalKit::new);
    public static final RegistryObject<Item> PAINTBALL_HEAVY_KIT = ITEMS.register("utility/kits/paintball_heavy", HeavyKit::new);
    public static final RegistryObject<Item> PAINTBALL_TRAINEE_KIT = ITEMS.register("utility/kits/paintball_trainee", TraineeKit::new);

    // Grenades //
    public static final RegistryObject<Item> PAINTBALL_GRENADE = ITEMS.register("utility/grenades/paintball_grenade", PaintballingGrenade::new);

    // Ammunition //
    public static final RegistryObject<Item> RED_AMMO = ITEMS.register("utility/ammo/red_basic", RedBaseAmmoItem::new);
    public static final RegistryObject<Item> GREEN_AMMO = ITEMS.register("utility/ammo/green_basic", GreenBaseAmmoItem::new);
    public static final RegistryObject<Item> BLUE_AMMO = ITEMS.register("utility/ammo/blue_basic", BlueBaseAmmoItem::new);
    public static final RegistryObject<Item> MAGENTA_AMMO = ITEMS.register("utility/ammo/magenta_basic", MagentaBaseAmmoItem::new);
    public static final RegistryObject<Item> PINK_AMMO = ITEMS.register("utility/ammo/pink_basic", PinkBaseAmmoItem::new);
    public static final RegistryObject<Item> PURPLE_AMMO = ITEMS.register("utility/ammo/purple_basic", PurpleBaseAmmoItem::new);
    public static final RegistryObject<Item> LIME_AMMO = ITEMS.register("utility/ammo/lime_basic", LimeBaseAmmoItem::new);
    public static final RegistryObject<Item> LIGHT_BLUE_AMMO = ITEMS.register("utility/ammo/light_blue_basic", LightBlueBaseAmmoItem::new);
    //
    public static final RegistryObject<Item> RED_AMMO_SHELL = ITEMS.register("utility/ammo/red_shell", RedShellAmmoItem::new);
    public static final RegistryObject<Item> GREEN_AMMO_SHELL = ITEMS.register("utility/ammo/green_shell", GreenShellAmmoItem::new);
    public static final RegistryObject<Item> BLUE_AMMO_SHELL = ITEMS.register("utility/ammo/blue_shell", BlueShellAmmoItem::new);
    public static final RegistryObject<Item> MAGENTA_AMMO_SHELL = ITEMS.register("utility/ammo/magenta_shell", MagentaShellAmmoItem::new);
    public static final RegistryObject<Item> PINK_AMMO_SHELL = ITEMS.register("utility/ammo/pink_shell", PinkShellAmmoItem::new);
    public static final RegistryObject<Item> PURPLE_AMMO_SHELL = ITEMS.register("utility/ammo/purple_shell", PurpleShellAmmoItem::new);
    public static final RegistryObject<Item> LIME_AMMO_SHELL = ITEMS.register("utility/ammo/lime_shell", LimeShellAmmoItem::new);
    public static final RegistryObject<Item> LIGHT_BLUE_AMMO_SHELL = ITEMS.register("utility/ammo/light_blue_shell", LightBlueShellAmmoItem::new);
    //
    public static final RegistryObject<Item> RED_AMMO_HEAVY = ITEMS.register("utility/ammo/red_heavy", RedHeavyAmmoItem::new);
    public static final RegistryObject<Item> GREEN_AMMO_HEAVY = ITEMS.register("utility/ammo/green_heavy", GreenHeavyAmmoItem::new);
    public static final RegistryObject<Item> BLUE_AMMO_HEAVY = ITEMS.register("utility/ammo/blue_heavy", BlueHeavyAmmoItem::new);
    public static final RegistryObject<Item> MAGENTA_AMMO_HEAVY = ITEMS.register("utility/ammo/magenta_heavy", MagentaHeavyAmmoItem::new);
    public static final RegistryObject<Item> PINK_AMMO_HEAVY = ITEMS.register("utility/ammo/pink_heavy", PinkHeavyAmmoItem::new);
    public static final RegistryObject<Item> PURPLE_AMMO_HEAVY = ITEMS.register("utility/ammo/purple_heavy", PurpleHeavyAmmoItem::new);
    public static final RegistryObject<Item> LIME_AMMO_HEAVY = ITEMS.register("utility/ammo/lime_heavy", LimeHeavyAmmoItem::new);
    public static final RegistryObject<Item> LIGHT_BLUE_AMMO_HEAVY = ITEMS.register("utility/ammo/light_blue_heavy", LightBlueHeavyAmmoItem::new);

    // Med Kits //
    public static final RegistryObject<Item> RED_MED_KIT = ITEMS.register("utility/med/red_kit", RedMedKitItem::new);
    public static final RegistryObject<Item> GREEN_MED_KIT = ITEMS.register("utility/med/green_kit", GreenMedKitItem::new);
    public static final RegistryObject<Item> BLUE_MED_KIT = ITEMS.register("utility/med/blue_kit", BlueMedKitItem::new);
    public static final RegistryObject<Item> MAGENTA_MED_KIT = ITEMS.register("utility/med/magenta_kit", MagentaMedKitItem::new);
    public static final RegistryObject<Item> PINK_MED_KIT = ITEMS.register("utility/med/pink_kit", PinkMedKitItem::new);
    public static final RegistryObject<Item> PURPLE_MED_KIT = ITEMS.register("utility/med/purple_kit", PurpleMedKitItem::new);
    public static final RegistryObject<Item> LIME_MED_KIT = ITEMS.register("utility/med/lime_kit", LimeMedKitItem::new);
    public static final RegistryObject<Item> LIGHT_BLUE_MED_KIT = ITEMS.register("utility/med/light_blue_kit", LightBlueMedKitItem::new);

    // Extra //
    public static final RegistryObject<Item> TABLET = ITEMS.register("utility/extra/tablet", TabletItem::new);

    public static final RegistryObject<Item> RESET_ROD = ITEMS.register("utility/extra/reset_rod", ResetRodItem::new);


}
