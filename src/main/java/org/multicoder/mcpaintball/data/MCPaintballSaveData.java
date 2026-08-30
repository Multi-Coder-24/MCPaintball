package org.multicoder.mcpaintball.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.saveddata.SavedDataType;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.block.objectives.CapturePointBlock;
import org.multicoder.mcpaintball.core.MCPaintballBlocks;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballItems;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.*;


@SuppressWarnings("all")
public class MCPaintballSaveData extends SavedData {
    public int redPoints = 0;
    public int greenPoints = 0;
    public int bluePoints = 0;
    public int yellowPoints = 0;
    public int pinkPoints = 0;
    public int orangePoints = 0;
    public boolean matchStarted = false;
    public boolean roundStarted = false;
    public List<BlockPos> capturePoints = new ArrayList<BlockPos>();

    public static final Codec<MCPaintballSaveData> CODEC = RecordCodecBuilder.create( instance  -> instance.group(
            Codec.INT.fieldOf("red_points").forGetter(MCPaintballSaveData::redPoints),
            Codec.INT.fieldOf("blue_points").forGetter(MCPaintballSaveData::bluePoints),
            Codec.INT.fieldOf("green_points").forGetter(MCPaintballSaveData::greenPoints),
            Codec.INT.fieldOf("yellow_points").forGetter(MCPaintballSaveData::yellowPoints),
            Codec.INT.fieldOf("pink_points").forGetter(MCPaintballSaveData::pinkPoints),
            Codec.INT.fieldOf("orange_points").forGetter(MCPaintballSaveData::orangePoints),
            Codec.BOOL.fieldOf("match_started").forGetter(MCPaintballSaveData::matchStarted),
            Codec.BOOL.fieldOf("round_started").forGetter(MCPaintballSaveData::roundStarted),
            Codec.list(BlockPos.CODEC).fieldOf("capture_points").forGetter(MCPaintballSaveData::capturePoints)
    ).apply(instance,MCPaintballSaveData::new));

    private List<BlockPos> capturePoints() {
        return capturePoints;
    }

    public static final SavedDataType<MCPaintballSaveData> TYPE = new SavedDataType<>(Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"paintball_data"),MCPaintballSaveData::new,CODEC,null);

    public MCPaintballSaveData(){

    }


    public MCPaintballSaveData(int redPoints, int bluePoints, int greenPoints,int yellowPoints,int pinkPoints,int orangePoints, boolean matchStarted, boolean roundStarted,List<BlockPos> capturePoints){
        this.redPoints = redPoints;
        this.bluePoints = bluePoints;
        this.greenPoints = greenPoints;
        this.yellowPoints = yellowPoints;
        this.pinkPoints = pinkPoints;
        this.orangePoints = orangePoints;
        this.matchStarted = matchStarted;
        this.roundStarted = roundStarted;
        this.capturePoints = capturePoints;
    }

    public int redPoints(){
        return redPoints;
    }
    public int greenPoints(){
        return greenPoints;
    }
    public int bluePoints(){
        return bluePoints;
    }
    public int yellowPoints(){return yellowPoints;}
    public int pinkPoints(){return pinkPoints;}
    public int orangePoints(){return orangePoints;}
    public boolean matchStarted(){
        return matchStarted;
    }
    public boolean roundStarted(){
        return roundStarted;
    }
    public void incrementByChecker(int checker){
        switch (checker){
            case 1 -> redPoints++;
            case 2 -> greenPoints++;
            case 3 -> bluePoints++;
            case 4 -> yellowPoints++;
            case 5 -> pinkPoints++;
            case 6 -> orangePoints++;
        }
        setDirty(true);
    }

    public void addCapturePoint(BlockPos pos){
        ArrayList<BlockPos> capturePointsTemp = new ArrayList<BlockPos>();
        capturePointsTemp.addAll(capturePoints);
        capturePointsTemp.add(pos);
        capturePoints = capturePointsTemp;
        setDirty(true);
    }
    public void removeCapturePoint(BlockPos pos){
        ArrayList<BlockPos> capturePointsTemp = new ArrayList<BlockPos>();
        capturePointsTemp.addAll(capturePoints);
        capturePointsTemp.remove(pos);
        capturePoints = capturePointsTemp;
        setDirty(true);
    }

    public void incrementCapturePointByChecker(int team) {
        switch (team){
            case 1 -> redPoints += 10;
            case 2 -> greenPoints += 10;
            case 3 -> bluePoints += 10;
            case 4 -> yellowPoints += 10;
            case 5 -> pinkPoints += 10;
            case 6 -> orangePoints += 10;
        }
        setDirty(true);
    }
    public void StartGame(MinecraftServer server){
        this.matchStarted = true;
        this.setDirty(true);
        server.getPlayerList().broadcastSystemMessage(Component.translatable("text.mcpaintball.game_start"),false);
    }
    public void StopGame(MinecraftServer server){
        this.matchStarted = false;
        this.roundStarted = false;
        this.redPoints = 0;
        this.greenPoints = 0;
        this.bluePoints = 0;
        this.yellowPoints = 0;
        this.pinkPoints = 0;
        this.orangePoints = 0;
        this.capturePoints = new ArrayList<>();
        this.setDirty(true);
        server.getPlayerList().broadcastSystemMessage(Component.translatable("text.mcpaintball.game_stopped"),false);
        server.getPlayerList().getPlayers().forEach(player -> {
            MCPaintballPlayerData data = new MCPaintballPlayerData(0,0);
            player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER,data);
        });
    }
    public void StartRound(MinecraftServer server, ServerPlayer player){
        if(this.matchStarted){
            this.roundStarted = true;
            this.setDirty(true);
            server.getPlayerList().broadcastSystemMessage(Component.translatable("text.mcpaintball.round_started"),false);
        }
        else {
            player.sendSystemMessage(Component.translatable("text.mcpaintball.error_game_not_started"),false);
        }
    }
    public void StopRound(MinecraftServer server, ServerPlayer player){
        if(this.matchStarted){
            this.roundStarted = false;
            this.capturePoints.forEach(pos ->{
                if(server.overworld().getBlockState(pos).getBlock() == MCPaintballBlocks.CAPTURE_POINT){
                    int Team = server.overworld().getBlockState(pos).getValue(CapturePointBlock.TEAM);
                    incrementCapturePointByChecker(Team);
                    server.overworld().setBlockAndUpdate(pos,server.overworld().getBlockState(pos).setValue(CapturePointBlock.TEAM, 0));
                }
            });
            this.setDirty(true);
            server.getPlayerList().broadcastSystemMessage(Component.translatable("text.mcpaintball.round_ended"),false);
        }
        else {
            player.sendSystemMessage(Component.translatable("text.mcpaintball.error_game_not_started"),false);
        }
    }
    public void RoundWinner(MinecraftServer server){
        List<Integer> points = new ArrayList<>();
        points.add(MCPaintballGameEvents.INSTANCE.redPoints);
        points.add(MCPaintballGameEvents.INSTANCE.greenPoints);
        points.add(MCPaintballGameEvents.INSTANCE.bluePoints);
        points.add(MCPaintballGameEvents.INSTANCE.yellowPoints);
        points.add(MCPaintballGameEvents.INSTANCE.pinkPoints);
        points.add(MCPaintballGameEvents.INSTANCE.orangePoints);
        int Winner = points.indexOf(points.stream().max(Comparator.naturalOrder()).get());
        Component Team = switch (Winner){
            case 0 -> Component.translatable("text.mcpaintball.team_red");
            case 1 -> Component.translatable("text.mcpaintball.team_green");
            case 2 -> Component.translatable("text.mcpaintball.team_blue");
            case 3 -> Component.translatable("text.mcpaintball.team_yellow");
            case 4 -> Component.translatable("text.mcpaintball.team_pink");
            case 5 -> Component.translatable("text.mcpaintball.team_orange");
            default -> throw new IllegalStateException("Unexpected value: " + Winner);
        };
        int FWinner = Winner + 1;
        server.getPlayerList().broadcastSystemMessage(Component.translatable("text.mcpaintball.round_winner",Team),false);
        server.getPlayerList().getPlayers().forEach(serverPlayer ->{
            if(Objects.requireNonNull(serverPlayer.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).team == FWinner){
                serverPlayer.addItem(new ItemStack(MCPaintballItems.MEDAL));
            }
        });
    }
}
