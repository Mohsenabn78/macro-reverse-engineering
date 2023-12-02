package com.android.dx.util;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class IntList extends MutabilityControl {
    public static final IntList EMPTY;
    private int size;
    private boolean sorted;
    private int[] values;

    static {
        IntList intList = new IntList(0);
        EMPTY = intList;
        intList.setImmutable();
    }

    public IntList() {
        this(4);
    }

    private void growIfNeeded() {
        int i4 = this.size;
        int[] iArr = this.values;
        if (i4 == iArr.length) {
            int[] iArr2 = new int[((i4 * 3) / 2) + 10];
            System.arraycopy(iArr, 0, iArr2, 0, i4);
            this.values = iArr2;
        }
    }

    public static IntList makeImmutable(int i4) {
        IntList intList = new IntList(1);
        intList.add(i4);
        intList.setImmutable();
        return intList;
    }

    public void add(int i4) {
        throwIfImmutable();
        growIfNeeded();
        int[] iArr = this.values;
        int i5 = this.size;
        int i6 = i5 + 1;
        this.size = i6;
        iArr[i5] = i4;
        if (this.sorted) {
            boolean z3 = true;
            if (i6 > 1) {
                if (i4 < iArr[i6 - 2]) {
                    z3 = false;
                }
                this.sorted = z3;
            }
        }
    }

    public int binarysearch(int i4) {
        int i5 = this.size;
        if (!this.sorted) {
            for (int i6 = 0; i6 < i5; i6++) {
                if (this.values[i6] == i4) {
                    return i6;
                }
            }
            return -i5;
        }
        int i7 = -1;
        int i8 = i5;
        while (i8 > i7 + 1) {
            int i9 = ((i8 - i7) >> 1) + i7;
            if (i4 <= this.values[i9]) {
                i8 = i9;
            } else {
                i7 = i9;
            }
        }
        if (i8 != i5) {
            if (i4 != this.values[i8]) {
                return (-i8) - 1;
            }
            return i8;
        }
        return (-i5) - 1;
    }

    public boolean contains(int i4) {
        if (indexOf(i4) >= 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IntList)) {
            return false;
        }
        IntList intList = (IntList) obj;
        if (this.sorted != intList.sorted || this.size != intList.size) {
            return false;
        }
        for (int i4 = 0; i4 < this.size; i4++) {
            if (this.values[i4] != intList.values[i4]) {
                return false;
            }
        }
        return true;
    }

    public int get(int i4) {
        if (i4 < this.size) {
            try {
                return this.values[i4];
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new IndexOutOfBoundsException("n < 0");
            }
        }
        throw new IndexOutOfBoundsException("n >= size()");
    }

    public int hashCode() {
        int i4 = 0;
        for (int i5 = 0; i5 < this.size; i5++) {
            i4 = (i4 * 31) + this.values[i5];
        }
        return i4;
    }

    public int indexOf(int i4) {
        int binarysearch = binarysearch(i4);
        if (binarysearch < 0) {
            return -1;
        }
        return binarysearch;
    }

    public void insert(int i4, int i5) {
        if (i4 <= this.size) {
            growIfNeeded();
            int[] iArr = this.values;
            int i6 = i4 + 1;
            System.arraycopy(iArr, i4, iArr, i6, this.size - i4);
            int[] iArr2 = this.values;
            iArr2[i4] = i5;
            boolean z3 = true;
            int i7 = this.size + 1;
            this.size = i7;
            if (!this.sorted || ((i4 != 0 && i5 <= iArr2[i4 - 1]) || (i4 != i7 - 1 && i5 >= iArr2[i6]))) {
                z3 = false;
            }
            this.sorted = z3;
            return;
        }
        throw new IndexOutOfBoundsException("n > size()");
    }

    public IntList mutableCopy() {
        int i4 = this.size;
        IntList intList = new IntList(i4);
        for (int i5 = 0; i5 < i4; i5++) {
            intList.add(this.values[i5]);
        }
        return intList;
    }

    public int pop() {
        throwIfImmutable();
        this.size--;
        return get(this.size - 1);
    }

    public void removeIndex(int i4) {
        int i5;
        if (i4 < this.size) {
            int[] iArr = this.values;
            System.arraycopy(iArr, i4 + 1, iArr, i4, (i5 - i4) - 1);
            this.size--;
            return;
        }
        throw new IndexOutOfBoundsException("n >= size()");
    }

    public void set(int i4, int i5) {
        throwIfImmutable();
        if (i4 < this.size) {
            try {
                this.values[i4] = i5;
                this.sorted = false;
                return;
            } catch (ArrayIndexOutOfBoundsException unused) {
                if (i4 >= 0) {
                    return;
                }
                throw new IllegalArgumentException("n < 0");
            }
        }
        throw new IndexOutOfBoundsException("n >= size()");
    }

    public void shrink(int i4) {
        if (i4 >= 0) {
            if (i4 <= this.size) {
                throwIfImmutable();
                this.size = i4;
                return;
            }
            throw new IllegalArgumentException("newSize > size");
        }
        throw new IllegalArgumentException("newSize < 0");
    }

    public int size() {
        return this.size;
    }

    public void sort() {
        throwIfImmutable();
        if (!this.sorted) {
            Arrays.sort(this.values, 0, this.size);
            this.sorted = true;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer((this.size * 5) + 10);
        stringBuffer.append('{');
        for (int i4 = 0; i4 < this.size; i4++) {
            if (i4 != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(this.values[i4]);
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public int top() {
        return get(this.size - 1);
    }

    public IntList(int i4) {
        super(true);
        try {
            this.values = new int[i4];
            this.size = 0;
            this.sorted = true;
        } catch (NegativeArraySizeException unused) {
            throw new IllegalArgumentException("size < 0");
        }
    }

    public static IntList makeImmutable(int i4, int i5) {
        IntList intList = new IntList(2);
        intList.add(i4);
        intList.add(i5);
        intList.setImmutable();
        return intList;
    }

    public void pop(int i4) {
        throwIfImmutable();
        this.size -= i4;
    }
}
