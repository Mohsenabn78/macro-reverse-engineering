package com.android.dx.cf.iface;

import com.android.dx.util.FixedSizeList;

/* loaded from: classes2.dex */
public final class StdAttributeList extends FixedSizeList implements AttributeList {
    public StdAttributeList(int i4) {
        super(i4);
    }

    @Override // com.android.dx.cf.iface.AttributeList
    public int byteLength() {
        int size = size();
        int i4 = 2;
        for (int i5 = 0; i5 < size; i5++) {
            i4 += get(i5).byteLength();
        }
        return i4;
    }

    @Override // com.android.dx.cf.iface.AttributeList
    public Attribute findFirst(String str) {
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            Attribute attribute = get(i4);
            if (attribute.getName().equals(str)) {
                return attribute;
            }
        }
        return null;
    }

    @Override // com.android.dx.cf.iface.AttributeList
    public Attribute findNext(Attribute attribute) {
        Attribute attribute2;
        int size = size();
        int i4 = 0;
        while (i4 < size) {
            if (get(i4) == attribute) {
                String name = attribute.getName();
                do {
                    i4++;
                    if (i4 >= size) {
                        return null;
                    }
                    attribute2 = get(i4);
                } while (!attribute2.getName().equals(name));
                return attribute2;
            }
            i4++;
        }
        return null;
    }

    @Override // com.android.dx.cf.iface.AttributeList
    public Attribute get(int i4) {
        return (Attribute) get0(i4);
    }

    public void set(int i4, Attribute attribute) {
        set0(i4, attribute);
    }
}
