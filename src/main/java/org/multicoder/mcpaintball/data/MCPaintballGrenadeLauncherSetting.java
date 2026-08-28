package org.multicoder.mcpaintball.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record MCPaintballGrenadeLauncherSetting(int setting) {
    public static final Codec<MCPaintballGrenadeLauncherSetting> CODEC = RecordCodecBuilder.create(builder -> builder.group(Codec.INT.fieldOf("setting").forGetter(MCPaintballGrenadeLauncherSetting::setting)).apply(builder, MCPaintballGrenadeLauncherSetting::new));
}
