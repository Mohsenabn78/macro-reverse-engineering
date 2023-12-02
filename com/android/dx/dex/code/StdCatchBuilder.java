package com.android.dx.dex.code;

import com.android.dx.dex.code.CatchTable;
import com.android.dx.rop.code.BasicBlock;
import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.IntList;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class StdCatchBuilder implements CatchBuilder {
    private static final int MAX_CATCH_RANGE = 65535;
    private final BlockAddresses addresses;
    private final RopMethod method;
    private final int[] order;

    public StdCatchBuilder(RopMethod ropMethod, int[] iArr, BlockAddresses blockAddresses) {
        if (ropMethod != null) {
            if (iArr != null) {
                if (blockAddresses != null) {
                    this.method = ropMethod;
                    this.order = iArr;
                    this.addresses = blockAddresses;
                    return;
                }
                throw new NullPointerException("addresses == null");
            }
            throw new NullPointerException("order == null");
        }
        throw new NullPointerException("method == null");
    }

    private static CatchHandlerList handlersFor(BasicBlock basicBlock, BlockAddresses blockAddresses) {
        IntList successors = basicBlock.getSuccessors();
        int size = successors.size();
        int primarySuccessor = basicBlock.getPrimarySuccessor();
        TypeList catches = basicBlock.getLastInsn().getCatches();
        int size2 = catches.size();
        if (size2 == 0) {
            return CatchHandlerList.EMPTY;
        }
        if ((primarySuccessor == -1 && size != size2) || (primarySuccessor != -1 && (size != size2 + 1 || primarySuccessor != successors.get(size2)))) {
            throw new RuntimeException("shouldn't happen: weird successors list");
        }
        int i4 = 0;
        while (true) {
            if (i4 >= size2) {
                break;
            } else if (catches.getType(i4).equals(Type.OBJECT)) {
                size2 = i4 + 1;
                break;
            } else {
                i4++;
            }
        }
        CatchHandlerList catchHandlerList = new CatchHandlerList(size2);
        for (int i5 = 0; i5 < size2; i5++) {
            catchHandlerList.set(i5, new CstType(catches.getType(i5)), blockAddresses.getStart(successors.get(i5)).getAddress());
        }
        catchHandlerList.setImmutable();
        return catchHandlerList;
    }

    private static CatchTable.Entry makeEntry(BasicBlock basicBlock, BasicBlock basicBlock2, CatchHandlerList catchHandlerList, BlockAddresses blockAddresses) {
        return new CatchTable.Entry(blockAddresses.getLast(basicBlock).getAddress(), blockAddresses.getEnd(basicBlock2).getAddress(), catchHandlerList);
    }

    private static boolean rangeIsValid(BasicBlock basicBlock, BasicBlock basicBlock2, BlockAddresses blockAddresses) {
        if (basicBlock != null) {
            if (basicBlock2 != null) {
                if (blockAddresses.getEnd(basicBlock2).getAddress() - blockAddresses.getLast(basicBlock).getAddress() <= 65535) {
                    return true;
                }
                return false;
            }
            throw new NullPointerException("end == null");
        }
        throw new NullPointerException("start == null");
    }

    @Override // com.android.dx.dex.code.CatchBuilder
    public CatchTable build() {
        return build(this.method, this.order, this.addresses);
    }

    @Override // com.android.dx.dex.code.CatchBuilder
    public HashSet<Type> getCatchTypes() {
        HashSet<Type> hashSet = new HashSet<>(20);
        BasicBlockList blocks = this.method.getBlocks();
        int size = blocks.size();
        for (int i4 = 0; i4 < size; i4++) {
            TypeList catches = blocks.get(i4).getLastInsn().getCatches();
            int size2 = catches.size();
            for (int i5 = 0; i5 < size2; i5++) {
                hashSet.add(catches.getType(i5));
            }
        }
        return hashSet;
    }

    @Override // com.android.dx.dex.code.CatchBuilder
    public boolean hasAnyCatches() {
        BasicBlockList blocks = this.method.getBlocks();
        int size = blocks.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (blocks.get(i4).getLastInsn().getCatches().size() != 0) {
                return true;
            }
        }
        return false;
    }

    public static CatchTable build(RopMethod ropMethod, int[] iArr, BlockAddresses blockAddresses) {
        int length = iArr.length;
        BasicBlockList blocks = ropMethod.getBlocks();
        ArrayList arrayList = new ArrayList(length);
        CatchHandlerList catchHandlerList = CatchHandlerList.EMPTY;
        BasicBlock basicBlock = null;
        BasicBlock basicBlock2 = null;
        for (int i4 : iArr) {
            BasicBlock labelToBlock = blocks.labelToBlock(i4);
            if (labelToBlock.canThrow()) {
                CatchHandlerList handlersFor = handlersFor(labelToBlock, blockAddresses);
                if (catchHandlerList.size() != 0) {
                    if (catchHandlerList.equals(handlersFor) && rangeIsValid(basicBlock, labelToBlock, blockAddresses)) {
                        basicBlock2 = labelToBlock;
                    } else if (catchHandlerList.size() != 0) {
                        arrayList.add(makeEntry(basicBlock, basicBlock2, catchHandlerList, blockAddresses));
                    }
                }
                basicBlock = labelToBlock;
                basicBlock2 = basicBlock;
                catchHandlerList = handlersFor;
            }
        }
        if (catchHandlerList.size() != 0) {
            arrayList.add(makeEntry(basicBlock, basicBlock2, catchHandlerList, blockAddresses));
        }
        int size = arrayList.size();
        if (size == 0) {
            return CatchTable.EMPTY;
        }
        CatchTable catchTable = new CatchTable(size);
        for (int i5 = 0; i5 < size; i5++) {
            catchTable.set(i5, (CatchTable.Entry) arrayList.get(i5));
        }
        catchTable.setImmutable();
        return catchTable;
    }
}
