package org.multicoder.mcpaintball.core;

import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;

public class MCPaintballDataAttachments {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENTS = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, MCPaintball.MODID);

    public static final DeferredHolder<AttachmentType<?>,AttachmentType<MCPaintballPlayerData>> PAINTBALL_PLAYER = ATTACHMENTS.register("paintball_player",() -> AttachmentType.builder(MCPaintballPlayerData::new).sync(MCPaintballPlayerData.STREAM_CODEC).serialize(MapCodec.assumeMapUnsafe(MCPaintballPlayerData.CODEC)).build());
}
