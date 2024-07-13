package org.multicoder.mcpaintball.common.data.containers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.List;

public record C4LocationData(List<Long> Positions)
{

    public static final Codec<C4LocationData> CODEC = RecordCodecBuilder.create(objectInstance -> objectInstance.group(Codec.list(Codec.LONG).fieldOf("Positions").forGetter(C4LocationData::Positions)).apply(objectInstance,C4LocationData::new));
}

