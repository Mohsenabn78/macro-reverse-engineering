package com.android.dx.rop.cst;

/* loaded from: classes2.dex */
public abstract class CstLiteral64 extends CstLiteralBits {
    private final long bits;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CstLiteral64(long j4) {
        this.bits = j4;
    }

    @Override // com.android.dx.rop.cst.Constant
    protected int compareTo0(Constant constant) {
        long j4 = ((CstLiteral64) constant).bits;
        long j5 = this.bits;
        if (j5 < j4) {
            return -1;
        }
        if (j5 > j4) {
            return 1;
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass() && this.bits == ((CstLiteral64) obj).bits) {
            return true;
        }
        return false;
    }

    @Override // com.android.dx.rop.cst.CstLiteralBits
    public final boolean fitsInInt() {
        long j4 = this.bits;
        if (((int) j4) == j4) {
            return true;
        }
        return false;
    }

    @Override // com.android.dx.rop.cst.CstLiteralBits
    public final int getIntBits() {
        return (int) this.bits;
    }

    @Override // com.android.dx.rop.cst.CstLiteralBits
    public final long getLongBits() {
        return this.bits;
    }

    public final int hashCode() {
        long j4 = this.bits;
        return ((int) j4) ^ ((int) (j4 >> 32));
    }

    @Override // com.android.dx.rop.cst.Constant
    public final boolean isCategory2() {
        return true;
    }
}
