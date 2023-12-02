package com.pollfish.internal;

import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class o1 {
    @NotNull
    public static int a(int i4) {
        boolean z3;
        int[] b4 = v0.b(2);
        int length = b4.length;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                break;
            }
            int i7 = b4[i6];
            if (p1.a(i7) == i4) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                i5 = i7;
                break;
            }
            i6++;
        }
        if (i5 == 0) {
            return 1;
        }
        return i5;
    }
}
