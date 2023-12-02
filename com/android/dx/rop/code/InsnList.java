package com.android.dx.rop.code;

import com.android.dx.rop.code.Insn;
import com.android.dx.util.FixedSizeList;

/* loaded from: classes2.dex */
public final class InsnList extends FixedSizeList {
    public InsnList(int i4) {
        super(i4);
    }

    public boolean contentEquals(InsnList insnList) {
        int size;
        if (insnList == null || (size = size()) != insnList.size()) {
            return false;
        }
        for (int i4 = 0; i4 < size; i4++) {
            if (!get(i4).contentEquals(insnList.get(i4))) {
                return false;
            }
        }
        return true;
    }

    public void forEach(Insn.Visitor visitor) {
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            get(i4).accept(visitor);
        }
    }

    public Insn get(int i4) {
        return (Insn) get0(i4);
    }

    public Insn getLast() {
        return get(size() - 1);
    }

    public void set(int i4, Insn insn) {
        set0(i4, insn);
    }

    public InsnList withRegisterOffset(int i4) {
        int size = size();
        InsnList insnList = new InsnList(size);
        for (int i5 = 0; i5 < size; i5++) {
            Insn insn = (Insn) get0(i5);
            if (insn != null) {
                insnList.set0(i5, insn.withRegisterOffset(i4));
            }
        }
        if (isImmutable()) {
            insnList.setImmutable();
        }
        return insnList;
    }
}
