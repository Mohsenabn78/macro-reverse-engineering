package com.android.dx.rop.cst;

import com.android.dx.rop.type.Type;
import com.android.dx.util.Hex;

/* loaded from: classes2.dex */
public final class CstFloat extends CstLiteral32 {
    public static final CstFloat VALUE_0 = make(Float.floatToIntBits(0.0f));
    public static final CstFloat VALUE_1 = make(Float.floatToIntBits(1.0f));
    public static final CstFloat VALUE_2 = make(Float.floatToIntBits(2.0f));

    private CstFloat(int i4) {
        super(i4);
    }

    public static CstFloat make(int i4) {
        return new CstFloat(i4);
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public Type getType() {
        return Type.FLOAT;
    }

    public float getValue() {
        return Float.intBitsToFloat(getIntBits());
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        return Float.toString(Float.intBitsToFloat(getIntBits()));
    }

    public String toString() {
        int intBits = getIntBits();
        return "float{0x" + Hex.u4(intBits) + " / " + Float.intBitsToFloat(intBits) + '}';
    }

    @Override // com.android.dx.rop.cst.Constant
    public String typeName() {
        return "float";
    }
}
