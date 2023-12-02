package com.android.dx.cf.code;

import com.android.dx.util.FixedSizeList;

/* loaded from: classes2.dex */
public final class LineNumberList extends FixedSizeList {
    public static final LineNumberList EMPTY = new LineNumberList(0);

    /* loaded from: classes2.dex */
    public static class Item {
        private final int lineNumber;
        private final int startPc;

        public Item(int i4, int i5) {
            if (i4 >= 0) {
                if (i5 >= 0) {
                    this.startPc = i4;
                    this.lineNumber = i5;
                    return;
                }
                throw new IllegalArgumentException("lineNumber < 0");
            }
            throw new IllegalArgumentException("startPc < 0");
        }

        public int getLineNumber() {
            return this.lineNumber;
        }

        public int getStartPc() {
            return this.startPc;
        }
    }

    public LineNumberList(int i4) {
        super(i4);
    }

    public static LineNumberList concat(LineNumberList lineNumberList, LineNumberList lineNumberList2) {
        if (lineNumberList == EMPTY) {
            return lineNumberList2;
        }
        int size = lineNumberList.size();
        int size2 = lineNumberList2.size();
        LineNumberList lineNumberList3 = new LineNumberList(size + size2);
        for (int i4 = 0; i4 < size; i4++) {
            lineNumberList3.set(i4, lineNumberList.get(i4));
        }
        for (int i5 = 0; i5 < size2; i5++) {
            lineNumberList3.set(size + i5, lineNumberList2.get(i5));
        }
        return lineNumberList3;
    }

    public Item get(int i4) {
        return (Item) get0(i4);
    }

    public int pcToLine(int i4) {
        int size = size();
        int i5 = -1;
        int i6 = -1;
        for (int i7 = 0; i7 < size; i7++) {
            Item item = get(i7);
            int startPc = item.getStartPc();
            if (startPc <= i4 && startPc > i5) {
                i6 = item.getLineNumber();
                if (startPc == i4) {
                    break;
                }
                i5 = startPc;
            }
        }
        return i6;
    }

    public void set(int i4, Item item) {
        if (item != null) {
            set0(i4, item);
            return;
        }
        throw new NullPointerException("item == null");
    }

    public void set(int i4, int i5, int i6) {
        set0(i4, new Item(i5, i6));
    }
}
