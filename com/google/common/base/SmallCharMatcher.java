package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.CharMatcher;
import java.util.BitSet;

@J2ktIncompatible
@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
final class SmallCharMatcher extends CharMatcher.NamedFastMatcher {

    /* renamed from: b  reason: collision with root package name */
    private final char[] f26358b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f26359c;

    /* renamed from: d  reason: collision with root package name */
    private final long f26360d;

    private SmallCharMatcher(char[] cArr, long j4, boolean z3, String str) {
        super(str);
        this.f26358b = cArr;
        this.f26360d = j4;
        this.f26359c = z3;
    }

    private boolean i(int i4) {
        if (1 == ((this.f26360d >> i4) & 1)) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    static int j(int i4) {
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
    public static CharMatcher k(BitSet bitSet, String str) {
        int i4;
        int cardinality = bitSet.cardinality();
        boolean z3 = bitSet.get(0);
        int j4 = j(cardinality);
        char[] cArr = new char[j4];
        int i5 = j4 - 1;
        int nextSetBit = bitSet.nextSetBit(0);
        long j5 = 0;
        while (nextSetBit != -1) {
            long j6 = (1 << nextSetBit) | j5;
            int l4 = l(nextSetBit);
            while (true) {
                i4 = l4 & i5;
                if (cArr[i4] == 0) {
                    break;
                }
                l4 = i4 + 1;
            }
            cArr[i4] = (char) nextSetBit;
            nextSetBit = bitSet.nextSetBit(nextSetBit + 1);
            j5 = j6;
        }
        return new SmallCharMatcher(cArr, j5, z3, str);
    }

    static int l(int i4) {
        return Integer.rotateLeft(i4 * (-862048943), 15) * 461845907;
    }

    @Override // com.google.common.base.CharMatcher
    void g(BitSet bitSet) {
        char[] cArr;
        if (this.f26359c) {
            bitSet.set(0);
        }
        for (char c4 : this.f26358b) {
            if (c4 != 0) {
                bitSet.set(c4);
            }
        }
    }

    @Override // com.google.common.base.CharMatcher
    public boolean matches(char c4) {
        if (c4 == 0) {
            return this.f26359c;
        }
        if (!i(c4)) {
            return false;
        }
        int length = this.f26358b.length - 1;
        int l4 = l(c4) & length;
        int i4 = l4;
        do {
            char c5 = this.f26358b[i4];
            if (c5 == 0) {
                return false;
            }
            if (c5 == c4) {
                return true;
            }
            i4 = (i4 + 1) & length;
        } while (i4 != l4);
        return false;
    }
}
