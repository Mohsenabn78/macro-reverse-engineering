package com.android.dx.cf.code;

import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.FixedSizeList;
import com.android.dx.util.IntList;

/* loaded from: classes2.dex */
public final class ByteCatchList extends FixedSizeList {
    public static final ByteCatchList EMPTY = new ByteCatchList(0);

    /* loaded from: classes2.dex */
    public static class Item {
        private final int endPc;
        private final CstType exceptionClass;
        private final int handlerPc;
        private final int startPc;

        public Item(int i4, int i5, int i6, CstType cstType) {
            if (i4 >= 0) {
                if (i5 >= i4) {
                    if (i6 >= 0) {
                        this.startPc = i4;
                        this.endPc = i5;
                        this.handlerPc = i6;
                        this.exceptionClass = cstType;
                        return;
                    }
                    throw new IllegalArgumentException("handlerPc < 0");
                }
                throw new IllegalArgumentException("endPc < startPc");
            }
            throw new IllegalArgumentException("startPc < 0");
        }

        public boolean covers(int i4) {
            if (i4 >= this.startPc && i4 < this.endPc) {
                return true;
            }
            return false;
        }

        public int getEndPc() {
            return this.endPc;
        }

        public CstType getExceptionClass() {
            CstType cstType = this.exceptionClass;
            if (cstType == null) {
                return CstType.OBJECT;
            }
            return cstType;
        }

        public int getHandlerPc() {
            return this.handlerPc;
        }

        public int getStartPc() {
            return this.startPc;
        }
    }

    public ByteCatchList(int i4) {
        super(i4);
    }

    private static boolean typeNotFound(Item item, Item[] itemArr, int i4) {
        CstType exceptionClass = item.getExceptionClass();
        for (int i5 = 0; i5 < i4; i5++) {
            CstType exceptionClass2 = itemArr[i5].getExceptionClass();
            if (exceptionClass2 == exceptionClass || exceptionClass2 == CstType.OBJECT) {
                return false;
            }
        }
        return true;
    }

    public int byteLength() {
        return (size() * 8) + 2;
    }

    public Item get(int i4) {
        return (Item) get0(i4);
    }

    public ByteCatchList listFor(int i4) {
        int size = size();
        Item[] itemArr = new Item[size];
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            Item item = get(i6);
            if (item.covers(i4) && typeNotFound(item, itemArr, i5)) {
                itemArr[i5] = item;
                i5++;
            }
        }
        if (i5 == 0) {
            return EMPTY;
        }
        ByteCatchList byteCatchList = new ByteCatchList(i5);
        for (int i7 = 0; i7 < i5; i7++) {
            byteCatchList.set(i7, itemArr[i7]);
        }
        byteCatchList.setImmutable();
        return byteCatchList;
    }

    public void set(int i4, Item item) {
        if (item != null) {
            set0(i4, item);
            return;
        }
        throw new NullPointerException("item == null");
    }

    public TypeList toRopCatchList() {
        int size = size();
        if (size == 0) {
            return StdTypeList.EMPTY;
        }
        StdTypeList stdTypeList = new StdTypeList(size);
        for (int i4 = 0; i4 < size; i4++) {
            stdTypeList.set(i4, get(i4).getExceptionClass().getClassType());
        }
        stdTypeList.setImmutable();
        return stdTypeList;
    }

    public IntList toTargetList(int i4) {
        int i5;
        if (i4 >= -1) {
            if (i4 >= 0) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            int size = size();
            if (size == 0) {
                if (i5 != 0) {
                    return IntList.makeImmutable(i4);
                }
                return IntList.EMPTY;
            }
            IntList intList = new IntList(size + i5);
            for (int i6 = 0; i6 < size; i6++) {
                intList.add(get(i6).getHandlerPc());
            }
            if (i5 != 0) {
                intList.add(i4);
            }
            intList.setImmutable();
            return intList;
        }
        throw new IllegalArgumentException("noException < -1");
    }

    public void set(int i4, int i5, int i6, int i7, CstType cstType) {
        set0(i4, new Item(i5, i6, i7, cstType));
    }
}
