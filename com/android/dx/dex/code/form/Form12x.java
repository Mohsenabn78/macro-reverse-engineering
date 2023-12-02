package com.android.dx.dex.code.form;

import com.android.dx.dex.code.DalvInsn;
import com.android.dx.dex.code.InsnFormat;
import com.android.dx.dex.code.SimpleInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.util.AnnotatedOutput;
import java.util.BitSet;

/* loaded from: classes2.dex */
public final class Form12x extends InsnFormat {
    public static final InsnFormat THE_ONE = new Form12x();

    private Form12x() {
    }

    @Override // com.android.dx.dex.code.InsnFormat
    public int codeSize() {
        return 1;
    }

    @Override // com.android.dx.dex.code.InsnFormat
    public BitSet compatibleRegs(DalvInsn dalvInsn) {
        RegisterSpecList registers = dalvInsn.getRegisters();
        BitSet bitSet = new BitSet(2);
        int reg = registers.get(0).getReg();
        int reg2 = registers.get(1).getReg();
        int size = registers.size();
        if (size != 2) {
            if (size == 3) {
                if (reg != reg2) {
                    bitSet.set(0, false);
                    bitSet.set(1, false);
                } else {
                    boolean unsignedFitsInNibble = InsnFormat.unsignedFitsInNibble(reg2);
                    bitSet.set(0, unsignedFitsInNibble);
                    bitSet.set(1, unsignedFitsInNibble);
                }
                bitSet.set(2, InsnFormat.unsignedFitsInNibble(registers.get(2).getReg()));
            } else {
                throw new AssertionError();
            }
        } else {
            bitSet.set(0, InsnFormat.unsignedFitsInNibble(reg));
            bitSet.set(1, InsnFormat.unsignedFitsInNibble(reg2));
        }
        return bitSet;
    }

    @Override // com.android.dx.dex.code.InsnFormat
    public String insnArgString(DalvInsn dalvInsn) {
        RegisterSpecList registers = dalvInsn.getRegisters();
        int size = registers.size();
        return registers.get(size - 2).regString() + ", " + registers.get(size - 1).regString();
    }

    @Override // com.android.dx.dex.code.InsnFormat
    public String insnCommentString(DalvInsn dalvInsn, boolean z3) {
        return "";
    }

    @Override // com.android.dx.dex.code.InsnFormat
    public boolean isCompatible(DalvInsn dalvInsn) {
        RegisterSpec registerSpec;
        RegisterSpec registerSpec2;
        if (!(dalvInsn instanceof SimpleInsn)) {
            return false;
        }
        RegisterSpecList registers = dalvInsn.getRegisters();
        int size = registers.size();
        if (size != 2) {
            if (size != 3) {
                return false;
            }
            registerSpec = registers.get(1);
            registerSpec2 = registers.get(2);
            if (registerSpec.getReg() != registers.get(0).getReg()) {
                return false;
            }
        } else {
            registerSpec = registers.get(0);
            registerSpec2 = registers.get(1);
        }
        if (!InsnFormat.unsignedFitsInNibble(registerSpec.getReg()) || !InsnFormat.unsignedFitsInNibble(registerSpec2.getReg())) {
            return false;
        }
        return true;
    }

    @Override // com.android.dx.dex.code.InsnFormat
    public void writeTo(AnnotatedOutput annotatedOutput, DalvInsn dalvInsn) {
        RegisterSpecList registers = dalvInsn.getRegisters();
        int size = registers.size();
        InsnFormat.write(annotatedOutput, InsnFormat.opcodeUnit(dalvInsn, InsnFormat.makeByte(registers.get(size - 2).getReg(), registers.get(size - 1).getReg())));
    }
}
