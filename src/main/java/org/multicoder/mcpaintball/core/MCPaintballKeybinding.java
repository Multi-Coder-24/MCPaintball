package org.multicoder.mcpaintball.core;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;
import org.lwjgl.glfw.GLFW;
import org.multicoder.mcpaintball.MCPaintball;

public class MCPaintballKeybinding {
    public static final KeyMapping.Category MCPAINTBALL_CATEGORY = KeyMapping.Category.register(Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"weapons"));
    public static final KeyMapping.Category MCPAINTBALL_SETUP_CATEGORY = KeyMapping.Category.register(Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"setup"));
    public static final KeyMapping CYCLE_GRENADE_LAUNCHER_TYPE = KeyMappingHelper.registerKeyMapping(new KeyMapping("key.mcpaintball.cycle_gl",InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_C, MCPAINTBALL_CATEGORY));
    public static final KeyMapping OPEN_TEAM_SELECT = KeyMappingHelper.registerKeyMapping(new KeyMapping("key.mcpaintball.team_select_open", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_Z,MCPAINTBALL_SETUP_CATEGORY));
    public static final KeyMapping OPEN_ROLE_SELECT = KeyMappingHelper.registerKeyMapping(new KeyMapping("key.mcpaintball.role_select_open", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_X,MCPAINTBALL_SETUP_CATEGORY));
    public static final KeyMapping OPEN_ADMIN_SCREEN = KeyMappingHelper.registerKeyMapping(new KeyMapping("key.mcpaintball.open_admin_screen", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_M,MCPAINTBALL_SETUP_CATEGORY));

    public static void initialize() {
        MCPaintball.LOGGER.info("Initializing Keybindings");
    }
}
