package org.multicoder.mcpaintball.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;

import java.util.List;

public record MCPaintballRemoteLinksDataComponent(List<BlockPos> positions) {

    @Override
    public List<BlockPos> positions() {
        return positions;
    }

    public static final Codec<MCPaintballRemoteLinksDataComponent> CODEC = RecordCodecBuilder.create(builder -> builder.group(Codec.list(BlockPos.CODEC).fieldOf("positions").forGetter(MCPaintballRemoteLinksDataComponent::positions)).apply(builder, MCPaintballRemoteLinksDataComponent::new));
}
