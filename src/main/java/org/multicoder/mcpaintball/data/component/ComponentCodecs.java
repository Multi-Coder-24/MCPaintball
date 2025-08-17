package org.multicoder.mcpaintball.data.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public class ComponentCodecs
{
    public static final Codec<ItemTeamDataComponent> ITEM_TEAM_CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.INT.fieldOf("team").forGetter(ItemTeamDataComponent::team)).apply(instance, ItemTeamDataComponent::new));
    public static final StreamCodec<ByteBuf,ItemTeamDataComponent> ITEM_TEAM_NETWORKED_CODEC = StreamCodec.composite(ByteBufCodecs.INT, ItemTeamDataComponent::team, ItemTeamDataComponent::new);

    public static final Codec<ItemClassComponent> ITEM_CLASS_CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.INT.fieldOf("Class").forGetter(ItemClassComponent::Class)).apply(instance, ItemClassComponent::new));
    public static final StreamCodec<ByteBuf,ItemClassComponent> ITEM_CLASS_NETWORKED_CODEC = StreamCodec.composite(ByteBufCodecs.INT, ItemClassComponent::Class, ItemClassComponent::new);

}
