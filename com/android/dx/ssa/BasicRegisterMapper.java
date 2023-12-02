package com.android.dx.ssa;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.util.IntList;

/* loaded from: classes2.dex */
public class BasicRegisterMapper extends RegisterMapper {
    private IntList oldToNew;
    private int runningCountNewRegisters;

    public BasicRegisterMapper(int i4) {
        this.oldToNew = new IntList(i4);
    }

    public void addMapping(int i4, int i5, int i6) {
        if (i4 >= this.oldToNew.size()) {
            for (int size = i4 - this.oldToNew.size(); size >= 0; size--) {
                this.oldToNew.add(-1);
            }
        }
        this.oldToNew.set(i4, i5);
        int i7 = i5 + i6;
        if (this.runningCountNewRegisters < i7) {
            this.runningCountNewRegisters = i7;
        }
    }

    @Override // com.android.dx.ssa.RegisterMapper
    public int getNewRegisterCount() {
        return this.runningCountNewRegisters;
    }

    @Override // com.android.dx.ssa.RegisterMapper
    public RegisterSpec map(RegisterSpec registerSpec) {
        int i4;
        if (registerSpec == null) {
            return null;
        }
        try {
            i4 = this.oldToNew.get(registerSpec.getReg());
        } catch (IndexOutOfBoundsException unused) {
            i4 = -1;
        }
        if (i4 >= 0) {
            return registerSpec.withReg(i4);
        }
        throw new RuntimeException("no mapping specified for register");
    }

    public int oldToNew(int i4) {
        if (i4 >= this.oldToNew.size()) {
            return -1;
        }
        return this.oldToNew.get(i4);
    }

    public String toHuman() {
        StringBuilder sb = new StringBuilder();
        sb.append("Old\tNew\n");
        int size = this.oldToNew.size();
        for (int i4 = 0; i4 < size; i4++) {
            sb.append(i4);
            sb.append('\t');
            sb.append(this.oldToNew.get(i4));
            sb.append('\n');
        }
        sb.append("new reg count:");
        sb.append(this.runningCountNewRegisters);
        sb.append('\n');
        return sb.toString();
    }
}
