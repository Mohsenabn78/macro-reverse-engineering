package com.google.android.gms.internal.nearby;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzqj {
    private final zzql zza = new zzql(null);

    public final zzqj zza(zzox zzoxVar) {
        this.zza.zzc = zzoxVar;
        return this;
    }

    public final zzqj zzb(zzqb zzqbVar) {
        this.zza.zzb = zzqbVar;
        return this;
    }

    public final zzqj zzc(@Nullable zzpa zzpaVar) {
        this.zza.zza = zzpaVar;
        return this;
    }

    public final zzql zzd() {
        return this.zza;
    }
}
