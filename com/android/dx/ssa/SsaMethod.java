package com.android.dx.ssa;

import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.PlainInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.rop.code.Rops;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.ssa.PhiInsn;
import com.android.dx.ssa.SsaBasicBlock;
import com.android.dx.ssa.SsaInsn;
import com.android.dx.util.IntList;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/* loaded from: classes2.dex */
public final class SsaMethod {
    private boolean backMode = false;
    private ArrayList<SsaBasicBlock> blocks;
    private int borrowedSpareRegisters;
    private SsaInsn[] definitionList;
    private int entryBlockIndex;
    private int exitBlockIndex;
    private final boolean isStatic;
    private int maxLabel;
    private final int paramWidth;
    private int registerCount;
    private int spareRegisterBase;
    private List<SsaInsn>[] unmodifiableUseList;
    private ArrayList<SsaInsn>[] useList;

    private SsaMethod(RopMethod ropMethod, int i4, boolean z3) {
        this.paramWidth = i4;
        this.isStatic = z3;
        this.maxLabel = ropMethod.getBlocks().getMaxLabel();
        int regCount = ropMethod.getBlocks().getRegCount();
        this.registerCount = regCount;
        this.spareRegisterBase = regCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BitSet bitSetFromLabelList(BasicBlockList basicBlockList, IntList intList) {
        BitSet bitSet = new BitSet(basicBlockList.size());
        int size = intList.size();
        for (int i4 = 0; i4 < size; i4++) {
            bitSet.set(basicBlockList.indexOfLabel(intList.get(i4)));
        }
        return bitSet;
    }

    private void buildUseList() {
        if (!this.backMode) {
            this.useList = new ArrayList[this.registerCount];
            for (int i4 = 0; i4 < this.registerCount; i4++) {
                this.useList[i4] = new ArrayList<>();
            }
            forEachInsn(new SsaInsn.Visitor() { // from class: com.android.dx.ssa.SsaMethod.2
                private void addToUses(SsaInsn ssaInsn) {
                    RegisterSpecList sources = ssaInsn.getSources();
                    int size = sources.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        SsaMethod.this.useList[sources.get(i5).getReg()].add(ssaInsn);
                    }
                }

                @Override // com.android.dx.ssa.SsaInsn.Visitor
                public void visitMoveInsn(NormalSsaInsn normalSsaInsn) {
                    addToUses(normalSsaInsn);
                }

                @Override // com.android.dx.ssa.SsaInsn.Visitor
                public void visitNonMoveInsn(NormalSsaInsn normalSsaInsn) {
                    addToUses(normalSsaInsn);
                }

                @Override // com.android.dx.ssa.SsaInsn.Visitor
                public void visitPhiInsn(PhiInsn phiInsn) {
                    addToUses(phiInsn);
                }
            });
            this.unmodifiableUseList = new List[this.registerCount];
            for (int i5 = 0; i5 < this.registerCount; i5++) {
                this.unmodifiableUseList[i5] = Collections.unmodifiableList(this.useList[i5]);
            }
            return;
        }
        throw new RuntimeException("No use list in back mode");
    }

    private void convertRopToSsaBlocks(RopMethod ropMethod) {
        int size = ropMethod.getBlocks().size();
        this.blocks = new ArrayList<>(size + 2);
        for (int i4 = 0; i4 < size; i4++) {
            this.blocks.add(SsaBasicBlock.newFromRop(ropMethod, i4, this));
        }
        this.entryBlockIndex = this.blocks.get(ropMethod.getBlocks().indexOfLabel(ropMethod.getFirstLabel())).insertNewPredecessor().getIndex();
        this.exitBlockIndex = -1;
    }

    private static SsaInsn getGoto(SsaBasicBlock ssaBasicBlock) {
        return new NormalSsaInsn(new PlainInsn(Rops.GOTO, SourcePosition.NO_INFO, (RegisterSpec) null, RegisterSpecList.EMPTY), ssaBasicBlock);
    }

    public static IntList indexListFromLabelList(BasicBlockList basicBlockList, IntList intList) {
        IntList intList2 = new IntList(intList.size());
        int size = intList.size();
        for (int i4 = 0; i4 < size; i4++) {
            intList2.add(basicBlockList.indexOfLabel(intList.get(i4)));
        }
        return intList2;
    }

    public static SsaMethod newFromRopMethod(RopMethod ropMethod, int i4, boolean z3) {
        SsaMethod ssaMethod = new SsaMethod(ropMethod, i4, z3);
        ssaMethod.convertRopToSsaBlocks(ropMethod);
        return ssaMethod;
    }

    private void removeFromUseList(SsaInsn ssaInsn, RegisterSpecList registerSpecList) {
        if (registerSpecList == null) {
            return;
        }
        int size = registerSpecList.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (!this.useList[registerSpecList.get(i4).getReg()].remove(ssaInsn)) {
                throw new RuntimeException("use not found");
            }
        }
    }

    public int blockIndexToRopLabel(int i4) {
        if (i4 < 0) {
            return -1;
        }
        return this.blocks.get(i4).getRopLabel();
    }

    public int borrowSpareRegister(int i4) {
        int i5 = this.spareRegisterBase;
        int i6 = this.borrowedSpareRegisters;
        int i7 = i5 + i6;
        this.borrowedSpareRegisters = i6 + i4;
        this.registerCount = Math.max(this.registerCount, i4 + i7);
        return i7;
    }

    public void computeReachability() {
        Iterator<SsaBasicBlock> it = this.blocks.iterator();
        while (it.hasNext()) {
            it.next().setReachable(0);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(getEntryBlock());
        while (!arrayList.isEmpty()) {
            SsaBasicBlock ssaBasicBlock = (SsaBasicBlock) arrayList.remove(0);
            if (!ssaBasicBlock.isReachable()) {
                ssaBasicBlock.setReachable(1);
                BitSet successors = ssaBasicBlock.getSuccessors();
                for (int nextSetBit = successors.nextSetBit(0); nextSetBit >= 0; nextSetBit = successors.nextSetBit(nextSetBit + 1)) {
                    arrayList.add(this.blocks.get(nextSetBit));
                }
            }
        }
    }

    public void deleteInsns(Set<SsaInsn> set) {
        SsaInsn ssaInsn;
        Iterator<SsaBasicBlock> it = getBlocks().iterator();
        while (it.hasNext()) {
            SsaBasicBlock next = it.next();
            ArrayList<SsaInsn> insns = next.getInsns();
            for (int size = insns.size() - 1; size >= 0; size--) {
                SsaInsn ssaInsn2 = insns.get(size);
                if (set.contains(ssaInsn2)) {
                    onInsnRemoved(ssaInsn2);
                    insns.remove(size);
                }
            }
            int size2 = insns.size();
            if (size2 == 0) {
                ssaInsn = null;
            } else {
                ssaInsn = insns.get(size2 - 1);
            }
            if (next != getExitBlock() && (size2 == 0 || ssaInsn.getOriginalRopInsn() == null || ssaInsn.getOriginalRopInsn().getOpcode().getBranchingness() == 1)) {
                insns.add(SsaInsn.makeFromRop(new PlainInsn(Rops.GOTO, SourcePosition.NO_INFO, (RegisterSpec) null, RegisterSpecList.EMPTY), next));
                BitSet successors = next.getSuccessors();
                for (int nextSetBit = successors.nextSetBit(0); nextSetBit >= 0; nextSetBit = successors.nextSetBit(nextSetBit + 1)) {
                    if (nextSetBit != next.getPrimarySuccessorIndex()) {
                        next.removeSuccessor(nextSetBit);
                    }
                }
            }
        }
    }

    public void forEachBlockDepthFirst(boolean z3, SsaBasicBlock.Visitor visitor) {
        SsaBasicBlock entryBlock;
        BitSet successors;
        BitSet bitSet = new BitSet(this.blocks.size());
        Stack stack = new Stack();
        if (z3) {
            entryBlock = getExitBlock();
        } else {
            entryBlock = getEntryBlock();
        }
        if (entryBlock == null) {
            return;
        }
        stack.add(null);
        stack.add(entryBlock);
        while (stack.size() > 0) {
            SsaBasicBlock ssaBasicBlock = (SsaBasicBlock) stack.pop();
            SsaBasicBlock ssaBasicBlock2 = (SsaBasicBlock) stack.pop();
            if (!bitSet.get(ssaBasicBlock.getIndex())) {
                if (z3) {
                    successors = ssaBasicBlock.getPredecessors();
                } else {
                    successors = ssaBasicBlock.getSuccessors();
                }
                for (int nextSetBit = successors.nextSetBit(0); nextSetBit >= 0; nextSetBit = successors.nextSetBit(nextSetBit + 1)) {
                    stack.add(ssaBasicBlock);
                    stack.add(this.blocks.get(nextSetBit));
                }
                bitSet.set(ssaBasicBlock.getIndex());
                visitor.visitBlock(ssaBasicBlock, ssaBasicBlock2);
            }
        }
    }

    public void forEachBlockDepthFirstDom(SsaBasicBlock.Visitor visitor) {
        BitSet bitSet = new BitSet(getBlocks().size());
        Stack stack = new Stack();
        stack.add(getEntryBlock());
        while (stack.size() > 0) {
            SsaBasicBlock ssaBasicBlock = (SsaBasicBlock) stack.pop();
            ArrayList<SsaBasicBlock> domChildren = ssaBasicBlock.getDomChildren();
            if (!bitSet.get(ssaBasicBlock.getIndex())) {
                for (int size = domChildren.size() - 1; size >= 0; size--) {
                    stack.add(domChildren.get(size));
                }
                bitSet.set(ssaBasicBlock.getIndex());
                visitor.visitBlock(ssaBasicBlock, null);
            }
        }
    }

    public void forEachInsn(SsaInsn.Visitor visitor) {
        Iterator<SsaBasicBlock> it = this.blocks.iterator();
        while (it.hasNext()) {
            it.next().forEachInsn(visitor);
        }
    }

    public void forEachPhiInsn(PhiInsn.Visitor visitor) {
        Iterator<SsaBasicBlock> it = this.blocks.iterator();
        while (it.hasNext()) {
            it.next().forEachPhiInsn(visitor);
        }
    }

    public ArrayList<SsaBasicBlock> getBlocks() {
        return this.blocks;
    }

    public int getCountReachableBlocks() {
        Iterator<SsaBasicBlock> it = this.blocks.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            if (it.next().isReachable()) {
                i4++;
            }
        }
        return i4;
    }

    public SsaInsn getDefinitionForRegister(int i4) {
        if (!this.backMode) {
            SsaInsn[] ssaInsnArr = this.definitionList;
            if (ssaInsnArr != null) {
                return ssaInsnArr[i4];
            }
            this.definitionList = new SsaInsn[getRegCount()];
            forEachInsn(new SsaInsn.Visitor() { // from class: com.android.dx.ssa.SsaMethod.1
                @Override // com.android.dx.ssa.SsaInsn.Visitor
                public void visitMoveInsn(NormalSsaInsn normalSsaInsn) {
                    SsaMethod.this.definitionList[normalSsaInsn.getResult().getReg()] = normalSsaInsn;
                }

                @Override // com.android.dx.ssa.SsaInsn.Visitor
                public void visitNonMoveInsn(NormalSsaInsn normalSsaInsn) {
                    if (normalSsaInsn.getResult() != null) {
                        SsaMethod.this.definitionList[normalSsaInsn.getResult().getReg()] = normalSsaInsn;
                    }
                }

                @Override // com.android.dx.ssa.SsaInsn.Visitor
                public void visitPhiInsn(PhiInsn phiInsn) {
                    SsaMethod.this.definitionList[phiInsn.getResult().getReg()] = phiInsn;
                }
            });
            return this.definitionList[i4];
        }
        throw new RuntimeException("No def list in back mode");
    }

    public SsaBasicBlock getEntryBlock() {
        return this.blocks.get(this.entryBlockIndex);
    }

    public int getEntryBlockIndex() {
        return this.entryBlockIndex;
    }

    public SsaBasicBlock getExitBlock() {
        int i4 = this.exitBlockIndex;
        if (i4 < 0) {
            return null;
        }
        return this.blocks.get(i4);
    }

    public int getExitBlockIndex() {
        return this.exitBlockIndex;
    }

    public int getParamWidth() {
        return this.paramWidth;
    }

    public int getRegCount() {
        return this.registerCount;
    }

    public ArrayList<SsaInsn>[] getUseListCopy() {
        if (this.useList == null) {
            buildUseList();
        }
        ArrayList<SsaInsn>[] arrayListArr = new ArrayList[this.registerCount];
        for (int i4 = 0; i4 < this.registerCount; i4++) {
            arrayListArr[i4] = new ArrayList<>(this.useList[i4]);
        }
        return arrayListArr;
    }

    public List<SsaInsn> getUseListForRegister(int i4) {
        if (this.unmodifiableUseList == null) {
            buildUseList();
        }
        return this.unmodifiableUseList[i4];
    }

    public boolean isRegALocal(RegisterSpec registerSpec) {
        SsaInsn definitionForRegister = getDefinitionForRegister(registerSpec.getReg());
        if (definitionForRegister == null) {
            return false;
        }
        if (definitionForRegister.getLocalAssignment() != null) {
            return true;
        }
        for (SsaInsn ssaInsn : getUseListForRegister(registerSpec.getReg())) {
            Insn originalRopInsn = ssaInsn.getOriginalRopInsn();
            if (originalRopInsn != null && originalRopInsn.getOpcode().getOpcode() == 54) {
                return true;
            }
        }
        return false;
    }

    public boolean isStatic() {
        return this.isStatic;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void makeExitBlock() {
        if (this.exitBlockIndex < 0) {
            this.exitBlockIndex = this.blocks.size();
            int i4 = this.exitBlockIndex;
            int i5 = this.maxLabel;
            this.maxLabel = i5 + 1;
            SsaBasicBlock ssaBasicBlock = new SsaBasicBlock(i4, i5, this);
            this.blocks.add(ssaBasicBlock);
            Iterator<SsaBasicBlock> it = this.blocks.iterator();
            while (it.hasNext()) {
                it.next().exitBlockFixup(ssaBasicBlock);
            }
            if (ssaBasicBlock.getPredecessors().cardinality() == 0) {
                this.blocks.remove(this.exitBlockIndex);
                this.exitBlockIndex = -1;
                this.maxLabel--;
                return;
            }
            return;
        }
        throw new RuntimeException("must be called at most once");
    }

    public SsaBasicBlock makeNewGotoBlock() {
        int size = this.blocks.size();
        int i4 = this.maxLabel;
        this.maxLabel = i4 + 1;
        SsaBasicBlock ssaBasicBlock = new SsaBasicBlock(size, i4, this);
        ssaBasicBlock.getInsns().add(getGoto(ssaBasicBlock));
        this.blocks.add(ssaBasicBlock);
        return ssaBasicBlock;
    }

    public int makeNewSsaReg() {
        int i4 = this.registerCount;
        int i5 = i4 + 1;
        this.registerCount = i5;
        this.spareRegisterBase = i5;
        onInsnsChanged();
        return i4;
    }

    public void mapRegisters(RegisterMapper registerMapper) {
        Iterator<SsaBasicBlock> it = getBlocks().iterator();
        while (it.hasNext()) {
            Iterator<SsaInsn> it2 = it.next().getInsns().iterator();
            while (it2.hasNext()) {
                it2.next().mapRegisters(registerMapper);
            }
        }
        int newRegisterCount = registerMapper.getNewRegisterCount();
        this.registerCount = newRegisterCount;
        this.spareRegisterBase = newRegisterCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onInsnAdded(SsaInsn ssaInsn) {
        onSourcesChanged(ssaInsn, null);
        updateOneDefinition(ssaInsn, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onInsnRemoved(SsaInsn ssaInsn) {
        if (this.useList != null) {
            removeFromUseList(ssaInsn, ssaInsn.getSources());
        }
        RegisterSpec result = ssaInsn.getResult();
        SsaInsn[] ssaInsnArr = this.definitionList;
        if (ssaInsnArr != null && result != null) {
            ssaInsnArr[result.getReg()] = null;
        }
    }

    public void onInsnsChanged() {
        this.definitionList = null;
        this.useList = null;
        this.unmodifiableUseList = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSourceChanged(SsaInsn ssaInsn, RegisterSpec registerSpec, RegisterSpec registerSpec2) {
        if (this.useList == null) {
            return;
        }
        if (registerSpec != null) {
            this.useList[registerSpec.getReg()].remove(ssaInsn);
        }
        int reg = registerSpec2.getReg();
        ArrayList<SsaInsn>[] arrayListArr = this.useList;
        if (arrayListArr.length <= reg) {
            this.useList = null;
        } else {
            arrayListArr[reg].add(ssaInsn);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSourcesChanged(SsaInsn ssaInsn, RegisterSpecList registerSpecList) {
        if (this.useList == null) {
            return;
        }
        if (registerSpecList != null) {
            removeFromUseList(ssaInsn, registerSpecList);
        }
        RegisterSpecList sources = ssaInsn.getSources();
        int size = sources.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.useList[sources.get(i4).getReg()].add(ssaInsn);
        }
    }

    public void returnSpareRegisters() {
        this.borrowedSpareRegisters = 0;
    }

    public void setBackMode() {
        this.backMode = true;
        this.useList = null;
        this.definitionList = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNewRegCount(int i4) {
        this.registerCount = i4;
        this.spareRegisterBase = i4;
        onInsnsChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateOneDefinition(SsaInsn ssaInsn, RegisterSpec registerSpec) {
        if (this.definitionList == null) {
            return;
        }
        if (registerSpec != null) {
            this.definitionList[registerSpec.getReg()] = null;
        }
        RegisterSpec result = ssaInsn.getResult();
        if (result != null) {
            int reg = result.getReg();
            SsaInsn[] ssaInsnArr = this.definitionList;
            if (ssaInsnArr[reg] == null) {
                ssaInsnArr[result.getReg()] = ssaInsn;
                return;
            }
            throw new RuntimeException("Duplicate add of insn");
        }
    }
}
