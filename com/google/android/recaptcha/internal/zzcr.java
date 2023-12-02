package com.google.android.recaptcha.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzcr {
    @NotNull
    public static final zzcr zza = new zzcr();
    @NotNull
    private static List zzb;

    static {
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        zzb = emptyList;
    }

    private zzcr() {
    }

    @JvmStatic
    public static final void acx(@NotNull int[] iArr) {
        zzb(iArr);
    }

    @JvmStatic
    public static final int zza(@NotNull int[] iArr) {
        List list;
        List plus;
        List list2 = zzb;
        list = ArraysKt___ArraysKt.toList(iArr);
        plus = CollectionsKt___CollectionsKt.plus((Collection) list2, (Iterable) list);
        Iterator it = plus.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            while (it.hasNext()) {
                next = Integer.valueOf(((Number) next).intValue() ^ ((Number) it.next()).intValue());
            }
            return ((Number) next).intValue();
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    public static final void zzb(@NotNull int[] iArr) {
        List list;
        list = ArraysKt___ArraysKt.toList(iArr);
        zzb = list;
    }
}
