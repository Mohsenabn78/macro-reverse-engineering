package com.arlosoft.macrodroid.extensions;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: MutableListExtensions.kt */
/* loaded from: classes3.dex */
public final class MutableListExtensionsKt {
    public static final void swap(@NotNull List<Integer> list, int i4, int i5) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        int intValue = list.get(i4).intValue();
        list.set(i4, list.get(i5));
        list.set(i5, Integer.valueOf(intValue));
    }
}
