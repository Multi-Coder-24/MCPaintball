package org.multicoder.mcpaintball.data.level;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.saveddata.SavedData;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME)
public class PaintballWorldData extends SavedData
{
    public static final String SAVE_NAME = "mcpaintball";
    public static PaintballWorldData INSTANCE;
    public int RED_POINTS;
    public int GREEN_POINTS;
    public int BLUE_POINTS;
    public int CYAN_POINTS;
    public int MAGENTA_POINTS;
    public int YELLOW_POINTS;
    public int LIME_POINTS;
    public int LIGHT_BLUE_POINTS;
    public int PINK_POINTS;
    public int WHITE_POINTS;
    public boolean GAME_STARTED;

    public static PaintballWorldData create()
    {
        PaintballWorldData instance = new PaintballWorldData();
        instance.RED_POINTS = 0;
        instance.GREEN_POINTS = 0;
        instance.BLUE_POINTS = 0;
        instance.CYAN_POINTS = 0;
        instance.MAGENTA_POINTS = 0;
        instance.YELLOW_POINTS = 0;
        instance.LIME_POINTS = 0;
        instance.LIGHT_BLUE_POINTS = 0;
        instance.PINK_POINTS = 0;
        instance.WHITE_POINTS = 0;
        instance.GAME_STARTED = false;
        return instance;
    }
    public static void incrementByIndex(int index)
    {
        switch (index){
            case 1:
                INSTANCE.GREEN_POINTS++;
                break;
            case 2:
                INSTANCE.GREEN_POINTS++;
                break;
            case 3:
                INSTANCE.BLUE_POINTS++;
                break;
            case 4:
                INSTANCE.CYAN_POINTS++;
                break;
            case 5:
                INSTANCE.MAGENTA_POINTS++;
                break;
            case 6:
                INSTANCE.YELLOW_POINTS++;
                break;
            case 7:
                INSTANCE.LIME_POINTS++;
                break;
            case 8:
                INSTANCE.LIGHT_BLUE_POINTS++;
                break;
            case 9:
                INSTANCE.PINK_POINTS++;
                break;
            case 10:
                INSTANCE.WHITE_POINTS++;
                break;
        }
        INSTANCE.setDirty();
    }

    public static int fetchByIndex(int index)
    {
        switch (index){
            case 1:
                return INSTANCE.RED_POINTS;
            case 2:
                return INSTANCE.GREEN_POINTS;
            case 3:
                return INSTANCE.BLUE_POINTS;
            case 4:
                return INSTANCE.CYAN_POINTS;
            case 5:
                return INSTANCE.MAGENTA_POINTS;
            case 6:
                return INSTANCE.YELLOW_POINTS;
            case 7:
                return INSTANCE.LIME_POINTS;
            case 8:
                return INSTANCE.LIGHT_BLUE_POINTS;
            case 9:
                return INSTANCE.PINK_POINTS;
            case 10:
                return INSTANCE.WHITE_POINTS;
        }
        return -1;
    }
    public static int fetchWinner()
    {
        ArrayList<Integer> winners = new ArrayList<>();
        winners.add(INSTANCE.RED_POINTS);
        winners.add(INSTANCE.GREEN_POINTS);
        winners.add(INSTANCE.BLUE_POINTS);
        winners.add(INSTANCE.CYAN_POINTS);
        winners.add(INSTANCE.MAGENTA_POINTS);
        winners.add(INSTANCE.YELLOW_POINTS);
        winners.add(INSTANCE.LIME_POINTS);
        winners.add(INSTANCE.LIGHT_BLUE_POINTS);
        winners.add(INSTANCE.PINK_POINTS);
        winners.add(INSTANCE.WHITE_POINTS);
        return winners.stream().max(Comparator.naturalOrder()).get();
    }
    public static PaintballWorldData load(CompoundTag tag, HolderLookup.@NotNull Provider provider)
    {
        PaintballWorldData instance = new PaintballWorldData();
        instance.RED_POINTS = tag.getInt("red");
        instance.GREEN_POINTS = tag.getInt("green");
        instance.BLUE_POINTS = tag.getInt("blue");
        instance.CYAN_POINTS = tag.getInt("cyan");
        instance.MAGENTA_POINTS = tag.getInt("magenta");
        instance.YELLOW_POINTS = tag.getInt("yellow");
        instance.LIME_POINTS = tag.getInt("lime");
        instance.LIGHT_BLUE_POINTS = tag.getInt("light_blue");
        instance.PINK_POINTS = tag.getInt("pink");
        instance.WHITE_POINTS = tag.getInt("white");
        instance.GAME_STARTED = tag.getBoolean("game_started");
        return instance;
    }
    @Override
    public  @NotNull CompoundTag save(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider provider) {
        tag.putInt("red", RED_POINTS);
        tag.putInt("green", GREEN_POINTS);
        tag.putInt("blue", BLUE_POINTS);
        tag.putInt("cyan", CYAN_POINTS);
        tag.putInt("magenta", MAGENTA_POINTS);
        tag.putInt("yellow", YELLOW_POINTS);
        tag.putInt("lime", LIME_POINTS);
        tag.putInt("light_blue", LIGHT_BLUE_POINTS);
        tag.putInt("pink", PINK_POINTS);
        tag.putInt("white", WHITE_POINTS);
        tag.putBoolean("game_started", GAME_STARTED);
        return tag;
    }

    @SubscribeEvent
    public static void ServerStarted(ServerStartedEvent event){
        PaintballWorldData.INSTANCE = event.getServer().overworld().getDataStorage().computeIfAbsent(new Factory<>(PaintballWorldData::create,PaintballWorldData::load),PaintballWorldData.SAVE_NAME);
        PaintballWorldData.INSTANCE.setDirty();
    }
}
