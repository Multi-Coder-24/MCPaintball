package org.multicoder.mcpaintball.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;

public record FlagItemSettings(BlockPos position, int Team,int Facing) {

    public static final Codec<FlagItemSettings> CODEC = RecordCodecBuilder.create(builder -> builder.group(
            BlockPos.CODEC.fieldOf("position").forGetter(FlagItemSettings::position),
            Codec.INT.fieldOf("Team").forGetter(FlagItemSettings::Team),
            Codec.INT.fieldOf("Facing").forGetter(FlagItemSettings::Facing)
    ).apply(builder, FlagItemSettings::new));
}
