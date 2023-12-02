package com.android.dx.rop.cst;

/* loaded from: classes2.dex */
public abstract class CstLiteralBits extends TypedConstant {
    public boolean fitsIn16Bits() {
        if (!fitsInInt()) {
            return false;
        }
        int intBits = getIntBits();
        if (((short) intBits) != intBits) {
            return false;
        }
        return true;
    }

    public boolean fitsIn8Bits() {
        if (!fitsInInt()) {
            return false;
        }
        int intBits = getIntBits();
        if (((byte) intBits) != intBits) {
            return false;
        }
        return true;
    }

    public abstract boolean fitsInInt();

    public abstract int getIntBits();

    public abstract long getLongBits();
}
