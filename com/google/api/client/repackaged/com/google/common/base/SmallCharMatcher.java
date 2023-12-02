package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtIncompatible;
import com.google.api.client.repackaged.com.google.common.annotations.VisibleForTesting;
import com.google.api.client.repackaged.com.google.common.base.CharMatcher;
import java.util.BitSet;

@GwtIncompatible("no precomputation is done in GWT")
/* loaded from: classes5.dex */
final class SmallCharMatcher extends CharMatcher.FastMatcher {

    /* renamed from: d  reason: collision with root package name */
    private final char[] f25967d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f25968e;

    /* renamed from: f  reason: collision with root package name */
    private final long f25969f;

    private SmallCharMatcher(char[] cArr, long j4, boolean z3, String str) {
        super(str);
        this.f25967d = cArr;
        this.f25969f = j4;
        this.f25968e = z3;
    }

    private boolean j(int i4) {
        if (1 == ((this.f25969f >> i4) & 1)) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    static int k(int i4) {
        if (i4 == 1) {
            return 2;
        }
        int highestOneBit = Integer.highestOneBit(i4 - 1) << 1;
        while (highestOneBit * 0.5d < i4) {
            highestOneBit <<= 1;
        }
        return highestOneBit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CharMatcher l(BitSet bitSet, String str) {
        int i4;
        int cardinality = bitSet.cardinality();
        boolean z3 = bitSet.get(0);
        int k4 = k(cardinality);
        char[] cArr = new char[k4];
        int i5 = k4 - 1;
        int nextSetBit = bitSet.nextSetBit(0);
        long j4 = 0;
        while (nextSetBit != -1) {
            long j5 = (1 << nextSetBit) | j4;
            int m4 = m(nextSetBit);
            while (true) {
                i4 = m4 & i5;
                if (cArr[i4] == 0) {
                    break;
                }
                m4 = i4 + 1;
            }
            cArr[i4] = (char) nextSetBit;
            nextSetBit = bitSet.nextSetBit(nextSetBit + 1);
            j4 = j5;
        }
        return new SmallCharMatcher(cArr, j4, z3, str);
    }

    static int m(int i4) {
        return Integer.rotateLeft(i4 * (-862048943), 15) * 461845907;
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
    void g(BitSet bitSet) {
        char[] cArr;
        if (this.f25968e) {
            bitSet.set(0);
        }
        for (char c4 : this.f25967d) {
            if (c4 != 0) {
                bitSet.set(c4);
            }
        }
    }

    @Override // com.google.api.client.repackaged.com.google.common.base.CharMatcher
    public boolean matches(char c4) {
        if (c4 == 0) {
            return this.f25968e;
        }
        if (!j(c4)) {
            return false;
        }
        int length = this.f25967d.length - 1;
        int m4 = m(c4) & length;
        int i4 = m4;
        do {
            char c5 = this.f25967d[i4];
            if (c5 == 0) {
                return false;
            }
            if (c5 == c4) {
                return true;
            }
            i4 = (i4 + 1) & length;
        } while (i4 != m4);
        return false;
    }
}
