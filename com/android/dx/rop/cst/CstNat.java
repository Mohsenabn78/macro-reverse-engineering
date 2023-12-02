package com.android.dx.rop.cst;

import com.android.dx.rop.type.Type;
import net.bytebuddy.description.method.MethodDescription;

/* loaded from: classes2.dex */
public final class CstNat extends Constant {
    public static final CstNat PRIMITIVE_TYPE_NAT = new CstNat(new CstString("TYPE"), new CstString("Ljava/lang/Class;"));
    private final CstString descriptor;
    private final CstString name;

    public CstNat(CstString cstString, CstString cstString2) {
        if (cstString != null) {
            if (cstString2 != null) {
                this.name = cstString;
                this.descriptor = cstString2;
                return;
            }
            throw new NullPointerException("descriptor == null");
        }
        throw new NullPointerException("name == null");
    }

    @Override // com.android.dx.rop.cst.Constant
    protected int compareTo0(Constant constant) {
        CstNat cstNat = (CstNat) constant;
        int compareTo = this.name.compareTo((Constant) cstNat.name);
        if (compareTo != 0) {
            return compareTo;
        }
        return this.descriptor.compareTo((Constant) cstNat.descriptor);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CstNat)) {
            return false;
        }
        CstNat cstNat = (CstNat) obj;
        if (!this.name.equals(cstNat.name) || !this.descriptor.equals(cstNat.descriptor)) {
            return false;
        }
        return true;
    }

    public CstString getDescriptor() {
        return this.descriptor;
    }

    public Type getFieldType() {
        return Type.intern(this.descriptor.getString());
    }

    public CstString getName() {
        return this.name;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) ^ this.descriptor.hashCode();
    }

    @Override // com.android.dx.rop.cst.Constant
    public boolean isCategory2() {
        return false;
    }

    public final boolean isClassInit() {
        return this.name.getString().equals(MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME);
    }

    public final boolean isInstanceInit() {
        return this.name.getString().equals(MethodDescription.CONSTRUCTOR_INTERNAL_NAME);
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        return this.name.toHuman() + ':' + this.descriptor.toHuman();
    }

    public String toString() {
        return "nat{" + toHuman() + '}';
    }

    @Override // com.android.dx.rop.cst.Constant
    public String typeName() {
        return "nat";
    }
}
