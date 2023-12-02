package com.google.android.gms.internal.nearby;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzfh {
    private final zzfj zza = new zzfj(null);

    public final zzfh zza(@Nullable zzjt zzjtVar) {
        this.zza.zzb = zzjtVar;
        return this;
    }

    public final zzfh zzb(@Nullable byte[] bArr) {
        this.zza.zzd = bArr;
        return this;
    }

    public final zzfh zzc(@Nullable zzkh zzkhVar) {
        this.zza.zze = zzkhVar;
        return this;
    }

    public final zzfh zzd(String str) {
        this.zza.zzc = str;
        return this;
    }

    public final zzfh zze(@Nullable zzkk zzkkVar) {
        this.zza.zza = zzkkVar;
        return this;
    }

    public final zzfj zzf() {
        return this.zza;
    }
}
