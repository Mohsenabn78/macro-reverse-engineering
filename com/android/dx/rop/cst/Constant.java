package com.android.dx.rop.cst;

import com.android.dx.util.ToHuman;

/* loaded from: classes2.dex */
public abstract class Constant implements ToHuman, Comparable<Constant> {
    protected abstract int compareTo0(Constant constant);

    public abstract boolean isCategory2();

    public abstract String typeName();

    @Override // java.lang.Comparable
    public final int compareTo(Constant constant) {
        Class<?> cls = getClass();
        Class<?> cls2 = constant.getClass();
        if (cls != cls2) {
            return cls.getName().compareTo(cls2.getName());
        }
        return compareTo0(constant);
    }
}
