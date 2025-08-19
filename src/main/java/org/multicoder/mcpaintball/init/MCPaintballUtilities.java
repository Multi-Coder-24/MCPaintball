package org.multicoder.mcpaintball.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.item.explosives.EMPGrenadeItem;
import org.multicoder.mcpaintball.item.explosives.PaintGrenadeItem;
import org.multicoder.mcpaintball.item.utility.*;

@SuppressWarnings("unused")
public class MCPaintballUtilities
{
    public static final DeferredRegister<Item> UTILITIES = DeferredRegister.create(Registries.ITEM, MCPaintball.MOD_ID);

    public static final DeferredHolder<Item,Item> RED_TEAM_TOKEN = UTILITIES.register("util/red_team_token", () -> new TeamTokenItem(1));
    public static final DeferredHolder<Item,Item> GREEN_TEAM_TOKEN = UTILITIES.register("util/green_team_token", () -> new TeamTokenItem(2));
    public static final DeferredHolder<Item,Item> BLUE_TEAM_TOKEN = UTILITIES.register("util/blue_team_token", () -> new TeamTokenItem(3));
    public static final DeferredHolder<Item,Item> CYAN_TEAM_TOKEN = UTILITIES.register("util/cyan_team_token", () -> new TeamTokenItem(4));
    public static final DeferredHolder<Item,Item> MAGENTA_TEAM_TOKEN = UTILITIES.register("util/magenta_team_token", () -> new TeamTokenItem(5));
    public static final DeferredHolder<Item,Item> YELLOW_TEAM_TOKEN = UTILITIES.register("util/yellow_team_token", () -> new TeamTokenItem(6));
    public static final DeferredHolder<Item,Item> LIME_TEAM_TOKEN = UTILITIES.register("util/lime_team_token", () -> new TeamTokenItem(7));
    public static final DeferredHolder<Item,Item> LIGHT_BLUE_TEAM_TOKEN = UTILITIES.register("util/light_blue_team_token", () -> new TeamTokenItem(8));
    public static final DeferredHolder<Item,Item> PINK_TEAM_TOKEN = UTILITIES.register("util/pink_team_token", () -> new TeamTokenItem(9));
    public static final DeferredHolder<Item,Item> WHITE_TEAM_TOKEN = UTILITIES.register("util/white_team_token", () -> new TeamTokenItem(10));
    public static final DeferredHolder<Item,Item> TEAM_REMOVER_TOKEN = UTILITIES.register("util/team_remover_token", TeamRemoverTokenItem::new);

    public static final DeferredHolder<Item,Item> RED_AMMO_HOPPER = UTILITIES.register("util/red_ammo_hopper", () -> new AmmoHopper(1));
    public static final DeferredHolder<Item,Item> GREEN_AMMO_HOPPER = UTILITIES.register("util/green_ammo_hopper", () -> new AmmoHopper(2));
    public static final DeferredHolder<Item,Item> BLUE_AMMO_HOPPER = UTILITIES.register("util/blue_ammo_hopper", () -> new AmmoHopper(3));
    public static final DeferredHolder<Item,Item> CYAN_AMMO_HOPPER = UTILITIES.register("util/cyan_ammo_hopper", () -> new AmmoHopper(4));
    public static final DeferredHolder<Item,Item> MAGENTA_AMMO_HOPPER = UTILITIES.register("util/magenta_ammo_hopper", () -> new AmmoHopper(5));
    public static final DeferredHolder<Item,Item> YELLOW_AMMO_HOPPER = UTILITIES.register("util/yellow_ammo_hopper", () -> new AmmoHopper(6));
    public static final DeferredHolder<Item,Item> LIME_AMMO_HOPPER = UTILITIES.register("util/lime_ammo_hopper", () -> new AmmoHopper(7));
    public static final DeferredHolder<Item,Item> LIGHT_BLUE_AMMO_HOPPER = UTILITIES.register("util/light_blue_ammo_hopper", () -> new AmmoHopper(8));
    public static final DeferredHolder<Item,Item> PINK_AMMO_HOPPER = UTILITIES.register("util/pink_ammo_hopper", () -> new AmmoHopper(9));
    public static final DeferredHolder<Item,Item> WHITE_AMMO_HOPPER = UTILITIES.register("util/white_ammo_hopper", () -> new AmmoHopper(10));

    public static final DeferredHolder<Item,Item> STANDARD_CLASS_TOKEN = UTILITIES.register("util/standard_class_token", () -> new ClassTokenItem(1));
    public static final DeferredHolder<Item,Item> HEAVY_CLASS_TOKEN = UTILITIES.register("util/heavy_class_token", () -> new ClassTokenItem(2));
    public static final DeferredHolder<Item,Item> ASSAULT_CLASS_TOKEN = UTILITIES.register("util/assault_class_token", () -> new ClassTokenItem(5));
    public static final DeferredHolder<Item,Item> SNIPER_CLASS_TOKEN = UTILITIES.register("util/sniper_class_token", () -> new ClassTokenItem(3));
    public static final DeferredHolder<Item,Item> MEDIC_CLASS_TOKEN = UTILITIES.register("util/medic_class_token", () -> new ClassTokenItem(4));

    public static final DeferredHolder<Item,Item> RED_MED_KIT = UTILITIES.register("util/red_med_kit", () -> new MedKitItem(1));
    public static final DeferredHolder<Item,Item> GREEN_MED_KIT = UTILITIES.register("util/green_med_kit",  () -> new MedKitItem(2));
    public static final DeferredHolder<Item,Item> BLUE_MED_KIT = UTILITIES.register("util/blue_med_kit",  () -> new MedKitItem(3));
    public static final DeferredHolder<Item,Item> CYAN_MED_KIT = UTILITIES.register("util/cyan_med_kit",  () -> new MedKitItem(4));
    public static final DeferredHolder<Item,Item> MAGENTA_MED_KIT = UTILITIES.register("util/magenta_med_kit",  () -> new MedKitItem(5));
    public static final DeferredHolder<Item,Item> YELLOW_MED_KIT = UTILITIES.register("util/yellow_med_kit",  () -> new MedKitItem(6));
    public static final DeferredHolder<Item,Item> LIME_MED_KIT = UTILITIES.register("util/lime_med_kit",  () -> new MedKitItem(7));
    public static final DeferredHolder<Item,Item> LIGHT_BLUE_MED_KIT = UTILITIES.register("util/light_blue_med_kit",  () -> new MedKitItem(8));
    public static final DeferredHolder<Item,Item> PINK_MED_KIT = UTILITIES.register("util/pink_med_kit",  () -> new MedKitItem(9));
    public static final DeferredHolder<Item,Item> WHITE_MED_KIT = UTILITIES.register("util/white_med_kit",  () -> new MedKitItem(10));

    public static final DeferredHolder<Item,Item> RED_C4_REMOTE = UTILITIES.register("util/red_c4_remote", () -> new C4RemoteItem(1));
    public static final DeferredHolder<Item,Item> GREEN_C4_REMOTE = UTILITIES.register("util/green_c4_remote",  () -> new C4RemoteItem(2));
    public static final DeferredHolder<Item,Item> BLUE_C4_REMOTE = UTILITIES.register("util/blue_c4_remote",  () -> new C4RemoteItem(3));
    public static final DeferredHolder<Item,Item> CYAN_C4_REMOTE = UTILITIES.register("util/cyan_c4_remote",  () -> new C4RemoteItem(4));
    public static final DeferredHolder<Item,Item> MAGENTA_C4_REMOTE = UTILITIES.register("util/magenta_c4_remote",  () -> new C4RemoteItem(5));
    public static final DeferredHolder<Item,Item> YELLOW_C4_REMOTE = UTILITIES.register("util/yellow_c4_remote",  () -> new C4RemoteItem(6));
    public static final DeferredHolder<Item,Item> LIME_C4_REMOTE = UTILITIES.register("util/lime_c4_remote",  () -> new C4RemoteItem(7));
    public static final DeferredHolder<Item,Item> LIGHT_BLUE_C4_REMOTE = UTILITIES.register("util/light_blue_c4_remote",  () -> new C4RemoteItem(8));
    public static final DeferredHolder<Item,Item> PINK_C4_REMOTE = UTILITIES.register("util/pink_c4_remote",  () -> new C4RemoteItem(9));
    public static final DeferredHolder<Item,Item> WHITE_C4_REMOTE = UTILITIES.register("util/white_c4_remote",  () -> new C4RemoteItem(10));

    public static final DeferredHolder<Item,Item> RED_PAINT_GRENADE = UTILITIES.register("explosives/red_paint_grenade", () -> new PaintGrenadeItem(1));
    public static final DeferredHolder<Item,Item> GREEN_PAINT_GRENADE = UTILITIES.register("explosives/green_paint_grenade",  () -> new PaintGrenadeItem(2));
    public static final DeferredHolder<Item,Item> BLUE_PAINT_GRENADE = UTILITIES.register("explosives/blue_paint_grenade",  () -> new PaintGrenadeItem(3));
    public static final DeferredHolder<Item,Item> CYAN_PAINT_GRENADE = UTILITIES.register("explosives/cyan_paint_grenade",  () -> new PaintGrenadeItem(4));
    public static final DeferredHolder<Item,Item> MAGENTA_PAINT_GRENADE = UTILITIES.register("explosives/magenta_paint_grenade",  () -> new PaintGrenadeItem(5));
    public static final DeferredHolder<Item,Item> YELLOW_PAINT_GRENADE = UTILITIES.register("explosives/yellow_paint_grenade",  () -> new PaintGrenadeItem(6));
    public static final DeferredHolder<Item,Item> LIME_PAINT_GRENADE = UTILITIES.register("explosives/lime_paint_grenade",  () -> new PaintGrenadeItem(7));
    public static final DeferredHolder<Item,Item> LIGHT_BLUE_PAINT_GRENADE = UTILITIES.register("explosives/light_blue_paint_grenade",  () -> new PaintGrenadeItem(8));
    public static final DeferredHolder<Item,Item> PINK_PAINT_GRENADE = UTILITIES.register("explosives/pink_paint_grenade",  () -> new PaintGrenadeItem(9));
    public static final DeferredHolder<Item,Item> WHITE_PAINT_GRENADE = UTILITIES.register("explosives/white_paint_grenade",  () -> new PaintGrenadeItem(10));

    public static final DeferredHolder<Item,Item> EMP_GRENADE = UTILITIES.register("explosives/emp_grenade", EMPGrenadeItem::new);

}
