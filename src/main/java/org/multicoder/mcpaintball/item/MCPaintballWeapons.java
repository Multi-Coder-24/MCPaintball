package org.multicoder.mcpaintball.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.item.weapons.*;

@SuppressWarnings("unused")
public class MCPaintballWeapons
{
    public static final DeferredRegister <Item> WEAPONS = DeferredRegister.create(Registries.ITEM, MCPaintball.MOD_ID);

    public static final DeferredHolder<Item,Item> PISTOL = WEAPONS.register("weapon/pistol", PistolItem::new);
    public static final DeferredHolder<Item,Item> SHOTGUN = WEAPONS.register("weapon/shotgun", ShotgunItem::new);
    public static final DeferredHolder<Item,Item> ASSAULT_RIFLE = WEAPONS.register("weapon/rifle", AssaultRifleItem::new);
    public static final DeferredHolder<Item,Item> SNIPER_RIFLE = WEAPONS.register("weapon/sniper", SniperRifleItem::new);
    public static final DeferredHolder<Item,Item> BURST_RIFLE = WEAPONS.register("weapon/burst", BurstRifleItem::new);
        public static final DeferredHolder<Item,Item> BAZOOKA = WEAPONS.register("weapon/bazooka", BazookaItem::new);
}
