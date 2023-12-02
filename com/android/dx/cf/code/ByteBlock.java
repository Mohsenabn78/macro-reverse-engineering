package com.android.dx.cf.code;

import com.android.dx.util.Hex;
import com.android.dx.util.IntList;
import com.android.dx.util.LabeledItem;

/* loaded from: classes2.dex */
public final class ByteBlock implements LabeledItem {
    private final ByteCatchList catches;
    private final int end;
    private final int label;
    private final int start;
    private final IntList successors;

    public ByteBlock(int i4, int i5, int i6, IntList intList, ByteCatchList byteCatchList) {
        if (i4 >= 0) {
            if (i5 >= 0) {
                if (i6 > i5) {
                    if (intList != null) {
                        int size = intList.size();
                        for (int i7 = 0; i7 < size; i7++) {
                            if (intList.get(i7) < 0) {
                                throw new IllegalArgumentException("successors[" + i7 + "] == " + intList.get(i7));
                            }
                        }
                        if (byteCatchList != null) {
                            this.label = i4;
                            this.start = i5;
                            this.end = i6;
                            this.successors = intList;
                            this.catches = byteCatchList;
                            return;
                        }
                        throw new NullPointerException("catches == null");
                    }
                    throw new NullPointerException("targets == null");
                }
                throw new IllegalArgumentException("end <= start");
            }
            throw new IllegalArgumentException("start < 0");
        }
        throw new IllegalArgumentException("label < 0");
    }

    public ByteCatchList getCatches() {
        return this.catches;
    }

    public int getEnd() {
        return this.end;
    }

    @Override // com.android.dx.util.LabeledItem
    public int getLabel() {
        return this.label;
    }

    public int getStart() {
        return this.start;
    }

    public IntList getSuccessors() {
        return this.successors;
    }

    public String toString() {
        return '{' + Hex.u2(this.label) + ": " + Hex.u2(this.start) + ".." + Hex.u2(this.end) + '}';
    }
}
