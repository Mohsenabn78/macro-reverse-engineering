package com.android.dx.rop.cst;

/* loaded from: classes2.dex */
public interface ConstantPool {
    Constant get(int i4);

    Constant get0Ok(int i4);

    Constant[] getEntries();

    Constant getOrNull(int i4);

    int size();
}
