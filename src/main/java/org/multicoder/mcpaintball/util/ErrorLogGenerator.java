package org.multicoder.mcpaintball.util;

import net.minecraft.Util;
import net.minecraftforge.fml.loading.FMLPaths;
import org.multicoder.mcpaintball.MCPaintball;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErrorLogGenerator
{
    public static void Generate(Exception e) throws Exception
    {
        String Location = FMLPaths.GAMEDIR.get() + "\\MCPaintball\\error-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_hh-mm-ss")) + ".elog";
        System.out.println(Location);
        File F = new File(Location);
        F.createNewFile();
        FileWriter FW = new FileWriter(F);
        FW.write("[15]; Error Log For MCPaintball, Please Send This To The Developer\n");
        FW.write("[60]; Error Occurred At: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_hh-mm-ss")) + "\n");
        FW.write("[62]; Error Message: " + e.getMessage() + "\n");
        FW.write("[15]; \t--Begin Stack Trace--\t\n");
        for(StackTraceElement element : e.getStackTrace())
        {
            FW.write("[22]; " + element.toString() + "\n");
        }
        FW.write("[15]; \t--End Stack Trace--\t\n");
        FW.write("[15]; \t--Begin System Info--\t\n");
        FW.write("[63]; Operating System: " + Util.getPlatform().name() + "\n");
        FW.write("[64]; Operating System Arch: " + System.getProperty("os.arch") + "\n");
        FW.write("[15]; Error Log Complete\n");
        FW.flush();
        FW.close();
    }
}
