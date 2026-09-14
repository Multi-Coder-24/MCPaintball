package org.multicoder.mcpaintball.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.StringRepresentable;
import org.jspecify.annotations.NonNull;

public enum PaintballColors implements StringRepresentable {
    None("text.mcpaintball.team_none"),
    Red("text.mcpaintball.team_red"),
    Green("text.mcpaintball.team_green"),
    Blue("text.mcpaintball.team_blue"),
    Yellow("text.mcpaintball.team_yellow"),
    Pink("text.mcpaintball.team_pink"),
    Orange("text.mcpaintball.team_orange"),
    Admin("text.mcpaintball.team_admin");
    PaintballColors(String translation){
        this.translation = translation;
    }
    public final String translation;

    @Override
    public @NonNull String getSerializedName() {
        return this.translation;
    }

    public static final Codec<PaintballColors> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("value").forGetter(PaintballColors::getValue)
    ).apply(instance,PaintballColors::fromValue));

    public int getValue(){
        return this.ordinal();
    }

    public static PaintballColors fromValue(int value){
        return values()[value];
    }
}
