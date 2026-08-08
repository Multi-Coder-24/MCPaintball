package org.multicoder.mcpaintball.block.utility;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.core.MCPaintballBlocks;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public class BasicTowerBlock extends Block {
    public BasicTowerBlock(Properties properties) {
        super(properties.noOcclusion());
    }

    @Override
    protected @NonNull InteractionResult useWithoutItem(@NonNull BlockState state, @NonNull Level level, @NonNull BlockPos pos, @NonNull Player player, @NonNull BlockHitResult hitResult) {
        if(!level.isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.MatchStarted && MCPaintballGameEvents.INSTANCE.RoundStarted){
                StructureTemplateManager manager = Objects.requireNonNull(level.getServer()).getStructureManager();
                StructureTemplate template;
                if(state.getBlock() == MCPaintballBlocks.RED_TOWER.get() && Objects.requireNonNull(player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get())).Team == 1){
                    template = manager.get(Identifier.fromNamespaceAndPath(MCPaintball.MODID,"red_tower")).orElseThrow();
                }else if(state.getBlock() == MCPaintballBlocks.GREEN_TOWER.get() && Objects.requireNonNull(player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get())).Team == 2){
                    template = manager.get(Identifier.fromNamespaceAndPath(MCPaintball.MODID,"green_tower")).orElseThrow();
                }else if(state.getBlock() == MCPaintballBlocks.BLUE_TOWER.get() && Objects.requireNonNull(player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get())).Team == 3){
                    template = manager.get(Identifier.fromNamespaceAndPath(MCPaintball.MODID,"blue_tower")).orElseThrow();
                }else if(state.getBlock() == MCPaintballBlocks.YELLOW_TOWER.get() && Objects.requireNonNull(player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get())).Team == 4){
                    template = manager.get(Identifier.fromNamespaceAndPath(MCPaintball.MODID,"yellow_tower")).orElseThrow();
                }else if(state.getBlock() == MCPaintballBlocks.PINK_TOWER.get() && Objects.requireNonNull(player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get())).Team == 5){
                    template = manager.get(Identifier.fromNamespaceAndPath(MCPaintball.MODID,"pink_tower")).orElseThrow();
                }else if(state.getBlock() == MCPaintballBlocks.ORANGE_TOWER.get() && Objects.requireNonNull(player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get())).Team == 6){
                    template = manager.get(Identifier.fromNamespaceAndPath(MCPaintball.MODID,"orange_tower")).orElseThrow();
                }else {
                    return InteractionResult.PASS;
                }
                template.placeInWorld((ServerLevelAccessor) level,pos.offset(-3,-1,-7),pos,new StructurePlaceSettings(),level.getRandom(),Block.UPDATE_ALL_IMMEDIATE);
                level.setBlock(pos, Blocks.AIR.defaultBlockState(),Block.UPDATE_ALL_IMMEDIATE);
                return InteractionResult.SUCCESS;
            }
        }
        return super.useWithoutItem(state, level, pos, player, hitResult);
    }
}
