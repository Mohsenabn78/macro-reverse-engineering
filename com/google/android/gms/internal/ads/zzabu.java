package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzabu implements zzabv {
    private final long zza;
    private final zzabt zzb;

    public zzabu(long j4, long j5) {
        zzabw zzabwVar;
        this.zza = j4;
        if (j5 == 0) {
            zzabwVar = zzabw.zza;
        } else {
            zzabwVar = new zzabw(0L, j5);
        }
        this.zzb = new zzabt(zzabwVar, zzabwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final long zze() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final zzabt zzg(long j4) {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final boolean zzh() {
        return false;
    }
}
