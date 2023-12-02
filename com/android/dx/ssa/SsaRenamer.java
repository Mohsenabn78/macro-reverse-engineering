package com.android.dx.ssa;

import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.code.PlainInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rops;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.rop.type.Type;
import com.android.dx.ssa.PhiInsn;
import com.android.dx.ssa.SsaBasicBlock;
import com.android.dx.ssa.SsaInsn;
import com.android.dx.util.IntList;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class SsaRenamer implements Runnable {
    private static final boolean DEBUG = false;
    private int nextSsaReg;
    private final int ropRegCount;
    private final SsaMethod ssaMeth;
    private final ArrayList<LocalItem> ssaRegToLocalItems;
    private IntList ssaRegToRopReg;
    private final RegisterSpec[][] startsForBlocks;
    private int threshold;

    /* loaded from: classes2.dex */
    private class BlockRenamer implements SsaInsn.Visitor {
        private final SsaBasicBlock block;
        private final RegisterSpec[] currentMapping;
        private final HashSet<SsaInsn> movesToKeep = new HashSet<>();
        private final HashMap<SsaInsn, SsaInsn> insnsToReplace = new HashMap<>();
        private final RenamingMapper mapper = new RenamingMapper();

        /* loaded from: classes2.dex */
        private class RenamingMapper extends RegisterMapper {
            public RenamingMapper() {
            }

            @Override // com.android.dx.ssa.RegisterMapper
            public int getNewRegisterCount() {
                return SsaRenamer.this.nextSsaReg;
            }

            @Override // com.android.dx.ssa.RegisterMapper
            public RegisterSpec map(RegisterSpec registerSpec) {
                if (registerSpec == null) {
                    return null;
                }
                return registerSpec.withReg(BlockRenamer.this.currentMapping[registerSpec.getReg()].getReg());
            }
        }

        BlockRenamer(SsaBasicBlock ssaBasicBlock) {
            this.block = ssaBasicBlock;
            this.currentMapping = SsaRenamer.this.startsForBlocks[ssaBasicBlock.getIndex()];
            SsaRenamer.this.startsForBlocks[ssaBasicBlock.getIndex()] = null;
        }

        private void addMapping(int i4, RegisterSpec registerSpec) {
            int reg = registerSpec.getReg();
            LocalItem localItem = registerSpec.getLocalItem();
            RegisterSpec[] registerSpecArr = this.currentMapping;
            registerSpecArr[i4] = registerSpec;
            for (int length = registerSpecArr.length - 1; length >= 0; length--) {
                if (reg == this.currentMapping[length].getReg()) {
                    this.currentMapping[length] = registerSpec;
                }
            }
            if (localItem != null) {
                SsaRenamer.this.setNameForSsaReg(registerSpec);
                for (int length2 = this.currentMapping.length - 1; length2 >= 0; length2--) {
                    RegisterSpec registerSpec2 = this.currentMapping[length2];
                    if (reg != registerSpec2.getReg() && localItem.equals(registerSpec2.getLocalItem())) {
                        this.currentMapping[length2] = registerSpec2.withLocalItem(null);
                    }
                }
            }
        }

        private void updateSuccessorPhis() {
            PhiInsn.Visitor visitor = new PhiInsn.Visitor() { // from class: com.android.dx.ssa.SsaRenamer.BlockRenamer.1
                @Override // com.android.dx.ssa.PhiInsn.Visitor
                public void visitPhiInsn(PhiInsn phiInsn) {
                    int ropResultReg = phiInsn.getRopResultReg();
                    if (SsaRenamer.this.isBelowThresholdRegister(ropResultReg)) {
                        return;
                    }
                    RegisterSpec registerSpec = BlockRenamer.this.currentMapping[ropResultReg];
                    if (!SsaRenamer.this.isVersionZeroRegister(registerSpec.getReg())) {
                        phiInsn.addPhiOperand(registerSpec, BlockRenamer.this.block);
                    }
                }
            };
            BitSet successors = this.block.getSuccessors();
            for (int nextSetBit = successors.nextSetBit(0); nextSetBit >= 0; nextSetBit = successors.nextSetBit(nextSetBit + 1)) {
                SsaRenamer.this.ssaMeth.getBlocks().get(nextSetBit).forEachPhiInsn(visitor);
            }
        }

        public void process() {
            RegisterSpec[] dupArray;
            this.block.forEachInsn(this);
            updateSuccessorPhis();
            ArrayList<SsaInsn> insns = this.block.getInsns();
            boolean z3 = true;
            for (int size = insns.size() - 1; size >= 0; size--) {
                SsaInsn ssaInsn = insns.get(size);
                SsaInsn ssaInsn2 = this.insnsToReplace.get(ssaInsn);
                if (ssaInsn2 != null) {
                    insns.set(size, ssaInsn2);
                } else if (ssaInsn.isNormalMoveInsn() && !this.movesToKeep.contains(ssaInsn)) {
                    insns.remove(size);
                }
            }
            Iterator<SsaBasicBlock> it = this.block.getDomChildren().iterator();
            while (it.hasNext()) {
                SsaBasicBlock next = it.next();
                if (next != this.block) {
                    if (!z3) {
                        dupArray = SsaRenamer.dupArray(this.currentMapping);
                    } else {
                        dupArray = this.currentMapping;
                    }
                    SsaRenamer.this.startsForBlocks[next.getIndex()] = dupArray;
                    z3 = false;
                }
            }
        }

        void processResultReg(SsaInsn ssaInsn) {
            RegisterSpec result = ssaInsn.getResult();
            if (result == null) {
                return;
            }
            int reg = result.getReg();
            if (SsaRenamer.this.isBelowThresholdRegister(reg)) {
                return;
            }
            ssaInsn.changeResultReg(SsaRenamer.this.nextSsaReg);
            addMapping(reg, ssaInsn.getResult());
            SsaRenamer.access$108(SsaRenamer.this);
        }

        @Override // com.android.dx.ssa.SsaInsn.Visitor
        public void visitMoveInsn(NormalSsaInsn normalSsaInsn) {
            RegisterSpec result = normalSsaInsn.getResult();
            int reg = result.getReg();
            boolean z3 = false;
            int reg2 = normalSsaInsn.getSources().get(0).getReg();
            normalSsaInsn.mapSourceRegisters(this.mapper);
            int reg3 = normalSsaInsn.getSources().get(0).getReg();
            LocalItem localItem = this.currentMapping[reg2].getLocalItem();
            LocalItem localItem2 = result.getLocalItem();
            if (localItem2 == null) {
                localItem2 = localItem;
            }
            LocalItem localForNewReg = SsaRenamer.this.getLocalForNewReg(reg3);
            z3 = (localForNewReg == null || localItem2 == null || localItem2.equals(localForNewReg)) ? true : true;
            RegisterSpec makeLocalOptional = RegisterSpec.makeLocalOptional(reg3, result.getType(), localItem2);
            if (Optimizer.getPreserveLocals() && (!z3 || !SsaRenamer.equalsHandlesNulls(localItem2, localItem) || SsaRenamer.this.threshold != 0)) {
                if (z3 && localItem == null && SsaRenamer.this.threshold == 0) {
                    this.insnsToReplace.put(normalSsaInsn, SsaInsn.makeFromRop(new PlainInsn(Rops.opMarkLocal(makeLocalOptional), SourcePosition.NO_INFO, (RegisterSpec) null, RegisterSpecList.make(RegisterSpec.make(makeLocalOptional.getReg(), makeLocalOptional.getType(), localItem2))), this.block));
                    addMapping(reg, makeLocalOptional);
                    return;
                }
                processResultReg(normalSsaInsn);
                this.movesToKeep.add(normalSsaInsn);
                return;
            }
            addMapping(reg, makeLocalOptional);
        }

        @Override // com.android.dx.ssa.SsaInsn.Visitor
        public void visitNonMoveInsn(NormalSsaInsn normalSsaInsn) {
            normalSsaInsn.mapSourceRegisters(this.mapper);
            processResultReg(normalSsaInsn);
        }

        @Override // com.android.dx.ssa.SsaInsn.Visitor
        public void visitPhiInsn(PhiInsn phiInsn) {
            processResultReg(phiInsn);
        }
    }

    public SsaRenamer(SsaMethod ssaMethod) {
        int regCount = ssaMethod.getRegCount();
        this.ropRegCount = regCount;
        this.ssaMeth = ssaMethod;
        this.nextSsaReg = regCount;
        this.threshold = 0;
        this.startsForBlocks = new RegisterSpec[ssaMethod.getBlocks().size()];
        this.ssaRegToLocalItems = new ArrayList<>();
        RegisterSpec[] registerSpecArr = new RegisterSpec[regCount];
        for (int i4 = 0; i4 < this.ropRegCount; i4++) {
            registerSpecArr[i4] = RegisterSpec.make(i4, Type.VOID);
        }
        this.startsForBlocks[ssaMethod.getEntryBlockIndex()] = registerSpecArr;
    }

    static /* synthetic */ int access$108(SsaRenamer ssaRenamer) {
        int i4 = ssaRenamer.nextSsaReg;
        ssaRenamer.nextSsaReg = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RegisterSpec[] dupArray(RegisterSpec[] registerSpecArr) {
        RegisterSpec[] registerSpecArr2 = new RegisterSpec[registerSpecArr.length];
        System.arraycopy(registerSpecArr, 0, registerSpecArr2, 0, registerSpecArr.length);
        return registerSpecArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean equalsHandlesNulls(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LocalItem getLocalForNewReg(int i4) {
        if (i4 < this.ssaRegToLocalItems.size()) {
            return this.ssaRegToLocalItems.get(i4);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isBelowThresholdRegister(int i4) {
        if (i4 < this.threshold) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isVersionZeroRegister(int i4) {
        if (i4 < this.ropRegCount) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameForSsaReg(RegisterSpec registerSpec) {
        int reg = registerSpec.getReg();
        LocalItem localItem = registerSpec.getLocalItem();
        this.ssaRegToLocalItems.ensureCapacity(reg + 1);
        while (this.ssaRegToLocalItems.size() <= reg) {
            this.ssaRegToLocalItems.add(null);
        }
        this.ssaRegToLocalItems.set(reg, localItem);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ssaMeth.forEachBlockDepthFirstDom(new SsaBasicBlock.Visitor() { // from class: com.android.dx.ssa.SsaRenamer.1
            @Override // com.android.dx.ssa.SsaBasicBlock.Visitor
            public void visitBlock(SsaBasicBlock ssaBasicBlock, SsaBasicBlock ssaBasicBlock2) {
                new BlockRenamer(ssaBasicBlock).process();
            }
        });
        this.ssaMeth.setNewRegCount(this.nextSsaReg);
        this.ssaMeth.onInsnsChanged();
    }

    public SsaRenamer(SsaMethod ssaMethod, int i4) {
        this(ssaMethod);
        this.threshold = i4;
    }
}
