package com.android.dx.cf.iface;

import com.android.dx.util.FixedSizeList;

/* loaded from: classes2.dex */
public final class StdFieldList extends FixedSizeList implements FieldList {
    public StdFieldList(int i4) {
        super(i4);
    }

    @Override // com.android.dx.cf.iface.FieldList
    public Field get(int i4) {
        return (Field) get0(i4);
    }

    public void set(int i4, Field field) {
        set0(i4, field);
    }
}
