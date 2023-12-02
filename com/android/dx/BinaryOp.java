package com.android.dx;

import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.Rops;

/* loaded from: classes2.dex */
public enum BinaryOp {
    ADD { // from class: com.android.dx.BinaryOp.1
        @Override // com.android.dx.BinaryOp
        Rop rop(com.android.dx.rop.type.TypeList typeList) {
            return Rops.opAdd(typeList);
        }
    },
    SUBTRACT { // from class: com.android.dx.BinaryOp.2
        @Override // com.android.dx.BinaryOp
        Rop rop(com.android.dx.rop.type.TypeList typeList) {
            return Rops.opSub(typeList);
        }
    },
    MULTIPLY { // from class: com.android.dx.BinaryOp.3
        @Override // com.android.dx.BinaryOp
        Rop rop(com.android.dx.rop.type.TypeList typeList) {
            return Rops.opMul(typeList);
        }
    },
    DIVIDE { // from class: com.android.dx.BinaryOp.4
        @Override // com.android.dx.BinaryOp
        Rop rop(com.android.dx.rop.type.TypeList typeList) {
            return Rops.opDiv(typeList);
        }
    },
    REMAINDER { // from class: com.android.dx.BinaryOp.5
        @Override // com.android.dx.BinaryOp
        Rop rop(com.android.dx.rop.type.TypeList typeList) {
            return Rops.opRem(typeList);
        }
    },
    AND { // from class: com.android.dx.BinaryOp.6
        @Override // com.android.dx.BinaryOp
        Rop rop(com.android.dx.rop.type.TypeList typeList) {
            return Rops.opAnd(typeList);
        }
    },
    OR { // from class: com.android.dx.BinaryOp.7
        @Override // com.android.dx.BinaryOp
        Rop rop(com.android.dx.rop.type.TypeList typeList) {
            return Rops.opOr(typeList);
        }
    },
    XOR { // from class: com.android.dx.BinaryOp.8
        @Override // com.android.dx.BinaryOp
        Rop rop(com.android.dx.rop.type.TypeList typeList) {
            return Rops.opXor(typeList);
        }
    },
    SHIFT_LEFT { // from class: com.android.dx.BinaryOp.9
        @Override // com.android.dx.BinaryOp
        Rop rop(com.android.dx.rop.type.TypeList typeList) {
            return Rops.opShl(typeList);
        }
    },
    SHIFT_RIGHT { // from class: com.android.dx.BinaryOp.10
        @Override // com.android.dx.BinaryOp
        Rop rop(com.android.dx.rop.type.TypeList typeList) {
            return Rops.opShr(typeList);
        }
    },
    UNSIGNED_SHIFT_RIGHT { // from class: com.android.dx.BinaryOp.11
        @Override // com.android.dx.BinaryOp
        Rop rop(com.android.dx.rop.type.TypeList typeList) {
            return Rops.opUshr(typeList);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Rop rop(com.android.dx.rop.type.TypeList typeList);
}
