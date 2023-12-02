package com.google.android.recaptcha.internal;

import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzar {
    @NotNull
    public static final zzar zza = new zzar();

    private zzar() {
    }

    @NotNull
    public static final zzlg zza(@NotNull zzn zznVar, @NotNull zzn zznVar2) {
        zzlf zzf = zzlg.zzf();
        zzf.zzp(zzka.zzb(zznVar.zzb()));
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        zzf.zzq(zzjy.zzb(zznVar.zza(timeUnit)));
        zzf.zzd(zzka.zzb(zznVar2.zzb()));
        zzf.zze(zzjy.zzb(zznVar2.zza(timeUnit)));
        return (zzlg) zzf.zzj();
    }
}
