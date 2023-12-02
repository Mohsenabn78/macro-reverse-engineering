package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
final class Hashing {
    private Hashing() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i4, double d4) {
        int max = Math.max(i4, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max > ((int) (d4 * highestOneBit))) {
            int i5 = highestOneBit << 1;
            if (i5 <= 0) {
                return 1073741824;
            }
            return i5;
        }
        return highestOneBit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(int i4, int i5, double d4) {
        if (i4 > d4 * i5 && i5 < 1073741824) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i4) {
        return (int) (Integer.rotateLeft((int) (i4 * (-862048943)), 15) * 461845907);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(@CheckForNull Object obj) {
        int hashCode;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        return c(hashCode);
    }
}
