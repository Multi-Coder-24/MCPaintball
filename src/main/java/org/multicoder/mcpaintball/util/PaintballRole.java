package org.multicoder.mcpaintball.util;

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
}
