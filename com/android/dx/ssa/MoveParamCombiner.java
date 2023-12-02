package com.android.dx.ssa;

import com.android.dx.rop.code.CstInsn;
import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.ssa.SsaInsn;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes2.dex */
public class MoveParamCombiner {
    private final SsaMethod ssaMeth;

    private MoveParamCombiner(SsaMethod ssaMethod) {
        this.ssaMeth = ssaMethod;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getParamIndex(NormalSsaInsn normalSsaInsn) {
        return ((CstInteger) ((CstInsn) normalSsaInsn.getOriginalRopInsn()).getConstant()).getValue();
    }

    public static void process(SsaMethod ssaMethod) {
        new MoveParamCombiner(ssaMethod).run();
    }

    private void run() {
        final RegisterSpec[] registerSpecArr = new RegisterSpec[this.ssaMeth.getParamWidth()];
        final HashSet hashSet = new HashSet();
        this.ssaMeth.forEachInsn(new SsaInsn.Visitor() { // from class: com.android.dx.ssa.MoveParamCombiner.1
            @Override // com.android.dx.ssa.SsaInsn.Visitor
            public void visitNonMoveInsn(NormalSsaInsn normalSsaInsn) {
                if (normalSsaInsn.getOpcode().getOpcode() == 3) {
                    int paramIndex = MoveParamCombiner.this.getParamIndex(normalSsaInsn);
                    RegisterSpec[] registerSpecArr2 = registerSpecArr;
                    final RegisterSpec registerSpec = registerSpecArr2[paramIndex];
                    if (registerSpec == null) {
                        registerSpecArr2[paramIndex] = normalSsaInsn.getResult();
                        return;
                    }
                    final RegisterSpec result = normalSsaInsn.getResult();
                    LocalItem localItem = registerSpec.getLocalItem();
                    LocalItem localItem2 = result.getLocalItem();
                    if (localItem == null) {
                        localItem = localItem2;
                    } else if (localItem2 != null && !localItem.equals(localItem2)) {
                        return;
                    }
                    MoveParamCombiner.this.ssaMeth.getDefinitionForRegister(registerSpec.getReg()).setResultLocal(localItem);
                    RegisterMapper registerMapper = new RegisterMapper() { // from class: com.android.dx.ssa.MoveParamCombiner.1.1
                        @Override // com.android.dx.ssa.RegisterMapper
                        public int getNewRegisterCount() {
                            return MoveParamCombiner.this.ssaMeth.getRegCount();
                        }

                        @Override // com.android.dx.ssa.RegisterMapper
                        public RegisterSpec map(RegisterSpec registerSpec2) {
                            if (registerSpec2.getReg() == result.getReg()) {
                                return registerSpec;
                            }
                            return registerSpec2;
                        }
                    };
                    List<SsaInsn> useListForRegister = MoveParamCombiner.this.ssaMeth.getUseListForRegister(result.getReg());
                    for (int size = useListForRegister.size() - 1; size >= 0; size--) {
                        useListForRegister.get(size).mapSourceRegisters(registerMapper);
                    }
                    hashSet.add(normalSsaInsn);
                }
            }

            @Override // com.android.dx.ssa.SsaInsn.Visitor
            public void visitMoveInsn(NormalSsaInsn normalSsaInsn) {
            }

            @Override // com.android.dx.ssa.SsaInsn.Visitor
            public void visitPhiInsn(PhiInsn phiInsn) {
            }
        });
        this.ssaMeth.deleteInsns(hashSet);
    }
}
