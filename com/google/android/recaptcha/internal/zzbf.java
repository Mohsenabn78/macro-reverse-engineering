package com.google.android.recaptcha.internal;

import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzbf implements zzbi {
    @NotNull
    private final zzdo zza;

    public zzbf() {
        this(1);
    }

    @NotNull
    public final List zwk() {
        return zza();
    }

    @NotNull
    public final List zza() {
        List list;
        list = CollectionsKt___CollectionsKt.toList(this.zza);
        return list;
    }

    public final boolean zzb(@NotNull List list) {
        this.zza.add(list);
        return true;
    }

    public zzbf(int i4) {
        this.zza = zzdo.zza(i4);
    }
}
