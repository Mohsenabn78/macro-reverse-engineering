package com.android.dx.util;

import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public class ListIntSet implements IntSet {
    final IntList ints;

    public ListIntSet() {
        IntList intList = new IntList();
        this.ints = intList;
        intList.sort();
    }

    @Override // com.android.dx.util.IntSet
    public void add(int i4) {
        int binarysearch = this.ints.binarysearch(i4);
        if (binarysearch < 0) {
            this.ints.insert(-(binarysearch + 1), i4);
        }
    }

    @Override // com.android.dx.util.IntSet
    public int elements() {
        return this.ints.size();
    }

    @Override // com.android.dx.util.IntSet
    public boolean has(int i4) {
        if (this.ints.indexOf(i4) >= 0) {
            return true;
        }
        return false;
    }

    @Override // com.android.dx.util.IntSet
    public IntIterator iterator() {
        return new IntIterator() { // from class: com.android.dx.util.ListIntSet.1
            private int idx = 0;

            @Override // com.android.dx.util.IntIterator
            public boolean hasNext() {
                if (this.idx < ListIntSet.this.ints.size()) {
                    return true;
                }
                return false;
            }

            @Override // com.android.dx.util.IntIterator
            public int next() {
                if (hasNext()) {
                    IntList intList = ListIntSet.this.ints;
                    int i4 = this.idx;
                    this.idx = i4 + 1;
                    return intList.get(i4);
                }
                throw new NoSuchElementException();
            }
        };
    }

    @Override // com.android.dx.util.IntSet
    public void merge(IntSet intSet) {
        int i4 = 0;
        if (intSet instanceof ListIntSet) {
            ListIntSet listIntSet = (ListIntSet) intSet;
            int size = this.ints.size();
            int size2 = listIntSet.ints.size();
            int i5 = 0;
            while (i4 < size2 && i5 < size) {
                while (i4 < size2 && listIntSet.ints.get(i4) < this.ints.get(i5)) {
                    add(listIntSet.ints.get(i4));
                    i4++;
                }
                if (i4 == size2) {
                    break;
                }
                while (i5 < size && listIntSet.ints.get(i4) >= this.ints.get(i5)) {
                    i5++;
                }
            }
            while (i4 < size2) {
                add(listIntSet.ints.get(i4));
                i4++;
            }
            this.ints.sort();
        } else if (intSet instanceof BitIntSet) {
            BitIntSet bitIntSet = (BitIntSet) intSet;
            while (i4 >= 0) {
                this.ints.add(i4);
                i4 = Bits.findFirst(bitIntSet.bits, i4 + 1);
            }
            this.ints.sort();
        } else {
            IntIterator it = intSet.iterator();
            while (it.hasNext()) {
                add(it.next());
            }
        }
    }

    @Override // com.android.dx.util.IntSet
    public void remove(int i4) {
        int indexOf = this.ints.indexOf(i4);
        if (indexOf >= 0) {
            this.ints.removeIndex(indexOf);
        }
    }

    public String toString() {
        return this.ints.toString();
    }
}
