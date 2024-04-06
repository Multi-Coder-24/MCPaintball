package org.multicoder.mcpaintball.network.packets;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;
import org.multicoder.mcpaintball.client.ClientPlayerTeamData;
import org.multicoder.mcpaintball.util.KitType;
import org.multicoder.mcpaintball.util.Teams;

import java.util.function.Supplier;

public class TeamUpdateS2CPacket {
    private final int Team;
    private final String Class;

    public TeamUpdateS2CPacket(int T, String Selected) {
        this.Team = T;
        this.Class = Selected;
    }

    public TeamUpdateS2CPacket(FriendlyByteBuf buffer) {
        Team = buffer.readInt();
        Class = buffer.readUtf();
    }

    public void toBytes(FriendlyByteBuf buffer) {
        buffer.writeInt(Team);
        buffer.writeUtf(Class);
    }

    public boolean handlePacket(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        Player player = Minecraft.getInstance().player;
        Level level = Minecraft.getInstance().level;
        ClientPlayerTeamData.SetTeam(Team);
        Teams T = Teams.getTeam(Team);
        KitType Kit = KitType.GetType(Class);
        ClientPlayerTeamData.SetClass(Class);
        String C1 = new TranslatableComponent("text.mcpaintball.team_update").getString();
        String C2 = new TranslatableComponent(T.GetTranslationKey()).getString();
        String C3 = new TranslatableComponent("text.mcpaintball.class_update").getString();
        String C4 = new TranslatableComponent(Kit.GetTranslationKey()).getString();
        String Comp = C1 + C2 + "\n" + C3 + C4;
        player.displayClientMessage(new TextComponent(Comp),false);
        return true;
    }
}
