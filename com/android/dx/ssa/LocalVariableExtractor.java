package com.android.dx.ssa;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecSet;
import com.android.dx.util.IntList;
import java.util.ArrayList;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class LocalVariableExtractor {
    private final ArrayList<SsaBasicBlock> blocks;
    private final SsaMethod method;
    private final LocalVariableInfo resultInfo;
    private final BitSet workSet;

    private LocalVariableExtractor(SsaMethod ssaMethod) {
        if (ssaMethod != null) {
            ArrayList<SsaBasicBlock> blocks = ssaMethod.getBlocks();
            this.method = ssaMethod;
            this.blocks = blocks;
            this.resultInfo = new LocalVariableInfo(ssaMethod);
            this.workSet = new BitSet(blocks.size());
            return;
        }
        throw new NullPointerException("method == null");
    }

    private LocalVariableInfo doit() {
        if (this.method.getRegCount() > 0) {
            int entryBlockIndex = this.method.getEntryBlockIndex();
            while (entryBlockIndex >= 0) {
                this.workSet.clear(entryBlockIndex);
                processBlock(entryBlockIndex);
                entryBlockIndex = this.workSet.nextSetBit(0);
            }
        }
        this.resultInfo.setImmutable();
        return this.resultInfo;
    }

    public static LocalVariableInfo extract(SsaMethod ssaMethod) {
        return new LocalVariableExtractor(ssaMethod).doit();
    }

    private void processBlock(int i4) {
        boolean z3;
        RegisterSpecSet registerSpecSet;
        RegisterSpecSet mutableCopyOfStarts = this.resultInfo.mutableCopyOfStarts(i4);
        SsaBasicBlock ssaBasicBlock = this.blocks.get(i4);
        ArrayList<SsaInsn> insns = ssaBasicBlock.getInsns();
        int size = insns.size();
        if (i4 == this.method.getExitBlockIndex()) {
            return;
        }
        int i5 = size - 1;
        SsaInsn ssaInsn = insns.get(i5);
        boolean z4 = true;
        if (ssaInsn.getOriginalRopInsn().getCatches().size() != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        z4 = (!z3 || ssaInsn.getResult() == null) ? false : false;
        RegisterSpecSet registerSpecSet2 = mutableCopyOfStarts;
        for (int i6 = 0; i6 < size; i6++) {
            if (z4 && i6 == i5) {
                registerSpecSet2.setImmutable();
                registerSpecSet2 = registerSpecSet2.mutableCopy();
            }
            SsaInsn ssaInsn2 = insns.get(i6);
            RegisterSpec localAssignment = ssaInsn2.getLocalAssignment();
            if (localAssignment == null) {
                RegisterSpec result = ssaInsn2.getResult();
                if (result != null && registerSpecSet2.get(result.getReg()) != null) {
                    registerSpecSet2.remove(registerSpecSet2.get(result.getReg()));
                }
            } else {
                RegisterSpec withSimpleType = localAssignment.withSimpleType();
                if (!withSimpleType.equals(registerSpecSet2.get(withSimpleType))) {
                    RegisterSpec localItemToSpec = registerSpecSet2.localItemToSpec(withSimpleType.getLocalItem());
                    if (localItemToSpec != null && localItemToSpec.getReg() != withSimpleType.getReg()) {
                        registerSpecSet2.remove(localItemToSpec);
                    }
                    this.resultInfo.addAssignment(ssaInsn2, withSimpleType);
                    registerSpecSet2.put(withSimpleType);
                }
            }
        }
        registerSpecSet2.setImmutable();
        IntList successorList = ssaBasicBlock.getSuccessorList();
        int size2 = successorList.size();
        int primarySuccessorIndex = ssaBasicBlock.getPrimarySuccessorIndex();
        for (int i7 = 0; i7 < size2; i7++) {
            int i8 = successorList.get(i7);
            if (i8 == primarySuccessorIndex) {
                registerSpecSet = registerSpecSet2;
            } else {
                registerSpecSet = mutableCopyOfStarts;
            }
            if (this.resultInfo.mergeStarts(i8, registerSpecSet)) {
                this.workSet.set(i8);
            }
        }
    }
}
