package com.android.dx;

import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.Rops;

/* loaded from: classes2.dex */
public enum UnaryOp {
    NOT { // from class: com.android.dx.UnaryOp.1
        @Override // com.android.dx.UnaryOp
        Rop rop(TypeId<?> typeId) {
            return Rops.opNot(typeId.ropType);
        }
    },
    NEGATE { // from class: com.android.dx.UnaryOp.2
        @Override // com.android.dx.UnaryOp
        Rop rop(TypeId<?> typeId) {
            return Rops.opNeg(typeId.ropType);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Rop rop(TypeId<?> typeId);
}
