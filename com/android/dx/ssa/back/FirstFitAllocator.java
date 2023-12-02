package com.android.dx.ssa.back;

import com.android.dx.rop.code.CstInsn;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.ssa.BasicRegisterMapper;
import com.android.dx.ssa.NormalSsaInsn;
import com.android.dx.ssa.RegisterMapper;
import com.android.dx.ssa.SsaMethod;
import com.android.dx.util.BitIntSet;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class FirstFitAllocator extends RegisterAllocator {
    private static final boolean PRESLOT_PARAMS = true;
    private final BitSet mapped;

    public FirstFitAllocator(SsaMethod ssaMethod, InterferenceGraph interferenceGraph) {
        super(ssaMethod, interferenceGraph);
        this.mapped = new BitSet(ssaMethod.getRegCount());
    }

    private int paramNumberFromMoveParam(NormalSsaInsn normalSsaInsn) {
        return ((CstInteger) ((CstInsn) normalSsaInsn.getOriginalRopInsn()).getConstant()).getValue();
    }

    @Override // com.android.dx.ssa.back.RegisterAllocator
    public RegisterMapper allocateRegisters() {
        int i4;
        boolean z3;
        int regCount = this.ssaMeth.getRegCount();
        BasicRegisterMapper basicRegisterMapper = new BasicRegisterMapper(regCount);
        int paramWidth = this.ssaMeth.getParamWidth();
        for (int i5 = 0; i5 < regCount; i5++) {
            if (!this.mapped.get(i5)) {
                int categoryForSsaReg = getCategoryForSsaReg(i5);
                BitIntSet bitIntSet = new BitIntSet(regCount);
                this.interference.mergeInterferenceSet(i5, bitIntSet);
                if (isDefinitionMoveParam(i5)) {
                    i4 = paramNumberFromMoveParam((NormalSsaInsn) this.ssaMeth.getDefinitionForRegister(i5));
                    basicRegisterMapper.addMapping(i5, i4, categoryForSsaReg);
                    z3 = true;
                } else {
                    basicRegisterMapper.addMapping(i5, paramWidth, categoryForSsaReg);
                    i4 = paramWidth;
                    z3 = false;
                }
                for (int i6 = i5 + 1; i6 < regCount; i6++) {
                    if (!this.mapped.get(i6) && !isDefinitionMoveParam(i6) && !bitIntSet.has(i6) && (!z3 || categoryForSsaReg >= getCategoryForSsaReg(i6))) {
                        this.interference.mergeInterferenceSet(i6, bitIntSet);
                        categoryForSsaReg = Math.max(categoryForSsaReg, getCategoryForSsaReg(i6));
                        basicRegisterMapper.addMapping(i6, i4, categoryForSsaReg);
                        this.mapped.set(i6);
                    }
                }
                this.mapped.set(i5);
                if (!z3) {
                    paramWidth += categoryForSsaReg;
                }
            }
        }
        return basicRegisterMapper;
    }

    @Override // com.android.dx.ssa.back.RegisterAllocator
    public boolean wantsParamsMovedHigh() {
        return true;
    }
}
