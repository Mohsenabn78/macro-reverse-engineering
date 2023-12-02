package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzvj extends zzcw {
    private static final Object zzc = new Object();
    private static final zzbp zzd;
    private final long zze;
    private final long zzf;
    private final boolean zzg;
    @Nullable
    private final zzbp zzh;
    @Nullable
    private final zzbf zzi;

    static {
        zzar zzarVar = new zzar();
        zzarVar.zza("SinglePeriodTimeline");
        zzarVar.zzb(Uri.EMPTY);
        zzd = zzarVar.zzc();
    }

    public zzvj(long j4, long j5, long j6, long j7, long j8, long j9, long j10, boolean z3, boolean z4, boolean z5, @Nullable Object obj, zzbp zzbpVar, @Nullable zzbf zzbfVar) {
        this.zze = j7;
        this.zzf = j8;
        this.zzg = z3;
        this.zzh = zzbpVar;
        this.zzi = zzbfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    public final int zza(Object obj) {
        if (zzc.equals(obj)) {
            return 0;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    public final int zzb() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    public final int zzc() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    public final zzct zzd(int i4, zzct zzctVar, boolean z3) {
        Object obj;
        zzdy.zza(i4, 0, 1);
        if (z3) {
            obj = zzc;
        } else {
            obj = null;
        }
        zzctVar.zzl(null, obj, 0, this.zze, 0L, zzd.zza, false);
        return zzctVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    public final zzcv zze(int i4, zzcv zzcvVar, long j4) {
        zzdy.zza(i4, 0, 1);
        zzcvVar.zza(zzcv.zza, this.zzh, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, this.zzg, false, this.zzi, 0L, this.zzf, 0, 0, 0L);
        return zzcvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    public final Object zzf(int i4) {
        zzdy.zza(i4, 0, 1);
        return zzc;
    }
}
