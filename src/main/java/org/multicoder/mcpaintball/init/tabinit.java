package org.multicoder.mcpaintball.init;



import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import org.multicoder.mcpaintball.MCPaintball;

@Mod.EventBusSubscriber(modid = MCPaintball.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class tabinit
{
    public static final CreativeModeTab Weapons = new CreativeModeTab("mcpaintball.paintball.weapons"){

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(iteminit.PAINTBALL_PISTOL.get());
        }
    };
    public static final CreativeModeTab Utility = new CreativeModeTab("mcpaintball.paintball.utilities"){

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(iteminit.RED_REMOTE.get());
        }
    };
    public static final CreativeModeTab Kits = new CreativeModeTab("mcpaintball.paintball.kits"){

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(iteminit.PAINTBALL_STANDARD_KIT.get());
        }
    };
    public static final CreativeModeTab Armor = new CreativeModeTab("mcpaintball.paintball.armor"){

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(iteminit.RED_BOOTS.get());
        }
    };
}
