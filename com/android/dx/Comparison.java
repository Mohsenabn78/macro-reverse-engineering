package com.android.dx;

import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.Rops;

/* loaded from: classes2.dex */
public enum Comparison {
    LT { // from class: com.android.dx.Comparison.1
        @Override // com.android.dx.Comparison
        Rop rop(com.android.dx.rop.type.TypeList typeList) {
            return Rops.opIfLt(typeList);
        }
    },
    LE { // from class: com.android.dx.Comparison.2
        @Override // com.android.dx.Comparison
        Rop rop(com.android.dx.rop.type.TypeList typeList) {
            return Rops.opIfLe(typeList);
        }
    },
    EQ { // from class: com.android.dx.Comparison.3
        @Override // com.android.dx.Comparison
        Rop rop(com.android.dx.rop.type.TypeList typeList) {
            return Rops.opIfEq(typeList);
        }
    },
    GE { // from class: com.android.dx.Comparison.4
        @Override // com.android.dx.Comparison
        Rop rop(com.android.dx.rop.type.TypeList typeList) {
            return Rops.opIfGe(typeList);
        }
    },
    GT { // from class: com.android.dx.Comparison.5
        @Override // com.android.dx.Comparison
        Rop rop(com.android.dx.rop.type.TypeList typeList) {
            return Rops.opIfGt(typeList);
        }
    },
    NE { // from class: com.android.dx.Comparison.6
        @Override // com.android.dx.Comparison
        Rop rop(com.android.dx.rop.type.TypeList typeList) {
            return Rops.opIfNe(typeList);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Rop rop(com.android.dx.rop.type.TypeList typeList);
}
