package com.android.dx.rop.code;

import com.android.dx.rop.cst.Constant;

/* loaded from: classes2.dex */
public abstract class CstInsn extends Insn {
    private final Constant cst;

    public CstInsn(Rop rop, SourcePosition sourcePosition, RegisterSpec registerSpec, RegisterSpecList registerSpecList, Constant constant) {
        super(rop, sourcePosition, registerSpec, registerSpecList);
        if (constant != null) {
            this.cst = constant;
            return;
        }
        throw new NullPointerException("cst == null");
    }

    @Override // com.android.dx.rop.code.Insn
    public boolean contentEquals(Insn insn) {
        if (super.contentEquals(insn) && this.cst.equals(((CstInsn) insn).getConstant())) {
            return true;
        }
        return false;
    }

    public Constant getConstant() {
        return this.cst;
    }

    @Override // com.android.dx.rop.code.Insn
    public String getInlineString() {
        return this.cst.toHuman();
    }
}
