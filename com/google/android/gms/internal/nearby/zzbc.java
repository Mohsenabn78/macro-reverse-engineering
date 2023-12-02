package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzbc {
    private final zzbe zza = new zzbe(null);

    public final zzbc zza(DailySummariesConfig dailySummariesConfig) {
        this.zza.zzb = dailySummariesConfig;
        return this;
    }

    public final zzbc zzb(zzcs zzcsVar) {
        this.zza.zza = zzcsVar;
        return this;
    }

    public final zzbe zzc() {
        return this.zza;
    }
}
