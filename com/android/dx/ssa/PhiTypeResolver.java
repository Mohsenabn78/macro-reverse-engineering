package com.android.dx.ssa;

import com.android.dx.cf.code.Merger;
import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.type.TypeBearer;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes2.dex */
public class PhiTypeResolver {
    SsaMethod ssaMeth;
    private final BitSet worklist;

    private PhiTypeResolver(SsaMethod ssaMethod) {
        this.ssaMeth = ssaMethod;
        this.worklist = new BitSet(ssaMethod.getRegCount());
    }

    private static boolean equalsHandlesNulls(LocalItem localItem, LocalItem localItem2) {
        if (localItem != localItem2 && (localItem == null || !localItem.equals(localItem2))) {
            return false;
        }
        return true;
    }

    public static void process(SsaMethod ssaMethod) {
        new PhiTypeResolver(ssaMethod).run();
    }

    private void run() {
        int regCount = this.ssaMeth.getRegCount();
        for (int i4 = 0; i4 < regCount; i4++) {
            SsaInsn definitionForRegister = this.ssaMeth.getDefinitionForRegister(i4);
            if (definitionForRegister != null && definitionForRegister.getResult().getBasicType() == 0) {
                this.worklist.set(i4);
            }
        }
        while (true) {
            int nextSetBit = this.worklist.nextSetBit(0);
            if (nextSetBit >= 0) {
                this.worklist.clear(nextSetBit);
                if (resolveResultType((PhiInsn) this.ssaMeth.getDefinitionForRegister(nextSetBit))) {
                    List<SsaInsn> useListForRegister = this.ssaMeth.getUseListForRegister(nextSetBit);
                    int size = useListForRegister.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        SsaInsn ssaInsn = useListForRegister.get(i5);
                        RegisterSpec result = ssaInsn.getResult();
                        if (result != null && (ssaInsn instanceof PhiInsn)) {
                            this.worklist.set(result.getReg());
                        }
                    }
                }
            } else {
                return;
            }
        }
    }

    boolean resolveResultType(PhiInsn phiInsn) {
        phiInsn.updateSourcesToDefinitions(this.ssaMeth);
        RegisterSpecList sources = phiInsn.getSources();
        int size = sources.size();
        LocalItem localItem = null;
        int i4 = -1;
        RegisterSpec registerSpec = null;
        for (int i5 = 0; i5 < size; i5++) {
            RegisterSpec registerSpec2 = sources.get(i5);
            if (registerSpec2.getBasicType() != 0) {
                i4 = i5;
                registerSpec = registerSpec2;
            }
        }
        if (registerSpec == null) {
            return false;
        }
        LocalItem localItem2 = registerSpec.getLocalItem();
        TypeBearer type = registerSpec.getType();
        boolean z3 = true;
        for (int i6 = 0; i6 < size; i6++) {
            if (i6 != i4) {
                RegisterSpec registerSpec3 = sources.get(i6);
                if (registerSpec3.getBasicType() != 0) {
                    if (z3 && equalsHandlesNulls(localItem2, registerSpec3.getLocalItem())) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    type = Merger.mergeType(type, registerSpec3.getType());
                }
            }
        }
        if (type != null) {
            if (z3) {
                localItem = localItem2;
            }
            RegisterSpec result = phiInsn.getResult();
            if (result.getTypeBearer() == type && equalsHandlesNulls(localItem, result.getLocalItem())) {
                return false;
            }
            phiInsn.changeResultType(type, localItem);
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i7 = 0; i7 < size; i7++) {
            sb.append(sources.get(i7).toString());
            sb.append(' ');
        }
        throw new RuntimeException("Couldn't map types in phi insn:" + ((Object) sb));
    }
}
