package com.android.dx.cf.attrib;

import com.android.dx.rop.cst.CstString;

/* loaded from: classes2.dex */
public final class AttSignature extends BaseAttribute {
    public static final String ATTRIBUTE_NAME = "Signature";
    private final CstString signature;

    public AttSignature(CstString cstString) {
        super(ATTRIBUTE_NAME);
        if (cstString != null) {
            this.signature = cstString;
            return;
        }
        throw new NullPointerException("signature == null");
    }

    @Override // com.android.dx.cf.iface.Attribute
    public int byteLength() {
        return 8;
    }

    public CstString getSignature() {
        return this.signature;
    }
}
