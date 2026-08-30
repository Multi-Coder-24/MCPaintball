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
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.block.objectives.CapturePointBlock;
import org.multicoder.mcpaintball.core.MCPaintballBlocks;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballItems;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class MCPaintballSaveData extends SavedData {
    public int RedPoints = 0;
    public int GreenPoints = 0;
    public int BluePoints = 0;
    public int YellowPoints = 0;
    public int PinkPoints = 0;
    public int OrangePoints = 0;
    public boolean MatchStarted = false;
    public boolean RoundStarted = false;
    public List<BlockPos> CapturePoints = new ArrayList<>();
    public static final Codec<MCPaintballSaveData> CODEC = RecordCodecBuilder.create(instance  -> instance.group(
            Codec.INT.fieldOf("red_points").forGetter(MCPaintballSaveData::RedPoints),
            Codec.INT.fieldOf("blue_points").forGetter(MCPaintballSaveData::BluePoints),
            Codec.INT.fieldOf("green_points").forGetter(MCPaintballSaveData::GreenPoints),
            Codec.INT.fieldOf("yellow_points").forGetter(MCPaintballSaveData::YellowPoints),
            Codec.INT.fieldOf("pink_points").forGetter(MCPaintballSaveData::PinkPoints),
            Codec.INT.fieldOf("orange_points").forGetter(MCPaintballSaveData::OrangePoints),
            Codec.BOOL.fieldOf("match_started").forGetter(MCPaintballSaveData::MatchStarted),
            Codec.BOOL.fieldOf("round_started").forGetter(MCPaintballSaveData::RoundStarted),
            Codec.list(BlockPos.CODEC).fieldOf("capture_points").forGetter(MCPaintballSaveData::CapturePoints)
    ).apply(instance,MCPaintballSaveData::new));

    private List<BlockPos> CapturePoints() {
        return CapturePoints;
    }

    public static final SavedDataType<MCPaintballSaveData> TYPE = new SavedDataType<>(Identifier.fromNamespaceAndPath(MCPaintball.MODID,"paintball_data"),MCPaintballSaveData::new,CODEC,null);

    public MCPaintballSaveData(){}


    public MCPaintballSaveData(int redPoints, int bluePoints, int greenPoints,int yellowPoints,int pinkPoints,int orangePoints, boolean matchStarted, boolean roundStarted,List<BlockPos> capturePoints){
        RedPoints = redPoints;
        BluePoints = bluePoints;
        GreenPoints = greenPoints;
        YellowPoints = yellowPoints;
        PinkPoints = pinkPoints;
        OrangePoints = orangePoints;
        MatchStarted = matchStarted;
        RoundStarted = roundStarted;
        CapturePoints = capturePoints;
    }

    public int RedPoints(){
        return RedPoints;
    }
    public int GreenPoints(){
        return GreenPoints;
    }
    public int BluePoints(){
        return BluePoints;
    }
    public int YellowPoints(){return YellowPoints;}
    public int PinkPoints(){return PinkPoints;}
    public int OrangePoints(){return OrangePoints;}
    public boolean MatchStarted(){
        return MatchStarted;
    }
    public boolean RoundStarted(){
        return RoundStarted;
    }

    public void IncrementByChecker(int Checker){
        switch (Checker){
            case 1-> RedPoints++;
            case 2-> GreenPoints++;
            case 3-> BluePoints++;
            case 4-> YellowPoints++;
            case 5-> PinkPoints++;
            case 6-> OrangePoints++;
        }
        setDirty(true);
    }

    public void removeCapturePoint(@NonNull BlockPos pos) {
        ArrayList<BlockPos> points = new ArrayList<>(CapturePoints);
        points.remove(pos);
        CapturePoints = points;
        setDirty(true);
    }

    public void addCapturePoint(@NonNull BlockPos pos) {
        ArrayList<BlockPos> points = new ArrayList<>(CapturePoints);
        points.add(pos);
        CapturePoints = points;
        setDirty(true);
    }

    public void incrementCapturePointByChecker(int team) {
        switch (team){
            case 1 -> RedPoints += 10;
            case 2 -> GreenPoints += 10;
            case 3 -> BluePoints += 10;
            case 4 -> YellowPoints += 10;
            case 5 -> PinkPoints += 10;
            case 6 -> OrangePoints += 10;
        }
        setDirty(true);
    }

    public void StartGame(MinecraftServer server){
        this.MatchStarted = true;
        this.setDirty(true);
        server.getPlayerList().broadcastSystemMessage(Component.translatable("text.mcpaintball.game_start"),false);
    }
    public void StopGame(MinecraftServer server){
        this.MatchStarted = false;
        this.RoundStarted = false;
        this.RedPoints = 0;
        this.GreenPoints = 0;
        this.BluePoints = 0;
        this.YellowPoints = 0;
        this.PinkPoints = 0;
        this.OrangePoints = 0;
        this.CapturePoints = new ArrayList<>();
        this.setDirty(true);
        server.getPlayerList().broadcastSystemMessage(Component.translatable("text.mcpaintball.game_stopped"),false);
        server.getPlayerList().getPlayers().forEach(player -> {
            MCPaintballPlayerData data = new MCPaintballPlayerData(0,0);
            player.setData(MCPaintballDataAttachments.PAINTBALL_PLAYER,data);
        });
    }
    public void StartRound(MinecraftServer server, ServerPlayer player){
        if(this.MatchStarted){
            this.RoundStarted = true;
            this.setDirty(true);
            server.getPlayerList().broadcastSystemMessage(Component.translatable("text.mcpaintball.round_started"),false);
        }
        else {
            player.sendSystemMessage(Component.translatable("text.mcpaintball.error_game_not_started"),false);
        }
    }
    public void StopRound(MinecraftServer server, ServerPlayer player){
        if(this.MatchStarted){
            this.RoundStarted = false;
            this.CapturePoints.forEach(pos ->{
                if(server.overworld().getBlockState(pos).getBlock() == MCPaintballBlocks.CAPTURE_POINT.get()){
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
        points.add(MCPaintballGameEvents.INSTANCE.RedPoints);
        points.add(MCPaintballGameEvents.INSTANCE.GreenPoints);
        points.add(MCPaintballGameEvents.INSTANCE.BluePoints);
        points.add(MCPaintballGameEvents.INSTANCE.YellowPoints);
        points.add(MCPaintballGameEvents.INSTANCE.PinkPoints);
        points.add(MCPaintballGameEvents.INSTANCE.OrangePoints);
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
            if(Objects.requireNonNull(serverPlayer.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == FWinner){
                serverPlayer.addItem(new ItemStack(MCPaintballItems.MEDAL.get()));
            }
        });
    }
}

