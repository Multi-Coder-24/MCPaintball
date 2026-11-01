package org.multicoder.mcpaintball.util;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.multicoder.mcpaintball.core.MCPaintballEntities;
import org.multicoder.mcpaintball.core.MCPaintballItems;
import org.multicoder.mcpaintball.entity.PaintGrenadeEntity;
import org.multicoder.mcpaintball.entity.PaintballEntity;

public enum PaintballTeam implements StringRepresentable {
    None("text.mcpaintball.team_none"),
    Red("text.mcpaintball.team_red"),
    Green("text.mcpaintball.team_green"),
    Blue("text.mcpaintball.team_blue"),
    Cyan("text.mcpaintball.team_cyan"),
    Magenta("text.mcpaintball.team_magenta"),
    Yellow("text.mcpaintball.team_yellow"),
    Pink("text.mcpaintball.team_pink"),
    Lime("text.mcpaintball.team_lime"),
    LightBlue("text.mcpaintball.team_light_blue"),
    LightGray("text.mcpaintball.team_light_gray"),
    Gray("text.mcpaintball.team_gray"),
    White("text.mcpaintball.team_white"),
    Black("text.mcpaintball.team_black"),
    Brown("text.mcpaintball.team_brown"),
    Purple("text.mcpaintball.team_purple"),
    Orange("text.mcpaintball.team_orange"),
    Admin("text.mcpaintball.team_admin");
    PaintballTeam(String translation){
        this.translation = translation;
    }
    public final String translation;

    @Override
    public @NonNull String getSerializedName() {
        return this.translation;
    }

    public static StringRepresentable.EnumCodec<PaintballTeam> CODEC = StringRepresentable.fromEnum(PaintballTeam::values);
    public static StreamCodec<ByteBuf,PaintballTeam> STREAM_CODEC = ByteBufCodecs.fromCodec(CODEC);

    public @Nullable PaintballEntity getPaintball(ServerLevel level, ItemStack weapon,ServerPlayer player) {
        switch (this){
            case Red -> {
                return new PaintballEntity(MCPaintballEntities.RED_PAINTBALL,player,level,weapon);
            }
            case Green -> {
                return new PaintballEntity(MCPaintballEntities.GREEN_PAINTBALL,player,level,weapon);
            }
            case Blue -> {
                return new PaintballEntity(MCPaintballEntities.BLUE_PAINTBALL,player,level,weapon);
            }
            case Cyan -> {
                return new PaintballEntity(MCPaintballEntities.CYAN_PAINTBALL,player,level,weapon);
            }
            case Magenta -> {
                return new PaintballEntity(MCPaintballEntities.MAGENTA_PAINTBALL,player,level,weapon);
            }
            case Yellow -> {
                return new PaintballEntity(MCPaintballEntities.YELLOW_PAINTBALL,player,level,weapon);
            }
            case Pink -> {
                return new PaintballEntity(MCPaintballEntities.PINK_PAINTBALL,player,level,weapon);
            }
            case Lime -> {
                return new PaintballEntity(MCPaintballEntities.LIME_PAINTBALL,player,level,weapon);
            }
            case LightBlue -> {
                return new PaintballEntity(MCPaintballEntities.LIGHT_BLUE_PAINTBALL,player,level,weapon);
            }
            case LightGray -> {
                return new PaintballEntity(MCPaintballEntities.LIGHT_GRAY_PAINTBALL,player,level,weapon);
            }
            case Gray -> {
                return new PaintballEntity(MCPaintballEntities.GRAY_PAINTBALL,player,level,weapon);
            }
            case White -> {
                return new PaintballEntity(MCPaintballEntities.WHITE_PAINTBALL,player,level,weapon);
            }
            case Black -> {
                return new PaintballEntity(MCPaintballEntities.BLACK_PAINTBALL,player,level,weapon);
            }
            case Brown -> {
                return new PaintballEntity(MCPaintballEntities.BROWN_PAINTBALL,player,level,weapon);
            }
            case Orange -> {
                return new PaintballEntity(MCPaintballEntities.ORANGE_PAINTBALL,player,level,weapon);
            }
            case Purple -> {
                return new PaintballEntity(MCPaintballEntities.PURPLE_PAINTBALL,player,level,weapon);
            }
        }
        //  We Should Never Get Here
        return null;
    }

    public @Nullable PaintGrenadeEntity getPaintGrenade(ServerLevel level,ServerPlayer player,ItemStack thrownStack) {
        switch (this){
            case Red -> {
                if(thrownStack.getItem() == MCPaintballItems.RED_PAINT_GRENADE){
                    return new PaintGrenadeEntity(MCPaintballEntities.RED_PAINT_GRENADE,player,level,thrownStack);
                }
            }
            case Green -> {
                if(thrownStack.getItem() == MCPaintballItems.GREEN_PAINT_GRENADE){
                    return new PaintGrenadeEntity(MCPaintballEntities.GREEN_PAINT_GRENADE,player,level,thrownStack);
                }
            }
            case Blue -> {
                if(thrownStack.getItem() == MCPaintballItems.BLUE_PAINT_GRENADE){
                    return new PaintGrenadeEntity(MCPaintballEntities.BLUE_PAINT_GRENADE,player,level,thrownStack);
                }
            }
            case Cyan -> {
                if(thrownStack.getItem() == MCPaintballItems.CYAN_PAINT_GRENADE){
                    return new PaintGrenadeEntity(MCPaintballEntities.CYAN_PAINT_GRENADE,player,level,thrownStack);
                }
            }
            case Magenta -> {
                if(thrownStack.getItem() == MCPaintballItems.MAGENTA_PAINT_GRENADE){
                    return new PaintGrenadeEntity(MCPaintballEntities.MAGENTA_PAINT_GRENADE,player,level,thrownStack);
                }
            }
            case Yellow -> {
                if(thrownStack.getItem() == MCPaintballItems.YELLOW_PAINT_GRENADE){
                    return new PaintGrenadeEntity(MCPaintballEntities.YELLOW_PAINT_GRENADE,player,level,thrownStack);
                }
            }
            case Pink -> {
                if(thrownStack.getItem() == MCPaintballItems.PINK_PAINT_GRENADE){
                    return new PaintGrenadeEntity(MCPaintballEntities.PINK_PAINT_GRENADE,player,level,thrownStack);
                }
            }
            case Lime -> {
                if(thrownStack.getItem() == MCPaintballItems.LIME_PAINT_GRENADE){
                    return new PaintGrenadeEntity(MCPaintballEntities.LIME_PAINT_GRENADE,player,level,thrownStack);
                }
            }
            case LightBlue -> {
                if(thrownStack.getItem() == MCPaintballItems.LIGHT_BLUE_PAINT_GRENADE){
                    return new PaintGrenadeEntity(MCPaintballEntities.LIGHT_BLUE_PAINT_GRENADE,player,level,thrownStack);
                }
            }
            case LightGray -> {
                if(thrownStack.getItem() == MCPaintballItems.LIGHT_GRAY_PAINT_GRENADE){
                    return new PaintGrenadeEntity(MCPaintballEntities.LIGHT_GRAY_PAINT_GRENADE,player,level,thrownStack);
                }
            }
            case Gray -> {
                if(thrownStack.getItem() == MCPaintballItems.GRAY_PAINT_GRENADE){
                    return new PaintGrenadeEntity(MCPaintballEntities.GRAY_PAINT_GRENADE,player,level,thrownStack);
                }
            }
            case White -> {
                if(thrownStack.getItem() == MCPaintballItems.WHITE_PAINT_GRENADE){
                    return new PaintGrenadeEntity(MCPaintballEntities.WHITE_PAINT_GRENADE,player,level,thrownStack);
                }
            }
            case Black -> {
                if(thrownStack.getItem() == MCPaintballItems.BLACK_PAINT_GRENADE){
                    return new PaintGrenadeEntity(MCPaintballEntities.BLACK_PAINT_GRENADE,player,level,thrownStack);
                }
            }
            case Brown -> {
                if(thrownStack.getItem() == MCPaintballItems.BROWN_PAINT_GRENADE){
                    return new PaintGrenadeEntity(MCPaintballEntities.BROWN_PAINT_GRENADE,player,level,thrownStack);
                }
            }
            case Orange -> {
                if(thrownStack.getItem() == MCPaintballItems.ORANGE_PAINT_GRENADE){
                    return new PaintGrenadeEntity(MCPaintballEntities.ORANGE_PAINT_GRENADE,player,level,thrownStack);
                }
            }
            case Purple -> {
                if(thrownStack.getItem() == MCPaintballItems.PURPLE_PAINT_GRENADE){
                    return new PaintGrenadeEntity(MCPaintballEntities.PURPLE_PAINT_GRENADE,player,level,thrownStack);
                }
            }
        }
        return null;
    }
}
