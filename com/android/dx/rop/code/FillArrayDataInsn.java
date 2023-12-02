package com.android.dx.rop.code;

import com.android.dx.rop.code.Insn;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class FillArrayDataInsn extends Insn {
    private final Constant arrayType;
    private final ArrayList<Constant> initValues;

    public FillArrayDataInsn(Rop rop, SourcePosition sourcePosition, RegisterSpecList registerSpecList, ArrayList<Constant> arrayList, Constant constant) {
        super(rop, sourcePosition, null, registerSpecList);
        if (rop.getBranchingness() == 1) {
            this.initValues = arrayList;
            this.arrayType = constant;
            return;
        }
        throw new IllegalArgumentException("bogus branchingness");
    }

    @Override // com.android.dx.rop.code.Insn
    public void accept(Insn.Visitor visitor) {
        visitor.visitFillArrayDataInsn(this);
    }

    @Override // com.android.dx.rop.code.Insn
    public TypeList getCatches() {
        return StdTypeList.EMPTY;
    }

    public Constant getConstant() {
        return this.arrayType;
    }

    public ArrayList<Constant> getInitValues() {
        return this.initValues;
    }

    @Override // com.android.dx.rop.code.Insn
    public Insn withAddedCatch(Type type) {
        throw new UnsupportedOperationException("unsupported");
    }

    @Override // com.android.dx.rop.code.Insn
    public Insn withNewRegisters(RegisterSpec registerSpec, RegisterSpecList registerSpecList) {
        return new FillArrayDataInsn(getOpcode(), getPosition(), registerSpecList, this.initValues, this.arrayType);
    }

    @Override // com.android.dx.rop.code.Insn
    public Insn withRegisterOffset(int i4) {
        return new FillArrayDataInsn(getOpcode(), getPosition(), getSources().withOffset(i4), this.initValues, this.arrayType);
    }
}
