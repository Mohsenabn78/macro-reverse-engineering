package com.android.dx.rop.code;

import com.android.dx.util.MutabilityControl;

/* loaded from: classes2.dex */
public final class RegisterSpecSet extends MutabilityControl {
    public static final RegisterSpecSet EMPTY = new RegisterSpecSet(0);
    private int size;
    private final RegisterSpec[] specs;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public RegisterSpecSet(int r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L5
            r1 = 1
            goto L6
        L5:
            r1 = 0
        L6:
            r2.<init>(r1)
            com.android.dx.rop.code.RegisterSpec[] r3 = new com.android.dx.rop.code.RegisterSpec[r3]
            r2.specs = r3
            r2.size = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.dx.rop.code.RegisterSpecSet.<init>(int):void");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RegisterSpecSet)) {
            return false;
        }
        RegisterSpecSet registerSpecSet = (RegisterSpecSet) obj;
        RegisterSpec[] registerSpecArr = registerSpecSet.specs;
        int length = this.specs.length;
        if (length != registerSpecArr.length || size() != registerSpecSet.size()) {
            return false;
        }
        for (int i4 = 0; i4 < length; i4++) {
            RegisterSpec registerSpec = this.specs[i4];
            RegisterSpec registerSpec2 = registerSpecArr[i4];
            if (registerSpec != registerSpec2 && (registerSpec == null || !registerSpec.equals(registerSpec2))) {
                return false;
            }
        }
        return true;
    }

    public RegisterSpec findMatchingLocal(RegisterSpec registerSpec) {
        int length = this.specs.length;
        for (int i4 = 0; i4 < length; i4++) {
            RegisterSpec registerSpec2 = this.specs[i4];
            if (registerSpec2 != null && registerSpec.matchesVariable(registerSpec2)) {
                return registerSpec2;
            }
        }
        return null;
    }

    public RegisterSpec get(int i4) {
        try {
            return this.specs[i4];
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IllegalArgumentException("bogus reg");
        }
    }

    public int getMaxSize() {
        return this.specs.length;
    }

    public int hashCode() {
        int hashCode;
        int length = this.specs.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            RegisterSpec registerSpec = this.specs[i5];
            if (registerSpec == null) {
                hashCode = 0;
            } else {
                hashCode = registerSpec.hashCode();
            }
            i4 = (i4 * 31) + hashCode;
        }
        return i4;
    }

    public void intersect(RegisterSpecSet registerSpecSet, boolean z3) {
        RegisterSpec intersect;
        throwIfImmutable();
        RegisterSpec[] registerSpecArr = registerSpecSet.specs;
        int length = this.specs.length;
        int min = Math.min(length, registerSpecArr.length);
        this.size = -1;
        for (int i4 = 0; i4 < min; i4++) {
            RegisterSpec registerSpec = this.specs[i4];
            if (registerSpec != null && (intersect = registerSpec.intersect(registerSpecArr[i4], z3)) != registerSpec) {
                this.specs[i4] = intersect;
            }
        }
        while (min < length) {
            this.specs[min] = null;
            min++;
        }
    }

    public RegisterSpec localItemToSpec(LocalItem localItem) {
        int length = this.specs.length;
        for (int i4 = 0; i4 < length; i4++) {
            RegisterSpec registerSpec = this.specs[i4];
            if (registerSpec != null && localItem.equals(registerSpec.getLocalItem())) {
                return registerSpec;
            }
        }
        return null;
    }

    public RegisterSpecSet mutableCopy() {
        int length = this.specs.length;
        RegisterSpecSet registerSpecSet = new RegisterSpecSet(length);
        for (int i4 = 0; i4 < length; i4++) {
            RegisterSpec registerSpec = this.specs[i4];
            if (registerSpec != null) {
                registerSpecSet.put(registerSpec);
            }
        }
        registerSpecSet.size = this.size;
        return registerSpecSet;
    }

    public void put(RegisterSpec registerSpec) {
        int i4;
        RegisterSpec registerSpec2;
        throwIfImmutable();
        if (registerSpec != null) {
            this.size = -1;
            try {
                int reg = registerSpec.getReg();
                RegisterSpec[] registerSpecArr = this.specs;
                registerSpecArr[reg] = registerSpec;
                if (reg > 0 && (registerSpec2 = registerSpecArr[reg - 1]) != null && registerSpec2.getCategory() == 2) {
                    this.specs[i4] = null;
                }
                if (registerSpec.getCategory() == 2) {
                    this.specs[reg + 1] = null;
                    return;
                }
                return;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new IllegalArgumentException("spec.getReg() out of range");
            }
        }
        throw new NullPointerException("spec == null");
    }

    public void putAll(RegisterSpecSet registerSpecSet) {
        int maxSize = registerSpecSet.getMaxSize();
        for (int i4 = 0; i4 < maxSize; i4++) {
            RegisterSpec registerSpec = registerSpecSet.get(i4);
            if (registerSpec != null) {
                put(registerSpec);
            }
        }
    }

    public void remove(RegisterSpec registerSpec) {
        try {
            this.specs[registerSpec.getReg()] = null;
            this.size = -1;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IllegalArgumentException("bogus reg");
        }
    }

    public int size() {
        int i4 = this.size;
        if (i4 < 0) {
            int length = this.specs.length;
            int i5 = 0;
            for (int i6 = 0; i6 < length; i6++) {
                if (this.specs[i6] != null) {
                    i5++;
                }
            }
            this.size = i5;
            return i5;
        }
        return i4;
    }

    public String toString() {
        int length = this.specs.length;
        StringBuffer stringBuffer = new StringBuffer(length * 25);
        stringBuffer.append('{');
        boolean z3 = false;
        for (int i4 = 0; i4 < length; i4++) {
            RegisterSpec registerSpec = this.specs[i4];
            if (registerSpec != null) {
                if (z3) {
                    stringBuffer.append(", ");
                } else {
                    z3 = true;
                }
                stringBuffer.append(registerSpec);
            }
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public RegisterSpecSet withOffset(int i4) {
        int length = this.specs.length;
        RegisterSpecSet registerSpecSet = new RegisterSpecSet(length + i4);
        for (int i5 = 0; i5 < length; i5++) {
            RegisterSpec registerSpec = this.specs[i5];
            if (registerSpec != null) {
                registerSpecSet.put(registerSpec.withOffset(i4));
            }
        }
        registerSpecSet.size = this.size;
        if (isImmutable()) {
            registerSpecSet.setImmutable();
        }
        return registerSpecSet;
    }

    public RegisterSpec get(RegisterSpec registerSpec) {
        return get(registerSpec.getReg());
    }
}
