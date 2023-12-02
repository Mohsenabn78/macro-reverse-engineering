package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzux implements zzxj {
    public long zza;
    public long zzb;
    @Nullable
    public zzxi zzc;
    @Nullable
    public zzux zzd;

    public zzux(long j4, int i4) {
        zze(j4, 65536);
    }

    public final int zza(long j4) {
        long j5 = j4 - this.zza;
        int i4 = this.zzc.zzb;
        return (int) j5;
    }

    public final zzux zzb() {
        this.zzc = null;
        zzux zzuxVar = this.zzd;
        this.zzd = null;
        return zzuxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final zzxi zzc() {
        zzxi zzxiVar = this.zzc;
        zzxiVar.getClass();
        return zzxiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    @Nullable
    public final zzxj zzd() {
        zzux zzuxVar = this.zzd;
        if (zzuxVar != null && zzuxVar.zzc != null) {
            return zzuxVar;
        }
        return null;
    }

    public final void zze(long j4, int i4) {
        boolean z3;
        if (this.zzc == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzf(z3);
        this.zza = j4;
        this.zzb = j4 + PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
    }
}
