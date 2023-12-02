package com.android.dx.dex.code.form;

import com.android.dx.dex.code.CstInsn;
import com.android.dx.dex.code.DalvInsn;
import com.android.dx.dex.code.InsnFormat;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.util.AnnotatedOutput;
import java.util.BitSet;

/* loaded from: classes2.dex */
public final class Form35c extends InsnFormat {
    private static final int MAX_NUM_OPS = 5;
    public static final InsnFormat THE_ONE = new Form35c();

    private Form35c() {
    }

    private static RegisterSpecList explicitize(RegisterSpecList registerSpecList) {
        int wordCount = wordCount(registerSpecList);
        int size = registerSpecList.size();
        if (wordCount == size) {
            return registerSpecList;
        }
        RegisterSpecList registerSpecList2 = new RegisterSpecList(wordCount);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RegisterSpec registerSpec = registerSpecList.get(i5);
            registerSpecList2.set(i4, registerSpec);
            if (registerSpec.getCategory() == 2) {
                registerSpecList2.set(i4 + 1, RegisterSpec.make(registerSpec.getReg() + 1, Type.VOID));
                i4 += 2;
            } else {
                i4++;
            }
        }
        registerSpecList2.setImmutable();
        return registerSpecList2;
    }

    private static int wordCount(RegisterSpecList registerSpecList) {
        int size = registerSpecList.size();
        if (size > 5) {
            return -1;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RegisterSpec registerSpec = registerSpecList.get(i5);
            i4 += registerSpec.getCategory();
            if (!InsnFormat.unsignedFitsInNibble((registerSpec.getReg() + registerSpec.getCategory()) - 1)) {
                return -1;
            }
        }
        if (i4 > 5) {
            return -1;
        }
        return i4;
    }

    @Override // com.android.dx.dex.code.InsnFormat
    public int codeSize() {
        return 3;
    }

    @Override // com.android.dx.dex.code.InsnFormat
    public BitSet compatibleRegs(DalvInsn dalvInsn) {
        RegisterSpecList registers = dalvInsn.getRegisters();
        int size = registers.size();
        BitSet bitSet = new BitSet(size);
        for (int i4 = 0; i4 < size; i4++) {
            RegisterSpec registerSpec = registers.get(i4);
            bitSet.set(i4, InsnFormat.unsignedFitsInNibble((registerSpec.getReg() + registerSpec.getCategory()) - 1));
        }
        return bitSet;
    }

    @Override // com.android.dx.dex.code.InsnFormat
    public String insnArgString(DalvInsn dalvInsn) {
        RegisterSpecList explicitize = explicitize(dalvInsn.getRegisters());
        return InsnFormat.regListString(explicitize) + ", " + InsnFormat.cstString(dalvInsn);
    }

    @Override // com.android.dx.dex.code.InsnFormat
    public String insnCommentString(DalvInsn dalvInsn, boolean z3) {
        if (z3) {
            return InsnFormat.cstComment(dalvInsn);
        }
        return "";
    }

    @Override // com.android.dx.dex.code.InsnFormat
    public boolean isCompatible(DalvInsn dalvInsn) {
        if (!(dalvInsn instanceof CstInsn)) {
            return false;
        }
        CstInsn cstInsn = (CstInsn) dalvInsn;
        if (!InsnFormat.unsignedFitsInShort(cstInsn.getIndex())) {
            return false;
        }
        Constant constant = cstInsn.getConstant();
        if ((!(constant instanceof CstMethodRef) && !(constant instanceof CstType)) || wordCount(cstInsn.getRegisters()) < 0) {
            return false;
        }
        return true;
    }

    @Override // com.android.dx.dex.code.InsnFormat
    public void writeTo(AnnotatedOutput annotatedOutput, DalvInsn dalvInsn) {
        int i4;
        int i5;
        int i6;
        int i7;
        int index = ((CstInsn) dalvInsn).getIndex();
        RegisterSpecList explicitize = explicitize(dalvInsn.getRegisters());
        int size = explicitize.size();
        int i8 = 0;
        if (size > 0) {
            i4 = explicitize.get(0).getReg();
        } else {
            i4 = 0;
        }
        if (size > 1) {
            i5 = explicitize.get(1).getReg();
        } else {
            i5 = 0;
        }
        if (size > 2) {
            i6 = explicitize.get(2).getReg();
        } else {
            i6 = 0;
        }
        if (size > 3) {
            i7 = explicitize.get(3).getReg();
        } else {
            i7 = 0;
        }
        if (size > 4) {
            i8 = explicitize.get(4).getReg();
        }
        InsnFormat.write(annotatedOutput, InsnFormat.opcodeUnit(dalvInsn, InsnFormat.makeByte(i8, size)), (short) index, InsnFormat.codeUnit(i4, i5, i6, i7));
    }
}
