package org.multicoder.mcpaintball.core;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;
import org.lwjgl.glfw.GLFW;
import org.multicoder.mcpaintball.MCPaintball;

public class MCPaintballKeybinding {
    public static final KeyMapping.Category MCPAINTBALL_CATEGORY = KeyMapping.Category.register(Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"weapons"));
    public static final KeyMapping CYCLE_GRENADE_LAUNCHER_TYPE = new KeyMapping("key.mcpaintball.cycle_gl", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_C,MCPAINTBALL_CATEGORY);
}
