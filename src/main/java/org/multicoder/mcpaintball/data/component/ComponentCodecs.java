package org.multicoder.mcpaintball.data.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public class ComponentCodecs
{
    public static final Codec<WeaponTeamDataComponent> WEAPON_TEAM_CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.INT.fieldOf("team").forGetter(WeaponTeamDataComponent::team)).apply(instance, WeaponTeamDataComponent::new));
    public static final StreamCodec<ByteBuf,WeaponTeamDataComponent> WEAPON_TEAM_NETWORKED_CODEC = StreamCodec.composite(ByteBufCodecs.INT, WeaponTeamDataComponent::team, WeaponTeamDataComponent::new);
}
