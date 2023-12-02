package com.android.dx.cf.attrib;

import com.android.dx.rop.cst.Constant;

/* loaded from: classes2.dex */
public final class AttAnnotationDefault extends BaseAttribute {
    public static final String ATTRIBUTE_NAME = "AnnotationDefault";
    private final int byteLength;
    private final Constant value;

    public AttAnnotationDefault(Constant constant, int i4) {
        super(ATTRIBUTE_NAME);
        if (constant != null) {
            this.value = constant;
            this.byteLength = i4;
            return;
        }
        throw new NullPointerException("value == null");
    }

    @Override // com.android.dx.cf.iface.Attribute
    public int byteLength() {
        return this.byteLength + 6;
    }

    public Constant getValue() {
        return this.value;
    }
}
