package org.multicoder.mcpaintball.util;

import net.minecraft.util.StringRepresentable;
import org.jspecify.annotations.NonNull;

public enum PaintballType implements StringRepresentable {
    None("text.mcpaintball.type_none"),
    Standard("text.mcpaintball.type_standard"),
    Sniper("text.mcpaintball.type_sniper"),
    Assault("text.mcpaintball.type_assault"),
    Heavy("text.mcpaintball.type_heavy");
    PaintballType(String translation){
        Translation = translation;
    }
    public final String Translation;

    @Override
    public @NonNull String getSerializedName() {
        return this.Translation;
    }
}
