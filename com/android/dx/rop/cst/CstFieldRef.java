package com.android.dx.rop.cst;

import com.android.dx.rop.type.Type;

/* loaded from: classes2.dex */
public final class CstFieldRef extends CstMemberRef {
    public CstFieldRef(CstType cstType, CstNat cstNat) {
        super(cstType, cstNat);
    }

    public static CstFieldRef forPrimitiveType(Type type) {
        return new CstFieldRef(CstType.forBoxedPrimitiveType(type), CstNat.PRIMITIVE_TYPE_NAT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.dx.rop.cst.CstMemberRef, com.android.dx.rop.cst.Constant
    public int compareTo0(Constant constant) {
        int compareTo0 = super.compareTo0(constant);
        if (compareTo0 != 0) {
            return compareTo0;
        }
        return getNat().getDescriptor().compareTo((Constant) ((CstFieldRef) constant).getNat().getDescriptor());
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public Type getType() {
        return getNat().getFieldType();
    }

    @Override // com.android.dx.rop.cst.Constant
    public String typeName() {
        return "field";
    }
}
