package com.android.dx.ssa;

import com.android.dx.rop.code.BasicBlock;
import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.InsnList;
import com.android.dx.rop.code.PlainInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.rop.code.Rops;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.ssa.PhiInsn;
import com.android.dx.ssa.SsaInsn;
import com.android.dx.util.Hex;
import com.android.dx.util.IntList;
import com.android.dx.util.IntSet;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes2.dex */
public final class SsaBasicBlock {
    public static final Comparator<SsaBasicBlock> LABEL_COMPARATOR = new LabelComparator();
    private int index;
    private IntSet liveIn;
    private IntSet liveOut;
    private SsaMethod parent;
    private BitSet predecessors;
    private int ropLabel;
    private BitSet successors;
    private int primarySuccessor = -1;
    private int movesFromPhisAtEnd = 0;
    private int movesFromPhisAtBeginning = 0;
    private int reachable = -1;
    private ArrayList<SsaInsn> insns = new ArrayList<>();
    private IntList successorList = new IntList();
    private final ArrayList<SsaBasicBlock> domChildren = new ArrayList<>();

    /* loaded from: classes2.dex */
    public static final class LabelComparator implements Comparator<SsaBasicBlock> {
        @Override // java.util.Comparator
        public int compare(SsaBasicBlock ssaBasicBlock, SsaBasicBlock ssaBasicBlock2) {
            int i4 = ssaBasicBlock.ropLabel;
            int i5 = ssaBasicBlock2.ropLabel;
            if (i4 < i5) {
                return -1;
            }
            return i4 > i5 ? 1 : 0;
        }
    }

    /* loaded from: classes2.dex */
    public interface Visitor {
        void visitBlock(SsaBasicBlock ssaBasicBlock, SsaBasicBlock ssaBasicBlock2);
    }

    public SsaBasicBlock(int i4, int i5, SsaMethod ssaMethod) {
        this.parent = ssaMethod;
        this.index = i4;
        this.ropLabel = i5;
        this.predecessors = new BitSet(ssaMethod.getBlocks().size());
        this.successors = new BitSet(ssaMethod.getBlocks().size());
    }

    private static boolean checkRegUsed(BitSet bitSet, RegisterSpec registerSpec) {
        int reg = registerSpec.getReg();
        int category = registerSpec.getCategory();
        if (bitSet.get(reg)) {
            return true;
        }
        if (category == 2 && bitSet.get(reg + 1)) {
            return true;
        }
        return false;
    }

    private int getCountPhiInsns() {
        int size = this.insns.size();
        int i4 = 0;
        while (i4 < size && (this.insns.get(i4) instanceof PhiInsn)) {
            i4++;
        }
        return i4;
    }

    public static SsaBasicBlock newFromRop(RopMethod ropMethod, int i4, SsaMethod ssaMethod) {
        int indexOfLabel;
        BasicBlockList blocks = ropMethod.getBlocks();
        BasicBlock basicBlock = blocks.get(i4);
        SsaBasicBlock ssaBasicBlock = new SsaBasicBlock(i4, basicBlock.getLabel(), ssaMethod);
        InsnList insns = basicBlock.getInsns();
        ssaBasicBlock.insns.ensureCapacity(insns.size());
        int size = insns.size();
        for (int i5 = 0; i5 < size; i5++) {
            ssaBasicBlock.insns.add(new NormalSsaInsn(insns.get(i5), ssaBasicBlock));
        }
        ssaBasicBlock.predecessors = SsaMethod.bitSetFromLabelList(blocks, ropMethod.labelToPredecessors(basicBlock.getLabel()));
        ssaBasicBlock.successors = SsaMethod.bitSetFromLabelList(blocks, basicBlock.getSuccessors());
        IntList indexListFromLabelList = SsaMethod.indexListFromLabelList(blocks, basicBlock.getSuccessors());
        ssaBasicBlock.successorList = indexListFromLabelList;
        if (indexListFromLabelList.size() != 0) {
            int primarySuccessor = basicBlock.getPrimarySuccessor();
            if (primarySuccessor < 0) {
                indexOfLabel = -1;
            } else {
                indexOfLabel = blocks.indexOfLabel(primarySuccessor);
            }
            ssaBasicBlock.primarySuccessor = indexOfLabel;
        }
        return ssaBasicBlock;
    }

    private void scheduleUseBeforeAssigned(List<SsaInsn> list) {
        SsaInsn ssaInsn;
        BitSet bitSet = new BitSet(this.parent.getRegCount());
        BitSet bitSet2 = new BitSet(this.parent.getRegCount());
        int size = list.size();
        int i4 = 0;
        while (i4 < size) {
            for (int i5 = i4; i5 < size; i5++) {
                setRegsUsed(bitSet, list.get(i5).getSources().get(0));
                setRegsUsed(bitSet2, list.get(i5).getResult());
            }
            int i6 = i4;
            int i7 = i6;
            while (i6 < size) {
                if (!checkRegUsed(bitSet, list.get(i6).getResult())) {
                    Collections.swap(list, i6, i7);
                    i7++;
                }
                i6++;
            }
            if (i4 == i7) {
                int i8 = i7;
                while (true) {
                    if (i8 < size) {
                        ssaInsn = list.get(i8);
                        if (checkRegUsed(bitSet, ssaInsn.getResult()) && checkRegUsed(bitSet2, ssaInsn.getSources().get(0))) {
                            Collections.swap(list, i7, i8);
                            break;
                        }
                        i8++;
                    } else {
                        ssaInsn = null;
                        break;
                    }
                }
                RegisterSpec result = ssaInsn.getResult();
                RegisterSpec withReg = result.withReg(this.parent.borrowSpareRegister(result.getCategory()));
                Rop opMove = Rops.opMove(result.getType());
                SourcePosition sourcePosition = SourcePosition.NO_INFO;
                int i9 = i7 + 1;
                list.add(i7, new NormalSsaInsn(new PlainInsn(opMove, sourcePosition, withReg, ssaInsn.getSources()), this));
                list.set(i9, new NormalSsaInsn(new PlainInsn(Rops.opMove(result.getType()), sourcePosition, result, RegisterSpecList.make(withReg)), this));
                size = list.size();
                i4 = i9;
            } else {
                i4 = i7;
            }
            bitSet.clear();
            bitSet2.clear();
        }
    }

    private static void setRegsUsed(BitSet bitSet, RegisterSpec registerSpec) {
        bitSet.set(registerSpec.getReg());
        if (registerSpec.getCategory() > 1) {
            bitSet.set(registerSpec.getReg() + 1);
        }
    }

    public void addDomChild(SsaBasicBlock ssaBasicBlock) {
        this.domChildren.add(ssaBasicBlock);
    }

    public void addInsnToHead(Insn insn) {
        SsaInsn makeFromRop = SsaInsn.makeFromRop(insn, this);
        this.insns.add(getCountPhiInsns(), makeFromRop);
        this.parent.onInsnAdded(makeFromRop);
    }

    public void addLiveIn(int i4) {
        if (this.liveIn == null) {
            this.liveIn = SetFactory.makeLivenessSet(this.parent.getRegCount());
        }
        this.liveIn.add(i4);
    }

    public void addLiveOut(int i4) {
        if (this.liveOut == null) {
            this.liveOut = SetFactory.makeLivenessSet(this.parent.getRegCount());
        }
        this.liveOut.add(i4);
    }

    public void addMoveToBeginning(RegisterSpec registerSpec, RegisterSpec registerSpec2) {
        if (registerSpec.getReg() == registerSpec2.getReg()) {
            return;
        }
        this.insns.add(getCountPhiInsns(), new NormalSsaInsn(new PlainInsn(Rops.opMove(registerSpec.getType()), SourcePosition.NO_INFO, registerSpec, RegisterSpecList.make(registerSpec2)), this));
        this.movesFromPhisAtBeginning++;
    }

    public void addMoveToEnd(RegisterSpec registerSpec, RegisterSpec registerSpec2) {
        ArrayList<SsaInsn> arrayList;
        ArrayList<SsaInsn> arrayList2;
        if (registerSpec.getReg() == registerSpec2.getReg()) {
            return;
        }
        NormalSsaInsn normalSsaInsn = (NormalSsaInsn) this.insns.get(arrayList.size() - 1);
        if (normalSsaInsn.getResult() == null && normalSsaInsn.getSources().size() <= 0) {
            NormalSsaInsn normalSsaInsn2 = new NormalSsaInsn(new PlainInsn(Rops.opMove(registerSpec.getType()), SourcePosition.NO_INFO, registerSpec, RegisterSpecList.make(registerSpec2)), this);
            this.insns.add(arrayList2.size() - 1, normalSsaInsn2);
            this.movesFromPhisAtEnd++;
            return;
        }
        int nextSetBit = this.successors.nextSetBit(0);
        while (nextSetBit >= 0) {
            this.parent.getBlocks().get(nextSetBit).addMoveToBeginning(registerSpec, registerSpec2);
            nextSetBit = this.successors.nextSetBit(nextSetBit + 1);
        }
    }

    public void addPhiInsnForReg(int i4) {
        this.insns.add(0, new PhiInsn(i4, this));
    }

    public void exitBlockFixup(SsaBasicBlock ssaBasicBlock) {
        if (this != ssaBasicBlock && this.successorList.size() == 0) {
            this.successors.set(ssaBasicBlock.index);
            this.successorList.add(ssaBasicBlock.index);
            this.primarySuccessor = ssaBasicBlock.index;
            ssaBasicBlock.predecessors.set(this.index);
        }
    }

    public void forEachInsn(SsaInsn.Visitor visitor) {
        int size = this.insns.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.insns.get(i4).accept(visitor);
        }
    }

    public void forEachPhiInsn(PhiInsn.Visitor visitor) {
        int size = this.insns.size();
        for (int i4 = 0; i4 < size; i4++) {
            SsaInsn ssaInsn = this.insns.get(i4);
            if (ssaInsn instanceof PhiInsn) {
                visitor.visitPhiInsn((PhiInsn) ssaInsn);
            } else {
                return;
            }
        }
    }

    public ArrayList<SsaBasicBlock> getDomChildren() {
        return this.domChildren;
    }

    public int getIndex() {
        return this.index;
    }

    public ArrayList<SsaInsn> getInsns() {
        return this.insns;
    }

    public IntSet getLiveInRegs() {
        if (this.liveIn == null) {
            this.liveIn = SetFactory.makeLivenessSet(this.parent.getRegCount());
        }
        return this.liveIn;
    }

    public IntSet getLiveOutRegs() {
        if (this.liveOut == null) {
            this.liveOut = SetFactory.makeLivenessSet(this.parent.getRegCount());
        }
        return this.liveOut;
    }

    public SsaMethod getParent() {
        return this.parent;
    }

    public List<SsaInsn> getPhiInsns() {
        return this.insns.subList(0, getCountPhiInsns());
    }

    public BitSet getPredecessors() {
        return this.predecessors;
    }

    public SsaBasicBlock getPrimarySuccessor() {
        if (this.primarySuccessor < 0) {
            return null;
        }
        return this.parent.getBlocks().get(this.primarySuccessor);
    }

    public int getPrimarySuccessorIndex() {
        return this.primarySuccessor;
    }

    public int getPrimarySuccessorRopLabel() {
        return this.parent.blockIndexToRopLabel(this.primarySuccessor);
    }

    public int getRopLabel() {
        return this.ropLabel;
    }

    public String getRopLabelString() {
        return Hex.u2(this.ropLabel);
    }

    public IntList getRopLabelSuccessorList() {
        IntList intList = new IntList(this.successorList.size());
        int size = this.successorList.size();
        for (int i4 = 0; i4 < size; i4++) {
            intList.add(this.parent.blockIndexToRopLabel(this.successorList.get(i4)));
        }
        return intList;
    }

    public IntList getSuccessorList() {
        return this.successorList;
    }

    public BitSet getSuccessors() {
        return this.successors;
    }

    public SsaBasicBlock insertNewPredecessor() {
        SsaBasicBlock makeNewGotoBlock = this.parent.makeNewGotoBlock();
        makeNewGotoBlock.predecessors = this.predecessors;
        makeNewGotoBlock.successors.set(this.index);
        makeNewGotoBlock.successorList.add(this.index);
        makeNewGotoBlock.primarySuccessor = this.index;
        BitSet bitSet = new BitSet(this.parent.getBlocks().size());
        this.predecessors = bitSet;
        bitSet.set(makeNewGotoBlock.index);
        for (int nextSetBit = makeNewGotoBlock.predecessors.nextSetBit(0); nextSetBit >= 0; nextSetBit = makeNewGotoBlock.predecessors.nextSetBit(nextSetBit + 1)) {
            this.parent.getBlocks().get(nextSetBit).replaceSuccessor(this.index, makeNewGotoBlock.index);
        }
        return makeNewGotoBlock;
    }

    public SsaBasicBlock insertNewSuccessor(SsaBasicBlock ssaBasicBlock) {
        SsaBasicBlock makeNewGotoBlock = this.parent.makeNewGotoBlock();
        if (this.successors.get(ssaBasicBlock.index)) {
            makeNewGotoBlock.predecessors.set(this.index);
            makeNewGotoBlock.successors.set(ssaBasicBlock.index);
            makeNewGotoBlock.successorList.add(ssaBasicBlock.index);
            makeNewGotoBlock.primarySuccessor = ssaBasicBlock.index;
            for (int size = this.successorList.size() - 1; size >= 0; size--) {
                if (this.successorList.get(size) == ssaBasicBlock.index) {
                    this.successorList.set(size, makeNewGotoBlock.index);
                }
            }
            int i4 = this.primarySuccessor;
            int i5 = ssaBasicBlock.index;
            if (i4 == i5) {
                this.primarySuccessor = makeNewGotoBlock.index;
            }
            this.successors.clear(i5);
            this.successors.set(makeNewGotoBlock.index);
            ssaBasicBlock.predecessors.set(makeNewGotoBlock.index);
            ssaBasicBlock.predecessors.set(this.index, this.successors.get(ssaBasicBlock.index));
            return makeNewGotoBlock;
        }
        throw new RuntimeException("Block " + ssaBasicBlock.getRopLabelString() + " not successor of " + getRopLabelString());
    }

    public boolean isExitBlock() {
        if (this.index == this.parent.getExitBlockIndex()) {
            return true;
        }
        return false;
    }

    public boolean isReachable() {
        if (this.reachable == -1) {
            this.parent.computeReachability();
        }
        if (this.reachable == 1) {
            return true;
        }
        return false;
    }

    public void removeAllPhiInsns() {
        this.insns.subList(0, getCountPhiInsns()).clear();
    }

    public void removeSuccessor(int i4) {
        int i5 = 0;
        for (int size = this.successorList.size() - 1; size >= 0; size--) {
            if (this.successorList.get(size) == i4) {
                i5 = size;
            } else {
                this.primarySuccessor = this.successorList.get(size);
            }
        }
        this.successorList.removeIndex(i5);
        this.successors.clear(i4);
        this.parent.getBlocks().get(i4).predecessors.clear(this.index);
    }

    public void replaceLastInsn(Insn insn) {
        if (insn.getOpcode().getBranchingness() != 1) {
            ArrayList<SsaInsn> arrayList = this.insns;
            SsaInsn makeFromRop = SsaInsn.makeFromRop(insn, this);
            ArrayList<SsaInsn> arrayList2 = this.insns;
            arrayList2.set(arrayList2.size() - 1, makeFromRop);
            this.parent.onInsnRemoved(arrayList.get(arrayList.size() - 1));
            this.parent.onInsnAdded(makeFromRop);
            return;
        }
        throw new IllegalArgumentException("last insn must branch");
    }

    public void replaceSuccessor(int i4, int i5) {
        if (i4 == i5) {
            return;
        }
        this.successors.set(i5);
        if (this.primarySuccessor == i4) {
            this.primarySuccessor = i5;
        }
        for (int size = this.successorList.size() - 1; size >= 0; size--) {
            if (this.successorList.get(size) == i4) {
                this.successorList.set(size, i5);
            }
        }
        this.successors.clear(i4);
        this.parent.getBlocks().get(i5).predecessors.set(this.index);
        this.parent.getBlocks().get(i4).predecessors.clear(this.index);
    }

    public void scheduleMovesFromPhis() {
        int i4 = this.movesFromPhisAtBeginning;
        if (i4 > 1) {
            scheduleUseBeforeAssigned(this.insns.subList(0, i4));
            if (this.insns.get(this.movesFromPhisAtBeginning).isMoveException()) {
                throw new RuntimeException("Unexpected: moves from phis before move-exception");
            }
        }
        if (this.movesFromPhisAtEnd > 1) {
            ArrayList<SsaInsn> arrayList = this.insns;
            scheduleUseBeforeAssigned(arrayList.subList((arrayList.size() - this.movesFromPhisAtEnd) - 1, this.insns.size() - 1));
        }
        this.parent.returnSpareRegisters();
    }

    public void setReachable(int i4) {
        this.reachable = i4;
    }

    public String toString() {
        return "{" + this.index + ":" + Hex.u2(this.ropLabel) + '}';
    }

    public void addPhiInsnForReg(RegisterSpec registerSpec) {
        this.insns.add(0, new PhiInsn(registerSpec, this));
    }
}
