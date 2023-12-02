package com.google.common.hash;

import com.google.common.hash.Striped64;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
final class LongAdder extends Striped64 implements Serializable, LongAddable {
    private static final long serialVersionUID = 7249069246863182397L;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f27910c = 0;
        this.f27908a = null;
        this.f27909b = objectInputStream.readLong();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(sum());
    }

    @Override // com.google.common.hash.LongAddable
    public void a() {
        add(1L);
    }

    @Override // com.google.common.hash.LongAddable
    public void add(long j4) {
        int length;
        Striped64.Cell cell;
        Striped64.Cell[] cellArr = this.f27908a;
        if (cellArr == null) {
            long j5 = this.f27909b;
            if (c(j5, j5 + j4)) {
                return;
            }
        }
        int[] iArr = Striped64.f27902d.get();
        boolean z3 = true;
        if (iArr != null && cellArr != null && (length = cellArr.length) >= 1 && (cell = cellArr[(length - 1) & iArr[0]]) != null) {
            long j6 = cell.f27913a;
            z3 = cell.a(j6, j6 + j4);
            if (z3) {
                return;
            }
        }
        h(j4, iArr, z3);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return sum();
    }

    @Override // com.google.common.hash.Striped64
    final long f(long j4, long j5) {
        return j4 + j5;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) sum();
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) sum();
    }

    @Override // java.lang.Number
    public long longValue() {
        return sum();
    }

    @Override // com.google.common.hash.LongAddable
    public long sum() {
        long j4 = this.f27909b;
        Striped64.Cell[] cellArr = this.f27908a;
        if (cellArr != null) {
            for (Striped64.Cell cell : cellArr) {
                if (cell != null) {
                    j4 += cell.f27913a;
                }
            }
        }
        return j4;
    }

    public String toString() {
        return Long.toString(sum());
    }
}
