package com.android.dx.cf.attrib;

/* loaded from: classes2.dex */
public final class AttSynthetic extends BaseAttribute {
    public static final String ATTRIBUTE_NAME = "Synthetic";

    public AttSynthetic() {
        super(ATTRIBUTE_NAME);
    }

    @Override // com.android.dx.cf.iface.Attribute
    public int byteLength() {
        return 6;
    }
}
