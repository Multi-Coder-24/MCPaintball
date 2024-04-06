package org.multicoder.mcpaintball.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.multicoder.mcpaintball.MCPaintball;

public class tabinit
{
    public static ItemGroup paintball;



    public static void RegsiterCreateiveTabs()
    {
        paintball = FabricItemGroup.builder(new Identifier(MCPaintball.ModID,"paintball")).displayName(Text.translatable("itemGroup.mcpaintball.paintball")).icon(() -> new ItemStack(iteminit.RED_PISTOL)).build();
    }
}
