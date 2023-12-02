package com.google.android.gms.internal.nearby;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.connection.AdvertisingOptions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzmr {
    private final zzmt zza = new zzmt(null);

    public final zzmr zza(@Nullable zzjq zzjqVar) {
        this.zza.zzb = zzjqVar;
        return this;
    }

    public final zzmr zzb(@Nullable zzjw zzjwVar) {
        this.zza.zzg = zzjwVar;
        return this;
    }

    public final zzmr zzc(long j4) {
        this.zza.zze = j4;
        return this;
    }

    public final zzmr zzd(@Nullable byte[] bArr) {
        this.zza.zzh = bArr;
        return this;
    }

    public final zzmr zze(@Nullable String str) {
        this.zza.zzc = str;
        return this;
    }

    public final zzmr zzf(AdvertisingOptions advertisingOptions) {
        this.zza.zzf = advertisingOptions;
        return this;
    }

    public final zzmr zzg(@Nullable zzkn zzknVar) {
        this.zza.zza = zzknVar;
        return this;
    }

    public final zzmr zzh(String str) {
        this.zza.zzd = str;
        return this;
    }

    public final zzmt zzi() {
        return this.zza;
    }
}
