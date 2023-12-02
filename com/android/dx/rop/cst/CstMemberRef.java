package com.android.dx.rop.cst;

/* loaded from: classes2.dex */
public abstract class CstMemberRef extends TypedConstant {
    private final CstType definingClass;
    private final CstNat nat;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CstMemberRef(CstType cstType, CstNat cstNat) {
        if (cstType != null) {
            if (cstNat != null) {
                this.definingClass = cstType;
                this.nat = cstNat;
                return;
            }
            throw new NullPointerException("nat == null");
        }
        throw new NullPointerException("definingClass == null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.dx.rop.cst.Constant
    public int compareTo0(Constant constant) {
        CstMemberRef cstMemberRef = (CstMemberRef) constant;
        int compareTo = this.definingClass.compareTo((Constant) cstMemberRef.definingClass);
        if (compareTo != 0) {
            return compareTo;
        }
        return this.nat.getName().compareTo((Constant) cstMemberRef.nat.getName());
    }

    public final boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CstMemberRef cstMemberRef = (CstMemberRef) obj;
        if (!this.definingClass.equals(cstMemberRef.definingClass) || !this.nat.equals(cstMemberRef.nat)) {
            return false;
        }
        return true;
    }

    public final CstType getDefiningClass() {
        return this.definingClass;
    }

    public final CstNat getNat() {
        return this.nat;
    }

    public final int hashCode() {
        return (this.definingClass.hashCode() * 31) ^ this.nat.hashCode();
    }

    @Override // com.android.dx.rop.cst.Constant
    public final boolean isCategory2() {
        return false;
    }

    @Override // com.android.dx.util.ToHuman
    public final String toHuman() {
        return this.definingClass.toHuman() + '.' + this.nat.toHuman();
    }

    public final String toString() {
        return typeName() + '{' + toHuman() + '}';
    }
}
