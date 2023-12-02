package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcrs {
    private final zzezz zza;
    private final zzezn zzb;
    private final String zzc;

    public zzcrs(zzezz zzezzVar, zzezn zzeznVar, @Nullable String str) {
        this.zza = zzezzVar;
        this.zzb = zzeznVar;
        this.zzc = str == null ? "com.google.ads.mediation.admob.AdMobAdapter" : str;
    }

    public final zzezn zza() {
        return this.zzb;
    }

    public final zzezq zzb() {
        return this.zza.zzb.zzb;
    }

    public final zzezz zzc() {
        return this.zza;
    }

    public final String zzd() {
        return this.zzc;
    }
}
