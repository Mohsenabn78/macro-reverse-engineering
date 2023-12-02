package com.android.dx.cf.iface;

import com.android.dx.cf.attrib.AttConstantValue;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.cst.TypedConstant;

/* loaded from: classes2.dex */
public final class StdField extends StdMember implements Field {
    public StdField(CstType cstType, int i4, CstNat cstNat, AttributeList attributeList) {
        super(cstType, i4, cstNat, attributeList);
    }

    @Override // com.android.dx.cf.iface.Field
    public TypedConstant getConstantValue() {
        AttConstantValue attConstantValue = (AttConstantValue) getAttributes().findFirst(AttConstantValue.ATTRIBUTE_NAME);
        if (attConstantValue == null) {
            return null;
        }
        return attConstantValue.getConstantValue();
    }
}
