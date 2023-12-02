package com.android.dx.cf.attrib;

import com.android.dx.rop.cst.CstString;

/* loaded from: classes2.dex */
public final class AttSourceFile extends BaseAttribute {
    public static final String ATTRIBUTE_NAME = "SourceFile";
    private final CstString sourceFile;

    public AttSourceFile(CstString cstString) {
        super(ATTRIBUTE_NAME);
        if (cstString != null) {
            this.sourceFile = cstString;
            return;
        }
        throw new NullPointerException("sourceFile == null");
    }

    @Override // com.android.dx.cf.iface.Attribute
    public int byteLength() {
        return 8;
    }

    public CstString getSourceFile() {
        return this.sourceFile;
    }
}
