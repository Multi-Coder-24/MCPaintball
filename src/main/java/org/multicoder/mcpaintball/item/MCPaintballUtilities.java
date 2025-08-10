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
}
