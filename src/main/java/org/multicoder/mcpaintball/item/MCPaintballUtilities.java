package org.multicoder.mcpaintball.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.item.utility.*;

@SuppressWarnings("unused")
public class MCPaintballUtilities
{
    public static final DeferredRegister<Item> UTILITIES = DeferredRegister.create(Registries.ITEM, MCPaintball.MOD_ID);

    public static final DeferredHolder<Item,Item> RED_TEAM_TOKEN = UTILITIES.register("util/red_team_token", RedTeamTokenItem::new);
    public static final DeferredHolder<Item,Item> GREEN_TEAM_TOKEN = UTILITIES.register("util/green_team_token", GreenTeamTokenItem::new);
    public static final DeferredHolder<Item,Item> BLUE_TEAM_TOKEN = UTILITIES.register("util/blue_team_token", BlueTeamTokenItem::new);
    public static final DeferredHolder<Item,Item> CYAN_TEAM_TOKEN = UTILITIES.register("util/cyan_team_token", CyanTeamTokenItem::new);
    public static final DeferredHolder<Item,Item> MAGENTA_TEAM_TOKEN = UTILITIES.register("util/magenta_team_token", MagentaTeamTokenItem::new);
    public static final DeferredHolder<Item,Item> YELLOW_TEAM_TOKEN = UTILITIES.register("util/yellow_team_token", YellowTeamTokenItem::new);
    public static final DeferredHolder<Item,Item> LIME_TEAM_TOKEN = UTILITIES.register("util/lime_team_token", LimeTeamTokenItem::new);
    public static final DeferredHolder<Item,Item> LIGHT_BLUE_TEAM_TOKEN = UTILITIES.register("util/light_blue_team_token", LightBlueTeamTokenItem::new);
    public static final DeferredHolder<Item,Item> PINK_TEAM_TOKEN = UTILITIES.register("util/pink_team_token", PinkTeamTokenItem::new);
    public static final DeferredHolder<Item,Item> WHITE_TEAM_TOKEN = UTILITIES.register("util/white_team_token", WhiteTeamTokenItem::new);
    public static final DeferredHolder<Item,Item> TEAM_REMOVER_TOKEN = UTILITIES.register("util/team_remover_token", TeamRemoverTokenItem::new);

    public static final DeferredHolder<Item,Item> RED_AMMO_HOPPER = UTILITIES.register("util/red_ammo_hopper", AmmoHopper::new);
    public static final DeferredHolder<Item,Item> GREEN_AMMO_HOPPER = UTILITIES.register("util/green_ammo_hopper", AmmoHopper::new);
    public static final DeferredHolder<Item,Item> BLUE_AMMO_HOPPER = UTILITIES.register("util/blue_ammo_hopper", AmmoHopper::new);
    public static final DeferredHolder<Item,Item> CYAN_AMMO_HOPPER = UTILITIES.register("util/cyan_ammo_hopper", AmmoHopper::new);
    public static final DeferredHolder<Item,Item> MAGENTA_AMMO_HOPPER = UTILITIES.register("util/magenta_ammo_hopper", AmmoHopper::new);
    public static final DeferredHolder<Item,Item> YELLOW_AMMO_HOPPER = UTILITIES.register("util/yellow_ammo_hopper", AmmoHopper::new);
    public static final DeferredHolder<Item,Item> LIME_AMMO_HOPPER = UTILITIES.register("util/lime_ammo_hopper", AmmoHopper::new);
    public static final DeferredHolder<Item,Item> LIGHT_BLUE_AMMO_HOPPER = UTILITIES.register("util/light_blue_ammo_hopper", AmmoHopper::new);
    public static final DeferredHolder<Item,Item> PINK_AMMO_HOPPER = UTILITIES.register("util/pink_ammo_hopper", AmmoHopper::new);
    public static final DeferredHolder<Item,Item> WHITE_AMMO_HOPPER = UTILITIES.register("util/white_ammo_hopper", AmmoHopper::new);

    public static final DeferredHolder<Item,Item> STANDARD_CLASS_TOKEN = UTILITIES.register("util/standard_class_token", StandardClassTokenItem::new);
    public static final DeferredHolder<Item,Item> HEAVY_CLASS_TOKEN = UTILITIES.register("util/heavy_class_token", HeavyClassTokenItem::new);
    public static final DeferredHolder<Item,Item> ASSAULT_CLASS_TOKEN = UTILITIES.register("util/assault_class_token", AssaultClassTokenItem::new);
    public static final DeferredHolder<Item,Item> SNIPER_CLASS_TOKEN = UTILITIES.register("util/sniper_class_token", SniperClassTokenItem::new);
    public static final DeferredHolder<Item,Item> MEDIC_CLASS_TOKEN = UTILITIES.register("util/medic_class_token", MedicClassTokenItem::new);
}
