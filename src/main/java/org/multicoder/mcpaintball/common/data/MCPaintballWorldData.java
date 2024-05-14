package org.multicoder.mcpaintball.common.data;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.saveddata.SavedData;

import java.rmi.AccessException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class MCPaintballWorldData extends SavedData {
    public static final String SAVE_NAME = "mcpaintball";

    public static MCPaintballWorldData INSTANCE;

    public String VERSION;
    public List<MCPaintballMatch> MATCHES;

    public static MCPaintballWorldData create() {
        MCPaintballWorldData data = new MCPaintballWorldData();
        data.VERSION = "2.0.0";
        data.MATCHES = new ArrayList<>();
        return data;
    }

    public static MCPaintballWorldData load(CompoundTag nbt) {
        MCPaintballWorldData data = new MCPaintballWorldData();
        data.VERSION = nbt.getString("version");
        data.MATCHES = new ArrayList<>();
        ListTag Matches = nbt.getList("matches", Tag.TAG_COMPOUND);
        Matches.forEach(tag -> {
            CompoundTag NBT = (CompoundTag) tag;
            data.MATCHES.add(new MCPaintballMatch(NBT));
        });
        return data;
    }

    @Override
    public CompoundTag save(CompoundTag tag) {
        tag.putString("version", VERSION);
        ListTag Matches = new ListTag();
        MATCHES.forEach(match -> Matches.add(match.Serialize()));
        tag.put("matches", Matches);
        return tag;
    }

    public void IncrementByName(String name, int Index,Class<?> Invoker) throws AccessException {
        if(Invoker.getPackageName().startsWith("org.multicoder")){
            AtomicReference<MCPaintballMatch> Buffered = new AtomicReference<>();
            MATCHES.forEach(mcPaintballMatch -> {
                if (mcPaintballMatch.Name.equalsIgnoreCase(name)) {
                    Buffered.set(mcPaintballMatch);
                }
            });
            if (Buffered.get() != null) {
                MCPaintballMatch Match = Buffered.get();
                Match.IncrementByOrdinal(Index);
                setDirty(true);
            }
        }
        else{
            throw new AccessException("Cannot Access This Class");
        }
    }

    public void StartMatch(String name,Class<?> Invoker) throws AccessException {
        if(Invoker.getPackageName().startsWith("org.multicoder")){
            AtomicReference<MCPaintballMatch> Buffered = new AtomicReference<>();
            MATCHES.forEach(mcPaintballMatch -> {
                if (mcPaintballMatch.Name.equalsIgnoreCase(name)) {
                    Buffered.set(mcPaintballMatch);
                }
            });
            if (Buffered.get() != null) {
                MCPaintballMatch Match = Buffered.get();
                Match.Started = true;
                setDirty();
            }
        }
        else{
            throw new AccessException("Cannot Access This Class");
        }
    }

    public void StopMatch(String name,Class<?> Invoker) throws AccessException {
        if(Invoker.getPackageName().startsWith("org.multicoder")){
            AtomicReference<MCPaintballMatch> Buffered = new AtomicReference<>();
            MATCHES.forEach(mcPaintballMatch -> {
                if (mcPaintballMatch.Name.equalsIgnoreCase(name)) {
                    Buffered.set(mcPaintballMatch);
                }
            });
            if (Buffered.get() != null) {
                MCPaintballMatch Match = Buffered.get();
                Match.Started = false;
                setDirty();
            }
        }
        else{
            throw new AccessException("Cannot Access This Class");
        }

    }

    public void AddMatch(MCPaintballMatch match, ServerPlayer player, MinecraftServer server,Class<?> Invoker) throws AccessException {
        if(Invoker.getPackageName().startsWith("org.multicoder")){
            AtomicBoolean Exists = new AtomicBoolean(false);
            MATCHES.forEach(Existing ->
            {
                if (Objects.equals(Existing.Name, match.Name)) {
                    Exists.set(true);
                }
            });
            if (Exists.get()) {
                player.sendSystemMessage(Component.translatable("mcpaintball.command.response.match_exists", match.Name).withStyle(ChatFormatting.DARK_RED));
            } else {
                MATCHES.add(match);
                setDirty();
                server.getPlayerList().broadcastSystemMessage(Component.translatable("mcpaintball.command.response.game_create", match.Name), true);
            }
        }
        else{
            throw new AccessException("Cannot Access This Class");
        }
    }

    public boolean StartedByName(String name,Class<?> Invoker) throws AccessException {
        if(Invoker.getPackageName().startsWith("org.multicoder")){
            AtomicReference<MCPaintballMatch> Buffered = new AtomicReference<>();
            MATCHES.forEach(mcPaintballMatch -> {
                if (mcPaintballMatch.Name.equalsIgnoreCase(name)) {
                    Buffered.set(mcPaintballMatch);
                }
            });
            if (Buffered.get() != null) {
                MCPaintballMatch Match = Buffered.get();
                return Match.Started;
            }
            return false;
        }
        else{
            throw new AccessException("Cannot Access This Class");
        }
    }
}
