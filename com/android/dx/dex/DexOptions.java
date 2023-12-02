package com.android.dx.dex;

import com.android.dex.DexFormat;

/* loaded from: classes2.dex */
public class DexOptions {
    public static final boolean ALIGN_64BIT_REGS_SUPPORT = true;
    public boolean ALIGN_64BIT_REGS_IN_OUTPUT_FINISHER = true;
    public int targetApiLevel = 13;
    public boolean forceJumbo = false;

    public String getMagic() {
        return DexFormat.apiToMagic(this.targetApiLevel);
    }
}
