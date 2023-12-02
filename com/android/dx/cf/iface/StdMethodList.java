package com.android.dx.cf.iface;

import com.android.dx.util.FixedSizeList;

/* loaded from: classes2.dex */
public final class StdMethodList extends FixedSizeList implements MethodList {
    public StdMethodList(int i4) {
        super(i4);
    }

    @Override // com.android.dx.cf.iface.MethodList
    public Method get(int i4) {
        return (Method) get0(i4);
    }

    public void set(int i4, Method method) {
        set0(i4, method);
    }
}
