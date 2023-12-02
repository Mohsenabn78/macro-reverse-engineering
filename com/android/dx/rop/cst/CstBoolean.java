package com.android.dx.rop.cst;

import com.android.dx.rop.type.Type;

/* loaded from: classes2.dex */
public final class CstBoolean extends CstLiteral32 {
    public static final CstBoolean VALUE_FALSE = new CstBoolean(false);
    public static final CstBoolean VALUE_TRUE = new CstBoolean(true);

    private CstBoolean(boolean z3) {
        super(z3 ? 1 : 0);
    }

    public static CstBoolean make(boolean z3) {
        return z3 ? VALUE_TRUE : VALUE_FALSE;
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public Type getType() {
        return Type.BOOLEAN;
    }

    public boolean getValue() {
        if (getIntBits() == 0) {
            return false;
        }
        return true;
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        if (getValue()) {
            return "true";
        }
        return "false";
    }

    public String toString() {
        if (getValue()) {
            return "boolean{true}";
        }
        return "boolean{false}";
    }

    @Override // com.android.dx.rop.cst.Constant
    public String typeName() {
        return "boolean";
    }

    public static CstBoolean make(int i4) {
        if (i4 == 0) {
            return VALUE_FALSE;
        }
        if (i4 == 1) {
            return VALUE_TRUE;
        }
        throw new IllegalArgumentException("bogus value: " + i4);
    }
}
