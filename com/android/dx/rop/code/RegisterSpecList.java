package com.android.dx.rop.code;

import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.FixedSizeList;
import java.util.BitSet;

/* loaded from: classes2.dex */
public final class RegisterSpecList extends FixedSizeList implements TypeList {
    public static final RegisterSpecList EMPTY = new RegisterSpecList(0);

    /* loaded from: classes2.dex */
    private static class Expander {
        private int base;
        private BitSet compatRegs;
        private boolean duplicateFirst;
        private RegisterSpecList regSpecList;
        private RegisterSpecList result;

        /* JADX INFO: Access modifiers changed from: private */
        public void expandRegister(int i4) {
            expandRegister(i4, (RegisterSpec) this.regSpecList.get0(i4));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public RegisterSpecList getResult() {
            if (this.regSpecList.isImmutable()) {
                this.result.setImmutable();
            }
            return this.result;
        }

        private Expander(RegisterSpecList registerSpecList, BitSet bitSet, int i4, boolean z3) {
            this.regSpecList = registerSpecList;
            this.compatRegs = bitSet;
            this.base = i4;
            this.result = new RegisterSpecList(registerSpecList.size());
            this.duplicateFirst = z3;
        }

        private void expandRegister(int i4, RegisterSpec registerSpec) {
            BitSet bitSet = this.compatRegs;
            boolean z3 = true;
            if (bitSet != null && bitSet.get(i4)) {
                z3 = false;
            }
            if (z3) {
                registerSpec = registerSpec.withReg(this.base);
                if (!this.duplicateFirst) {
                    this.base += registerSpec.getCategory();
                }
                this.duplicateFirst = false;
            }
            this.result.set0(i4, registerSpec);
        }
    }

    public RegisterSpecList(int i4) {
        super(i4);
    }

    public static RegisterSpecList make(RegisterSpec registerSpec) {
        RegisterSpecList registerSpecList = new RegisterSpecList(1);
        registerSpecList.set(0, registerSpec);
        return registerSpecList;
    }

    public RegisterSpec get(int i4) {
        return (RegisterSpec) get0(i4);
    }

    public int getRegistersSize() {
        int nextReg;
        int size = size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RegisterSpec registerSpec = (RegisterSpec) get0(i5);
            if (registerSpec != null && (nextReg = registerSpec.getNextReg()) > i4) {
                i4 = nextReg;
            }
        }
        return i4;
    }

    @Override // com.android.dx.rop.type.TypeList
    public Type getType(int i4) {
        return get(i4).getType().getType();
    }

    @Override // com.android.dx.rop.type.TypeList
    public int getWordCount() {
        int size = size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            i4 += getType(i5).getCategory();
        }
        return i4;
    }

    public int indexOfRegister(int i4) {
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            if (get(i5).getReg() == i4) {
                return i5;
            }
        }
        return -1;
    }

    public void set(int i4, RegisterSpec registerSpec) {
        set0(i4, registerSpec);
    }

    public RegisterSpec specForRegister(int i4) {
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            RegisterSpec registerSpec = get(i5);
            if (registerSpec.getReg() == i4) {
                return registerSpec;
            }
        }
        return null;
    }

    public RegisterSpecList subset(BitSet bitSet) {
        int size = size() - bitSet.cardinality();
        if (size == 0) {
            return EMPTY;
        }
        RegisterSpecList registerSpecList = new RegisterSpecList(size);
        int i4 = 0;
        for (int i5 = 0; i5 < size(); i5++) {
            if (!bitSet.get(i5)) {
                registerSpecList.set0(i4, get0(i5));
                i4++;
            }
        }
        if (isImmutable()) {
            registerSpecList.setImmutable();
        }
        return registerSpecList;
    }

    @Override // com.android.dx.rop.type.TypeList
    public TypeList withAddedType(Type type) {
        throw new UnsupportedOperationException("unsupported");
    }

    public RegisterSpecList withExpandedRegisters(int i4, boolean z3, BitSet bitSet) {
        int size = size();
        if (size == 0) {
            return this;
        }
        Expander expander = new Expander(bitSet, i4, z3);
        for (int i5 = 0; i5 < size; i5++) {
            expander.expandRegister(i5);
        }
        return expander.getResult();
    }

    public RegisterSpecList withFirst(RegisterSpec registerSpec) {
        int size = size();
        RegisterSpecList registerSpecList = new RegisterSpecList(size + 1);
        int i4 = 0;
        while (i4 < size) {
            int i5 = i4 + 1;
            registerSpecList.set0(i5, get0(i4));
            i4 = i5;
        }
        registerSpecList.set0(0, registerSpec);
        if (isImmutable()) {
            registerSpecList.setImmutable();
        }
        return registerSpecList;
    }

    public RegisterSpecList withOffset(int i4) {
        int size = size();
        if (size == 0) {
            return this;
        }
        RegisterSpecList registerSpecList = new RegisterSpecList(size);
        for (int i5 = 0; i5 < size; i5++) {
            RegisterSpec registerSpec = (RegisterSpec) get0(i5);
            if (registerSpec != null) {
                registerSpecList.set0(i5, registerSpec.withOffset(i4));
            }
        }
        if (isImmutable()) {
            registerSpecList.setImmutable();
        }
        return registerSpecList;
    }

    public RegisterSpecList withoutFirst() {
        int size = size() - 1;
        if (size == 0) {
            return EMPTY;
        }
        RegisterSpecList registerSpecList = new RegisterSpecList(size);
        int i4 = 0;
        while (i4 < size) {
            int i5 = i4 + 1;
            registerSpecList.set0(i4, get0(i5));
            i4 = i5;
        }
        if (isImmutable()) {
            registerSpecList.setImmutable();
        }
        return registerSpecList;
    }

    public RegisterSpecList withoutLast() {
        int size = size() - 1;
        if (size == 0) {
            return EMPTY;
        }
        RegisterSpecList registerSpecList = new RegisterSpecList(size);
        for (int i4 = 0; i4 < size; i4++) {
            registerSpecList.set0(i4, get0(i4));
        }
        if (isImmutable()) {
            registerSpecList.setImmutable();
        }
        return registerSpecList;
    }

    public static RegisterSpecList make(RegisterSpec registerSpec, RegisterSpec registerSpec2) {
        RegisterSpecList registerSpecList = new RegisterSpecList(2);
        registerSpecList.set(0, registerSpec);
        registerSpecList.set(1, registerSpec2);
        return registerSpecList;
    }

    public static RegisterSpecList make(RegisterSpec registerSpec, RegisterSpec registerSpec2, RegisterSpec registerSpec3) {
        RegisterSpecList registerSpecList = new RegisterSpecList(3);
        registerSpecList.set(0, registerSpec);
        registerSpecList.set(1, registerSpec2);
        registerSpecList.set(2, registerSpec3);
        return registerSpecList;
    }

    public static RegisterSpecList make(RegisterSpec registerSpec, RegisterSpec registerSpec2, RegisterSpec registerSpec3, RegisterSpec registerSpec4) {
        RegisterSpecList registerSpecList = new RegisterSpecList(4);
        registerSpecList.set(0, registerSpec);
        registerSpecList.set(1, registerSpec2);
        registerSpecList.set(2, registerSpec3);
        registerSpecList.set(3, registerSpec4);
        return registerSpecList;
    }
}
