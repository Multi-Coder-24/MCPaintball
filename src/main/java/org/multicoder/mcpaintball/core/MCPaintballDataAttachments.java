package org.multicoder.mcpaintball.core;

import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentSyncPredicate;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.resources.Identifier;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.util.PaintballRole;
import org.multicoder.mcpaintball.util.PaintballTeam;

public class MCPaintballDataAttachments {
    public static final AttachmentType<MCPaintballPlayerData> PAINTBALL_PLAYER = AttachmentRegistry.create(Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"paintball_player"),builder -> builder.initializer(() -> new MCPaintballPlayerData(PaintballTeam.None, PaintballRole.None)).persistent(MCPaintballPlayerData.CODEC).syncWith(MCPaintballPlayerData.STREAM_CODEC, AttachmentSyncPredicate.all()).copyOnDeath().buildAndRegister(Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"paintball_player")));
    public static void initialize(){
        MCPaintball.LOGGER.info("Initialize DataAttachments");
    }
}
