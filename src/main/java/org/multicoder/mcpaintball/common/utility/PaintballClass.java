package org.multicoder.mcpaintball.common.utility;

public enum PaintballClass
{
    STANDARD,
    HEAVY,
    MEDICAL,
    ENGINEER,
    SNIPER,
    GRENADIER;

    public String getTKey(){
        return "type." + this.name().toLowerCase();
    }
}
