package com.google.android.recaptcha.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzg {
    private zzg() {
    }

    public /* synthetic */ zzg(DefaultConstructorMarker defaultConstructorMarker) {
    }

    @NotNull
    public static final zzh zza(@NotNull zzmf zzmfVar) {
        zzh zzhVar = (zzh) zzh.zzd().get(zzmfVar);
        if (zzhVar == null) {
            return new zzh(zzf.zzb, zzd.zzb);
        }
        return zzhVar;
    }
}
