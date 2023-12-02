package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcqv {
    private final zzcxv zza;
    @Nullable
    private final zzdac zzb;

    public zzcqv(zzcxv zzcxvVar, @Nullable zzdac zzdacVar) {
        this.zza = zzcxvVar;
        this.zzb = zzdacVar;
    }

    public final zzcxv zza() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final zzdac zzb() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzdcm zzc() {
        zzdac zzdacVar = this.zzb;
        if (zzdacVar != null) {
            return new zzdcm(zzdacVar, zzcae.zzf);
        }
        return new zzdcm(new zzcqu(this), zzcae.zzf);
    }
}
