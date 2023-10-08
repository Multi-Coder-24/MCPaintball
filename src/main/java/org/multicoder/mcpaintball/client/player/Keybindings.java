package org.multicoder.mcpaintball.client.player;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class Keybindings {
    public static final String MCPAINTBALL_GAMEPLAY = "key.category.mcpaintball.game";
    public static final String CONFIG_KEY = "key.mcpaintball.config";
    public static final String RELOAD_KEY = "key.mcpaintball.reload";

    public static final KeyMapping CONFIG = new KeyMapping(CONFIG_KEY, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_C, MCPAINTBALL_GAMEPLAY);
    public static final KeyMapping RELOAD = new KeyMapping(RELOAD_KEY, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_R, MCPAINTBALL_GAMEPLAY);
}
