package org.multicoder.mcpaintball.common.init;


import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.block.*;
import org.multicoder.mcpaintball.common.blockitem.*;
import org.multicoder.mcpaintball.common.util.enums.Teams;

@SuppressWarnings("all")
public class blockinit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MCPaintball.MOD_ID);


    //  Blocks
    public static final RegistryObject<Block> RED_EXPLOSIVE = BLOCKS.register("utility/red_c4", Explosive::new);
    public static final RegistryObject<Block> BLUE_EXPLOSIVE = BLOCKS.register("utility/blue_c4", Explosive::new);
    public static final RegistryObject<Block> GREEN_EXPLOSIVE = BLOCKS.register("utility/green_c4", Explosive::new);
    public static final RegistryObject<Block> MAGENTA_EXPLOSIVE = BLOCKS.register("utility/magenta_c4", Explosive::new);
    public static final RegistryObject<Block> PINK_EXPLOSIVE = BLOCKS.register("utility/pink_c4", Explosive::new);
    public static final RegistryObject<Block> PURPLE_EXPLOSIVE = BLOCKS.register("utility/purple_c4", Explosive::new);
    public static final RegistryObject<Block> LIME_EXPLOSIVE = BLOCKS.register("utility/lime_c4", Explosive::new);
    public static final RegistryObject<Block> LIGHT_BLUE_EXPLOSIVE = BLOCKS.register("utility/light_blue_c4", Explosive::new);
    public static final RegistryObject<Block> CYAN_EXPLOSIVE = BLOCKS.register("utility/cyan_c4", Explosive::new);
    public static final RegistryObject<Block> RED_EXPLOSIVE_STATION = BLOCKS.register("utility/red_explosive_station", () -> new ExplosiveStationBlock(Teams.RED));
    public static final RegistryObject<Block> GREEN_EXPLOSIVE_STATION = BLOCKS.register("utility/green_explosive_station", () -> new ExplosiveStationBlock(Teams.GREEN));
    public static final RegistryObject<Block> BLUE_EXPLOSIVE_STATION = BLOCKS.register("utility/blue_explosive_station", () -> new ExplosiveStationBlock(Teams.BLUE));
    public static final RegistryObject<Block> MAGENTA_EXPLOSIVE_STATION = BLOCKS.register("utility/magenta_explosive_station", () -> new ExplosiveStationBlock(Teams.MAGENTA));
    public static final RegistryObject<Block> PINK_EXPLOSIVE_STATION = BLOCKS.register("utility/pink_explosive_station", () -> new ExplosiveStationBlock(Teams.PINK));
    public static final RegistryObject<Block> PURPLE_EXPLOSIVE_STATION = BLOCKS.register("utility/purple_explosive_station", () -> new ExplosiveStationBlock(Teams.PURPLE));
    public static final RegistryObject<Block> LIME_EXPLOSIVE_STATION = BLOCKS.register("utility/lime_explosive_station", () -> new ExplosiveStationBlock(Teams.LIME));
    public static final RegistryObject<Block> LIGHT_BLUE_EXPLOSIVE_STATION = BLOCKS.register("utility/light_blue_explosive_station", () -> new ExplosiveStationBlock(Teams.LIGHT_BLUE));
    public static final RegistryObject<Block> CYAN_EXPLOSIVE_STATION = BLOCKS.register("utility/cyan_explosive_station", () -> new ExplosiveStationBlock(Teams.CYAN));
    public static final RegistryObject<Block> RED_MEDICAL_STATION = BLOCKS.register("utility/red_medical_station", () -> new MedicalStationBlock(Teams.RED));
    public static final RegistryObject<Block> GREEN_MEDICAL_STATION = BLOCKS.register("utility/green_medical_station", () -> new MedicalStationBlock(Teams.GREEN));
    public static final RegistryObject<Block> BLUE_MEDICAL_STATION = BLOCKS.register("utility/blue_medical_station", () -> new MedicalStationBlock(Teams.BLUE));
    public static final RegistryObject<Block> MAGENTA_MEDICAL_STATION = BLOCKS.register("utility/magenta_medical_station", () -> new MedicalStationBlock(Teams.MAGENTA));
    public static final RegistryObject<Block> PINK_MEDICAL_STATION = BLOCKS.register("utility/pink_medical_station", () -> new MedicalStationBlock(Teams.PINK));
    public static final RegistryObject<Block> PURPLE_MEDICAL_STATION = BLOCKS.register("utility/purple_medical_station", () -> new MedicalStationBlock(Teams.PURPLE));
    public static final RegistryObject<Block> LIME_MEDICAL_STATION = BLOCKS.register("utility/lime_medical_station", () -> new MedicalStationBlock(Teams.LIME));
    public static final RegistryObject<Block> LIGHT_BLUE_MEDICAL_STATION = BLOCKS.register("utility/light_blue_medical_station", () -> new MedicalStationBlock(Teams.LIGHT_BLUE));
    public static final RegistryObject<Block> CYAN_MEDICAL_STATION = BLOCKS.register("utility/cyan_medical_station", () -> new MedicalStationBlock(Teams.CYAN));
    public static final RegistryObject<Block> AMMO_POD = BLOCKS.register("utility/ammo_pod", AmmoPodBlock::new);
    public static final RegistryObject<Block> RED_RESPAWN_STATION = BLOCKS.register("utility/red_respawn_station", () -> new TeamSpawnBlock(Teams.RED));
    public static final RegistryObject<Block> GREEN_RESPAWN_STATION = BLOCKS.register("utility/green_respawn_station", () -> new TeamSpawnBlock(Teams.GREEN));
    public static final RegistryObject<Block> BLUE_RESPAWN_STATION = BLOCKS.register("utility/blue_respawn_station", () -> new TeamSpawnBlock(Teams.BLUE));
    public static final RegistryObject<Block> MAGENTA_RESPAWN_STATION = BLOCKS.register("utility/magenta_respawn_station", () -> new TeamSpawnBlock(Teams.MAGENTA));
    public static final RegistryObject<Block> PINK_RESPAWN_STATION = BLOCKS.register("utility/pink_respawn_station", () -> new TeamSpawnBlock(Teams.PINK));
    public static final RegistryObject<Block> PURPLE_RESPAWN_STATION = BLOCKS.register("utility/purple_respawn_station", () -> new TeamSpawnBlock(Teams.PURPLE));
    public static final RegistryObject<Block> LIME_RESPAWN_STATION = BLOCKS.register("utility/lime_respawn_station", () -> new TeamSpawnBlock(Teams.LIME));
    public static final RegistryObject<Block> LIGHT_BLUE_RESPAWN_STATION = BLOCKS.register("utility/light_blue_respawn_station", () -> new TeamSpawnBlock(Teams.LIGHT_BLUE));
    public static final RegistryObject<Block> CYAN_RESPAWN_STATION = BLOCKS.register("utility/cyan_respawn_station", () -> new TeamSpawnBlock(Teams.CYAN));


    //  BlockItems
    public static final RegistryObject<Item> AMMO_POD_BI = iteminit.ITEMS.register("utility/ammo_pod", () -> new AmmoPodBlockItem(AMMO_POD.get()));
    public static final RegistryObject<Item> RED_MEDICAL_STATION_BI = iteminit.ITEMS.register("utility/red_medical_station", () -> new MedicalStationBlockItem(RED_MEDICAL_STATION.get()));
    public static final RegistryObject<Item> GREEN_MEDICAL_STATION_BI = iteminit.ITEMS.register("utility/green_medical_station", () -> new MedicalStationBlockItem(GREEN_MEDICAL_STATION.get()));
    public static final RegistryObject<Item> BLUE_MEDICAL_STATION_BI = iteminit.ITEMS.register("utility/blue_medical_station", () -> new MedicalStationBlockItem(BLUE_MEDICAL_STATION.get()));
    public static final RegistryObject<Item> MAGENTA_MEDICAL_STATION_BI = iteminit.ITEMS.register("utility/magenta_medical_station", () -> new MedicalStationBlockItem(MAGENTA_MEDICAL_STATION.get()));
    public static final RegistryObject<Item> PINK_MEDICAL_STATION_BI = iteminit.ITEMS.register("utility/pink_medical_station", () -> new MedicalStationBlockItem(PINK_MEDICAL_STATION.get()));
    public static final RegistryObject<Item> PURPLE_MEDICAL_STATION_BI = iteminit.ITEMS.register("utility/purple_medical_station", () -> new MedicalStationBlockItem(PURPLE_MEDICAL_STATION.get()));
    public static final RegistryObject<Item> LIME_MEDICAL_STATION_BI = iteminit.ITEMS.register("utility/lime_medical_station", () -> new MedicalStationBlockItem(LIME_MEDICAL_STATION.get()));
    public static final RegistryObject<Item> LIGHT_BLUE_MEDICAL_STATION_BI = iteminit.ITEMS.register("utility/light_blue_medical_station", () -> new MedicalStationBlockItem(LIGHT_BLUE_MEDICAL_STATION.get()));
    public static final RegistryObject<Item> CYAN_MEDICAL_STATION_BI = iteminit.ITEMS.register("utility/cyan_medical_station", () -> new MedicalStationBlockItem(CYAN_MEDICAL_STATION.get()));
    public static final RegistryObject<Item> RED_EXPLOSIVE_STATION_BI = iteminit.ITEMS.register("utility/red_explosive_station", () -> new ExplosivesStationBlockItem(RED_EXPLOSIVE_STATION.get()));
    public static final RegistryObject<Item> GREEN_EXPLOSIVE_STATION_BI = iteminit.ITEMS.register("utility/green_explosive_station", () -> new ExplosivesStationBlockItem(GREEN_EXPLOSIVE_STATION.get()));
    public static final RegistryObject<Item> BLUE_EXPLOSIVE_STATION_BI = iteminit.ITEMS.register("utility/blue_explosive_station", () -> new ExplosivesStationBlockItem(BLUE_EXPLOSIVE_STATION.get()));
    public static final RegistryObject<Item> MAGENTA_EXPLOSIVE_STATION_BI = iteminit.ITEMS.register("utility/magenta_explosive_station", () -> new ExplosivesStationBlockItem(MAGENTA_EXPLOSIVE_STATION.get()));
    public static final RegistryObject<Item> PINK_EXPLOSIVE_STATION_BI = iteminit.ITEMS.register("utility/pink_explosive_station", () -> new ExplosivesStationBlockItem(PINK_EXPLOSIVE_STATION.get()));
    public static final RegistryObject<Item> PURPLE_EXPLOSIVE_STATION_BI = iteminit.ITEMS.register("utility/purple_explosive_station", () -> new ExplosivesStationBlockItem(PURPLE_EXPLOSIVE_STATION.get()));
    public static final RegistryObject<Item> LIME_EXPLOSIVE_STATION_BI = iteminit.ITEMS.register("utility/lime_explosive_station", () -> new ExplosivesStationBlockItem(LIME_EXPLOSIVE_STATION.get()));
    public static final RegistryObject<Item> LIGHT_BLUE_EXPLOSIVE_STATION_BI = iteminit.ITEMS.register("utility/light_blue_explosive_station", () -> new ExplosivesStationBlockItem(LIGHT_BLUE_EXPLOSIVE_STATION.get()));
    public static final RegistryObject<Item> CYAN_EXPLOSIVE_STATION_BI = iteminit.ITEMS.register("utility/cyan_explosive_station", () -> new ExplosivesStationBlockItem(CYAN_EXPLOSIVE_STATION.get()));
    public static final RegistryObject<Item> RED_EXPLOSIVE_BI = iteminit.ITEMS.register("utility/red_c4", () -> new ExplosiveBlockItem(RED_EXPLOSIVE.get()));
    public static final RegistryObject<Item> GREEN_EXPLOSIVE_BI = iteminit.ITEMS.register("utility/green_c4", () -> new ExplosiveBlockItem(GREEN_EXPLOSIVE.get()));
    public static final RegistryObject<Item> BLUE_EXPLOSIVE_BI = iteminit.ITEMS.register("utility/blue_c4", () -> new ExplosiveBlockItem(BLUE_EXPLOSIVE.get()));
    public static final RegistryObject<Item> MAGENTA_EXPLOSIVE_BI = iteminit.ITEMS.register("utility/magenta_c4", () -> new ExplosiveBlockItem(MAGENTA_EXPLOSIVE.get()));
    public static final RegistryObject<Item> PINK_EXPLOSIVE_BI = iteminit.ITEMS.register("utility/pink_c4", () -> new ExplosiveBlockItem(PINK_EXPLOSIVE.get()));
    public static final RegistryObject<Item> PURPLE_EXPLOSIVE_BI = iteminit.ITEMS.register("utility/purple_c4", () -> new ExplosiveBlockItem(PURPLE_EXPLOSIVE.get()));
    public static final RegistryObject<Item> LIME_EXPLOSIVE_BI = iteminit.ITEMS.register("utility/lime_c4", () -> new ExplosiveBlockItem(LIME_EXPLOSIVE.get()));
    public static final RegistryObject<Item> LIGHT_BLUE_EXPLOSIVE_BI = iteminit.ITEMS.register("utility/light_blue_c4", () -> new ExplosiveBlockItem(LIGHT_BLUE_EXPLOSIVE.get()));
    public static final RegistryObject<Item> CYAN_EXPLOSIVE_BI = iteminit.ITEMS.register("utility/cyan_c4", () -> new ExplosiveBlockItem(CYAN_EXPLOSIVE.get()));
    public static final RegistryObject<Item> RED_RESPAWN_STATION_BI = iteminit.ITEMS.register("utility/red_respawn_station", () -> new TeamSpawnBlockItem(RED_RESPAWN_STATION.get()));
    public static final RegistryObject<Item> GREEN_RESPAWN_STATION_BI = iteminit.ITEMS.register("utility/green_respawn_station", () -> new TeamSpawnBlockItem(GREEN_RESPAWN_STATION.get()));
    public static final RegistryObject<Item> BLUE_RESPAWN_STATION_BI = iteminit.ITEMS.register("utility/blue_respawn_station", () -> new TeamSpawnBlockItem(BLUE_RESPAWN_STATION.get()));
    public static final RegistryObject<Item> MAGENTA_RESPAWN_STATION_BI = iteminit.ITEMS.register("utility/magenta_respawn_station", () -> new TeamSpawnBlockItem(MAGENTA_RESPAWN_STATION.get()));
    public static final RegistryObject<Item> PINK_RESPAWN_STATION_BI = iteminit.ITEMS.register("utility/pink_respawn_station", () -> new TeamSpawnBlockItem(PINK_RESPAWN_STATION.get()));
    public static final RegistryObject<Item> PURPLE_RESPAWN_STATION_BI = iteminit.ITEMS.register("utility/purple_respawn_station", () -> new TeamSpawnBlockItem(PURPLE_RESPAWN_STATION.get()));
    public static final RegistryObject<Item> LIME_RESPAWN_STATION_BI = iteminit.ITEMS.register("utility/lime_respawn_station", () -> new TeamSpawnBlockItem(LIME_RESPAWN_STATION.get()));
    public static final RegistryObject<Item> LIGHT_BLUE_RESPAWN_STATION_BI = iteminit.ITEMS.register("utility/light_blue_respawn_station", () -> new TeamSpawnBlockItem(LIGHT_BLUE_RESPAWN_STATION.get()));
    public static final RegistryObject<Item> CYAN_RESPAWN_STATION_BI = iteminit.ITEMS.register("utility/cyan_respawn_station", () -> new TeamSpawnBlockItem(CYAN_RESPAWN_STATION.get()));

}
