package org.multicoder.mcpaintball.util;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.StringRepresentable;
import org.jspecify.annotations.NonNull;

public enum PaintballTeam implements StringRepresentable {
    None("text.mcpaintball.team_none"),
    Red("text.mcpaintball.team_red"),
    Green("text.mcpaintball.team_green"),
    Blue("text.mcpaintball.team_blue"),
    Yellow("text.mcpaintball.team_yellow"),
    Pink("text.mcpaintball.team_pink"),
    Orange("text.mcpaintball.team_orange"),
    Admin("text.mcpaintball.team_admin");
    PaintballTeam(String translation){
        this.translation = translation;
    }
    public final String translation;

    @Override
    public @NonNull String getSerializedName() {
        return this.translation;
    }

    public static StringRepresentable.EnumCodec<PaintballTeam> CODEC = StringRepresentable.fromEnum(PaintballTeam::values);
    public static StreamCodec<ByteBuf,PaintballTeam> STREAM_CODEC = ByteBufCodecs.fromCodec(CODEC);
}
