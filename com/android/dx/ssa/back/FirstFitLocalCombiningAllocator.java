package com.android.dx.ssa.back;

import com.android.dx.rop.code.CstInsn;
import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.ssa.InterferenceRegisterMapper;
import com.android.dx.ssa.NormalSsaInsn;
import com.android.dx.ssa.Optimizer;
import com.android.dx.ssa.PhiInsn;
import com.android.dx.ssa.RegisterMapper;
import com.android.dx.ssa.SsaInsn;
import com.android.dx.ssa.SsaMethod;
import com.android.dx.util.IntIterator;
import com.android.dx.util.IntSet;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public class FirstFitLocalCombiningAllocator extends RegisterAllocator {
    private static final boolean DEBUG = false;
    private final ArrayList<NormalSsaInsn> invokeRangeInsns;
    private final Map<LocalItem, ArrayList<RegisterSpec>> localVariables;
    private final InterferenceRegisterMapper mapper;
    private final boolean minimizeRegisters;
    private final ArrayList<NormalSsaInsn> moveResultPseudoInsns;
    private final int paramRangeEnd;
    private final ArrayList<PhiInsn> phiInsns;
    private final BitSet reservedRopRegs;
    private final BitSet ssaRegsMapped;
    private final BitSet usedRopRegs;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum Alignment {
        EVEN { // from class: com.android.dx.ssa.back.FirstFitLocalCombiningAllocator.Alignment.1
            @Override // com.android.dx.ssa.back.FirstFitLocalCombiningAllocator.Alignment
            int nextClearBit(BitSet bitSet, int i4) {
                int nextClearBit = bitSet.nextClearBit(i4);
                while (!FirstFitLocalCombiningAllocator.isEven(nextClearBit)) {
                    nextClearBit = bitSet.nextClearBit(nextClearBit + 1);
                }
                return nextClearBit;
            }
        },
        ODD { // from class: com.android.dx.ssa.back.FirstFitLocalCombiningAllocator.Alignment.2
            @Override // com.android.dx.ssa.back.FirstFitLocalCombiningAllocator.Alignment
            int nextClearBit(BitSet bitSet, int i4) {
                int nextClearBit = bitSet.nextClearBit(i4);
                while (FirstFitLocalCombiningAllocator.isEven(nextClearBit)) {
                    nextClearBit = bitSet.nextClearBit(nextClearBit + 1);
                }
                return nextClearBit;
            }
        },
        UNSPECIFIED { // from class: com.android.dx.ssa.back.FirstFitLocalCombiningAllocator.Alignment.3
            @Override // com.android.dx.ssa.back.FirstFitLocalCombiningAllocator.Alignment
            int nextClearBit(BitSet bitSet, int i4) {
                return bitSet.nextClearBit(i4);
            }
        };

        abstract int nextClearBit(BitSet bitSet, int i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class Multiset {
        private final int[] count;
        private final int[] reg;
        private int size = 0;

        public Multiset(int i4) {
            this.reg = new int[i4];
            this.count = new int[i4];
        }

        public void add(int i4) {
            int i5 = 0;
            while (true) {
                int i6 = this.size;
                if (i5 < i6) {
                    if (this.reg[i5] == i4) {
                        int[] iArr = this.count;
                        iArr[i5] = iArr[i5] + 1;
                        return;
                    }
                    i5++;
                } else {
                    this.reg[i6] = i4;
                    this.count[i6] = 1;
                    this.size = i6 + 1;
                    return;
                }
            }
        }

        public int getAndRemoveHighestCount() {
            int i4 = -1;
            int i5 = -1;
            int i6 = 0;
            for (int i7 = 0; i7 < this.size; i7++) {
                int i8 = this.count[i7];
                if (i6 < i8) {
                    i5 = this.reg[i7];
                    i4 = i7;
                    i6 = i8;
                }
            }
            this.count[i4] = 0;
            return i5;
        }

        public int getSize() {
            return this.size;
        }
    }

    public FirstFitLocalCombiningAllocator(SsaMethod ssaMethod, InterferenceGraph interferenceGraph, boolean z3) {
        super(ssaMethod, interferenceGraph);
        this.ssaRegsMapped = new BitSet(ssaMethod.getRegCount());
        this.mapper = new InterferenceRegisterMapper(interferenceGraph, ssaMethod.getRegCount());
        this.minimizeRegisters = z3;
        int paramWidth = ssaMethod.getParamWidth();
        this.paramRangeEnd = paramWidth;
        BitSet bitSet = new BitSet(paramWidth * 2);
        this.reservedRopRegs = bitSet;
        bitSet.set(0, paramWidth);
        this.usedRopRegs = new BitSet(paramWidth * 2);
        this.localVariables = new TreeMap();
        this.moveResultPseudoInsns = new ArrayList<>();
        this.invokeRangeInsns = new ArrayList<>();
        this.phiInsns = new ArrayList<>();
    }

    private void addMapping(RegisterSpec registerSpec, int i4) {
        int reg = registerSpec.getReg();
        if (!this.ssaRegsMapped.get(reg) && canMapReg(registerSpec, i4)) {
            int category = registerSpec.getCategory();
            this.mapper.addMapping(registerSpec.getReg(), i4, category);
            this.ssaRegsMapped.set(reg);
            this.usedRopRegs.set(i4, category + i4);
            return;
        }
        throw new RuntimeException("attempt to add invalid register mapping");
    }

    private void adjustAndMapSourceRangeRange(NormalSsaInsn normalSsaInsn) {
        int findRangeAndAdjust = findRangeAndAdjust(normalSsaInsn);
        RegisterSpecList sources = normalSsaInsn.getSources();
        int size = sources.size();
        int i4 = 0;
        while (i4 < size) {
            RegisterSpec registerSpec = sources.get(i4);
            int reg = registerSpec.getReg();
            int category = registerSpec.getCategory();
            int i5 = findRangeAndAdjust + category;
            if (!this.ssaRegsMapped.get(reg)) {
                LocalItem localItemForReg = getLocalItemForReg(reg);
                addMapping(registerSpec, findRangeAndAdjust);
                if (localItemForReg != null) {
                    markReserved(findRangeAndAdjust, category);
                    ArrayList<RegisterSpec> arrayList = this.localVariables.get(localItemForReg);
                    int size2 = arrayList.size();
                    for (int i6 = 0; i6 < size2; i6++) {
                        RegisterSpec registerSpec2 = arrayList.get(i6);
                        if (-1 == sources.indexOfRegister(registerSpec2.getReg())) {
                            tryMapReg(registerSpec2, findRangeAndAdjust, category);
                        }
                    }
                }
            }
            i4++;
            findRangeAndAdjust = i5;
        }
    }

    private void analyzeInstructions() {
        this.ssaMeth.forEachInsn(new SsaInsn.Visitor() { // from class: com.android.dx.ssa.back.FirstFitLocalCombiningAllocator.1
            private void processInsn(SsaInsn ssaInsn) {
                RegisterSpec localAssignment = ssaInsn.getLocalAssignment();
                if (localAssignment != null) {
                    LocalItem localItem = localAssignment.getLocalItem();
                    ArrayList arrayList = (ArrayList) FirstFitLocalCombiningAllocator.this.localVariables.get(localItem);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        FirstFitLocalCombiningAllocator.this.localVariables.put(localItem, arrayList);
                    }
                    arrayList.add(localAssignment);
                }
                if (ssaInsn instanceof NormalSsaInsn) {
                    if (ssaInsn.getOpcode().getOpcode() == 56) {
                        FirstFitLocalCombiningAllocator.this.moveResultPseudoInsns.add((NormalSsaInsn) ssaInsn);
                    } else if (Optimizer.getAdvice().requiresSourcesInOrder(ssaInsn.getOriginalRopInsn().getOpcode(), ssaInsn.getSources())) {
                        FirstFitLocalCombiningAllocator.this.invokeRangeInsns.add((NormalSsaInsn) ssaInsn);
                    }
                } else if (ssaInsn instanceof PhiInsn) {
                    FirstFitLocalCombiningAllocator.this.phiInsns.add((PhiInsn) ssaInsn);
                }
            }

            @Override // com.android.dx.ssa.SsaInsn.Visitor
            public void visitMoveInsn(NormalSsaInsn normalSsaInsn) {
                processInsn(normalSsaInsn);
            }

            @Override // com.android.dx.ssa.SsaInsn.Visitor
            public void visitNonMoveInsn(NormalSsaInsn normalSsaInsn) {
                processInsn(normalSsaInsn);
            }

            @Override // com.android.dx.ssa.SsaInsn.Visitor
            public void visitPhiInsn(PhiInsn phiInsn) {
                processInsn(phiInsn);
            }
        });
    }

    private boolean canMapReg(RegisterSpec registerSpec, int i4) {
        if (!spansParamRange(i4, registerSpec.getCategory()) && !this.mapper.interferes(registerSpec, i4)) {
            return true;
        }
        return false;
    }

    private boolean canMapRegs(ArrayList<RegisterSpec> arrayList, int i4) {
        Iterator<RegisterSpec> it = arrayList.iterator();
        while (it.hasNext()) {
            RegisterSpec next = it.next();
            if (!this.ssaRegsMapped.get(next.getReg()) && !canMapReg(next, i4)) {
                return false;
            }
        }
        return true;
    }

    private int findAnyFittingRange(NormalSsaInsn normalSsaInsn, int i4, int[] iArr, BitSet bitSet) {
        Alignment alignment = Alignment.UNSPECIFIED;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 : iArr) {
            if (i8 == 2) {
                if (isEven(i7)) {
                    i6++;
                } else {
                    i5++;
                }
                i7 += 2;
            } else {
                i7++;
            }
        }
        if (i5 > i6) {
            if (isEven(this.paramRangeEnd)) {
                alignment = Alignment.ODD;
            } else {
                alignment = Alignment.EVEN;
            }
        } else if (i6 > 0) {
            if (isEven(this.paramRangeEnd)) {
                alignment = Alignment.EVEN;
            } else {
                alignment = Alignment.ODD;
            }
        }
        int i9 = this.paramRangeEnd;
        while (true) {
            int findNextUnreservedRopReg = findNextUnreservedRopReg(i9, i4, alignment);
            if (fitPlanForRange(findNextUnreservedRopReg, normalSsaInsn, iArr, bitSet) >= 0) {
                return findNextUnreservedRopReg;
            }
            i9 = findNextUnreservedRopReg + 1;
            bitSet.clear();
        }
    }

    private int findNextUnreservedRopReg(int i4, int i5) {
        return findNextUnreservedRopReg(i4, i5, getAlignment(i5));
    }

    private int findRangeAndAdjust(NormalSsaInsn normalSsaInsn) {
        int oldToNew;
        BitSet bitSet;
        int fitPlanForRange;
        RegisterSpecList sources = normalSsaInsn.getSources();
        int size = sources.size();
        int[] iArr = new int[size];
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            int category = sources.get(i5).getCategory();
            iArr[i5] = category;
            i4 += category;
        }
        int i6 = Integer.MIN_VALUE;
        BitSet bitSet2 = null;
        int i7 = 0;
        int i8 = -1;
        for (int i9 = 0; i9 < size; i9++) {
            int reg = sources.get(i9).getReg();
            if (i9 != 0) {
                i7 -= iArr[i9 - 1];
            }
            if (this.ssaRegsMapped.get(reg) && (oldToNew = this.mapper.oldToNew(reg) + i7) >= 0 && !spansParamRange(oldToNew, i4) && (fitPlanForRange = fitPlanForRange(oldToNew, normalSsaInsn, iArr, (bitSet = new BitSet(size)))) >= 0) {
                int cardinality = fitPlanForRange - bitSet.cardinality();
                if (cardinality > i6) {
                    i6 = cardinality;
                    i8 = oldToNew;
                    bitSet2 = bitSet;
                }
                if (fitPlanForRange == i4) {
                    break;
                }
            }
        }
        if (i8 == -1) {
            bitSet2 = new BitSet(size);
            i8 = findAnyFittingRange(normalSsaInsn, i4, iArr, bitSet2);
        }
        for (int nextSetBit = bitSet2.nextSetBit(0); nextSetBit >= 0; nextSetBit = bitSet2.nextSetBit(nextSetBit + 1)) {
            normalSsaInsn.changeOneSource(nextSetBit, insertMoveBefore(normalSsaInsn, sources.get(nextSetBit)));
        }
        return i8;
    }

    private int findRopRegForLocal(int i4, int i5) {
        Alignment alignment = getAlignment(i5);
        int nextClearBit = alignment.nextClearBit(this.usedRopRegs, i4);
        while (true) {
            int i6 = 1;
            while (i6 < i5 && !this.usedRopRegs.get(nextClearBit + i6)) {
                i6++;
            }
            if (i6 == i5) {
                return nextClearBit;
            }
            nextClearBit = alignment.nextClearBit(this.usedRopRegs, nextClearBit + i6);
        }
    }

    private int fitPlanForRange(int i4, NormalSsaInsn normalSsaInsn, int[] iArr, BitSet bitSet) {
        RegisterSpecList sources = normalSsaInsn.getSources();
        int size = sources.size();
        RegisterSpecList ssaSetToSpecs = ssaSetToSpecs(normalSsaInsn.getBlock().getLiveOutRegs());
        BitSet bitSet2 = new BitSet(this.ssaMeth.getRegCount());
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            RegisterSpec registerSpec = sources.get(i6);
            int reg = registerSpec.getReg();
            int i7 = iArr[i6];
            if (i6 != 0) {
                i4 += iArr[i6 - 1];
            }
            if (!this.ssaRegsMapped.get(reg) || this.mapper.oldToNew(reg) != i4) {
                if (!rangeContainsReserved(i4, i7)) {
                    if (this.ssaRegsMapped.get(reg) || !canMapReg(registerSpec, i4) || bitSet2.get(reg)) {
                        if (!this.mapper.areAnyPinned(ssaSetToSpecs, i4, i7) && !this.mapper.areAnyPinned(sources, i4, i7)) {
                            bitSet.set(i6);
                            bitSet2.set(reg);
                        }
                    }
                }
                return -1;
            }
            i5 += i7;
            bitSet2.set(reg);
        }
        return i5;
    }

    private Alignment getAlignment(int i4) {
        Alignment alignment = Alignment.UNSPECIFIED;
        if (i4 == 2) {
            if (isEven(this.paramRangeEnd)) {
                return Alignment.EVEN;
            }
            return Alignment.ODD;
        }
        return alignment;
    }

    private LocalItem getLocalItemForReg(int i4) {
        for (Map.Entry<LocalItem, ArrayList<RegisterSpec>> entry : this.localVariables.entrySet()) {
            Iterator<RegisterSpec> it = entry.getValue().iterator();
            while (it.hasNext()) {
                if (it.next().getReg() == i4) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    private int getParameterIndexForReg(int i4) {
        Rop opcode;
        SsaInsn definitionForRegister = this.ssaMeth.getDefinitionForRegister(i4);
        if (definitionForRegister == null || (opcode = definitionForRegister.getOpcode()) == null || opcode.getOpcode() != 3) {
            return -1;
        }
        return ((CstInteger) ((CstInsn) definitionForRegister.getOriginalRopInsn()).getConstant()).getValue();
    }

    private void handleCheckCastResults() {
        Iterator<NormalSsaInsn> it = this.moveResultPseudoInsns.iterator();
        while (it.hasNext()) {
            NormalSsaInsn next = it.next();
            RegisterSpec result = next.getResult();
            int reg = result.getReg();
            BitSet predecessors = next.getBlock().getPredecessors();
            boolean z3 = true;
            if (predecessors.cardinality() == 1) {
                ArrayList<SsaInsn> insns = this.ssaMeth.getBlocks().get(predecessors.nextSetBit(0)).getInsns();
                SsaInsn ssaInsn = insns.get(insns.size() - 1);
                if (ssaInsn.getOpcode().getOpcode() == 43) {
                    RegisterSpec registerSpec = ssaInsn.getSources().get(0);
                    int reg2 = registerSpec.getReg();
                    int category = registerSpec.getCategory();
                    boolean z4 = this.ssaRegsMapped.get(reg);
                    boolean z5 = this.ssaRegsMapped.get(reg2);
                    if ((!z5) & z4) {
                        z5 = tryMapReg(registerSpec, this.mapper.oldToNew(reg), category);
                    }
                    if ((!z4) & z5) {
                        z4 = tryMapReg(result, this.mapper.oldToNew(reg2), category);
                    }
                    if (!z4 || !z5) {
                        int findNextUnreservedRopReg = findNextUnreservedRopReg(this.paramRangeEnd, category);
                        ArrayList<RegisterSpec> arrayList = new ArrayList<>(2);
                        arrayList.add(result);
                        arrayList.add(registerSpec);
                        while (!tryMapRegs(arrayList, findNextUnreservedRopReg, category, false)) {
                            findNextUnreservedRopReg = findNextUnreservedRopReg(findNextUnreservedRopReg + 1, category);
                        }
                    }
                    if (ssaInsn.getOriginalRopInsn().getCatches().size() == 0) {
                        z3 = false;
                    }
                    int oldToNew = this.mapper.oldToNew(reg);
                    if (oldToNew != this.mapper.oldToNew(reg2) && !z3) {
                        ((NormalSsaInsn) ssaInsn).changeOneSource(0, insertMoveBefore(ssaInsn, registerSpec));
                        addMapping(ssaInsn.getSources().get(0), oldToNew);
                    }
                }
            }
        }
    }

    private void handleInvokeRangeInsns() {
        Iterator<NormalSsaInsn> it = this.invokeRangeInsns.iterator();
        while (it.hasNext()) {
            adjustAndMapSourceRangeRange(it.next());
        }
    }

    private void handleLocalAssociatedOther() {
        for (ArrayList<RegisterSpec> arrayList : this.localVariables.values()) {
            int i4 = this.paramRangeEnd;
            boolean z3 = false;
            do {
                int size = arrayList.size();
                int i5 = 1;
                for (int i6 = 0; i6 < size; i6++) {
                    RegisterSpec registerSpec = arrayList.get(i6);
                    int category = registerSpec.getCategory();
                    if (!this.ssaRegsMapped.get(registerSpec.getReg()) && category > i5) {
                        i5 = category;
                    }
                }
                int findRopRegForLocal = findRopRegForLocal(i4, i5);
                if (canMapRegs(arrayList, findRopRegForLocal)) {
                    z3 = tryMapRegs(arrayList, findRopRegForLocal, i5, true);
                }
                i4 = findRopRegForLocal + 1;
            } while (!z3);
        }
    }

    private void handleLocalAssociatedParams() {
        for (ArrayList<RegisterSpec> arrayList : this.localVariables.values()) {
            int size = arrayList.size();
            int i4 = 0;
            int i5 = -1;
            int i6 = 0;
            while (true) {
                if (i6 >= size) {
                    break;
                }
                RegisterSpec registerSpec = arrayList.get(i6);
                int parameterIndexForReg = getParameterIndexForReg(registerSpec.getReg());
                if (parameterIndexForReg >= 0) {
                    i4 = registerSpec.getCategory();
                    addMapping(registerSpec, parameterIndexForReg);
                    i5 = parameterIndexForReg;
                    break;
                }
                i6++;
                i5 = parameterIndexForReg;
            }
            if (i5 >= 0) {
                tryMapRegs(arrayList, i5, i4, true);
            }
        }
    }

    private void handleNormalUnassociated() {
        RegisterSpec definitionSpecForSsaReg;
        int regCount = this.ssaMeth.getRegCount();
        for (int i4 = 0; i4 < regCount; i4++) {
            if (!this.ssaRegsMapped.get(i4) && (definitionSpecForSsaReg = getDefinitionSpecForSsaReg(i4)) != null) {
                int category = definitionSpecForSsaReg.getCategory();
                int findNextUnreservedRopReg = findNextUnreservedRopReg(this.paramRangeEnd, category);
                while (!canMapReg(definitionSpecForSsaReg, findNextUnreservedRopReg)) {
                    findNextUnreservedRopReg = findNextUnreservedRopReg(findNextUnreservedRopReg + 1, category);
                }
                addMapping(definitionSpecForSsaReg, findNextUnreservedRopReg);
            }
        }
    }

    private void handlePhiInsns() {
        Iterator<PhiInsn> it = this.phiInsns.iterator();
        while (it.hasNext()) {
            processPhiInsn(it.next());
        }
    }

    private void handleUnassociatedParameters() {
        int regCount = this.ssaMeth.getRegCount();
        for (int i4 = 0; i4 < regCount; i4++) {
            if (!this.ssaRegsMapped.get(i4)) {
                int parameterIndexForReg = getParameterIndexForReg(i4);
                RegisterSpec definitionSpecForSsaReg = getDefinitionSpecForSsaReg(i4);
                if (parameterIndexForReg >= 0) {
                    addMapping(definitionSpecForSsaReg, parameterIndexForReg);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isEven(int i4) {
        if ((i4 & 1) == 0) {
            return true;
        }
        return false;
    }

    private boolean isThisPointerReg(int i4) {
        if (i4 == 0 && !this.ssaMeth.isStatic()) {
            return true;
        }
        return false;
    }

    private void markReserved(int i4, int i5) {
        this.reservedRopRegs.set(i4, i5 + i4, true);
    }

    private void printLocalVars() {
        System.out.println("Printing local vars");
        for (Map.Entry<LocalItem, ArrayList<RegisterSpec>> entry : this.localVariables.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append('{');
            sb.append(' ');
            Iterator<RegisterSpec> it = entry.getValue().iterator();
            while (it.hasNext()) {
                sb.append('v');
                sb.append(it.next().getReg());
                sb.append(' ');
            }
            sb.append('}');
            System.out.printf("Local: %s Registers: %s\n", entry.getKey(), sb);
        }
    }

    private void processPhiInsn(PhiInsn phiInsn) {
        RegisterSpec result = phiInsn.getResult();
        int reg = result.getReg();
        int category = result.getCategory();
        RegisterSpecList sources = phiInsn.getSources();
        int size = sources.size();
        ArrayList<RegisterSpec> arrayList = new ArrayList<>();
        Multiset multiset = new Multiset(size + 1);
        if (this.ssaRegsMapped.get(reg)) {
            multiset.add(this.mapper.oldToNew(reg));
        } else {
            arrayList.add(result);
        }
        for (int i4 = 0; i4 < size; i4++) {
            RegisterSpec result2 = this.ssaMeth.getDefinitionForRegister(sources.get(i4).getReg()).getResult();
            int reg2 = result2.getReg();
            if (this.ssaRegsMapped.get(reg2)) {
                multiset.add(this.mapper.oldToNew(reg2));
            } else {
                arrayList.add(result2);
            }
        }
        for (int i5 = 0; i5 < multiset.getSize(); i5++) {
            tryMapRegs(arrayList, multiset.getAndRemoveHighestCount(), category, false);
        }
        int findNextUnreservedRopReg = findNextUnreservedRopReg(this.paramRangeEnd, category);
        while (!tryMapRegs(arrayList, findNextUnreservedRopReg, category, false)) {
            findNextUnreservedRopReg = findNextUnreservedRopReg(findNextUnreservedRopReg + 1, category);
        }
    }

    private boolean rangeContainsReserved(int i4, int i5) {
        for (int i6 = i4; i6 < i4 + i5; i6++) {
            if (this.reservedRopRegs.get(i6)) {
                return true;
            }
        }
        return false;
    }

    private boolean spansParamRange(int i4, int i5) {
        int i6 = this.paramRangeEnd;
        if (i4 < i6 && i4 + i5 > i6) {
            return true;
        }
        return false;
    }

    private boolean tryMapReg(RegisterSpec registerSpec, int i4, int i5) {
        if (registerSpec.getCategory() <= i5 && !this.ssaRegsMapped.get(registerSpec.getReg()) && canMapReg(registerSpec, i4)) {
            addMapping(registerSpec, i4);
            return true;
        }
        return false;
    }

    private boolean tryMapRegs(ArrayList<RegisterSpec> arrayList, int i4, int i5, boolean z3) {
        Iterator<RegisterSpec> it = arrayList.iterator();
        boolean z4 = false;
        while (it.hasNext()) {
            RegisterSpec next = it.next();
            if (!this.ssaRegsMapped.get(next.getReg())) {
                boolean tryMapReg = tryMapReg(next, i4, i5);
                if (tryMapReg && !z4) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (tryMapReg && z3) {
                    markReserved(i4, next.getCategory());
                }
            }
        }
        return !z4;
    }

    @Override // com.android.dx.ssa.back.RegisterAllocator
    public RegisterMapper allocateRegisters() {
        analyzeInstructions();
        handleLocalAssociatedParams();
        handleUnassociatedParameters();
        handleInvokeRangeInsns();
        handleLocalAssociatedOther();
        handleCheckCastResults();
        handlePhiInsns();
        handleNormalUnassociated();
        return this.mapper;
    }

    RegisterSpecList ssaSetToSpecs(IntSet intSet) {
        RegisterSpecList registerSpecList = new RegisterSpecList(intSet.elements());
        IntIterator it = intSet.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            registerSpecList.set(i4, getDefinitionSpecForSsaReg(it.next()));
            i4++;
        }
        return registerSpecList;
    }

    @Override // com.android.dx.ssa.back.RegisterAllocator
    public boolean wantsParamsMovedHigh() {
        return true;
    }

    private int findNextUnreservedRopReg(int i4, int i5, Alignment alignment) {
        int nextClearBit = alignment.nextClearBit(this.reservedRopRegs, i4);
        while (true) {
            int i6 = 1;
            while (i6 < i5 && !this.reservedRopRegs.get(nextClearBit + i6)) {
                i6++;
            }
            if (i6 == i5) {
                return nextClearBit;
            }
            nextClearBit = alignment.nextClearBit(this.reservedRopRegs, nextClearBit + i6);
        }
    }
}
