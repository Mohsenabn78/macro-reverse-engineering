package com.android.dx.rop.cst;

import com.google.firebase.analytics.FirebaseAnalytics;

/* loaded from: classes2.dex */
public final class CstMethodRef extends CstBaseMethodRef {
    public CstMethodRef(CstType cstType, CstNat cstNat) {
        super(cstType, cstNat);
    }

    @Override // com.android.dx.rop.cst.Constant
    public String typeName() {
        return FirebaseAnalytics.Param.METHOD;
    }
}
