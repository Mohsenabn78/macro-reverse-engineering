package com.android.dx.dex.code;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.util.AnnotatedOutput;

/* loaded from: classes2.dex */
public final class HighRegisterPrefix extends VariableSizeInsn {
    private SimpleInsn[] insns;

    public HighRegisterPrefix(SourcePosition sourcePosition, RegisterSpecList registerSpecList) {
        super(sourcePosition, registerSpecList);
        if (registerSpecList.size() != 0) {
            this.insns = null;
            return;
        }
        throw new IllegalArgumentException("registers.size() == 0");
    }

    private void calculateInsnsIfNecessary() {
        if (this.insns != null) {
            return;
        }
        RegisterSpecList registers = getRegisters();
        int size = registers.size();
        this.insns = new SimpleInsn[size];
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RegisterSpec registerSpec = registers.get(i5);
            this.insns[i5] = moveInsnFor(registerSpec, i4);
            i4 += registerSpec.getCategory();
        }
    }

    private static SimpleInsn moveInsnFor(RegisterSpec registerSpec, int i4) {
        return DalvInsn.makeMove(SourcePosition.NO_INFO, RegisterSpec.make(i4, registerSpec.getType()), registerSpec);
    }

    @Override // com.android.dx.dex.code.DalvInsn
    protected String argString() {
        return null;
    }

    @Override // com.android.dx.dex.code.DalvInsn
    public int codeSize() {
        calculateInsnsIfNecessary();
        int i4 = 0;
        for (SimpleInsn simpleInsn : this.insns) {
            i4 += simpleInsn.codeSize();
        }
        return i4;
    }

    @Override // com.android.dx.dex.code.DalvInsn
    protected String listingString0(boolean z3) {
        RegisterSpecList registers = getRegisters();
        int size = registers.size();
        StringBuffer stringBuffer = new StringBuffer(100);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RegisterSpec registerSpec = registers.get(i5);
            SimpleInsn moveInsnFor = moveInsnFor(registerSpec, i4);
            if (i5 != 0) {
                stringBuffer.append('\n');
            }
            stringBuffer.append(moveInsnFor.listingString0(z3));
            i4 += registerSpec.getCategory();
        }
        return stringBuffer.toString();
    }

    @Override // com.android.dx.dex.code.DalvInsn
    public DalvInsn withRegisters(RegisterSpecList registerSpecList) {
        return new HighRegisterPrefix(getPosition(), registerSpecList);
    }

    @Override // com.android.dx.dex.code.DalvInsn
    public void writeTo(AnnotatedOutput annotatedOutput) {
        calculateInsnsIfNecessary();
        for (SimpleInsn simpleInsn : this.insns) {
            simpleInsn.writeTo(annotatedOutput);
        }
    }
}
