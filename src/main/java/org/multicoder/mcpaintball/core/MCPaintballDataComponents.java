package org.multicoder.mcpaintball.core;

import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.data.FlagItemSettings;
import org.multicoder.mcpaintball.data.MCPaintballGrenadeLauncherSetting;

public class MCPaintballDataComponents {

    public static final DataComponentType<MCPaintballGrenadeLauncherSetting> SETTING = Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE,Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"grenade_launcher_setting"),
            new DataComponentType.Builder<MCPaintballGrenadeLauncherSetting>().persistent(MCPaintballGrenadeLauncherSetting.CODEC).ignoreSwapAnimation().build());

    public static final DataComponentType<FlagItemSettings> FLAGITEMSETTINGS = Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE,Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"flag_item_settings"),
            new DataComponentType.Builder<FlagItemSettings>().persistent(FlagItemSettings.CODEC).ignoreSwapAnimation().build());

    public static void Initialize() {
        MCPaintball.LOGGER.info("Initializing Data Components");
    }
}
