package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzt extends Exception {
    @Nullable
    private final Throwable zza;
    @NotNull
    private final zzmi zzb;
    @NotNull
    private final int zzc;
    @NotNull
    private final int zzd;

    public zzt(@NotNull int i4, @NotNull int i5, @Nullable Throwable th) {
        this.zzc = i4;
        this.zzd = i5;
        this.zza = th;
        zzmi zzf = zzmj.zzf();
        zzf.zze(i5);
        zzf.zzp(i4);
        this.zzb = zzf;
    }

    @Override // java.lang.Throwable
    @Nullable
    public final Throwable getCause() {
        return this.zza;
    }

    @NotNull
    public final zzmi zza() {
        return this.zzb;
    }
}
