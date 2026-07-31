package org.multicoder.mcpaintball.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;

public record FlagItemSettings(BlockPos Position, int Team) {
    public static final Codec<FlagItemSettings> CODEC = RecordCodecBuilder.create(builder -> builder.group(
            BlockPos.CODEC.fieldOf("position").forGetter(FlagItemSettings::Position),
                    Codec.INT.fieldOf("team").forGetter(FlagItemSettings::Team))
            .apply(builder, FlagItemSettings::new));
}
