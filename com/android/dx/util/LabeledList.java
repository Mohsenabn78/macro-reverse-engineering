package com.android.dx.util;

import java.util.Arrays;

/* loaded from: classes2.dex */
public class LabeledList extends FixedSizeList {
    private final IntList labelToIndex;

    public LabeledList(int i4) {
        super(i4);
        this.labelToIndex = new IntList(i4);
    }

    private void addLabelIndex(int i4, int i5) {
        int size = this.labelToIndex.size();
        for (int i6 = 0; i6 <= i4 - size; i6++) {
            this.labelToIndex.add(-1);
        }
        this.labelToIndex.set(i4, i5);
    }

    private void rebuildLabelToIndex() {
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            LabeledItem labeledItem = (LabeledItem) get0(i4);
            if (labeledItem != null) {
                this.labelToIndex.set(labeledItem.getLabel(), i4);
            }
        }
    }

    private void removeLabel(int i4) {
        this.labelToIndex.set(i4, -1);
    }

    public final int[] getLabelsInOrder() {
        int size = size();
        int[] iArr = new int[size];
        for (int i4 = 0; i4 < size; i4++) {
            LabeledItem labeledItem = (LabeledItem) get0(i4);
            if (labeledItem != null) {
                iArr[i4] = labeledItem.getLabel();
            } else {
                throw new NullPointerException("null at index " + i4);
            }
        }
        Arrays.sort(iArr);
        return iArr;
    }

    public final int getMaxLabel() {
        int size = this.labelToIndex.size() - 1;
        while (size >= 0 && this.labelToIndex.get(size) < 0) {
            size--;
        }
        int i4 = size + 1;
        this.labelToIndex.shrink(i4);
        return i4;
    }

    public final int indexOfLabel(int i4) {
        if (i4 >= this.labelToIndex.size()) {
            return -1;
        }
        return this.labelToIndex.get(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void set(int i4, LabeledItem labeledItem) {
        LabeledItem labeledItem2 = (LabeledItem) getOrNull0(i4);
        set0(i4, labeledItem);
        if (labeledItem2 != null) {
            removeLabel(labeledItem2.getLabel());
        }
        if (labeledItem != null) {
            addLabelIndex(labeledItem.getLabel(), i4);
        }
    }

    @Override // com.android.dx.util.FixedSizeList
    public void shrinkToFit() {
        super.shrinkToFit();
        rebuildLabelToIndex();
    }

    public LabeledList(LabeledList labeledList) {
        super(labeledList.size());
        this.labelToIndex = labeledList.labelToIndex.mutableCopy();
        int size = labeledList.size();
        for (int i4 = 0; i4 < size; i4++) {
            Object obj = labeledList.get0(i4);
            if (obj != null) {
                set0(i4, obj);
            }
        }
    }
}
