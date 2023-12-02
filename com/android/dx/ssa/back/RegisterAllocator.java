package com.android.dx.ssa.back;

import com.android.dx.rop.code.PlainInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rops;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.ssa.NormalSsaInsn;
import com.android.dx.ssa.RegisterMapper;
import com.android.dx.ssa.SsaBasicBlock;
import com.android.dx.ssa.SsaInsn;
import com.android.dx.ssa.SsaMethod;
import com.android.dx.util.IntIterator;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public abstract class RegisterAllocator {
    protected final InterferenceGraph interference;
    protected final SsaMethod ssaMeth;

    public RegisterAllocator(SsaMethod ssaMethod, InterferenceGraph interferenceGraph) {
        this.ssaMeth = ssaMethod;
        this.interference = interferenceGraph;
    }

    public abstract RegisterMapper allocateRegisters();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getCategoryForSsaReg(int i4) {
        SsaInsn definitionForRegister = this.ssaMeth.getDefinitionForRegister(i4);
        if (definitionForRegister == null) {
            return 1;
        }
        return definitionForRegister.getResult().getCategory();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RegisterSpec getDefinitionSpecForSsaReg(int i4) {
        SsaInsn definitionForRegister = this.ssaMeth.getDefinitionForRegister(i4);
        if (definitionForRegister == null) {
            return null;
        }
        return definitionForRegister.getResult();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RegisterSpec insertMoveBefore(SsaInsn ssaInsn, RegisterSpec registerSpec) {
        SsaBasicBlock block = ssaInsn.getBlock();
        ArrayList<SsaInsn> insns = block.getInsns();
        int indexOf = insns.indexOf(ssaInsn);
        if (indexOf >= 0) {
            if (indexOf == insns.size() - 1) {
                RegisterSpec make = RegisterSpec.make(this.ssaMeth.makeNewSsaReg(), registerSpec.getTypeBearer());
                insns.add(indexOf, SsaInsn.makeFromRop(new PlainInsn(Rops.opMove(make.getType()), SourcePosition.NO_INFO, make, RegisterSpecList.make(registerSpec)), block));
                int reg = make.getReg();
                IntIterator it = block.getLiveOutRegs().iterator();
                while (it.hasNext()) {
                    this.interference.add(reg, it.next());
                }
                RegisterSpecList sources = ssaInsn.getSources();
                int size = sources.size();
                for (int i4 = 0; i4 < size; i4++) {
                    this.interference.add(reg, sources.get(i4).getReg());
                }
                this.ssaMeth.onInsnsChanged();
                return make;
            }
            throw new IllegalArgumentException("Adding move here not supported:" + ssaInsn.toHuman());
        }
        throw new IllegalArgumentException("specified insn is not in this block");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isDefinitionMoveParam(int i4) {
        SsaInsn definitionForRegister = this.ssaMeth.getDefinitionForRegister(i4);
        if (!(definitionForRegister instanceof NormalSsaInsn) || ((NormalSsaInsn) definitionForRegister).getOpcode().getOpcode() != 3) {
            return false;
        }
        return true;
    }

    public abstract boolean wantsParamsMovedHigh();
}
