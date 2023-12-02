package com.pollfish.internal;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class z2 {
    @NotNull
    public static int a(@NotNull String str) {
        int[] _values;
        for (int i4 : a3._values()) {
            if (Intrinsics.areEqual(a3.a(i4), str)) {
                return i4;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }
}
