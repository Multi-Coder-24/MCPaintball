package org.multicoder.mcpaintball.util;

import net.minecraft.util.StringRepresentable;
import org.jspecify.annotations.NonNull;

public enum PaintballTeam implements StringRepresentable {
    None("text.mcpaintball.team_none"),
    Red("text.mcpaintball.team_red"),
    Green("text.mcpaintball.team_green"),
    Blue("text.mcpaintball.team_blue"),;
    PaintballTeam(String translation){
        Translation = translation;
    }
    public final String Translation;

    @Override
    public @NonNull String getSerializedName() {
        return this.Translation;
    }
}
