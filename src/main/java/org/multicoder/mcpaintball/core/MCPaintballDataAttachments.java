package org.multicoder.mcpaintball.core;

import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentSyncPredicate;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.resources.Identifier;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;

public class MCPaintballDataAttachments {
    public static final AttachmentType<MCPaintballPlayerData> PAINTBALL_PLAYER = AttachmentRegistry.create(Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"paintball_player"),builder -> builder.initializer(() -> new MCPaintballPlayerData(0,0)).persistent(MCPaintballPlayerData.CODEC).syncWith(MCPaintballPlayerData.STREAM_CODEC, AttachmentSyncPredicate.all()).copyOnDeath().buildAndRegister(Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"paintball_player")));
    public static void Initialize(){
        MCPaintball.LOGGER.info("Initialize DataAttachments");
    }
}
