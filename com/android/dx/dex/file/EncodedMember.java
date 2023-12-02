package com.android.dx.dex.file;

import com.android.dx.rop.cst.CstString;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.ToHuman;
import java.io.PrintWriter;

/* loaded from: classes2.dex */
public abstract class EncodedMember implements ToHuman {
    private final int accessFlags;

    public EncodedMember(int i4) {
        this.accessFlags = i4;
    }

    public abstract void addContents(DexFile dexFile);

    public abstract void debugPrint(PrintWriter printWriter, boolean z3);

    public abstract int encode(DexFile dexFile, AnnotatedOutput annotatedOutput, int i4, int i5);

    public final int getAccessFlags() {
        return this.accessFlags;
    }

    public abstract CstString getName();
}
