package com.android.dx.cf.iface;

import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;

/* loaded from: classes2.dex */
public abstract class StdMember implements Member {
    private final int accessFlags;
    private final AttributeList attributes;
    private final CstType definingClass;
    private final CstNat nat;

    public StdMember(CstType cstType, int i4, CstNat cstNat, AttributeList attributeList) {
        if (cstType != null) {
            if (cstNat != null) {
                if (attributeList != null) {
                    this.definingClass = cstType;
                    this.accessFlags = i4;
                    this.nat = cstNat;
                    this.attributes = attributeList;
                    return;
                }
                throw new NullPointerException("attributes == null");
            }
            throw new NullPointerException("nat == null");
        }
        throw new NullPointerException("definingClass == null");
    }

    @Override // com.android.dx.cf.iface.Member
    public final int getAccessFlags() {
        return this.accessFlags;
    }

    @Override // com.android.dx.cf.iface.Member, com.android.dx.cf.iface.HasAttribute
    public final AttributeList getAttributes() {
        return this.attributes;
    }

    @Override // com.android.dx.cf.iface.Member
    public final CstType getDefiningClass() {
        return this.definingClass;
    }

    @Override // com.android.dx.cf.iface.Member
    public final CstString getDescriptor() {
        return this.nat.getDescriptor();
    }

    @Override // com.android.dx.cf.iface.Member
    public final CstString getName() {
        return this.nat.getName();
    }

    @Override // com.android.dx.cf.iface.Member
    public final CstNat getNat() {
        return this.nat;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(getClass().getName());
        stringBuffer.append('{');
        stringBuffer.append(this.nat.toHuman());
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
