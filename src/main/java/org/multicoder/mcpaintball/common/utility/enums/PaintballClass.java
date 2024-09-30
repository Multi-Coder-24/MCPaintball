package org.multicoder.mcpaintball.common.utility.enums;

public enum PaintballClass
{
    STANDARD,
    HEAVY,
    SHOTGUNNER,
    SOLO;

    public static String getFromOrdinal(int Ordinal)
    {
        PaintballClass Class = PaintballClass.values()[Ordinal];
        switch (Class){
            case STANDARD -> {
                return "Standard";
            }
            case HEAVY -> {
                return "Heavy";
            }
            case SHOTGUNNER -> {
                return "Shotgunner";
            }
            case SOLO -> {
                return "Solo";
            }
        }
        return "Error";
    }
}
