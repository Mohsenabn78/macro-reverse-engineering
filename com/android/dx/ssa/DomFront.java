package com.android.dx.ssa;

import com.android.dx.util.IntSet;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class DomFront {
    private static boolean DEBUG = false;
    private final DomInfo[] domInfos;
    private final SsaMethod meth;
    private final ArrayList<SsaBasicBlock> nodes;

    /* loaded from: classes2.dex */
    public static class DomInfo {
        public IntSet dominanceFrontiers;
        public int idom = -1;
    }

    public DomFront(SsaMethod ssaMethod) {
        this.meth = ssaMethod;
        ArrayList<SsaBasicBlock> blocks = ssaMethod.getBlocks();
        this.nodes = blocks;
        int size = blocks.size();
        this.domInfos = new DomInfo[size];
        for (int i4 = 0; i4 < size; i4++) {
            this.domInfos[i4] = new DomInfo();
        }
    }

    private void buildDomTree() {
        int size = this.nodes.size();
        for (int i4 = 0; i4 < size; i4++) {
            int i5 = this.domInfos[i4].idom;
            if (i5 != -1) {
                this.nodes.get(i5).addDomChild(this.nodes.get(i4));
            }
        }
    }

    private void calcDomFronts() {
        int size = this.nodes.size();
        for (int i4 = 0; i4 < size; i4++) {
            DomInfo domInfo = this.domInfos[i4];
            BitSet predecessors = this.nodes.get(i4).getPredecessors();
            if (predecessors.cardinality() > 1) {
                for (int nextSetBit = predecessors.nextSetBit(0); nextSetBit >= 0; nextSetBit = predecessors.nextSetBit(nextSetBit + 1)) {
                    int i5 = nextSetBit;
                    while (i5 != domInfo.idom && i5 != -1) {
                        DomInfo domInfo2 = this.domInfos[i5];
                        if (domInfo2.dominanceFrontiers.has(i4)) {
                            break;
                        }
                        domInfo2.dominanceFrontiers.add(i4);
                        i5 = domInfo2.idom;
                    }
                }
            }
        }
    }

    private void debugPrintDomChildren() {
        int size = this.nodes.size();
        for (int i4 = 0; i4 < size; i4++) {
            SsaBasicBlock ssaBasicBlock = this.nodes.get(i4);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append('{');
            Iterator<SsaBasicBlock> it = ssaBasicBlock.getDomChildren().iterator();
            boolean z3 = false;
            while (it.hasNext()) {
                SsaBasicBlock next = it.next();
                if (z3) {
                    stringBuffer.append(',');
                }
                stringBuffer.append(next);
                z3 = true;
            }
            stringBuffer.append('}');
            PrintStream printStream = System.out;
            printStream.println("domChildren[" + ssaBasicBlock + "]: " + ((Object) stringBuffer));
        }
    }

    public DomInfo[] run() {
        int size = this.nodes.size();
        if (DEBUG) {
            for (int i4 = 0; i4 < size; i4++) {
                PrintStream printStream = System.out;
                printStream.println("pred[" + i4 + "]: " + this.nodes.get(i4).getPredecessors());
            }
        }
        Dominators.make(this.meth, this.domInfos, false);
        if (DEBUG) {
            for (int i5 = 0; i5 < size; i5++) {
                DomInfo domInfo = this.domInfos[i5];
                PrintStream printStream2 = System.out;
                printStream2.println("idom[" + i5 + "]: " + domInfo.idom);
            }
        }
        buildDomTree();
        if (DEBUG) {
            debugPrintDomChildren();
        }
        for (int i6 = 0; i6 < size; i6++) {
            this.domInfos[i6].dominanceFrontiers = SetFactory.makeDomFrontSet(size);
        }
        calcDomFronts();
        if (DEBUG) {
            for (int i7 = 0; i7 < size; i7++) {
                PrintStream printStream3 = System.out;
                printStream3.println("df[" + i7 + "]: " + this.domInfos[i7].dominanceFrontiers);
            }
        }
        return this.domInfos;
    }
}
