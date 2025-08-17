package org.multicoder.mcpaintball.data.attachments;

import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.multicoder.mcpaintball.MCPaintball;

import java.util.function.Supplier;

public class MCPaintballDataAttachments{
    public static final DeferredRegister<AttachmentType<?>> DATA_ATTACHMENTS = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, MCPaintball.MOD_ID);

    public static final Supplier<AttachmentType<PlayerTeamDataAttachment>> PLAYER_TEAM = DATA_ATTACHMENTS.register("player_team",() -> AttachmentType.serializable(PlayerTeamDataAttachment::new).build());
}
