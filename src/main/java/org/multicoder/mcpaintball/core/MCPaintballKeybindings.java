package org.multicoder.mcpaintball.core;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;
import org.lwjgl.glfw.GLFW;
import org.multicoder.mcpaintball.MCPaintball;
@SuppressWarnings("unused")
public class MCPaintballKeybindings {
    public static final KeyMapping.Category CATEGORY = new KeyMapping.Category(Identifier.fromNamespaceAndPath(MCPaintball.MODID,"weapons"));
    public static final KeyMapping.Category CATEGORY_CONFIG = new KeyMapping.Category(Identifier.fromNamespaceAndPath(MCPaintball.MODID,"setup"));
    public static final KeyMapping CYCLE_GRENADE_LAUNCHER_TYPE = new KeyMapping("key.mcpaintball.cycle_gl", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_C,CATEGORY);
    public static final KeyMapping SELECT_TEAM = new KeyMapping("key.mcpaintball.team_select_open", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_Z,CATEGORY_CONFIG);
    public static final KeyMapping SELECT_ROLE = new KeyMapping("key.mcpaintball.role_select_open", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_X,CATEGORY_CONFIG);
}
