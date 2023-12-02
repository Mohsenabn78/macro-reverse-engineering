package com.android.dx.rop.code;

import com.android.dx.util.Bits;
import com.android.dx.util.IntList;

/* loaded from: classes2.dex */
public final class LocalVariableExtractor {
    private final BasicBlockList blocks;
    private final RopMethod method;
    private final LocalVariableInfo resultInfo;
    private final int[] workSet;

    private LocalVariableExtractor(RopMethod ropMethod) {
        if (ropMethod != null) {
            BasicBlockList blocks = ropMethod.getBlocks();
            int maxLabel = blocks.getMaxLabel();
            this.method = ropMethod;
            this.blocks = blocks;
            this.resultInfo = new LocalVariableInfo(ropMethod);
            this.workSet = Bits.makeBitSet(maxLabel);
            return;
        }
        throw new NullPointerException("method == null");
    }

    private LocalVariableInfo doit() {
        int firstLabel = this.method.getFirstLabel();
        while (firstLabel >= 0) {
            Bits.clear(this.workSet, firstLabel);
            processBlock(firstLabel);
            firstLabel = Bits.findFirst(this.workSet, 0);
        }
        this.resultInfo.setImmutable();
        return this.resultInfo;
    }

    public static LocalVariableInfo extract(RopMethod ropMethod) {
        return new LocalVariableExtractor(ropMethod).doit();
    }

    private void processBlock(int i4) {
        boolean z3;
        RegisterSpecSet registerSpecSet;
        RegisterSpecSet mutableCopyOfStarts = this.resultInfo.mutableCopyOfStarts(i4);
        BasicBlock labelToBlock = this.blocks.labelToBlock(i4);
        InsnList insns = labelToBlock.getInsns();
        int size = insns.size();
        if (labelToBlock.hasExceptionHandlers() && insns.getLast().getResult() != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        int i5 = size - 1;
        RegisterSpecSet registerSpecSet2 = mutableCopyOfStarts;
        for (int i6 = 0; i6 < size; i6++) {
            if (z3 && i6 == i5) {
                registerSpecSet2.setImmutable();
                registerSpecSet2 = registerSpecSet2.mutableCopy();
            }
            Insn insn = insns.get(i6);
            RegisterSpec localAssignment = insn.getLocalAssignment();
            if (localAssignment == null) {
                RegisterSpec result = insn.getResult();
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
                    this.resultInfo.addAssignment(insn, withSimpleType);
                    registerSpecSet2.put(withSimpleType);
                }
            }
        }
        registerSpecSet2.setImmutable();
        IntList successors = labelToBlock.getSuccessors();
        int size2 = successors.size();
        int primarySuccessor = labelToBlock.getPrimarySuccessor();
        for (int i7 = 0; i7 < size2; i7++) {
            int i8 = successors.get(i7);
            if (i8 == primarySuccessor) {
                registerSpecSet = registerSpecSet2;
            } else {
                registerSpecSet = mutableCopyOfStarts;
            }
            if (this.resultInfo.mergeStarts(i8, registerSpecSet)) {
                Bits.set(this.workSet, i8);
            }
        }
    }
}
