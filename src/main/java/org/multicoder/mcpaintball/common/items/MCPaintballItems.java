package org.multicoder.mcpaintball.common.items;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.*;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.items.weapons.*;

public class MCPaintballItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(MCPaintball.MOD_ID);

    public static final DeferredItem<?> PISTOL = (DeferredItem<?>) ITEMS.register("pistol", PistolItem::new);
    public static final DeferredItem<?> RIFLE = (DeferredItem<?>) ITEMS.register("rifle", RifleItem::new);
    public static final DeferredItem<?> SHOTGUN = (DeferredItem<?>) ITEMS.register("shotgun", ShotgunItem::new);
    public static final DeferredItem<?> SNIPER = (DeferredItem<?>) ITEMS.register("sniper", SniperItem::new);
    public static final DeferredItem<?> BAZOOKA = (DeferredItem<?>) ITEMS.register("bazooka", BazookaItem::new);

    public static final DeferredItem<?> REMOTE = (DeferredItem<?>) ITEMS.register("remote", RemoteItem::new);
    public static final DeferredItem<?> GRENADE = (DeferredItem<?>) ITEMS.register("grenade", GrenadeItem::new);
    public static final DeferredItem<?> SLOW_GRENADE = (DeferredItem<?>) ITEMS.register("slow_grenade", SlownessGrenadeItem::new);
    public static final DeferredItem<?> WEAK_GRENADE = (DeferredItem<?>) ITEMS.register("weak_grenade", WeaknessGrenadeItem::new);
    public static final DeferredItem<?> DEBUG_WAND = (DeferredItem<?>) ITEMS.register("debug_wand", DebugWand::new);
}
