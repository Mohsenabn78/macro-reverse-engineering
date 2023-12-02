package com.android.dx.rop.code;

import com.android.dx.util.MutabilityControl;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class LocalVariableInfo extends MutabilityControl {
    private final RegisterSpecSet[] blockStarts;
    private final RegisterSpecSet emptySet;
    private final HashMap<Insn, RegisterSpec> insnAssignments;
    private final int regCount;

    public LocalVariableInfo(RopMethod ropMethod) {
        if (ropMethod != null) {
            BasicBlockList blocks = ropMethod.getBlocks();
            int maxLabel = blocks.getMaxLabel();
            int regCount = blocks.getRegCount();
            this.regCount = regCount;
            RegisterSpecSet registerSpecSet = new RegisterSpecSet(regCount);
            this.emptySet = registerSpecSet;
            this.blockStarts = new RegisterSpecSet[maxLabel];
            this.insnAssignments = new HashMap<>(blocks.getInstructionCount());
            registerSpecSet.setImmutable();
            return;
        }
        throw new NullPointerException("method == null");
    }

    private RegisterSpecSet getStarts0(int i4) {
        try {
            return this.blockStarts[i4];
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IllegalArgumentException("bogus label");
        }
    }

    public void addAssignment(Insn insn, RegisterSpec registerSpec) {
        throwIfImmutable();
        if (insn != null) {
            if (registerSpec != null) {
                this.insnAssignments.put(insn, registerSpec);
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

    public RegisterSpec getAssignment(Insn insn) {
        return this.insnAssignments.get(insn);
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
        if (starts0.size() != 0) {
            mutableCopy.intersect(registerSpecSet, true);
        } else {
            mutableCopy = registerSpecSet.mutableCopy();
        }
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
                throw new IllegalArgumentException("bogus label");
            }
        }
        throw new NullPointerException("specs == null");
    }

    public RegisterSpecSet getStarts(BasicBlock basicBlock) {
        return getStarts(basicBlock.getLabel());
    }
}
