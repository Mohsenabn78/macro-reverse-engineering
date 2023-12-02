package com.android.dx.dex.code;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.ssa.RegisterMapper;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import com.android.dx.util.TwoColumnOutput;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.BitSet;

/* loaded from: classes2.dex */
public abstract class DalvInsn {
    private int address;
    private final Dop opcode;
    private final SourcePosition position;
    private final RegisterSpecList registers;

    public DalvInsn(Dop dop, SourcePosition sourcePosition, RegisterSpecList registerSpecList) {
        if (dop != null) {
            if (sourcePosition != null) {
                if (registerSpecList != null) {
                    this.address = -1;
                    this.opcode = dop;
                    this.position = sourcePosition;
                    this.registers = registerSpecList;
                    return;
                }
                throw new NullPointerException("registers == null");
            }
            throw new NullPointerException("position == null");
        }
        throw new NullPointerException("opcode == null");
    }

    public static SimpleInsn makeMove(SourcePosition sourcePosition, RegisterSpec registerSpec, RegisterSpec registerSpec2) {
        Dop dop;
        boolean z3 = true;
        if (registerSpec.getCategory() != 1) {
            z3 = false;
        }
        boolean isReference = registerSpec.getType().isReference();
        int reg = registerSpec.getReg();
        if ((registerSpec2.getReg() | reg) < 16) {
            if (isReference) {
                dop = Dops.MOVE_OBJECT;
            } else if (z3) {
                dop = Dops.MOVE;
            } else {
                dop = Dops.MOVE_WIDE;
            }
        } else if (reg < 256) {
            if (isReference) {
                dop = Dops.MOVE_OBJECT_FROM16;
            } else if (z3) {
                dop = Dops.MOVE_FROM16;
            } else {
                dop = Dops.MOVE_WIDE_FROM16;
            }
        } else if (isReference) {
            dop = Dops.MOVE_OBJECT_16;
        } else if (z3) {
            dop = Dops.MOVE_16;
        } else {
            dop = Dops.MOVE_WIDE_16;
        }
        return new SimpleInsn(dop, sourcePosition, RegisterSpecList.make(registerSpec, registerSpec2));
    }

    protected abstract String argString();

    public abstract int codeSize();

    public DalvInsn expandedPrefix(BitSet bitSet) {
        RegisterSpecList registerSpecList = this.registers;
        boolean z3 = bitSet.get(0);
        if (hasResult()) {
            bitSet.set(0);
        }
        RegisterSpecList subset = registerSpecList.subset(bitSet);
        if (hasResult()) {
            bitSet.set(0, z3);
        }
        if (subset.size() == 0) {
            return null;
        }
        return new HighRegisterPrefix(this.position, subset);
    }

    public DalvInsn expandedSuffix(BitSet bitSet) {
        if (hasResult() && !bitSet.get(0)) {
            RegisterSpec registerSpec = this.registers.get(0);
            return makeMove(this.position, registerSpec, registerSpec.withReg(0));
        }
        return null;
    }

    public DalvInsn expandedVersion(BitSet bitSet) {
        return withRegisters(this.registers.withExpandedRegisters(0, hasResult(), bitSet));
    }

    public final int getAddress() {
        int i4 = this.address;
        if (i4 >= 0) {
            return i4;
        }
        throw new RuntimeException("address not yet known");
    }

    public DalvInsn getLowRegVersion() {
        return withRegisters(this.registers.withExpandedRegisters(0, hasResult(), null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.android.dx.rop.code.RegisterSpecList] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.BitSet] */
    public final int getMinimumRegisterRequirement(BitSet bitSet) {
        int i4;
        ?? hasResult = hasResult();
        int size = this.registers.size();
        int i5 = 0;
        if (hasResult != 0 && !bitSet.get(0)) {
            i4 = this.registers.get(0).getCategory();
        } else {
            i4 = 0;
        }
        while (hasResult < size) {
            if (!bitSet.get(hasResult)) {
                i5 += this.registers.get(hasResult).getCategory();
            }
            hasResult++;
        }
        return Math.max(i5, i4);
    }

    public final int getNextAddress() {
        return getAddress() + codeSize();
    }

    public final Dop getOpcode() {
        return this.opcode;
    }

    public final SourcePosition getPosition() {
        return this.position;
    }

    public final RegisterSpecList getRegisters() {
        return this.registers;
    }

    public final boolean hasAddress() {
        if (this.address >= 0) {
            return true;
        }
        return false;
    }

    public final boolean hasResult() {
        return this.opcode.hasResult();
    }

    public final String identifierString() {
        int i4 = this.address;
        if (i4 != -1) {
            return String.format("%04x", Integer.valueOf(i4));
        }
        return Hex.u4(System.identityHashCode(this));
    }

    public final String listingString(String str, int i4, boolean z3) {
        int i5;
        String listingString0 = listingString0(z3);
        if (listingString0 == null) {
            return null;
        }
        String str2 = str + identifierString() + ": ";
        int length = str2.length();
        if (i4 == 0) {
            i5 = listingString0.length();
        } else {
            i5 = i4 - length;
        }
        return TwoColumnOutput.toString(str2, length, "", listingString0, i5);
    }

    protected abstract String listingString0(boolean z3);

    public final void setAddress(int i4) {
        if (i4 >= 0) {
            this.address = i4;
            return;
        }
        throw new IllegalArgumentException("address < 0");
    }

    public final String toString() {
        boolean z3;
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(identifierString());
        stringBuffer.append(' ');
        stringBuffer.append(this.position);
        stringBuffer.append(": ");
        stringBuffer.append(this.opcode.getName());
        if (this.registers.size() != 0) {
            stringBuffer.append(this.registers.toHuman(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, ", ", null));
            z3 = true;
        } else {
            z3 = false;
        }
        String argString = argString();
        if (argString != null) {
            if (z3) {
                stringBuffer.append(',');
            }
            stringBuffer.append(' ');
            stringBuffer.append(argString);
        }
        return stringBuffer.toString();
    }

    public DalvInsn withMapper(RegisterMapper registerMapper) {
        return withRegisters(registerMapper.map(getRegisters()));
    }

    public abstract DalvInsn withOpcode(Dop dop);

    public abstract DalvInsn withRegisterOffset(int i4);

    public abstract DalvInsn withRegisters(RegisterSpecList registerSpecList);

    public abstract void writeTo(AnnotatedOutput annotatedOutput);
}
