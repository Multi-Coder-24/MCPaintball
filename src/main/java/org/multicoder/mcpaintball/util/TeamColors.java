package org.multicoder.mcpaintball.util;

import net.minecraft.util.StringRepresentable;
import org.jspecify.annotations.NonNull;

public enum TeamColors implements StringRepresentable {
    NONE("none"),
    RED("red"),
    GREEN("green"),
    BLUE("blue"),
    CYAN("cyan"),
    MAGENTA("magenta"),
    YELLOW("yellow"),
    ORANGE("orange"),
    WHITE("white"),
    BLACK("black");

    public final String COLOR;
    TeamColors(String color){
        COLOR = color;
    }
    @Override
    public @NonNull String getSerializedName() {
        return COLOR;
    }



    public static final StringRepresentable.EnumCodec<TeamColors> CODEC =  StringRepresentable.fromEnum(TeamColors::values);
}
