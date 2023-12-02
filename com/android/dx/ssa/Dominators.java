package com.android.dx.ssa;

import com.android.dx.ssa.DomFront;
import com.android.dx.ssa.SsaBasicBlock;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class Dominators {
    private final ArrayList<SsaBasicBlock> blocks;
    private final DomFront.DomInfo[] domInfos;
    private final DFSInfo[] info;
    private final SsaMethod meth;
    private final boolean postdom;
    private final ArrayList<SsaBasicBlock> vertex;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class DFSInfo {
        public SsaBasicBlock ancestor;
        public ArrayList<SsaBasicBlock> bucket = new ArrayList<>();
        public SsaBasicBlock parent;
        public SsaBasicBlock rep;
        public int semidom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class DfsWalker implements SsaBasicBlock.Visitor {
        private int dfsNum;

        private DfsWalker() {
            this.dfsNum = 0;
        }

        @Override // com.android.dx.ssa.SsaBasicBlock.Visitor
        public void visitBlock(SsaBasicBlock ssaBasicBlock, SsaBasicBlock ssaBasicBlock2) {
            DFSInfo dFSInfo = new DFSInfo();
            int i4 = this.dfsNum + 1;
            this.dfsNum = i4;
            dFSInfo.semidom = i4;
            dFSInfo.rep = ssaBasicBlock;
            dFSInfo.parent = ssaBasicBlock2;
            Dominators.this.vertex.add(ssaBasicBlock);
            Dominators.this.info[ssaBasicBlock.getIndex()] = dFSInfo;
        }
    }

    private Dominators(SsaMethod ssaMethod, DomFront.DomInfo[] domInfoArr, boolean z3) {
        this.meth = ssaMethod;
        this.domInfos = domInfoArr;
        this.postdom = z3;
        ArrayList<SsaBasicBlock> blocks = ssaMethod.getBlocks();
        this.blocks = blocks;
        this.info = new DFSInfo[blocks.size() + 2];
        this.vertex = new ArrayList<>();
    }

    private void compress(SsaBasicBlock ssaBasicBlock) {
        if (this.info[this.info[ssaBasicBlock.getIndex()].ancestor.getIndex()].ancestor != null) {
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            arrayList.add(ssaBasicBlock);
            while (!arrayList.isEmpty()) {
                int size = arrayList.size() - 1;
                DFSInfo dFSInfo = this.info[((SsaBasicBlock) arrayList.get(size)).getIndex()];
                SsaBasicBlock ssaBasicBlock2 = dFSInfo.ancestor;
                DFSInfo dFSInfo2 = this.info[ssaBasicBlock2.getIndex()];
                if (hashSet.add(ssaBasicBlock2) && dFSInfo2.ancestor != null) {
                    arrayList.add(ssaBasicBlock2);
                } else {
                    arrayList.remove(size);
                    if (dFSInfo2.ancestor != null) {
                        SsaBasicBlock ssaBasicBlock3 = dFSInfo2.rep;
                        if (this.info[ssaBasicBlock3.getIndex()].semidom < this.info[dFSInfo.rep.getIndex()].semidom) {
                            dFSInfo.rep = ssaBasicBlock3;
                        }
                        dFSInfo.ancestor = dFSInfo2.ancestor;
                    }
                }
            }
        }
    }

    private SsaBasicBlock eval(SsaBasicBlock ssaBasicBlock) {
        DFSInfo dFSInfo = this.info[ssaBasicBlock.getIndex()];
        if (dFSInfo.ancestor == null) {
            return ssaBasicBlock;
        }
        compress(ssaBasicBlock);
        return dFSInfo.rep;
    }

    private BitSet getPreds(SsaBasicBlock ssaBasicBlock) {
        if (this.postdom) {
            return ssaBasicBlock.getSuccessors();
        }
        return ssaBasicBlock.getPredecessors();
    }

    private BitSet getSuccs(SsaBasicBlock ssaBasicBlock) {
        if (this.postdom) {
            return ssaBasicBlock.getPredecessors();
        }
        return ssaBasicBlock.getSuccessors();
    }

    public static Dominators make(SsaMethod ssaMethod, DomFront.DomInfo[] domInfoArr, boolean z3) {
        Dominators dominators = new Dominators(ssaMethod, domInfoArr, z3);
        dominators.run();
        return dominators;
    }

    private void run() {
        SsaBasicBlock entryBlock;
        int i4;
        int i5;
        if (this.postdom) {
            entryBlock = this.meth.getExitBlock();
        } else {
            entryBlock = this.meth.getEntryBlock();
        }
        if (entryBlock != null) {
            this.vertex.add(entryBlock);
            this.domInfos[entryBlock.getIndex()].idom = entryBlock.getIndex();
        }
        this.meth.forEachBlockDepthFirst(this.postdom, new DfsWalker());
        int size = this.vertex.size() - 1;
        int i6 = size;
        while (true) {
            if (i6 < 2) {
                break;
            }
            SsaBasicBlock ssaBasicBlock = this.vertex.get(i6);
            DFSInfo dFSInfo = this.info[ssaBasicBlock.getIndex()];
            BitSet preds = getPreds(ssaBasicBlock);
            for (int nextSetBit = preds.nextSetBit(0); nextSetBit >= 0; nextSetBit = preds.nextSetBit(nextSetBit + 1)) {
                SsaBasicBlock ssaBasicBlock2 = this.blocks.get(nextSetBit);
                if (this.info[ssaBasicBlock2.getIndex()] != null && (i5 = this.info[eval(ssaBasicBlock2).getIndex()].semidom) < dFSInfo.semidom) {
                    dFSInfo.semidom = i5;
                }
            }
            this.info[this.vertex.get(dFSInfo.semidom).getIndex()].bucket.add(ssaBasicBlock);
            SsaBasicBlock ssaBasicBlock3 = dFSInfo.parent;
            dFSInfo.ancestor = ssaBasicBlock3;
            ArrayList<SsaBasicBlock> arrayList = this.info[ssaBasicBlock3.getIndex()].bucket;
            while (!arrayList.isEmpty()) {
                SsaBasicBlock remove = arrayList.remove(arrayList.size() - 1);
                SsaBasicBlock eval = eval(remove);
                if (this.info[eval.getIndex()].semidom < this.info[remove.getIndex()].semidom) {
                    this.domInfos[remove.getIndex()].idom = eval.getIndex();
                } else {
                    this.domInfos[remove.getIndex()].idom = dFSInfo.parent.getIndex();
                }
            }
            i6--;
        }
        for (i4 = 2; i4 <= size; i4++) {
            SsaBasicBlock ssaBasicBlock4 = this.vertex.get(i4);
            if (this.domInfos[ssaBasicBlock4.getIndex()].idom != this.vertex.get(this.info[ssaBasicBlock4.getIndex()].semidom).getIndex()) {
                DomFront.DomInfo domInfo = this.domInfos[ssaBasicBlock4.getIndex()];
                DomFront.DomInfo[] domInfoArr = this.domInfos;
                domInfo.idom = domInfoArr[domInfoArr[ssaBasicBlock4.getIndex()].idom].idom;
            }
        }
    }
}
