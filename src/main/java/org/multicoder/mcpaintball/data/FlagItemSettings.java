package org.multicoder.mcpaintball.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;

public record FlagItemSettings(BlockPos position,int team,int facing) {
    public static final Codec<FlagItemSettings> CODEC = RecordCodecBuilder.create(builder -> builder.group(
            BlockPos.CODEC.fieldOf("position").forGetter(FlagItemSettings::position),
                    Codec.INT.fieldOf("team").forGetter(FlagItemSettings::team),
            Codec.INT.fieldOf("facing").forGetter(FlagItemSettings::facing))
            .apply(builder, FlagItemSettings::new));
}
