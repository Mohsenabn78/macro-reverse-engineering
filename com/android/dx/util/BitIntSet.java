package com.android.dx.util;

import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public class BitIntSet implements IntSet {
    int[] bits;

    public BitIntSet(int i4) {
        this.bits = Bits.makeBitSet(i4);
    }

    private void ensureCapacity(int i4) {
        if (i4 >= Bits.getMax(this.bits)) {
            int[] makeBitSet = Bits.makeBitSet(Math.max(i4 + 1, Bits.getMax(this.bits) * 2));
            int[] iArr = this.bits;
            System.arraycopy(iArr, 0, makeBitSet, 0, iArr.length);
            this.bits = makeBitSet;
        }
    }

    @Override // com.android.dx.util.IntSet
    public void add(int i4) {
        ensureCapacity(i4);
        Bits.set(this.bits, i4, true);
    }

    @Override // com.android.dx.util.IntSet
    public int elements() {
        return Bits.bitCount(this.bits);
    }

    @Override // com.android.dx.util.IntSet
    public boolean has(int i4) {
        if (i4 < Bits.getMax(this.bits) && Bits.get(this.bits, i4)) {
            return true;
        }
        return false;
    }

    @Override // com.android.dx.util.IntSet
    public IntIterator iterator() {
        return new IntIterator() { // from class: com.android.dx.util.BitIntSet.1
            private int idx;

            {
                this.idx = Bits.findFirst(BitIntSet.this.bits, 0);
            }

            @Override // com.android.dx.util.IntIterator
            public boolean hasNext() {
                if (this.idx >= 0) {
                    return true;
                }
                return false;
            }

            @Override // com.android.dx.util.IntIterator
            public int next() {
                if (hasNext()) {
                    int i4 = this.idx;
                    this.idx = Bits.findFirst(BitIntSet.this.bits, i4 + 1);
                    return i4;
                }
                throw new NoSuchElementException();
            }
        };
    }

    @Override // com.android.dx.util.IntSet
    public void merge(IntSet intSet) {
        if (intSet instanceof BitIntSet) {
            BitIntSet bitIntSet = (BitIntSet) intSet;
            ensureCapacity(Bits.getMax(bitIntSet.bits) + 1);
            Bits.or(this.bits, bitIntSet.bits);
        } else if (intSet instanceof ListIntSet) {
            ListIntSet listIntSet = (ListIntSet) intSet;
            int size = listIntSet.ints.size();
            if (size > 0) {
                ensureCapacity(listIntSet.ints.get(size - 1));
            }
            for (int i4 = 0; i4 < listIntSet.ints.size(); i4++) {
                Bits.set(this.bits, listIntSet.ints.get(i4), true);
            }
        } else {
            IntIterator it = intSet.iterator();
            while (it.hasNext()) {
                add(it.next());
            }
        }
    }

    @Override // com.android.dx.util.IntSet
    public void remove(int i4) {
        if (i4 < Bits.getMax(this.bits)) {
            Bits.set(this.bits, i4, false);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        int findFirst = Bits.findFirst(this.bits, 0);
        boolean z3 = true;
        while (findFirst >= 0) {
            if (!z3) {
                sb.append(", ");
            }
            sb.append(findFirst);
            findFirst = Bits.findFirst(this.bits, findFirst + 1);
            z3 = false;
        }
        sb.append('}');
        return sb.toString();
    }
}
