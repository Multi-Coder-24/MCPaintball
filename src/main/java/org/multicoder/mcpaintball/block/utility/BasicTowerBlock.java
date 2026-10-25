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
        super(properties);
    }

    @Override
    protected @NonNull InteractionResult useWithoutItem(@NonNull BlockState state, @NonNull Level level, @NonNull BlockPos pos, @NonNull Player player, @NonNull BlockHitResult hitResult) {
        if(!level.isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.matchStarted && !MCPaintballGameEvents.INSTANCE.roundStarted){
                StructureTemplateManager manager = Objects.requireNonNull(level.getServer()).getStructureManager();
                StructureTemplate template;
                if(state.getBlock() == MCPaintballBlocks.RED_TOWER && Objects.requireNonNull(player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).team == 1){
                    template = manager.get(Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"red_tower")).orElseThrow();
                }else if(state.getBlock() == MCPaintballBlocks.GREEN_TOWER && Objects.requireNonNull(player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).team == 2){
                    template = manager.get(Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"green_tower")).orElseThrow();
                }else if(state.getBlock() == MCPaintballBlocks.BLUE_TOWER && Objects.requireNonNull(player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).team == 3){
                    template = manager.get(Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"blue_tower")).orElseThrow();
                }else if(state.getBlock() == MCPaintballBlocks.YELLOW_TOWER && Objects.requireNonNull(player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).team == 4){
                    template = manager.get(Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"yellow_tower")).orElseThrow();
                }else if(state.getBlock() == MCPaintballBlocks.PINK_TOWER && Objects.requireNonNull(player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).team == 5){
                    template = manager.get(Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"pink_tower")).orElseThrow();
                }else if(state.getBlock() == MCPaintballBlocks.ORANGE_TOWER && Objects.requireNonNull(player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).team == 6){
                    template = manager.get(Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"orange_tower")).orElseThrow();
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
