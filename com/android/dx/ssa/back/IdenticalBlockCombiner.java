package com.android.dx.ssa.back;

import com.android.dx.rop.code.BasicBlock;
import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.util.IntList;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class IdenticalBlockCombiner {
    private final BasicBlockList blocks;
    private final BasicBlockList newBlocks;
    private final RopMethod ropMethod;

    public IdenticalBlockCombiner(RopMethod ropMethod) {
        this.ropMethod = ropMethod;
        BasicBlockList blocks = ropMethod.getBlocks();
        this.blocks = blocks;
        this.newBlocks = blocks.getMutableCopy();
    }

    private void combineBlocks(int i4, IntList intList) {
        int size = intList.size();
        for (int i5 = 0; i5 < size; i5++) {
            int i6 = intList.get(i5);
            IntList labelToPredecessors = this.ropMethod.labelToPredecessors(this.blocks.labelToBlock(i6).getLabel());
            int size2 = labelToPredecessors.size();
            for (int i7 = 0; i7 < size2; i7++) {
                replaceSucc(this.newBlocks.labelToBlock(labelToPredecessors.get(i7)), i6, i4);
            }
        }
    }

    private static boolean compareInsns(BasicBlock basicBlock, BasicBlock basicBlock2) {
        return basicBlock.getInsns().contentEquals(basicBlock2.getInsns());
    }

    private void replaceSucc(BasicBlock basicBlock, int i4, int i5) {
        IntList mutableCopy = basicBlock.getSuccessors().mutableCopy();
        mutableCopy.set(mutableCopy.indexOf(i4), i5);
        int primarySuccessor = basicBlock.getPrimarySuccessor();
        if (primarySuccessor != i4) {
            i5 = primarySuccessor;
        }
        mutableCopy.setImmutable();
        BasicBlock basicBlock2 = new BasicBlock(basicBlock.getLabel(), basicBlock.getInsns(), mutableCopy, i5);
        BasicBlockList basicBlockList = this.newBlocks;
        basicBlockList.set(basicBlockList.indexOfLabel(basicBlock.getLabel()), basicBlock2);
    }

    public RopMethod process() {
        int size = this.blocks.size();
        BitSet bitSet = new BitSet(this.blocks.getMaxLabel());
        for (int i4 = 0; i4 < size; i4++) {
            BasicBlock basicBlock = this.blocks.get(i4);
            if (!bitSet.get(basicBlock.getLabel())) {
                IntList labelToPredecessors = this.ropMethod.labelToPredecessors(basicBlock.getLabel());
                int size2 = labelToPredecessors.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    int i6 = labelToPredecessors.get(i5);
                    BasicBlock labelToBlock = this.blocks.labelToBlock(i6);
                    if (!bitSet.get(i6) && labelToBlock.getSuccessors().size() <= 1 && labelToBlock.getFirstInsn().getOpcode().getOpcode() != 55) {
                        IntList intList = new IntList();
                        for (int i7 = i5 + 1; i7 < size2; i7++) {
                            int i8 = labelToPredecessors.get(i7);
                            BasicBlock labelToBlock2 = this.blocks.labelToBlock(i8);
                            if (labelToBlock2.getSuccessors().size() == 1 && compareInsns(labelToBlock, labelToBlock2)) {
                                intList.add(i8);
                                bitSet.set(i8);
                            }
                        }
                        combineBlocks(i6, intList);
                    }
                }
            }
        }
        for (int i9 = size - 1; i9 >= 0; i9--) {
            if (bitSet.get(this.newBlocks.get(i9).getLabel())) {
                this.newBlocks.set(i9, (BasicBlock) null);
            }
        }
        this.newBlocks.shrinkToFit();
        this.newBlocks.setImmutable();
        return new RopMethod(this.newBlocks, this.ropMethod.getFirstLabel());
    }
}
