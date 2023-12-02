package com.koushikdutta.async.http.spdy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* loaded from: classes6.dex */
interface BitArray {

    /* loaded from: classes6.dex */
    public static final class FixedCapacity implements BitArray {

        /* renamed from: a  reason: collision with root package name */
        long f35477a = 0;

        private static int a(int i4) {
            if (i4 >= 0 && i4 <= 63) {
                return i4;
            }
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "input must be between 0 and 63: %s", Integer.valueOf(i4)));
        }

        @Override // com.koushikdutta.async.http.spdy.BitArray
        public void clear() {
            this.f35477a = 0L;
        }

        @Override // com.koushikdutta.async.http.spdy.BitArray
        public boolean get(int i4) {
            if (((this.f35477a >> a(i4)) & 1) == 1) {
                return true;
            }
            return false;
        }

        @Override // com.koushikdutta.async.http.spdy.BitArray
        public void set(int i4) {
            this.f35477a |= 1 << a(i4);
        }

        @Override // com.koushikdutta.async.http.spdy.BitArray
        public void shiftLeft(int i4) {
            this.f35477a <<= a(i4);
        }

        public String toString() {
            return Long.toBinaryString(this.f35477a);
        }

        public BitArray toVariableCapacity() {
            return new VariableCapacity(this);
        }

        @Override // com.koushikdutta.async.http.spdy.BitArray
        public void toggle(int i4) {
            this.f35477a ^= 1 << a(i4);
        }
    }

    /* loaded from: classes6.dex */
    public static final class VariableCapacity implements BitArray {

        /* renamed from: a  reason: collision with root package name */
        long[] f35478a;

        /* renamed from: b  reason: collision with root package name */
        private int f35479b;

        private static int a(int i4) {
            if (i4 >= 0) {
                return i4;
            }
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "input must be a positive number: %s", Integer.valueOf(i4)));
        }

        private void b(int i4) {
            long[] jArr = new long[i4];
            long[] jArr2 = this.f35478a;
            if (jArr2 != null) {
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            }
            this.f35478a = jArr;
        }

        private int c(int i4) {
            int i5 = (i4 + this.f35479b) / 64;
            if (i5 > this.f35478a.length - 1) {
                b(i5 + 1);
            }
            return i5;
        }

        private int d(int i4) {
            return (i4 + this.f35479b) % 64;
        }

        @Override // com.koushikdutta.async.http.spdy.BitArray
        public void clear() {
            Arrays.fill(this.f35478a, 0L);
        }

        List<Integer> e() {
            ArrayList arrayList = new ArrayList();
            int length = (this.f35478a.length * 64) - this.f35479b;
            for (int i4 = 0; i4 < length; i4++) {
                if (get(i4)) {
                    arrayList.add(Integer.valueOf(i4));
                }
            }
            return arrayList;
        }

        @Override // com.koushikdutta.async.http.spdy.BitArray
        public boolean get(int i4) {
            a(i4);
            if ((this.f35478a[c(i4)] & (1 << d(i4))) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.koushikdutta.async.http.spdy.BitArray
        public void set(int i4) {
            a(i4);
            int c4 = c(i4);
            long[] jArr = this.f35478a;
            jArr[c4] = jArr[c4] | (1 << d(i4));
        }

        @Override // com.koushikdutta.async.http.spdy.BitArray
        public void shiftLeft(int i4) {
            int a4 = this.f35479b - a(i4);
            this.f35479b = a4;
            if (a4 < 0) {
                int i5 = (a4 / (-64)) + 1;
                long[] jArr = this.f35478a;
                long[] jArr2 = new long[jArr.length + i5];
                System.arraycopy(jArr, 0, jArr2, i5, jArr.length);
                this.f35478a = jArr2;
                this.f35479b = (this.f35479b % 64) + 64;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            List<Integer> e4 = e();
            int size = e4.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (i4 > 0) {
                    sb.append(',');
                }
                sb.append(e4.get(i4));
            }
            sb.append('}');
            return sb.toString();
        }

        @Override // com.koushikdutta.async.http.spdy.BitArray
        public void toggle(int i4) {
            a(i4);
            int c4 = c(i4);
            long[] jArr = this.f35478a;
            jArr[c4] = jArr[c4] ^ (1 << d(i4));
        }

        public VariableCapacity() {
            this.f35478a = new long[1];
        }

        private VariableCapacity(FixedCapacity fixedCapacity) {
            this.f35478a = new long[]{fixedCapacity.f35477a, 0};
        }
    }

    void clear();

    boolean get(int i4);

    void set(int i4);

    void shiftLeft(int i4);

    void toggle(int i4);
}
