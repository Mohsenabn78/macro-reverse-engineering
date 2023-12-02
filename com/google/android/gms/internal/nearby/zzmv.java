package com.google.android.gms.internal.nearby;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.connection.DiscoveryOptions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzmv {
    private final zzmx zza = new zzmx(null);

    public final zzmv zza(@Nullable zzkd zzkdVar) {
        this.zza.zze = zzkdVar;
        return this;
    }

    public final zzmv zzb(long j4) {
        this.zza.zzc = j4;
        return this;
    }

    public final zzmv zzc(DiscoveryOptions discoveryOptions) {
        this.zza.zzd = discoveryOptions;
        return this;
    }

    public final zzmv zzd(@Nullable zzkk zzkkVar) {
        this.zza.zza = zzkkVar;
        return this;
    }

    public final zzmv zze(String str) {
        this.zza.zzb = str;
        return this;
    }

    public final zzmx zzf() {
        return this.zza;
    }
}
