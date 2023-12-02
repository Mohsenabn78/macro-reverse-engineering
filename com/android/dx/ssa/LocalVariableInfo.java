package com.android.dx.ssa;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecSet;
import com.android.dx.util.MutabilityControl;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class LocalVariableInfo extends MutabilityControl {
    private final RegisterSpecSet[] blockStarts;
    private final RegisterSpecSet emptySet;
    private final HashMap<SsaInsn, RegisterSpec> insnAssignments;
    private final int regCount;

    public LocalVariableInfo(SsaMethod ssaMethod) {
        if (ssaMethod != null) {
            ArrayList<SsaBasicBlock> blocks = ssaMethod.getBlocks();
            int regCount = ssaMethod.getRegCount();
            this.regCount = regCount;
            RegisterSpecSet registerSpecSet = new RegisterSpecSet(regCount);
            this.emptySet = registerSpecSet;
            this.blockStarts = new RegisterSpecSet[blocks.size()];
            this.insnAssignments = new HashMap<>();
            registerSpecSet.setImmutable();
            return;
        }
        throw new NullPointerException("method == null");
    }

    private RegisterSpecSet getStarts0(int i4) {
        try {
            return this.blockStarts[i4];
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IllegalArgumentException("bogus index");
        }
    }

    public void addAssignment(SsaInsn ssaInsn, RegisterSpec registerSpec) {
        throwIfImmutable();
        if (ssaInsn != null) {
            if (registerSpec != null) {
                this.insnAssignments.put(ssaInsn, registerSpec);
                return;
            }
            throw new NullPointerException("spec == null");
        }
        throw new NullPointerException("insn == null");
    }

    public void debugDump() {
        int i4 = 0;
        while (true) {
            RegisterSpecSet[] registerSpecSetArr = this.blockStarts;
            if (i4 < registerSpecSetArr.length) {
                RegisterSpecSet registerSpecSet = registerSpecSetArr[i4];
                if (registerSpecSet != null) {
                    if (registerSpecSet == this.emptySet) {
                        System.out.printf("%04x: empty set\n", Integer.valueOf(i4));
                    } else {
                        System.out.printf("%04x: %s\n", Integer.valueOf(i4), this.blockStarts[i4]);
                    }
                }
                i4++;
            } else {
                return;
            }
        }
    }

    public RegisterSpec getAssignment(SsaInsn ssaInsn) {
        return this.insnAssignments.get(ssaInsn);
    }

    public int getAssignmentCount() {
        return this.insnAssignments.size();
    }

    public RegisterSpecSet getStarts(int i4) {
        RegisterSpecSet starts0 = getStarts0(i4);
        return starts0 != null ? starts0 : this.emptySet;
    }

    public boolean mergeStarts(int i4, RegisterSpecSet registerSpecSet) {
        RegisterSpecSet starts0 = getStarts0(i4);
        if (starts0 == null) {
            setStarts(i4, registerSpecSet);
            return true;
        }
        RegisterSpecSet mutableCopy = starts0.mutableCopy();
        mutableCopy.intersect(registerSpecSet, true);
        if (starts0.equals(mutableCopy)) {
            return false;
        }
        mutableCopy.setImmutable();
        setStarts(i4, mutableCopy);
        return true;
    }

    public RegisterSpecSet mutableCopyOfStarts(int i4) {
        RegisterSpecSet starts0 = getStarts0(i4);
        if (starts0 != null) {
            return starts0.mutableCopy();
        }
        return new RegisterSpecSet(this.regCount);
    }

    public void setStarts(int i4, RegisterSpecSet registerSpecSet) {
        throwIfImmutable();
        if (registerSpecSet != null) {
            try {
                this.blockStarts[i4] = registerSpecSet;
                return;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new IllegalArgumentException("bogus index");
            }
        }
        throw new NullPointerException("specs == null");
    }

    public RegisterSpecSet getStarts(SsaBasicBlock ssaBasicBlock) {
        return getStarts(ssaBasicBlock.getIndex());
    }
}
