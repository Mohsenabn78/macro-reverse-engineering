package com.android.dx.cf.code;

import com.android.dx.util.Hex;
import com.android.dx.util.LabeledItem;
import com.android.dx.util.LabeledList;

/* loaded from: classes2.dex */
public final class ByteBlockList extends LabeledList {
    public ByteBlockList(int i4) {
        super(i4);
    }

    public ByteBlock get(int i4) {
        return (ByteBlock) get0(i4);
    }

    public ByteBlock labelToBlock(int i4) {
        int indexOfLabel = indexOfLabel(i4);
        if (indexOfLabel >= 0) {
            return get(indexOfLabel);
        }
        throw new IllegalArgumentException("no such label: " + Hex.u2(i4));
    }

    public void set(int i4, ByteBlock byteBlock) {
        super.set(i4, (LabeledItem) byteBlock);
    }
}
