package org.multicoder.mcpaintball.common.data;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.level.saveddata.SavedData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MCPaintballWorldData extends SavedData
{
    public static final String SAVE_NAME = "mcpaintball";

    public static MCPaintballWorldData INSTANCE;

    public String VERSION;
    public List<MCPaintballMatch> MATCHES;

    public static MCPaintballWorldData create()
    {
        MCPaintballWorldData data = new MCPaintballWorldData();
        data.VERSION = "2.0.0";
        data.MATCHES = new ArrayList<>();
        return data;
    }
    public static MCPaintballWorldData load(CompoundTag nbt)
    {
        MCPaintballWorldData data = new MCPaintballWorldData();
        data.VERSION = nbt.getString("version");
        data.MATCHES = new ArrayList<>();
        ListTag Matches = nbt.getList("matches", Tag.TAG_COMPOUND);
        Matches.forEach(tag -> {CompoundTag NBT = (CompoundTag) tag;data.MATCHES.add(new MCPaintballMatch(NBT));});
        return data;
    }

    @Override
    public CompoundTag save(CompoundTag tag)
    {
        tag.putString("version",VERSION);
        ListTag Matches = new ListTag();
        MATCHES.forEach(match -> Matches.add(match.Serialize()));
        tag.put("matches",Matches);
        return tag;
    }

    public void IncrementByName(String name,String TK)
    {
        AtomicReference<MCPaintballMatch> Buffered = new AtomicReference<>();
        MATCHES.forEach(mcPaintballMatch -> {
            if(mcPaintballMatch.Name.equalsIgnoreCase(name)){
                Buffered.set(mcPaintballMatch);
            }
        });
        if(Buffered.get() != null)
        {
            MCPaintballMatch Match = Buffered.get();
            Match.IncrementByTranslationKey(TK);
            setDirty();
        }
    }

    public void StartMatch(String name){
        AtomicReference<MCPaintballMatch> Buffered = new AtomicReference<>();
        MATCHES.forEach(mcPaintballMatch -> {
            if(mcPaintballMatch.Name.equalsIgnoreCase(name)){
                Buffered.set(mcPaintballMatch);
            }
        });
        if(Buffered.get() != null)
        {
            MCPaintballMatch Match = Buffered.get();
            Match.Enabled = true;
            setDirty();
        }
    }
    public void StartGame(String name){
        AtomicReference<MCPaintballMatch> Buffered = new AtomicReference<>();
        MATCHES.forEach(mcPaintballMatch -> {
            if(mcPaintballMatch.Name.equalsIgnoreCase(name)){
                Buffered.set(mcPaintballMatch);
            }
        });
        if(Buffered.get() != null)
        {
            MCPaintballMatch Match = Buffered.get();
            Match.Started = true;
            Match.Enabled = true;
            setDirty();
        }
    }
    public void StopMatch(String name){
        AtomicReference<MCPaintballMatch> Buffered = new AtomicReference<>();
        MATCHES.forEach(mcPaintballMatch -> {
            if(mcPaintballMatch.Name.equalsIgnoreCase(name)){
                Buffered.set(mcPaintballMatch);
            }
        });
        if(Buffered.get() != null)
        {
            MCPaintballMatch Match = Buffered.get();
            Match.Enabled = false;
            setDirty();
        }
    }
    public void StopGame(String name){
        AtomicReference<MCPaintballMatch> Buffered = new AtomicReference<>();
        MATCHES.forEach(mcPaintballMatch -> {
            if(mcPaintballMatch.Name.equalsIgnoreCase(name)){
                Buffered.set(mcPaintballMatch);
            }
        });
        if(Buffered.get() != null)
        {
            MCPaintballMatch Match = Buffered.get();
            Match.Started = false;
            setDirty();
        }
    }
    public void AddMatch(MCPaintballMatch match){
        MATCHES.add(match);
        setDirty();
    }
    public boolean EnabledByName(String name)
    {
        AtomicReference<MCPaintballMatch> Buffered = new AtomicReference<>();
        MATCHES.forEach(mcPaintballMatch -> {
            if(mcPaintballMatch.Name.equalsIgnoreCase(name)){
                Buffered.set(mcPaintballMatch);
            }
        });
        if(Buffered.get() != null)
        {
            MCPaintballMatch Match = Buffered.get();
            return Match.Enabled;
        }
        return false;
    }
    public boolean StartedByName(String name)
    {
        AtomicReference<MCPaintballMatch> Buffered = new AtomicReference<>();
        MATCHES.forEach(mcPaintballMatch -> {
            if(mcPaintballMatch.Name.equalsIgnoreCase(name)){
                Buffered.set(mcPaintballMatch);
            }
        });
        if(Buffered.get() != null)
        {
            MCPaintballMatch Match = Buffered.get();
            return Match.Started;
        }
        return false;
    }
}
