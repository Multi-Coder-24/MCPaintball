package org.multicoder.mcpaintball.event;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.permissions.Permissions;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import org.multicoder.mcpaintball.command.MCPaintballCommands;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballDataComponents;
import org.multicoder.mcpaintball.core.MCPaintballItems;
import org.multicoder.mcpaintball.core.MCPaintballKeybinding;
import org.multicoder.mcpaintball.data.MCPaintballSaveData;
import org.multicoder.mcpaintball.network.CycleGLTypeC2SPacket;
import org.multicoder.mcpaintball.network.PointSyncS2CPacket;
import java.util.Objects;

public class MCPaintballGameEvents {
    public static MCPaintballSaveData INSTANCE;
    public static int ticker = 0;
    public static void serverStart(MinecraftServer server) {
        INSTANCE = server.overworld().getDataStorage().computeIfAbsent(MCPaintballSaveData.TYPE);
        Objects.requireNonNull(server.overworld().getDataStorage().get(MCPaintballSaveData.TYPE)).setDirty();
        server.addTickable((() -> {
            if(ticker == 20){
                server.getPlayerList().getPlayers().forEach(player -> ServerPlayNetworking.send(player,new PointSyncS2CPacket(MCPaintballGameEvents.INSTANCE.redPoints,MCPaintballGameEvents.INSTANCE.greenPoints,MCPaintballGameEvents.INSTANCE.bluePoints,MCPaintballGameEvents.INSTANCE.yellowPoints,MCPaintballGameEvents.INSTANCE.pinkPoints,MCPaintballGameEvents.INSTANCE.orangePoints, MCPaintballGameEvents.INSTANCE.matchStarted,MCPaintballGameEvents.INSTANCE.roundStarted)));
                ticker = 0;
            }else{
                ticker++;
            }
        }));
    }

    public static void join(ServerPlayer player) {
        player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER);
    }

    public static void commandRegister(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext ignored, Commands.CommandSelection ignored2) {
        dispatcher.register(Commands.literal(Component.translatable("command.mcpaintball.prefix").getString()).then(Commands.literal(Component.translatable("command.mcpaintball.team_prefix").getString()).then(Commands.argument("team",StringArgumentType.word()).executes(MCPaintballCommands::setTeam)))).createBuilder().build();
        dispatcher.register(Commands.literal(Component.translatable("command.mcpaintball.prefix").getString()).then(Commands.literal(Component.translatable("command.mcpaintball.type_prefix").getString()).then(Commands.argument("type",StringArgumentType.word()).executes(MCPaintballCommands::setType)))).createBuilder().build();
        dispatcher.register(Commands.literal(Component.translatable("command.mcpaintball.prefix").getString()).then(Commands.literal(Component.translatable("command.mcpaintball.game_prefix").getString()).then(Commands.literal(Component.translatable("command.mcpaintball.start").getString()).requires(commandSourceStack -> commandSourceStack.permissions().hasPermission(Permissions.COMMANDS_ADMIN)).executes(MCPaintballCommands::startGame)).then(Commands.literal(Component.translatable("command.mcpaintball.stop").getString()).requires(commandSourceStack -> commandSourceStack.permissions().hasPermission(Permissions.COMMANDS_ADMIN)).executes(MCPaintballCommands::stopGame)))).createBuilder().build();
        dispatcher.register(Commands.literal(Component.translatable("command.mcpaintball.prefix").getString()).then(Commands.literal(Component.translatable("command.mcpaintball.round_prefix").getString()).then(Commands.literal(Component.translatable("command.mcpaintball.start").getString()).requires(commandSourceStack -> commandSourceStack.permissions().hasPermission(Permissions.COMMANDS_ADMIN)).executes(MCPaintballCommands::startRound)).then(Commands.literal(Component.translatable("command.mcpaintball.end").getString()).requires(commandSourceStack -> commandSourceStack.permissions().hasPermission(Permissions.COMMANDS_ADMIN)).executes(MCPaintballCommands::stopRound)).then(Commands.literal(Component.translatable("command.mcpaintball.winner").getString()).requires(commandSourceStack -> commandSourceStack.permissions().hasPermission(Permissions.COMMANDS_MODERATOR)).executes(MCPaintballCommands::roundWinner)))).createBuilder().build();
        dispatcher.register(Commands.literal(Component.translatable("command.mcpaintball.prefix").getString()).then(Commands.literal(Component.translatable("command.mcpaintball.kit").getString()).executes(MCPaintballCommands::giveKit))).createBuilder().build();
    }

    public static void clientEndTick(Minecraft minecraft) {
        while(MCPaintballKeybinding.CYCLE_GRENADE_LAUNCHER_TYPE.consumeClick()){
            Player player =  minecraft.player;
            if(Objects.requireNonNull(player).getItemInHand(InteractionHand.MAIN_HAND).getItem() == MCPaintballItems.GRENADE_LAUNCHER){
                int i = Objects.requireNonNull(player.getItemInHand(InteractionHand.MAIN_HAND).get(MCPaintballDataComponents.SETTING)).setting();
                ClientPlayNetworking.send(new CycleGLTypeC2SPacket(i));
            }
        }
    }
}
