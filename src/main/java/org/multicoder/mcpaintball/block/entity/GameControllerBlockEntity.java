package org.multicoder.mcpaintball.block.entity;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.UUIDUtil;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.core.MCPaintballBlockEntities;
import org.multicoder.mcpaintball.util.PaintballColors;

import java.util.*;

@SuppressWarnings("all")
public class GameControllerBlockEntity extends BlockEntity {

    public Map<UUID,String> TEAM_NAMES;
    public Map<String,UUID> TEAM_IDS;
    public Map<UUID, PaintballColors> TEAM_COLORS;
    public Map<UUID,Integer> POINTS;
    public Map<UUID,Integer> WINS;
    public Map<UUID, List<UUID>> PLAYERS;
    public List<UUID> ADMINS;
    public List<BlockPos> CAPTURE_POINTS;
    public UUID controllerID;
    public String tournamentName;
    public boolean tournamentStarted;
    public boolean roundStarted;

    public GameControllerBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(MCPaintballBlockEntities.GAME_CONTROLLER_BLOCK_ENTITY, worldPosition, blockState);
        TEAM_NAMES = new HashMap<>();
        TEAM_IDS = new HashMap<>();
        TEAM_COLORS = new HashMap<>();
        POINTS = new HashMap<>();
        WINS = new HashMap<>();
        PLAYERS = new HashMap<>();
        ADMINS = new ArrayList<>();
        CAPTURE_POINTS = new ArrayList<>();
        controllerID = UUID.randomUUID();
        tournamentName = "Placeholder";
        tournamentStarted = false;
        roundStarted = false;
        this.setChanged();
    }

    @Override
    protected void saveAdditional(@NonNull ValueOutput output) {
        super.saveAdditional(output);
        output.store("team_names", Codec.unboundedMap(UUIDUtil.CODEC,Codec.STRING), TEAM_NAMES);
        output.store("team_ids",Codec.unboundedMap(Codec.STRING,UUIDUtil.CODEC),TEAM_IDS);
        output.store("team_colors",Codec.unboundedMap(UUIDUtil.CODEC,PaintballColors.CODEC),TEAM_COLORS);
        output.store("points",Codec.unboundedMap(UUIDUtil.CODEC,Codec.INT),POINTS);
        output.store("wins",Codec.unboundedMap(UUIDUtil.CODEC,Codec.INT),WINS);
        output.store("players",Codec.unboundedMap(UUIDUtil.CODEC,Codec.list(UUIDUtil.CODEC)),PLAYERS);
        output.store("admins",Codec.list(UUIDUtil.CODEC),ADMINS);
        output.store("capture_points",Codec.list(BlockPos.CODEC),CAPTURE_POINTS);
        output.store("controller_id",UUIDUtil.CODEC,controllerID);
        output.store("tournament_name",Codec.STRING,tournamentName);
        output.store("tournament_started",Codec.BOOL, tournamentStarted);
        output.store("round_started",Codec.BOOL, roundStarted);
    }

    @Override
    protected void loadAdditional(@NonNull ValueInput input) {
        super.loadAdditional(input);
        TEAM_NAMES = input.read("team_names",Codec.unboundedMap(UUIDUtil.CODEC,Codec.STRING)).get();
        TEAM_IDS = input.read("team_ids",Codec.unboundedMap(Codec.STRING,UUIDUtil.CODEC)).get();
        TEAM_COLORS = input.read("team_colors",Codec.unboundedMap(UUIDUtil.CODEC,PaintballColors.CODEC)).get();
        POINTS = input.read("points",Codec.unboundedMap(UUIDUtil.CODEC,Codec.INT)).get();
        WINS = input.read("wins",Codec.unboundedMap(UUIDUtil.CODEC,Codec.INT)).get();
        PLAYERS = input.read("players",Codec.unboundedMap(UUIDUtil.CODEC,Codec.list(UUIDUtil.CODEC))).get();
        ADMINS = input.read("admins",Codec.list(UUIDUtil.CODEC)).get();
        CAPTURE_POINTS = input.read("capture_points",Codec.list(BlockPos.CODEC)).get();
        controllerID = input.read("controller_id",UUIDUtil.CODEC).get();
        tournamentName = input.read("tournament_name",Codec.STRING).get();
        tournamentStarted = input.read("tournament_started",Codec.BOOL).get();
        roundStarted = input.read("round_started",Codec.BOOL).get();
    }
}
