package org.multicoder.mcpaintball.init;


import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.block.blockitem.BasicAmmoPodBlockItem;
import org.multicoder.mcpaintball.block.blockitem.ExplosiveBlockItem;
import org.multicoder.mcpaintball.block.blockitem.ExplosivesStationBlockItem;
import org.multicoder.mcpaintball.block.explosive.*;
import org.multicoder.mcpaintball.block.explosive_station.*;
import org.multicoder.mcpaintball.block.pods.*;

import java.util.function.Supplier;

public class blockinit
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MCPaintball.MODID);

    public static final RegistryObject<Block> RED_EXPLOSIVE = RegisterExplosiveBlock("utility/red_explosive", RedExplosive::new);
    public static final RegistryObject<Block> BLUE_EXPLOSIVE = RegisterExplosiveBlock("utility/blue_explosive", BlueExplosive::new);
    public static final RegistryObject<Block> GREEN_EXPLOSIVE = RegisterExplosiveBlock("utility/green_explosive", GreenExplosive::new);
    public static final RegistryObject<Block> MAGENTA_EXPLOSIVE = RegisterExplosiveBlock("utility/magenta_explosive", MagentaExplosive::new);
    public static final RegistryObject<Block> PINK_EXPLOSIVE = RegisterExplosiveBlock("utility/pink_explosive", PinkExplosive::new);
    public static final RegistryObject<Block> PURPLE_EXPLOSIVE = RegisterExplosiveBlock("utility/purple_explosive", PurpleExplosive::new);
    public static final RegistryObject<Block> LIME_EXPLOSIVE = RegisterExplosiveBlock("utility/lime_explosive", LimeExplosive::new);
    public static final RegistryObject<Block> LIGHT_BLUE_EXPLOSIVE = RegisterExplosiveBlock("utility/light_blue_explosive", LightBlueExplosive::new);


    public static final RegistryObject<Block> RED_AMMO_POD_BASIC = RegisterBasicAmmoPodBlock("utility/basic_red_ammo", RedAmmoPod::new);
    public static final RegistryObject<Block> GREEN_AMMO_POD_BASIC = RegisterBasicAmmoPodBlock("utility/basic_green_ammo", GreenAmmoPod::new);
    public static final RegistryObject<Block> BLUE_AMMO_POD_BASIC = RegisterBasicAmmoPodBlock("utility/basic_blue_ammo", BlueAmmoPod::new);
    public static final RegistryObject<Block> MAGENTA_AMMO_POD_BASIC = RegisterBasicAmmoPodBlock("utility/basic_magenta_ammo", MagentaAmmoPod::new);
    public static final RegistryObject<Block> PINK_AMMO_POD_BASIC = RegisterBasicAmmoPodBlock("utility/basic_pink_ammo", PinkAmmoPod::new);
    public static final RegistryObject<Block> PURPLE_AMMO_POD_BASIC = RegisterBasicAmmoPodBlock("utility/basic_purple_ammo", PurpleAmmoPod::new);
    public static final RegistryObject<Block> LIME_AMMO_POD_BASIC = RegisterBasicAmmoPodBlock("utility/basic_lime_ammo", LimeAmmoPod::new);
    public static final RegistryObject<Block> LIGHT_BLUE_AMMO_POD_BASIC = RegisterBasicAmmoPodBlock("utility/basic_light_blue_ammo", LightBlueAmmoPod::new);

    public static final RegistryObject<Block> RED_EXPLOSIVE_STATION = RegisterBasicStationBlock("utility/basic_red_station", RedExplosiveStation::new);
    public static final RegistryObject<Block> GREEN_EXPLOSIVE_STATION = RegisterBasicStationBlock("utility/basic_green_station", GreenExplosiveStation::new);
    public static final RegistryObject<Block> BLUE_EXPLOSIVE_STATION = RegisterBasicStationBlock("utility/basic_blue_station", BlueExplosiveStation::new);
    public static final RegistryObject<Block> MAGENTA_EXPLOSIVE_STATION = RegisterBasicStationBlock("utility/basic_magenta_station", MagentaExplosiveStation::new);
    public static final RegistryObject<Block> PINK_EXPLOSIVE_STATION = RegisterBasicStationBlock("utility/basic_pink_station", PinkExplosiveStation::new);
    public static final RegistryObject<Block> PURPLE_EXPLOSIVE_STATION = RegisterBasicStationBlock("utility/basic_purple_station", PurpleExplosiveStation::new);
    public static final RegistryObject<Block> LIME_EXPLOSIVE_STATION = RegisterBasicStationBlock("utility/basic_lime_station", LimeExplosiveStation::new);
    public static final RegistryObject<Block> LIGHT_BLUE_EXPLOSIVE_STATION = RegisterBasicStationBlock("utility/basic_light_blue_station", LightBlueExplosiveStation::new);

    private static <T extends Block> RegistryObject<T> RegisterBasicAmmoPodBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        RegisterBasicAmmoPodBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> RegisterBasicAmmoPodBlockItem(String name, RegistryObject<T> block) {
        return iteminit.ITEMS.register(name, () -> new BasicAmmoPodBlockItem(block.get()));
    }
    private static <T extends Block> RegistryObject<T> RegisterBasicStationBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        RegisterBasicStationBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> RegisterBasicStationBlockItem(String name, RegistryObject<T> block) {
        return iteminit.ITEMS.register(name, () -> new ExplosivesStationBlockItem(block.get()));
    }
    private static <T extends Block> RegistryObject<T> RegisterExplosiveBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return iteminit.ITEMS.register(name, () -> new ExplosiveBlockItem(block.get()));
    }
}
