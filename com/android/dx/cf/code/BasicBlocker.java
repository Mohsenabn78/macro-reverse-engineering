package com.android.dx.cf.code;

import com.android.dx.cf.code.ByteCatchList;
import com.android.dx.cf.code.BytecodeArray;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstMemberRef;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.util.Bits;
import com.android.dx.util.IntList;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class BasicBlocker implements BytecodeArray.Visitor {
    private final int[] blockSet;
    private final ByteCatchList[] catchLists;
    private final int[] liveSet;
    private final ConcreteMethod method;
    private int previousOffset;
    private final IntList[] targetLists;
    private final int[] workSet;

    private BasicBlocker(ConcreteMethod concreteMethod) {
        if (concreteMethod != null) {
            this.method = concreteMethod;
            int size = concreteMethod.getCode().size() + 1;
            this.workSet = Bits.makeBitSet(size);
            this.liveSet = Bits.makeBitSet(size);
            this.blockSet = Bits.makeBitSet(size);
            this.targetLists = new IntList[size];
            this.catchLists = new ByteCatchList[size];
            this.previousOffset = -1;
            return;
        }
        throw new NullPointerException("method == null");
    }

    private void addWorkIfNecessary(int i4, boolean z3) {
        if (!Bits.get(this.liveSet, i4)) {
            Bits.set(this.workSet, i4);
        }
        if (z3) {
            Bits.set(this.blockSet, i4);
        }
    }

    private void doit() {
        BytecodeArray code = this.method.getCode();
        ByteCatchList catches = this.method.getCatches();
        int size = catches.size();
        Bits.set(this.workSet, 0);
        Bits.set(this.blockSet, 0);
        while (!Bits.isEmpty(this.workSet)) {
            try {
                code.processWorkSet(this.workSet, this);
                for (int i4 = 0; i4 < size; i4++) {
                    ByteCatchList.Item item = catches.get(i4);
                    int startPc = item.getStartPc();
                    int endPc = item.getEndPc();
                    if (Bits.anyInRange(this.liveSet, startPc, endPc)) {
                        Bits.set(this.blockSet, startPc);
                        Bits.set(this.blockSet, endPc);
                        addWorkIfNecessary(item.getHandlerPc(), true);
                    }
                }
            } catch (IllegalArgumentException e4) {
                throw new SimException("flow of control falls off end of method", e4);
            }
        }
    }

    private ByteBlockList getBlockList() {
        ByteCatchList byteCatchList;
        IntList intList;
        ByteBlock[] byteBlockArr = new ByteBlock[this.method.getCode().size()];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int findFirst = Bits.findFirst(this.blockSet, i4 + 1);
            if (findFirst < 0) {
                break;
            }
            if (Bits.get(this.liveSet, i4)) {
                int i6 = findFirst - 1;
                IntList intList2 = null;
                while (true) {
                    if (i6 >= i4) {
                        intList2 = this.targetLists[i6];
                        if (intList2 != null) {
                            break;
                        }
                        i6--;
                    } else {
                        i6 = -1;
                        break;
                    }
                }
                if (intList2 == null) {
                    intList = IntList.makeImmutable(findFirst);
                    byteCatchList = ByteCatchList.EMPTY;
                } else {
                    ByteCatchList byteCatchList2 = this.catchLists[i6];
                    if (byteCatchList2 == null) {
                        byteCatchList2 = ByteCatchList.EMPTY;
                    }
                    byteCatchList = byteCatchList2;
                    intList = intList2;
                }
                byteBlockArr[i5] = new ByteBlock(i4, i4, findFirst, intList, byteCatchList);
                i5++;
            }
            i4 = findFirst;
        }
        ByteBlockList byteBlockList = new ByteBlockList(i5);
        for (int i7 = 0; i7 < i5; i7++) {
            byteBlockList.set(i7, byteBlockArr[i7]);
        }
        return byteBlockList;
    }

    public static ByteBlockList identifyBlocks(ConcreteMethod concreteMethod) {
        BasicBlocker basicBlocker = new BasicBlocker(concreteMethod);
        basicBlocker.doit();
        return basicBlocker.getBlockList();
    }

    private void visitCommon(int i4, int i5, boolean z3) {
        Bits.set(this.liveSet, i4);
        if (z3) {
            addWorkIfNecessary(i4 + i5, false);
        } else {
            Bits.set(this.blockSet, i4 + i5);
        }
    }

    private void visitThrowing(int i4, int i5, boolean z3) {
        int i6 = i5 + i4;
        if (z3) {
            addWorkIfNecessary(i6, true);
        }
        ByteCatchList listFor = this.method.getCatches().listFor(i4);
        this.catchLists[i4] = listFor;
        IntList[] intListArr = this.targetLists;
        if (!z3) {
            i6 = -1;
        }
        intListArr[i4] = listFor.toTargetList(i6);
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public int getPreviousOffset() {
        return this.previousOffset;
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void setPreviousOffset(int i4) {
        this.previousOffset = i4;
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitBranch(int i4, int i5, int i6, int i7) {
        if (i4 != 167) {
            if (i4 == 168) {
                addWorkIfNecessary(i5, true);
            }
            int i8 = i5 + i6;
            visitCommon(i5, i6, true);
            addWorkIfNecessary(i8, true);
            this.targetLists[i5] = IntList.makeImmutable(i8, i7);
        } else {
            visitCommon(i5, i6, false);
            this.targetLists[i5] = IntList.makeImmutable(i7);
        }
        addWorkIfNecessary(i7, true);
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitConstant(int i4, int i5, int i6, Constant constant, int i7) {
        visitCommon(i5, i6, true);
        if ((constant instanceof CstMemberRef) || (constant instanceof CstType) || (constant instanceof CstString)) {
            visitThrowing(i5, i6, true);
        }
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitInvalid(int i4, int i5, int i6) {
        visitCommon(i5, i6, true);
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitLocal(int i4, int i5, int i6, int i7, Type type, int i8) {
        if (i4 == 169) {
            visitCommon(i5, i6, false);
            this.targetLists[i5] = IntList.EMPTY;
            return;
        }
        visitCommon(i5, i6, true);
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitNewarray(int i4, int i5, CstType cstType, ArrayList<Constant> arrayList) {
        visitCommon(i4, i5, true);
        visitThrowing(i4, i5, true);
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitNoArgs(int i4, int i5, int i6, Type type) {
        if (i4 != 108 && i4 != 112) {
            if (i4 != 172 && i4 != 177) {
                if (i4 != 190) {
                    if (i4 != 191) {
                        if (i4 != 194 && i4 != 195) {
                            switch (i4) {
                                case 46:
                                case 47:
                                case 48:
                                case 49:
                                case 50:
                                case 51:
                                case 52:
                                case 53:
                                    break;
                                default:
                                    switch (i4) {
                                        case 79:
                                        case 80:
                                        case 81:
                                        case 82:
                                        case 83:
                                        case 84:
                                        case 85:
                                        case 86:
                                            break;
                                        default:
                                            visitCommon(i5, i6, true);
                                            return;
                                    }
                            }
                        }
                    } else {
                        visitCommon(i5, i6, false);
                        visitThrowing(i5, i6, false);
                        return;
                    }
                }
                visitCommon(i5, i6, true);
                visitThrowing(i5, i6, true);
                return;
            }
            visitCommon(i5, i6, false);
            this.targetLists[i5] = IntList.EMPTY;
            return;
        }
        visitCommon(i5, i6, true);
        if (type == Type.INT || type == Type.LONG) {
            visitThrowing(i5, i6, true);
        }
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitSwitch(int i4, int i5, int i6, SwitchList switchList, int i7) {
        visitCommon(i5, i6, false);
        addWorkIfNecessary(switchList.getDefaultTarget(), true);
        int size = switchList.size();
        for (int i8 = 0; i8 < size; i8++) {
            addWorkIfNecessary(switchList.getTarget(i8), true);
        }
        this.targetLists[i5] = switchList.getTargets();
    }
}
