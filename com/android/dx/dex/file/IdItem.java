package com.android.dx.dex.file;

import com.android.dx.rop.cst.CstType;

/* loaded from: classes2.dex */
public abstract class IdItem extends IndexedItem {
    private final CstType type;

    public IdItem(CstType cstType) {
        if (cstType != null) {
            this.type = cstType;
            return;
        }
        throw new NullPointerException("type == null");
    }

    @Override // com.android.dx.dex.file.Item
    public void addContents(DexFile dexFile) {
        dexFile.getTypeIds().intern(this.type);
    }

    public final CstType getDefiningClass() {
        return this.type;
    }
}
