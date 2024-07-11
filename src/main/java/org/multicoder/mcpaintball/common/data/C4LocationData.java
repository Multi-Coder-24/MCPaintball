package org.multicoder.mcpaintball.common.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public record C4LocationData(List<Long> Positions)
{

    public static final Codec<C4LocationData> CODEC = RecordCodecBuilder.create(objectInstance -> objectInstance.group(Codec.list(Codec.LONG).fieldOf("Positions").forGetter(C4LocationData::Positions)).apply(objectInstance,C4LocationData::new));
}

