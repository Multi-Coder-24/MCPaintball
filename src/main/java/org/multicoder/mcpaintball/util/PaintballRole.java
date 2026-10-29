package org.multicoder.mcpaintball.util;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.StringRepresentable;
import org.jspecify.annotations.NonNull;

public enum PaintballRole implements StringRepresentable {
    None("text.mcpaintball.role_none"),
    Captain("text.mcpaintball.role_captain"),
    Gunner("text.mcpaintball.role_gunner"),
    Sniper("text.mcpaintball.role_sniper"),
    Specialist("text.mcpaintball.role_specialist"),
    Grenadier("text.mcpaintball.role_grenadier");
    
    PaintballRole(String translation){
        this.translation = translation;
    }
    public final String translation;

    @Override
    public @NonNull String getSerializedName() {
        return this.translation;
    }

    public static StringRepresentable.EnumCodec<PaintballRole> CODEC = StringRepresentable.fromEnum(PaintballRole::values);
    public static StreamCodec<ByteBuf,PaintballRole> STREAM_CODEC = ByteBufCodecs.fromCodec(CODEC);
}
