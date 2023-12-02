package com.android.dx.rop.cst;

import com.android.dx.rop.type.TypeBearer;

/* loaded from: classes2.dex */
public abstract class TypedConstant extends Constant implements TypeBearer {
    @Override // com.android.dx.rop.type.TypeBearer
    public final int getBasicFrameType() {
        return getType().getBasicFrameType();
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public final int getBasicType() {
        return getType().getBasicType();
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public final boolean isConstant() {
        return true;
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public final TypeBearer getFrameType() {
        return this;
    }
}
