package com.android.dx.dex.code;

import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.rop.cst.Constant;

/* loaded from: classes2.dex */
public final class CstInsn extends FixedSizeInsn {
    private int classIndex;
    private final Constant constant;
    private int index;

    public CstInsn(Dop dop, SourcePosition sourcePosition, RegisterSpecList registerSpecList, Constant constant) {
        super(dop, sourcePosition, registerSpecList);
        if (constant != null) {
            this.constant = constant;
            this.index = -1;
            this.classIndex = -1;
            return;
        }
        throw new NullPointerException("constant == null");
    }

    @Override // com.android.dx.dex.code.DalvInsn
    protected String argString() {
        return this.constant.toHuman();
    }

    public int getClassIndex() {
        int i4 = this.classIndex;
        if (i4 >= 0) {
            return i4;
        }
        throw new RuntimeException("class index not yet set");
    }

    public Constant getConstant() {
        return this.constant;
    }

    public int getIndex() {
        int i4 = this.index;
        if (i4 >= 0) {
            return i4;
        }
        throw new RuntimeException("index not yet set for " + this.constant);
    }

    public boolean hasClassIndex() {
        if (this.classIndex >= 0) {
            return true;
        }
        return false;
    }

    public boolean hasIndex() {
        if (this.index >= 0) {
            return true;
        }
        return false;
    }

    public void setClassIndex(int i4) {
        if (i4 >= 0) {
            if (this.classIndex < 0) {
                this.classIndex = i4;
                return;
            }
            throw new RuntimeException("class index already set");
        }
        throw new IllegalArgumentException("index < 0");
    }

    public void setIndex(int i4) {
        if (i4 >= 0) {
            if (this.index < 0) {
                this.index = i4;
                return;
            }
            throw new RuntimeException("index already set");
        }
        throw new IllegalArgumentException("index < 0");
    }

    @Override // com.android.dx.dex.code.DalvInsn
    public DalvInsn withOpcode(Dop dop) {
        CstInsn cstInsn = new CstInsn(dop, getPosition(), getRegisters(), this.constant);
        int i4 = this.index;
        if (i4 >= 0) {
            cstInsn.setIndex(i4);
        }
        int i5 = this.classIndex;
        if (i5 >= 0) {
            cstInsn.setClassIndex(i5);
        }
        return cstInsn;
    }

    @Override // com.android.dx.dex.code.DalvInsn
    public DalvInsn withRegisters(RegisterSpecList registerSpecList) {
        CstInsn cstInsn = new CstInsn(getOpcode(), getPosition(), registerSpecList, this.constant);
        int i4 = this.index;
        if (i4 >= 0) {
            cstInsn.setIndex(i4);
        }
        int i5 = this.classIndex;
        if (i5 >= 0) {
            cstInsn.setClassIndex(i5);
        }
        return cstInsn;
    }
}
