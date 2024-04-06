package org.multicoder.mcpaintball.client.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.layouts.GridLayout;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraftforge.client.gui.widget.ForgeSlider;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.config.MCPaintballConfig;
import org.multicoder.mcpaintball.util.ErrorLogGenerator;

@SuppressWarnings("all")
public class ConfigScreen extends Screen
{
    //  Sliders
    ForgeSlider PISTOL_INACCURACY = new ForgeSlider(50, 30, 150, 20, Component.translatable("slider.mcpaintball.pistol_pre"), Component.empty(), 0.0d, 1.0d, MCPaintballConfig.PISTOL_INACCURACY.get(), 0.1d, 2, true);
    ForgeSlider RIFLE_INACCURACY = new ForgeSlider(50, 60, 150, 20, Component.translatable("slider.mcpaintball.rifle_pre"), Component.empty(), 0.0d, 3.0d, MCPaintballConfig.RIFLE_INACCURACY.get(), 0.1d, 2, true);
    ForgeSlider SHOTGUN_INACCURACY = new ForgeSlider(50, 90, 150, 20, Component.translatable("slider.mcpaintball.shotgun_pre"), Component.empty(), 0.0d, 1.0d, MCPaintballConfig.SHOTGUN_INACCURACY.get(), 0.1d, 2, true);
    ForgeSlider BAZOOKA_INACCURACY = new ForgeSlider(250, 30, 150, 20, Component.translatable("slider.mcpaintball.bazooka_pre"), Component.empty(), 0.0d, 4.0d, MCPaintballConfig.BAZOOKA_INACCURACY.get(), 0.1d, 2, true);
    ForgeSlider SNIPER_INACCURACY = new ForgeSlider(250, 60, 150, 20, Component.translatable("slider.mcpaintball.sniper_pre"), Component.empty(), 0.0d, 4.0d, MCPaintballConfig.SNIPER_INACCURACY.get(), 0.1d, 2, true);
    //  Checkboxes
    Checkbox OP_ONLY = new Checkbox(50, 150, 150, 20, Component.translatable("checkbox.mcpaintball.op_command"), MCPaintballConfig.WINNER_OP_ONLY.get(), true);
    Checkbox FRIENDLY_FIRE = new Checkbox(250, 150, 150, 20, Component.translatable("checkbox.mcpaintball.friendly_fire"), MCPaintballConfig.FRIENDLY_FIRE.get(), true);
    //  Button
    Button Save = Button.builder(Component.translatable("button.mcpaintball.save"), this::onPress).build();

    //  On Button Pressed
    private void onPress(Button button)
    {
        try{
            if (button == Save)
            {
                MCPaintballConfig.BAZOOKA_INACCURACY.set(BAZOOKA_INACCURACY.getValue());
                MCPaintballConfig.PISTOL_INACCURACY.set(PISTOL_INACCURACY.getValue());
                MCPaintballConfig.RIFLE_INACCURACY.set(RIFLE_INACCURACY.getValue());
                MCPaintballConfig.SHOTGUN_INACCURACY.set(SHOTGUN_INACCURACY.getValue());
                MCPaintballConfig.SNIPER_INACCURACY.set(SNIPER_INACCURACY.getValue());
                MCPaintballConfig.WINNER_OP_ONLY.set(OP_ONLY.selected());
                MCPaintballConfig.FRIENDLY_FIRE.set(FRIENDLY_FIRE.selected());
                MCPaintballConfig.BAZOOKA_INACCURACY.save();
                MCPaintballConfig.PISTOL_INACCURACY.save();
                MCPaintballConfig.RIFLE_INACCURACY.save();
                MCPaintballConfig.SNIPER_INACCURACY.save();
                MCPaintballConfig.SHOTGUN_INACCURACY.save();
                MCPaintballConfig.WINNER_OP_ONLY.save();
                MCPaintballConfig.FRIENDLY_FIRE.save();
                MCPaintballConfig.SPEC.save();
                this.onClose();
            }
        }
        catch(Exception e)
        {
            MCPaintball.LOG_ERROR.throwing(e);
            try
            {
                ErrorLogGenerator.Generate(e);
            }
            catch (Exception ex){}
            MCPaintball.LOG_ERROR.info("Error Handled");
        }
    }

    //  Constructor
    public ConfigScreen(Minecraft instance)
    {
        super(Component.translatable("screen.mcpaintball.config"));
        this.minecraft = instance;
    }


    //  Initialization
    @Override
    protected void init()
    {
        try
        {
            super.init();
            GridLayout GW = new GridLayout(4, 2);
            GW.setPosition(180, 50);
            GW.addChild(PISTOL_INACCURACY, 0, 0);
            GW.addChild(RIFLE_INACCURACY, 0, 1);
            GW.addChild(SHOTGUN_INACCURACY, 1, 0);
            GW.addChild(SNIPER_INACCURACY, 1, 1);
            GW.addChild(BAZOOKA_INACCURACY, 2, 0);
            GW.addChild(OP_ONLY, 3, 0);
            GW.addChild(FRIENDLY_FIRE, 3, 1);
            Save.setPosition(150, 210);
            this.addRenderableWidget(Save);
            this.addRenderableWidget(PISTOL_INACCURACY);
            this.addRenderableWidget(RIFLE_INACCURACY);
            this.addRenderableWidget(SHOTGUN_INACCURACY);
            this.addRenderableWidget(SNIPER_INACCURACY);
            this.addRenderableWidget(BAZOOKA_INACCURACY);
            this.addRenderableWidget(OP_ONLY);
            this.addRenderableWidget(FRIENDLY_FIRE);
        }
        catch(Exception e)
        {
            MCPaintball.LOG_ERROR.throwing(e);
            try
            {
                ErrorLogGenerator.Generate(e);
            }
            catch (Exception ex){}
            MCPaintball.LOG_ERROR.info("Error Handled");
        }
    }

    //  Render
    @Override
    public void render(@NotNull PoseStack p_96562_, int p_96563_, int p_96564_, float p_96565_)
    {
        try
        {
            this.renderDirtBackground(p_96562_);
            for (Renderable renderable : this.renderables) {
                renderable.render(p_96562_, p_96563_, p_96564_, p_96565_);
            }
            drawString(p_96562_,this.font, Component.translatable("screen.mcpaintball.config"), 110, 20, 16777215);
        }
        catch(Exception e)
        {
            MCPaintball.LOG_ERROR.throwing(e);
            try
            {
                ErrorLogGenerator.Generate(e);
            }
            catch (Exception ex){}
            MCPaintball.LOG_ERROR.info("Error Handled");
        }
    }
}
