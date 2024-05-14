package org.multicoder.mcpaintball.common.utility;

import java.rmi.AccessException;

public enum PaintballClass {
    STANDARD,
    HEAVY,
    MEDICAL,
    ENGINEER,
    SNIPER,
    GRENADIER;

    public String GetTKey(Class<?> Invoker) throws AccessException {
        if(Invoker.getPackageName().startsWith("org.multicoder")){
            return "type." + this.name().toLowerCase();
        }
        else{
            throw new AccessException("Cannot Access This Class");
        }
    }
}
