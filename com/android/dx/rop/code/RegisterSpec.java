package com.android.dx.rop.code;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import com.android.dx.util.ToHuman;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class RegisterSpec implements TypeBearer, ToHuman, Comparable<RegisterSpec> {
    public static final String PREFIX = "v";
    private final LocalItem local;
    private final int reg;
    private final TypeBearer type;
    private static final HashMap<Object, RegisterSpec> theInterns = new HashMap<>(1000);
    private static final ForComparison theInterningItem = new ForComparison();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ForComparison {
        private LocalItem local;
        private int reg;
        private TypeBearer type;

        private ForComparison() {
        }

        public boolean equals(Object obj) {
            if (obj instanceof RegisterSpec) {
                return ((RegisterSpec) obj).equals(this.reg, this.type, this.local);
            }
            return false;
        }

        public int hashCode() {
            return RegisterSpec.hashCodeOf(this.reg, this.type, this.local);
        }

        public void set(int i4, TypeBearer typeBearer, LocalItem localItem) {
            this.reg = i4;
            this.type = typeBearer;
            this.local = localItem;
        }

        public RegisterSpec toRegisterSpec() {
            return new RegisterSpec(this.reg, this.type, this.local);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int hashCodeOf(int i4, TypeBearer typeBearer, LocalItem localItem) {
        int i5;
        if (localItem != null) {
            i5 = localItem.hashCode();
        } else {
            i5 = 0;
        }
        return (((i5 * 31) + typeBearer.hashCode()) * 31) + i4;
    }

    private static RegisterSpec intern(int i4, TypeBearer typeBearer, LocalItem localItem) {
        HashMap<Object, RegisterSpec> hashMap = theInterns;
        synchronized (hashMap) {
            ForComparison forComparison = theInterningItem;
            forComparison.set(i4, typeBearer, localItem);
            RegisterSpec registerSpec = hashMap.get(forComparison);
            if (registerSpec != null) {
                return registerSpec;
            }
            RegisterSpec registerSpec2 = forComparison.toRegisterSpec();
            hashMap.put(registerSpec2, registerSpec2);
            return registerSpec2;
        }
    }

    public static RegisterSpec make(int i4, TypeBearer typeBearer) {
        return intern(i4, typeBearer, null);
    }

    public static RegisterSpec makeLocalOptional(int i4, TypeBearer typeBearer, LocalItem localItem) {
        return intern(i4, typeBearer, localItem);
    }

    public static String regString(int i4) {
        return PREFIX + i4;
    }

    private String toString0(boolean z3) {
        StringBuffer stringBuffer = new StringBuffer(40);
        stringBuffer.append(regString());
        stringBuffer.append(":");
        LocalItem localItem = this.local;
        if (localItem != null) {
            stringBuffer.append(localItem.toString());
        }
        Type type = this.type.getType();
        stringBuffer.append(type);
        if (type != this.type) {
            stringBuffer.append("=");
            if (z3) {
                TypeBearer typeBearer = this.type;
                if (typeBearer instanceof CstString) {
                    stringBuffer.append(((CstString) typeBearer).toQuoted());
                }
            }
            if (z3) {
                TypeBearer typeBearer2 = this.type;
                if (typeBearer2 instanceof Constant) {
                    stringBuffer.append(typeBearer2.toHuman());
                }
            }
            stringBuffer.append(this.type);
        }
        return stringBuffer.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RegisterSpec)) {
            if (obj instanceof ForComparison) {
                ForComparison forComparison = (ForComparison) obj;
                return equals(forComparison.reg, forComparison.type, forComparison.local);
            }
            return false;
        }
        RegisterSpec registerSpec = (RegisterSpec) obj;
        return equals(registerSpec.reg, registerSpec.type, registerSpec.local);
    }

    public boolean equalsUsingSimpleType(RegisterSpec registerSpec) {
        if (!matchesVariable(registerSpec) || this.reg != registerSpec.reg) {
            return false;
        }
        return true;
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public final int getBasicFrameType() {
        return this.type.getBasicFrameType();
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public final int getBasicType() {
        return this.type.getBasicType();
    }

    public int getCategory() {
        return this.type.getType().getCategory();
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public TypeBearer getFrameType() {
        return this.type.getFrameType();
    }

    public LocalItem getLocalItem() {
        return this.local;
    }

    public int getNextReg() {
        return this.reg + getCategory();
    }

    public int getReg() {
        return this.reg;
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public Type getType() {
        return this.type.getType();
    }

    public TypeBearer getTypeBearer() {
        return this.type;
    }

    public int hashCode() {
        return hashCodeOf(this.reg, this.type, this.local);
    }

    public RegisterSpec intersect(RegisterSpec registerSpec, boolean z3) {
        LocalItem localItem;
        boolean z4;
        TypeBearer type;
        if (this == registerSpec) {
            return this;
        }
        if (registerSpec == null || this.reg != registerSpec.getReg()) {
            return null;
        }
        LocalItem localItem2 = this.local;
        if (localItem2 != null && localItem2.equals(registerSpec.getLocalItem())) {
            localItem = this.local;
        } else {
            localItem = null;
        }
        if (localItem == this.local) {
            z4 = true;
        } else {
            z4 = false;
        }
        if ((z3 && !z4) || (type = getType()) != registerSpec.getType()) {
            return null;
        }
        if (this.type.equals(registerSpec.getTypeBearer())) {
            type = this.type;
        }
        if (type == this.type && z4) {
            return this;
        }
        int i4 = this.reg;
        if (localItem == null) {
            return make(i4, type);
        }
        return make(i4, type, localItem);
    }

    public boolean isCategory1() {
        return this.type.getType().isCategory1();
    }

    public boolean isCategory2() {
        return this.type.getType().isCategory2();
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public final boolean isConstant() {
        return false;
    }

    public boolean isEvenRegister() {
        if ((getReg() & 1) == 0) {
            return true;
        }
        return false;
    }

    public boolean matchesVariable(RegisterSpec registerSpec) {
        if (registerSpec == null || !this.type.getType().equals(registerSpec.type.getType())) {
            return false;
        }
        LocalItem localItem = this.local;
        LocalItem localItem2 = registerSpec.local;
        if (localItem != localItem2 && (localItem == null || !localItem.equals(localItem2))) {
            return false;
        }
        return true;
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        return toString0(true);
    }

    public String toString() {
        return toString0(false);
    }

    public RegisterSpec withLocalItem(LocalItem localItem) {
        LocalItem localItem2 = this.local;
        if (localItem2 != localItem && (localItem2 == null || !localItem2.equals(localItem))) {
            return makeLocalOptional(this.reg, this.type, localItem);
        }
        return this;
    }

    public RegisterSpec withOffset(int i4) {
        if (i4 == 0) {
            return this;
        }
        return withReg(this.reg + i4);
    }

    public RegisterSpec withReg(int i4) {
        if (this.reg == i4) {
            return this;
        }
        return makeLocalOptional(i4, this.type, this.local);
    }

    public RegisterSpec withSimpleType() {
        Type type;
        TypeBearer typeBearer = this.type;
        if (typeBearer instanceof Type) {
            type = (Type) typeBearer;
        } else {
            type = typeBearer.getType();
        }
        if (type.isUninitialized()) {
            type = type.getInitializedType();
        }
        if (type == typeBearer) {
            return this;
        }
        return makeLocalOptional(this.reg, type, this.local);
    }

    public RegisterSpec withType(TypeBearer typeBearer) {
        return makeLocalOptional(this.reg, typeBearer, this.local);
    }

    private RegisterSpec(int i4, TypeBearer typeBearer, LocalItem localItem) {
        if (i4 < 0) {
            throw new IllegalArgumentException("reg < 0");
        }
        if (typeBearer != null) {
            this.reg = i4;
            this.type = typeBearer;
            this.local = localItem;
            return;
        }
        throw new NullPointerException("type == null");
    }

    public static RegisterSpec make(int i4, TypeBearer typeBearer, LocalItem localItem) {
        if (localItem != null) {
            return intern(i4, typeBearer, localItem);
        }
        throw new NullPointerException("local  == null");
    }

    @Override // java.lang.Comparable
    public int compareTo(RegisterSpec registerSpec) {
        int i4 = this.reg;
        int i5 = registerSpec.reg;
        if (i4 < i5) {
            return -1;
        }
        if (i4 > i5) {
            return 1;
        }
        int compareTo = this.type.getType().compareTo(registerSpec.type.getType());
        if (compareTo != 0) {
            return compareTo;
        }
        LocalItem localItem = this.local;
        if (localItem == null) {
            return registerSpec.local == null ? 0 : -1;
        }
        LocalItem localItem2 = registerSpec.local;
        if (localItem2 == null) {
            return 1;
        }
        return localItem.compareTo(localItem2);
    }

    public String regString() {
        return regString(this.reg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean equals(int i4, TypeBearer typeBearer, LocalItem localItem) {
        LocalItem localItem2;
        return this.reg == i4 && this.type.equals(typeBearer) && ((localItem2 = this.local) == localItem || (localItem2 != null && localItem2.equals(localItem)));
    }
}
